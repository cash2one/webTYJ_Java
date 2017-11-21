package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 收费类型
 * @author maogaofei
 * @date 2016年6月29日 下午4:23:37
 */
@XmlRootElement(name = "ChargeType")
public class ChargeType {
    private String chargeTypeId;//费用类型ID

    private String chargeTypeName;//费用类型名称

    private String chargeTypeNum;//收费项目编号

    private String chargeTypeStatus;//启用状态 0-已启用 01-未启用 02失效

    private String accountType;//账户类型 01-资产账户 02-押金账户

    private int chargeTypePriority;//优先级 1、2、3、4、5、6、7、8、9 数字越小优先级越高

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间
    
    private String description;//优先级描述
    
    private String projectId;//项目ID
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
    
    //关联收费项目子表
    private List<ChargeTypeDetails> chargetypedetailslist;

	public List<ChargeTypeDetails> getChargetypedetailslist() {
		return chargetypedetailslist;
	}

	public void setChargetypedetailslist(List<ChargeTypeDetails> chargetypedetailslist) {
		this.chargetypedetailslist = chargetypedetailslist;
	}



	private Page page;
    
    public void setPage(Page page) {
		this.page = page;
	}

	

	public String getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(String chargeTypeId) {
        this.chargeTypeId = chargeTypeId == null ? null : chargeTypeId.trim();
    }

    public String getChargeTypeName() {
        return chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName == null ? null : chargeTypeName.trim();
    }

    public String getChargeTypeNum() {
        return chargeTypeNum;
    }

    public void setChargeTypeNum(String chargeTypeNum) {
        this.chargeTypeNum = chargeTypeNum == null ? null : chargeTypeNum.trim();
    }

    public String getChargeTypeStatus() {
        return chargeTypeStatus;
    }

    public void setChargeTypeStatus(String chargeTypeStatus) {
        this.chargeTypeStatus = chargeTypeStatus == null ? null : chargeTypeStatus.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

   

    public int getChargeTypePriority() {
		return chargeTypePriority;
	}

	public void setChargeTypePriority(int chargeTypePriority) {
		this.chargeTypePriority = chargeTypePriority;
	}

	public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

	public Page getPage() {
		if(this.page==null){
    		this.page=new Page();
		}
		return page;
	}
}