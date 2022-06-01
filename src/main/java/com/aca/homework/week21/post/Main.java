package com.aca.homework.week21.post;

import com.aca.homework.week21.post.dto.UploadRequestDto;
import com.aca.homework.week21.post.facade.PostFacade;
import com.aca.homework.week21.post.retrofit.factory.CatFactServiceFactory;
import com.aca.homework.week21.post.retrofit.factory.RetrofitFactory;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.retrofit.service.core.CatFactService;
import com.aca.homework.week21.post.retrofit.service.impl.CatFactFetcherServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
    }
}
