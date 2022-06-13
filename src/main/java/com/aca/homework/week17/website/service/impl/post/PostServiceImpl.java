package com.aca.homework.week17.website.service.impl.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.image.ImageRepository;
import com.aca.homework.week17.website.repository.post.PostRepository;
import com.aca.homework.week17.website.service.core.post.PostCreationParams;
import com.aca.homework.week17.website.service.core.post.PostService;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        Assert.notNull(postRepository, "post repository should not be null");
        Assert.notNull(userService, "user service should not be null");
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post create(PostCreationParams params) {
        Assert.notNull(params, "post creation params should not be null");
        LOGGER.info("Creating a new post according to params - {}", params);
        Post post = postRepository.save(
                new Post(
                        params.getTitle(),
                        params.getDescription(),
                        userService.getById(params.getUserId()))
        );
        LOGGER.info("Successfully created a new post - {}", post);
        return post;
    }

    @Override
    public Post getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving a post with id = {}", id);
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        LOGGER.info("Successfully retrieved a post - {}", post);
        return post;
    }

    @Override
    public List<Post> getAllByUserId(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Getting all posts of user with id - {}", id);
        List<Post> allByUser = postRepository.findAllByUserId(id);
        LOGGER.info("Successfully retrieved all users - {}", allByUser);
        return allByUser;
    }

    @Override
    public boolean existsById(Long id) {
        Assert.notNull(id, "id should not be null");
        boolean result = postRepository.existsById(id);
        LOGGER.info("Checking id a user with id - {} exists, result - {}", id, result);
        return result;
    }

    @Override
    public LocalDateTime postCreationDate() {
        return LocalDateTime.now();
    }
}
