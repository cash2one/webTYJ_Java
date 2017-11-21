package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.ChargeType;
import com.flf.entity.ChargeTypeDetails;
import com.flf.entity.PageRestful;
import com.flf.entity.Product;
import com.flf.mapper.ChargeTypeDetailsMapper;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.request.Info;
import com.flf.service.ChargeTypeService;
import com.flf.util.Tools;

import net.sf.json.JSONObject;
/**
 * 
 * @author maogaofei
 * @date 2016年6月28日 下午2:11:20
 */
public class ChargeTypeServiceImpl implements ChargeTypeService {
	Map<String,String> map=new HashMap<String,String>();
	private ChargeTypeMapper chargeTypeMapper;
	
	@Autowired
	private ChargeTypeDetailsMapper chargeTypeDetailsMapper;

	public ChargeTypeMapper getChargeTypeMapper() {
		return chargeTypeMapper;
	}

	public void setChargeTypeMapper(ChargeTypeMapper chargeTypeMapper) {
		this.chargeTypeMapper = chargeTypeMapper;
	}

	@Override
	public List<ChargeType> listAllChargeType(ChargeType chargeType) {
		List<ChargeType>  chargeTypeList = chargeTypeMapper.listAllChargeType(chargeType);
		return chargeTypeList;
	}


	@Override
	public ChargeType getChargeTypeById(String chargeTypeId) {
		return chargeTypeMapper.selectByPrimaryKey(chargeTypeId);
	}
	
	@Override
	public List<ChargeType> getChargeTypeProjectId(String projectId) {
		List<ChargeType> list = chargeTypeMapper.getChargeTypeProjectId(projectId);
		return list;
	}


	@Override
	public String addChargeType(ChargeType chargeType) {
		//取出收费项目名称
		String name=chargeType.getChargeTypeName();
		ChargeType _name;
		String projectId=chargeType.getProjectId();
		_name=chargeTypeMapper.selectByName2(name,projectId);
		
		
		//判断收费项目名称是否存在
		if(_name!=null)
		{
			map.put("code","0");
		    return JSONObject.fromObject(map).toString();
		}
		else
		{
			//生成ID		
			String chargetypeid=UUID.randomUUID().toString();
			//设置ID
			chargeType.setChargeTypeId(chargetypeid);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(new Date());
			
			chargeType.setCreateTime(date);
			
			if (chargeType.getChargetypedetailslist() != null&& chargeType.getChargetypedetailslist().size() > 0) 
			{
				for (ChargeTypeDetails ad : chargeType.getChargetypedetailslist()) 
				{
					ad.setChargeTypeDetailsId(UUID.randomUUID().toString());
					ad.setChargeTypeId(chargetypeid);
					ad.setCreateTime(date);
					ad.setUpdateTime(date);
					chargeTypeDetailsMapper.insertSelective(ad);
				}
			}
		    chargeTypeMapper.insertSelective(chargeType);
		    map.put("code","1");
		    return JSONObject.fromObject(map).toString();
		}
	}


	@Override
	public void changeState(String chargeTypeId) {	
			chargeTypeMapper.changeState(chargeTypeId);			
		}


	@Override
	public String editChargeType(ChargeType chargeType) {
		
		String chargetypeid=chargeType.getChargeTypeId();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());
		chargeType.setUpdateTime(time);
		
		if (chargeType.getChargetypedetailslist() != null&& chargeType.getChargetypedetailslist().size() > 0) {
			for (ChargeTypeDetails ad : chargeType.getChargetypedetailslist()) {
				if(ad.getChargeTypeDetailsId()!=null){
					ad.setUpdateTime(time);
					chargeTypeDetailsMapper.updateByPrimaryKeySelective(ad);
				}
				else{
					ad.setCreateTime(time);
					ad.setUpdateTime(time);
					ad.setChargeTypeId(chargetypeid);
					ad.setChargeTypeDetailsId(UUID.randomUUID().toString());
					chargeTypeDetailsMapper.insertSelective(ad);
				}	
			}
		}
		ChargeTypeDetails temp=new ChargeTypeDetails();
		temp.setChargeTypeDetailsId(UUID.randomUUID().toString());
		temp.setChargeTypeId(chargetypeid);
		temp.setUpdateTime(time);
		chargeTypeDetailsMapper.deleteTimeId(temp);
		chargeTypeMapper.updateByPrimaryKeySelective(chargeType);
		
		map.put("time",time);
	    return JSONObject.fromObject(map).toString();
		
	}


	@Override
	public PageRestful listPageChargeType(ChargeType chargeType) {
		PageRestful pageRestful = new PageRestful();
		List<ChargeType> chargetypes = chargeTypeMapper.listPageChargeType(chargeType);
		chargetypes.add(0, null);
		pageRestful.setChargetypes(chargetypes);
		pageRestful.setPage(chargeType.getPage());
		return pageRestful;
	}


	@Override
	public List<ChargeType> getPriority(String productId) {
		List<ChargeType> list=chargeTypeMapper.getPriority(productId);
		return list;
	}

	@Override
	public String getCode() {
		ChargeType temp=chargeTypeMapper.getCode();
		String str=temp.getChargeTypeNum();
		return str;
	}

	@Override
	public String selectStateById(String chargeTypeId) {
		ChargeType temp=chargeTypeMapper.selectStateById(chargeTypeId);
		String data=temp.getChargeTypeStatus();
		return data;
	}




	@Override
	public int checkEditName(String name, String id,String projectId) {
		ChargeType _name;
		_name=chargeTypeMapper.selectByName(name,id,projectId);
		if(_name!=null)
		{
			return 1;
		}
		else{
			return 0;
		}
	}

	@Override
	public int checkNewName(String name,String projectId) {
		ChargeType _name;
		_name=chargeTypeMapper.selectByName2(name,projectId);
		if(_name!=null)
		{
			return 1;
		}
		else{
			return 0;
		}
	}




	


	
	
	
	
	

}