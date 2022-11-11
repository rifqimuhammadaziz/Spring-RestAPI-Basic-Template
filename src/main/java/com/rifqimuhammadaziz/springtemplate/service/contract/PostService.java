package com.rifqimuhammadaziz.springtemplate.service.contract;

import com.rifqimuhammadaziz.springtemplate.model.dto.PostRequestDTO;
import com.rifqimuhammadaziz.springtemplate.model.dto.PostResponseDTO;
import com.rifqimuhammadaziz.springtemplate.model.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostRequestDTO post);
    List<Post> findAll();
    Post findById(Long id);
    Post update(Post post, Long id);
    void deleteById(Long id);
}
