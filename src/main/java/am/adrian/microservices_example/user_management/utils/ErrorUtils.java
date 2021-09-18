package am.adrian.microservices_example.user_management.utils;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import am.adrian.microservices_example.user_management.exception_handler.response.FieldSubErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ErrorUtils {

    private static final String UNKNOWN_FIELD = "unknown";

    private ErrorUtils() {
    }

    public static Collection<FieldSubErrorResponse> extractFieldSubErrors(MethodArgumentNotValidException e) {
        return e.getAllErrors().stream()
            .map(ErrorUtils::extractFieldSubError)
            .collect(Collectors.toList());
    }

    private static FieldSubErrorResponse extractFieldSubError(ObjectError objectError) {
        return new FieldSubErrorResponse(
            getField(objectError),
            objectError.getDefaultMessage()
        );
    }

    private static String getField(ObjectError objectError) {
        return Optional.ofNullable(((DefaultMessageSourceResolvable) objectError))
            .map(DefaultMessageSourceResolvable::getArguments)
            .map(arguments -> (DefaultMessageSourceResolvable) arguments[0])
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .orElse(UNKNOWN_FIELD);
    }
}
