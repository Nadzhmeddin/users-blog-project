package ru.users_blog.mapper;

import org.springframework.stereotype.Service;
import ru.users_blog.dto.PostDto;
import ru.users_blog.entity.Post;
import ru.users_blog.entity.User;
import ru.users_blog.repository.UserRepository;

import java.util.Optional;

@Service
public class PostMapper {

    private UserRepository userRepository;

    Post toEntity(PostDto postDto) {
        Optional<User> foundUser = userRepository.findById(postDto.getUserId());
        if(foundUser.isPresent()) {
            Post post = new Post();
            post.setUser(foundUser.get());
            post.setDescription(postDto.getDescription());
            return post;
        }
        else throw new IllegalArgumentException("User with this ID not found!");
    }

    PostDto toDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.setDescription(post.getDescription());
        return postDto;
    }
}
