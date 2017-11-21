package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.flf.entity.HouseNew;
import com.flf.entity.Prepare;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.request.PrepareResult;
import com.flf.service.PrepareService;

/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */

public class PrepareServiceImpl implements PrepareService {
	
	private PrepareMapper prepareMapper;
	
	public PrepareMapper getPrepareMapper() {
		return prepareMapper;
	}

	public void setPrepareMapper(PrepareMapper prepareMapper) {
		this.prepareMapper = prepareMapper;
	}
		/**
		 * 编制表增删改查接口实现
		 */
	@Override
	public List<Prepare> listAllPrepare() {
		// TODO Auto-generated method stub
		return prepareMapper.listAllPrepare();
	}

	@Override
	public Prepare getUserByIdRest(String prepareId) {
		// TODO Auto-generated method stub
		return prepareMapper.getPreparebyId(prepareId);
	}

	@Override
	public void insertPreparerest(Prepare prepare) {
		// TODO Auto-generated method stub
		prepareMapper.insertPrepare(prepare);
	}

	@Override
	public void updatePreparerest(Prepare prepare) {
		// TODO Auto-generated method stub
		prepareMapper.updatePrepare(prepare);
	}

	@Override
	public void deletePreparerest(String prepareId) {
		// TODO Auto-generated method stub
		prepareMapper.deletePrepare(prepareId);
	}

	@Override
	public List<Prepare> getPreparebyteamworkId(String teamworkId) {
		// TODO Auto-generated method stub
		return prepareMapper.getPreparebyteamworkId(teamworkId);
	}

	@Override
	public List<Prepare> getPreparebyprojectId(String projectId) {
		// TODO Auto-generated method stub
		return prepareMapper.getPreparebyprojectId(projectId);
	}

	@Override
	public List<Prepare> listAllSearchPrepare(String projectId, String specialtyId) {
		// TODO Auto-generated method stub
		return prepareMapper.listAllSearchPrepare( projectId, specialtyId);
	}

	

}
