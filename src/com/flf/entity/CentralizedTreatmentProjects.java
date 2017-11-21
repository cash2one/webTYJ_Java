package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 集中处理项目表
 * @author shaozheng
 *	2015-7-16
 */
@XmlRootElement(name = "CentralizedTreatmentProjects")
public class CentralizedTreatmentProjects {
	
	private String projectId;//集中处理项目id
	private String projectName;//集中处理名称
	private Integer projectState;//集中处理项状态   (0关闭 1启动  2完成)
	private Integer projectType;//集中处理项目类别
	private Integer projectProfessional;//集中处理项目专业
	private String projectCreate;//集中处理项目创建人
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
	private Date projectStartTime;//开始时间
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
	private Date projectEndTime;//结束时间
	private Double projectEstimateArea;//项目累计面积
	private String projetctEstimaNum;//项目预计个数
	private Double projectRealityArea;//项目实际面积
	private String projectRealityNum;//项目实际个数
	private String remarks;//备注说明
	private String createTime;//创建时间
	private String principal;//集中项负责人
	private double projectEstimateMoney; //项目累计金额
	
	private Staff staff;//人员表
	
	private Page page; 
	private String state;//集中项 状态查询
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getProjectType() {
		return projectType;
	}
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	public Integer getProjectProfessional() {
		return projectProfessional;
	}
	public void setProjectProfessional(Integer projectProfessional) {
		this.projectProfessional = projectProfessional;
	}
	public String getProjectCreate() {
		return projectCreate;
	}
	public void setProjectCreate(String projectCreate) {
		this.projectCreate = projectCreate;
	}
	public Date getProjectStartTime() {
		return projectStartTime;
	}
	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}
	public Date getProjectEndTime() {
		return projectEndTime;
	}
	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}
	public Double getProjectEstimateArea() {
		return projectEstimateArea;
	}
	public void setProjectEstimateArea(Double projectEstimateArea) {
		this.projectEstimateArea = projectEstimateArea;
	}
	public String getProjetctEstimaNum() {
		return projetctEstimaNum;
	}
	public void setProjetctEstimaNum(String projetctEstimaNum) {
		this.projetctEstimaNum = projetctEstimaNum;
	}
	public Double getProjectRealityArea() {
		return projectRealityArea;
	}
	public void setProjectRealityArea(Double projectRealityArea) {
		this.projectRealityArea = projectRealityArea;
	}
	public String getProjectRealityNum() {
		return projectRealityNum;
	}
	public void setProjectRealityNum(String projectRealityNum) {
		this.projectRealityNum = projectRealityNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getProjectState() {
		return projectState;
	}
	public void setProjectState(Integer projectState) {
		this.projectState = projectState;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public double getProjectEstimateMoney() {
		return projectEstimateMoney;
	}
	public void setProjectEstimateMoney(double projectEstimateMoney) {
		this.projectEstimateMoney = projectEstimateMoney;
	}
	
	
}
