package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
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

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;
    private final CatFactFetcherService catFactFetcherService;

    public PostServiceImpl(PostRepository postRepository, CatFactFetcherService catFactFetcherService) {
        Assert.notNull(postRepository, "Post repository should not be null");
        Assert.notNull(catFactFetcherService, "Cat fact fetcher service should not be null");
        this.postRepository = postRepository;
        this.catFactFetcherService = catFactFetcherService;
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
        String catFactContent = catFactFetcherService.getRandomFact();
        Post post = postRepository.save(new Post(
                LocalDateTime.now(),
                catFactContent,
                params.getCreatedBy()
        ));
        LOGGER.info("Successfully saved a new post, result - {}", post);
        return post;
    }
}
