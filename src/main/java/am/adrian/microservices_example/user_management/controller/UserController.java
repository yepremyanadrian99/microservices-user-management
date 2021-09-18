package am.adrian.microservices_example.user_management.controller;

import javax.validation.Valid;

import am.adrian.microservices_example.user_management.dto.projection.UserProjection;
import am.adrian.microservices_example.user_management.dto.request.UserRequest;
import am.adrian.microservices_example.user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public Page<UserProjection> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @PostMapping("/create")
    public void create(@RequestBody @Validated @Valid UserRequest userRequest) {
        userService.create(userRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody @Validated @Valid UserRequest userRequest) {
        userService.update(userRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void update(@PathVariable Long id) {
        userService.delete(id);
    }
}
