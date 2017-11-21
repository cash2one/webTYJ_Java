/**
 * @Title: PageRestful.java
 * @Package com.flf.entity
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件�?��有限公司
 * 
 * @author wangtao
 * @date 2015-4-20 下午2:02:26
 * @version V1.0
 */

package com.flf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.request.CassetRepositoryReault;
import com.flf.request.FixedParkingSpace;


/**
 * @ClassName: PageRestful
 * @Description: TODO
 * @author wangyang
 * @date 2015-4-20 下午2:02:26
 * 
 */
@XmlRootElement(name = "PageRestful")
public class PageRestful {
	private List<AfterSaleProcess> afterSaleProcess;//售后处理
	
	private List<AfterSale> afterSales;//售后管理
	
	private List<AfterSaleQuery> afterSaleQuery;//售后管理查询条件类
	
	private List<Project> departments;  //售后管理项目下拉框
	
	private List<PropertyType> propertyTypes; //售后管理专业查询条件
	
	private List<Produceprice> produceprices; // 产品管理
	
	private List<Faq> faqs;// FAQS
	
	private List<Faqs> faqnew;//服务请求FAQ
	
	private List<Vacation> vacations = new ArrayList<Vacation>();// 假期信息
	
	private List<Functional> functionals;  //功能区配置
	
	private List<CassetRepository> cassetRepositorys; //资产库
	
	private List<PersonBuildingNew> PersonBuildingNew; 
	
	private List<ChargeItemNew> chargeItemNews;//收费项目
	
	private List<AcceptanceHouse> acceptanceHouses;//房屋初验
	
	private List<ServiceRequest> serviceRequests;
	
	private List<Tasks> tasks;//任务单
	
	private List<CollectionManage> collectionManages;  //银行托收办理
	
	private List<UnionpayCollectionTotall> unionpayCollectionTotalls;//银联托收总结
	
	private List<AdvancePaymentsDetails> advancePaymentsDetails;//与支付明细
	
	private List<UnionpayCounterofferTotal> unionpayCounterofferTotals;//银行托收
	
	private List<PersonCustNew> personCustNew; // 个人客户信息
	
	private List<Caraccesscard> caraccesscards; // 个人客户信息
	
	private List<CassetRepositoryReault> cassetRepositoryReault;//条件查询资产库（新）
	
	private List<MeterReadingProgram> MeterReadingProgram;  //抄表计划信息
	
	private List<MeterReadingData> MeterReadingData;  //抄表数据信息
	
	private List<ElectricityMeterReadingProgram> electricityMeterReadingProgram;  //电表抄表计划信息
	
	private List<ElectricityMeterReadingData> electricityMeterReadingData;  //电表抄表数据信息
	
	private List<PersonEmphasis> personEmphasiss ;  //重要客户
	
	private List<PersonVip> personVips ;  //vip客户
	
	private List<BuildingComponent> buildingComponents; //建筑组件
	
	private List<ComponentProperty> componentPropertys;//建筑组件与资产关系
	
	private List<ComponentStructure> componentStructures; //建筑组件与建筑结构关系
	
	private List<Staff> staffs; //人员表
	
	private List<SpecialtyInfo> specialtyInfos; //专业线
	
	private List<Communtitnotice> communtitnotices; //小区公告
	
	private List<Rules> ruless; //规章制度
	
	private List<Inform> informs; //内部公告
	
	private List<Corporatenews> corporatenewss; //内部公告
	
	private List<Log> logs; //日志表
	
	private List<WaterMeter> waterMeter; //水表表
	
	private List<MeterReadingComplaints> meterReadingComplaints; //抄表投诉
	
	private List<ElectricityMeter> electricityMeter;  //电表
	
	private List<Project> project;
	
	private List<Contract> contract;
	
	private List<ApplicationDelayRecords> applicationDelayRecords;//延时记录表
	
	private List<UrgeTaskRecords> UrgeTaskRecords;//延时记录表
	
	private  List<EnterpriseCustNew> enterpriseCustNews;  //企业客户信息
	
	private List<GateAccount> gateAccounts;
	
	private List<StallNew> stallNews;
	
	private List<GiftArticle> giftArticle;
	
	private List<Gift> gift;
	
	private List<IntakeActivity> intakeActivity;
	
