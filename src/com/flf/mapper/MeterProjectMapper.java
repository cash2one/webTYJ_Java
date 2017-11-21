package com.flf.mapper;

import com.flf.entity.WaterMeterProject;
import java.util.List;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */

public interface MeterProjectMapper {
	int deleteWaterMeterProject(String waterMeterProjectId);// 删除水表使用记录抄表计划关系信息
	
	int deleteWaterMeterProjectbyId(String buildingStructureId);// 根据建筑结构id删除水表使用记录抄表计划关系信息

    int insertWaterMeterProject(WaterMeterProject waterMeterProject); //新增水表使用记录抄表计划关系信息

    List<WaterMeterProject> listPageWaterMeterProject(WaterMeterProject waterMeterProject); // 分页查询水表使用记录抄表计划关系信息
    
    List<WaterMeterProject> listAllWaterMeterProject();  // 查询所有水表使用记录抄表计划关系信息

    WaterMeterProject getWaterMeterProjectbyId(String waterMeterProjectId);  //根据水表使用记录抄表计划关系id查询水表使用记录抄表计划关系信息

    int updateWaterMeterProject(WaterMeterProject waterMeterProject); // 修改水表使用记录抄表计划关系信息
    
    List<WaterMeterProject> listWaterMeterProjectbyId(String readingProgramId);  //根据查表计划id查询建筑结构id

	void deleteByReadingProgramId(String meterReadingProgramId);
}