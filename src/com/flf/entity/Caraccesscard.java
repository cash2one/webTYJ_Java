package com.flf.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Caraccesscard")
public class Caraccesscard {
	/*
	 * t_car_access_card 车辆卡表
	 */
    private String cardId;//车辆卡id
   
	private String houseId;//绑定住宅id
    private String idcardNum;//ID卡号
    private @DateTimeFormat(pattern="yyyy-MM-dd ") Date doCarddate;//办卡日期
    private Byte cardState;//卡状态
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate;//启用日期
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate;//截止日期	
    private String parkId;		// 车位id
    private String custCode;    //客户id

    private String userName;   //使用人姓名

    private String kinsfolk;    //亲属关系
    
    private Double nominalFee;   //工本费
 
    private String photograph;   //照片
    private String customerId ; //客户编号
    
    private Page page;
    
    private HouseNew house;
    
	private Date refundDate; 	// 退费日期
	
	private Double paymentAmount;//缴费金额
	
	private String creater; //创建人 
	
	private String registrationStatus;// 行驶证状态
	
	private String parkingLocation;// 停车地点
	
	private String note;// 备注
	
	private PersonCustNew personCust;//关联客户表
	
	private CarInfo carInfo;//关联车辆表
	
	private String carType;// 办卡类型(1.私人、2.固定、3.流动)
	
	private String userType;// 用户类型
	
	private String carcardType;// 车辆卡类型
	
	private String carId; // 车位id（建筑结构id）
	
	private String newcardId; //新卡号
	
	private StallNew stall;//关联车位表
	
    private Date operateDate;//操作时间
    
    private String nodeName;//建筑地址
    
    private String name;//客户姓名（查询用）
    
    private String cardNum;//证件号（查询用）
    
    private String cardType;//证件类型（查询用）
    
    private String carNum;//车牌号（查询用）
    
    private PersonCustNew personCustNew;//客户信息 
    
    private String productId; //产品id
    
    private  String price;//管理费
    
    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	 public String getCardId() {
			return cardId;
		}
		public void setCardId(String cardId) {
			this.cardId = cardId;
		}
		public String getHouseId() {
			return houseId;
		}
		public void setHouseId(String houseId) {
			this.houseId = houseId;
		}
		public String getIdcardNum() {
			return idcardNum;
		}
		public void setIdcardNum(String idcardNum) {
			this.idcardNum = idcardNum;
		}
		public String getParkId() {
			return parkId;
		}
		public void setParkId(String parkId) {
			this.parkId = parkId;
		}
	
		public String getCustCode() {
			return custCode;
		}

		public void setCustCode(String custCode) {
			this.custCode = custCode;
		}

		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getCarcardType() {
			return carcardType;
		}
		public void setCarcardType(String carcardType) {
			this.carcardType = carcardType;
		}
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
	
	public StallNew getStall() {
		return stall;
	}
	public void setStall(StallNew stall) {
		this.stall = stall;
	}
	public String getNewcardId() {
		return newcardId;
	}
	public void setNewcardId(String newcardId) {
		this.newcardId = newcardId;
	}
	

	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public CarInfo getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}
	public PersonCustNew getPersonCust() {
		return personCust;
	}
	public void setPersonCust(PersonCustNew personCust) {
		this.personCust = personCust;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public String getParkingLocation() {
		return parkingLocation;
	}
	public void setParkingLocation(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}
	public Date getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKinsfolk() {
		return kinsfolk;
	}
	public void setKinsfolk(String kinsfolk) {
		this.kinsfolk = kinsfolk;
	}
	public Double getNominalFee() {
		return nominalFee;
	}
	public void setNominalFee(Double nominalFee) {
		this.nominalFee = nominalFee;
	}
	public String getPhotograph() {
		return photograph;
	}
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
	public HouseNew getHouse() {
		return house;
	}
	public void setHouse(HouseNew house) {
		this.house = house;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public Date getDoCarddate() {
		return doCarddate;
	}
	public void setDoCarddate(Date doCarddate) {
		this.doCarddate = doCarddate;
	}
	public Byte getCardState() {
		return cardState;
	}
	public void setCardState(Byte cardState) {
		this.cardState = cardState;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
   }