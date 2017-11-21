package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 部门质检频率关联表
 * @author shaozheng
 *	2015-7-14
 */
@XmlRootElement(name = "FrequencyRecord")
public class FrequencyRecord {
	
	private String recordId;//记录ID
	private String relationId;//父级id
	private Integer frequencyType;//频率类型
	private String executionFrequency;//执行频率
	private Byte executionFrequencyNum;//执行次数
	
	private List<String> executionFrequencys;
	
	
	public Byte getExecutionFrequencyNum() {
		return executionFrequencyNum;
	}
	public void setExecutionFrequencyNum(Byte executionFrequencyNum) {
		this.executionFrequencyNum = executionFrequencyNum;
	}
	
	public String getrecordId() {
		return recordId;
	}
	public void setrecordId(String recordId) {
		this.recordId = recordId;
	}
	
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public Integer getFrequencyType() {
		return frequencyType;
	}
	public void setFrequencyType(Integer frequencyType) {
		this.frequencyType = frequencyType;
	}
	public String getExecutionFrequency() {
		return executionFrequency;
	}
	public void setExecutionFrequency(String executionFrequency) {
		this.executionFrequency = executionFrequency;
	}
	public List<String> getExecutionFrequencys() {
		return executionFrequencys;
	}
	public void setExecutionFrequencys(List<String> executionFrequencys) {
		this.executionFrequencys = executionFrequencys;
	}
	
}
