package com.rifqimuhammadaziz.springtemplate.controller;

import com.rifqimuhammadaziz.springtemplate.service.contract.PostService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("Get All Posts");
        return ResponseEntity.ok(postService.findAll());
    }
}
