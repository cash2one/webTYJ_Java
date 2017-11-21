/**
 * @Title: ArchitectureNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-15 上午11:56:42
 * @version V1.0
 */

package com.flf.service.impl;

import com.flf.entity.ArchitectureNew;
import com.flf.mapper.ArchitectureNewMapper;
import com.flf.service.ArchitectureNewService;

/**
 * @ClassName: ArchitectureNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-15 上午11:56:42
 *
 */

public class ArchitectureNewServiceImpl implements ArchitectureNewService {

	private ArchitectureNewMapper architectureNewMapper;
	
	
	
	/*
	 * <p>Title: getArchitectureNewRest</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.ArchitectureNewService#getArchitectureNewRest(java.lang.String)
	 */

	public ArchitectureNewMapper getArchitectureNewMapper() {
		return architectureNewMapper;
	}

	public void setArchitectureNewMapper(ArchitectureNewMapper architectureNewMapper) {
		this.architectureNewMapper = architectureNewMapper;
	}

	@Override
	public ArchitectureNew getArchitectureNewRest(String id) {
		// TODO Auto-generated method stub
		return architectureNewMapper.selectArchitectureNewById(id);
	}

	/*
	 * <p>Title: insertArchitectureNewRestful</p>.
	 * <p>Description: </p>
	 * @param ArchitectureNew
	 * @see com.flf.service.ArchitectureNewService#insertArchitectureNewRestful(com.flf.entity.ArchitectureNew)
	 */

	@Override
	public void insertArchitectureNewRestful(ArchitectureNew ArchitectureNew) {
		// TODO Auto-generated method stub
		architectureNewMapper.insertArchitectureNew(ArchitectureNew);
	}

}
