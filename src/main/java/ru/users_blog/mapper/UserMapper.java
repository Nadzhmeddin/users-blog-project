package ru.users_blog.mapper;

import org.springframework.stereotype.Service;
import ru.users_blog.dto.UserDto;
import ru.users_blog.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public List<UserDto> toDtoList(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>(users.size());
        for (User user : users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }
}
