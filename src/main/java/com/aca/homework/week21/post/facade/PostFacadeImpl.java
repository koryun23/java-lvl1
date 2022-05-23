package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.CatFactDto;
import com.aca.homework.week21.post.CatFactFetcherService;
import com.aca.homework.week21.post.entity.CatFact;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.service.core.CatFactCreationParams;
import com.aca.homework.week21.post.service.core.CatFactService;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

@Component
public class PostFacadeImpl implements PostFacade {

    private CatFactFetcherService catFactFetcherService;
    private PostService postService;
    private CatFactService catFactService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    @Override
    public PostDto getPostById(Long postId) {
        Assert.notNull(postId, "the post id should not be null");
        Post post = postService.getPostById(postId);
        CatFact catFact = post.getFact();
        return new PostDto(post.getCreationDate(), new CatFactDto(catFact.getFact(), catFact.getLength()), post.getCreatedBy());
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postService.getAllPosts();
        List<PostDto> allPostDtos = new LinkedList<>();
        for(Post post : allPosts) {
            CatFact catFact = post.getFact();
            allPostDtos.add(new PostDto(
                    post.getCreationDate(),
                    new CatFactDto(catFact.getFact(), catFact.getLength()),
                    post.getCreatedBy()
            ));
        }
        return allPostDtos;
    }

    @Override
    public void deletePostById(Long id) {
        postService.deletePostById(id);
    }

    @Override
    public CatFactDto fetchCatFact() {
        LOGGER.info("Fetching a random cat fact");
        String randomFact = catFactFetcherService.getRandomFact();
        LOGGER.info("Successfully fetched a new random fact, result - {}", randomFact);
        return new CatFactDto(randomFact, randomFact.length());
    }

    @Override
    public PostDto uploadPost(PostUploadRequestDto dto) {
        CatFactDto catFactDto = dto.getCatFactDto();
        catFactService.create(new CatFactCreationParams(
                catFactDto.getFact(),
                catFactDto.getLength()
        ));
        Post post = postService.uploadPost(dto);

        CatFact fact = post.getFact();
        return new PostDto(
                post.getCreationDate(),
                new CatFactDto(fact.getFact(), fact.getLength()),
                post.getCreatedBy()
        );
    }
}