    private List<Teamworkstaff> teamworkStaffs;//团队表
    
    private List<Intake> intakes;
	
    private List<News> newss;//新闻信息分页 创建by肖聪
	
	private List<ChangeTitle> changeTitles;//实例信息
	
	private List<CarInfo> carInfos;// 车辆信息
	
	private List<NewLease> newLeases; // 租赁信息
	
	private List<TenementPact> tenementPacts;//物业合同
	
	private List<PetRegistration> petRegistrations;//宠物
	
	private List<WaterMeterRecords> waterMeterRecords; //水表使用记录查询
	
	private List<ElectricityMeterRecords> electricityMeterRecords; //电表使用记录查询
	
	private List<FixedParkingSpace> fixedParkingSpaces;//产品初始化固定车位返回结果
	
	private List<DecorationInspectionPlans> decorationInspectionPlan;//装修服务巡检方案
	
	List<ExecutionTimeRecords> executionTimeRecord;//巡检执行次数
	
	private List<ArticleRelease> articleReleases;//放行条
	
	private List<Entrance> entrances;//门禁卡
	
	private List<MeterReadingResults> MeterReadingResult;//抄表执行结果
	
    private List<TcArticleState> tcArticleStates;//遗失物品
    
    private List<LeaseContract> leaseContracts;//租赁合同
    
    private List<ProductBs> productBss;//建筑产品列表
    
    private List<Property> propertys;//资产绑定
    
    private List<UnionpayCollectionDetail>unionpayCollectionDetails;
    
    private List<UnionpayCounterofferDetai> unionpayCounterofferDetais;
    
    private List<FinancialCounterofferTotal> financialCounterofferTotals;//回盘总结文件
   
    private List<SpecialRepairProject> specialRepairProject;//专项项目管理

    private List<CentralizedTreatmentProjects> CentralizedTreatmentProjects; //集中项目
    
    private List<FinancialCounterofferDetail> financialCounterofferDetails;//回盘明细文件
    
    private List<FinancialBankNum> financialBankNums;//银行行别
    
    private List<ChargeType> chargetypes;

	private List<StoreNew> storeNews;

	private List<Lost> losts;//遗失物品

	private List<AreaTypeNew> areaTypeNews;//面积管理
	
	private List<Teamwork> teamworks;//团队管理

	private List<Scheme> schemes;//方案
	
	private List<FinancialGroupTotal> financialGroupTotals;// 金融联银行总结
	
	private List<FinancialGroupDetail> financialGroupDetails;// 金融联银行托收明细

	private List<AccountRecord> accountRecords;//交账记录表
	
	private List<PaymentDetails> paymentDetail;//支付明细
	
	private List<Bill> bills;//计费表
	
	private List<AssetAccount> assetAccounts;//资产账户表
	
	private List<Product> products;//产品表BuildingBilling
	
	private List<DataDictionaryMaster> dataDictionaryMasters;//数据字典表主表
	
	private List<DataDictionarySlave> dataDictionarySlaves;//数据字典表从表
	
	private List<DataDictionaryMasterProject> dataDictionaryMasterProjects;//数据字典从表与项目关联表
	
	private List<SubCompany> subCompanies;//子公司	

	private List<InspectionPlan> inspectionPlan;//巡检方案表
	
	private List<ImportantEventType> importantEventTypes;//重大事项类型表
	
	private List<HouseNew> houseNews;//住宅表
	
	private List<Authorization> authorizations;//授权表
	
	private List<PendingApproval> pendingApprovals;
	
	private List<TUserRole> tUserRoles;
	
	private List<CorePosition> corePositions;//核心岗位表
	
	private List<TenementInsurance> tenementInsurances;//物业合同
	
	private List<ElectronicBilling> electronicBillings;//电子账单表
	
	private List<ProjectBilling> projectBillings;//项目计费 
	
	private List<ChargeTypeProjectBilling> chargeTypeProjectBillings;//收费类型项目计费
	
	private List<ChargeTypeBuildingBilling> chargeTypeBuildingBillings;//收费类型建筑计费 
	
	private List<ChargeTypeDetailsBuildingBilling> chargeTypeDetailsBuildingBillings;//收费类型详情建筑计费 
	
	private Page page;//分页
	
