package com.rifqimuhammadaziz.springtemplate.service.implementation;

import com.rifqimuhammadaziz.springtemplate.model.dto.PostRequestDTO;
import com.rifqimuhammadaziz.springtemplate.model.dto.PostResponseDTO;
import com.rifqimuhammadaziz.springtemplate.model.entity.Post;
import com.rifqimuhammadaziz.springtemplate.repository.PostRepository;
import com.rifqimuhammadaziz.springtemplate.service.contract.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private ModelMapper modelMapper;

//    private Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Override
    public Post createPost(PostRequestDTO postRequestDTO) {
        Post post = null;

        try {
            log.info("ProductService::createPost execution started.");
            post = modelMapper.map(postRequestDTO, Post.class);
            postRepository.save(post);
            log.debug("ProductService::createNewPost request parameters {}", post);
        } catch (Exception e) {
            log.error("PostService::createPost failed to save, Exception Message {}", e.getMessage());
        }

        return post;
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = null;
        try {
            log.info("PostService:findAll execution started");
            posts = postRepository.findAll();
            log.debug("PostService:findAll retrieving products from database {}", posts);
        } catch (Exception e) {
            log.error("Exception occurred while retrieving posts from database, Exception message {}", e.getMessage());
        }

        log.info("ProductService:findAll execution done");
        return posts;
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post update(Post post, Long id) {
        Post currentPost = postRepository.findById(id).get();
        currentPost.setTitle(post.getTitle());
        currentPost.setCategory(post.getCategory());
        currentPost.setBody(post.getBody());
        return postRepository.save(currentPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    // Convert Entity to Request DTO
    private PostRequestDTO mapRequestDTO(Post post) {
        PostRequestDTO postRequestDTO = modelMapper.map(post, PostRequestDTO.class);
        return postRequestDTO;
    }

    // Convert Request DTO to Response DTO
    private PostResponseDTO mapResponseDto(PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponseDTO = modelMapper.map(postRequestDTO, PostResponseDTO.class);
        return postResponseDTO;
    }
}
