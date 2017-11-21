package com.flf.mapper;

import java.util.List;

import com.flf.entity.AuthorizationProject;

public interface AuthorizationProjectMapper {
    int deleteByPrimaryKey(String authorizationProject);

    int insert(AuthorizationProject record);

    int insertSelective(AuthorizationProject record);

    AuthorizationProject selectByPrimaryKey(String authorizationProject);

    int updateByPrimaryKeySelective(AuthorizationProject record);

    int updateByPrimaryKey(AuthorizationProject record);
    
    List<AuthorizationProject> selectAllData();//查询所有的授权项目
    
    List<AuthorizationProject> getDataById(String authorizationId);
}