package com.flf.service.impl;

import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.Log;
import com.flf.entity.LogType;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchLog;
import com.flf.entity.Staff;
import com.flf.entity.WaterMeterRecords;
import com.flf.mapper.LogMapper;
import com.flf.mapper.StaffMapper;
import com.flf.service.LogService;
import com.flf.service.LogTypeService;
import com.flf.util.JsonUtil;

public class LogServiceImpl implements LogService {
	
	private LogMapper logMapper;
	
	private LogTypeService logTypeService;
	
	private StaffMapper staffMapper;
	
	public StaffMapper getStaffMapper() {
		return staffMapper;
	}


	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	/*private LogMapper logMapper;

	public LogMapper getLogMapper() {
		return logMapper;
	}

	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	@Override
	public int deleteLog(Integer id) {
		// TODO Auto-generated method stub
		return logMapper.deleteLog(id);
	}

	@Override
	public int insertLog(Log log) {
		// TODO Auto-generated method stub
		return logMapper.insertLog(log);
	}

	@Override
	public List<Log> listPageLog(Log log) {
		// TODO Auto-generated method stub
		return logMapper.listPageLog(log);
	}

	@Override
	public List<Log> listAllLog() {
		// TODO Auto-generated method stub
		return logMapper.listAllLog();
	}

	@Override
	public Log getLogbyId(Integer id) {
		// TODO Auto-generated method stub
		return logMapper.getLogbyId(id);
	}

	@Override
	public int updateLog(Log log) {
		// TODO Auto-generated method stub
		return logMapper.updateLog(log);
	}

	@Override
	public String findLogByOrderId(int id) {
		
		List<Log> logs=  logMapper.findLogByOrderId(id);
		if(logs.size()>0)
			
		{	JSONArray json=JSONArray.fromObject(logs);
			return JsonUtil.success(json.toString(),false);
		}else
		{
			return JsonUtil.failure("failure", true);
		}
	}

	//--------------------------------------------------------//
	@Override
	public List<Log> listPagelog() {
		// TODO Auto-generated method stub
		return logMapper.listAllLog();
	}

	@Override
	public Log getLogByIdRest(Integer id) {
		// TODO Auto-generated method stub
		return logMapper.getLogbyId(id);
	}

	@Override
	public void AddLog(Log log) {
		// TODO Auto-generated method stub
		logMapper.insertLog(log);
	}

	@Override
	public void UpdateLog(Log log) {
		// TODO Auto-generated method stub
		logMapper.updateLog(log);
	}

	@Override
	public void DeleteLogById(Integer id) {
		// TODO Auto-generated method stub
		logMapper.deleteLog(id);
	}
	
	//--------------------------------------------------------//
*/
	/*
	  * <p>Title: insertLog</p>
	  * <p>Description: </p>
	  * @param log
	  * @return
	  * @see com.flf.service.LogService#insertLog(com.flf.entity.Log)
	  */
	
	
	public LogTypeService getLogTypeService() {
		return logTypeService;
	}



	public void setLogTypeService(LogTypeService logTypeService) {
		this.logTypeService = logTypeService;
	}



	public LogMapper getLogMapper() {
		return logMapper;
	}



	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}



	@Override
	public void insertLog(Log log) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();//生成UUID
		log.setLogTypeId(uuid);
		if(logMapper.insertLog(log)>0){
			LogType lt=new LogType();
			lt.setLogTypeId(log.getLogTypeId());
			lt.setLogTypeName("类型名");
			lt.setNote("备注");
			logTypeService.insertLogTypeRestful(lt);
			
		}
		//return logMapper.insertLog(log);
	}

	/**
	 * 多功能查询日志表信息
	 */

	@Override
	public PageRestful listPageLog(SearchLog searchLog) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Log> logs=logMapper.listPageLog(searchLog);
		logs.add(0,null);
		pageRestful.setLogs(logs);
		pageRestful.setPage(searchLog.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageWaterLog(SearchLog searchLog) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Log> logs=logMapper.listPageWaterLog(searchLog);
		for (Log item : logs) {
			if (item.getStaff()!=null) {
				Staff staff=staffMapper.findStaffBystaffId(item.getStaff());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setStaff(staff.getStaffName());
					}
				}
			}		
		}
		logs.add(0,null);
		pageRestful.setLogs(logs);
		pageRestful.setPage(searchLog.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageElectricityLog(SearchLog searchLog) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Log> logs=logMapper.listPageElectricityLog(searchLog);
		for (Log item : logs) {
			if (item.getStaff()!=null) {
				Staff staff=staffMapper.findStaffBystaffId(item.getStaff());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setStaff(staff.getStaffName());
					}
				}
			}
		}
		logs.add(0,null);
		pageRestful.setLogs(logs);
		pageRestful.setPage(searchLog.getPage());
		return pageRestful;
	}
	
	@Override
	public void insertWaterLog(Log log) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();//生成UUID
		log.setLogTypeId(uuid);
		if(logMapper.insertLog(log)>0){
			LogType lt=new LogType();
			lt.setLogTypeId(log.getLogTypeId());
			lt.setLogTypeName("水表抄表");
			lt.setNote("备注");
			logTypeService.insertLogTypeRestful(lt);
			
		}
	}
	
	@Override
	public void insertElectricityLog(Log log) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();//生成UUID
		log.setLogTypeId(uuid);
		if(logMapper.insertLog(log)>0){
			LogType lt=new LogType();
			lt.setLogTypeId(log.getLogTypeId());
			lt.setLogTypeName("电表抄表");
			lt.setNote("备注");
			logTypeService.insertLogTypeRestful(lt);
			
		}
	}

/**
 * 分页查询日志表信息
 */

/*	@Override
	public PageRestful listPageLog(Log log) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Log> logs=logMapper.listPageLog(log);
		pageRestful.setLogs(logs);
		pageRestful.setPage(log.getPage());
		return pageRestful;
	}*/
}
