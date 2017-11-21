package com.flf.mapper;

import com.flf.entity.DepartmentOrders;

public interface DepartmentOrdersMapper {
	
	int insertDepartmentOrders(DepartmentOrders departmentOrders);//添加部门质检工单信息
	int insertDepartmentOrdersUUID(DepartmentOrders departmentOrders);//添加部门质检工单信息
	DepartmentOrders getDepartmentOrdersbyId(String orderId);//根据id查询部门质检工单信息
	DepartmentOrders getDepartmentOrdersbyTaskId(String orderId);//通过任务id查询工单信息
	int updateDepartmentOrders(DepartmentOrders departmentOrders);
}
