package com.flf.mapper;

import java.util.List;


import com.flf.entity.Inform;

public interface InformMapper {
	List<Inform> listPageInform(Inform inform);//分页显示所有内部通知信息
	List<Inform> listAllInform();//显示所有内部通知信息
	List<Inform> listAllsInform();//显示所有内部通知信息
	int insertInform(Inform inform);//添加内部通知信息
	
	int updateInform(Inform inform);//修改内部通知信息
	
	int deleteInform(String id);//删除内部通知信息
	
	Inform getInformById(String id);//根据id查询内部通知信息
	
	Inform getInforms(String id);

	int updateInforms(Inform inform);

	int insertInforms(Inform inform);

	int deleteInforms(String id);
	
	List<Inform> listAllsinformByUserId(String userId);//根据userId显示所有内部公告通知信息
}
