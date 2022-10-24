package com.rifqimuhammadaziz.springtemplate.service.contract;

import com.rifqimuhammadaziz.springtemplate.model.entity.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    List<Post> findAll();
    Post findById(Long id);
    Post update(Post post, Long id);
    void deleteById(Long id);
}
