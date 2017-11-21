package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.HrAuthority;
import com.flf.entity.TUserPermissions;

public interface HrAuthorityMapper {
    int deleteByPrimaryKey(String authorityId);

    int insert(HrAuthority record);

    int insertSelective(HrAuthority record);

    HrAuthority selectByPrimaryKey(String authorityId);

    int updateByPrimaryKeySelective(HrAuthority record);

    int updateByPrimaryKey(HrAuthority record);
    
    List<HrAuthority> listAuthorityByuserId(String tUserId);
    
    int deleteHrAuthority(HrAuthority hrAuthority);
    
    List<HrAuthority>listProjectHrAuthoritysByUserId(String userId);//通过用户查询此用户关联的项目信息
    
    List<HrAuthority>listTeamHrAuthoritysByUserId(String userId);//通过用户查询此用户关联的团队信息
    
    List<HrAuthority>listAuthorityForPower(String userId);//通过用户id查询用户功能权限
    
    List<HrAuthority> selectHrAuthorityByUserIdAndTeamId(HrAuthority hrAuthority);//通过用户id和团队id查询记录
    
    HrAuthority ifOderToAuthorityByuserId(String userId);//查询帐号是否有操作团队的权限

	void deleteAuthrityByUserId(String userId,Integer type); //通过用户id删除所有的hr权限信息
	
	int deleteAuthrityByUserIdTeamworkStaffId(String userId,Integer type, String teamworkId);
	
	List<HrAuthority> getHrAuthorityByUserId(String userId);//通过用户id获取用户团队信息
	
	/**
	 * 查询数据
	 * zhuqi 2016.03.10
	 * @param map
	 * @return List<HrAuthority>
	 */
	List<HrAuthority> getTUserPermissionByMap(Map map); 
	
	/**
	 * 查询hrAuthority通过StaffId和hrAuthority
	 * zhuqi 2016.03.25
	 * @param hrAuthority
	 * @return
	 */
	HrAuthority getAllByHrAuthority(HrAuthority hrAuthority);
    
}