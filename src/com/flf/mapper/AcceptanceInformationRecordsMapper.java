package com.flf.mapper;

import java.util.List;

import com.flf.entity.AcceptanceInformationRecords;

/**
 * 验收项记录表
 * @author shaozheng
 *	2015-7-2
 */
public interface AcceptanceInformationRecordsMapper {
	
	int deleteAcceptanceInformationRecords(String recordId);//删除验收信息记录

	int insertAcceptanceInformationRecords(AcceptanceInformationRecords acceptanceInformationRecords);//添加验收信息记录

    List<AcceptanceInformationRecords> listAllAcceptanceInformationRecords();//查询所有验收信息记录

    AcceptanceInformationRecords getAcceptanceInformationRecordsbyId(String recordId);//通过Id查询验收信息记录

    int updateAcceptanceInformationRecords(AcceptanceInformationRecords acceptanceInformationRecords);//修改验收信息记录

}
