package com.aca.homework.week21.post.controller;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.dto.PostListRetrievalDto;
import com.aca.homework.week21.post.dto.UploadRequestDto;
import com.aca.homework.week21.post.dto.UploadResponseDto;
import com.aca.homework.week21.post.facade.PostFacade;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping("/posts/bulk")
    public UploadResponseDto uploadPosts(@RequestBody UploadRequestDto dto) {
        return postFacade.upload(dto);
    }

    @GetMapping("/posts/bulk")
    public PostListRetrievalDto getPosts() {
        return new PostListRetrievalDto(postFacade.getPosts());
    }

    @GetMapping("/posts/bulk/{id}")
    public PostDto getPostById(@PathVariable Long id) {
        return postFacade.getPostById(id);
    }

    @DeleteMapping("/posts/bulk/{id}")
    public void deletePostById(@PathVariable Long id) {
        postFacade.deletePostById(id);
    }
}
