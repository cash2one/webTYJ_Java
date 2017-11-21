package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.Scheduling;


public interface SchedulingMapper {//排班表
	List<Scheduling> listAllScheduling();//排班表表信息
	Scheduling getSchedulingById(int id);//通过Id查询排班表信息
	int insertScheduling(Scheduling scheduling);//添加排班表信息
	int updateScheduling(Scheduling scheduling);//修改排班表信息
	int deleteScheduling(int id);//删除排班表信息
	
	/**
	 * 查询条件下的所有排班信息
	 *岗位id or
	 * 员工id or
	 * 时间  or
	 * @param scheduling
	 * @return
	 */
	List<Map> listAllSchedulingBypostIdOrStaffId(Scheduling scheduling);
	
	/**
	 * 部门id or
	 * 岗位id or
	 * 时间  or
	 * @param scheduling
	 * @return
	 */
	List<Map> listAllSchedulingBypostIdOrStaffName(Scheduling scheduling);//查询所有排班表
	
	/**
	 * 通过员工id跟日期，修改员工班次
	 * @param scheduling
	 * @return
	 */
	int updateSchedulingByStaffId(Scheduling scheduling);
	
	int getCountBydivisionIdAndDate(Map map);//根据部门id和时间查询总记录数
	
}