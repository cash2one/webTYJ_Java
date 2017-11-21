package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SearchNews")
public class SearchNews {
	private String staffName;//员工名字
	  
	  private String divisionName;//部门名称
	  
	
	  
	  private String newsModel;//新闻大类（1.表示消息管理，2.表示项目内部公告）
	  
	  private Integer newsType;//新闻分类
	  
	  private String newsTitle;//新闻标题
	  
	  private String newsAbstract;//新闻摘要
	    
	  public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getNewsModel() {
		return newsModel;
	}

	public void setNewsModel(String newsModel) {
		this.newsModel = newsModel;
	}

	public Integer getNewsType() {
		return newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsAbstract() {
		return newsAbstract;
	}

	public void setNewsAbstract(String newsAbstract) {
		this.newsAbstract = newsAbstract;
	}

	
}
