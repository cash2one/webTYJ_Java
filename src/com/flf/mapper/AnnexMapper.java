package com.flf.mapper;

import java.util.List;

import com.flf.entity.Annex;

public interface AnnexMapper {

	int insertAnnex(Annex annex);//添加附件信息
	int insertAnnexUUID(Annex annex);//添加附件信息(UUID)
	List<Annex> getAnnexbyRelationId(String relationId);//通过关系id获取附件
	int deleteAnnex(String pactId); //删除合同文件
	int updateAnnex(Annex annex);//更新文件
	Annex findAnnexByRelationIdAndAddress(String relationId,String annexAddress);//根据id和地址获取对象
	int deleteAnnexByRelationId(String relationId);//根据关联id删除附件;
	
	List<Annex> getAnnexByPactId();//根据合同id获取附件
}
