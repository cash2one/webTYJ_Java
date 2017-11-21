package com.flf.entity;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

//售后管理查询条件
@XmlRootElement(name="AfterSaleQuery")
public class AfterSaleQuery {
	
	//项目名
	private String responsibleDepartmentId;
	
	//专业集合
	private List<String> propertyTypeNameList;
	
	//专业
	private String propertyTypeName;
	
	//来源集合
	private List<String> sourceList;
	
	//来源
	private String source;
	
	//进度集合
	private List<String> processList;
	
	//进度
	private String process;
	
	//资产名称
	private String propertyName;
	
	private Page page;
	
	//保修单位
	private String guarantee;
	
	//地址
	private String homeAddress;
	
	//合同号
	private String contractNum;
	
	//业主姓名
	private String clientName;
	
	//负责项目
	private String responsibleProject;

	public String getResponsibleProject() {
		return responsibleProject;
	}

	public void setResponsibleProject(String responsibleProject) {
		this.responsibleProject = responsibleProject;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getResponsibleDepartmentId() {
		return responsibleDepartmentId;
	}

	public void setResponsibleDepartmentId(String responsibleDepartmentId) {
		this.responsibleDepartmentId = responsibleDepartmentId;
	}

	public List<String> getPropertyTypeNameList() {
		return propertyTypeNameList;
	}

	public void setPropertyTypeNameList(List<String> propertyTypeNameList) {
		this.propertyTypeNameList = propertyTypeNameList;
	}

	public List<String> getSourceList() {
		return sourceList;
	}

	public void setSourceList(List<String> sourceList) {
		this.sourceList = sourceList;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<String> getProcessList() {
		return processList;
	}

	public void setProcessList(List<String> processList) {
		this.processList = processList;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}
}
