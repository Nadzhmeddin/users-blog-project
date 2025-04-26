package ru.users_blog.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.PostDto;
import ru.users_blog.entity.Post;
import ru.users_blog.entity.User;
import ru.users_blog.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostMapper {

    private final UserRepository userRepository;

    public Post toEntity(PostDto postDto) {
        Optional<User> foundUser = userRepository.findById(postDto.getUserId());
        if(foundUser.isPresent()) {
            Post post = new Post();
            post.setUser(foundUser.get());
            post.setDescription(postDto.getDescription());
            return post;
        }
        else throw new IllegalArgumentException("User with this ID not found!");
    }

    public PostDto toDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.setDescription(post.getDescription());
        return postDto;
    }

    public List<PostDto> toDtoList(List<Post> posts) {
        List<PostDto> postDtos = new ArrayList<>(posts.size());
        for (Post post : posts) {
            postDtos.add(toDto(post));
        }
        return postDtos;
    }
}
