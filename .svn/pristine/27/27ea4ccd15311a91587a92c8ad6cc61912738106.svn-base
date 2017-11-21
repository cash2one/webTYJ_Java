package com.flf.mapper;

import java.util.List;

import javax.ws.rs.PathParam;

import com.flf.entity.PropertyType;
import com.flf.entity.TeamPermissions;



public interface PropertyTypeMapper {
	
	List<PropertyType> listPropertyType();  //查询所有专业资产分类
	PropertyType selectByPrimaryKey(String propertyTypeId);  //id专业资产分类
	int insert(PropertyType propertyType);   //添加专业资产分类
	int updateByPrimaryKey(PropertyType propertyType);   //添加专业资产分类
	int deleteByPrimaryKey(String propertyTypeId);  //删除专业资产分类
	List<PropertyType> listParentPropertyType();//查询所有的父节点类型
	List<PropertyType> listPageParentPropertyType(PropertyType propertyType);//分页查询父节点 fansensen
	List<PropertyType> listClassifyPropertyType();//查询所有分类
	List<PropertyType> listPageClassifyPropertyType(PropertyType propertyType);//分页查询分类fansensen

	List<PropertyType> selectByIds(String propertyTypeId); //查询父节点下的子节点
	
	/**
	 * 获取资产专业中的编号最大值（分为专业和分类两种）
	 * 王洲
	 * 2016.1.21
	 * @param parentId
	 * @return
	 */
	String getMaxNum(String parentId);
	
	PropertyType selectPropertyTypeByProperty(String propertyTypeId);
	
	/**
	 * 根据Id查找专业和分类
	 * 陈浪
	 * 2016.3.24
	 * @param propertyTypeId
	 */
	
	List<PropertyType> selectPropertyTypeByParentId(String propertyTypeId);
}