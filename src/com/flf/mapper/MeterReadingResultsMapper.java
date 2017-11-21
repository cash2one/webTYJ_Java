package com.flf.mapper;

import java.util.List;

import com.flf.entity.MeterReadingResults;
import com.flf.entity.SearchMeter;

public interface MeterReadingResultsMapper {
    int deleteByPrimaryKey(String meterExecutiveId);

    int insert(MeterReadingResults record);

    int insertSelective(MeterReadingResults record);

    MeterReadingResults selectByPrimaryKey(String meterExecutiveId);

    int updateByPrimaryKeySelective(MeterReadingResults record);

    int updateByPrimaryKey(MeterReadingResults record);
    
    List<MeterReadingResults> listAllMeterReadingResults();  // 查询所有抄表执行结果信息
    List<MeterReadingResults> listPageMeterReadingResults(SearchMeter searchMeter); //抄表执行结果多条件查询接口
}