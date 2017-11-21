/**
 * @Title: PropertyResult.java
 * @Package com.flf.request
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-15 上午9:46:09
 * @version V1.0
 */

package com.flf.request;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.CassetRepository;
import com.flf.entity.Contract;
import com.flf.entity.Property;

/**
 * @ClassName: PropertyResult
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-15 上午9:46:09
 *
 */
//合同初始化Result
@XmlRootElement(name = "PropertyResult")
public class PropertyResult {
	
	private Contract contract;//合同信息
	
	private List<String> propertys;//资产id集合
	
	private List<String> buildingStructureNews;//建筑结构id集合
	
	private List<Property> propertyList;
	
	private List<String> functionals;//功能区id集合
	private List<Date> startTimes;//启动时间集合
	public List<Property> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	public List<String> getBuildingStructureNews() {
		return buildingStructureNews;
	}
	public void setBuildingStructureNews(List<String> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}

	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public List<String> getPropertys() {
		return propertys;
	}
	public void setPropertys(List<String> propertys) {
		this.propertys = propertys;
	}
	public List<String> getFunctionals() {
		return functionals;
	}
	public void setFunctionals(List<String> functionals) {
		this.functionals = functionals;
	}
	public List<Date> getStartTimes() {
		return startTimes;
	}
	public void setStartTimes(List<Date> startTimes) {
		this.startTimes = startTimes;
	}
	

}
