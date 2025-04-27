package ru.users_blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.users_blog.dto.PostDto;
import ru.users_blog.service.impl.PostServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl service;

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<PostDto> allPosts = service.findAll();
        if(allPosts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else return ResponseEntity.status(HttpStatus.OK).body(allPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostDto>> findById(@PathVariable Long id) {
        Optional<PostDto> foundPost = service.findById(id);
        if(foundPost.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(foundPost);
        } else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<PostDto> save(@RequestBody PostDto postDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(postDto));
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
