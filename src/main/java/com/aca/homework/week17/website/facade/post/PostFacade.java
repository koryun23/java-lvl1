package com.aca.homework.week17.website.facade.post;

import com.aca.homework.week17.website.facade.post.response.PostsRetrievalResponseDto;
import com.aca.homework.week17.website.facade.post.response.ImageUploadResponseDto;
import com.aca.homework.week17.website.facade.post.request.PostsRetrievalRequestDto;
import com.aca.homework.week17.website.facade.post.request.ImageUploadRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostCreationRequestDto;
import com.aca.homework.week17.website.facade.post.response.PostCreationResponseDto;

public interface PostFacade {
    PostCreationResponseDto create(PostCreationRequestDto dto);

    ImageUploadResponseDto uploadImage(ImageUploadRequestDto dto);

    PostsRetrievalResponseDto getAllUserPosts(PostsRetrievalRequestDto dto);
}