	private List<ElectricityMeterReadingComplaints> electricityMeterReadingComplaints; //抄表投诉
	
	private List<BillingRecord> billingRecords;//计费记录
	
	private List<ProductFixedparkingspace> productFixedparkingspaces;//固定车位主表list
	
	private ProductFixedparkingspace productFixedparkingspace;//固定车位主表
	
	private List<ProductFixedparkingspaceChild> productFixedparkingspaceChilds;//固定车位子表

	
	private List<WorkFlow> workFlows;
	
	private List<TUser> tUsers;
	
	private java.util.List<com.flf.entity.Insurance> insuranceCompany;//保险公司
	
	private List<BuildingStructureNew> buildingStructureNews;
	
	public List<AfterSaleProcess> getAfterSaleProcess() {
		return afterSaleProcess;
	}

	public void setAfterSaleProcess(List<AfterSaleProcess> afterSaleProcess) {
		this.afterSaleProcess = afterSaleProcess;
	}

	public java.util.List<com.flf.entity.Insurance> getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(java.util.List<com.flf.entity.Insurance> insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public List<TUser> gettUsers() {
		return tUsers;
	}

	public void settUsers(List<TUser> tUsers) {
		this.tUsers = tUsers;
	}

	public List<WorkFlow> getWorkFlows() {
		return workFlows;
	}

	public void setWorkFlows(List<WorkFlow> workFlows) {
		this.workFlows = workFlows;
	}

	
	public ProductFixedparkingspace getProductFixedparkingspace() {
		return productFixedparkingspace;
	}

	public void setProductFixedparkingspace(ProductFixedparkingspace productFixedparkingspace) {
		this.productFixedparkingspace = productFixedparkingspace;
	}

	public List<ProductFixedparkingspaceChild> getProductFixedparkingspaceChilds() {
		return productFixedparkingspaceChilds;
	}

	public void setProductFixedparkingspaceChilds(List<ProductFixedparkingspaceChild> productFixedparkingspaceChilds) {
		this.productFixedparkingspaceChilds = productFixedparkingspaceChilds;
	}

	public List<ProductFixedparkingspace> getProductFixedparkingspaces() {
		return productFixedparkingspaces;
	}

	public void setProductFixedparkingspaces(List<ProductFixedparkingspace> productFixedparkingspaces) {
		this.productFixedparkingspaces = productFixedparkingspaces;
	}

	public List<BillingRecord> getBillingRecords() {
		return billingRecords;
	}

	public void setBillingRecords(List<BillingRecord> billingRecords) {
		this.billingRecords = billingRecords;
	}

	public List<ElectricityMeterReadingComplaints> getElectricityMeterReadingComplaints() {
		return electricityMeterReadingComplaints;
	}

	public void setElectricityMeterReadingComplaints(
			List<ElectricityMeterReadingComplaints> electricityMeterReadingComplaints) {
		this.electricityMeterReadingComplaints = electricityMeterReadingComplaints;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<ChargeTypeProjectBilling> getChargeTypeProjectBillings() {
		return chargeTypeProjectBillings;
	}

	public void setChargeTypeProjectBillings(
			List<ChargeTypeProjectBilling> chargeTypeProjectBillings) {
		this.chargeTypeProjectBillings = chargeTypeProjectBillings;
	}

	public List<ChargeTypeBuildingBilling> getChargeTypeBuildingBillings() {
		return chargeTypeBuildingBillings;
	}

	public void setChargeTypeBuildingBillings(
			List<ChargeTypeBuildingBilling> chargeTypeBuildingBillings) {
		this.chargeTypeBuildingBillings = chargeTypeBuildingBillings;
	}

	public List<ChargeTypeDetailsBuildingBilling> getChargeTypeDetailsBuildingBillings() {
		return chargeTypeDetailsBuildingBillings;
	}

	public void setChargeTypeDetailsBuildingBillings(
			List<ChargeTypeDetailsBuildingBilling> chargeTypeDetailsBuildingBillings) {
		this.chargeTypeDetailsBuildingBillings = chargeTypeDetailsBuildingBillings;
	}

	public List<AfterSale> getAfterSales() {
		return afterSales;
	}

	public void setAfterSales(List<AfterSale> afterSales) {
		this.afterSales = afterSales;
	}

	public List<AfterSaleQuery> getAfterSaleQuery() {
		return afterSaleQuery;
	}

	public void setAfterSaleQuery(List<AfterSaleQuery> afterSaleQuery) {
		this.afterSaleQuery = afterSaleQuery;
	}

	public List<Project> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Project> departments) {
		this.departments = departments;
	}

	public List<PropertyType> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(List<PropertyType> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public List<Produceprice> getProduceprices() {
		return produceprices;
	}

	public void setProduceprices(List<Produceprice> produceprices) {
		this.produceprices = produceprices;
	}

	public List<Faq> getFaqs() {
		return faqs;
	}

	public void setFaqs(List<Faq> faqs) {
		this.faqs = faqs;
	}

	public List<Faqs> getFaqnew() {
		return faqnew;
	}

	public void setFaqnew(List<Faqs> faqnew) {
		this.faqnew = faqnew;
	}

	public List<Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

	public List<Functional> getFunctionals() {
		return functionals;
	}

	public void setFunctionals(List<Functional> functionals) {
		this.functionals = functionals;
	}

	public List<CassetRepository> getCassetRepositorys() {
		return cassetRepositorys;
	}

	public void setCassetRepositorys(List<CassetRepository> cassetRepositorys) {
		this.cassetRepositorys = cassetRepositorys;
	}

	public List<PersonBuildingNew> getPersonBuildingNew() {
		return PersonBuildingNew;
	}

	public void setPersonBuildingNew(List<PersonBuildingNew> personBuildingNew) {
		PersonBuildingNew = personBuildingNew;
	}

	public List<ChargeItemNew> getChargeItemNews() {
		return chargeItemNews;
	}

	public void setChargeItemNews(List<ChargeItemNew> chargeItemNews) {
		this.chargeItemNews = chargeItemNews;
	}

	public List<AcceptanceHouse> getAcceptanceHouses() {
		return acceptanceHouses;
	}

	public void setAcceptanceHouses(List<AcceptanceHouse> acceptanceHouses) {
		this.acceptanceHouses = acceptanceHouses;
	}

	public List<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public List<CollectionManage> getCollectionManages() {
		return collectionManages;
	}

	public void setCollectionManages(List<CollectionManage> collectionManages) {
		this.collectionManages = collectionManages;
	}

	public List<UnionpayCollectionTotall> getUnionpayCollectionTotalls() {
		return unionpayCollectionTotalls;
	}

	public void setUnionpayCollectionTotalls(
			List<UnionpayCollectionTotall> unionpayCollectionTotalls) {
		this.unionpayCollectionTotalls = unionpayCollectionTotalls;
	}

	public List<AdvancePaymentsDetails> getAdvancePaymentsDetails() {
		return advancePaymentsDetails;
	}

	public void setAdvancePaymentsDetails(
			List<AdvancePaymentsDetails> advancePaymentsDetails) {
		this.advancePaymentsDetails = advancePaymentsDetails;
	}

	public List<UnionpayCounterofferTotal> getUnionpayCounterofferTotals() {
		return unionpayCounterofferTotals;
	}

	public void setUnionpayCounterofferTotals(
			List<UnionpayCounterofferTotal> unionpayCounterofferTotals) {
		this.unionpayCounterofferTotals = unionpayCounterofferTotals;
	}

	public List<PersonCustNew> getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(List<PersonCustNew> personCustNew) {
		this.personCustNew = personCustNew;
	}

	public List<Caraccesscard> getCaraccesscards() {
		return caraccesscards;
	}

	public void setCaraccesscards(List<Caraccesscard> caraccesscards) {
		this.caraccesscards = caraccesscards;
	}

	public List<CassetRepositoryReault> getCassetRepositoryReault() {
		return cassetRepositoryReault;
	}

	public void setCassetRepositoryReault(
			List<CassetRepositoryReault> cassetRepositoryReault) {
		this.cassetRepositoryReault = cassetRepositoryReault;
	}

	public List<MeterReadingProgram> getMeterReadingProgram() {
		return MeterReadingProgram;
	}

	public void setMeterReadingProgram(List<MeterReadingProgram> meterReadingProgram) {
		MeterReadingProgram = meterReadingProgram;
	}

	public List<MeterReadingData> getMeterReadingData() {
		return MeterReadingData;
	}

	public void setMeterReadingData(List<MeterReadingData> meterReadingData) {
		MeterReadingData = meterReadingData;
	}

	public List<ElectricityMeterReadingProgram> getElectricityMeterReadingProgram() {
		return electricityMeterReadingProgram;
	}

	public void setElectricityMeterReadingProgram(
			List<ElectricityMeterReadingProgram> electricityMeterReadingProgram) {
		this.electricityMeterReadingProgram = electricityMeterReadingProgram;
	}

	public List<ElectricityMeterReadingData> getElectricityMeterReadingData() {
		return electricityMeterReadingData;
	}

	public void setElectricityMeterReadingData(
			List<ElectricityMeterReadingData> electricityMeterReadingData) {
		this.electricityMeterReadingData = electricityMeterReadingData;
	}

	public List<PersonEmphasis> getPersonEmphasiss() {
		return personEmphasiss;
	}

	public void setPersonEmphasiss(List<PersonEmphasis> personEmphasiss) {
		this.personEmphasiss = personEmphasiss;
	}

	public List<PersonVip> getPersonVips() {
		return personVips;
	}

	public void setPersonVips(List<PersonVip> personVips) {
		this.personVips = personVips;
	}

	public List<BuildingComponent> getBuildingComponents() {
		return buildingComponents;
	}

	public void setBuildingComponents(List<BuildingComponent> buildingComponents) {
		this.buildingComponents = buildingComponents;
	}

	public List<ComponentProperty> getComponentPropertys() {
		return componentPropertys;
	}

	public void setComponentPropertys(List<ComponentProperty> componentPropertys) {
		this.componentPropertys = componentPropertys;
	}

	public List<ComponentStructure> getComponentStructures() {
		return componentStructures;
	}

	public void setComponentStructures(List<ComponentStructure> componentStructures) {
		this.componentStructures = componentStructures;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<SpecialtyInfo> getSpecialtyInfos() {
		return specialtyInfos;
	}

	public void setSpecialtyInfos(List<SpecialtyInfo> specialtyInfos) {
		this.specialtyInfos = specialtyInfos;
	}

	public List<Communtitnotice> getCommuntitnotices() {
		return communtitnotices;
	}

	public void setCommuntitnotices(List<Communtitnotice> communtitnotices) {
		this.communtitnotices = communtitnotices;
	}

	public List<Rules> getRuless() {
		return ruless;
	}

	public void setRuless(List<Rules> ruless) {
		this.ruless = ruless;
	}

	public List<Inform> getInforms() {
		return informs;
	}

	public void setInforms(List<Inform> informs) {
		this.informs = informs;
	}

	public List<Corporatenews> getCorporatenewss() {
		return corporatenewss;
	}

	public void setCorporatenewss(List<Corporatenews> corporatenewss) {
		this.corporatenewss = corporatenewss;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<WaterMeter> getWaterMeter() {
		return waterMeter;
	}

	public void setWaterMeter(List<WaterMeter> waterMeter) {
		this.waterMeter = waterMeter;
	}

	public List<MeterReadingComplaints> getMeterReadingComplaints() {
		return meterReadingComplaints;
	}

	public void setMeterReadingComplaints(
			List<MeterReadingComplaints> meterReadingComplaints) {
		this.meterReadingComplaints = meterReadingComplaints;
	}

	public List<ElectricityMeter> getElectricityMeter() {
		return electricityMeter;
	}

	public void setElectricityMeter(List<ElectricityMeter> electricityMeter) {
		this.electricityMeter = electricityMeter;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	public List<ApplicationDelayRecords> getApplicationDelayRecords() {
		return applicationDelayRecords;
	}

	public void setApplicationDelayRecords(
			List<ApplicationDelayRecords> applicationDelayRecords) {
		this.applicationDelayRecords = applicationDelayRecords;
	}

	public List<UrgeTaskRecords> getUrgeTaskRecords() {
		return UrgeTaskRecords;
	}

	public void setUrgeTaskRecords(List<UrgeTaskRecords> urgeTaskRecords) {
		UrgeTaskRecords = urgeTaskRecords;
	}

	public List<EnterpriseCustNew> getEnterpriseCustNews() {
		return enterpriseCustNews;
	}

	public void setEnterpriseCustNews(List<EnterpriseCustNew> enterpriseCustNews) {
		this.enterpriseCustNews = enterpriseCustNews;
	}

	public List<GateAccount> getGateAccounts() {
		return gateAccounts;
	}

	public void setGateAccounts(List<GateAccount> gateAccounts) {
		this.gateAccounts = gateAccounts;
	}

	public List<StallNew> getStallNews() {
		return stallNews;
	}

	public void setStallNews(List<StallNew> stallNews) {
		this.stallNews = stallNews;
	}

	public List<GiftArticle> getGiftArticle() {
		return giftArticle;
	}

	public void setGiftArticle(List<GiftArticle> giftArticle) {
		this.giftArticle = giftArticle;
	}

	public List<Gift> getGift() {
		return gift;
	}

	public void setGift(List<Gift> gift) {
		this.gift = gift;
	}

	public List<IntakeActivity> getIntakeActivity() {
		return intakeActivity;
	}

	public void setIntakeActivity(List<IntakeActivity> intakeActivity) {
		this.intakeActivity = intakeActivity;
	}

	public List<Teamworkstaff> getTeamworkStaffs() {
		return teamworkStaffs;
	}

	public void setTeamworkStaffs(List<Teamworkstaff> teamworkStaffs) {
		this.teamworkStaffs = teamworkStaffs;
	}

	public List<Intake> getIntakes() {
		return intakes;
	}

	public void setIntakes(List<Intake> intakes) {
		this.intakes = intakes;
	}

	public List<News> getNewss() {
		return newss;
	}

	public void setNewss(List<News> newss) {
		this.newss = newss;
	}

	public List<ChangeTitle> getChangeTitles() {
		return changeTitles;
	}

	public void setChangeTitles(List<ChangeTitle> changeTitles) {
		this.changeTitles = changeTitles;
	}

	public List<CarInfo> getCarInfos() {
		return carInfos;
	}

	public void setCarInfos(List<CarInfo> carInfos) {
		this.carInfos = carInfos;
	}

	public List<NewLease> getNewLeases() {
		return newLeases;
	}

	public void setNewLeases(List<NewLease> newLeases) {
		this.newLeases = newLeases;
	}

	public List<TenementPact> getTenementPacts() {
		return tenementPacts;
	}

	public void setTenementPacts(List<TenementPact> tenementPacts) {
		this.tenementPacts = tenementPacts;
	}

	public List<PetRegistration> getPetRegistrations() {
		return petRegistrations;
	}

	public void setPetRegistrations(List<PetRegistration> petRegistrations) {
		this.petRegistrations = petRegistrations;
	}

	public List<WaterMeterRecords> getWaterMeterRecords() {
		return waterMeterRecords;
	}

	public void setWaterMeterRecords(List<WaterMeterRecords> waterMeterRecords) {
		this.waterMeterRecords = waterMeterRecords;
	}

	public List<ElectricityMeterRecords> getElectricityMeterRecords() {
		return electricityMeterRecords;
	}

	public void setElectricityMeterRecords(
			List<ElectricityMeterRecords> electricityMeterRecords) {
		this.electricityMeterRecords = electricityMeterRecords;
	}

	public List<FixedParkingSpace> getFixedParkingSpaces() {
		return fixedParkingSpaces;
	}

	public void setFixedParkingSpaces(List<FixedParkingSpace> fixedParkingSpaces) {
		this.fixedParkingSpaces = fixedParkingSpaces;
	}

	public List<DecorationInspectionPlans> getDecorationInspectionPlan() {
		return decorationInspectionPlan;
	}

	public void setDecorationInspectionPlan(
			List<DecorationInspectionPlans> decorationInspectionPlan) {
		this.decorationInspectionPlan = decorationInspectionPlan;
	}

	public List<ArticleRelease> getArticleReleases() {
		return articleReleases;
	}

	public void setArticleReleases(List<ArticleRelease> articleReleases) {
		this.articleReleases = articleReleases;
	}

	public List<Entrance> getEntrances() {
		return entrances;
	}

	public void setEntrances(List<Entrance> entrances) {
		this.entrances = entrances;
	}

	public List<MeterReadingResults> getMeterReadingResult() {
		return MeterReadingResult;
	}

	public void setMeterReadingResult(List<MeterReadingResults> meterReadingResult) {
		MeterReadingResult = meterReadingResult;
	}

	public List<TcArticleState> getTcArticleStates() {
		return tcArticleStates;
	}

	public void setTcArticleStates(List<TcArticleState> tcArticleStates) {
		this.tcArticleStates = tcArticleStates;
	}

	public List<LeaseContract> getLeaseContracts() {
		return leaseContracts;
	}

	public void setLeaseContracts(List<LeaseContract> leaseContracts) {
		this.leaseContracts = leaseContracts;
	}

	public List<ProductBs> getProductBss() {
		return productBss;
	}

	public void setProductBss(List<ProductBs> productBss) {
		this.productBss = productBss;
	}

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public List<UnionpayCollectionDetail> getUnionpayCollectionDetails() {
		return unionpayCollectionDetails;
	}

	public void setUnionpayCollectionDetails(
			List<UnionpayCollectionDetail> unionpayCollectionDetails) {
		this.unionpayCollectionDetails = unionpayCollectionDetails;
	}

	public List<UnionpayCounterofferDetai> getUnionpayCounterofferDetais() {
		return unionpayCounterofferDetais;
	}

	public void setUnionpayCounterofferDetais(
			List<UnionpayCounterofferDetai> unionpayCounterofferDetais) {
		this.unionpayCounterofferDetais = unionpayCounterofferDetais;
	}

	public List<FinancialCounterofferTotal> getFinancialCounterofferTotals() {
		return financialCounterofferTotals;
	}

	public void setFinancialCounterofferTotals(
			List<FinancialCounterofferTotal> financialCounterofferTotals) {
		this.financialCounterofferTotals = financialCounterofferTotals;
	}

	public List<SpecialRepairProject> getSpecialRepairProject() {
		return specialRepairProject;
	}

	public void setSpecialRepairProject(
			List<SpecialRepairProject> specialRepairProject) {
		this.specialRepairProject = specialRepairProject;
	}

	public List<CentralizedTreatmentProjects> getCentralizedTreatmentProjects() {
		return CentralizedTreatmentProjects;
	}

	public void setCentralizedTreatmentProjects(
			List<CentralizedTreatmentProjects> centralizedTreatmentProjects) {
		CentralizedTreatmentProjects = centralizedTreatmentProjects;
	}

	public List<FinancialCounterofferDetail> getFinancialCounterofferDetails() {
		return financialCounterofferDetails;
	}

	public void setFinancialCounterofferDetails(
			List<FinancialCounterofferDetail> financialCounterofferDetails) {
		this.financialCounterofferDetails = financialCounterofferDetails;
	}

	public List<FinancialBankNum> getFinancialBankNums() {
		return financialBankNums;
	}

	public void setFinancialBankNums(List<FinancialBankNum> financialBankNums) {
		this.financialBankNums = financialBankNums;
	}

	public List<ChargeType> getChargetypes() {
		return chargetypes;
	}

	public void setChargetypes(List<ChargeType> chargetypes) {
		this.chargetypes = chargetypes;
	}

	public List<StoreNew> getStoreNews() {
		return storeNews;
	}

	public void setStoreNews(List<StoreNew> storeNews) {
		this.storeNews = storeNews;
	}

	public List<Lost> getLosts() {
		return losts;
	}

	public void setLosts(List<Lost> losts) {
		this.losts = losts;
	}

	public List<AreaTypeNew> getAreaTypeNews() {
		return areaTypeNews;
	}

	public void setAreaTypeNews(List<AreaTypeNew> areaTypeNews) {
		this.areaTypeNews = areaTypeNews;
	}

	public List<Teamwork> getTeamworks() {
		return teamworks;
	}

	public void setTeamworks(List<Teamwork> teamworks) {
		this.teamworks = teamworks;
	}

	public List<ProjectBilling> getProjectBillings() {
		return projectBillings;
	}

	public void setProjectBillings(List<ProjectBilling> projectBillings) {
		this.projectBillings = projectBillings;
	}

	public List<Scheme> getSchemes() {
		return schemes;
	}

	public void setSchemes(List<Scheme> schemes) {
		this.schemes = schemes;
	}

	public List<FinancialGroupTotal> getFinancialGroupTotals() {
		return financialGroupTotals;
	}

	public void setFinancialGroupTotals(
			List<FinancialGroupTotal> financialGroupTotals) {
		this.financialGroupTotals = financialGroupTotals;
	}

	public List<FinancialGroupDetail> getFinancialGroupDetails() {
		return financialGroupDetails;
	}

	public void setFinancialGroupDetails(
			List<FinancialGroupDetail> financialGroupDetails) {
		this.financialGroupDetails = financialGroupDetails;
	}

	public List<AccountRecord> getAccountRecords() {
		return accountRecords;
	}

	public void setAccountRecords(List<AccountRecord> accountRecords) {
		this.accountRecords = accountRecords;
	}

	public List<PaymentDetails> getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(List<PaymentDetails> paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<AssetAccount> getAssetAccounts() {
		return assetAccounts;
	}

	public void setAssetAccounts(List<AssetAccount> assetAccounts) {
		this.assetAccounts = assetAccounts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<DataDictionaryMaster> getDataDictionaryMasters() {
		return dataDictionaryMasters;
	}

	public void setDataDictionaryMasters(
			List<DataDictionaryMaster> dataDictionaryMasters) {
		this.dataDictionaryMasters = dataDictionaryMasters;
	}

	public List<DataDictionarySlave> getDataDictionarySlaves() {
		return dataDictionarySlaves;
	}

	public void setDataDictionarySlaves(
			List<DataDictionarySlave> dataDictionarySlaves) {
		this.dataDictionarySlaves = dataDictionarySlaves;
	}

	public List<DataDictionaryMasterProject> getDataDictionaryMasterProjects() {
		return dataDictionaryMasterProjects;
	}

	public void setDataDictionaryMasterProjects(
			List<DataDictionaryMasterProject> dataDictionaryMasterProjects) {
		this.dataDictionaryMasterProjects = dataDictionaryMasterProjects;
	}

	public List<SubCompany> getSubCompanies() {
		return subCompanies;
	}

	public void setSubCompanies(List<SubCompany> subCompanies) {
		this.subCompanies = subCompanies;
	}

	public List<InspectionPlan> getInspectionPlan() {
		return inspectionPlan;
	}

	public void setInspectionPlan(List<InspectionPlan> inspectionPlan) {
		this.inspectionPlan = inspectionPlan;
	}

	public List<ImportantEventType> getImportantEventTypes() {
		return importantEventTypes;
	}

	public void setImportantEventTypes(List<ImportantEventType> importantEventTypes) {
		this.importantEventTypes = importantEventTypes;
	}

	public List<HouseNew> getHouseNews() {
		return houseNews;
	}

	public void setHouseNews(List<HouseNew> houseNews) {
		this.houseNews = houseNews;
	}

	public List<Authorization> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(List<Authorization> authorizations) {
		this.authorizations = authorizations;
	}

	public List<PendingApproval> getPendingApprovals() {
		return pendingApprovals;
	}

	public void setPendingApprovals(List<PendingApproval> pendingApprovals) {
		this.pendingApprovals = pendingApprovals;
	}

	public List<TUserRole> gettUserRoles() {
		return tUserRoles;
	}

	public void settUserRoles(List<TUserRole> tUserRoles) {
		this.tUserRoles = tUserRoles;
	}

	public List<CorePosition> getCorePositions() {
		return corePositions;
	}

	public void setCorePositions(List<CorePosition> corePositions) {
		this.corePositions = corePositions;
	}

	public List<TenementInsurance> getTenementInsurances() {
		return tenementInsurances;
	}

	public void setTenementInsurances(List<TenementInsurance> tenementInsurances) {
		this.tenementInsurances = tenementInsurances;
	}

	public List<ElectronicBilling> getElectronicBillings() {
		return electronicBillings;
	}

	public void setElectronicBillings(List<ElectronicBilling> electronicBillings) {
		this.electronicBillings = electronicBillings;
	}

	public List<BuildingStructureNew> getBuildingStructureNews() {
		return buildingStructureNews;
	}

	public void setBuildingStructureNews(List<BuildingStructureNew> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}

	public List<ExecutionTimeRecords> getExecutionTimeRecord() {
		return executionTimeRecord;
	}

	public void setExecutionTimeRecord(List<ExecutionTimeRecords> executionTimeRecord) {
		this.executionTimeRecord = executionTimeRecord;
	}
	
}
