package com.aca.homework.week17.website.facade.post.request;

public class PostsRetrievalRequestDto {

    private Long userId;

    public PostsRetrievalRequestDto(Long userId) {
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
