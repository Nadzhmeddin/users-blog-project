package ru.users_blog.exception.comment_exception;

public class CommentsNotFoundException extends RuntimeException{
    public CommentsNotFoundException(String message) {
        super(message);
    }
}
