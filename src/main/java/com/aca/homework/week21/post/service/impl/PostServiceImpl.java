package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.CatFactDto;
import com.aca.homework.week21.post.entity.CatFact;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.facade.PostDto;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.PostNotFoundException;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.PostUploadRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post getPostById(Long postId) {
        Assert.notNull(postId, "The post id should not be null");
        LOGGER.info("Retrieving a post having id of {}", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        LOGGER.info("Successfully retrieved a post with id - {}, result - {}", postId, post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        LOGGER.info("Retrieving all cat fact posts");
        List<Post> allPosts = postRepository.findAll();
        LOGGER.info("Successfully retrieved all posts, result - {}", allPosts);
        return allPosts;
    }

    @Override
    public void deletePostById(Long postId) {
        LOGGER.info("Deleting a post with id - {}", postId);
        postRepository.deleteById(postId);
        LOGGER.info("Successfully deleted a post with id - {}", postId);
    }

    @Override
    public Post uploadPost(PostUploadRequestDto dto) {
        Assert.notNull(dto, "post upload request dto should not be null");
        LOGGER.info("Uploading a new post according to the post upload request dto - {}", dto);
        CatFactDto catFactDto = dto.getCatFactDto();
        Post post = postRepository.save(new Post(dto.getCreationDate(), new CatFact(catFactDto.getFact(), catFactDto.getLength()), dto.getCreatedBy()));
        LOGGER.info("Successfully uploaded a new post according to post upload request dto - {}, result - {}", dto, post);
        return post;
    }
}
