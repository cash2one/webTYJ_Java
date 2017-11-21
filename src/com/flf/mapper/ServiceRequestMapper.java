package com.flf.mapper;


import java.util.List;

import com.flf.entity.ServiceRequest;
/**
 * 服务请求表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
public interface ServiceRequestMapper {
	
	int updateFeedback(ServiceRequest serviceRequest);//添加回访记录
	ServiceRequest getServiceRequest(String serviceRequestId);
	int deleteServiceRequest(String serviceRequestId);//删除服务请求
	int insertServiceRequest(ServiceRequest serviceRequest);//添加服务请求
    List<ServiceRequest> listPageServiceRequest(ServiceRequest serviceRequest);//分页查询服务请求
    List<ServiceRequest> listAllServiceRequest();//查询所有服务请求
    ServiceRequest getServiceRequestbyId(String serviceRequestId);//通过Id查询服务请求
    int updateServiceRequest(ServiceRequest serviceRequest);//修改服务请求
    List<ServiceRequest> getServiceRequestbyCustomerId(String customerId);//通过客户Id查询服务请求
    List<ServiceRequest> listPageServiceRequestbyCustomerId(ServiceRequest serviceRequest);//通过客户Id查询服务请求
    int closeServiceRequest(String serviceRequestId); //关闭服务请求
    ServiceRequest returnNewServiceRequest(ServiceRequest serviceRequest); //获取uuid
    ServiceRequest getServiceRequestByWriterId(String writerId);//通过创建人id获取服务请求
    int insertServiceRequestUUID(ServiceRequest serviceRequest);//添加服务请求(uuid)
    List<ServiceRequest> getServiceRequestbyQCType(String QCType);//根据质检单位类型获取服务请求信息(部门质检)
    List<ServiceRequest> getServiceRequestbyState(String customerId ,String state,String date);//根据状态获取服务请求
    List<ServiceRequest> getServiceRequestbyCustomerIdAndDate(String customerId,String date);//
    List<ServiceRequest> getGoingServiceRequestbyStateAndType(String type);//根据类型获取进行中的服务请求
    List<ServiceRequest> getHistoryServiceRequestbyStateAndTypes(String type);//根据状态获取历史服务请求
    List<ServiceRequest> getServiceRequestbyDecoration(String serviceRequestType);//通过服务请求类型获取服务请求
    List<ServiceRequest> listPageServiceRequestbyDecoration(ServiceRequest serviceRequest);//通过服务请求类型获取服务请求（分页）
    List<ServiceRequest> getAllServiceRequestsbyEventType();//获取所有重大事项
    List<ServiceRequest> listPageAllServiceRequestsbyEventType(ServiceRequest serviceRequest);//获取所有重大事项(分页)
    List<ServiceRequest> listPageGoingServiceRequestsbyEventType(ServiceRequest serviceRequest);//获取进行中重大事项(分页)
    List<ServiceRequest> listPageHistoryServiceRequestsbyEventType(ServiceRequest serviceRequest);//获取历史重大事项(分页)
    int getGoingEventSum();//获取进行中重大事项
    int getHistotyEventSum();//获取已完成重大事项
    List<ServiceRequest> getServiceRequestbyTypeAndCustomerId(String serviceRequestType,String customerId);
    List<ServiceRequest> listPageServiceRequestByType(ServiceRequest serviceRequest);//根据服务请求类型分页查询服务请求
    int changeServiceRequestStateByIds(ServiceRequest serviceRequest);//使结合中的服务请求失效
    List<ServiceRequest> listPageServiceRequestbyStateAndType(ServiceRequest serviceRequest);//根据类型分页显示进行中的服务请求
    List<ServiceRequest> getInspectionServiceRequest();//巡检服务请求
    List<ServiceRequest> listPageInspectionServiceRequestbyStateAndType(ServiceRequest serviceRequest);//进行中巡检服务请求分页
    List<ServiceRequest> listPageInspectionServiceRequestbyStateAndType1(ServiceRequest serviceRequest);//历史巡检服务请求分页
}