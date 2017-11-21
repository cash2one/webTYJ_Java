package com.flf.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import com.flf.entity.PageRestful;
import com.flf.entity.Produceprice;

import com.flf.mapper.ProducepriceMapper;
import com.flf.service.ProducepriceService;
import com.flf.util.JsonUtil;

public class ProducepriceServiceImpl implements ProducepriceService {

	private ProducepriceMapper producepriceMapper;
	
	public ProducepriceMapper getProducepriceMapper() {
		return producepriceMapper;
	}

	public void setProducepriceMapper(ProducepriceMapper producepriceMapper) {
		this.producepriceMapper = producepriceMapper;
	}

	@Override
	public List<String> listType() {
		// TODO Auto-generated method stub
		return producepriceMapper.listType();
	}
	
	@Override
	public List<Produceprice> listProducequotelistByType(String type) {
		// TODO Auto-generated method stub
		return producepriceMapper.listProducequotelistByType(type);
	}
	
	@Override
	public Produceprice getProducepriceById(int id) {
		// TODO Auto-generated method stub
		return producepriceMapper.producequotelistById(id);
	}
	
	@Override
	public PageRestful listPageProduceprice(Produceprice produceprice) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Produceprice> produceprices =producepriceMapper.listPageProduceprice(produceprice);
		produceprices.add(0,null);
		pagerestful.setProduceprices(produceprices);
		pagerestful.setPage(produceprice.getPage());
		return pagerestful;
	}

	@Override
	public String listProducepriceType() {
		List<Produceprice> listpro= producepriceMapper.listAllProduceprice();
		if(listpro.size()>0){
			JSONArray json=JSONArray.fromObject(listpro);
			return(JsonUtil.success(json, false));
		}else{
			return(JsonUtil.failure("failure", true));
		}
	}

	@Override
	public void AddProduceprice(Produceprice produceprice) {
		// TODO Auto-generated method stub
		producepriceMapper.insertProduceprice(produceprice);
		
	}

	@Override
	public void UpdateProducepriceById(Produceprice produceprice) {
		// TODO Auto-generated method stub
		producepriceMapper.updateByPrimaryKeySelective(produceprice);
		
	}

	@Override
	public void DeleteProducepriceById(Integer id) {
		// TODO Auto-generated method stub
		producepriceMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Produceprice> listAllProduceprice() {
		// TODO Auto-generated method stub
		return producepriceMapper.listAllProduceprice();
	}

	@Override
	public void UpdateStateById(int productId) {
		// TODO Auto-generated method stub
		producepriceMapper.UpdateStateById(productId);
	}

}
