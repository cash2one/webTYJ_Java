package com.flf.service.impl;

import java.util.List;

import javax.jws.WebService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.Hillock;
import com.flf.mapper.HillockMapper;
import com.flf.service.HillockService;
import com.flf.util.JsonUtil;
@WebService
public class HillockServiceImpl implements HillockService {
	
	private HillockMapper hillockMapper;
	
	public HillockMapper getHillockMapper() {
		return hillockMapper;
	}

	public void setHillockMapper(HillockMapper hillockMapper) {
		this.hillockMapper = hillockMapper;
	}

	@Override
	public int deleteHillock(Integer id) {
		// TODO Auto-generated method stub
		return hillockMapper.deleteHillock(id);
	}

	@Override
	public int insertHillock(Hillock hillock) {
		// TODO Auto-generated method stub
		return hillockMapper.insertHillock(hillock);
	}

	@Override
	public List<Hillock> listPageHillock(Hillock hillock) {
		// TODO Auto-generated method stub
		return hillockMapper.listPageHillock(hillock);
	}

	@Override
	public List<Hillock> listAllHillock() {
		// TODO Auto-generated method stub
		return hillockMapper.listAllHillock();
	}

	@Override
	public Hillock getHillockbyId(Integer id) {
		// TODO Auto-generated method stub
		return hillockMapper.getHillockbyId(id);
	}

	@Override
	public int updateHillock(Hillock hillock) {
		// TODO Auto-generated method stub
		return hillockMapper.updateHillock(hillock);
	}

	
	@Override
	public List<Hillock> listHillockBydivisionId(int divisionId) {
		
		return hillockMapper.listHillockBydivisionId(divisionId);
	}

	@Override
	public String listHillockBydivision(int divisionId) {
		List<Hillock> hillocks= hillockMapper.listHillockBydivisionId(divisionId);
		if (hillocks.size()>0) {
			JSONArray json=JSONArray.fromObject(hillocks);
			return JsonUtil.success(json, false);
		}else{
			return JsonUtil.failure("failure", true);
		}
	}

	@Override
	public String updateHillockJson(String hillock) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(hillock);
		Hillock hillock2=(Hillock) JSONObject.toBean(json,Hillock.class);
		if(hillockMapper.updateHillock(hillock2)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}

	@Override
	public String getHillockbyIdJson(Integer id) {
		// TODO Auto-generated method stub
		Hillock hillock=hillockMapper.getHillockbyId(id);
		if(hillock!=null){
			JSONObject json=JSONObject.fromObject(hillock);
			return JsonUtil.success(json, false);
		}else{
			return JsonUtil.failure("failure", true);
		}
	}

	@Override
	public String deleteHillockJson(Integer id) {
		// TODO Auto-generated method stub
		try {			
			if(hillockMapper.deleteHillock(id)>0)
			{
			return JsonUtil.success("success", true);
			}else{
				return JsonUtil.failure("failure", true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.failure("failure", true);
		}
	}

	@Override
	public String insertHillockJson(String hillock) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(hillock);
		Hillock hillock1=(Hillock) JSONObject.toBean(json,Hillock.class);
		if(hillockMapper.insertHillock(hillock1)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}

	@Override
	public void AddHillock(Hillock hillock) {
		hillockMapper.insertHillock(hillock);
		
	}

	@Override
	public void UpdateHillockById(Hillock hillock) {
		// TODO Auto-generated method stub
		hillockMapper.updateHillock(hillock);
		
	}

	@Override
	public void DeleteHillockById(Integer id) {
		// TODO Auto-generated method stub
		hillockMapper.deleteHillock(id);
		
	}

}
