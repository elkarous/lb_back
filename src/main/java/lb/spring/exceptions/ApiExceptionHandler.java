package lb.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiResponseException.class})
    public ResponseEntity<Object> handleResponseException(ApiResponseException e) {
        return new ResponseEntity<>(new ApiError(
                e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE,
                ZonedDateTime.now(ZoneId.of("Z"))),HttpStatus.NOT_ACCEPTABLE);

    }

}
