package ru.users_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.users_blog.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
