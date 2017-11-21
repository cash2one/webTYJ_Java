package com.flf.mapper;

import com.flf.entity.MeterReadingData;
import com.flf.entity.MeterReadingResults;
import com.flf.entity.Search;
import com.flf.entity.SearchMeter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public interface MeterReadingDataMapper {
	int deleteMeterReadingData(String meterReadingDataId);// 删除抄表数据信息

    int insertMeterReadingData(MeterReadingData meterReadingData); //新增抄表数据信息
    
    int updateReasonByBuildingStructureId(MeterReadingData meterReadingData);//根据建筑修改读数

    List<MeterReadingData> listPageMeterReadingData(MeterReadingData meterReadingData); // 分页查询抄表数据信息
   
    List<MeterReadingData> listAllMeterReadingData();  // 查询所有抄表数据信息

    MeterReadingData getMeterReadingDatabyId(String meterReadingDataId);  //根据抄表数据id查询抄表数据信息

    int updateMeterReadingData(MeterReadingData meterReadingData); // 修改抄表数据信息
    int updateMeterReading(MeterReadingData meterReadingData); // 修改抄表数据信息
    int updateMeter(String meterReadingDataId); // 修改抄表数据信息 修正读数 
    int updateMeterChecked(List<String> meterReadingDataIdList); // 修改抄表数据信息 核实
    int updateMeterRecoed(List<String> meterReadingDataIdList); // 修改抄表信息 添加重抄任务
    int updateMeterReject(List<String> meterReadingDataIdList); // 修改抄表信息 驳回
    int updateVerification(List<String> meterReadingDataIdList); // 修改抄表信息 重抄任务
    MeterReadingData listMeterReadingDatabyRecordId(String waterMeterRecordId);//根据建筑结构id查询上次水表读数 
    List<MeterReadingData> listMeterReadingDatabyId(String waterMeterRecordId);  //根据水表id查询抄表数据信息
    
    List<MeterReadingData> listMeterReadingDatebyName(String projectName); //根据计划名称查询抄表数据
    
    List<MeterReadingData> listPageMeterReadingDate(SearchMeter searchMeter); //异常数据处理多条件查询功能
    
    List<MeterReadingData> listMeterReadingDatebyDate(Date meterReadingDate); // 根据抄表日期查询抄表数据
    
    MeterReadingData getMeterReadingDatabyDate(SearchMeter searchMeter);  //根据抄表日期和水表编号查询数据
    
    MeterReadingData getMeterReadings(String buildingStructureId);//根据建筑结构id查询水表读数 
    MeterReadingData lastMeterReadings(String buildingStructureId);//根据建筑结构id查询上次水表读数 
    
    List<MeterReadingData> getMeterReadingByC(Map map);//根据条件查询水表读数 
    
    List<MeterReadingData> listPageMeterReading(MeterReadingData meterReadingData); //数据报表分页显示
    
    List<MeterReadingData> listPageMeterReadingDates(MeterReadingData meterReadingData); //水表数据报表分页显示
    
    List<MeterReadingData> getMeterReadingsByBuildingId(String buildingId); //根据建筑结构id查询水表信息

    /**
     * 根据水表使用记录id查询上个月的读数
     * @param str
     * @return
     */
    MeterReadingData selectLastMonthReading(String str);

    /**
     * 抄表结果列表分页
     * @param meterReadingData
     * @return
     */
	List<MeterReadingData> listPageMeterRecoedDateList(MeterReadingData meterReadingData);
	
	/**
     * 重抄任务模态框中列表分页
     * @param meterReadingData
     * @return
     */
	List<MeterReadingData> listPageMeterRecoedDateList2(MeterReadingData meterReadingData);

	/**
	 * 根据抄表计划id的集合，自动核实抄表结果
	 * @param meterReadingProgramIdList
	 */
	void examineProject(List<String> meterReadingProgramIdList);
	
	/**
	 * 根据抄表计划id查询抄表数据
	 * @param programId
	 * @return
	 */
	List<MeterReadingData> selectMeterReadingDateByProgramId(String programId);
	
	int updateByPrimaryKeySelective(MeterReadingData record);

	MeterReadingData selectByBuildingStructureIdAndMeterReadingDate(String buildingStructureId, String specifiedDate);

	/**
	 * 根据水表建筑结构id和抄表日期查询水表用量
	 * @param buildingStructureId
	 * @param meterReadingDate
	 * @return
	 */
	
	MeterReadingData selectByPrimaryKey(String meterReadingDataId);

	/**
	 * 根据水表使用记录id和记录时间查询水表抄表数据
	 * @param waterMeterRecordId
	 * @param time
	 * @return
	 */
	
	MeterReadingData selectByMeterReadingProgramId(String meterReadingProgramId);

	/**
	 * 根据水表使用记录id和记录时间查询水表抄表数据
	 * @param waterMeterRecordId
	 * @param time
	 * @return
	 */
	MeterReadingData selectByWaterMeterRecordIdAndDate(String waterMeterRecordId, Date time);

	/**
	 * 根据抄表计划id查询抄表记录
	 * @param meterReadingProgramId
	 * @return
	 */
	List<MeterReadingData> selectMeterReadingDateByMeterReadingProgramId(String meterReadingProgramId);
	
	/**
	 * 水表结果列表分页
	 * */
	List<MeterReadingData> listPageWaterMeterRecordAll(MeterReadingData meterReadingData);

	void deleteByReadingProgramId(String meterReadingProgramId);
	
	List<MeterReadingData> listAllMeterReadingData1();  // 查询所有水表数据报表结果信息

}