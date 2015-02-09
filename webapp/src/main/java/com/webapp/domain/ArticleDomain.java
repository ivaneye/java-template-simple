package com.webapp.domain;

import com.mybatis.model.Article;
import com.mybatis.model.ArticleExample;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class ArticleDomain extends Article<ArticleDomain> {

    public List<ArticleDomain> list() {
        ArticleExample e = new ArticleExample();
        return this.selectByExample(e);
    }
}
