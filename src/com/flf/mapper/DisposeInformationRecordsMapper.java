package com.flf.mapper;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.DisposeInformationRecords;
/**
 * 处理信息记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
public interface DisposeInformationRecordsMapper {
	int deleteDisposeInformationRecords(String recordId);//删除处理信息记录

	int insertDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);//添加处理信息记录

    List<DisposeInformationRecords> listPageDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);//分页查询处理信息记录
    
    List<DisposeInformationRecords> listAllDisposeInformationRecords();//查询所有处理信息记录

    DisposeInformationRecords getDisposeInformationRecordsbyId(String recordId);//通过Id查询处理信息记录

    int updateDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);//修改处理信息记录

    List<DisposeInformationRecords> getDisposeInformationRecordsbyOrderId(String orderId);//根据orderId获取处理信息
}