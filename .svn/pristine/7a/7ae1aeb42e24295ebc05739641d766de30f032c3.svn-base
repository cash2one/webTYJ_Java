package com.flf.mapper;

import java.util.List;

import com.flf.entity.Action;

public interface ActionMapper {
    int deleteByPrimaryKey(String actionId);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(String actionId);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
    
    List<Action> selectActionById(String roleId);
    //根据功能权限id获取操作权限id
    List<Action> selectActionByRoleId(String roleId);
} 