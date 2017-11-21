package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Division") 
//部门表
public class Division {
    private String id;//id

    private String divisionName;//部门
    
    private Integer isinitialize;//是否初始化
    
    public Integer getIsinitialize() {
		return isinitialize;
	}
	public void setIsinitialize(Integer isinitialize) {
		this.isinitialize = isinitialize;
	}
	private Page page;
    
	public Page getPage() {
   		return page;
   	}
   	public void setPage(Page page) {
   		this.page = page;
   	}
/*	private List<Hillock>  hillocks;
    
    public List<Hillock> getHillocks() {
		return hillocks;
	}
	public void setHillocks(List<Hillock> hillocks) {
		this.hillocks = hillocks;
	}*/


	

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}