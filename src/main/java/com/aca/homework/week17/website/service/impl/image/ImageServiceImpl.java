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
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);
    private final ImageRepository imageRepository;
    private final PostService postService;

    public ImageServiceImpl(ImageRepository imageRepository, PostService postService) {
        Assert.notNull(imageRepository, "image repository should not be null");
        Assert.notNull(postService, "post service should not be null");
        this.imageRepository = imageRepository;
        this.postService = postService;
    }

    @Override
    public Image create(ImageCreationParams params) {
        Assert.notNull(params, "image creation params should not be null");
        LOGGER.info("Creating and saving a new image according to params - {}", params);
        Image image = imageRepository.save(new Image(
                params.getBlobId(),
                postService.getById(params.getPostId())
        ));
        LOGGER.info("Successfully saved a new image - {}, params - {}", image, params);
        return image;
    }

    @Override
    public List<Image> getAllByPostId(Long id) {
        Assert.notNull(id, "post id should not be null");
        LOGGER.info("Retrieving all images of post with id - {}", id);
        List<Image> allByPost = imageRepository.findAllByPostId(id);
        LOGGER.info("Successfully retrieved all images - {} of post with id - {}", allByPost, id);
        return Collections.unmodifiableList(allByPost);
    }
}
