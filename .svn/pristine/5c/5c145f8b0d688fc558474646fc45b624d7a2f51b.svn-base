package com.flf.mapper;

import java.util.List;

import com.flf.entity.Authorization;
import com.flf.entity.Search;



public interface AuthorizationMapper {
	
	List<Authorization> listAuthorization();  //查询所有授权信息 
	int deleteByPrimaryKey(String authorizationId); //根据id删除授权信息
	Authorization selectByauthorizationId(String authorizationId); //根据id查询授权信息
	List<Authorization> selectByauthorizedId(String authorizedPersonid); //根据被授权人id查询授权信息
	int insert(Authorization authorization);  //  添加授权信息
	int updateByPrimaryKey(Authorization authorization);  //  修改授权信息
	int updateAuthorization(Authorization authorization);  //  修改授权信息
	List<Authorization> selectByauthorizedIdlease(String authorizedPersonid); //根据被授权人id查询授权信息
	
	List<Authorization> listAuthorizationAndHouse(String authorizedPersonid);//查询指定几个授权人的所有房产
	
	List<Authorization> listAuthorizationAndStall(String authorizedPersonid);//查询指定几个授权人的所有车位
	List<Authorization> listSearchAuthorization(Search search);
	
	List<Authorization> listPageAuthorization(Authorization authorization);//根据被授权人id分页查询授权信息
	
	List<Authorization> listAuthorizationByHouseId(String houseId);//根据房屋id查询出所有授权的历史记录
}