package com.aca.homework.week17.website.service.impl.image;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.image.ImageRepository;
import com.aca.homework.week17.website.service.core.image.ImageCreationParams;
import com.aca.homework.week17.website.service.core.image.ImageService;
import com.aca.homework.week17.website.service.core.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private PostService postService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    public ImageServiceImpl(ImageRepository imageRepository, PostService postService) {
        this.imageRepository = imageRepository;
        this.postService = postService;
    }
    @Override
    public Image create(ImageCreationParams params) {
        Assert.notNull(params, "image creation params should not be null");
        LOGGER.info("creating and saving a new image according to params - {}", params);
        Image image = imageRepository.save(new Image(
                params.getBlobId(),
                postService.getById(params.getPostId())
        ));
        LOGGER.info("Successfully saved a new image - {}", image);
        return image;
    }

    @Override
    public List<Image> getAllByPost(Post post) {
        Assert.notNull(post, "post should not be null");
        LOGGER.info("retrieving all images of post - {}", post);
        List<Image> allByPost = imageRepository.findAllByPost(post);
        if(allByPost.isEmpty()){
            LOGGER.info("the post - {} had not images, returning an empty list.", post);
            return Collections.emptyList();
        }
        LOGGER.info("successfully retrieved all images - {} of post - {}", allByPost, post);
        return Collections.unmodifiableList(allByPost);
    }

    @Override
    public List<Image> getAllByUser(User user) {
        Assert.notNull(user, "user should not be null");
        LOGGER.info("retrieving all the images from user - {}", user);
        List<Post> allByUser = postService.getAllByUser(user);
        List<Image> imagesByUser = new LinkedList<>();
        for(Post post : allByUser) {
            List<Image> allByPost = getAllByPost(post);
            imagesByUser.addAll(allByPost);
        }
        LOGGER.info("successfully retrieved all images - {} of the user - {}", imagesByUser, user);
        return imagesByUser;
    }

}
