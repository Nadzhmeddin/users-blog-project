package ru.users_blog.exception.user_exception;

public class UsersNotFoundException extends RuntimeException{

    public UsersNotFoundException(String message) {
        super(message);
    }
}
