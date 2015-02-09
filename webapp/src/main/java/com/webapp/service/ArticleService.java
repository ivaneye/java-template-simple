package com.webapp.service;

import com.webapp.domain.ArticleDomain;
import com.webapp.domain.PostDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    public List<ArticleDomain> list() {
        return new ArticleDomain().list();
    }

    public void save(ArticleDomain article) {
        article.insert();
    }

    public ArticleDomain selectById(String id) {
        if(id == null)return null;
        Long recId = Long.parseLong(id);
        return new ArticleDomain().selectByPrimaryKey(recId);
    }

    public void deleteById(Long recId) {
        new ArticleDomain().deleteByPrimaryKey(recId);
        new PostDomain().deleteByArtId(recId);
    }
}
