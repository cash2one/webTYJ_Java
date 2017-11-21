package com.flf.mapper;

/*Created by Administrator on 2015/6/5. 
author:尹磊
修改时间：2015/6/5  修改人：尹磊 */

import com.flf.entity.ArticleRelease;
import com.flf.entity.Search;

import java.util.List;

public interface ArticleReleaseMapper {
	//删除放行条信息
	int deleteArticleRelease(String id);
	
	//新增放行条信息
    int insertArticleRelease(ArticleRelease articleRelease);
    
  //分页查询所有放行条信息
    List<ArticleRelease> listPageArticleRelease(ArticleRelease articleRelease);
    
  //查询所有放行条信息
    List<ArticleRelease> listAllArticleRelease(Search search);
    
  //根据id查询放行条信息
    ArticleRelease getArticleReleasebyId(String id);
    
  //修改放行条信息
    int updateArticleRelease(ArticleRelease articleRelease);
    
    //根据来办理人的id查询
    List<ArticleRelease> listAllArticleReleaseByPersonId(String personId);
    
    //分页查询所有放行条信息
    List<ArticleRelease> listPageArticleReleaseByPersonId(ArticleRelease articleRelease);
    //条件分页查询
    List<ArticleRelease> listPageArticleReleaseByContion(ArticleRelease articleRelease);
    //条件分页查询
    List<ArticleRelease> listPageArticleReleaseByCondition(Search search);

    /**
     * 根据客户id集合查询放行条记录
     * @param custIdList
     * @return
     */
	List<ArticleRelease> getArticleReleaseByCustIdList(List<String> custIdList);

	/**
	 * 家家客户端根据buildingStructureId查询放行条记录
	 * @param buildingStructureId
	 * @return
	 */
	List<ArticleRelease> getArticleReleaseByBuildingStructure(String buildingStructureId);
}