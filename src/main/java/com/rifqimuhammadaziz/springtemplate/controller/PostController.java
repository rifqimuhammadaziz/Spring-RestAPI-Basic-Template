package com.rifqimuhammadaziz.springtemplate.controller;

import com.rifqimuhammadaziz.springtemplate.model.dto.PostRequestDTO;
import com.rifqimuhammadaziz.springtemplate.service.contract.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j // logging
@Validated // validate request
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Get All Posts", description = "API for get detail of all posts")
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts() {
        log.info("PostController::getAllPosts OK");
        return ResponseEntity.ok(postService.findAll());
    }

    @Operation(summary = "Save Post", description = "API for save of post")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<?> savePost(@RequestBody PostRequestDTO post) {
        log.info("PostController::savePosts request title : {}", post.getTitle());
        return ResponseEntity.ok(postService.createPost(post));
    }

    @Operation(summary = "Get Post By ID", description = "API for get detail of single post")
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPostByID(@PathVariable("id") Long postId) {
        log.info("PostController:getPostByID request id: {}", postId);
        return ResponseEntity.ok(postService.findById(postId));
    }


}
