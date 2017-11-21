package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 是否发函记录
 * @author 倪明
 * 2015/08/21
 */
@XmlRootElement(name = "LetterRecords")
public class LetterRecords {

	private String recordId;   //是否发函记录id
	
	private String orderId;   //关联工单id
	
	private String letterId;   //函件id
	
	private String letterName;   //函件名称
	
	private Integer whetherLetter;   //是否建议发函

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getLetterId() {
		return letterId;
	}

	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}

	public String getLetterName() {
		return letterName;
	}

	public void setLetterName(String letterName) {
		this.letterName = letterName;
	}

	public Integer getWhetherLetter() {
		return whetherLetter;
	}

	public void setWhetherLetter(Integer whetherLetter) {
		this.whetherLetter = whetherLetter;
	}
	
}
