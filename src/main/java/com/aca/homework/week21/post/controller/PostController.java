package com.aca.homework.week21.post.controller;

import com.aca.homework.week21.post.facade.PostDto;
import com.aca.homework.week21.post.facade.PostFacade;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping("/posts")
    public PostDto uploadNewPost(@RequestBody PostUploadRequestDto postUploadRequestDto){
        return postFacade.uploadPost(postUploadRequestDto);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postFacade.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public PostDto getPost(@PathVariable("id") Long id) {
        return postFacade.getPostById(id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePostWithId(@PathVariable("id") Long id) {
        postFacade.deletePostById(id);
    }
}
