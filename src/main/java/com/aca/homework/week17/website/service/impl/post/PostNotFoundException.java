package com.aca.homework.week17.website.service.impl.post;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super(String.format("Post with id (%s) not found.", id));
    }
}
