package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.PageRestful;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.service.AreaTypeNewService;
import com.flf.util.JsonUtil;

/**
 * 面积名称实现类
 * @author niming
 *
 */
public class AreaTypeNewServiceImpl implements AreaTypeNewService {
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	
	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	@Override
	public int deleteAreaTypeNew(String id) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.deleteAreaTypeNew(id);
	}
		
	@Override
	public int insertAreaTypeNew(AreaTypeNew areaType) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.insertAreaTypeNew(areaType);
	}
		
	@Override
	public List<AreaTypeNew> listPageAreaTypeNew(AreaTypeNew areaType) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.listPageAreaTypeNew(areaType);
	}
		
	@Override
	public List<AreaTypeNew> listAllAreaTypeNew() {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.listAllAreaTypeNew();
	}	
	
	@Override
	public AreaTypeNew getAreaTypeNewById(String id) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.getAreaTypeNewById(id);
	}
	
	@Override
	public int updateAreaTypeNew(AreaTypeNew areaType) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.updateAreaTypeNew(areaType);
	}
	
	@Override
	public String deleteAreaTypeNewCxf(String id) {
		// TODO Auto-generated method stub
		if(areaTypeNewMapper.deleteAreaTypeNew(id)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}
	
	@Override
	public String insertAreaTypeNewCxf(String areaType) {
		// TODO Auto-generated method stub
		AreaTypeNew obj=(AreaTypeNew) JSONObject.toBean(JSONObject.fromObject(areaType),AreaTypeNew.class);
		if(areaTypeNewMapper.insertAreaTypeNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}
	
	@Override
	public String listAllAreaTypeNewCxf() {
		// TODO Auto-generated method stub
		List<AreaTypeNew> areaTypes = areaTypeNewMapper.listAllAreaTypeNew();
		JSONArray json=JSONArray.fromObject(areaTypes);
		return JsonUtil.success(json,true);
	}	
	
	@Override
	public String getAreaTypeNewbyIdCxf(String id) {
		// TODO Auto-generated method stub
		AreaTypeNew areaType = areaTypeNewMapper.getAreaTypeNewById(id);
		JSONObject json = JSONObject.fromObject(areaType);
		return JsonUtil.success(json,true);
	}
	
	@Override
	public String updateAreaTypeNewCxf(String areaType) {
		// TODO Auto-generated method stub
		AreaTypeNew obj=(AreaTypeNew) JSONObject.toBean(JSONObject.fromObject(areaType),AreaTypeNew.class);
		if(areaTypeNewMapper.updateAreaTypeNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}
	
	@Override
	public List<AreaTypeNew> listAllAreaTypeNeweRestful() {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.listAllAreaTypeNew();
	}
	
	@Override
	public AreaTypeNew selectAreaTypeNewById(String id) {
		// TODO Auto-generated method stub
		return areaTypeNewMapper.getAreaTypeNewById(id);
	}
	
	@Override
	public int insertAreaTypeNewRestful(AreaTypeNew areaTypeNew) {
		// TODO Auto-generated method stub
		int count = areaTypeNewMapper.getAreaTypeNewAreaName(areaTypeNew.getAreaTypeName());
		if(count>0){
			return -1;
		}else{
			String uuid = UUID.randomUUID().toString();
			areaTypeNew.setId(uuid);
			areaTypeNew.setCreateTime(new Date());
			Integer result = areaTypeNewMapper.insertAreaTypeNew(areaTypeNew);
			return result;
		}
	}
	
	@Override
	public void updateArticleReleaserestRestful(AreaTypeNew areaTypeNew) {
		// TODO Auto-generated method stub
		areaTypeNewMapper.updateAreaTypeNew(areaTypeNew);
		
	}

	@Override
	public PageRestful listPageAreaTypeNewRestful(AreaTypeNew areaTypeNew) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<AreaTypeNew> areaTypeNews =areaTypeNewMapper.listPageAreaTypeNew(areaTypeNew);
		areaTypeNews.add(0,null);
		pagerestful.setAreaTypeNews(areaTypeNews);
		pagerestful.setPage(areaTypeNew.getPage());
		return pagerestful;
	}

}
