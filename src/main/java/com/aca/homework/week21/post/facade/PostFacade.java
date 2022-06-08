package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.*;

import java.util.List;

public interface PostFacade {
    SinglePostRetrievalResponseDto getPostById(Long postId);

    PostListRetrievalResponseDto getAllPosts();

    PostDeletionResponseDto deletePostById(Long id);

    PostUploadResponseDto uploadPost(PostUploadRequestDto dto);
}
