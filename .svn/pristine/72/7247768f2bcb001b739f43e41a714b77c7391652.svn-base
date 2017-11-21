package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 处理机制表
 * @author shaozheng
 *	2015-8-19
 */
@XmlRootElement(name="HandleMechanism")
public class HandleMechanism {

	private String handleId;//处理机制
	private Integer handleType;//处理机制类型  园林0 维修1 护管2 部门质检3 装修巡检4 装修验收5 施工巡检6 施工核查7 施工验收8 赔偿给业主9 向业主索赔10 清洁11 回访12 投诉13 验房 14 咨询15 抄水表16 抄电表17 装修核查18
	private String eventTypeId;//关联重大事项类型
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//创建时间
	private String createPersonId;//创建人
	private String principal;//负责人
	private String remarks;//处理描述
	
	private Staff staff;//员工
	
	private ImportantEventTypeJournal importantEventTypeJournal;//重大事项类型日志记录表

	public ImportantEventTypeJournal getImportantEventTypeJournal() {
		return importantEventTypeJournal;
	}
	public void setImportantEventTypeJournal(
			ImportantEventTypeJournal importantEventTypeJournal) {
		this.importantEventTypeJournal = importantEventTypeJournal;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	private Integer state;//状态（0无效1有效）
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getHandleId() {
		return handleId;
	}
	public void setHandleId(String handleId) {
		this.handleId = handleId;
	}
	public Integer getHandleType() {
		return handleType;
	}
	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}
	public String getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
}
