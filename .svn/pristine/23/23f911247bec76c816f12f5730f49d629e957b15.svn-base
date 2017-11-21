package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConsultationOrders;

/**
 * 咨询工单表Mapper
 * 创建人：倪明
 * 创建时间：2015/8/12
 */
public interface ConsultationOrdersMapper {
	
	List<ConsultationOrders> listAllConsultationOrders();   //查询所有咨询工单信息
	
	int insertConsultationOrders(ConsultationOrders consultationOrders);    //新增咨询工单信息
	
	int insertConsultationOrdersUUID(ConsultationOrders consultationOrders);   ////新增咨询工单信息UUID
	
	int deleteConsultationOrders(String orderId);   //删除咨询工单信息
	
	ConsultationOrders getConsultationOrdersbyId(String orderId);   //根据id查询咨询工单信息
	
	int updateConsultationOrders(ConsultationOrders consultationOrders);   //修改咨询工单信息
	
	int closeConsultationOrders(String orderId);   //关闭咨询工单信息
	
}
