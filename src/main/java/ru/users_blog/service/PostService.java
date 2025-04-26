package ru.users_blog.service;

import ru.users_blog.dto.PostDto;
import ru.users_blog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostDto> findAll();

    Optional<PostDto> findById(Long id);

    PostDto save(PostDto post);

    void deleteById(Long id);

    void deleteAll();
}
