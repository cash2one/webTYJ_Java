package com.flf.mapper;

import java.util.List;

import com.flf.entity.UnionpayCounterofferTotal;

public interface UnionpayCounterofferTotalMapper {
	// 插入所有信息
	int insertUnionpayCounterofferTotal(UnionpayCounterofferTotal unionpayCounterofferTotal);

	// 通过ID查询所有
	List<UnionpayCounterofferTotal> getUnionpayCounterofferTotalById(String unionpayCounterofferCotalId);

	// 分页查询所有信息
	List<UnionpayCounterofferTotal> listPageUnionpayCounterofferTotal(
			UnionpayCounterofferTotal unionpayCounterofferTotal);

	// 多条数据插入
	int inserts(List<UnionpayCounterofferTotal> unionpayCounterofferTotals);
	
	int updateOfferTotalState(UnionpayCounterofferTotal ucot);
	
	//删除回盘未确认文件记录
	int deleteByPrimaryKey(String unionpayCounterofferCotalId);
	
	//通过文件名查询是否有重复记录
	int selectFileCount(UnionpayCounterofferTotal counterofferTotal);

}