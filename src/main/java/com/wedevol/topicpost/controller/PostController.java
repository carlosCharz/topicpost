package com.wedevol.topicpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedevol.topicpost.dao.PostRepository;
import com.wedevol.topicpost.model.Post;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

}
