package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.TeamworkStaffRole;

public interface TeamworkStaffRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TeamworkStaffRole record);

    int insertSelective(TeamworkStaffRole record);

    TeamworkStaffRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeamworkStaffRole record);

    int updateByPrimaryKey(TeamworkStaffRole record);
    
    /**
     *查询是否有团队操作员权限
     * zhuqi 2016.03.23
     * @param staffId、roleId or teamworkId
     * @return int 
     */
    int findCountByMap(Map map);
    
    /**
     * 查询权限表和对应的团队人员信息
     * @param map staffId、roleId or teamworkId
     * @return List<TeamworkStaffRole>
     */
    List<TeamworkStaffRole> findTeamworkStaffRoleByMap(Map map);
}