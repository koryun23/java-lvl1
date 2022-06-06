package com.aca.homework.week17.website.service.impl.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.post.PostRepository;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    private PostService testSubject;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        testSubject = new PostServiceImpl(postRepository, userService);
    }

    @Test
    public void testGetPostByIdWhenPostDoesNotExist() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getById(1L)).isExactlyInstanceOf(PostNotFoundException.class);
        Mockito.verify(postRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testGetPostByIdWhenPostExists() {
        User user = new User("john11", "John", "Smith", "pwd11");
        Post post = new Post("title-1", "desc-1", user);
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(post);
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testGetAllByUserIdWhenUserHasNoPosts() {
        Mockito.when(postRepository.findAllByUserId(1L)).thenReturn(Collections.emptyList());
        Assertions.assertThat(testSubject.getAllByUserId(1L)).isEqualTo(Collections.emptyList());
        Mockito.verify(postRepository).findAllByUserId(1L);
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testGetAllByUserIdWhenUserHasPosts() {
        User user = new User("john11", "John", "Smith", "pwd11");
        Post post1 = new Post("title-1", "desc-1", user);
        Post post2 = new Post("title-2", "desc-2", user);
        Mockito.when(postRepository.findAllByUserId(1L)).thenReturn(List.of(
                post1, post2
        ));
        Assertions.assertThat(testSubject.getAllByUserId(1L)).isEqualTo(List.of(
                post1, post2
        ));
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testPostExistsWhenPostDoesNotExist() {
        Mockito.when(postRepository.existsById(1L)).thenReturn(false);
        Assertions.assertThat(testSubject.existsById(1L)).isEqualTo(false);
        Mockito.verify(postRepository).existsById(1L);
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testPostExistsWhenPostExists() {
        Mockito.when(postRepository.existsById(1L)).thenReturn(true);
        Assertions.assertThat(testSubject.existsById(1L)).isEqualTo(true);
        Mockito.verify(postRepository).existsById(1L);
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }

    @Test
    public void testCreatePost() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);
        Mockito.when(userService.getById(1L)).thenReturn(user);
        Mockito.when(postRepository.save(new Post("title-1", "desc-1", user))).thenReturn(new Post("title-1", "desc-1", user));
        Assertions.assertThat(testSubject.create(new PostCreationParams("title-1", "desc-1", 1L)))
                .isEqualTo(new Post("title-1", "desc-1", user));
        Mockito.verify(userService).getById(1L);
        Mockito.verify(postRepository).save(new Post("title-1", "desc-1", user));
        Mockito.verifyNoMoreInteractions(postRepository, userService);
    }
}