package bf.kvill.spring_phone_book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ApiError> handleContactNotFoundException(ContactNotFoundException e)
    {
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(ContactNotFoundException e)
    {
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
