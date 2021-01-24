package com.wedevol.topicpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedevol.topicpost.dao.TopicRepository;
import com.wedevol.topicpost.model.Topic;
import com.wedevol.topicpost.service.TopicService;

@Controller
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    
    @Autowired
    private TopicService topicService;

    // curl 'localhost:8080/topics/all'
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
    
    // curl -X PUT -H 'Content-Type: application/json' -d '{"name":"football"}' localhost:8080/topics/1
    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Topic topic) {
        topic.setId(id);
        topicService.updateTopic(id, topic);
    }

}
