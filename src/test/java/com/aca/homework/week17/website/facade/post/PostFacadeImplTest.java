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
import com.aca.homework.week17.website.mapper.image.ImageDtoMapper;
import com.aca.homework.week17.website.mapper.post.PostDtoMapper;
import com.aca.homework.week17.website.mapper.user.UserDtoMapper;
import com.aca.homework.week17.website.service.core.image.ImageCreationParams;
import com.aca.homework.week17.website.service.core.image.ImageService;
import com.aca.homework.week17.website.service.core.post.PostCreationParams;
import com.aca.homework.week17.website.service.core.post.PostService;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacadeImpl testSubject;

    @Mock
    private UserService userService;

    @Mock
    private ImageService imageService;

    @Mock
    private PostService postService;

    @Mock
    private UserDtoMapper userDtoMapper;

    @Mock
    private PostDtoMapper postDtoMapper;

    @Mock
    private ImageDtoMapper imageDtoMapper;

    @BeforeEach
    public void init() {

        testSubject = new PostFacadeImpl(userService, postService, imageService, userDtoMapper, postDtoMapper, imageDtoMapper);
    }

    @Test
    public void testGetAllPostsFromNonExistingUser() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.getAllUserPosts(new PostsRetrievalRequestDto(1L)))
                .isEqualTo(new PostsRetrievalResponseDto(List.of("user with id - 1 does not exist")));
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService, imageService, postService, userDtoMapper, postDtoMapper, imageDtoMapper);
    }

    @Test
    public void testGetAllPostsFromExistingUser() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);

        Post post = new Post("title-1", "desc-1", user);
        post.setId(1L);

        Image image1 = new Image("blob-1", post);
        image1.setId(1L);

        Image image2 = new Image("blob-2", post);
        image2.setId(2L);

        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userDtoMapper.apply(user))
                .thenReturn(new UserDto("john11", "John", "Smith"));
        Mockito.when(postService.getAllByUserId(1L)).thenReturn(
                List.of(post)
        );
        Mockito.when(imageService.getAllByPostId(1L)).thenReturn(List.of(
                image1,
                image2
        ));
        Mockito.when(imageDtoMapper.apply(image1))
                .thenReturn(new ImageDto("blob-1"));
        Mockito.when(imageDtoMapper.apply(image2))
                .thenReturn(new ImageDto("blob-2"));
        Mockito.when(postDtoMapper.apply(post))
                .thenReturn(new PostDto(
                        "title-1",
                        "desc-1",
                        List.of(
                                new ImageDto("blob-1"),
                                new ImageDto("blob-2")
                        ),
                        new UserDto("john11", "John", "Smith"))
                );
        Mockito.when(userDtoMapper.apply(user))
                .thenReturn(new UserDto("john11", "John", "Smith"));

        Assertions.assertThat(testSubject.getAllUserPosts(new PostsRetrievalRequestDto(1L)))
                .isEqualTo(new PostsRetrievalResponseDto(
                        new UserDto("john11", "John", "Smith"),
                        List.of(new PostDto(
                                "title-1",
                                "desc-1",
                                List.of(
                                        new ImageDto("blob-1"),
                                        new ImageDto("blob-2")
                                ),
                                new UserDto("john11", "John", "Smith")))
                ));
        Mockito.verify(userService).findById(1L);
        Mockito.verify(userDtoMapper, Mockito.atLeast(2)).apply(user);
        Mockito.verify(postService).getAllByUserId(1L);
        Mockito.verify(imageService).getAllByPostId(1L);
        Mockito.verify(imageDtoMapper).apply(image1);
        Mockito.verify(imageDtoMapper).apply(image2);
        Mockito.verify(postDtoMapper).apply(post);
        Mockito.verifyNoMoreInteractions(userService, postService, imageService, userDtoMapper, postDtoMapper, imageDtoMapper);
    }

    @Test
    public void testCreatePostWhenImageCountExceedsMaximumCount() {
        Assertions.assertThat(testSubject.create(new PostCreationRequestDto("title-1",
                "desc-1",
                1L,
                 List.of(
                         new ImageUploadRequestDto("blob-1", 1L),
                         new ImageUploadRequestDto("blob-2", 1L),
                         new ImageUploadRequestDto("blob-3", 1L),
                         new ImageUploadRequestDto("blob-4", 1L),
                         new ImageUploadRequestDto("blob-5", 1L),
                         new ImageUploadRequestDto("blob-6", 1L)
                 )))).isEqualTo(new PostCreationResponseDto(List.of("image maximum count exceeded: maximum count - 5, actual count - 6")));
        Mockito.verifyNoMoreInteractions(userService, postService, imageService, userDtoMapper, postDtoMapper, imageDtoMapper);
    }

    @Test
    public void testCreatePostWhenImageCountIsValid() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);

        Post post = new Post("title-1", "desc-1", user);
        post.setId(1L);

        Image image1 = new Image("blob-1", post);
        image1.setId(1L);

        Image image2 = new Image("blob-2", post);
        image2.setId(2L);

        Image image3 = new Image("blob-3", post);
        image3.setId(3L);

        Mockito.when(postService.create(new PostCreationParams(
                "title-1",
                "desc-1",
                1L
        ))).thenReturn(post);

        Mockito.when(imageService.create(new ImageCreationParams("blob-1", 1L)))
                .thenReturn(image1);
        Mockito.when(imageService.create(new ImageCreationParams("blob-2", 1L)))
                .thenReturn(image2);
        Mockito.when(imageService.create(new ImageCreationParams("blob-3", 1L)))
                .thenReturn(image3);
        Mockito.when(postService.postCreationDate()).thenReturn(LocalDateTime.MAX);
        PostCreationResponseDto postCreationResponseDto = testSubject.create(new PostCreationRequestDto(
                "title-1",
                "desc-1",
                1L,
                List.of(
                        new ImageUploadRequestDto("blob-1", 1L),
                        new ImageUploadRequestDto("blob-2", 1L),
                        new ImageUploadRequestDto("blob-3", 1L)
                )
        ));
        Assertions.assertThat(postCreationResponseDto).isEqualTo(new PostCreationResponseDto(
                List.of(
                        new ImageUploadResponseDto("blob-1", 1L),
                        new ImageUploadResponseDto("blob-2", 1L),
                        new ImageUploadResponseDto("blob-3", 1L)
                ),
                "title-1",
                "desc-1",
                LocalDateTime.MAX
        ));
        Mockito.verify(postService).create(new PostCreationParams("title-1", "desc-1", 1L));
        Mockito.verify(imageService).create(new ImageCreationParams("blob-1", 1L));
        Mockito.verify(imageService).create(new ImageCreationParams("blob-2", 1L));
        Mockito.verify(imageService).create(new ImageCreationParams("blob-3", 1L));
        Mockito.verifyNoMoreInteractions(userService, postService, imageService, userDtoMapper, postDtoMapper, imageDtoMapper);
    }

}