package com.wedevol.topicpost.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedevol.topicpost.model.Topic;
import com.wedevol.topicpost.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void updateTopic(Integer topicId, Topic updated) {
        System.out.println(updated);
        Topic topic = entityManager.find(Topic.class, topicId);
        System.out.println(topic);
        if (topic != null) {
            topic.setName(updated.getName());
            System.out.println("EXECUTED");
        } else {
            throw new RuntimeException("Error with " + topicId);
        }
        System.out.println("END");
    }

}
