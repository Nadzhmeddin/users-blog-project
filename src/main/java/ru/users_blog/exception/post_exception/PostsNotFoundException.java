package ru.users_blog.exception.post_exception;

public class PostsNotFoundException extends RuntimeException {

    public PostsNotFoundException(String message) {
        super(message);
    }
}
