package com.flf.service.impl;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.ServiceRequestJournal;
import com.flf.mapper.ServiceRequestJournalMapper;
import com.flf.service.ServiceRequestJournalService;
/**
 * 服务请求日志表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@WebService
public class ServiceRequestJournalServiceImpl implements ServiceRequestJournalService {
	
	private ServiceRequestJournalMapper serviceRequestJournalMapper;
	

	public ServiceRequestJournalMapper getServiceRequestJournalMapper() {
		return serviceRequestJournalMapper;
	}

	public void setServiceRequestJournalMapper(ServiceRequestJournalMapper serviceRequestJournalMapper) {
		this.serviceRequestJournalMapper = serviceRequestJournalMapper;
	}

	@Override
	public List<ServiceRequestJournal> listPageServiceRequestJournal(
			ServiceRequestJournal serviceRequestJournal) {
		// TODO Auto-generated method stub
		return serviceRequestJournalMapper.listPageServiceRequestJournal(serviceRequestJournal);
	}

	@Override
	public List<ServiceRequestJournal> listAllServiceRequestJournal() {
		// TODO Auto-generated method stub
		return serviceRequestJournalMapper.listAllServiceRequestJournal();
	}

	@Override
	public ServiceRequestJournal getServiceRequestJournalbyId(String serviceRequestJournalId) {
		// TODO Auto-generated method stub
		return serviceRequestJournalMapper.getServiceRequestJournalbyId(serviceRequestJournalId);
	}

	@Override
	public void insertServiceRequestJournal(ServiceRequestJournal serviceRequestJournal) {
		// TODO Auto-generated method stub
		serviceRequestJournalMapper.insertServiceRequestJournal(serviceRequestJournal);
	}

	@Override
	public void updateServiceRequestJournal(ServiceRequestJournal serviceRequestJournal) {
		// TODO Auto-generated method stub
		serviceRequestJournalMapper.updateServiceRequestJournal(serviceRequestJournal);
	}

	@Override
	public void deleteServiceRequestJournal(String serviceRequestJournalId) {
		// TODO Auto-generated method stub
		serviceRequestJournalMapper.deleteServiceRequestJournal(serviceRequestJournalId);
	}

	
}
