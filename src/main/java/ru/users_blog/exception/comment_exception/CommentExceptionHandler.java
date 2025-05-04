package ru.users_blog.exception.comment_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CommentExceptionHandler {

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<CommentException> commentNotFoundExceptionHandler(CommentNotFoundException exception) {
        CommentException commentException = new CommentException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(commentException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CommentsNotFoundException.class)
    public ResponseEntity<CommentException> commentsNotFoundExceptionHandler(CommentsNotFoundException exception) {
        CommentException commentException = new CommentException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(commentException, HttpStatus.NOT_FOUND);
    }
}
