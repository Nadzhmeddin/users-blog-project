package ru.users_blog.mapper;

import org.springframework.stereotype.Service;
import ru.users_blog.dto.UserDto;
import ru.users_blog.entity.User;

@Service
public class UserMapper {

    User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
