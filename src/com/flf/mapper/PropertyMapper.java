package com.flf.mapper;

import java.util.List;

import com.flf.entity.Property;

public interface PropertyMapper {
	
	List<Property> listProperty(Property property);  //查询所有资产信息
	List<Property> listPropertys(Property property);  //查询所有资产信息
	List<Property> listPropertyAll(); //查询所有资产信息
	Property selectByPrimaryKey(String propertyId);//根据id资产信息
	List<Property> selectDataByPrimaryKey(String propertyTypeId);//根据id资产信息
	int insert(Property property);//添加资产信息
	int updateByPrimaryKey(Property property);//修改资产信息
	int deleteByPrimaryKey(String propertyId);//根据id删除资产信息
	List<Property> getPropertyByparentIdRest(String parentId);//根据父节点id查询专业资产列表
	List<Property> listPropertyByParentPropertyType(Property property);//根据专业和资产信息查询所有类型下的资产
	
	/**
	 * 根据二级资产分类id查询此分类下已有多少资产，将返回的数据用在编号生成中
	 * 王洲
	 * 2016.1.22
	 * @param propertyTypeId
	 * @return
	 */
	int getCountByPropertyTypeId(String propertyTypeId);
	
	/**
	 * 分页查询资产及关联的分类、专业
	 * 朱琪
	 * 2016.2.22
	 * @param property
	 * @return
	 */
	List<Property> listPageProperty(Property property);
	
	List<Property> listPropertyType(Property property);
	
	/**
	 * 根据父节点id删除资产
	 * 陈浪
	 * 2016.3.24
	 * @param propertyTypeId
	 * @return 
	 */
	
	int deletePropertyByParentId(String propertyTypeId);
}