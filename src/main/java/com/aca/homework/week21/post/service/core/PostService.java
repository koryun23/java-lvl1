package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.entity.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Post getPostById(Long postId);

    List<Post> getAllPosts();

    void deletePostById(Long postId);

    Post create(PostCreationParams params);

    LocalDateTime creationDate();

    Optional<Post> findPostById(Long id);
}
