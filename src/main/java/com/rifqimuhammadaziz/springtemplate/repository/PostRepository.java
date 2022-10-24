package com.rifqimuhammadaziz.springtemplate.repository;

import com.rifqimuhammadaziz.springtemplate.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
