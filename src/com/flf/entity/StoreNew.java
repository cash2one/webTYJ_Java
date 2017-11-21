package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "StoreNew") 
public class StoreNew {

	private String buildingStructureId;//建筑结构id
	
	private String buildingId;//建筑id
	
	private String projectId;//项目id
	
	private String fullName;//商铺地址
	
	private String storeTyoe;//商铺属性（建筑初始化 ） 
	
	private String storeNumber ; //商铺号（建筑初始化）
	
	private Double buildingArea;//建筑面积（建筑初始化）
	
	private Double insideArea;//套内面积（建筑初始化）
	
	private Double commonalityArea;//分摊面积（建筑初始化）
	
	private Double completionArea;//竣工面积（建筑初始化）
	
	private Date intakeDate;//竣工日期（建筑初始化） 

	private String storeId;  //商铺id

    private String storeBairro;//所在区
    
    private Date staDate;//签约日期

    private Byte propertyType;//产权类型

    private Double registerPrice;//登记价

    private Double mortgageAmount;//按揭金额

    private String registrantCust;//登记人

    private Date registrationDate;//登记时间

    private Double downPaymentAmount;//付款方式

    private String paymentMethod;//首付金额

    private String transactionType;//交易类型

    private Double discountedPrices;//折后实价

    private Double usableArea;  //实用面积
    
	private Byte intakeState;//入伙状态	
	
	private String buildingCertificate;//房产证号
	
	private String projectName;//项目名称导出用  王洲 2016.1.8
	
	private String e_intakeDate;//竣工日期导出用  王洲 2016.1.8
	
	private BuildingStructureNew buildingStructureNew;//关联建筑结构导出用  王洲 2016.1.8
	
	private String intakeStates;//入伙状态，用于导出  王洲  2016.02.29
	
	private Page page;
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getBuildingCertificate() {
		return buildingCertificate;
	}

	public void setBuildingCertificate(String buildingCertificate) {
		this.buildingCertificate = buildingCertificate;
	}

    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Byte getIntakeState() {
		return intakeState;
	}

	public void setIntakeState(Byte intakeState) {
		this.intakeState = intakeState;
	}


    
    private List<StoreNew> storeList;
 
	public List<StoreNew> getStoreList() {
		return storeList;
	}

	private String storeCode;//商铺编号
	
	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

   

	public void setStoreList(List<StoreNew> storeList) {
		this.storeList = storeList;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public Date getIntakeDate() {
		return intakeDate;
	}

	public void setIntakeDate(Date intakeDate) {
		this.intakeDate = intakeDate;
	}

	public Double getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Double getCommonalityArea() {
		return commonalityArea;
	}

	public void setCommonalityArea(Double commonalityArea) {
		this.commonalityArea = commonalityArea;
	}

	public Double getInsideArea() {
		return insideArea;
	}

	public void setInsideArea(Double insideArea) {
		this.insideArea = insideArea;
	}

	public Double getCompletionArea() {
		return completionArea;
	}

	public void setCompletionArea(Double completionArea) {
		this.completionArea = completionArea;
	}

	public Double getUsableArea() {

		return usableArea;
	}

	public void setUsableArea(Double usableArea) {
		this.usableArea = usableArea;
	}

	public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreTyoe() {
		return storeTyoe;
	}

	public void setStoreTyoe(String storeTyoe) {
		this.storeTyoe = storeTyoe;
	}

	public String getStoreBairro() {
        return storeBairro;
    }

    public void setStoreBairro(String storeBairro) {
        this.storeBairro = storeBairro;
    }

    public Date getStaDate() {
        return staDate;
    }

    public void setStaDate(Date staDate) {
        this.staDate = staDate;
    }

    public Byte getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Byte propertyType) {
        this.propertyType = propertyType;
    }

    public Double getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(Double registerPrice) {
        this.registerPrice = registerPrice;
    }

    public Double getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(Double mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public String getRegistrantCust() {
        return registrantCust;
    }

    public void setRegistrantCust(String registrantCust) {
        this.registrantCust = registrantCust;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getDownPaymentAmount() {
        return downPaymentAmount;
    }

    public void setDownPaymentAmount(Double downPaymentAmount) {
        this.downPaymentAmount = downPaymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getDiscountedPrices() {
        return discountedPrices;
    }

    public void setDiscountedPrices(Double discountedPrices) {
        this.discountedPrices = discountedPrices;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getE_intakeDate() {
		return e_intakeDate;
	}

	public void setE_intakeDate(String e_intakeDate) {
		this.e_intakeDate = e_intakeDate;
	}

	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}

	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}

	public String getIntakeStates() {
		return intakeStates;
	}

	public void setIntakeStates(String intakeStates) {
		this.intakeStates = intakeStates;
	}
    
}