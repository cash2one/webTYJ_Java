package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.HrAuthority;
import com.flf.entity.TUserPermissions;

public interface TUserPermissionsMapper {
    int deleteByTUserPermissions(Map map);

    int insert(TUserPermissions record);

    int insertSelective(TUserPermissions record);

    TUserPermissions selectByPrimaryKey(String rolePermissionsId);

    int updateByPrimaryKeySelective(TUserPermissions record);

    int updateByPrimaryKey(TUserPermissions record);
    
    List<TUserPermissions> listTUserPermissionsByuserId(String userId);
    
    int deleteTUserPermissions(TUserPermissions tUserPermissions);
    
    TUserPermissions getTUserPermissionBytUserId(String userId);
    
    /**
     * 根据用户id和权限id查询对应权限
     * 朱琪 2016.03.03
     * @param hrAuthority
     * @return List<TUserPermissions>
     */
    List<TUserPermissions> getTUserPermissionBytUserIdAndPermissionsId(Map map);
}