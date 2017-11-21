package com.flf.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
//住宅�?
@XmlRootElement(name = "HouseNew") 
public class HouseNew {

    private String projectId;//项目id
    
    private String buildingId;  //建筑id

    private String buildingStructureId;//建筑结构id
    
    private String houseName;//户型名称
    
    private String id;   //主键(uuid)

    private String houseNum;//住宅编号

    private String property;//属性（关联面积表）
    
    private Double landPrice;//地价

    private Double lastTranscationPrice;//最新成交价

    private String housePostcode;//房屋邮编

    private Double manageFee;//管理费单价

    private Byte elevator;//电梯

    private Byte gateGuard;//门禁

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date joinDate;//入伙日期

    private Byte joinState;//入伙状态

    private String designerDraw;//设计图(关联附件)

    private Byte isBilling;//是否计费

    private Double price;//售价

    private String landCertificate;//土地证（关联附件）

    private Byte marketState;//销售状态）

    private Byte specialFund;  //专项资金

    private Byte capitalType; //资产类型

    private String password; //密码

    private String sipId; //sipId
	
    private String houseAddress;//房屋地址
    
    private String premisesPermit;//房产证号
    
    private Sipmanage sipmanage; //sip对象
    
    private Double managementUnitPrice;//管理费单价
    
    private Byte joinGangState;//入伙状态
    
    private String custType;   //客户类型
    
    private Gift gift;//物品包对象
    
    private String projectName;//项目名称用于导出  王洲  2016.1.8
    
    private String e_completeDate;//竣工日期用于导出  王洲  2016.1.8
    
    private BuildingStructureNew buildingStructureNew;//建筑结构用于导出  王洲 2016.1.8
    
    private String joinGangStates;//入伙状态用于导出  王洲  2016.02.29
    
	public Gift getGift() {
		return gift;
	}
	
    private List<HouseArticle> houseArticles;//物品列表
    
	private List<Intake> intake;//关于此栋房屋的入伙记录对象
	
    private String houseAttribute;//房屋属性
    
    private String houseType;//房屋户型
    
    private Double houseArea;//房屋面积（建筑面积）
    
    private Double usableArea; //套内面积
    
    private Double shareArea;//公摊面积
    
    private Double completeArea;//竣工面积
    
    private Date completeDate;//竣工日期
    
    private List<HouseNew> hnList;//住宅集合
    
    private String fullName;//房屋地址（有效）
    
    private String productId;   //项目id
    
    private String buildingArea;  //建筑面积
    
    private String commonalityArea;   //公摊面积
    
    private Byte equity; //产权
    
    private Byte towards;//朝向
    
    private String floor;//楼层
    
    private List<String> custNameList;//业主姓名集合
    
    private List<String> familyNameList;//家属姓名集合
    
    private List<Entrance> entranceList;//门禁卡信息集合
    
    /***查询条件***/
    private String name;//姓名   

	private String phoneNum;//电话号码   
    private String cardNum;//证件号码
	private String registerPhone;//注册电话
	private String custCode;  //客户编号
	private String areaId;//建筑类型
	private String custId;//客户id
	
	private String buildingCertificate;//房产证号
	
	private String personBuildingId;  //客户房屋关系id
	
	private String saleState;//销售状态 

	private String indoorSipId;//室内机sipId
	
	private Sipmanage indoorSipInfo;//室内机sip对象
	
	private String projectType;

