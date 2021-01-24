package com.wedevol.topicpost.dao;

import org.springframework.data.repository.CrudRepository;
import com.wedevol.topicpost.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
