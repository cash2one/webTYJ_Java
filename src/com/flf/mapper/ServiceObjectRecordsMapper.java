package com.flf.mapper;


import java.util.List;

import com.flf.entity.ServiceObjectRecords;
/**
 * 服务对象记录表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
public interface ServiceObjectRecordsMapper {
	int deleteServiceObjectRecords(String recordId);//删除服务对象记录

	int insertServiceObjectRecords(ServiceObjectRecords serviceObjectRecords);//添加服务对象记录

    List<ServiceObjectRecords> listAllServiceObjectRecords();//查询所有服务对象记录

    ServiceObjectRecords getServiceObjectRecordsbyId(String recordId);//通过Id查询服务对象记录

    int updateServiceObjectRecords(ServiceObjectRecords serviceObjectRecords);//修改服务对象记录
    
    List<ServiceObjectRecords> getServiceObjectRecordsbyServicereId(String serviceId);//通过服务请求ID查询服务对象记录

    ServiceObjectRecords getServiceObjectRecordsbyRequestAndStaff(String serviceId,String staffId);//通过服务请求id和员工id查询
}