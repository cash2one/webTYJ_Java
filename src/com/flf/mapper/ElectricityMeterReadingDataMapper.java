package com.flf.mapper;

import com.flf.entity.ElectricityMeterReadingData;
import com.flf.entity.MeterReadingData;
import com.flf.entity.SearchMeter;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ElectricityMeterReadingDataMapper {
	int deleteElectricityMeterReadingData(String electricityMeterReadingDataId);  //��ݵ�����idɾ����Ϣ

    int insertElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData); //新增抄表数据信息
	int updateByPrimaryKeySelective(ElectricityMeterReadingData record);

    List<ElectricityMeterReadingData> listPageElectricityMeterReadingDataBySearchMeter(SearchMeter searchMeter);//��ҳ��ѯ��������Ϣ
    
    List<ElectricityMeterReadingData> listPageElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData);
    
    List<ElectricityMeterReadingData> listAllElectricityMeterReadingData(); //��ѯ���е�������Ϣ

    ElectricityMeterReadingData getElectricityMeterReadingDatabyId(String electricityMeterReadingDataId); //ͨ�������id��ȡ��������Ϣ

    int updateElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData);//���µ�������Ϣ}
    
    List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyDate(Date meterReadingDate); 
			   //根据抄表日期查询抄表数据
    
    List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyName(
			String projectName);   // 根据计划名称查询抄表数据
    ElectricityMeterReadingData listElectricityMeterReadingDatabyRecordId(String electricityMeterRecordId);
    
    List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyId(
			String electricityMeterRecordId); 
    //根据电表id查询抄表数据
    List<ElectricityMeterReadingData> getElectricityMeterReadingbyId(Map map);

    //根据建筑id查询抄表数据
    List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyBuildingId(String addressId);
    
    
    /**
	 * 水表结果列表分页
	 * */
	List<ElectricityMeterReadingData> listPageElectricityMeterRecordAll(ElectricityMeterReadingData electricityMeterReadingData);
   /* MeterReadingData selectByBuildingStructureIdAndElectricityMeterReadingDate(String buildingStructureId, String specifiedDate);

	*/
    /**
	 * 根据水表建筑结构id和抄表日期查询水表用量
	 * @param buildingStructureId
	 * @param meterReadingDate
	 * @return
	 */
	
	/**
	 * 根据水表使用记录id和记录时间查询水表抄表数据
	 * @param waterMeterRecordId
	 * @param time
	 * @return
	 */
	ElectricityMeterReadingData selectByElectricityMeterRecordIdAndDate(String electricityMeterRecordId, Date time);

	List<ElectricityMeterReadingData> listAllElectricityMeterReadingData1();  // 查询所有水表数据报表结果信息
	
	
	 /**
     * 根据水表使用记录id查询上个月的读数
     * @param str
     * @return
     */
	ElectricityMeterReadingData selectLastMonthReading(String str);
	
	void deleteByReadingProgramId(String meterReadingProgramId);
	
	/**
	 * 根据抄表计划id查询抄表记录
	 * @param meterReadingProgramId
	 * @return
	 */
	List<ElectricityMeterReadingData> selectMeterReadingDateByMeterReadingProgramId(String meterReadingProgramId);
	
	 /**
     * 抄表结果列表分页
     * @param meterReadingData
     * @return
     */
	List<ElectricityMeterReadingData> listPageMeterRecoedDateList(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 根据水表建筑结构id和抄表日期查询水表用量
	 * @param buildingStructureId
	 * @param meterReadingDate
	 * @return
	 */
	
	ElectricityMeterReadingData selectByPrimaryKey(String meterReadingDataId);
	
	/**
	 * 根据电表使用记录id和记录时间查询电表抄表数据
	 * @param waterMeterRecordId
	 * @param time
	 * @return
	 */
	ElectricityMeterReadingData selectByWaterMeterRecordIdAndDate(String waterMeterRecordId, Date time);
	
	/**
	 * 修改抄表数据信息 核实
	 * @param meterReadingDataIdList 电表抄表数据id
	 * @return
	 */
	int updateMeterChecked(List<String> meterReadingDataIdList); 
	
	/**
	 * 修改抄表信息 添加重抄任务
	 * @param meterReadingDataIdList
	 * @return
	 */
	int updateMeterRecoed(List<String> meterReadingDataIdList); 
	
	/**
     * 重抄电表任务模态框中列表分页
     * @param meterReadingData
     * @return
     */
	List<ElectricityMeterReadingData> listPageMeterRecoedDateList2(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 修改抄表信息 驳回
	 * @param meterReadingDataIdList
	 * @return
	 */
	int updateMeterReject(List<String> electricityMeterReadingDataList);
	
	/**
	 *  修改抄表信息 重抄任务
	 * @param meterReadingDataIdList
	 * @return
	 */
	int updateVerification(List<String> meterReadingDataIdList); 
	
}