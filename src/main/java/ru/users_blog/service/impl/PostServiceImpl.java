package ru.users_blog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.PostDto;
import ru.users_blog.entity.Post;
import ru.users_blog.mapper.PostMapper;
import ru.users_blog.repository.PostRepository;
import ru.users_blog.service.PostService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public List<PostDto> findAll() {
        List<Post> allPosts = repository.findAll();
        if(allPosts.isEmpty()) {
            throw new IllegalArgumentException("Posts not found!");
        }
        return mapper.toDtoList(allPosts);
    }

    @Override
    public Optional<PostDto> findById(Long id) {
        Optional<Post> foundPost = repository.findById(id);
        if(foundPost.isEmpty()) {
            throw new IllegalArgumentException("Post with that Id is not found!");
        }
        return Optional.of(mapper.toDto(foundPost.get()));
    }

    @Override
    public PostDto save(PostDto post) {
        Post savedPost = repository.save(mapper.toEntity(post));
        return mapper.toDto(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
