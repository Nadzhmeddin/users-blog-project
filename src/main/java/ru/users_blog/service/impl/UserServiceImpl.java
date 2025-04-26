package ru.users_blog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users_blog.dto.UserDto;
import ru.users_blog.repository.UserRepository;
import ru.users_blog.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDto save(UserDto user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
