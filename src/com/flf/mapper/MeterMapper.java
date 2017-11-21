package com.flf.mapper;

import com.flf.entity.SearchMeter;
import com.flf.entity.WaterMeter;
import com.flf.entity.WaterMeter;

import java.util.List;
import org.apache.ibatis.annotations.Param;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public interface MeterMapper {
	int deleteWaterMeter(String waterMeterId);// 删除水表信息

    int insertWaterMeter(WaterMeter waterMeter); //新增水表信息

    List<WaterMeter> listPageWaterMeter(WaterMeter waterMeter); // 分页查询水表信息
    
    List<WaterMeter> listAllWaterMeter();  // 查询所有水表信息

    WaterMeter getWaterMeterbyId(String waterMeterId);  //根据水表id查询水表信息

    int updateWaterMeter(WaterMeter waterMeter); // 修改水表信息
    
    List<WaterMeter> listWaterMeterbyParent(String parentId); //根据父级id查询水表信息
    
    WaterMeter getWaterMeterbywaterMeterRecordsId(String waterMeterRecordsId);  //根据水表使用记录查询水表信息
    
    WaterMeter getWaterMeterbyWaterMeterNum(String waterMeterNum); //根据水表编号查询水表信息是否存在
    
    WaterMeter getWaterMeterbyPropertyNumber(String propertyNumber); //根据资产编号查询水表信息是否存在
    
    WaterMeter getWaterMeterbyParentNum(String waterMeterNum); //根据水表编号查询水表信息
    
    WaterMeter getWaterMeterbyWaterMeterId(String waterMeterId);  //根据水表id查询水表信息
    
    /**
     * 根据建筑结构Id获取水表和房屋
     * @param waterMeter
     * @return
     */
    List<WaterMeter> getWaterMeterByBuildingStructureId(WaterMeter waterMeter);

    /**
     * 根据单元的建筑结构id查询使用中的水表及建筑全名
     * @param parentId
     * @return
     */
    List<WaterMeter> getWaterMeterAndFullNameByParentId(String parentId);
    
    /**
     * 根据抄表计划id查询水表及建筑全名
     * @param meterReadingProgramId
     * @return
     */
    List<WaterMeter> getWaterMeterAndFullNameByMeterReadingProgramId(String meterReadingProgramId);

}