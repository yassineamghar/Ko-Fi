package com.Kofi.Contentservice.Service;


import com.Kofi.Contentservice.Repository.AccountRepository;
import com.Kofi.Contentservice.Repository.PostRepository;
import com.Kofi.Contentservice.model.Account;
import com.Kofi.Contentservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AccountRepository accountRepository;


    public void addPost(String title, String content, Long userId) {
        Account user = accountRepository.findById(userId).orElse(null);

        if (user == null) {
            System.out.println("user not found!!");
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
    }
}
