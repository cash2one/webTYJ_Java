package com.flf.mapper;

import java.util.List;

import com.flf.entity.Caraccesscard;
import com.flf.entity.Entrance;
import com.flf.entity.Search;

public interface EntranceMapper {
	/*
	 * t_entrance 
	 */
	List<Entrance> listPageEntrance(Entrance entrance);//分页条件查询门禁卡信息
	List<Entrance> listAllEntrance();//查询所有门禁卡
	Entrance getEntrance(String cardId);//通过门禁卡id查询门禁卡信息
	int updateEntrance(Entrance entrance);//更新门禁卡信息
	int insertEntrance(Entrance entrance);//添加门禁卡信息
	int deleteEntranceById(String cardId);//删除门禁卡信息
	int updateEntranceByIdAndReturn(String cardId);//退还门禁卡
	int updateEntranceByIdAndLost(String cardId);//挂失门禁卡
	List<Entrance> listEntranceByHouseId(String houseId);  //ͨ通过房屋id查询门禁卡信息
	
	List<Entrance> listSearchEntrance(Search search);//物业服务搜索门禁卡
	
	int updateEntranceById(String cardId);  //更换״̬
	List<Entrance> listSearchEntranceAu(Search search);
	
	List<Entrance> listPageEntranceRestful(Entrance entrance);//分页查询门禁卡信息(通过办卡人和卡状态)
	
	List<Entrance> listPageEntranceByContion(Entrance entrance);//条件查询
	
	int getEntranceBycardNum(String cardNum);//根据门禁卡号查询数据库中是否已存在此卡名称  王洲  2016.1.14
}