package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.dto.*;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.retrofit.service.core.CatFactFetcherService;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import com.aca.homework.week21.post.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Component
public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);
    private final PostService postService;
    private final CatFactFetcherService catFactFetcherService;

    @Value("${bulk.post.prefix}")
    private String factPrefix;

    public PostFacadeImpl(PostService postService, CatFactFetcherService catFactFetcherService) {
        this.postService = postService;
        this.catFactFetcherService = catFactFetcherService;
    }

    @Override
    public UploadResponseDto upload(UploadRequestDto dto) {
        Assert.notNull(dto, "Posts upload request dto should not be null");
        LOGGER.info("Uploading {} post(s) according to the upload request dto - {}", dto.getCount(), dto);
        ExecutorService executorService = Executors.newCachedThreadPool();
        long numberOfPosts = dto.getCount();
        String creator = dto.getCreatedBy();
        List<PostDto> uploadedPosts = Collections.synchronizedList(new LinkedList<>());

        List<Callable<PostDto>> postCallableList = new LinkedList<>();

        for (int i = 0; i < numberOfPosts; i++) {
            postCallableList.add(new PostAdderCallable(uploadedPosts, catFactFetcherService, factPrefix, creator, LocalDateTime.now()));
        }

        List<Future<PostDto>> postDtoFutureList = new LinkedList<>();
        try {
            postDtoFutureList = executorService.invokeAll(postCallableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new UploadResponseDto("Could not upload post");
        }

        for (Future<PostDto> postDtoFuture : postDtoFutureList) {
            PostDto postDto;
            try {
                postDto = postDtoFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new UploadResponseDto("Could not upload post");
            }
            postService.create(new PostCreationParams(
                    postDto.getCreationDate(),
                    postDto.getContent(),
                    postDto.getCreatedBy()
            ));
        }

        executorService.shutdown();
        UploadResponseDto uploadResponseDto = new UploadResponseDto(uploadedPosts);
        LOGGER.info("Uploaded {} post(s) according to the upload request dto - {}, result - {}", dto.getCount(), dto, uploadResponseDto);
        return uploadResponseDto;
    }

    @Override
    public PostListRetrievalDto getPosts() {
        List<PostDto> postDtoList = new LinkedList<>();
        List<Post> postList = postService.getAllPosts();
        for (Post post : postList) {
            postDtoList.add(new PostDto(
                    post.getCreationDate(),
                    post.getContent(),
                    post.getCreatedBy()
            ));
        }
        return new PostListRetrievalDto(postDtoList);
    }

    @Override
    public SinglePostRetrievalDto getPostById(Long id) {
        Optional<Post> postOptional = postService.findPostById(id);
        if(postOptional.isEmpty()) {
            return new SinglePostRetrievalDto("Could not find a post with an id of " + id);
        }
        Post post = postOptional.get();
        return new SinglePostRetrievalDto(new PostDto(
                post.getCreationDate(),
                post.getContent(),
                post.getCreatedBy()
        ));
    }

    @Override
    public PostDeletionResponseDto deletePostById(Long id) {
        try {
            postService.deletePostById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            PostDeletionResponseDto postDeletionResponseDto = new PostDeletionResponseDto(id, false, String.format("Post with an id of %d does not exist. ", id));
            LOGGER.info("POST DELETION RESPONSE DTO - {}", postDeletionResponseDto);
            return postDeletionResponseDto;
        }
        PostDeletionResponseDto postDeletionResponseDto = new PostDeletionResponseDto(id, true);
        LOGGER.info("POST DELETION RESPONSE DTO - {}", postDeletionResponseDto);
        return postDeletionResponseDto;
    }
}
