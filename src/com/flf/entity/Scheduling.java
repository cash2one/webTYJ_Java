package com.flf.entity;

import java.util.Date;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Scheduling") 
/*
 * 排班表
 */
public class Scheduling {
    private Integer id;//排班id

    private String staffId;//员工id

    private String staffName;//员工名称

    private String classesTypeId;//班次类型id

    private String classesTypeName;//班次类型名称

    private String classesId;//班次id

    private String classesName;//班次名称

    private @DateTimeFormat(pattern="yyyy-MM-dd") Date currentdate;//日期

    private Byte statusCd;//状态

    private String startDt;//开始时间

    private String endDt;//结束时间

    private String postId;//岗位id

    private String postName;//岗位名称
    
   private String divisionName;  //部门名称
   
	private String divisionId;//  部门id


    public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getClassesTypeId() {
        return classesTypeId;
    }

    public void setClassesTypeId(String name) {
        this.classesTypeId = name;
    }

    public String getClassesTypeName() {
        return classesTypeName;
    }

    public void setClassesTypeName(String classesTypeName) {
        this.classesTypeName = classesTypeName;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String name) {
        this.classesId = name;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }

    public Byte getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Byte statusCd) {
        this.statusCd = statusCd;
    }



    public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}