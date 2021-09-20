package am.adrian.microservices_example.user_management.exception_handler.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FieldSubErrorResponse {

    private final String field;

    private final String message;
}