	public String getSaleState() {
		return saleState;
	}

	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}

	public String getPersonBuildingId() {
		return personBuildingId;
	}

	public void setPersonBuildingId(String personBuildingId) {
		this.personBuildingId = personBuildingId;
	}

	public String getBuildingCertificate() {
		return buildingCertificate;
	}

	public void setBuildingCertificate(String buildingCertificate) {
		this.buildingCertificate = buildingCertificate;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getRegisterPhone() {
		return registerPhone;
	}

	public void setRegisterPhone(String registerPhone) {
		this.registerPhone = registerPhone;
	}

    
    public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	private PersonCustNew personCustNew;
    
    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public void setHouseArticles(List<HouseArticle> houseArticles) {
		this.houseArticles = houseArticles;
	}
   
    
    private Double completionArea;   //竣工面积
    
    private Double insideArea;  //套内面积
    
    private EnterpriseCustNew enterpriseCustNew;
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public List<HouseArticle> getHouseArticles() {
		return houseArticles;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Byte getJoinGangState() {
		return joinGangState;
	}

	public void setJoinGangState(Byte joinGangState) {
		this.joinGangState = joinGangState;
	}

	public Double getManagementUnitPrice() {
		return managementUnitPrice;
	}

	public void setManagementUnitPrice(Double managementUnitPrice) {
		this.managementUnitPrice = managementUnitPrice;
	}


    

    public Double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getPremisesPermit() {
		return premisesPermit;
	}

	public void setPremisesPermit(String premisesPermit) {
		this.premisesPermit = premisesPermit;
	}
    public Double getUsableArea() {
		return usableArea;
	}

	public void setUsableArea(Double usableArea) {
		this.usableArea = usableArea;
	}

	public Sipmanage getSipmanage() {
		return sipmanage;
	}

	public void setSipmanage(Sipmanage sipmanage) {
		this.sipmanage = sipmanage;
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

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }
    
    public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Double getLandPrice() {
        return landPrice;
    }

    public void setLandPrice(Double landPrice) {
        this.landPrice = landPrice;
    }

    public Double getLastTranscationPrice() {
        return lastTranscationPrice;
    }

    public void setLastTranscationPrice(Double lastTranscationPrice) {
        this.lastTranscationPrice = lastTranscationPrice;
    }

   

    public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHousePostcode() {
        return housePostcode;
    }

    public void setHousePostcode(String housePostcode) {
        this.housePostcode = housePostcode;
    }

    public Double getManageFee() {
        return manageFee;
    }

    public void setManageFee(Double manageFee) {
        this.manageFee = manageFee;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Byte getElevator() {
        return elevator;
    }

    public void setElevator(Byte elevator) {
        this.elevator = elevator;
    }

    public Byte getGateGuard() {
        return gateGuard;
    }

    public void setGateGuard(Byte gateGuard) {
        this.gateGuard = gateGuard;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Byte getJoinState() {
        return joinState;
    }

    public void setJoinState(Byte joinState) {
        this.joinState = joinState;
    }

    public String getDesignerDraw() {
        return designerDraw;
    }

    public void setDesignerDraw(String designerDraw) {
        this.designerDraw = designerDraw;
    }

    public Byte getIsBilling() {
        return isBilling;
    }

    public void setIsBilling(Byte isBilling) {
        this.isBilling = isBilling;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLandCertificate() {
        return landCertificate;
    }

    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    public Byte getMarketState() {
        return marketState;
    }

    public void setMarketState(Byte marketState) {
        this.marketState = marketState;
    }

    public Byte getSpecialFund() {
        return specialFund;
    }

    public void setSpecialFund(Byte specialFund) {
        this.specialFund = specialFund;
    }

    public Byte getCapitalType() {
        return capitalType;
    }

    public void setCapitalType(Byte capitalType) {
        this.capitalType = capitalType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
    }

	public String getHouseAttribute() {
		return houseAttribute;
	}

	public void setHouseAttribute(String houseAttribute) {
		this.houseAttribute = houseAttribute;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public Double getShareArea() {
		return shareArea;
	}

	public void setShareArea(Double shareArea) {
		this.shareArea = shareArea;
	}

	public Double getCompleteArea() {
		return completeArea;
	}

	public void setCompleteArea(Double completeArea) {
		this.completeArea = completeArea;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<HouseNew> getHnList() {
		return hnList;
	}

	public void setHnList(List<HouseNew> hnList) {
		this.hnList = hnList;
	}
	 
    public List<Intake> getIntake() {
			return intake;
		}

		public void setIntake(List<Intake> intake) {
			this.intake = intake;
		}

		public EnterpriseCustNew getEnterpriseCustNew() {
			return enterpriseCustNew;
		}

		public void setEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew) {
			this.enterpriseCustNew = enterpriseCustNew;
		}

		public Double getCompletionArea() {
			return completionArea;
		}

		public void setCompletionArea(Double completionArea) {
			this.completionArea = completionArea;
		}

		public Double getInsideArea() {
			return insideArea;
		}

		public void setInsideArea(Double insideArea) {
			this.insideArea = insideArea;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getBuildingArea() {
			return buildingArea;
		}

		public void setBuildingArea(String buildingArea) {
			this.buildingArea = buildingArea;
		}

		public String getCommonalityArea() {
			return commonalityArea;
		}

		public void setCommonalityArea(String commonalityArea) {
			this.commonalityArea = commonalityArea;
		}

		public String getCustType() {
			return custType;
		}

		public void setCustType(String custType) {
			this.custType = custType;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getE_completeDate() {
			return e_completeDate;
		}

		public void setE_completeDate(String e_completeDate) {
			this.e_completeDate = e_completeDate;
		}

		public BuildingStructureNew getBuildingStructureNew() {
			return buildingStructureNew;
		}

		public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
			this.buildingStructureNew = buildingStructureNew;
		}

		public String getJoinGangStates() {
			return joinGangStates;
		}

		public void setJoinGangStates(String joinGangStates) {
			this.joinGangStates = joinGangStates;
		}

		public Byte getEquity() {
			return equity;
		}

		public void setEquity(Byte equity) {
			this.equity = equity;
		}

		public Byte getTowards() {
			return towards;
		}

		public void setTowards(Byte towards) {
			this.towards = towards;
		}

		public String getFloor() {
			return floor;
		}

		public void setFloor(String floor) {
			this.floor = floor;
		}

		public String getIndoorSipId() {
			return indoorSipId;
		}

		public void setIndoorSipId(String indoorSipId) {
			this.indoorSipId = indoorSipId;
		}

		public Sipmanage getIndoorSipInfo() {
			return indoorSipInfo;
		}

		public void setIndoorSipInfo(Sipmanage indoorSipInfo) {
			this.indoorSipInfo = indoorSipInfo;
		}

		public List<String> getCustNameList() {
			return custNameList;
		}

		public void setCustNameList(List<String> custNameList) {
			this.custNameList = custNameList;
		}

		public List<String> getFamilyNameList() {
			return familyNameList;
		}

		public void setFamilyNameList(List<String> familyNameList) {
			this.familyNameList = familyNameList;
		}

		public List<Entrance> getEntranceList() {
			return entranceList;
		}

		public void setEntranceList(List<Entrance> entranceList) {
			this.entranceList = entranceList;
		}

		public String getProjectType() {
			return projectType;
		}

		public void setProjectType(String projectType) {
			this.projectType = projectType;
		}

}