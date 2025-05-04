package ru.users_blog.exception.post_exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;
}
