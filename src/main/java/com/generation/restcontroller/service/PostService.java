package com.generation.restcontroller.service;

import com.generation.restcontroller.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post save(Post post);

    Post getPost(Long id);

    List<Post> getPosts();

    void delete(Long id);

}
