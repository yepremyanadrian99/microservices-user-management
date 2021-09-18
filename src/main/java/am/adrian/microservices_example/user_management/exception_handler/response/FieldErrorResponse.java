package am.adrian.microservices_example.user_management.exception_handler.response;

import java.util.Collection;

public record FieldErrorResponse(Collection<FieldSubErrorResponse> fieldErrors) {
}
