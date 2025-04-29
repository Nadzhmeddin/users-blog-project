package ru.users_blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public record UserException(String message, Throwable throwable, HttpStatus httpStatus) {
}
