package com.flf.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 创建by夏平 2015/10/2
 * 产品初始化
 */
@XmlRootElement(name = "FixedParkingSpace")
public class FixedParkingSpace {
	private double price;//金额
	private String name;//产权人
	private String custId;//产权人ID
	private String stallId;//车位ID
	private String stallPosition;//车位地址/产品名称
	private String stallProperty;//车位属性
	private String stallNumber;//车位编号
	private String stallType;//车位类型
	private String projectId;//项目ID
	private String productId;//产品ID
	private String fixed;//是否是固定车位
	
	private String fullName;//建筑全名  王洲  2016.04.07
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getStallId() {
		return stallId;
	}
	public void setStallId(String stallId) {
		this.stallId = stallId;
	}
	public String getStallPosition() {
		return stallPosition;
	}
	public void setStallPosition(String stallPosition) {
		this.stallPosition = stallPosition;
	}
	public String getStallNumber() {
		return stallNumber;
	}
	public void setStallNumber(String stallNumber) {
		this.stallNumber = stallNumber;
	}
	public String getStallType() {
		return stallType;
	}
	public void setStallType(String stallType) {
		this.stallType = stallType;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getStallProperty() {
		return stallProperty;
	}
	public void setStallProperty(String stallProperty) {
		this.stallProperty = stallProperty;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getFixed() {
		return fixed;
	}
	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
