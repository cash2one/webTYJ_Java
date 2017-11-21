package com.flf.service.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;

import com.flf.entity.Caraccesscard;
import com.flf.entity.Entrance;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.mapper.EntranceMapper;
import com.flf.request.Info;
import com.flf.service.EntranceService;
import com.flf.util.JsonUtil;
import com.flf.util.Tools;
@WebService

public  class EntranceServiceImpl implements EntranceService{
	private EntranceMapper entranceMapper;
	
	public EntranceMapper getEntranceMapper() {
		return entranceMapper;
	}
	public void setEntranceMapper(EntranceMapper entranceMapper) {
		this.entranceMapper = entranceMapper;
	}
	@Override
	public List<Entrance> listAllEntranceRest() {
		// TODO Auto-generated method stub
		return entranceMapper.listAllEntrance();
	}
	@Override
	public Entrance getEntranceRest(String cardId) {
		// TODO Auto-generated method stub
		return entranceMapper.getEntrance(cardId);
	}
	@Override
	public void insertEntranceRest(Entrance entrance) {
		// TODO Auto-generated method stub
		entranceMapper.insertEntrance(entrance);
	}
	@Override
	public void updateEntranceRest(Entrance entrance) {
		// TODO Auto-generated method stub
		entranceMapper.updateEntrance(entrance);
	}
	@Override
	public void deleteEntranceByIdRest(String cardId) {
		// TODO Auto-generated method stub
		entranceMapper.deleteEntranceById(cardId);
	}
	@Override
	public List<Entrance> listEntranceByCustcodeRest(String houseId) {
		// TODO Auto-generated method stub
		return entranceMapper.listEntranceByHouseId(houseId);
	}
	
	/**
	 * 修改 by 肖聪   
	 * 2015/6/18
	 * 更换门禁卡
	 */
	@Override
	public void updateEntranceByIdRest(Entrance entrance) {
		// TODO Auto-generated method stub
		/*entranceMapper.updateEntranceById(entrance.getCardId()); //�޸ľ��Ž�״̬Ϊ����
		entranceMapper.insertEntrance(entrance);  //�����µ��Ž���Ϣ
*/		
		entranceMapper.updateEntranceById(entrance.getCardId()); // 修改就停车门禁卡状态为禁用
		entrance.setCardNum(entrance.getNewCardNum());
		entrance.setCardState((byte) 1);
		entranceMapper.insertEntrance(entrance); // 创建新的停车门禁卡信息
	}
	
	/**
	 * 修改 by 肖聪   
	 * 2015/6/18
	 * 挂失门禁卡
	 */
	@Override
	public void updateEntranceByIdAndLost(String cardId) {
		// TODO Auto-generated method stub
		entranceMapper.updateEntranceByIdAndLost(cardId);
	}
	

	/**
	 * 修改 by 肖聪   
	 * 2015/6/18
	 * 挂失门禁卡
	 */
	@Override
	public void updateEntranceByIdAndReturn(String cardId) {
		// TODO Auto-generated method stub
		entranceMapper.updateEntranceByIdAndReturn(cardId);
	}
	
	@Override
	public List<Entrance>  listAllEntranceBySearch(Search search) {
		// TODO Auto-generated method stub
		return entranceMapper.listSearchEntrance(search);
	}
	
	 /**
	  * 创建by肖聪  2015/7/10
	  * 通过条件查询办理人和授权人的门禁卡信息
	  */
	@Override
	public List<Entrance> listSearchEntrancedAu(Search search) {
		// TODO Auto-generated method stub
		
		List<Entrance> entrances=entranceMapper.listSearchEntrance(search);
		List<Entrance> entranceone=entranceMapper.listSearchEntranceAu(search);
		
		entrances.addAll(entranceone);
		
		return entrances;
	}

	@Override
	public PageRestful listPageEntranceRestful(Entrance entrance){
		PageRestful pageRestful = new PageRestful();
		List<Entrance> entrances = entranceMapper.listPageEntranceRestful(entrance);
		entrances.add(0, null);
		pageRestful.setEntrances(entrances);
		pageRestful.setPage(entrance.getPage());
		return pageRestful;
	}
	@Override
	public PageRestful listPageEntranceByContion(Entrance entrance) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Entrance> entrances = entranceMapper.listPageEntranceByContion(entrance);
		entrances.add(0, null);
		pageRestful.setEntrances(entrances);
		pageRestful.setPage(entrance.getPage());
		return pageRestful;
	}
	
	/**
	 * 根据门禁卡号查询在数据库中是否已有相同对象
	 * 王洲
	 * 2016.1.14
	 */
	@Override
	public Info getEntranceBycardNum(String cardNum){
		int flag = entranceMapper.getEntranceBycardNum(cardNum);
		if(flag == 0){
			return Tools.msg("successed", true);
		}else{
			return Tools.msg("unsuccess", false);
		}
	}
}
