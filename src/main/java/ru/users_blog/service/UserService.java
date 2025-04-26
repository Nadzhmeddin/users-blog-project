package ru.users_blog.service;

import ru.users_blog.dto.UserDto;
import ru.users_blog.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(UserDto user);

    void deleteById(Long id);

    void deleteAll();
}
