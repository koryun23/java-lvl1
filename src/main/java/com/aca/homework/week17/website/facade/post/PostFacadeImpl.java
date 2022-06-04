package com.aca.homework.week17.website.facade.post;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.facade.post.dto.UserDto;
import com.aca.homework.week17.website.facade.post.request.ImageUploadRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostCreationRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostsRetrievalRequestDto;
import com.aca.homework.week17.website.facade.post.response.ImageUploadResponseDto;
import com.aca.homework.week17.website.facade.post.response.PostCreationResponseDto;
import com.aca.homework.week17.website.facade.post.response.PostsRetrievalResponseDto;
import com.aca.homework.week17.website.mapper.Mapper;
import com.aca.homework.week17.website.mapper.post.PostDtoMapper;
import com.aca.homework.week17.website.mapper.user.UserDtoMapper;
import com.aca.homework.week17.website.service.core.image.ImageCreationParams;
import com.aca.homework.week17.website.service.core.image.ImageService;
import com.aca.homework.week17.website.service.core.post.PostCreationParams;
import com.aca.homework.week17.website.service.core.post.PostService;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);
    private static final int MAXIMUM_IMAGE_COUNT = 5;
    private final UserService userService;
    private final PostService postService;
    private final ImageService imageService;
    private final UserDtoMapper userDtoMapper;
    private final PostDtoMapper postDtoMapper;
    private final Mapper<Image, ImageDto> imageDtoMapper;

    public PostFacadeImpl(UserService userService,
                          PostService postService,
                          ImageService imageService,
                          UserDtoMapper userDtoMapper,
                          PostDtoMapper postDtoMapper,
                          Mapper<Image, ImageDto> imageDtoMapper) {
        Assert.notNull(userService, "user service should not be null");
        Assert.notNull(postService, "post service should not be null");
        Assert.notNull(imageService, "image facade should not be null");
        Assert.notNull(userDtoMapper, "user dto mapper should not be null");
        Assert.notNull(imageDtoMapper, "image dto mapper should not be null");
        this.userService = userService;
        this.postService = postService;
        this.imageService = imageService;
        this.userDtoMapper = userDtoMapper;
        this.postDtoMapper = postDtoMapper;
        this.imageDtoMapper = imageDtoMapper;
    }

    @Override
    public PostCreationResponseDto create(PostCreationRequestDto dto) {
        Assert.notNull(dto, "post creation request dto should not be null");
        List<ImageUploadRequestDto> imageUploadRequestDtos = dto.getImageUploadRequestDtos();
        if (imageUploadRequestDtos.size() > MAXIMUM_IMAGE_COUNT) {
            return new PostCreationResponseDto(List.of(
                    String.format(
                            "image maximum count exceeded: maximum count - %d, actual count - %d",
                            MAXIMUM_IMAGE_COUNT, imageUploadRequestDtos.size()))
            );
        }
        LOGGER.info("creating a new post according to post creation request dto - {}", dto);
        Post post = postService.create(
                new PostCreationParams(
                        dto.getTitle(),
                        dto.getDescription(),
                        dto.getUserId()
                )
        );
        List<ImageUploadResponseDto> imageUploadResponseDtos = this.uploadMultipleImages(imageUploadRequestDtos);
        PostCreationResponseDto postCreationResponseDto = new PostCreationResponseDto(
                imageUploadResponseDtos,
                post.getTitle(),
                post.getDescription(),
                LocalDateTime.now()
        );
        LOGGER.info("successfully created a new post - {}, response - {}", post, postCreationResponseDto);
        return postCreationResponseDto;
    }

    @Override
    public ImageUploadResponseDto uploadImage(ImageUploadRequestDto dto) {
        Assert.notNull(dto, "image upload request dto should not be null");
        LOGGER.info("Uploading a new image according to image upload request dto - {}", dto);

        if(imageService.imageCountInPost(dto.getPostId()) >= MAXIMUM_IMAGE_COUNT) {
            return new ImageUploadResponseDto(List.of(String.format("Cannot upload more than %d images.", MAXIMUM_IMAGE_COUNT)));
        }

        if (!postService.existsById(dto.getPostId())) {
            return new ImageUploadResponseDto(List.of(String.format("Post with id(%d) does not exist", dto.getPostId())));
        }
        Image image = imageService.create(new ImageCreationParams(dto.getBlobId(), dto.getPostId()));
        ImageUploadResponseDto imageUploadResponseDto = new ImageUploadResponseDto(
                image.getBlobId(),
                image.getPost().getId()
        );
        LOGGER.info("Successfully uploaded a new image - {}, response - {}", image, imageUploadResponseDto);
        return imageUploadResponseDto;
    }

    @Override
    public List<ImageUploadResponseDto> uploadMultipleImages(List<ImageUploadRequestDto> imageUploadRequestDtos) {
        Assert.notNull(imageUploadRequestDtos, "Multiple image upload request dto object should not be null");
        LOGGER.info("Uploading multiple images according to image upload request dto list - {}", imageUploadRequestDtos);
        List<ImageUploadResponseDto> imageUploadResponseDtos = new LinkedList<>();
        for(ImageUploadRequestDto imageUploadRequestDto : imageUploadRequestDtos) {
            Image image = imageService.create(new ImageCreationParams(
                    imageUploadRequestDto.getBlobId(),
                    imageUploadRequestDto.getPostId()
            ));
            ImageUploadResponseDto imageUploadResponseDto = new ImageUploadResponseDto(
                    image.getBlobId(),
                    image.getPost().getId()
            );
            imageUploadResponseDtos.add(imageUploadResponseDto);
        }
        LOGGER.info("Successfully uploaded multiple images according to image upload request dto list - {}, result - {}", imageUploadRequestDtos, imageUploadResponseDtos);
        return imageUploadResponseDtos;
    }

    @Override
    public PostsRetrievalResponseDto getAllUserPosts(PostsRetrievalRequestDto dto) {
        Assert.notNull(dto, "posts retrieval request dto should not be null");
        LOGGER.info("Retrieving all posts of user with id = {}", dto.getUserId());
        Optional<User> optionalUser = userService.findById(dto.getUserId());
        if (optionalUser.isEmpty()) {
            return new PostsRetrievalResponseDto(List.of(String.format("user with id = %d does not exist", dto.getUserId())));
        }
        User user = optionalUser.get();
        UserDto userDto = userDtoMapper.apply(user);
        List<Post> posts = postService.getAllByUserId(user.getId());
        List<PostDto> postDtos = new LinkedList<>();

        for (Post post : posts) {
            List<Image> images = imageService.getAllByPostId(post.getId());
            List<ImageDto> imageDtos = new LinkedList<>();
            images.forEach(image -> imageDtos.add(imageDtoMapper.apply(image)));
            postDtoMapper.apply(post);
            postDtos.add(new PostDto(
                    post.getTitle(),
                    post.getDescription(),
                    imageDtos,
                    userDtoMapper.apply(user)));
        }

        PostsRetrievalResponseDto postsRetrievalResponseDto = new PostsRetrievalResponseDto(
                userDto,
                postDtos
        );
        LOGGER.info("Successfully retrieved all posts - {}", postsRetrievalResponseDto);
        return postsRetrievalResponseDto;
    }
}
