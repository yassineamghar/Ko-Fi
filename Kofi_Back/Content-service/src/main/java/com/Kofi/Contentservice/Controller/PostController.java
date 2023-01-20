package com.Kofi.Contentservice.Controller;


import com.Kofi.Contentservice.Dto.PostDTO;
import com.Kofi.Contentservice.Repository.PostRepository;
import com.Kofi.Contentservice.Service.PostService;
import com.Kofi.Contentservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }

    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Post> posts = postRepository.findAll(PageRequest.of(page, size));
        return posts.getContent();
    }

    @PostMapping("/posts")
    public void addPost(@RequestBody PostDTO postDTO) {
        postService.addPost(postDTO.getTitle(), postDTO.getContent(), postDTO.getId());
    }

}
