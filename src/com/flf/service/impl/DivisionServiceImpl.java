package com.flf.service.impl;

import java.util.List;

import javax.jws.WebService;

import net.sf.json.JSONObject;

import com.flf.entity.Division;
import com.flf.mapper.DivisionMapper;
import com.flf.service.DivisionService;
import com.flf.util.JsonUtil;
@WebService
public class DivisionServiceImpl implements DivisionService {
	
	private DivisionMapper divisionMapper;
	
	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
	}

	@Override
	public int deleteDivision(String id) {
		// TODO Auto-generated method stub
		return divisionMapper.deleteDivision(id);
	}

	@Override
	public int insertDivision(Division Division) {
		// TODO Auto-generated method stub
		
		
		return divisionMapper.insertDivision(Division); //添加 
	}

	@Override
	public List<Division> listPageDivision(Division Division) {
		// TODO Auto-generated method stub
		return divisionMapper.listPageDivision(Division);
	}

	@Override
	public List<Division> listAllDivision() {
		// TODO Auto-generated method stub
		return divisionMapper.listAllDivision();
	}

	@Override
	public Division getDivisionbyId(String id) {
		// TODO Auto-generated method stub
		return divisionMapper.getDivisionbyId(id);
	}

	@Override
	public int updateDivision(Division Division) {
		// TODO Auto-generated method stub
		return divisionMapper.updateDivision(Division);
	}

	@Override
	public String updateDivisionJson(String division) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(division);
		Division division2=(Division) JSONObject.toBean(json,Division.class);
		if(divisionMapper.updateDivision(division2)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}

	@Override
	public String getDivisionbyIdJson(String id) {
		// TODO Auto-generated method stub
		Division division=divisionMapper.getDivisionbyId(id);
		if(division!=null){
			JSONObject json=JSONObject.fromObject(division);
			return JsonUtil.success(json, false);
		}else{
			return JsonUtil.failure("failure", true);
		}
	}

	
	public String deleteDivisionJson(String id) {
		// TODO Auto-generated method stub
		try {			
			if(divisionMapper.deleteDivision(id)>0)
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
	public String insertDivisionJson(String division) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(division);
		Division division1=(Division) JSONObject.toBean(json,Division.class);
		if(divisionMapper.insertDivision(division1)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}

	
	public int deleteDivisionId(String id) {
		// TODO Auto-generated method stub
		return divisionMapper.deleteDivisionId(id);
	}

	@Override
	public List<Division> listPagedivision() {
		// TODO Auto-generated method stub
		Division division=new Division();
		List<Division> divisions = divisionMapper.listPageDivision(division);
		return divisions;
	}

	
	public Division getDivisionId(String id) {
		// TODO Auto-generated method stub
		Division division=divisionMapper.getDivisionbyId(id);
		return division;
	}

	@Override
	public List<Division> AllDivision() {
		// TODO Auto-generated method stub		
		return divisionMapper.listAllDivision();
	}

	@Override
	public void UpdateDivision(Division division) {
		// TODO Auto-generated method stub
		divisionMapper.updateDivision(division);
	}

	
	public void DeleteDivisionId(String id) {
		// TODO Auto-generated method stub
		divisionMapper.deleteDivisionId(id);
	}

	@Override
	public void AddDeal(Division division) {
		// TODO Auto-generated method stub
		divisionMapper.insertDivision(division);
	}


	public boolean isinitialize(String id) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Division division = divisionMapper.getDivisionbyId(id);
		if(division.getIsinitialize()!=null)
		{
			if(division.getIsinitialize()==1)
			{
				bool=true;
			}
		}
		return bool;
	}
	

	@Override
	public int updateDivisionisinitialize(String id) {
		// TODO Auto-generated method stub
		return divisionMapper.updateDivisionisinitialize(id);
	}
}
