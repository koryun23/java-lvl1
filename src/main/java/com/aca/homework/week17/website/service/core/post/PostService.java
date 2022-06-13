package com.aca.homework.week17.website.service.core.post;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    Post create(PostCreationParams params);

    Post getById(Long id);

    List<Post> getAllByUserId(Long id);

    boolean existsById(Long id);

    LocalDateTime postCreationDate();
}
