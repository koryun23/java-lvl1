package com.aca.homework.week21.post.repository;

import com.aca.homework.week21.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
