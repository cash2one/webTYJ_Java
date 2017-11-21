package com.flf.mapper;

import java.util.List;

import com.flf.entity.ClassesType;

public interface ClassesTypeMapper {
	
	 List<ClassesType> listClassesAll();  //查询所有的班次类型
	 ClassesType selectByPrimaryKey(String classesTypeId); //根据id查询班次类型
	 int deleteByPrimaryKey(String classesTypeId); //根据id删除班次类型
	 int insertClassesType(ClassesType classesType); //添加班次类型
	 int updateByPrimaryKey(ClassesType classesType); //修改班次类型
	 
}
