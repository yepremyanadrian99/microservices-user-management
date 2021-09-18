package am.adrian.microservices_example.user_management.mapper;

import am.adrian.microservices_example.user_management.dto.request.UserRequest;
import am.adrian.microservices_example.user_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.control.DeepClone;

@Mapper(mappingControl = DeepClone.class, componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserRequest userRequest);

    void mapToUser(UserRequest source, @MappingTarget User destination);
}
