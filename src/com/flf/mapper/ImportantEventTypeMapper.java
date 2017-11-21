package com.flf.mapper;

import java.util.List;

import com.flf.entity.ImportantEventType;

public interface ImportantEventTypeMapper {
	
	int insertImportantEventType(ImportantEventType importantEventType);//添加重大事项类型
	int insertImportantEventTypeUUID(ImportantEventType importantEventType);//添加重大事项类型
	int updateImportantEventType(ImportantEventType importantEventType);//修改重大事项类型
	ImportantEventType getImportantEventTypebyId(String id);//根据id获取重大事项类型
	List<ImportantEventType> getAllImportantEventType();//获取所有的重大事项类型
	
	List<ImportantEventType> listPageImportantEventType(ImportantEventType importantEventType);//分页显示所有的重大事项类型
	
	List<ImportantEventType> getAllImportantEventTypes();//查询所有的重大事项类型 
}
