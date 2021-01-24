package com.wedevol.topicpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedevol.topicpost.dao.TopicRepository;
import com.wedevol.topicpost.model.Topic;

@Controller
@RequestMapping(path = "/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

}
