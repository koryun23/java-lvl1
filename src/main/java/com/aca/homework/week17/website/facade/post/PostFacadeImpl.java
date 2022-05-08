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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);
    private final UserService userService;
    private final PostService postService;
    private final ImageService imageService;
    private UserDtoMapper userDtoMapper;
    private PostDtoMapper postDtoMapper;
    private Mapper<Image, ImageDto> imageDtoMapper;

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
        if(imageUploadRequestDtos.size() > 5) {
            throw new ImageMaximumCountOutOfBoundsException(imageUploadRequestDtos.size(), 5);
        }
        LOGGER.info("creating a new post according to post creation request dto - {}", dto);
        Post post = postService.create(
                new PostCreationParams(
                        dto.getTitle(),
                        dto.getDescription(),
                        dto.getUserId()
                )
        );
        List<ImageUploadResponseDto> imageUploadResponseDtos = new LinkedList<>();
        for(ImageUploadRequestDto imageUploadRequestDto : imageUploadRequestDtos) {
            imageUploadResponseDtos.add(this.uploadImage(imageUploadRequestDto));
        }
        LOGGER.info("successfully created a new post - {}", post);
        return new PostCreationResponseDto(
                imageUploadResponseDtos,
                post.getTitle(),
                post.getDescription(),
                LocalDateTime.now()
        );
    }

    @Override
    public ImageUploadResponseDto uploadImage(ImageUploadRequestDto dto) {
        Assert.notNull(dto, "image upload request dto should not be null");
        LOGGER.info("uploading a new image according to image upload request dto - {}", dto);
        Image image = imageService.create(new ImageCreationParams(dto.getBlobId(), dto.getPostId()));
        LOGGER.info("successfully uploaded a new image - {}", image);
        return new ImageUploadResponseDto(
                image.getBlobId(),
                image.getPost().getId()
        );
    }

    @Override
    public PostsRetrievalResponseDto getAllUserPosts(PostsRetrievalRequestDto dto) {
        Assert.notNull(dto, "posts retrieval request dto should not be null");
        LOGGER.info("retrieving all posts of user with id = {}", dto.getUserId());
        User user = userService.getById(dto.getUserId());
        UserDto userDto = userDtoMapper.apply(user);
        List<Post> posts = postService.getAllByUser(user);
        List<PostDto> postDtos = new LinkedList<>();

        for(Post post : posts) {
            List<Image> images = imageService.getAllByPost(post);
            List<ImageDto> imageDtos = new LinkedList<>();
            images.forEach(image -> imageDtos.add(imageDtoMapper.apply(image)));
            postDtoMapper.apply(post);
            postDtos.add(new PostDto(
                            post.getTitle(),
                            post.getDescription(),
                            imageDtos
            ));
        }

        PostsRetrievalResponseDto postsRetrievalResponseDto = new PostsRetrievalResponseDto(
                userDto,
                postDtos
        );
        LOGGER.info("successfully retrieved all posts - {}", postsRetrievalResponseDto);
        return postsRetrievalResponseDto;
    }
}
