package com.flf.mapper;

import java.util.List;

import com.flf.entity.CheckItemRecords;

/**
 * 检测项结果记录表
 * 
 * @author 邵政 
 * 2015-7-2
 */
public interface CheckItemRecordsMapper {

	int deleteCheckItemRecords(String recordId);//删除检测信息记录

	int insertCheckItemRecords(CheckItemRecords checkItemRecords);//添加检测信息记录

    List<CheckItemRecords> listAllCheckItemRecords();//查询所有检测信息记录

    CheckItemRecords getCheckItemRecordsbyId(String recordId);//通过Id查询检测信息记录

    int updateCheckItemRecords(CheckItemRecords checkItemRecords);//修改检测信息记录
    
    List<CheckItemRecords> getCheckItemRecordsbyOrderId(String orderId);//根据工单id获取检测信息

}
