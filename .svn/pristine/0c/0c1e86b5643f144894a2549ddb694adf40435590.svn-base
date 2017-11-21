package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.flf.entity.HandleMechanism;
import com.flf.entity.ImportantEventTypeJournal;
import com.flf.mapper.HandleMechanismMapper;
import com.flf.mapper.ImportantEventTypeJournalMapper;
import com.flf.service.HandleMechanismService;

public class HandleMechanismServiceImpl implements HandleMechanismService{
	
	private HandleMechanismMapper handleMechanismMapper;
	
	private ImportantEventTypeJournalMapper importantEventTypeJournalMapper;
	
	public ImportantEventTypeJournalMapper getImportantEventTypeJournalMapper() {
		return importantEventTypeJournalMapper;
	}
	public void setImportantEventTypeJournalMapper(
			ImportantEventTypeJournalMapper importantEventTypeJournalMapper) {
		this.importantEventTypeJournalMapper = importantEventTypeJournalMapper;
	}
	public HandleMechanismMapper getHandleMechanismMapper() {
		return handleMechanismMapper;
	}
	public void setHandleMechanismMapper(HandleMechanismMapper handleMechanismMapper) {
		this.handleMechanismMapper = handleMechanismMapper;
	}
	@Override
	public void updateHandleMechanism(HandleMechanism handleMechanism) {
		// TODO Auto-generated method stub
		handleMechanism.setCreateTime(new Date());
		handleMechanismMapper.updateHandleMechanism(handleMechanism);
	}
	@Override
	public void updateHandleState(HandleMechanism handleMechanism) {
		// TODO Auto-generated method stub
		handleMechanismMapper.updateHandleState(handleMechanism);
	}
	@Override
	public List<HandleMechanism> getHandleMechanismbyEventTypeId(
			String eventTypeId) {
		// TODO Auto-generated method stub
		return handleMechanismMapper.getHandleMechanismbyEventTypeId(eventTypeId);
	}
	@Override
	public void insertHandleMechanismUUID(HandleMechanism handleMechanism) {
		// TODO Auto-generated method stub
		Date date=new Date();
		String id=UUID.randomUUID().toString();
		handleMechanism.setHandleId(id);
		handleMechanism.setState(1);//状态设为有效
		handleMechanism.setCreateTime(date);
		ImportantEventTypeJournal importantEventTypeJournal =handleMechanism.getImportantEventTypeJournal();
		Integer n=handleMechanismMapper.insertHandleMechanismUUID(handleMechanism);
		if(n>0){
			importantEventTypeJournal.setRecordId(id);
			importantEventTypeJournal.setOperatorTime(date);
			importantEventTypeJournal.setOperatatorId(handleMechanism.getCreatePersonId());
			importantEventTypeJournal.setEventTypeId(handleMechanism.getEventTypeId());
			importantEventTypeJournalMapper.insertImportantEventTypeJournal(importantEventTypeJournal);
		}
	}

}
