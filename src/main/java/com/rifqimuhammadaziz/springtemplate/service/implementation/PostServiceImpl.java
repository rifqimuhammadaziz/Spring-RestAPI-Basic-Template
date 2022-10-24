package com.rifqimuhammadaziz.springtemplate.service.implementation;

import com.rifqimuhammadaziz.springtemplate.model.entity.Post;
import com.rifqimuhammadaziz.springtemplate.service.contract.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public Post update(Post post, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
