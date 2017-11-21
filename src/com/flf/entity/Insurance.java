/**
 * @Title: Insurance.java
 * @Package com.flf.entity
 * @Description: 保险公司实体类
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件有限公司
 * @date 2016年7月21日
 * @version V1.0
 */
package com.flf.entity;

/**
 * @ClassName: Insurance
 * @Description: 保险公司实体。
 * @author ylq
 * @date 2016年7月21日
 * 
 */
@javax.xml.bind.annotation.XmlRootElement(name = "Insurance")
public class Insurance {
    private String insuranceCompanyId;//保险公司ID
    private String insuranceCompanyName;//保险公司名称
    private String areaCompanyId;//区域公司ID
    private String areaCompanyName;//区域公司名称
    
    private Page page;//分页所用Page

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getInsuranceCompanyId() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyId(String insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public String getAreaCompanyId() {
		return areaCompanyId;
	}

	public void setAreaCompanyId(String areaCompanyId) {
		this.areaCompanyId = areaCompanyId;
	}

	public String getAreaCompanyName() {
		return areaCompanyName;
	}

	public void setAreaCompanyName(String areaCompanyName) {
		this.areaCompanyName = areaCompanyName;
	}
	
}
