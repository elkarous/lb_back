package lb.spring.exceptions;

public class ApiResponseException  extends RuntimeException {
    public ApiResponseException(String message) {
        super(message);
    }

    public ApiResponseException(Throwable cause) {
        super(cause);
    }
}
