package com.flf.mapper;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import com.flf.entity.MeterReadingComplaints;
import com.flf.entity.MeterReadingComplaints;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeterReadingComplaintsMapper {
	int deleteMeterReadingComplaints(String meterReadingComplaintsId);// 删除抄表投诉信息

    int insertMeterReadingComplaints(MeterReadingComplaints meterReadingComplaints); //新增抄表投诉信息

    List<MeterReadingComplaints> listPageMeterReadingComplaints(MeterReadingComplaints meterReadingComplaints); // 分页查询抄表投诉信息
    
    List<MeterReadingComplaints> listAllMeterReadingComplaints();  // 查询所有抄表投诉信息

    MeterReadingComplaints getMeterReadingComplaintsbyId(String meterReadingComplaintsId);  //根据抄表投诉id查询抄表投诉信息

    int updateMeterReadingComplaints(MeterReadingComplaints meterReadingComplaints); // 修改抄表投诉信息
}