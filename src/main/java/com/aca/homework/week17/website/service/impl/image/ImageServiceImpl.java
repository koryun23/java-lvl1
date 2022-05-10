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
    public List<Image> getAllByPostId(Long id) {
        Assert.notNull(id, "post should not be null");
        LOGGER.info("retrieving all images of post with id - {}", id);
        List<Image> allByPost = imageRepository.findAllByPostId(id);
        LOGGER.info("successfully retrieved all images - {} of post with id - {}", allByPost, id);
        return Collections.unmodifiableList(allByPost);
    }

    @Override
    public List<Image> getAllByUserId(Long id) {
        Assert.notNull(id, "user should not be null");
        LOGGER.info("retrieving all the images from user - {}", id);
        List<Post> allByUser = postService.getAllByUserId(id);
        List<Image> imagesByUser = new LinkedList<>();
        for(Post post : allByUser) {
            List<Image> allByPost = getAllByPostId(post.getId());
            imagesByUser.addAll(allByPost);
        }
        LOGGER.info("successfully retrieved all images - {} of the user with id - {}", imagesByUser, id);
        return imagesByUser;
    }

}
