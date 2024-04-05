package org.example.GlobalExceptionHandlerLayer;

import org.example.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotValidException.class)
    public ResponseEntity<String> handleUserNotValidException(UserNotValidException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    public ResponseEntity<String> handleBookNotAvailableException(BookNotAvailableException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoBooksException.class)
    public ResponseEntity<String> handleNoBooksException(NoBooksException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage()+"", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidEmailAddressException.class)
    public ResponseEntity<String> handleInvalidEmailAddressException(InvalidEmailAddressException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage()+"", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage()+"", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage()+"", HttpStatus.NOT_FOUND);
    }

}
