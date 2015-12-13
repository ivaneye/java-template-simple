package com.mybatis.mapper;

import com.mybatis.model.Article;
import com.mybatis.model.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long recId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long recId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}