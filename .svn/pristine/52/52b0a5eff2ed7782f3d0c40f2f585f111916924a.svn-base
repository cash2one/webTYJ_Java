package com.flf.service.impl;

import java.util.HashMap;
import java.util.List;


import java.util.Map;

import net.sf.json.JSONObject;

import com.flf.entity.PageRestful;
import com.flf.entity.Lost;
import com.flf.entity.Search;
import com.flf.mapper.LostMapper;
import com.flf.service.LostService;


public class LostServiceImpl implements LostService{
	
	private LostMapper lostMapper;

	public LostMapper getLostMapper() {
		return lostMapper;
	}

	public void setLostMapper(LostMapper lostMapper) {
		this.lostMapper = lostMapper;
	}

	@Override
	public List<Lost> listAllLost() {
		// TODO Auto-generated method stub
		return lostMapper.listAllLost();
	}

	@Override
	public PageRestful listPageAllLost(Lost lost) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Lost> losts=lostMapper.listPageLost(lost);
		losts.add(0,null);
		pagerestful.setLosts(losts);
		pagerestful.setPage(lost.getPage());
		return pagerestful;
		//return lostMapper.listPageLost(lost);
	}

	@Override
	public Lost getLostById(String id) {
		// TODO Auto-generated method stub
		return lostMapper.getLostById(id);
	}

	@Override
	public int insertLost(Lost lost) {
		// TODO Auto-generated method stub
		return lostMapper.insertLost(lost);
	}

	@Override
	public int updateLost(Lost lost) {
		// TODO Auto-generated method stub
		return lostMapper.updateLost( lost);
	}

	/*@Override
	public PageRestful listPageLostRestful(Lost lost) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Lost> losts =lostMapper.listPageLost(lost);
		losts.add(0,null);
		pagerestful.setLosts(losts);
		pagerestful.setPage(lost.getPage());
		return pagerestful;
	}*/

	@Override
	public List<Lost> listAllLostRestful() {
		// TODO Auto-generated method stub
		List<Lost>losts=lostMapper.listAllLost();
		return losts;
	}

	@Override
	public Lost getLostByIdRestful(String id) {
		// TODO Auto-generated method stub
		return lostMapper.getLostById(id);
	}

	@Override
	public void deleteLostRestful(String id) {
		// TODO Auto-generated method stub
		lostMapper.deleteLost(id);
	}

	@Override
	public void insertLostRestful(Lost lost) {
		// TODO Auto-generated method stub
		lostMapper.insertLost(lost);
	}

	@Override
	public void updateLostRestful(Lost lost) {
		// TODO Auto-generated method stub
		lostMapper.updateLost( lost);
	}
	
	   /**
     * 创建by肖聪
     * 2015/8/3
     * 遗失物品领取
     * @param lost
     */

	@Override
	public void updateLostClaim(Lost lost) {
		// TODO Auto-generated method stub
		lostMapper.updateLostClaim( lost);
	}
	
	 /**
     * 创建by 肖聪
     * 2015/8/3
     * 物品遗失更据条件查询
     * @param lost
     * @return
     */

	@Override
	public List<Lost> listAllLostBySearch(Search search) {
		// TODO Auto-generated method stub
		return lostMapper.listAllLostBySearch(search);
	}

	@Override
	public List<Lost> listAllLostSearch(Search search) {
		// TODO Auto-generated method stub
		return lostMapper.listAllLostSearch(search);
	}

	@Override
	public List<Lost> listAllGetSearch(Search search) {
		// TODO Auto-generated method stub
		return lostMapper.listAllGetSearch(search);
	}

	@Override
	public List<Lost> listAllUpSearch(Search search) {
		// TODO Auto-generated method stub
		return lostMapper.listAllUpSearch(search);
	}

	@Override
	public List<Lost> listPageLost(Lost lost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listAllCount() {
		// TODO Auto-generated method stub
		Map<String,Integer> data = new HashMap<String, Integer>();
		int lostPick=lostMapper.countLostByState(0);
		int lostLose=lostMapper.countLostByState(1);
		int lostGet=lostMapper.countLostByState(2);
		data.put("lostPick",lostPick);
		data.put("lostWait",lostLose-lostGet>=0?lostLose-lostGet:0);
		return JSONObject.fromObject(data).toString();
	}  
}
