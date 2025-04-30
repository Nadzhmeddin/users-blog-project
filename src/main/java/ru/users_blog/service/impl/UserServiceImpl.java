package ru.users_blog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.UserDto;
import ru.users_blog.entity.User;
import ru.users_blog.exception.user_exception.EmailNullPointerException;
import ru.users_blog.exception.user_exception.NameNullPointerException;
import ru.users_blog.exception.user_exception.UserNotFoundException;
import ru.users_blog.exception.user_exception.UsersNotFoundException;
import ru.users_blog.mapper.UserMapper;
import ru.users_blog.repository.UserRepository;
import ru.users_blog.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<User> allUsers = repository.findAll();
        if(allUsers.isEmpty()) {
            throw new UsersNotFoundException("There are no registered users");
        }
        return mapper.toDtoList(allUsers);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> foundUser = repository.findById(id);
        if(foundUser.isEmpty()) {
            throw new UserNotFoundException("Requested User does not exist");
        }
        return Optional.of(mapper.toDto(foundUser.get()));
    }

    @Override
    public UserDto save(UserDto user) {
        if(user.getEmail().isEmpty()) {
            throw new EmailNullPointerException("The email field cannot be empty");
        }
        if(user.getName().isEmpty()) {
            throw new NameNullPointerException("The name field cannot be empty");
        }
        User savedUser = repository.save(mapper.toEntity(user));
        return mapper.toDto(savedUser);
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> deletedUser = repository.findById(id);
        if(deletedUser.isEmpty()) {
            throw new UserNotFoundException("Requested User does not exist");
        }
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
