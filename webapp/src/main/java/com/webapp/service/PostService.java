package com.webapp.service;

import com.mybatis.mapper.PostMapper;
import com.mybatis.model.Post;
import com.mybatis.model.PostExample;
import com.webapp.util.AppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 15-1-15.
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public void save(Post post) {
        post.setStatus(1);
        post.setAddTime(new Date());
        post.setUpdateTime(new Date());
        post.setUserId(AppContext.getUser().getRecId());
        postMapper.insert(post);
    }

    public List<Post> selectByArtId(String id) {
        if (id == null) return null;
        Long artId = Long.parseLong(id);
        PostExample e = new PostExample();
        e.createCriteria().andArtIdEqualTo(artId);
        return postMapper.selectByExample(e);
    }
}
