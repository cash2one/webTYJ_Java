package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 一.	业主装修申请表
 * @author taoyongchao
 *  2015-8-20
 */
@XmlRootElement(name="OwnerRenovationApply")
public class OwnerRenovationApply {
	
	private String applyId;//业主装修申请ID
	private String custId;  //业主ID
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date applyTime;  //申请时间
	private Integer applyType;  //申请状态  	0关闭    1完成	2处理中
	private Integer decorateType;  //装修类型 0.自装 1.工装
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date estimatedStarTime; //预计开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date estimatedFinishTime; //预计完成时间
	private String dismantlesWallArea;  //预计拆墙面积
	private String actualDismantlesWallArea; //实际拆墙面积
	private String angentId;  //经办人ID
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date closeTime;  //关闭时间
	private String closePersonId;  //关闭操作人ID
	private String closeRemarks;   //关闭原因
	private String serviceId;
	private ServiceRequest serviceRequest;//服务请求
	
	private List<DecorateAnnex> decorateAnnexList;//装修图纸附件
	private List<DecorateComponentRecords> decorateComponentRecordsList;//装修组件记录表
	private DecorateAssociatedRecords decorateAssociatedRecords;//装修单位关联表
	private List<DecoratePersonnelAssociated> decoratePersonnelAssociatedList;//装修人员关联表
	private List<DecoreateDiscloseInformation> decoreateDiscloseInformationList;//装修单位提交资料记录表
	

	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}


	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getDecorateType() {
		return decorateType;
	}
	public void setDecorateType(Integer decorateType) {
		this.decorateType = decorateType;
	}
	public Date getEstimatedStarTime() {
		return estimatedStarTime;
	}
	public void setEstimatedStarTime(Date estimatedStarTime) {
		this.estimatedStarTime = estimatedStarTime;
	}
	public Date getEstimatedFinishTime() {
		return estimatedFinishTime;
	}
	public void setEstimatedFinishTime(Date estimatedFinishTime) {
		this.estimatedFinishTime = estimatedFinishTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	
	public String getDismantlesWallArea() {
		return dismantlesWallArea;
	}
	public void setDismantlesWallArea(String dismantlesWallArea) {
		this.dismantlesWallArea = dismantlesWallArea;
	}
	public String getActualDismantlesWallArea() {
		return actualDismantlesWallArea;
	}
	public void setActualDismantlesWallArea(String actualDismantlesWallArea) {
		this.actualDismantlesWallArea = actualDismantlesWallArea;
	}
	public String getAngentId() {
		return angentId;
	}
	public void setAngentId(String angentId) {
		this.angentId = angentId;
	}

	public String getClosePersonId() {
		return closePersonId;
	}
	public void setClosePersonId(String closePersonId) {
		this.closePersonId = closePersonId;
	}
	public String getCloseRemarks() {
		return closeRemarks;
	}
	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}
	public List<DecorateAnnex> getDecorateAnnexList() {
		return decorateAnnexList;
	}
	public void setDecorateAnnexList(List<DecorateAnnex> decorateAnnexList) {
		this.decorateAnnexList = decorateAnnexList;
	}
	public List<DecorateComponentRecords> getDecorateComponentRecordsList() {
		return decorateComponentRecordsList;
	}
	public void setDecorateComponentRecordsList(
			List<DecorateComponentRecords> decorateComponentRecordsList) {
		this.decorateComponentRecordsList = decorateComponentRecordsList;
	}
	public DecorateAssociatedRecords getDecorateAssociatedRecords() {
		return decorateAssociatedRecords;
	}
	public void setDecorateAssociatedRecords(
			DecorateAssociatedRecords decorateAssociatedRecords) {
		this.decorateAssociatedRecords = decorateAssociatedRecords;
	}
	public List<DecoratePersonnelAssociated> getDecoratePersonnelAssociatedList() {
		return decoratePersonnelAssociatedList;
	}
	public void setDecoratePersonnelAssociatedList(
			List<DecoratePersonnelAssociated> decoratePersonnelAssociatedList) {
		this.decoratePersonnelAssociatedList = decoratePersonnelAssociatedList;
	}
	public List<DecoreateDiscloseInformation> getDecoreateDiscloseInformationList() {
		return decoreateDiscloseInformationList;
	}
	public void setDecoreateDiscloseInformationList(
			List<DecoreateDiscloseInformation> decoreateDiscloseInformationList) {
		this.decoreateDiscloseInformationList = decoreateDiscloseInformationList;
	}
	public Integer getApplyType() {
		return applyType;
	}
	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}
	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
}
