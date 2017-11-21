/**
 * @Title: AfterSaleServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-4-20 下午4:53:43
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.flf.entity.AfterSale;
import com.flf.entity.AfterSaleQuery;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.PropertyType;
import com.flf.mapper.AfterSaleMapper;
import com.flf.mapper.AfterSaleQueryMapper;
import com.flf.service.AfterSaleService;

/**
 * @ClassName: AfterSaleServiceImpl
 * @Description: TODO
 * @author wangyang
 * @date 2015-4-20 下午4:53:43
 *
 */

public class AfterSaleServiceImpl implements AfterSaleService {

	private AfterSaleMapper afterSaleMapper;
	
	private AfterSaleQueryMapper afterSaleQueryMapper;
	
	
	
	/*
	 * <p>Title: listAllAfterSale</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.AfterSaleService#listAllAfterSale()
	 */

	public AfterSaleMapper getAfterSaleMapper() {
		return afterSaleMapper;
	}

	public void setAfterSaleMapper(AfterSaleMapper afterSaleMapper) {
		this.afterSaleMapper = afterSaleMapper;
	}

	
	
	public AfterSaleQueryMapper getAfterSaleQueryMapper() {
		return afterSaleQueryMapper;
	}

	public void setAfterSaleQueryMapper(AfterSaleQueryMapper afterSaleQueryMapper) {
		this.afterSaleQueryMapper = afterSaleQueryMapper;
	}

	@Override
	public List<AfterSale> listAllAfterSale() {
		// TODO Auto-generated method stub
		return afterSaleMapper.listAllAfterSale();
	}

	/*
	 * <p>Title: listPageAfterSale</p>
	 * <p>Description: </p>
	 * @param afterSale
	 * @return
	 * @see com.flf.service.AfterSaleService#listPageAfterSale(com.flf.entity.AfterSale)
	 */

	@Override
	public List<AfterSale> listPageAfterSale(AfterSaleQuery afterSale) {
		// TODO Auto-generated method stub
		return afterSaleMapper.listPageAfterSale(afterSale);
	}

	/*
	 * <p>Title: getAfterSaleById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.AfterSaleService#getAfterSaleById(int)
	 */

	@Override
	public AfterSale getAfterSaleById(String id) {
		// TODO Auto-generated method stub
		return afterSaleMapper.getAfterSaleById(id);
	}

	/*
	 * <p>Title: insertAfterSale</p>
	 * <p>Description: </p>
	 * @param afterSale
	 * @return
	 * @see com.flf.service.AfterSaleService#insertAfterSale(com.flf.entity.AfterSale)
	 */

	@Override
	public int insertAfterSale(AfterSale afterSale) {
		// TODO Auto-generated method stub
		return afterSaleMapper.insertAfterSale(afterSale);
	}

	/*
	 * <p>Title: updateAfterSale</p>
	 * <p>Description: </p>
	 * @param afterSale
	 * @return
	 * @see com.flf.service.AfterSaleService#updateAfterSale(com.flf.entity.AfterSale)
	 */

	@Override
	public int updateAfterSale(AfterSale afterSale) {
		// TODO Auto-generated method stub
		return afterSaleMapper.updateAfterSale(afterSale);
	}

	/*
	 * <p>Title: listPageAfterSaleRestful</p>
	 * <p>Description: 售后管理列表查询所有数据</p>
	 * @param afterSale
	 * @return
	 * @see com.flf.service.AfterSaleService#listPageAfterSaleRestful(com.flf.entity.AfterSale)
	 */

	@Override
	public PageRestful listPageAfterSaleRestful(AfterSaleQuery afterSaleQuery) {
		PageRestful pagerestful=new PageRestful();
		
		List<String> list = afterSaleQuery.getPropertyTypeNameList();
		//获取售后管理表中的所有数据包括条件查询
		List<AfterSale> afterSales = new ArrayList<AfterSale>();
		for (String propertyType : list) {
			afterSaleQuery.setPropertyTypeName(propertyType);
			AfterSale afterSale = afterSaleMapper.listPageAfterSaleSingle(afterSaleQuery);
			afterSales.add(afterSale);
		}
		//获取查询条件中的项目数据
		List<Project> department = afterSaleMapper.listProjectName();
		//加入空数据
		afterSales.add(0,null);
		pagerestful.setAfterSales(afterSales);
		pagerestful.setPage(afterSaleQuery.getPage());
		pagerestful.setDepartments(department);
		return pagerestful;
	}

	/*
	 * <p>Title: listAllAfterSaleRestful</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.AfterSaleService#listAllAfterSaleRestful()
	 */

	@Override
	public List<AfterSale> listAllAfterSaleRestful() {
		 //TODO Auto-generated method stub
		return afterSaleMapper.listAllAfterSale();
	}

