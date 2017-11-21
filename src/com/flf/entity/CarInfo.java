package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "CarInfo") 
public class CarInfo {
	/*
	 * t_carinfo 车辆信息表
	 */
    private String carId;//车辆id

	private String personId;//人员id

    private String carNum;//车牌号

    private String carBrand;//车辆品牌

    private String carType;//车辆类型

    private String carStyle;//车辆型号

    private String engineNum;//发动机号

    private String discriminateCode;//车辆识别代码

    private Integer passengers;//核定载客数

    private String carColor;//车辆颜色

    private @DateTimeFormat(pattern="yyyy-MM-dd") Date regeditDate;//注册登记日期

    private @DateTimeFormat(pattern="yyyy-MM-dd") Date certificationDate;//发证日期
    
	private List<Annex> annexs;//附件表

	private @DateTimeFormat(pattern="yyyy-MM-dd") Date recordDate;//登记日期

    private String businessStyle;//交易类型
    
    private String owner;//车辆所属人
    private String ownerName;//车辆所有人姓名
    private String drivingLicense;//驾驶证号
    private String commissionAgent;//代办人
    
    private String transactor;//办理人
    private String address;  //地址
    private String registrant;//操作人id
    
    private List<CarInfo> carInfos;

	private byte deleteCar;//车辆删除状态
    
   

	private PersonCustNew personCustNew;//车辆所有人
	
	private Caraccesscard caraccesscard;//停车卡
	
    private Date operateDate;//操作时间
    
	private PersonCustNew person;//车辆办理人
	
	private String name; //客户姓名（查询用）
	
	private String phone;//联系电话（查询用）	
	
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonCustNew getPerson() {
			return person;
		}

		public void setPerson(PersonCustNew person) {
			this.person = person;
		}
    
    public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
    public byte getDeleteCar() {
		return deleteCar;
	}

	public void setDeleteCar(byte deleteCar) {
		this.deleteCar = deleteCar;
	}
	
	 public PersonCustNew getPersonCustNew() {
			return personCustNew;
		}

		public void setPersonCustNew(PersonCustNew personCustNew) {
			this.personCustNew = personCustNew;
		}
    
 

	public String getRegistrant() {
		return registrant;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}

	
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
    
    public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
    
    public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	
    
    public String getCommissionAgent() {
		return commissionAgent;
	}

	public void setCommissionAgent(String commissionAgent) {
		this.commissionAgent = commissionAgent;
	}

	public String getTransactor() {
		return transactor;
	}

	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}

	
    
    public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	
	
	 public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getCarId() {
			return carId;
		}

		public void setCarId(String carId) {
			this.carId = carId;
		}

		public String getPersonId() {
			return personId;
		}

		public void setPersonId(String personId) {
			this.personId = personId;
		}
    
    public Caraccesscard getCaraccesscard() {
		return caraccesscard;
	}

	public void setCaraccesscard(Caraccesscard caraccesscard) {
		this.caraccesscard = caraccesscard;
	}

	private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}



	

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarStyle() {
        return carStyle;
    }

    public void setCarStyle(String carStyle) {
        this.carStyle = carStyle;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getDiscriminateCode() {
        return discriminateCode;
    }

    public void setDiscriminateCode(String discriminateCode) {
        this.discriminateCode = discriminateCode;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Date getRegeditDate() {
        return regeditDate;
    }

    public void setRegeditDate(Date regeditDate) {
        this.regeditDate = regeditDate;
    }

    public Date getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(Date certificationDate) {
        this.certificationDate = certificationDate;
    }

    public String getBusinessStyle() {
        return businessStyle;
    }

    public void setBusinessStyle(String businessStyle) {
        this.businessStyle = businessStyle;
    }

	public List<CarInfo> getCarInfos() {
		return carInfos;
	}

	public void setCarInfos(List<CarInfo> carInfos) {
		this.carInfos = carInfos;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}