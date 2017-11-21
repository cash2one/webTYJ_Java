package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.HandleMechanism;
import com.flf.entity.ImportantEventType;
import com.flf.entity.ImportantEventTypeJournal;
import com.flf.entity.PageRestful;
import com.flf.mapper.HandleMechanismMapper;
import com.flf.mapper.ImportantEventTypeJournalMapper;
import com.flf.mapper.ImportantEventTypeMapper;
import com.flf.service.ImportantEventTypeService;

public class ImportantEventTypeServiceImpl implements ImportantEventTypeService{

	private ImportantEventTypeMapper importantEventTypeMapper;
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

	public ImportantEventTypeMapper getImportantEventTypeMapper() {
		return importantEventTypeMapper;
	}

	public void setImportantEventTypeMapper(
			ImportantEventTypeMapper importantEventTypeMapper) {
		this.importantEventTypeMapper = importantEventTypeMapper;
	}

	@Override
	public List<ImportantEventType> getAllImportantEventType() {
		List<ImportantEventType> importantEventTypes = importantEventTypeMapper.getAllImportantEventType();
		for (ImportantEventType importantEventType : importantEventTypes) {
			List<HandleMechanism> handleMechanisms = importantEventType.getHandleMechanismArr();
			if(handleMechanisms!=null && handleMechanisms.size()<=1){
				handleMechanisms.add(0, null);
				importantEventType.setHandleMechanismArr(handleMechanisms);
			}
		}
		return importantEventTypes;
	}

	@Override
	public void insertImportantEventType(ImportantEventType importantEventType) {
		if(importantEventType!=null){
			String uuid = UUID.randomUUID().toString();
			List<HandleMechanism> hmlist = importantEventType.getHandleMechanismArr();
			Date date = new Date();
			
			importantEventType.setEventTypeId(uuid);
			importantEventType.setState(1);
			importantEventType.setCreateTime(date);
			Integer resulst = importantEventTypeMapper.insertImportantEventTypeUUID(importantEventType);
			if(resulst>0 && hmlist!=null && hmlist.size()>0){
				for(HandleMechanism hm:hmlist){
					hm.setHandleId(UUID.randomUUID().toString());
					hm.setEventTypeId(uuid);
					hm.setCreateTime(date);
					hm.setCreatePersonId(importantEventType.getCreatePersonId());
					hm.setState(1);//状态设为有效
					handleMechanismMapper.insertHandleMechanismUUID(hm);
				}
			}
		}
	}

	@Override
	public void insertHandleMechanism(ImportantEventType importantEventType) {
		if(importantEventType!=null){
			Date date = new Date();
			String eventTypeId = importantEventType.getEventTypeId();
			//List<HandleMechanism> hmlist = importantEventType.getHandleMechanismArr();
			HandleMechanism hm=new HandleMechanism();
			hm.setEventTypeId(eventTypeId);
			hm.setCreateTime(date);
			hm.setState(1);//状态设为有效
			hm.setRemarks(importantEventType.getRemarks());
			handleMechanismMapper.insertHandleMechanism(hm);
//			if(hmlist!=null && hmlist.size()>0){
//				for(HandleMechanism hm:hmlist){
//					hm.setEventTypeId(eventTypeId);
//					hm.setCreateTime(date);
//					hm.setState(1);//状态设为有效
//					handleMechanismMapper.insertHandleMechanism(hm);
//				}
//			}
		}
	}

	@Override
	public void closeImportantEventType(ImportantEventType importantEventType) {
		if(importantEventType!=null){
			importantEventType.setState(0);
			ImportantEventTypeJournal joural = importantEventType.getImportantEventTypeJournal();
			Integer result = importantEventTypeMapper.updateImportantEventType(importantEventType);
			if(result>0 && joural!=null){
				joural.setChangeState(importantEventType.getState());
				joural.setEventTypeId(importantEventType.getEventTypeId());
				joural.setOperatorTime(new Date());
				importantEventTypeJournalMapper.insertImportantEventTypeJournal(joural);
			}
		}
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public PageRestful listPageImportantEventType(
			ImportantEventType importantEventType) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<ImportantEventType> importantEventTypes =importantEventTypeMapper.listPageImportantEventType(importantEventType);
		importantEventTypes.add(0,null);
		pagerestful.setImportantEventTypes(importantEventTypes);
		pagerestful.setPage(importantEventType.getPage());
		return pagerestful;
	}

	@Override
	public List<ImportantEventType> getAllImportantEventTypes() {
		// TODO Auto-generated method stub
		return importantEventTypeMapper.getAllImportantEventTypes();
	}

}
