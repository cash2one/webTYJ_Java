package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "EnterpriseCustNew") 
public class EnterpriseCustNew {
    private String enterpriseId;

    private String enterpriseName;//企业名称

    private String address;//地址

    private String representative;//企业法人id

    private String officePhone;

    private String faxNumber;

    private String enterpriseUrl;

    private String taxCertificate;

    private String enterpriseProperty;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date tradingDate;

    private String tradingNumber; //用于存放营业执照文件在ts_annex中文件地址

    private String taxNumber;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date taxDate;

    private String manageType;

    private String unitNumber;//企业编号

    private String email;
    
    private String companyId;
    
    private Date modifyTime;
    
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	private String s_registerDate;//导出时注册日期

    public String getS_registerDate() {
		return s_registerDate;
	}

	public void setS_registerDate(String s_registerDate) {
		this.s_registerDate = s_registerDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String businessAddress;

    private String principal;

    private String emergencyContact;
    
    private String emergencyContactPhone;
    
    private String organizationCode; //用于存放组织机构代码文件在ts_annex中文件地址
    
    private @DateTimeFormat(pattern="yyyy-MM-dd")Date registerDate;//注册时间
    
    private PersonCustNew personCustNew; //企业法人对象
    
   

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	private Page page;
    
    private String projectId;
    
    private List<String> bsnList;//建筑结构集合(查询用)
    
    private List<Annex> annexs; //用于文件上传
    
    private String buildingStructureId;

    public Page getPage() {
    	if(this.page==null){
    		this.page = new Page();
    	}
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEnterpriseUrl() {
        return enterpriseUrl;
    }

    public void setEnterpriseUrl(String enterpriseUrl) {
        this.enterpriseUrl = enterpriseUrl;
    }

    public String getTaxCertificate() {
        return taxCertificate;
    }

    public void setTaxCertificate(String taxCertificate) {
        this.taxCertificate = taxCertificate;
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    public Date getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getTradingNumber() {
        return tradingNumber;
    }

    public void setTradingNumber(String tradingNumber) {
        this.tradingNumber = tradingNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Date getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(Date taxDate) {
        this.taxDate = taxDate;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

	public List<String> getBsnList() {
		return bsnList;
	}

	public void setBsnList(List<String> bsnList) {
		this.bsnList = bsnList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}
    
    
}