package com.webapp.service;

import com.webapp.domain.PostDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 15-1-15.
 */
@Service
@Transactional
public class PostService {
    public void save(PostDomain domain) {
        domain.save();
    }

    public List<PostDomain> selectByArtId(String id) {
        if(id == null)return null;
        Long artId = Long.parseLong(id);
        return new PostDomain().selectByArtId(artId);
    }
}
