package com.webapp.service;

import com.mybatis.mapper.ArticleMapper;
import com.mybatis.mapper.PostMapper;
import com.mybatis.model.Article;
import com.mybatis.model.ArticleExample;
import com.mybatis.model.PostExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private PostMapper postMapper;

    public List<Article> list() {
        ArticleExample e = new ArticleExample();
        return articleMapper.selectByExample(e);
    }

    public void save(Article article) {
        articleMapper.insert(article);
    }

    public Article selectById(String id) {
        if (id == null) return null;
        Long recId = Long.parseLong(id);
        return articleMapper.selectByPrimaryKey(recId);
    }

    public void deleteById(Long recId) {
        articleMapper.deleteByPrimaryKey(recId);
        PostExample e = new PostExample();
        e.createCriteria().andArtIdEqualTo(recId);
        postMapper.deleteByExample(e);
    }
}
