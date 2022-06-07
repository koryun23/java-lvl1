package com.aca.homework.week21.post.service.core;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super(String.format("Post with an id of %s not found", id));
    }
}
