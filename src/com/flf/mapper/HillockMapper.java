package com.flf.mapper;

import com.flf.entity.Hillock;

import java.util.List;

public interface HillockMapper {
	int deleteHillock(Integer id);//删除岗位信息

    int insertHillock(Hillock hillock);//添加岗位信息

    List<Hillock> listPageHillock(Hillock hillock);//分页显示所有岗位信息
    
    List<Hillock> listAllHillock();//显示所有岗位信息

    int updateHillock(Hillock hillock);//修改催费信息

	Hillock getHillockbyId(Integer id);//根据id查询岗位信息
	
	List<Hillock> listHillockBydivisionId(int divisionId);  //根据部门id查询岗位集合
   
	int updateHillockJson(Hillock hillock);

	Hillock getHillockbyIdJson(Integer id);
	
	int deleteHillockJson(Integer id);

    int insertHillockJson(Hillock hillock);
}