package com.flf.mapper;

import com.flf.entity.ElectricityMeterReadingProgram;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.SearchMeter;

import java.util.List;

public interface ElectricityMeterReadingProgramMapper {
	int deleteElectricityMeterReadingProgram(String electricityMeterReadingProgramId);  //��ݵ��ƻ���ϵ��idɾ����Ϣ

    int insertElectricityMeterReadingProgram(ElectricityMeterReadingProgram electricityMeterReadingProgram); //������ƻ���ϵ����Ϣ

    List<ElectricityMeterReadingProgram> listPageElectricityMeterReadingProgram(SearchMeter searchMeter);//��ҳ��ѯ���ƻ���ϵ����Ϣ
    
    List<ElectricityMeterReadingProgram> listAllElectricityMeterReadingProgram(); //��ѯ���е��ƻ���ϵ����Ϣ

    ElectricityMeterReadingProgram getElectricityMeterReadingProgrambyId(String electricityMeterReadingProgramId); //ͨ����ƻ���ϵ��id��ȡ���ƻ���ϵ����Ϣ

    int updateElectricityMeterReadingProgram(ElectricityMeterReadingProgram electricityMeterReadingProgram);//���µ��ƻ���ϵ����Ϣ
    
    public List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyStaff(
			String currentExecutor);  //根据执行人查询抄表数据
    
    /**
     * 执行抄表计划
     * @param meterReadingProgramId
     */
	void implementProgram(List<String> meterReadingProgramIdList);
	
	void insertSelective (ElectricityMeterReadingProgram electricityMeterReadingProgram);
	// 修改抄表计划信息
	int updateMeterReadingProgram(ElectricityMeterReadingProgram electricityMeterReadingProgram); 
	int updateByPrimaryKeySelective(ElectricityMeterReadingProgram record);

	/**
	 * 根据抄表计划id查询抄表计划详情
	 * @param meterReadingProgramId
	 * @return
	 */
	ElectricityMeterReadingProgram editData(String meterReadingProgramId);
	
	/**
	 * 抄表结果列表
	 * @param searchMerter
	 * @return
	 */
	List<ElectricityMeterReadingProgram> listPageMeterReadingResult(SearchMeter searchMerter);
	
	/**
	 * 通过计划id查询所有计划的信息
	 * @param meterReadingProgramId
	 * @return
	 */
	ElectricityMeterReadingProgram selectByPrimaryKey(String meterReadingProgramId);
	
	/**
	 * 根据选中的id,查询对应的抄表计划
	 * @param meterReadingProgramIdList
	 * @return
	 */
	List<ElectricityMeterReadingProgram> selectMeterChecked(List<String> meterReadingProgramIdList);
}