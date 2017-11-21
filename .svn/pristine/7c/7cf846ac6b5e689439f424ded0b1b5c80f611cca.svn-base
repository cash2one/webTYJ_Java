/**
 * @Title: InsuranceService.java
 * @Package com.flf.service
 * @Description: 保险公司WebService
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件有限公司
 * @date 2016年7月21日
 * @version V1.0
 */
package com.flf.service;
/**
 * @ClassName: InsuranceService
 * @Description: 保险公司WebService
 * @author ylq
 * @date 2016年7月21日
 */
@javax.jws.WebService
@javax.ws.rs.Path("/InsuranceService")
public interface InsuranceService {
	/**
	 * 获取所有的保险公司列表
	 */
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/listPageInsuranceCompanyRecord")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public com.flf.entity.PageRestful listPageInsuranceCompanyRecord(com.flf.entity.Insurance insuranceCompany);
}
