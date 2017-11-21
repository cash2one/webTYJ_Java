package com.flf.mapper;

import com.flf.entity.TcArticleGet;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TcArticleGetMapper {
    
    int deleteByPrimaryKey(String articleGetId);

    int insert(TcArticleGet record);

    int insertSelective(TcArticleGet record);

    TcArticleGet selectByPrimaryKey(String articleGetId);

    int updateByPrimaryKeySelective(TcArticleGet record);

    int updateByPrimaryKey(TcArticleGet record);
    
    List<TcArticleGet> listPageTArticleGets(TcArticleGet tArticleGet);//分页查询领取物品的信息
}