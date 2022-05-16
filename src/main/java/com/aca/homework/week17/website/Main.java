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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
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
                List.of(new ImageUploadRequestDto("abc", 1L, 0),
                        new ImageUploadRequestDto("abcd", 1L, 1),
                        new ImageUploadRequestDto("ab", 1L, 2),
                        new ImageUploadRequestDto("a", 1L, 3),
                        new ImageUploadRequestDto("asdfk", 1L, 4)
                )
        )));
        postFacade.create(new PostCreationRequestDto(
                "post-2", "description-2", 1L,
                List.of(new ImageUploadRequestDto("abc2", 2L, 0),
                        new ImageUploadRequestDto("abcd2", 2L, 1),
                        new ImageUploadRequestDto("ab2", 2L, 2),
                        new ImageUploadRequestDto("a2", 2L, 3),
                        new ImageUploadRequestDto("asdfk2", 2L, 4)
                )
        ));
        System.out.println(postFacade.getAllUserPosts(
                new PostsRetrievalRequestDto(
                        1L
                )
        ));
    }
}
