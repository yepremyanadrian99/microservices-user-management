package am.adrian.microservices_example.user_management.exception_handler;

import am.adrian.microservices_example.user_management.exception_handler.response.FieldErrorResponse;
import am.adrian.microservices_example.user_management.utils.ErrorUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> generalExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<FieldErrorResponse> methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        FieldErrorResponse errorResponse = new FieldErrorResponse(ErrorUtils.extractFieldSubErrors(e));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errorResponse);
    }
}
