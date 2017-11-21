package com.flf.mapper;
/**
 * 创建 by xiaocong   
 * date   2015-6-16
 */
import java.util.List;

import com.flf.entity.Intake;
import com.flf.entity.Search;

public interface IntakeMapper {
	    List<Intake> listAllIntake();//查询所有入伙信息
	    List<Intake> listPageIntake(Intake intakeId);//分页条件查询入伙信息
	    Intake getIntakeById(String intakeId); //通过入伙id查询入伙信息
	    List<Intake> getInrakeByBuildingId(String HouseId);//通过房屋id查询入伙信息
	    int deleteIntake(String intakeId);//通过入伙id删除入伙信息
	    int insertIntake(Intake intake);//增加入伙信息
	    int updateIntake(Intake intake);//修改入伙信息
		List<Intake> listAllIntakeBySearch(Search search);//通过条件查询入伙信息
		int insertListIntake(List<Intake> intakes);//添加入伙初始化集合
}
