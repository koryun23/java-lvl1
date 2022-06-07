package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface PostFacade {
    UploadResponseDto upload(UploadRequestDto dto);

    PostListRetrievalDto getPosts();

    SinglePostRetrievalDto getPostById(Long id);

    PostDeletionResponseDto deletePostById(Long id);
}
