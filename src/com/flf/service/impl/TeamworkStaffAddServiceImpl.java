package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.TeamworkStaffAdd;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.TeamworkStaffAddMapper;
import com.flf.service.TeamworkStaffAddService;

public class TeamworkStaffAddServiceImpl implements TeamworkStaffAddService {

	@Autowired
	TeamworkStaffAddMapper teamworkStaffAddMapper;

	@Override
	public int insertTeamworkStaff(TeamworkStaffAdd teamworkStaffSdd) {
		if(teamworkStaffSdd == null || teamworkStaffSdd.getStaffId()==null || teamworkStaffSdd.getTeamworkId()==null){
			return 0;
		}
		teamworkStaffSdd.setId(UUID.randomUUID().toString());
		int result = teamworkStaffAddMapper.insert(teamworkStaffSdd);
		return result;
	}

	@Override
	public int delTeamworkStaff(String teamworkId, String staffId) {
		return teamworkStaffAddMapper.deleteByTeamworkidStaffid(teamworkId, staffId);
	}

	@Override
	public List<TeamworkStaffAdd> listTeamworkStaffAdd(String staffId) {
		List<TeamworkStaffAdd> teamworkStaffAddList = new ArrayList<>();
		teamworkStaffAddList = teamworkStaffAddMapper.selectByStaffId(staffId);
		return teamworkStaffAddList;
	}
	
}
