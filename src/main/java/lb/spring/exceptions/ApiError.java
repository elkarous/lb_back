package lb.spring.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiError {
    private final String message;
    private final HttpStatus httpStatus ;
    private final ZonedDateTime zonedDateTime;
    public String getMessage() {
        return message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public java.time.ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public ApiError(String message, HttpStatus httpStatus, java.time.ZonedDateTime zonedDateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
}
