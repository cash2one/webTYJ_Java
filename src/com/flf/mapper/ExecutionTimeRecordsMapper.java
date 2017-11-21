package com.flf.mapper;

import java.util.Date;
import java.util.List;

import com.flf.entity.ExecutionTimeRecords;
;

public interface ExecutionTimeRecordsMapper {
    int deleteByPrimaryKey(String executiveNumId);

    int insert(ExecutionTimeRecords record);
    int insertUUID(ExecutionTimeRecords record);

    int insertSelective(ExecutionTimeRecords record);

    ExecutionTimeRecords selectByPrimaryKey(String executiveNumId);

    int updateByPrimaryKeySelective(ExecutionTimeRecords record);

    int updateByPrimaryKey(ExecutionTimeRecords record);
    
    List<ExecutionTimeRecords> getExecutionTimeRecordsbyRecordId(String recordId);
    
    int updateNextExecutiveTimeByExecutiveNumId(Date NextExecutiveTime,String ExecutiveNumId);
    List<ExecutionTimeRecords> listPageDecorationsExecutionTime(ExecutionTimeRecords executionTimeRecords);
}