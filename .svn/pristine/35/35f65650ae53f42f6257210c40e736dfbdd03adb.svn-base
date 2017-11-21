package com.flf.service.impl;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import sun.misc.BASE64Decoder;

import com.flf.entity.ServiceObjectRecords;
import com.flf.mapper.ServiceObjectRecordsMapper;
import com.flf.service.ServiceObjectRecordsService;
import com.flf.util.JsonUtil;
/**
 * 服务对象记录表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
@WebService
public class ServiceObjectRecordsServiceImpl implements ServiceObjectRecordsService {
	
	private ServiceObjectRecordsMapper serviceObjectRecordsMapper;
	

	public ServiceObjectRecordsMapper getServiceObjectRecordsMapper() {
		return serviceObjectRecordsMapper;
	}

	public void setServiceObjectRecordsMapper(ServiceObjectRecordsMapper serviceObjectRecordsMapper) {
		this.serviceObjectRecordsMapper = serviceObjectRecordsMapper;
	}

	@Override
	public List<ServiceObjectRecords> listAllServiceObjectRecords() {
		// TODO Auto-generated method stub
		return serviceObjectRecordsMapper.listAllServiceObjectRecords();
	}

	@Override
	public ServiceObjectRecords getServiceObjectRecordsbyId(String recordId) {
		// TODO Auto-generated method stub
		return serviceObjectRecordsMapper.getServiceObjectRecordsbyId(recordId);
	}

	@Override
	public void insertServiceObjectRecords(ServiceObjectRecords serviceObjectRecords) {
		// TODO Auto-generated method stub
		serviceObjectRecordsMapper.insertServiceObjectRecords(serviceObjectRecords);
	}

	@Override
	public void updateServiceObjectRecords(ServiceObjectRecords serviceObjectRecords) {
		// TODO Auto-generated method stub
		serviceObjectRecordsMapper.updateServiceObjectRecords(serviceObjectRecords);
	}

	@Override
	public void deleteServiceObjectRecords(String recordId) {
		// TODO Auto-generated method stub
		serviceObjectRecordsMapper.deleteServiceObjectRecords(recordId);
	}

	@Override
	public ServiceObjectRecords getServiceObjectRecordsbyRequestAndStaff(
			String serviceId, String staffId) {
		
		return serviceObjectRecordsMapper.getServiceObjectRecordsbyRequestAndStaff(serviceId, staffId);
	}

	
}
