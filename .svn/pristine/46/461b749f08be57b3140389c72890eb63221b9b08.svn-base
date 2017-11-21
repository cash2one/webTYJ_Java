package com.flf.mapper;

import com.flf.entity.TcArticle;
import com.flf.entity.TcArticleState;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TcArticleStateMapper {
	
    int deleteByPrimaryKey(String articleStateId);

    int insert(TcArticleState record);

    int insertSelective(TcArticleState record);

    TcArticleState selectByPrimaryKey(String articleStateId);

    int updateByPrimaryKeySelective(TcArticleState record);

    int updateByPrimaryKey(TcArticleState record);
    
    List<TcArticleState>listPageTcArticleStates(TcArticleState tcArticleState);//根据传过来的遗失物品对象查看分页数据,查看未领取的拾取和遗失的集合
    
    List<TcArticleState>listAllTcArticleStates();//根据传过来的遗失物品对象查看分页数据,查看未领取的拾取和遗失的集合
    
    List<TcArticleState>listPageTcArticleGets(TcArticleState tcArticleState);//查询被领取物品的信息

	void updataState(String articleStateId);//将关系停用
	
	int listCounts(Integer state);//通过物品类型查看所剩数量
}