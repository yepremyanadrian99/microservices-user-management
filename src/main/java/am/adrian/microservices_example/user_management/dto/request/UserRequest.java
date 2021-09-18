package am.adrian.microservices_example.user_management.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserRequest(
    Long id,
    @NotBlank String name,
    @NotBlank String surname,
    @NotBlank @Email String email,
    @NotNull LocalDate birthDate) {
}
