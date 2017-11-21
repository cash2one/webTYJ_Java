package com.flf.mapper;

import java.util.List;

import com.flf.entity.PersonEmphasis;

public interface PersonEmphasisMapper {
	
	List<PersonEmphasis>  listPagePersonEmphasis(PersonEmphasis personEmphasis);  //分页显示重点客户信息
	
	List<PersonEmphasis>  listPersonEmphasisBySta(int sta);  //按状态（0-待审核；1-审核通过；2-审核不通过）显示重点客户信息
	
	List<PersonEmphasis>  listAllPersonEmphasis();  //查询所有重点客户信息
	
	PersonEmphasis  selectPersonEmphasis(String emphasisId);  //根据id查询所有重点客户信息
	
	int deletePersonEmphasis(String emphasisId);  //根据id删除重点客户信息
	
	int insertPersonEmphasis(PersonEmphasis personEmphasis);  //新增重点客户信息
	
	int updatePersonEmphasis(PersonEmphasis personEmphasis);  //修改重点客户信息
	
	PersonEmphasis getPersonEmphasisDataByapprovalId(String approvalId);
	
	PersonEmphasis getPersonEmphasisData(String custId);
	
	PersonEmphasis getPersonEmphasisDataById(String custId);
	
	PersonEmphasis getPersonEmphasisState(String custId);
	
	int getPersonEmphasisSum(String theme);//查询重点客户申请数量
	int getFailPersonEmphasisSum(String theme);//查询重点客户失效申请数量
}