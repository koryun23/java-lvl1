package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.facade.PostDto;

import java.util.List;

public interface PostService {
    Post getPostById(Long postId);

    List<Post> getAllPosts();

    void deletePostById(Long postId);

    Post create(PostCreationParams params);
}
