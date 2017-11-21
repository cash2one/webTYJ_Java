package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 集中处理关联表
 * @author shaozheng
 *	2015-7-7
 */
@XmlRootElement(name = "CentralizedProcessingRecords")
public class CentralizedProcessingRecords {

	private String recordId;//记录id
	private String projectId;//集中处理项目id
	private String taskId;//任务id
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
