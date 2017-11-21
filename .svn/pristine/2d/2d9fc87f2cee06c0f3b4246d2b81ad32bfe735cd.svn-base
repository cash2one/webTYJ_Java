package com.flf.mapper;

import com.flf.entity.LogType;
import com.flf.entity.LogType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogTypeMapper {
	/*分页查询日志类型表*/
	List<LogType> listPageLogType(LogType logType);
	
	/*查询所有日志类型表*/
	List<LogType> listAllLogType();
	
	/*根据id查询日志类型表*/
	LogType getLogTypeById(String logTypeId);
	
	/*新增日志类型表*/
    int insertLogType(LogType logType);
    
    /*修改日志类型表*/
    int updateLogType(LogType logType);

     /*删除日志类型表*/
    int deleteLogType(String logTypeId);
}