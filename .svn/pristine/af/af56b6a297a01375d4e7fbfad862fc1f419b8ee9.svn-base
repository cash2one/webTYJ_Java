package com.flf.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flf.entity.Log;
import com.flf.entity.SearchLog;
//日志表
public interface LogMapper {
	int deleteLog(Integer id);//删除日志信息

    int insertLog(Log log);//增加日志信息

   
    
    List<Log> listAllLog();

    Log getLogbyId(Integer id);//根据id查询日志信息

    int updateLog(Log log);//更新日志信息
    
    List<Log> findLogByOrderId(Integer id);
    
    int insertAccept(int workOrderId,Date date,String processingConditions);// 新增日志接受工单

    int insertAccept(Map map);// 新增日志接受工单
	 List<Log> listPageLog(Log log);//查找所有的日志信息
	
	/*int insertLog(Log log);*/
	
	List<Log> listPageLog(SearchLog searchLog);  //多条件查询日志表
	
	List<Log> listPageWaterLog(SearchLog searchLog);  //多条件查询水表日志表
	
	List<Log> listPageElectricityLog(SearchLog searchLog);  //多条件查询电表日志表
	
	/*List<Log> listPageLog(Log log); //分页查询日志表信息*/
}