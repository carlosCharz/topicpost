package com.wedevol.topicpost.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedevol.topicpost.model.Post;
import com.wedevol.topicpost.model.dto.PostDTO;
import com.wedevol.topicpost.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private EntityManager entityManager;

    private int pageSize = 25; // In real life would be configurable

    @Override
    public List<PostDTO> listPostTitlesAndTopics(int pageNumber) {
        List<Post> posts = entityManager
                .createQuery("SELECT p FROM Post p JOIN FETCH p.topic")
                //.createQuery("SELECT p FROM Post p JOIN p.topic")
                //.createQuery("SELECT p FROM Post p")
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        System.out.println("Size: " + posts.size());
        
        List<PostDTO> result = new ArrayList<>(posts.size());
        
        for (Post post : posts) {
            System.out.println(post.getId());
            PostDTO postDto = new PostDTO();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setTopicName(post.getTopic().getName());
            result.add(postDto);
        }
        return result;
    }

}
