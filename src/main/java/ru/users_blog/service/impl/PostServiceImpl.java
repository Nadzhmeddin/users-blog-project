package ru.users_blog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.PostDto;
import ru.users_blog.repository.PostRepository;
import ru.users_blog.service.PostService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public List<PostDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<PostDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public PostDto save(PostDto post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
