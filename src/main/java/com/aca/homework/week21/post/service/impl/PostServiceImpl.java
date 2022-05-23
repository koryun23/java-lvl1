package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.PostNotFoundException;
import com.aca.homework.week21.post.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post getPostById(Long postId) {
        Assert.notNull(postId, "The post id should not be null");
        LOGGER.info("Retrieving a post having id of {}", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        LOGGER.info("Successfully retrieved a post with id - {}, result - {}", postId, post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        LOGGER.info("Retrieving all cat fact posts");
        List<Post> allPosts = postRepository.findAll();
        LOGGER.info("Successfully retrieved all posts, result - {}", allPosts);
        return allPosts;
    }

    @Override
    public void deletePostById(Long postId) {
        LOGGER.info("Deleting a post with id - {}", postId);
        postRepository.deleteById(postId);
        LOGGER.info("Successfully deleted a post with id - {}", postId);
    }
}
