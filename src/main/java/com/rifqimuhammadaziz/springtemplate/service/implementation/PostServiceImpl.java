package com.rifqimuhammadaziz.springtemplate.service.implementation;

import com.rifqimuhammadaziz.springtemplate.model.entity.Post;
import com.rifqimuhammadaziz.springtemplate.repository.PostRepository;
import com.rifqimuhammadaziz.springtemplate.service.contract.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
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
}
