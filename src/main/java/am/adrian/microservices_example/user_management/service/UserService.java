package am.adrian.microservices_example.user_management.service;

import java.util.function.Supplier;

import am.adrian.microservices_example.user_management.dto.projection.UserProjection;
import am.adrian.microservices_example.user_management.dto.request.UserRequest;
import am.adrian.microservices_example.user_management.entity.User;
import am.adrian.microservices_example.user_management.mapper.UserMapper;
import am.adrian.microservices_example.user_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public Page<UserProjection> findAll(Pageable pageable) {
        Page<UserProjection> page = userRepository.findAll((root, query, criteriaBuilder) ->
                query.getRestriction(),
            UserProjection.class, pageable);
        LOGGER.info("Returning Page of element count: {{}}, page size: {{}}, page: {{}}. Total elements: {{}}",
            page.getNumberOfElements(), page.getSize(), pageable.getPageNumber(), page.getTotalElements());
        return page;
    }

    @Transactional
    public void create(UserRequest userRequest) {
        User user = userMapper.mapToUser(userRequest);
        userRepository.save(user);
        LOGGER.info("Created new user: {{}}", user.toString());
    }

    @Transactional
    public void update(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId())
            .orElseThrow(userNotFound(userRequest.getId()));
        userMapper.mapToUser(userRequest, user);
        userRepository.save(user);
        LOGGER.info("Updated user to: {{}}", user.toString());
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(userNotFound(id));
        userRepository.delete(user);
        LOGGER.info("Deleted user with id: {{}}", id);
    }

    private static Supplier<RuntimeException> userNotFound(Long id) {
        return () -> {
            LOGGER.info("User with id: {{}} not found", id);
            return new RuntimeException("User not found");
        };
    }
}
