package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Component
public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);
    private final PostService postService;
    private final CatFactFetcherService catFactFetcherService;

    public PostFacadeImpl(PostService postService, CatFactFetcherService catFactFetcherService) {
        Assert.notNull(postService, "Post service should not be null");
        Assert.notNull(catFactFetcherService, "Cat fact fetcher service should not be null");
        this.postService = postService;
        this.catFactFetcherService = catFactFetcherService;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Assert.notNull(postId, "post id should not be null");
        Post postById = postService.getPostById(postId);
        return new PostDto(
                postById.getCreationDate(),
                postById.getFact(),
                postById.getCreatedBy()
        ); // TODO: CREATE A MAPPER WHICH MAPS A POSTDTO FROM POST
    }

    @Override
    public List<PostDto> getAllPosts() {
        LOGGER.info("Retrieving all post dtos");
        List<PostDto> postDtos = new LinkedList<>();
        List<Post> posts = postService.getAllPosts();
        for (Post post : posts) {
            postDtos.add(new PostDto(
                            post.getCreationDate(),
                            post.getFact(),
                            post.getCreatedBy()
                    )
            );
        }
        return postDtos;
    }

    @Override
    public void deletePostById(Long id) {
        postService.deletePostById(id);
    }

    @Override
    public PostDto uploadPost(PostUploadRequestDto dto) {
        Assert.notNull(dto, "Post upload request dto should not be null");
        LOGGER.info("Uploading a new post according to the post upload request dto - {}", dto);
        Post post = postService.create(new PostCreationParams(
                LocalDateTime.now(),
                catFactFetcherService.getRandomFact(),
                dto.getCreatedBy())
        );
        PostDto postDto = new PostDto(
                post.getCreationDate(),
                post.getFact(),
                post.getCreatedBy()
        );
        LOGGER.info("Successfully uploaded a new post according to the post upload request dto - {}, result - {}", dto, postDto);
        return postDto;
    }
}
