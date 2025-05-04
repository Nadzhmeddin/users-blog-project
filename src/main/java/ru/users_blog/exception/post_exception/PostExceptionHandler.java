package ru.users_blog.exception.post_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<PostException> postNotFoundExceptionHandler(PostNotFoundException exception) {
        PostException postException = new PostException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(postException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostsNotFoundException.class)
    public ResponseEntity<PostException> postsNotFoundException(PostsNotFoundException exception) {
        PostException postException = new PostException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(postException, HttpStatus.NOT_FOUND);
    }
}
