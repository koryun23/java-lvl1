package com.aca.homework.week17.website.service.impl.image;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.image.ImageRepository;
import com.aca.homework.week17.website.service.core.image.ImageCreationParams;
import com.aca.homework.week17.website.service.core.image.ImageService;
import com.aca.homework.week17.website.service.core.post.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {
    private ImageService testSubject;

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private PostService postService;

    @BeforeEach
    public void init() {
        testSubject = new ImageServiceImpl(imageRepository, postService);
    }

    @Test
    public void testGetAllByPostId() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);
        Post post = new Post("title-1", "desc-1", user);
        post.setId(1L);
        Image image1 = new Image("blob-1", post);
        image1.setId(1L);
        Image image2 = new Image("blob-2", post);
        image2.setId(2L);
        Mockito.when(imageRepository.findAllByPostId(1L)).thenReturn(List.of(
            image1, image2
        ));

        Assertions.assertThat(testSubject.getAllByPostId(1L)).isEqualTo(List.of(image1, image2));

        Mockito.verify(imageRepository).findAllByPostId(1L);
        Mockito.verifyNoMoreInteractions(imageRepository, postService);
    }

    @Test
    public void testCreate() {
        User user = new User("john11", "John", "Smith", "pwd11");
        Post post = new Post("title-1", "desc-1", user);
        Mockito.when(imageRepository.save(new Image("blob-1", post))).thenReturn(new Image("blob-1", post));
        Mockito.when(postService.getById(1L)).thenReturn(post);

        Assertions.assertThat(testSubject.create(new ImageCreationParams("blob-1", 1L))).isEqualTo(new Image("blob-1", post));

        Mockito.verify(imageRepository).save(new Image("blob-1", post));
        Mockito.verify(postService).getById(1L);
        Mockito.verifyNoMoreInteractions(imageRepository, postService);
    }
}