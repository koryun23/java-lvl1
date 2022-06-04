package com.aca.homework.week17.website;

import com.aca.homework.week17.website.facade.post.PostFacade;
import com.aca.homework.week17.website.facade.post.PostFacadeImpl;
import com.aca.homework.week17.website.facade.post.request.ImageUploadRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostCreationRequestDto;
import com.aca.homework.week17.website.facade.post.request.PostsRetrievalRequestDto;
import com.aca.homework.week17.website.facade.user.UserFacade;
import com.aca.homework.week17.website.facade.user.UserFacadeImpl;
import com.aca.homework.week17.website.facade.user.request.UserSignUpRequestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserFacade userFacade = context.getBean(UserFacadeImpl.class);
        PostFacade postFacade = context.getBean(PostFacadeImpl.class);

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
                List.of(new ImageUploadRequestDto("image-1-post-1", 1L),
                        new ImageUploadRequestDto("image-2-post-1", 1L),
                        new ImageUploadRequestDto("image-3-post-1", 1L),
                        new ImageUploadRequestDto("image-4-post-1", 1L),
                        new ImageUploadRequestDto("image-5-post-1", 1L)
                )
        )));
        System.out.println(postFacade.create(new PostCreationRequestDto(
                "post-2", "description-2", 1L,
                List.of(new ImageUploadRequestDto("image-1-post-2", 2L),
                        new ImageUploadRequestDto("image-2-post-2", 2L),
                        new ImageUploadRequestDto("image-3-post-2", 2L),
                        new ImageUploadRequestDto("image-4-post-2", 2L),
                        new ImageUploadRequestDto("image-5-post-2", 2L)
                )
        )));

        System.out.println(postFacade.uploadImage(new ImageUploadRequestDto("additional", 2L)));
        System.out.println(postFacade.getAllUserPosts(
                new PostsRetrievalRequestDto(
                        1L
                )
        ));
    }
}
