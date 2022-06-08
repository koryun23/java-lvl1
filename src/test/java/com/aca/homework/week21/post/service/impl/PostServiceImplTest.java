package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostNotFoundException;
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

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    private PostServiceImpl testSubject;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        testSubject = new PostServiceImpl(postRepository);
    }

    @Test
    public void testCreate() {
        Mockito.when(postRepository.save(new Post(LocalDateTime.MAX, "random-fact", "creator")))
                .thenReturn(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        Assertions.assertThat(testSubject.create(new PostCreationParams(LocalDateTime.MAX, "random-fact", "creator")))
                .isEqualTo(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verify(postRepository).save(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testGetAllPosts() {
        Mockito.when(postRepository.findAll())
                .thenReturn(List.of(
                        new Post(LocalDateTime.MAX, "random-fact-1", "creator"),
                        new Post(LocalDateTime.MAX, "random-fact-2", "creator"),
                        new Post(LocalDateTime.MAX, "random-fact-3", "creator")
                ));
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(
                List.of(
                        new Post(LocalDateTime.MAX, "random-fact-1", "creator"),
                        new Post(LocalDateTime.MAX, "random-fact-2", "creator"),
                        new Post(LocalDateTime.MAX, "random-fact-3", "creator")
                )
        );
        Mockito.verify(postRepository).findAll();
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testGetPostByIdWhenPostDoesNotExist() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getPostById(1L)).isExactlyInstanceOf(PostNotFoundException.class);
        Mockito.verify(postRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testGetPostByIdWhenPostExists() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.of(
                new Post(
                        LocalDateTime.MAX,
                        "random-fact",
                        "creator"
                )
        ));
        Assertions.assertThat(testSubject.getPostById(1L)).isEqualTo(
                new Post(LocalDateTime.MAX, "random-fact", "creator")
        );
        Mockito.verify(postRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.of(new Post(
                LocalDateTime.MAX,
                "random-fact",
                "creator"
        )));
        postRepository.deleteById(1L);
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getPostById(1L)).isExactlyInstanceOf(PostNotFoundException.class);
        Mockito.verify(postRepository).deleteById(1L);
        Mockito.verify(postRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(postRepository);
    }
}