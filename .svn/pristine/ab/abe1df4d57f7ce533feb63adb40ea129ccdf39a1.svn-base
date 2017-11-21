package com.flf.mapper;

import com.flf.entity.Search;
import com.flf.entity.SearchMeter;
import com.flf.entity.WaterMeterOrderRecords;
import com.flf.entity.WaterMeterRecords;
import com.flf.entity.WaterMeterRecords;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public interface MeterRecordsMapper {
	int deleteWaterMeterRecords(String waterMeterRecordsId);// 删除水表使用记录信息

    int insertWaterMeterRecords(WaterMeterRecords waterMeterRecords); //新增水表使用记录信息

   /* List<WaterMeterRecords> listPageWaterMeterRecords(WaterMeterRecords waterMeterRecords); // 分页查询水表使用记录信息
*/    
    List<WaterMeterRecords> listAllWaterMeterRecords();  // 查询所有水表使用记录信息

    WaterMeterRecords getWaterMeterRecordsbyId(String waterMeterRecordsId);  //根据水表使用记录id查询水表使用记录信息
    WaterMeterRecords getWaterMeterRecordsbyIds(String waterMeterRecordsId);  //根据水表使用记录id查询水表使用记录信息
    WaterMeterRecords getWaterMeterRecordsbyBuildigId(String buildingStructureId); //根据建筑id查询水表信息
    
    int updateWaterMeterRecords(WaterMeterRecords waterMeterRecords); // 修改水表使用记录信息
    
    List<WaterMeterRecords> listWaterMeterRecordsbyWaterId(String waterMeterId);  //根据水表id查询水表使用记录信息
    
    List<WaterMeterRecords> listPageWaterMeterRecords(SearchMeter searchMeter);  //多条件查询水表接口	
    
    int updateWaterMeterRecordsbyNum(WaterMeterRecords waterMeterRecords); // 停用水表
    
    WaterMeterRecords listWaterMeterRecordsbybuildigIds(String buildingStructureId); //根据建筑结构id查询鼠标使用记录
    List<WaterMeterRecords> listPageWaterMeterRecordsById(WaterMeterRecords waterMeterRecords);  //分页查询计划下抄表数据	

    List<WaterMeterRecords> listWaterMeterRecordsBybuildigIds(String buildingStructureId);//查询建筑下所有停用水表记录 
    List<WaterMeterRecords> listWaterMeterRecordsByIds(String buildingStructureId);//查询建筑下所有用水表记录 
    List<WaterMeterRecords> listWaterMeterRecordsByWaterMeterId(String waterMeterId,Integer year);//根据水表ID查询水表使用记录信息
    
    WaterMeterRecords selectByBuildingStructureId(String buildingStructureId);
    
    WaterMeterRecords selectByPrimePrimaryKey(String id);

    /**
     * 水损列表第一级
     * @return
     */
    List<WaterMeterRecords> listPageWaterDamage(WaterMeterRecords waterMeterRecords);

	/**
	 * 根据水表使用记录id查询读数
	 * @param waterMeterRecordsId
	 * @param date 
	 * @return
	 */
	WaterMeterRecords selectReadingById(String waterMeterRecordsId, Date date);

	/**
	 * 根据父表标号查询子表读数总和
	 * @param waterMeterNum
	 * @param date 
	 * @return
	 */
	Double selectSumReadingByParentNum(String waterMeterNum, Date date);
	
	Double selectSumReadingByParentNum_AndIsBilling1(String waterMeterNum, Date date);

	/**
	 * 水损列表第二级
	 * @param waterMeterRecords
	 * @return
	 */
	List<WaterMeterRecords> listPageWaterDamageTwo(WaterMeterRecords waterMeterRecords);

	List<WaterMeterRecords> getWaterDamage(WaterMeterRecords waterMeterRecords);

	List<WaterMeterRecords> getWaterDamageTwo(Map<String, Object> map);

	
	List<WaterMeterOrderRecords> listWaterMeterRecordsByProjectIdAndBuildingStructureId(com.flf.entity.Search search);
	
	/**
	 * 根据父表标号查询子表用量总和
	 * @param waterMeterNum
	 * @param date 
	 * @return
	 */
	Double selectSumConsumptionByParentNum(String waterMeterNum, Date date,String publicWater);
}