package com.aca.homework.week21.post.controller;

import com.aca.homework.week21.post.dto.*;
import com.aca.homework.week21.post.facade.PostFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping("/posts")
    public PostUploadResponseDto uploadNewPost(@RequestBody PostUploadRequestDto postUploadRequestDto) {
        return postFacade.uploadPost(postUploadRequestDto);
    }

    @GetMapping("/posts")
    public PostListRetrievalResponseDto getAllPosts() {
        return postFacade.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public SinglePostRetrievalResponseDto getPost(@PathVariable("id") Long id) {
        return postFacade.getPostById(id);
    }

    @DeleteMapping("/posts/{id}")
    public PostDeletionResponseDto deletePostWithId(@PathVariable("id") Long id) {
        return postFacade.deletePostById(id);
    }
}
