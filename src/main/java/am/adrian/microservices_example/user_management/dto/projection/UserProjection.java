package am.adrian.microservices_example.user_management.dto.projection;

import java.time.LocalDate;

public interface UserProjection {

    String getName();

    String getSurname();

    String getEmail();

    LocalDate getBirthDate();
}