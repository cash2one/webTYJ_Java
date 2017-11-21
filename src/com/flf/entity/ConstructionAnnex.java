package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 四.	施工图纸附件
 * @author 陶勇超
 * 2015-8-31
 */
@XmlRootElement(name="ConstructionAnnex")
public class ConstructionAnnex {
	private String recordId; //记录ID
	private String applyId; //施工申请关联ID
	private Integer drawingType1; //图纸类型 0.原图 1.设计图
	private Integer drawingType2; //图纸类型 0.建筑图 1.水路图 2.电路图
	private String annexAddress; //附件地址
	private String annexName;    //附件名称
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
	public Integer getDrawingType1() {
		return drawingType1;
	}
	public void setDrawingType1(Integer drawingType1) {
		this.drawingType1 = drawingType1;
	}
	public Integer getDrawingType2() {
		return drawingType2;
	}
	public void setDrawingType2(Integer drawingType2) {
		this.drawingType2 = drawingType2;
	}
	public String getAnnexAddress() {
		return annexAddress;
	}
	public void setAnnexAddress(String annexAddress) {
		this.annexAddress = annexAddress;
	}
	public String getAnnexName() {
		return annexName;
	}
	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}
	
	

}
