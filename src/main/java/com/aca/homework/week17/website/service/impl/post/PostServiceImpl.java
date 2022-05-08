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
import org.springframework.util.Assert;

import java.util.List;

public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post create(PostCreationParams params) {
        Assert.notNull(params, "post creation params should not be null");
        LOGGER.info("creating a new post according to params - {}", params);
        Post post = postRepository.save(
                new Post(
                        params.getTitle(),
                        params.getDescription(),
                        userService.getById(params.getUserId()))
        );
        LOGGER.info("successfully created a new post - {}", post);
        return post;
    }

    @Override
    public Post getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving a post with id = {}", id);
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        LOGGER.info("successfully retrieved a post - {}", post);
        return post;
    }

    @Override
    public List<Post> getAllByUser(User user) {
        Assert.notNull(user, "user should not be null");
        LOGGER.info("getting all posts of user with id {}", user);
        List<Post> allByUser = postRepository.findAllByUser(user);
        LOGGER.info("successfully retrieved all users - {}", allByUser);
        return allByUser;
    }
}
