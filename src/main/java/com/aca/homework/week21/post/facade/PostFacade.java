package com.aca.homework.week21.post.facade;

import java.util.List;

public interface PostFacade {
    PostDto getPostById(Long postId);

    List<PostDto> getAllPosts();

    void deletePostById(Long id);
}
