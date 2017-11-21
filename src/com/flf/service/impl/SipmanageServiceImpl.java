/**
 * @Title: SipmanageServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-4 下午1:14:27
 * @version V1.0
 */

package com.flf.service.impl;

import net.sf.json.JSONObject;

import com.flf.entity.Sipmanage;
import com.flf.mapper.SipmanageMapper;
import com.flf.service.SipmanageService;

/**
 * @ClassName: SipmanageServiceImpl
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-4 下午1:14:27
 *
 */

public class SipmanageServiceImpl implements SipmanageService {

	private SipmanageMapper sipmanageMapper;
	
	/*
	 * <p>Title: updateLoginState</p>
	 * <p>Description: </p>
	 * @param sip
	 * @param state
	 * @return
	 * @see com.flf.service.SipmanageService#updateLoginState(java.lang.String, int)
	 */

	public SipmanageMapper getSipmanageMapper() {
		return sipmanageMapper;
	}



	public void setSipmanageMapper(SipmanageMapper sipmanageMapper) {
		this.sipmanageMapper = sipmanageMapper;
	}



	@Override
	public int updateLoginState(String sip, int state) {
		// TODO Auto-generated method stub
		return sipmanageMapper.updateLoginState(sip, state);
	}
	
	
	/*
	  * <p>Title: getSipmanageByhouseId</p>
	  * <p>Description: </p>
	  * @param houseId
	  * @return
	  * @see com.flf.service.SipmanageService#getSipmanageByhouseId(java.lang.String)
	  */
	
	
	@Override
	public String getSipmanageByhouseId(String houseId) {
		// TODO Auto-generated method stub
		Sipmanage sipmanage=sipmanageMapper.getSipmanageByhouseId(houseId);
		JSONObject json=JSONObject.fromObject(sipmanage);
		return json.toString();
	}



	@Override
	public String getSipBySipName(String sipName) {
		Sipmanage sip = sipmanageMapper.getSipBySipName(sipName);
		JSONObject json = JSONObject.fromObject(sip);
		return json.toString();
	}

}
