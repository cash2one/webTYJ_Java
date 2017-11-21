package com.flf.mapper;

import java.util.List;

import com.flf.entity.TeamworkStaffAdd;

public interface TeamworkStaffAddMapper {
    int deleteByPrimaryKey(String id);

    int insert(TeamworkStaffAdd record);

    int insertSelective(TeamworkStaffAdd record);

    TeamworkStaffAdd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeamworkStaffAdd record);

    int updateByPrimaryKey(TeamworkStaffAdd record);
    
    int deleteByTeamworkidStaffid(String teamworkId, String staffId);
    
    List<TeamworkStaffAdd> selectByStaffId(String staffId);
    
    List<TeamworkStaffAdd> selectByTeamworkId(String teamworkId);
}