package com.aca.homework.week17.website.facade.post.request;

import org.springframework.util.Assert;

public class PostsRetrievalRequestDto {

    private final Long userId;

    public PostsRetrievalRequestDto(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "PostsRetrievalRequestDto{" +
                "userId=" + userId +
                '}';
    }
}
