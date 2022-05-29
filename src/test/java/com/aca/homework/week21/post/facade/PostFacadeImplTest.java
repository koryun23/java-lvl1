package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacade testSubject;

    @Mock
    private PostService postService;

    @Mock
    private CatFactFetcherService catFactFetcherService;

    @BeforeEach
    public void init() {
        testSubject = new PostFacadeImpl(postService, catFactFetcherService);
    }

    @Test
    public void testGetPostByIdWhenPostExists() {
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
        Mockito.verifyNoMoreInteractions(postService);
    }

    @Test
    public void testGetAllPosts() {
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
        Mockito.verifyNoMoreInteractions(postService);
    }

    @Test
    public void testUploadPost() {
        Mockito.when(catFactFetcherService.getRandomFact()).thenReturn("random-fact");
        Mockito.when(postService.creationDate()).thenReturn(LocalDateTime.MAX);
        Mockito.when(postService.create(new PostCreationParams(LocalDateTime.MAX, "random-fact", "creator")))
                .thenReturn(new Post(LocalDateTime.MAX, "random-fact", "creator"));
        PostDto postDto = testSubject.uploadPost(new PostUploadRequestDto("creator"));
        Mockito.when(postService.getAllPosts()).thenReturn(List.of(new Post(postDto.getCreationDate(), "random-fact", "creator")));
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(List.of(new PostDto(postDto.getCreationDate(), "random-fact", "creator")));
        Mockito.verify(postService).getAllPosts();
        Mockito.verify(postService).create(new PostCreationParams(LocalDateTime.MAX, "random-fact", "creator"));
        Mockito.verifyNoMoreInteractions(postService);
    }

    @Test
    public void testDeletePostById() {
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

    }
}