	/*
	 * <p>Title: getAfterSaleByIdRestful</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.AfterSaleService#getAfterSaleByIdRestful(int)
	 */

	@Override
	public AfterSale getAfterSaleByIdRestful(String id) {
		// TODO Auto-generated method stub
		return afterSaleMapper.getAfterSaleById(id);
	}

	/*
	 * <p>Title: deleteAfterSaleRestful</p>
	 * <p>Description: </p>
	 * @param id
	 * @see com.flf.service.AfterSaleService#deleteAfterSaleRestful(int)
	 */


	/*
	 * <p>Title: insertAfterSaleRestful</p>
	 * <p>Description: </p>
	 * @param afterSale
	 * @see com.flf.service.AfterSaleService#insertAfterSaleRestful(com.flf.entity.AfterSale)
	 */

	@Override
	public void insertAfterSaleRestful(AfterSale afterSale) {
		// TODO Auto-generated method stub
		afterSaleMapper.insertAfterSale(afterSale);
	}

	/*
	 * <p>Title: updateAfterSaleRestful</p>
	 * <p>Description: </p>
	 * @param afterSale
	 * @see com.flf.service.AfterSaleService#updateAfterSaleRestful(com.flf.entity.AfterSale)
	 */

	@Override
	public void updateAfterSaleRestful(AfterSale afterSale) {
		// TODO Auto-generated method stub
		afterSaleMapper.updateAfterSale(afterSale);
	}

	/*
	  * <p>Title: deleteAfterSaleRestful</p>
	  * <p>Description: </p>
	  * @param afterSales
	  * @see com.flf.service.AfterSaleService#deleteAfterSaleRestful(java.util.List)
	  */
	
	
	@Override
	public void deleteAfterSaleRestful(String id) {
		// TODO Auto-generated method stub
		afterSaleMapper.deleteAfterSale(id);
	}

	/*
	 * <p>Title: listProjectAndTypeName</p>
	 * <p>Description: 查询项目表中的项目 </p>
	 * (non-Javadoc)
	 * @see com.flf.service.AfterSaleService#listProjectAndTypeName()
	 */
	@Override
	public PageRestful listProjectAndTypeName(AfterSaleQuery afterSaleQuery) {
		PageRestful pagerestful = new PageRestful();
		//!结束
		List<AfterSale> afterSales = afterSaleMapper.listPageAfterSale(afterSaleQuery);
		//List<Project> department = afterSaleMapper.listProjectName();
		//List<PropertyType> propertytype = afterSaleMapper.listPropertyType();
		afterSales.add(0, null);
		pagerestful.setAfterSales(afterSales);
		pagerestful.setPage(afterSaleQuery.getPage());
		//pagerestful.setDepartments(department);
		//pagerestful.setPropertyTypes(propertytype);
		return pagerestful;
	}

	/*
	 * <p>Title: updateGuaranteeById</p>
	 * <p>Description: 根据传入的id修改保修字段的值 </p>
	 * @see com.flf.service.AfterSaleService#updateGuaranteeById(java.lang.String)
	 */
	@Override
	public void updateGuaranteeById(String id){
		if(id != null && id != ""){
			try {
				afterSaleMapper.updateGuaranteeById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查询所有项目放入下拉框
	 */
	@Override
	public List<Project> listProjectName(){
		return afterSaleMapper.listProjectName();
	}
	
	/**
	 * 查询所有专业
	 */
	@Override
	public List<PropertyType> listPropertyType(){
		return afterSaleMapper.listPropertyType();
	}

	@Override
	public List<AfterSale> getAfterSaleInfoByProjectId(String projectId) {
		// TODO Auto-generated method stub
		return afterSaleMapper.getAfterSaleInfoByProjectId(projectId);
	}

	@Override
	public void updateAfterSaleRelationIdById(AfterSale afterSale) {
		// TODO Auto-generated method stub
		afterSaleMapper.updateAfterSaleRelationIdById(afterSale);
	}

	@Override
	public PageRestful listPageAfterSaleByProcessId(AfterSale afterSale) {
		// TODO Auto-generated method stub
		PageRestful pagerestful = new PageRestful();
		List<AfterSale> afterSalelist = afterSaleMapper.listPageAfterSaleByProcessId(afterSale);
		afterSalelist.add(0,null);
		pagerestful.setPage(afterSale.getPage());
		pagerestful.setAfterSales(afterSalelist);
		return pagerestful;
	}

	@Override
	public void updateAfterSaleProcessStateByProcessId(AfterSale afterSale) {
		// TODO Auto-generated method stub
		afterSaleMapper.updateAfterSaleProcessStateByProcessId(afterSale);
	}
}
