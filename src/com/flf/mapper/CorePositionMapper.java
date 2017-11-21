package com.flf.mapper;

import com.flf.entity.CorePosition;



import java.util.List;
public interface CorePositionMapper {
	int deleteCorePosition(String corePositionid);  //根据核心岗位id删除信息

    int insertCorePosition(CorePosition corePosition); //插入核心岗位信息

    List<CorePosition> listPageCorePosition(CorePosition corePosition);//分页查询核心岗位信息
    
    List<CorePosition> listAllCorePosition(); //查询项目经理信息

    CorePosition getCorePositionbyId(String corePositionid); //通过核心岗位id获取核心岗位信息

    int updateCorePosition(CorePosition corePosition);//更新核心岗位信息
    
    List<CorePosition> listCorePost(CorePosition corePosition);  // 查询核心岗位经理 
    
    List<CorePosition> getCorePositionBystaffId(String staffId);
    
    List<CorePosition> listAllCorePositionRes();//查询所有的核心岗位信息
    
    List<CorePosition> listAllCorePositionByCore(CorePosition corePosition);//查询所有的核心岗位信息模糊查询
    
    void  deleteCorePositionRes(String corePositionid);//根据核心岗位id删除核心岗位人员
}