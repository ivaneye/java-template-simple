package com.webapp.domain;

import com.mybatis.model.Post;
import com.mybatis.model.PostExample;
import com.webapp.util.AppContext;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 15-1-15.
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class PostDomain extends Post<PostDomain> {
    public void save() {
        this.setStatus(1);
        this.setAddTime(new Date());
        this.setUpdateTime(new Date());
        this.setUserId(AppContext.getUser().getRecId());
        this.insert();
    }

    public List<PostDomain> selectByArtId(Long artId) {
        PostExample e = new PostExample();
        e.createCriteria().andArtIdEqualTo(artId);
        return this.selectByExample(e);
    }

    public void deleteByArtId(Long artId) {
        PostExample e = new PostExample();
        e.createCriteria().andArtIdEqualTo(artId);
        this.deleteByExample(e);
    }
}
