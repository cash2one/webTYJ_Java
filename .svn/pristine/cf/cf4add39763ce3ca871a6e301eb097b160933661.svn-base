/**
 * @Title: PropertyTypeServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-5 上午10:51:09
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Log;
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.entity.PropertyType;
import com.flf.entity.Teamworkstaff;
import com.flf.entity.WaterMeterProject;
import com.flf.mapper.PropertyMapper;
import com.flf.mapper.PropertyTypeMapper;
import com.flf.request.Tree;
import com.flf.service.LogService;
import com.flf.service.PropertyTypeService;

/**
 * @ClassName: PropertyTypeServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-5 上午10:51:09
 *
 */

public class PropertyTypeServiceImpl implements PropertyTypeService {

	private PropertyTypeMapper propertyTypeMapper;
	
	private LogService logService;
	
	private PropertyMapper propertyMapper;
	
	/*
	 * <p>Title: listPropertyType</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.PropertyTypeService#listPropertyType()
	 */

	public LogService getLogService() {
		return logService;
	}

	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}

	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public PropertyTypeMapper getPropertyTypeMapper() {
		return propertyTypeMapper;
	}

	public void setPropertyTypeMapper(PropertyTypeMapper propertyTypeMapper) {
		this.propertyTypeMapper = propertyTypeMapper;
	}

	@Override
	public List<PropertyType> listPropertyType() {
		// TODO Auto-generated method stub
		return propertyTypeMapper.listPropertyType();
	}

	@Override
	public List<Tree> treePropertyType(){
		List<Tree> treeList = new ArrayList<Tree>();
		List<PropertyType> pList = propertyTypeMapper.listPropertyType();
		for(PropertyType pt:pList){
			 Tree t = new Tree();
		     t.setId(pt.getPropertyTypeId());
		     t.setpId(pt.getParentId());
		     t.setName(pt.getPropertyTypeName());
		     treeList.add(t);
		}
		return treeList;
	}
	
	/*
	 * <p>Title: getPropertyTypeByIdRest</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.PropertyTypeService#getPropertyTypeByIdRest(java.lang.Integer)
	 */

	@Override
	public PropertyType getPropertyTypeByIdRest(String id) {
		// TODO Auto-generated method stub
		return propertyTypeMapper.selectByPrimaryKey(id);
	}

	/*
	 * <p>Title: AddPropertyType</p>
	 * <p>Description: </p>
	 * @param propertyType
	 * @see com.flf.service.PropertyTypeService#AddPropertyType(com.flf.entity.PropertyType)
	 */

	/**
	 * 修改资产分类的编号生成
	 * 王洲
	 * 2016.1.22
	 */
	@Override
	public void AddPropertyType(PropertyType propertyType) {
		// TODO Auto-generated method stub
		propertyType.setFounderTime(new Date());
		UUID uuid=UUID.randomUUID();//生成UUID
		propertyType.setPropertyTypeId(uuid.toString());
		Date date=new Date();
		String toadd = null;//设置存放资产类型编号的参数
		if(propertyType.getParentId() == null){//新增资产专业
			//查询propertyType中一级专业的最大值
			String maxNum = propertyTypeMapper.getMaxNum(propertyType.getParentId());
			if(maxNum == null){
				toadd = "001";//数据库中没有资产专业时，设置资产专业编号为001
			}else{
				//将maxNum加1设为新增的编号
				toadd = String.valueOf(Integer.parseInt(maxNum) + 1);
				for(int i = toadd.length(); i < 3; i ++){//循环补0
					toadd = "0"+toadd;
				}
			}
		}else{//新增资产专业分类
			String maxNum = propertyTypeMapper.getMaxNum(propertyType.getParentId());
			if(maxNum == null){//当此资产专业下没有分类时，设置资产专业分类编号为专业编号+001
				toadd = propertyTypeMapper.selectByPrimaryKey(propertyType.getParentId()).getPropertyTypeNumber() + "001";
			}else{
				toadd = String.valueOf(Integer.parseInt(maxNum) + 1);//有分类时，将最高位编号+1作为分类编号
				for(int i = toadd.length(); i < 6; i ++){//循环补0
					toadd = "0" + toadd;
				}
			}
		}
		propertyType.setPropertyTypeNumber(toadd);//将编号参数放入资产类型对象
		if(propertyTypeMapper.insert(propertyType)>0){
			Log log=new Log();
			log.setOperation("新增");//操作
			log.setService("专业");//业务
			log.setThing("新增专业");
			log.setRelevanceId(propertyType.getOperator());//操作人
			log.setTable("t_property_type");//操作的表名
			log.setTime(date);
			log.setRelevanceId(propertyType.getPropertyTypeId());//关联id
			logService.insertLog(log);//记录日志
		}
	}

	/*
	 * <p>Title: UpdatePropertyType</p>
	 * <p>Description: </p>
	 * @param propertyType
	 * @see com.flf.service.PropertyTypeService#UpdatePropertyType(com.flf.entity.PropertyType)
	 */

	@Override
	public void UpdatePropertyType(PropertyType propertyType) {
		// TODO Auto-generated method stub
		propertyType.setModifyTime(new Date());
		if(propertyTypeMapper.updateByPrimaryKey(propertyType)>0){
			Log log=new Log();
			log.setOperation("修改");//操作
			log.setService("专业");//业务
			log.setRelevanceId(propertyType.getOperator());//操作人
			log.setTable("t_property_type");//操作的表名
			log.setRelevanceId(propertyType.getPropertyTypeId());//关联id
			logService.insertLog(log);//记录日志
		}
	}

	/*
	 * <p>Title: DeletePropertyTypeById</p>
	 * <p>Description: </p>
	 * @param id
	 * @see com.flf.service.PropertyTypeService#DeletePropertyTypeById(java.lang.Integer)
	 */

	@Override
	public void DeletePropertyTypeById(String id) {
		// TODO Auto-generated method stub
		String ids[]=id.split("split");
		for(String pid:ids){
			List<PropertyType> propertyTypes = propertyTypeMapper.selectPropertyTypeByParentId(pid);
			for(PropertyType p:propertyTypes){
				propertyMapper.deletePropertyByParentId(p.getPropertyTypeId());			
			}
			propertyTypeMapper.deleteByPrimaryKey(pid);
		}
	}
	
	/*
	  * <p>Title: listParentPropertyType</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.PropertyTypeService#listParentPropertyType()
	  */
	
	
	@Override
	public List<PropertyType> listParentPropertyType() {
		// TODO Auto-generated method stub
		List<PropertyType> listPropertyType=new ArrayList<PropertyType>();
		//获取专业集合
		List<PropertyType> propertyTypes=propertyTypeMapper.listParentPropertyType();
		//遍历专业集合
		for (PropertyType propertyType : propertyTypes) {
			PropertyType obj=propertyType;
//			Property property=propertyTypeResult.getProperty();
//			property.setPropertyTypeId(propertyType.getPropertyTypeId());
			//获取分类的集合
			List<PropertyType> subPTList = propertyTypeMapper.selectByIds(propertyType.getPropertyTypeId());
			//将分类集合set到专业对象中
			
			//遍历分类集合获取资产
			if(subPTList!=null && subPTList.size()>0){
				//存储分类对象
				List<PropertyType> subListPropertyType=new ArrayList<PropertyType>();
				subListPropertyType.add(0, null);
				for(PropertyType pt : subPTList){
					 List<Property> pList = propertyMapper.getPropertyByparentIdRest(pt.getPropertyTypeId());
					 pList.add(0, null);
					 pt.setPropertys(pList);
					 subListPropertyType.add(pt);
					 obj.setPropertyTypes(subListPropertyType);
				}
			}else{
				obj.setPropertyTypes(subPTList);
			}
			listPropertyType.add(obj);
		}
		return listPropertyType;
	}

	@Override
	public List<PropertyType> listClassifyPropertyType() {
		// TODO Auto-generated method stub
		return propertyTypeMapper.listClassifyPropertyType();
	}

	/**
	 * 分页查询专业
	 * @author fansensen 2015-08-25
	 */
	@Override
	public PageRestful listPageParentPropertyType(PropertyType propertyType) {
		
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<PropertyType> propertyTypes = propertyTypeMapper.listPageParentPropertyType(propertyType);
		propertyTypes.add(0, null);
		pageRestful.setPropertyTypes(propertyTypes);
		pageRestful.setPage(propertyType.getPage());
		return pageRestful;
	}

	/**
	 * 分页查询分类
	 * @author fansensen 2015-08-25
	 */
	@Override
	public PageRestful listPageClassifyPropertyType(PropertyType propertyType) {
		PageRestful pageRestful = new PageRestful();
		List<PropertyType> propertyTypes = propertyTypeMapper.listPageClassifyPropertyType(propertyType);
		propertyTypes.add(0, null);
		pageRestful.setPropertyTypes(propertyTypes);
		pageRestful.setPage(propertyType.getPage());
		return pageRestful;
	}

	@Override
	public List<PropertyType> getPropertyTypeByIds(String id) {
		// TODO Auto-generated method stub
		return propertyTypeMapper.selectByIds(id);
	}

	@Override
	public List<Tree> treePropertyTypess() {
		// TODO Auto-generated method stub
		List<Tree> treeList = new ArrayList<Tree>();
		List<PropertyType> pList = propertyTypeMapper.listPropertyType();
		for (PropertyType pt : pList) {
			 Tree t = new Tree();
			 t.setId(pt.getPropertyTypeId());
		     t.setpId(pt.getParentId());
		     t.setName(pt.getPropertyTypeName());
		     treeList.add(t);
		     List<Property> propertyList = propertyMapper.selectDataByPrimaryKey(pt.getPropertyTypeId());
		     if(propertyList!=null && propertyList.size()>0){
		    	 for(Property p : propertyList){
		    		 Tree t1 = new Tree();
		    		 t1.setId(p.getPropertyId());
				     t1.setpId(p.getPropertyTypeId());
				     t1.setName(p.getPropertyName());
				     treeList.add(t1);
		    	 }
		     }
		}
		return treeList;
	}

	@Override
	public List<Tree> treeProperty() {
		// TODO Auto-generated method stub
		List<Tree> treeList = new ArrayList<Tree>();
		List<PropertyType> pList = propertyTypeMapper.listPropertyType();
		for(PropertyType pt:pList){
			List<Tree> t1 = new ArrayList<Tree>();
			 Tree t = new Tree();
		     t.setId(pt.getPropertyTypeId());
		     t.setpId(pt.getParentId());
		     t.setName(pt.getPropertyTypeName());
		     t.setTypes("pt");
		     //treeList.add(t);
		     if(pt.getParentId()!=null){
		     List<Property> tlist =propertyMapper.getPropertyByparentIdRest(pt.getPropertyTypeId());
		     if(tlist!=null && tlist.size()>0){
		    	 for(Property ty:tlist){
		    		 Tree t2= new Tree();
		    		 t2.setId(ty.getPropertyId());
		    		 t2.setName(ty.getPropertyName());
		    		 t2.setpId(ty.getPropertyTypeId());
		    		 t2.setTypes("property");
		    		 treeList.add(t2);
		    	 }
		     }
		 }
		     treeList.add(t);
		     
		}
		return treeList;
	}

}
