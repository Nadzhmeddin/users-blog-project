package ru.users_blog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.CommentDto;
import ru.users_blog.entity.Comment;
import ru.users_blog.mapper.CommentMapper;
import ru.users_blog.repository.CommentRepository;
import ru.users_blog.service.CommentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Override
    public List<CommentDto> findAll() {
        List<Comment> allComments = repository.findAll();
        if(allComments.isEmpty()) {
            throw new IllegalArgumentException("Comments not found");
        }
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public Optional<CommentDto> findById(Long id) {
        Optional<Comment> foundComment = repository.findById(id);
        if(foundComment.isEmpty()) {
            throw new IllegalArgumentException("Comment with that Id is not found");
        }
        return Optional.of(mapper.toDto(foundComment.get()));
    }

    @Override
    public CommentDto save(CommentDto comment) {
        Comment savedComment = repository.save(mapper.toEntity(comment));
        return mapper.toDto(savedComment);
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
