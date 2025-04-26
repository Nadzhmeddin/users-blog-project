package ru.users_blog.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.CommentDto;
import ru.users_blog.entity.Comment;
import ru.users_blog.entity.Post;
import ru.users_blog.entity.User;
import ru.users_blog.repository.PostRepository;
import ru.users_blog.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentMapper {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Comment toEntity(CommentDto commentDto) {
        Optional<User> foundUser = userRepository.findById(commentDto.getUserId());
        Optional<Post> foundPost = postRepository.findById(commentDto.getPostId());
        if(foundUser.isEmpty()) {
            throw new IllegalArgumentException("User with that ID is not found");
        }
        if(foundPost.isEmpty()) {
            throw new IllegalArgumentException("Post with that ID is not found");
        }

        Comment comment = new Comment();
        comment.setDescription(commentDto.getDescription());
        comment.setUser(foundUser.get());
        comment.setPost(foundPost.get());
        return comment;
    }

    public CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setDescription(comment.getDescription());
        commentDto.setUserId(comment.getUser().getId());
        commentDto.setPostId(comment.getPost().getId());
        return commentDto;
    }

    public List<CommentDto> toDtoList(List<Comment> comments) {
        List<CommentDto> commentDtos = new ArrayList<>(comments.size());
        for (Comment comment : comments) {
            commentDtos.add(toDto(comment));
        }
        return commentDtos;
    }
}
