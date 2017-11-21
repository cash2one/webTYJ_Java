package com.flf.mapper;

import com.flf.entity.ElectricityMeterProject;
import com.flf.entity.WaterMeterProject;
import com.flf.entity.ElectricityMeterProject;

import java.util.List;

public interface ElectricityMeterProjectMapper {
	int deleteElectricityMeterProject(String electricityMeterProjectId);  //��ݵ��ƻ�idɾ����Ϣ

    int insertElectricityMeterProject(ElectricityMeterProject electricityMeterProject); //������ƻ���Ϣ

    List<ElectricityMeterProject> listPageElectricityMeterProject(ElectricityMeterProject electricityMeterProject);//��ҳ��ѯ���ƻ���Ϣ
    
    List<ElectricityMeterProject> listAllElectricityMeterProject(); //��ѯ���е��ƻ���Ϣ

    ElectricityMeterProject getElectricityMeterProjectbyId(String electricityMeterProjectId); //ͨ����ƻ�id��ȡ���ƻ���Ϣ

    int updateElectricityMeterProject(ElectricityMeterProject electricityMeterProject);//���µ��ƻ���Ϣ
    
    List<ElectricityMeterProject> listElectricityMeterProjectbyId(String readingProgramId);  //根据查表计划id查询建筑结构id
    
    void deleteByReadingProgramId(String meterReadingProgramId);
    
    int insertWaterMeterProject(ElectricityMeterProject electricityMeterProject); //新增电表使用记录抄表计划关系信息
}