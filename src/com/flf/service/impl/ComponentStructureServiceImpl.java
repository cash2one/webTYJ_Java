/**
 * @Title: ComponentStructureServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午5:29:04
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ComponentProperty;
import com.flf.entity.ComponentStructure;
import com.flf.entity.PageRestful;
import com.flf.mapper.ComponentStructureMapper;
import com.flf.service.ComponentStructureService;

/**
 * @ClassName: ComponentStructureServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午5:29:04
 *
 */

public class ComponentStructureServiceImpl implements ComponentStructureService {

	private ComponentStructureMapper componentStructureMapper;
	/*
	 * <p>Title: listPageComponentStructure</p>
	 * <p>Description: </p>
	 * @param ComponentStructure
	 * @return
	 * @see com.flf.service.ComponentStructureService#listPageComponentStructure(com.flf.entity.ComponentStructure)
	 */

	public ComponentStructureMapper getComponentStructureMapper() {
		return componentStructureMapper;
	}

	public void setComponentStructureMapper(
			ComponentStructureMapper componentStructureMapper) {
		this.componentStructureMapper = componentStructureMapper;
	}

	@Override
	public PageRestful listPageComponentStructure(
			ComponentStructure ComponentStructure) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<ComponentStructure> componentStructures =componentStructureMapper.ListPageComponentStructure(ComponentStructure);	
		componentStructures.add(0,null);
		pagerestful.setComponentStructures(componentStructures);
		pagerestful.setPage(ComponentStructure.getPage());
		return pagerestful;
	}

	/*
	 * <p>Title: listComponentStructureAll</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.ComponentStructureService#listComponentStructureAll()
	 */

	@Override
	public List<ComponentStructure> listComponentStructureAll() {
		// TODO Auto-generated method stub
		return componentStructureMapper.ListComponentStructureAll();
	}

	/*
	 * <p>Title: getComponentStructureByIdRest</p>
	 * <p>Description: </p>
	 * @param ComponentStructureId
	 * @return
	 * @see com.flf.service.ComponentStructureService#getComponentStructureByIdRest(java.lang.String)
	 */

	@Override
	public ComponentStructure getComponentStructureByIdRest(
			String ComponentStructureId) {
		// TODO Auto-generated method stub
		return componentStructureMapper.selectComponentStructureById(ComponentStructureId);
	}

	/*
	 * <p>Title: AddComponentStructure</p>
	 * <p>Description: </p>
	 * @param ComponentStructure
	 * @see com.flf.service.ComponentStructureService#AddComponentStructure(com.flf.entity.ComponentStructure)
	 */

	@Override
	public void AddComponentStructure(ComponentStructure ComponentStructure) {
		// TODO Auto-generated method stub
		componentStructureMapper.insertComponentStructure(ComponentStructure);

	}

	/*
	 * <p>Title: UpdateComponentStructure</p>
	 * <p>Description: </p>
	 * @param ComponentStructure
	 * @see com.flf.service.ComponentStructureService#UpdateComponentStructure(com.flf.entity.ComponentStructure)
	 */

	@Override
	public void UpdateComponentStructure(ComponentStructure ComponentStructure) {
		// TODO Auto-generated method stub
		componentStructureMapper.updateComponentStructure(ComponentStructure);
	}

	/*
	 * <p>Title: DeleteComponentStructureById</p>
	 * <p>Description: </p>
	 * @param ComponentStructureId
	 * @see com.flf.service.ComponentStructureService#DeleteComponentStructureById(java.lang.String)
	 */

	@Override
	public void DeleteComponentStructureById(String ComponentStructureId) {
		// TODO Auto-generated method stub

		componentStructureMapper.deleteComponentStructure(ComponentStructureId);
	}

}
