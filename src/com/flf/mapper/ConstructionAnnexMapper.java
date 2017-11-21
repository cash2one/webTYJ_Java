package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionAnnex;
/**
 * 四.	施工图纸附件
 * @author 陶勇超
 * 2015-8-31
 */
public interface ConstructionAnnexMapper {
	int deleteConstructionAnnex(String fileId);//删除施工图纸附件信息记录

	int insertConstructionAnnex(ConstructionAnnex ConstructionAnnex);//添加施工图纸附件 信息记录

    List<ConstructionAnnex> listAllConstructionAnnex();//查询所有施工图纸附件信息记录

    ConstructionAnnex getConstructionAnnexbyId(String fileId);//通过Id查询施工图纸附件信息记录

    int updateConstructionAnnex(ConstructionAnnex ConstructionAnnex);//修改施工图纸附件 信息记录
    
    List<ConstructionAnnex> getConstructionAnnexbyApplyId(String applyId);//根据申请id获取施工图纸附件 信息记录

}
