/**
 * @Title: PooledNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-15 上午11:52:46
 * @version V1.0
 */

package com.flf.service.impl;

import com.flf.entity.PooledNew;
import com.flf.mapper.PooledNewMapper;
import com.flf.service.PooledNewService;

/**
 * @ClassName: PooledNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-15 上午11:52:46
 *
 */

public class PooledNewServiceImpl implements PooledNewService {

	private PooledNewMapper pooledNewMapper;
	/*
	 * <p>Title: getPooledNewRest</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.PooledNewService#getPooledNewRest(java.lang.String)
	 */

	public PooledNewMapper getPooledNewMapper() {
		return pooledNewMapper;
	}

	public void setPooledNewMapper(PooledNewMapper pooledNewMapper) {
		this.pooledNewMapper = pooledNewMapper;
	}

	@Override
	public PooledNew getPooledNewRest(String id) {
		// TODO Auto-generated method stub
		return pooledNewMapper.selectPooledNewById(id);
	}

	/*
	 * <p>Title: insertPooledNewRestful</p>
	 * <p>Description: </p>
	 * @param PooledNew
	 * @see com.flf.service.PooledNewService#insertPooledNewRestful(com.flf.entity.PooledNew)
	 */

	@Override
	public void insertPooledNewRestful(PooledNew PooledNew) {
		// TODO Auto-generated method stub
		pooledNewMapper.insertPooledNew(PooledNew);

	}

}
