/**
 * @Title: SipmanageMapper.java
 * @Package com.flf.mapper
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-4 下午12:43:08
 * @version V1.0
 */

package com.flf.mapper;

import java.util.List;

import com.flf.entity.Sipmanage;

/**
 * @ClassName: SipmanageMapper
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-4 下午12:43:08
 *
 */

public interface SipmanageMapper {
	int updateLoginState(String sip,int state);
	Sipmanage getSipmanageByhouseId(String houseId);
	Sipmanage getSipByhouseAddress(String houseAddress);
	Sipmanage getSipBySipName(String sipName);
	
	/**
	 * 根据使用状态0来查询出所有有效的数据
	 * @author 王洲
	 * 2016.02.27
	 * @return
	 */
	List<Sipmanage> listSipmanageByState();
	
	/**
	 * 根据sip账号id修改状态
	 * @param sipId
	 * @return
	 * 王洲
	 * 2016.02.27
	 */
	int updateStateBySipId(String sipId);
}
