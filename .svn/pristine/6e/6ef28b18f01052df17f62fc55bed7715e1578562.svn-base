package com.flf.mapper;

import java.util.List;

import com.flf.entity.PersonVip;


/**
 * 
  * @ClassName: vip客户Mapper
  * @Description: TODO
  * @author wangyong
  * @date 2015-6-17 下午3:17:55
  *
 */
public interface PersonVipMapper {
	
	List<PersonVip>  listPagePersonVip(PersonVip personVip);  //分页显示vip客户信息
	
	List<PersonVip>  listAllPersonVip();  //查询所有vip客户信息
	
	PersonVip  selectPersonVip(String emphasisId);  //根据id查询所有vip客户信息
	
	int deletePersonVip(String emphasisId);  //根据id删除vip客户信息
	
	int insertPersonVip(PersonVip personVip);  //新增vip客户信息
	
	int updatePersonVip(PersonVip personVip);  //修改vip客户信息
	
	List<PersonVip>  selectPersonVipbyState(Byte reviewState);  //根据审核状态所有vip客户信息
	
	PersonVip getPersonVipData(String custId);
	
	PersonVip getPersonVipDataById(String custId);
	
	PersonVip getPersonVipDataByapprovalId(String approvalId);
	
	PersonVip getPersonVipState(String custId);//得到客户的申请信息（校验用 2016-1-19）
	
	int getPersonVipSum(String theme);//查询vip客户申请
	int getFailPersonVipSum(String theme);//查询vip客户失效申请
}