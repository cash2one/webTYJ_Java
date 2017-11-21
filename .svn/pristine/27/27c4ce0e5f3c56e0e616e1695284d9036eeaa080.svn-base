package com.flf.mapper;

import com.flf.entity.Prepare;

import java.util.List;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
public interface PrepareMapper {
	//删除编制信息功能
	int deletePrepare(String prepareId);

	//新增编制信息功能
    int insertPrepare(Prepare prepare);

    //分页查询所有编制信息功能
    List<Prepare> listPagePrepare(Prepare prepare);
    
    //查询所有编制信息功能
    List<Prepare> listAllPrepare();

    //根据id查询所有编制信息功能
    Prepare getPreparebyId(String prepareId);

    //修改编制信息功能
    int updatePrepare(Prepare prepare);
    
    //添加多个编制
    int insertListPrepare(List<Prepare> prepares);
    
    //根据团队id查询项目id
    List<Prepare> getPreparebyteamworkId(String teamworkId);
    
  //根据项目id查询编制信息
    List<Prepare> getPreparebyprojectId(String projectId);

	List<Prepare> listAllSearchPrepare(String projectId,String pecialtyId);    //根据专业线id和项目id查询编制结果集

	//List<Prepare> listAllSearchStaffB();   //查询SearchStaffB结果集

	Prepare getPreparebyIdone(String prepareId);
	
	int getMaxNumByProjectAndPostId(String projectId, String postId);//根据项目id和岗位id查询岗位在项目下的最大编制
	
	Prepare getPrepareByProjectIdAndPostId(String projectId, String postId);//根据项目id和岗位id查询编制信息  王洲  2016.1.29
}