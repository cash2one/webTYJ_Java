package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
//合同表
@XmlRootElement(name = "Contract")
public class Contract {
    private String id;//主键

    private String contractOddNum;//合同单号

    private String contractNum;//合同编号

    private String contractType;//合同类型

    private String contractProject;//合同项目

    private String firstParty;//合同甲方

    private String secondParty;//合同乙方
    
    private String thirdParty;//合同丙方
    
    private String fourParty;//合同丁方
    
    private String operator;//操作人
    
    private List<ContractPropertyStructure> contractPropertyStructures;  //合同详情
    
    private List<Annex> annexs;
    
     private Date startUsingDate;//合同启动日期                    新加字段2015-12-10   
   
     private Date  startTime;//区间查询开始时间   区间查询使用
     
     private Date  endTime; //区间查询结束时间     区间查询使用
     
     
     
    public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartUsingDate() {
		return startUsingDate;
	}

	public void setStartUsingDate(Date startUsingDate) {
		this.startUsingDate = startUsingDate;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public List<ContractPropertyStructure> getContractPropertyStructures() {
		return contractPropertyStructures;
	}

	public void setContractPropertyStructures(
			List<ContractPropertyStructure> contractPropertyStructures) {
		this.contractPropertyStructures = contractPropertyStructures;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String getFourParty() {
		return fourParty;
	}

	public void setFourParty(String fourParty) {
		this.fourParty = fourParty;
	}

	private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractOddNum() {
        return contractOddNum;
    }

    public void setContractOddNum(String contractOddNum) {
        this.contractOddNum = contractOddNum;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractProject() {
        return contractProject;
    }

    public void setContractProject(String contractProject) {
        this.contractProject = contractProject;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }
}