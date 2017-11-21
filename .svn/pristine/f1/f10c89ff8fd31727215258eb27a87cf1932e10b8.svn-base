package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.TUserRole;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(Map map);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
    
    /**
     * 根据角色id查询数据
     * @param roleId
     * @return
     */
    List<TUserRole> listTUserRoleByRoleId(String roleId);
    
    /**
     * 根据用户id修改角色id
     * @param userId
     * @return
     */
    int updateRoleIdByUserId(TUserRole tUserRole);
    
    List<TUserRole> listPageAdmin(TUserRole tUserRole);
    
    /**
     * 根据用户id查询关联的角色类型
     * @param userId
     * @return
     */
    TUserRole getTURbyUserId(String userId);
    
    /**
     * 根据角色id或用户id查询表
     * 朱琪 2016.03.02
     * @param map
     * @return
     */
    List<TUserRole> getTUserRoleByMap(Map map);
    
   /**
    *  根据staffid获取角色关联信息
    *  朱琪 2016.03.02
    * @param map
    * @return
    */
    List<TUserRole> getTURByStaffId(Map map);
    
}