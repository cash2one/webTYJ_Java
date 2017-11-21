package com.flf.service.impl;

import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.AreaNew;
import com.flf.entity.BuildingNew;
import com.flf.mapper.AreaNewMapper;
import com.flf.service.AreaNewService;
import com.flf.util.JsonUtil;

public class AreaNewServiceImpl implements AreaNewService {
	
	private AreaNewMapper areaNewMapper;

	public AreaNewMapper getAreaNewMapper() {
		return areaNewMapper;
	}

	public void setAreaNewMapper(AreaNewMapper areaNewMapper) {
		this.areaNewMapper = areaNewMapper;
	}

	/*
	  * <p>Title: listAllAreaNewByState</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.AreaNewService#listAllAreaNewByState()
	  */
	
	
	@Override
	public List<AreaNew> listAllAreaNewByState() {
		// TODO Auto-generated method stub
		return areaNewMapper.listAllAreaNew();
	}

	/*
	  * <p>Title: getAreaNewByIdRest</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.AreaNewService#getAreaNewByIdRest(java.lang.String)
	  */
	
	
	@Override
	public AreaNew getAreaNewByIdRest(String id) {
		// TODO Auto-generated method stub
		return areaNewMapper.getAreaNewById(id);
	}

	/*
	  * <p>Title: AddAreaNew</p>
	  * <p>Description: </p>
	  * @param AreaNew
	  * @see com.flf.service.AreaNewService#AddAreaNew(com.flf.entity.AreaNew)
	  */
	
	
	@Override
	public void AddAreaNew(AreaNew AreaNew) {
		// TODO Auto-generated method stub
		areaNewMapper.insertAreaNew(AreaNew);
	}

	/*
	  * <p>Title: UpdateAreaNew</p>
	  * <p>Description: </p>
	  * @param AreaNew
	  * @see com.flf.service.AreaNewService#UpdateAreaNew(com.flf.entity.AreaNew)
	  */
	
	
	@Override
	public void UpdateAreaNew(AreaNew AreaNew) {
		// TODO Auto-generated method stub
		areaNewMapper.updateAreaNew(AreaNew);
		
	}

	/*
	  * <p>Title: DeleteAreaNewById</p>
	  * <p>Description: </p>
	  * @param id
	  * @see com.flf.service.AreaNewService#DeleteAreaNewById(java.lang.String)
	  */
	
	
	@Override
	public void DeleteAreaNewById(String id) {
		// TODO Auto-generated method stub
		areaNewMapper.deleteAreaNew(id);
	}

	
	
	
	
	
	


	
}
