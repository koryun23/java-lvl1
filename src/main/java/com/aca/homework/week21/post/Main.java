package com.aca.homework.week21.post;

import com.aca.homework.week21.post.facade.PostFacade;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
//        CatFactFetcherService catFactWrapperService = new CatFactFetcherServiceImpl(
//                CatFactServiceFactory.getCatFactService(
//                        RetrofitFactory.getClient("https://catfact.ninja/")
//                )
//        );
//        System.out.println(catFactWrapperService.getRandomFact());
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        PostFacade postFacade = context.getBean(PostFacade.class);
    }
}
