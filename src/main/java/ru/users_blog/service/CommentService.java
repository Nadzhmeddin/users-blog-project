package ru.users_blog.service;

import ru.users_blog.dto.CommentDto;
import ru.users_blog.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<CommentDto> findAll();

    Optional<CommentDto> findById(Long id);

    CommentDto save(CommentDto comment);

    void deleteById(Long id);

    void deleteAll();
}
