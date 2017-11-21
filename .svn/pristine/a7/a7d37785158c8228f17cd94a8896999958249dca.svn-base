package com.flf.mapper;

import java.util.List;

import com.flf.entity.Functional;



public interface FunctionalMapper {
	
	List<Functional> listPageFunctional(Functional functional);//分页查询功能区
	
	List<Functional> listFunctionalAll();//查询所有功能区
	
	Functional selectFunctionalById(String functionalId);//根据id查询功能区信息
	
    int insertFunctional(Functional functional); //添加功能区信息
    
    int updateFunctional(Functional functional);//修改功能区信息

    int deleteFunctional(String functionalId);//删除功能区信息
    
    int insertFunctionalUUID(Functional functional);//新增功能区间信息，不使用mysql的UUID
    
    int getCountByNoOrName(Functional functional);		//根据编号或者名称查询是否已存在
    
    String selectCustCode();//查询表中 组件最大的编号 
}