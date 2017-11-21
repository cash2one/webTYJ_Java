package com.flf.mapper;

import com.flf.entity.TcArticle;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TcArticleMapper {

    int deleteByPrimaryKey(String articleId);

    int insert(TcArticle record);

    int insertSelective(TcArticle record);

    TcArticle selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(TcArticle record);

    int updateByPrimaryKey(TcArticle record);
    
    List<TcArticle>listPageTcArticles(TcArticle tcArticle);//根据传过来的遗失物品对象查看分页数据,查看未领取的拾取和遗失的集合
    
    List<TcArticle>listAllTcArticles();//根据传过来的遗失物品对象查看分页数据,查看未领取的拾取和遗失的集合
    
    
}