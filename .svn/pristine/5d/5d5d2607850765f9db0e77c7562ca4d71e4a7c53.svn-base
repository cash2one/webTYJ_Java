package com.flf.mapper;

import java.util.List;

import com.flf.entity.CollectionManage;

/**
 * 银行托收办理Mapper
 * 创建时间：2015/09/25
 * @author 倪明
 *
 */
public interface CollectionManageMapper {

	List<CollectionManage> listAllCollectionManage();  //查询所有银行托收办理信息
	
	List<CollectionManage> listPageCollectionManage(CollectionManage collectionManage);  //分页查询银行托收办理信息
	
	CollectionManage getCollectionManagebyId(String collectionManageId);  //根据id查询银行托收办理信息
	
	int insertCollectionManage(CollectionManage collectionManage);  //新增银行托收办理信息
	
	int updateCollectionManage(CollectionManage collectionManage);  //修改银行托收办理信息
	
	int deleteCollectionManage(String collectionManageId);  //删除银行托收办理信息
	
	/**
	 * 根据建筑结构id、托收类型和当前日期查询启用状态的银行托收办理信息
	 * @author maogaofei
	 * @date 2016年6月1日 下午2:09:23
	 * @param buildingId 建筑结构id
	 * @param collectionType 托收类型
	 * @param dateStr 当前日期
	 * @return
	 */
	List<CollectionManage> listCollectionManagebybuildingId(String buildingId,String collectionType,String dateStr); 
	
	
	CollectionManage getContractNumber(String contractNumber);
	
}
