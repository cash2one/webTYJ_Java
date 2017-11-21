package com.flf.entity;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Project")
//项目表
public class Project {
    private String projectId;//项目id
    private Integer custId;//项目id
    private String projectNumber;//项目编号
    private String projectName;//项目名称
    private double stallMatching;//车位配比
    private double parkArea;//停车场面积
    private Integer carEntrinum;//车辆出入口数量
    private Integer personEntrinum;//人行出入口数量
    private Integer carStallnum;//机动车位泊位总数
    private double addCapacitancearea;//核增计容面积
    private double capacitanceArea;//计容面积
    private Integer privateStallnum;//私家车位总数
    private Integer privateStallsold;//私家已售出总数
    private Integer privateStallunsold;//私家未售出总数
    private Integer garageNum;//车库总数
    private Integer garageSold;//车库已售出总数
    private Integer garageUbsold;//车库未售出总数
    private double projectTotalarea;//项目总占地面积
    private double discountPrice;//折合楼面价
    private Integer houseTotalnum;//住宅总户数
    private Integer buildAreanum;//楼宇数量区
    private Integer buildUnitnum;//楼宇数量单元
    private Integer buildBuildnum;//楼宇数量栋
    private Integer stallNum;//车位总数
    private Integer undergroundParkingspacestotal;//地下车位总数
    private Integer groundParkingspacetotal;//地面车位总数
    private double greeningRate;//绿化率
    private double totalBuildarea;//实际总建筑面积
    private double basementArea;//实际地下室面积
    private String province;//省
    private String fullAddress;//市
    private String postcode;//区
    private String street;//街道
    private String address;//全地址
    private String postCode;//邮编
    private String company;//公司
    private String outline;//概要
    private String phone;//电话号码
    private String parcel;//宗地信息
    private String planning;//规划信息
    private String staffId;//项目经理
    private String instanceId;//实例id
    private String staffName; //项目经理名称
    private String isUseSystem;//是否使用收费系统0使用1未使用
	private int billingType;  //计费类型
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date billingDate;//计费时间
    private List<String> subProjectIds;//多个删除子公司id
    private List<RegionNew> regionNews;//区域
    private Double civilAirDefenceArea;//人防面积
    private String meansPayments;//结算方式
    private Integer disabledPayFunction; //是否开启微信支付功能
    private Company companyDetail;//公司对象
    private String checked;//关联状态
    private Staff staff;//关联员工
    private Integer state;//项目状态 0.在用 1.关闭 5.默认物业公司项目
    private Date sortDate;//排序时间
    private AfterSale afterSaleInfo;//售后管理信息
    
   
	public AfterSale getAfterSaleInfo() {
		return afterSaleInfo;
	}
	public void setAfterSaleInfo(AfterSale afterSaleInfo) {
		this.afterSaleInfo = afterSaleInfo;
	}
	public Date getSortDate() {
		return sortDate;
	}
	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}
	private ProjectCompletion projectCompletion;//项目入伙前置任务完成情况
    
    public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public List<String> getSubProjectIds() {
		return subProjectIds;
	}
	public void setSubProjectIds(List<String> subProjectIds) {
		this.subProjectIds = subProjectIds;
	}
	public String getMeansPayments() {
		return meansPayments;
	}
	public void setMeansPayments(String meansPayments) {
		this.meansPayments = meansPayments;
	}
	public Integer getDisabledPayFunction() {
		return disabledPayFunction;
	}
	public void setDisabledPayFunction(Integer disabledPayFunction) {
		this.disabledPayFunction = disabledPayFunction;
	}
	public Double getCivilAirDefenceArea() {
		return civilAirDefenceArea;
	}
	public void setCivilAirDefenceArea(Double civilAirDefenceArea) {
		this.civilAirDefenceArea = civilAirDefenceArea;
	}
	public List<RegionNew> getRegionNews() {
		return regionNews;
	}
	public void setRegionNews(List<RegionNew> regionNews) {
		this.regionNews = regionNews;
	}
	public int getBillingType() {
		return billingType;
	}
	public void setBillingType(int billingType) {
		this.billingType = billingType;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
    
    public String getIsUseSystem() {
		return isUseSystem;
	}
	public void setIsUseSystem(String isUseSystem) {
		this.isUseSystem = isUseSystem;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	private Page page;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getStallMatching() {
		return stallMatching;
	}
	public void setStallMatching(double stallMatching) {
		this.stallMatching = stallMatching;
	}
	public double getParkArea() {
		return parkArea;
	}
	public void setParkArea(double parkArea) {
		this.parkArea = parkArea;
	}
	public Integer getCarEntrinum() {
		return carEntrinum;
	}
	public void setCarEntrinum(Integer carEntrinum) {
		this.carEntrinum = carEntrinum;
	}
	public Integer getPersonEntrinum() {
		return personEntrinum;
	}
	public void setPersonEntrinum(Integer personEntrinum) {
		this.personEntrinum = personEntrinum;
	}
	public Integer getCarStallnum() {
		return carStallnum;
	}
	public void setCarStallnum(Integer carStallnum) {
		this.carStallnum = carStallnum;
	}
	public double getAddCapacitancearea() {
		return addCapacitancearea;
	}
	public void setAddCapacitancearea(double addCapacitancearea) {
		this.addCapacitancearea = addCapacitancearea;
	}
	public double getCapacitanceArea() {
		return capacitanceArea;
	}
	public void setCapacitanceArea(double capacitanceArea) {
		this.capacitanceArea = capacitanceArea;
	}
	public Integer getPrivateStallnum() {
		return privateStallnum;
	}
	public void setPrivateStallnum(Integer privateStallnum) {
		this.privateStallnum = privateStallnum;
	}
	public Integer getPrivateStallsold() {
		return privateStallsold;
	}
	public void setPrivateStallsold(Integer privateStallsold) {
		this.privateStallsold = privateStallsold;
	}
	public Integer getPrivateStallunsold() {
		return privateStallunsold;
	}
	public void setPrivateStallunsold(Integer privateStallunsold) {
		this.privateStallunsold = privateStallunsold;
	}
	public Integer getGarageNum() {
		return garageNum;
	}
	public void setGarageNum(Integer garageNum) {
		this.garageNum = garageNum;
	}
	public Integer getGarageSold() {
		return garageSold;
	}
	public void setGarageSold(Integer garageSold) {
		this.garageSold = garageSold;
	}
	public Integer getGarageUbsold() {
		return garageUbsold;
	}
	public void setGarageUbsold(Integer garageUbsold) {
		this.garageUbsold = garageUbsold;
	}
	public double getProjectTotalarea() {
		return projectTotalarea;
	}
	public void setProjectTotalarea(double projectTotalarea) {
		this.projectTotalarea = projectTotalarea;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getHouseTotalnum() {
		return houseTotalnum;
	}
	public void setHouseTotalnum(Integer houseTotalnum) {
		this.houseTotalnum = houseTotalnum;
	}
	public Integer getBuildAreanum() {
		return buildAreanum;
	}
	public void setBuildAreanum(Integer buildAreanum) {
		this.buildAreanum = buildAreanum;
	}
	public Integer getBuildUnitnum() {
		return buildUnitnum;
	}
	public void setBuildUnitnum(Integer buildUnitnum) {
		this.buildUnitnum = buildUnitnum;
	}
	public Integer getBuildBuildnum() {
		return buildBuildnum;
	}
	public void setBuildBuildnum(Integer buildBuildnum) {
		this.buildBuildnum = buildBuildnum;
	}
	public Integer getStallNum() {
		return stallNum;
	}
	public void setStallNum(Integer stallNum) {
		this.stallNum = stallNum;
	}
	public Integer getUndergroundParkingspacestotal() {
		return undergroundParkingspacestotal;
	}
	public void setUndergroundParkingspacestotal(
			Integer undergroundParkingspacestotal) {
		this.undergroundParkingspacestotal = undergroundParkingspacestotal;
	}
	public Integer getGroundParkingspacetotal() {
		return groundParkingspacetotal;
	}
	public void setGroundParkingspacetotal(Integer groundParkingspacetotal) {
		this.groundParkingspacetotal = groundParkingspacetotal;
	}
	public double getGreeningRate() {
		return greeningRate;
	}
	public void setGreeningRate(double greeningRate) {
		this.greeningRate = greeningRate;
	}
	public double getTotalBuildarea() {
		return totalBuildarea;
	}
	public void setTotalBuildarea(double totalBuildarea) {
		this.totalBuildarea = totalBuildarea;
	}
	public double getBasementArea() {
		return basementArea;
	}
	public void setBasementArea(double basementArea) {
		this.basementArea = basementArea;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getParcel() {
		return parcel;
	}
	public void setParcel(String parcel) {
		this.parcel = parcel;
	}
	public String getPlanning() {
		return planning;
	}
	public void setPlanning(String planning) {
		this.planning = planning;
	}
	public Company getCompanyDetail() {
		return companyDetail;
	}
	public void setCompanyDetail(Company companyDetail) {
		this.companyDetail = companyDetail;
	}
	public ProjectCompletion getProjectCompletion() {
		return projectCompletion;
	}
	public void setProjectCompletion(ProjectCompletion projectCompletion) {
		this.projectCompletion = projectCompletion;
	}
   }