package com.flf.service.impl;

import com.flf.entity.ImportantEventTypeJournal;
import com.flf.mapper.ImportantEventTypeJournalMapper;
import com.flf.service.ImportantEventTypeJournalService;

public class ImportantEventTypeJournalServiceImpl implements ImportantEventTypeJournalService{
	
	private ImportantEventTypeJournalMapper importantEventTypeJournalMapper;
	
	public ImportantEventTypeJournalMapper getImportantEventTypeJournalMapper() {
		return importantEventTypeJournalMapper;
	}
	public void setImportantEventTypeJournalMapper(
			ImportantEventTypeJournalMapper importantEventTypeJournalMapper) {
		this.importantEventTypeJournalMapper = importantEventTypeJournalMapper;
	}
	@Override
	public ImportantEventTypeJournal getDataByReordId(String recordId) {
		// TODO Auto-generated method stub
		return importantEventTypeJournalMapper.getDataByReordId(recordId);
	}

}
