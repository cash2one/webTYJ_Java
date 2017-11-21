package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 施工组件记录表
 * @author 陶勇超
 *  2015-8-31
 */
@XmlRootElement(name="ConstructionComponentRecords")
public class ConstructionComponentRecords {
	private String recordId; //记录ID
	private String applyId; //关联施工申请ID
	private String componentId; //组件ID
	private String componentName;//组件名称
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
}
