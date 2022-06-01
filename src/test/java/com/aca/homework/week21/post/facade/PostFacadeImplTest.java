package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.dto.SinglePostRetrievalDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.mapper.PostCreationParamsMapper;
import com.aca.homework.week21.post.mapper.PostDtoMapper;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacade testSubject;

    @Mock
    private PostService postService;

    @Mock
    private CatFactFetcherService catFactFetcherService;

    @Mock
    private PostDtoMapper postDtoMapper;

    @Mock
    private PostCreationParamsMapper postCreationParamsMapper;

    @BeforeEach
    public void init() {
        testSubject = new PostFacadeImpl(postService, catFactFetcherService, postDtoMapper, postCreationParamsMapper);
    }

    @Test
    public void testGetAllPosts() {
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(
                new Post(LocalDateTime.MAX, "content", "creator")
        ));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "content", "creator"))).thenReturn(
                new PostDto(LocalDateTime.MAX, "content", "creator")
        );
        Assertions.assertThat(testSubject.getPosts().getPostDtoList()).isEqualTo(
                List.of(new PostDto(LocalDateTime.MAX, "content", "creator"))
        );
        Mockito.verify(postService).getAllPosts();
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "content", "creator"));
        Mockito.verifyNoMoreInteractions(postService, catFactFetcherService, postDtoMapper, postCreationParamsMapper);
    }

    @Test
    public void testGetPostByIdWhenPostDoesNotExist() {
        Mockito.when(postService.findPostById(1L)).thenReturn(Optional.empty());

        SinglePostRetrievalDto postById = testSubject.getPostById(1L);
        Assertions.assertThat(postById.getError()).isNotEmpty();
        Assertions.assertThat(postById.getError()).isEqualTo("Could not find a post with an id of 1");

        Mockito.verify(postService).findPostById(1L);
        Mockito.verifyNoMoreInteractions(postService, postDtoMapper);
    }

    @Test
    public void testGetPostByIdWhenPostExists() {
        Mockito.when(postService.findPostById(1L)).thenReturn(
                Optional.of(new Post(LocalDateTime.MAX, "content", "creator")
        ));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "content", "creator")))
                        .thenReturn(new PostDto(LocalDateTime.MAX, "content", "creator"));
        Assertions.assertThat(testSubject.getPostById(1L).getPostDto())
                .isEqualTo(new PostDto(LocalDateTime.MAX, "content", "creator"));
        Mockito.verify(postService).findPostById(1L);
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "content", "creator"));
    }
}