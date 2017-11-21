/**
 * @Title: HouseGateService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-23 下午4:29:49
 * @version V1.0
 */

package com.flf.service;

import java.util.List;

import javax.jws.WebService;

import com.flf.entity.HouseGate;

/**
 * @ClassName: HouseGateService
 * @Description: TODO
 * @author wangyang
 * @date 2015-5-23 下午4:29:49
 *
 */
/**
  * @ClassName: HouseGateService
  * @Description: TODO
  * @author wangyang
  * @date 2015-5-27 下午5:51:10
  *
  */
@WebService
public interface HouseGateService {
	List<HouseGate> listPageHouseGate(HouseGate houseGate);
	
	List<HouseGate> listAllHouseGate();
	
	HouseGate getHouseGateById(String id);
	
	int insertHouseGate(HouseGate houseGate);
	
	int updateHouseGate(HouseGate houseGate);
	
	int deleteHouseGate(String id);
	
	//Cxf
	String listAllHouseGateCxf();
    
	String getHouseGateByIdCxf(String id);

    String insertHouseGateCxf(String houseGate);
    
    String updateHouseGateCxf(String houseGate);
    
    String deleteHouseGateCxf(String id);    
	
    String listHouseGateBygateAccountId(String gateAccountId);
    
}
