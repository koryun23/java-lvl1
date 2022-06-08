package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.mapper.PostDtoMapper;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.dto.PostUploadRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacade testSubject;

    @Mock
    private PostService postService;

    @Mock
    private CatFactFetcherService catFactFetcherService;

    @Mock
    private PostDtoMapper postDtoMapper;

    @BeforeEach
    public void init() {
        testSubject = new PostFacadeImpl(postService, catFactFetcherService, postDtoMapper);
    }

    @Test
    public void testGetPostByIdWhenPostExists() {
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.when(postService.getPostById(1L)).thenReturn(new Post(
                LocalDateTime.MAX,
                "random-fact",
                "creator"
        ));
        Assertions.assertThat(testSubject.getPostById(1L)).isEqualTo(new PostDto(
                LocalDateTime.MAX,
                "random-fact",
                "creator"
        ));
        Mockito.verify(postService).getPostById(1L);
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verifyNoMoreInteractions(postService, postDtoMapper);
    }

    @Test
    public void testGetAllPosts() {
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-1", "creator")))
                        .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-1", "creator"));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-2", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-2", "creator"));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-3", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-3", "creator"));
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(
                new Post(LocalDateTime.MAX, "random-fact-1", "creator"),
                new Post(LocalDateTime.MAX, "random-fact-2", "creator"),
                new Post(LocalDateTime.MAX, "random-fact-3", "creator")
        ));
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(List.of(
                new PostDto(LocalDateTime.MAX, "random-fact-1", "creator"),
                new PostDto(LocalDateTime.MAX, "random-fact-2", "creator"),
                new PostDto(LocalDateTime.MAX, "random-fact-3", "creator")
        ));
        Mockito.verify(postService).getAllPosts();
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "random-fact-1", "creator"));
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "random-fact-2", "creator"));
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "random-fact-3", "creator"));
        Mockito.verifyNoMoreInteractions(postService, postDtoMapper);
    }

    @Test
    public void testUploadPost() {
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact", "creator")))
                        .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.when(catFactFetcherService.getRandomFact()).thenReturn("random-fact");
        Mockito.when(postService.creationDate()).thenReturn(LocalDateTime.MAX);
        Mockito.when(postService.create(new PostCreationParams(LocalDateTime.MAX, "random-fact", "creator")))
                .thenReturn(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        testSubject.uploadPost(new PostUploadRequestDto("creator"));
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(new Post(LocalDateTime.MAX, "random-fact", "creator")));
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(List.of(new PostDto(LocalDateTime.MAX, "random-fact", "creator")));
        Mockito.verify(postService).getAllPosts();
        Mockito.verify(postService).create(new PostCreationParams(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verify(postDtoMapper, Mockito.atLeast(2)).apply(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verifyNoMoreInteractions(postService, postDtoMapper);
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-1", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-1", "creator"));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-2", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-2", "creator"));
        Mockito.when(postDtoMapper.apply(new Post(LocalDateTime.MAX, "random-fact-3", "creator")))
                .thenReturn(new PostDto(LocalDateTime.MAX, "random-fact-3", "creator"));
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(
                    new Post(LocalDateTime.MAX, "random-fact-1", "creator"),
                    new Post(LocalDateTime.MAX, "random-fact-2", "creator"),
                    new Post(LocalDateTime.MAX, "random-fact-3", "creator")
                )
        );
        List<PostDto> allPosts = testSubject.getAllPosts();
        Assertions.assertThat(allPosts).isEqualTo(List.of(
                        new PostDto(LocalDateTime.MAX, "random-fact-1", "creator"),
                        new PostDto(LocalDateTime.MAX, "random-fact-2", "creator"),
                        new PostDto(LocalDateTime.MAX, "random-fact-3", "creator")
                )
        );
        testSubject.deletePostById(1L);
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(
                new Post(LocalDateTime.MAX, "random-fact-2", "creator"),
                new Post(LocalDateTime.MAX, "random-fact-3", "creator")
        ));
        List<PostDto> allPostsAfterDeletion = testSubject.getAllPosts();
        Assertions.assertThat(allPostsAfterDeletion).isEqualTo(
                List.of(
                        new PostDto(LocalDateTime.MAX, "random-fact-2", "creator"),
                        new PostDto(LocalDateTime.MAX, "random-fact-3", "creator")
                )
        );
        Mockito.verify(postService, Mockito.atLeast(2)).getAllPosts();
        Mockito.verify(postService).deletePostById(1L);
        Mockito.verify(postDtoMapper).apply(new Post(LocalDateTime.MAX, "random-fact-1", "creator"));
        Mockito.verify(postDtoMapper, Mockito.atLeast(2)).apply(new Post(LocalDateTime.MAX, "random-fact-2", "creator"));
        Mockito.verify(postDtoMapper, Mockito.atLeast(2)).apply(new Post(LocalDateTime.MAX, "random-fact-3", "creator"));
        Mockito.verifyNoMoreInteractions(postService, postDtoMapper);
    }
}