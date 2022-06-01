package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostNotFoundException;
import com.aca.homework.week21.post.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        Assert.notNull(postRepository, "Post repository should not be null");
        this.postRepository = postRepository;
    }

    @Override
    public Post getPostById(Long postId) {
        Assert.notNull(postId, "Post id should not be null");
        LOGGER.info("Retrieving a post having an id of {}", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        LOGGER.info("Successfully retrieved a post having an id of {}, result - {}", postId, post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        LOGGER.info("Retrieving all posts");
        List<Post> allPosts = postRepository.findAll();
        LOGGER.info("Successfully retrieved all posts, result - {}", allPosts);
        return Collections.unmodifiableList(allPosts);
    }

    @Override
    public void deletePostById(Long postId) {
        Assert.notNull(postId, "post id should not be null");
        LOGGER.info("Deleting a post having an id of {}", postId);
        postRepository.deleteById(postId);
        LOGGER.info("Successfully deleted a post having an id of {}", postId);
    }

    @Override
    public Post create(PostCreationParams params) {
        Assert.notNull(params, "Post creation params should not be null");
        LOGGER.info("Creating a new post according to the creation params - {}", params);
        Post post = postRepository.save(new Post(
                params.getCreationDate(),
                params.getContent(),
                params.getCreatedBy()
        ));
        System.out.println(post);
        LOGGER.info("Successfully saved a new post, result - {}", post);
        return post;
    }

    @Override
    public LocalDateTime creationDate() {
        return LocalDateTime.now();
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        Assert.notNull(id, "Post id should not be null");
        LOGGER.info("Retrieving an optional of a post having an id of {}", id);
        Optional<Post> postOptional = postRepository.findById(id);
        LOGGER.info("Successfully retrieved an optional of a post having an id of {}, result - {}", id, postOptional);
        return postOptional;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return LocalDateTime.now();
    }
}
