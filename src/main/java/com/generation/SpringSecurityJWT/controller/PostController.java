package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }


    @GetMapping("/{id}")
    public ArrayList<Post> findByUserId(@PathVariable Long id) {
        return (ArrayList<Post>) postService.findByUserId(id);
    }

}
