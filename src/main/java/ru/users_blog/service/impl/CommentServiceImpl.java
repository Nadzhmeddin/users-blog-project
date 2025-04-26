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
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public Optional<CommentDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CommentDto save(CommentDto comment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
