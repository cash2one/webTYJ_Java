package com.flf.mapper;

import com.flf.entity.TeamPermissions;

import java.util.List;

public interface TeamPermissionsMapper {
	int deleteTeamPermissions(String teamPermissionsid);  //根据核心岗位id删除信息

    int insertTeamPermissions(TeamPermissions teamPermissions); //插入核心岗位信息

    List<TeamPermissions> listPageTeamPermissions(TeamPermissions teamPermissions);//分页查询核心岗位信息
    
    List<TeamPermissions> listAllTeamPermissions(); //查询所有核心岗位信息

    TeamPermissions getTeamPermissionsbyId(String teamPermissionsid); //通过核心岗位id获取核心岗位信息

    int updateTeamPermissions(TeamPermissions teamPermissions);//更新核心岗位信息
    
    TeamPermissions isStaffPermissions(String projectId,String specialtyInfoId,String staffId);//判断员工权限
   
    //TeamPermissions getTeamPermissions(TeamPermissions teamPermissions); //通过核心岗位id获取核心岗位信息
    
    List<TeamPermissions> listAllTeamPermissionsStaff(); //查询所有项目专业线负责人

    List<TeamPermissions> getTeamPermissions(TeamPermissions teamPermissions); //通过核心岗位id获取核心岗位信息
    
    TeamPermissions getCorePositionByProjectAndSpecialty(TeamPermissions teamPermissions);//通过项目id,专业线id查询对应的核心岗位信息
    
    TeamPermissions checkPremissions(String projectId, String specialtyInfoId, String corePositionId);//通过项目id，专业线id，核心岗位id查询是否有操作权限
    
   List<TeamPermissions> getTeamPermissionsByTeamworkId(String teamworkId);//根据团队id
    
    int deleteTeamPermissionsByTeamworkId(String teamworkId);
}