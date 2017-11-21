package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    //根据tuser查询结果
    TUser getReSultByTUser(TUser tUser);
    
    TUser getTUserbyLoginName(String loginName);
    
    //根据employId查询userId
    String getUserIdByEmployId(String staffId);
    
    //根据角色和员工查询用户信息
    List<TUser> findRoleAndStaffIdByUser(Map map);
    
    //修改工作人员权限
    int updateAccountForStatus(TUser tUser);
    
    String findAccountForStatusById(String userId);
    List<TUser> findUserByLoginNameAndCompanyId(TUser tUser);
}