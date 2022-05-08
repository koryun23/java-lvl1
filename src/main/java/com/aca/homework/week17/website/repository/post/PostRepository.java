package com.aca.homework.week17.website.repository.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(User user);
}
