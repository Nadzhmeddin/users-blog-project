package ru.users_blog.exception.user_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserException> handleUserNotFoundException(UserNotFoundException exception) {
        UserException userException = new UserException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNullPointerException.class)
    public ResponseEntity<UserException> handleEmailNullPointerException(EmailNullPointerException exception) {
        UserException userException = new UserException(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsersNotFoundException.class)
    public ResponseEntity<UserException> handlerUsersNotFoundException(UsersNotFoundException exception) {
        UserException userException = new UserException(
          exception.getMessage(),
          HttpStatus.NOT_FOUND,
          LocalDateTime.now()
        );

        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NameNullPointerException.class)
    public ResponseEntity<UserException> handleNameNullPointerException(NameNullPointerException exception) {
        UserException userException = new UserException(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
    }
}
