package ru.users_blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.users_blog.dto.CommentDto;
import ru.users_blog.mapper.CommentMapper;
import ru.users_blog.service.impl.CommentServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {
        List<CommentDto> allComments = service.findAll();
        if(allComments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else return ResponseEntity.status(HttpStatus.OK).body(allComments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommentDto>> findById(@PathVariable Long id) {
        Optional<CommentDto> foundComment = service.findById(id);
        if(foundComment.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(foundComment);
        } else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto commentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(commentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
