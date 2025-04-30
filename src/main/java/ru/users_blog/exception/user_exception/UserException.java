package ru.users_blog.exception.user_exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;
}
