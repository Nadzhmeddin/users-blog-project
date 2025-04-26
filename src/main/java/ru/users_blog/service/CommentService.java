package ru.users_blog.service;

import ru.users_blog.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> findAll();

    Optional<Comment> findById(Long id);

    Comment save(Comment comment);

    void deleteById(Long id);

    void deleteAll();
}
