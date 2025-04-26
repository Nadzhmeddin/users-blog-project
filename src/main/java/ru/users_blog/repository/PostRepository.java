package ru.users_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.users_blog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
