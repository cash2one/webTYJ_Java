package com.flf.mapper;

import java.util.List;

import com.flf.entity.Caraccesscard;
import com.flf.entity.Search;

public interface CaraccesscardMapper {
	/*
	 * t_car_access_card 门禁车辆卡表
	 */
	List<Caraccesscard> listPageCaraccesscard(Caraccesscard caraccesscard);
	List<Caraccesscard> listAllCaraccesscard();
	Caraccesscard getCaraccesscard(String id);
	Caraccesscard getParkbyId(String parkId);
	void updateCaraccesscard(Caraccesscard caraccesscard);
	void insertCaraccesscard(Caraccesscard caraccesscard);
	int deleteCaraccesscardById(String id);
	

	List<Caraccesscard> listCaraccesscardByCustcode(String houseId);  //通过房屋id查询所有与之关联的门禁卡
	List<Caraccesscard> listCaraccesscardByCustId(String custCode);  // 根据客户id查询车辆卡信息
	int updateCaraccesscardById(String cardId);  //通过id修改停车门禁卡状态
	
	List<Caraccesscard> getCaraccesscardByCardIdRest(String cardId);//根据车辆id查询欠费的停车卡
	int LossCaraccesscardById(String cardId);  // 根据停车卡号进行挂失处理
	
	int RefundCaraccessBycardId(String cardId);   // 根据停车卡号进行退卡处理
	
	 List<Caraccesscard> listSearchCaraccesscard(Search search);//物业服务搜索停车卡
	List<Caraccesscard> listSearchCaraccesscardAu(Search search);//通过条件查询出授权人停车卡信息
	List<Caraccesscard> listSearchCaraccesscardEX(Search search);// 通过条件查询外部专业线停车卡信息
	
	List<Caraccesscard> listPageCaraccesscardByCustCode(Caraccesscard caraccesscard);
	
	List<Caraccesscard> listPageCaraccesscardByContion(Caraccesscard caraccesscard);//通过条件查询停车卡信息
	
	List<Caraccesscard> listPageCaraccesscardBySearch(Caraccesscard caraccesscard);//通过条件查询停车卡信息
}