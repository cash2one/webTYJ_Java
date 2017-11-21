package com.flf.mapper;

import com.flf.entity.Division;
import com.flf.entity.Division;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DivisionMapper {
	int deleteDivision(String id);
/*
 * 部门表
 */
	/**
	 * 添加 
	 * @param division
	 * @return
	 */
	int insertDivision(Division division);  

    List<Division> listPageDivision(Division division);
    
    List<Division> listAllDivision();

    int updateDivision(Division division);

	Division getDivisionbyId(String id);
	
	int deleteDivisionId(String id);
	
	
	int updateDivisionJson(Division division);

	Division getDivisionbyIdJson(String id);
	
	int deleteDivisionJson(String id);

    int insertDivisionJson(Division division);
    
    int updateDivisionisinitialize(String id);
   
}