package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "SearchLog")
public class SearchLog {
	
	private String logTypeName; //日志类型
	
	private Date time; //操作时间
	
	private Page page;

	private String thing;//内容
	
	
	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	
	public String getLogTypeName() {
		return logTypeName;
	}

	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
