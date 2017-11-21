package com.flf.mapper;

import java.util.List;

import com.flf.entity.Classes;

public interface ClassesMapper {
	List<Classes> listAllClasses();
	Classes getClassesById(String id);
	int insertClasses(Classes classes);
	int updateClasses(Classes classes);
	int deleteClasses(String id);
	int insertClassess(List<Classes> classess);
	int updateClassesState(Classes classes);//修改班次状态
	
	/**
	 * 根据岗位id查询班次并按岗位类型排序
	 * @param postId
	 * @return
	 */
	List<Classes> listClassesByPostIdAndOrderByPostTypeId(String postId);
}
