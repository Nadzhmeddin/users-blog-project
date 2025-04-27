package ru.users_blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.users_blog.dto.CommentDto;
import ru.users_blog.service.impl.CommentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {

    }
}
