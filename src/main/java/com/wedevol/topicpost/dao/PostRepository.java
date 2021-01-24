package com.wedevol.topicpost.dao;

import org.springframework.data.repository.CrudRepository;
import com.wedevol.topicpost.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
