package com.aca.homework.week17.website;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.post.PostFacade;
import com.aca.homework.week17.website.facade.post.PostFacadeImpl;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.facade.post.dto.UserDto;
import com.aca.homework.week17.website.facade.post.request.ImageUploadRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostCreationRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostsRetrievalRequestDto;
import com.aca.homework.week17.website.facade.user.UserFacade;
import com.aca.homework.week17.website.facade.user.UserFacadeImpl;
import com.aca.homework.week17.website.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week17.website.mapper.Mapper;
import com.aca.homework.week17.website.mapper.image.ImageDtoMapper;
import com.aca.homework.week17.website.mapper.image.ImageDtoMapperImpl;
import com.aca.homework.week17.website.mapper.post.PostDtoMapper;
import com.aca.homework.week17.website.mapper.post.PostDtoMapperImpl;
import com.aca.homework.week17.website.mapper.user.UserDtoMapper;
import com.aca.homework.week17.website.mapper.user.UserDtoMapperImpl;
import com.aca.homework.week17.website.repository.image.ImageRepository;
import com.aca.homework.week17.website.repository.post.PostRepository;
import com.aca.homework.week17.website.repository.user.UserRepository;
import com.aca.homework.week17.website.service.core.image.ImageService;
import com.aca.homework.week17.website.service.core.post.PostService;
import com.aca.homework.week17.website.service.core.user.UserService;
import com.aca.homework.week17.website.service.impl.image.ImageServiceImpl;
import com.aca.homework.week17.website.service.impl.post.PostServiceImpl;
import com.aca.homework.week17.website.service.impl.user.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        PostRepository postRepository = context.getBean(PostRepository.class);
        ImageRepository imageRepository = context.getBean(ImageRepository.class);
        UserService userService = new UserServiceImpl(userRepository);
        PostService postService = new PostServiceImpl(postRepository, userService);
        ImageService imageService = new ImageServiceImpl(imageRepository, postService);
        UserFacade userFacade = new UserFacadeImpl(userService);
        UserDtoMapper userDtoMapper = new UserDtoMapperImpl();
        PostDtoMapper postDtoMapper = new PostDtoMapperImpl();
        ImageDtoMapper imageDtoMapper = new ImageDtoMapperImpl();
        PostFacade postFacade = new PostFacadeImpl(
                userService,
                postService,
                imageService,
                userDtoMapper,
                postDtoMapper,
                imageDtoMapper
        );
        System.out.println(userFacade.signUp(
                new UserSignUpRequestDto(
                        "johnny11",
                        "John",
                        "Smith",
                        "abc123"
                )
        ));

        System.out.println(postFacade.create(new PostCreationRequestDto(
                "post-1", "description-1", 1L,
                List.of(new ImageUploadRequestDto("abc", 1L),
                        new ImageUploadRequestDto("abcd", 1L),
                        new ImageUploadRequestDto("ab", 1L),
                        new ImageUploadRequestDto("a", 1L),
                        new ImageUploadRequestDto("asdfk", 1L)
                )
        )));
        postFacade.create(new PostCreationRequestDto(
                "post-2", "description-2", 1L,
                List.of(new ImageUploadRequestDto("abc2", 2L),
                        new ImageUploadRequestDto("abcd2", 2L),
                        new ImageUploadRequestDto("ab2", 2L),
                        new ImageUploadRequestDto("a2", 2L),
                        new ImageUploadRequestDto("asdfk2", 2L)
                )
        ));
        System.out.println(postFacade.getAllUserPosts(
                new PostsRetrievalRequestDto(
                        1L
                )
        ));
    }
}
