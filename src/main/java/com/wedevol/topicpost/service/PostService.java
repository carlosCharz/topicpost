package com.wedevol.topicpost.service;

import java.util.List;
import com.wedevol.topicpost.model.dto.PostDTO;

public interface PostService {
    
    List<PostDTO> listPostTitlesAndTopics(int pageNumber);

}
