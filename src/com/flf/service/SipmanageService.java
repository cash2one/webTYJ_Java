/**
 * @Title: SipmanageService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-4 下午1:13:08
 * @version V1.0
 */

package com.flf.service;

import javax.jws.WebService;

import com.flf.entity.Sipmanage;

/**
 * @ClassName: SipmanageService
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-4 下午1:13:08
 *
 */
@WebService
public interface SipmanageService {
	int updateLoginState(String sip,int state);
	String getSipmanageByhouseId(String houseId);
	String getSipBySipName(String sipName);
}
