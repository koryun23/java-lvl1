package com.aca.homework.week17.website.service.core.image;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;

import java.util.List;

public interface ImageService {
    Image create(ImageCreationParams params);

    List<Image> getAllByPostId(Long id);

    int imageCountInPost(Long postId);
}
