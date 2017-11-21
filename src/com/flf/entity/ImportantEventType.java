package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 重大事项类型表
 * @author shaozheng
 *	2015-8-19
 */
@XmlRootElement(name="ImportantEventType")
public class ImportantEventType {

	private String eventTypeId;//	重大事项类型
	private String eventNum;//	重大事项编号
	private String eventTypeName;//	类型名称
	private Integer state;//	状态 0关闭 1启用
	private String createPersonId;//	创建人
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//	创建时间	
	private String remarks;//	说明
	
//	private String changeRemarks;//状态修改备注
	private List<HandleMechanism> handleMechanismArr;//处理机制
	private Staff staff;
	private ImportantEventTypeJournal importantEventTypeJournal;
	
	private Page page;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public ImportantEventTypeJournal getImportantEventTypeJournal() {
		return importantEventTypeJournal;
	}
	public void setImportantEventTypeJournal(
			ImportantEventTypeJournal importantEventTypeJournal) {
		this.importantEventTypeJournal = importantEventTypeJournal;
	}
	public String getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventNum() {
		return eventNum;
	}
	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}
	

	public Date getCreateTime() {
		return createTime;

	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;

	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<HandleMechanism> getHandleMechanismArr() {
		return handleMechanismArr;
	}
	public void setHandleMechanismArr(List<HandleMechanism> handleMechanismArr) {
		this.handleMechanismArr = handleMechanismArr;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
//	public String getChangeRemarks() {
//		return changeRemarks;
//	}
//	public void setChangeRemarks(String changeRemarks) {
//		this.changeRemarks = changeRemarks;
//	}
}
