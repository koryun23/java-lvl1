package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostService;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;

public class PostAdderCallable implements Callable<PostDto> {

    private final List<PostDto> postDtoList;
    private final CatFactFetcherService catFactFetcherService;
    private final String prefix;
    private final String creator;
    private final LocalDateTime creationDate;

    public PostAdderCallable(List<PostDto> postDtoList, CatFactFetcherService catFactFetcherService, String prefix, String creator, LocalDateTime creationDate) {
        this.postDtoList = postDtoList;
        this.catFactFetcherService = catFactFetcherService;
        this.prefix = prefix;
        this.creator = creator;
        this.creationDate = creationDate;
    }

    @Override
    public PostDto call() {
        PostDto postDto = new PostDto(
                creationDate,
                prefix + catFactFetcherService.getRandomFact(),
                creator
        );
        postDtoList.add(postDto);
        return postDto;
    }
}
