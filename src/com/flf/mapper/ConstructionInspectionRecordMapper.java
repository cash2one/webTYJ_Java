package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionInspectionRecord;

/**
 * 施工巡检记录表
 * @author 陶勇超
 *  2015-8-31
 */
public interface ConstructionInspectionRecordMapper {
	int deleteConstructionInspectionRecord(String recordId);//删除施工巡检记录表信息记录

	int insertConstructionInspectionRecord(ConstructionInspectionRecord constructionInspectionRecord);//添加施工巡检记录表信息记录

    List<ConstructionInspectionRecord> listAllConstructionInspectionRecord();//查询所有施工巡检记录表信息记录

    ConstructionInspectionRecord getConstructionInspectionRecordbyId(String recordId);//通过Id查询施工巡检记录表信息记录

    int updateConstructionInspectionRecord(ConstructionInspectionRecord constructionInspectionRecord);//修改施工巡检记录表信息记录


}
