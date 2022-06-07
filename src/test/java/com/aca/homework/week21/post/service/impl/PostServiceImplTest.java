package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostNotFoundException;
import com.aca.homework.week21.post.service.core.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    private PostService testSubject;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        testSubject = new PostServiceImpl(postRepository);
    }

    @Test
    public void testCreate() {
        Mockito.when(postRepository.save(new Post(LocalDateTime.MAX, "content", "creator")))
                .thenReturn(new Post(LocalDateTime.MAX, "content", "creator"));
        Post post = testSubject.create(new PostCreationParams(LocalDateTime.MAX, "content", "creator"));
        Mockito.when(postRepository.findAll()).thenReturn(List.of(
                new Post(LocalDateTime.MAX, "content", "creator")
        ));
        Assertions.assertThat(post).isEqualTo(new Post(LocalDateTime.MAX, "content", "creator"));

        List<Post> allPosts = testSubject.getAllPosts();
        Assertions.assertThat(allPosts).contains(new Post(LocalDateTime.MAX, "content", "creator"));
        Mockito.verify(postRepository).save(new Post(LocalDateTime.MAX, "content", "creator"));
        Mockito.verify(postRepository).findAll();
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testGetPostWhenPostNotFound() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findPostById(1L)).isEmpty();
        Assertions.assertThatThrownBy(() -> testSubject.getPostById(1L)).isExactlyInstanceOf(PostNotFoundException.class);
        Mockito.verify(postRepository, Mockito.atLeast(2)).findById(1L);
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testGetAllPosts() {
        Mockito.when(postRepository.findAll()).thenReturn(
                List.of(new Post(LocalDateTime.MAX, "content", "creator"))
        );
        List<Post> allPosts = testSubject.getAllPosts();
        Assertions.assertThat(allPosts).isEqualTo(
                List.of(new Post(LocalDateTime.MAX, "content", "creator"))
        );
        Mockito.verify(postRepository).findAll();
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testPostDelete() {
        Mockito.when(postRepository.findAll()).thenReturn(
                List.of(new Post(LocalDateTime.MAX, "content", "creator"))
        );
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(List.of(new Post(LocalDateTime.MAX, "content", "creator")));
        testSubject.deletePostById(1L);
        Mockito.when(postRepository.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(Collections.emptyList());
        Mockito.verify(postRepository, Mockito.atLeast(2)).findAll();
    }
}