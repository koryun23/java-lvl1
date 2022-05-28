package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;

import java.util.List;

public interface PostFacade {
    PostDto getPostById(Long postId);

    List<PostDto> getAllPosts();

    void deletePostById(Long id);

    PostDto uploadPost(PostUploadRequestDto dto);
}
