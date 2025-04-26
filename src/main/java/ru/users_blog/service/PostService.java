package ru.users_blog.service;

import ru.users_blog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    Post save(Post post);

    void deleteById(Long id);

    void deleteAll();
}
