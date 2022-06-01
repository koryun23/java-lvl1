package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.entity.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Post create(PostCreationParams params);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void deletePostById(Long id);

    LocalDateTime creationDate();

    Optional<Post> findPostById(Long id);

    LocalDateTime getCreationDate();
}
