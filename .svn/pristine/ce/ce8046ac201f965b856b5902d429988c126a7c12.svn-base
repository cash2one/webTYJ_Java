package com.flf.mapper;

import java.util.List;

import com.flf.entity.TRole;

public interface TRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
    
    TRole getTRoleByRoleType(String roleType);
    
    //查询所有数据
    List<TRole> selectAllTRole();
    
    //根据角色id查找角色类型
    String getRoleTypeByRoleId(String roleId);
}