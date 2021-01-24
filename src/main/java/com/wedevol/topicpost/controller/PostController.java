package com.wedevol.topicpost.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedevol.topicpost.dao.PostRepository;
import com.wedevol.topicpost.model.Post;
import com.wedevol.topicpost.model.dto.PostDTO;
import com.wedevol.topicpost.service.PostService;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private PostService postService;

    // curl 'localhost:8080/posts/all'
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
    // curl 'localhost:8080/posts/list'
    @GetMapping(path = "/list")
    public @ResponseBody List<PostDTO> listPostTitlesAndTopics() {
        return postService.listPostTitlesAndTopics(1);
    }

}
