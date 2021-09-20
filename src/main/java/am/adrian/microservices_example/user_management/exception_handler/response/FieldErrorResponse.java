package am.adrian.microservices_example.user_management.exception_handler.response;

import java.util.Collection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FieldErrorResponse {

    private final Collection<FieldSubErrorResponse> fieldErrors;
}
