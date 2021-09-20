package am.adrian.microservices_example.user_management.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRequest {

    private final Long id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String surname;

    @NotBlank
    @Email
    private final String email;

    @NotNull
    private final LocalDate birthDate;
}
