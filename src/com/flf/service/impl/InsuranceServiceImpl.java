/**
 * @Title: InsuranceServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: implements com.flf.service.InsuranceService
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件有限公司
 * @date 2016年7月21日
 * @version V1.0
 */
package com.flf.service.impl;

/**
 * @ClassName: InsuranceServiceImpl
 * @Description: 保险公司增删改查。
 * @author ylq
 * @date 2016年7月21日
 * 
 */
public class InsuranceServiceImpl implements com.flf.service.InsuranceService{
	
	@org.springframework.beans.factory.annotation.Autowired
	private com.flf.mapper.InsuranceMapper insuranceMapper;

	@Override
	public com.flf.entity.PageRestful listPageInsuranceCompanyRecord(com.flf.entity.Insurance insuranceCompany) {
		com.flf.entity.PageRestful pageRestful = new com.flf.entity.PageRestful();
		java.util.List<com.flf.entity.Insurance> insuranceCompanyList = insuranceMapper.listPageInsuranceCompanyRecord(insuranceCompany);
		insuranceCompanyList.add(0,null);
		pageRestful.setInsuranceCompany(insuranceCompanyList);
		pageRestful.setPage(insuranceCompany.getPage());
		return pageRestful;
	}

}