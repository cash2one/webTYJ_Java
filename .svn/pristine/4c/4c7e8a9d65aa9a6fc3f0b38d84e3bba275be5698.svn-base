package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;*/















import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.AreaNew;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.AssetAccount;
import com.flf.entity.BuildingNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CassetRepository;
import com.flf.entity.HouseNew;
import com.flf.entity.Intake;
import com.flf.entity.Project;
import com.flf.entity.Sipmanage;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;
import com.flf.mapper.AreaNewMapper;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BuildingNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.CassetRepositoryMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.IntakeMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SipmanageMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.request.Tree;
import com.flf.service.BuildingNewService;
import com.flf.util.JsonUtil;

public class BuildingNewServiceImpl implements BuildingNewService {
	
	private BuildingNewMapper buildingNewMapper;
	
	private AreaNewMapper areaNewMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;  
	
	private CassetRepositoryMapper cassetRepositoryMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	private ProjectMapper projectMapper;
	
	private SipmanageMapper sipmanageMapper;
	
	private HouseNewMapper houseNewMapper;
	
	private StallNewMapper stallNewMapper;
	
	private StoreNewMapper storeNewMapper;
	
	private AssetAccountMapper assetAccountMapper;//资产账户mapper 王洲  2016.04.19
	
	private IntakeMapper intakeMapper;//入伙

	/*
	  * <p>Title: deleteBuildingNew</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.BuildingNewService#deleteBuildingNew(java.lang.String)
	  */
	
	public IntakeMapper getIntakeMapper() {
		return intakeMapper;
	}

	public void setIntakeMapper(IntakeMapper intakeMapper) {
		this.intakeMapper = intakeMapper;
	}

	public AreaNewMapper getAreaNewMapper() {
		return areaNewMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public CassetRepositoryMapper getCassetRepositoryMapper() {
		return cassetRepositoryMapper;
	}

	public void setCassetRepositoryMapper(
			CassetRepositoryMapper cassetRepositoryMapper) {
		this.cassetRepositoryMapper = cassetRepositoryMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public void setAreaNewMapper(AreaNewMapper areaNewMapper) {
		this.areaNewMapper = areaNewMapper;
	}

	public BuildingNewMapper getBuildingNewMapper() {
		return buildingNewMapper;
	}

	public void setBuildingNewMapper(BuildingNewMapper buildingNewMapper) {
		this.buildingNewMapper = buildingNewMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public SipmanageMapper getSipmanageMapper() {
		return sipmanageMapper;
	}

	public void setSipmanageMapper(SipmanageMapper sipmanageMapper) {
		this.sipmanageMapper = sipmanageMapper;
	}

	public HouseNewMapper getHouseNewMapper() {
		return houseNewMapper;
	}

	public void setHouseNewMapper(HouseNewMapper houseNewMapper) {
		this.houseNewMapper = houseNewMapper;
	}

	public StallNewMapper getStallNewMapper() {
		return stallNewMapper;
	}

	public void setStallNewMapper(StallNewMapper stallNewMapper) {
		this.stallNewMapper = stallNewMapper;
	}

	public StoreNewMapper getStoreNewMapper() {
		return storeNewMapper;
	}

	public void setStoreNewMapper(StoreNewMapper storeNewMapper) {
		this.storeNewMapper = storeNewMapper;
	}

	public AssetAccountMapper getAssetAccountMapper() {
		return assetAccountMapper;
	}

	public void setAssetAccountMapper(AssetAccountMapper assetAccountMapper) {
		this.assetAccountMapper = assetAccountMapper;
	}

	@Override
	public int deleteBuildingNew(String id) {
		// TODO Auto-generated method stub
		return buildingNewMapper.deleteBuildingNew(id);
	}

	/*
	  * <p>Title: insertBuildingNew</p>
	  * <p>Description: </p>
	  * @param building
	  * @return
	  * @see com.flf.service.BuildingNewService#insertBuildingNew(com.flf.entity.BuildingNew)
	  */
	
	
	@Override
	public int insertBuildingNew(BuildingNew building) {
		// TODO Auto-generated method stub
		return buildingNewMapper.insertBuildingNew(building);
	}

	/*
	  * <p>Title: listPageBuildingNew</p>
	  * <p>Description: </p>
	  * @param building
	  * @return
	  * @see com.flf.service.BuildingNewService#listPageBuildingNew(com.flf.entity.BuildingNew)
	  */
	
	
	@Override
	public List<BuildingNew> listPageBuildingNew(BuildingNew building) {
		// TODO Auto-generated method stub
		return buildingNewMapper.listPageBuildingNew(building);
	}

	/*
	  * <p>Title: listAllBuildingNew</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.BuildingNewService#listAllBuildingNew()
	  */
	
	
	@Override
	public List<BuildingNew> listAllBuildingNew() {
		// TODO Auto-generated method stub
		return buildingNewMapper.listAllBuildingNew();
	}

	/*
	  * <p>Title: getBuildingNewbyId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.BuildingNewService#getBuildingNewbyId(java.lang.String)
	  */
	
	
	@Override
	public BuildingNew getBuildingNewById(String id) {
		// TODO Auto-generated method stub
		return buildingNewMapper.getBuildingNewById(id);
	}

	/*
	  * <p>Title: updateBuildingNew</p>
	  * <p>Description: </p>
	  * @param building
	  * @return
	  * @see com.flf.service.BuildingNewService#updateBuildingNew(com.flf.entity.BuildingNew)
	  */
	
	
	@Override
	public int updateBuildingNew(BuildingNew building) {
		// TODO Auto-generated method stub
		return buildingNewMapper.updateBuildingNew(building);
	}

	/*
	  * <p>Title: deleteBuildingNewCxf</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.BuildingNewService#deleteBuildingNewCxf(java.lang.String)
	  */
	
	
	@Override
	public String deleteBuildingNewCxf(String id) {
		// TODO Auto-generated method stub
		if(buildingNewMapper.deleteBuildingNew(id)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: insertBuildingNewCXF</p>
	  * <p>Description: </p>
	  * @param building
	  * @return
	  * @see com.flf.service.BuildingNewService#insertBuildingNewCXF(java.lang.String)
	  */
	
	
	@Override
	public String insertBuildingNewCxf(String building) {
		// TODO Auto-generated method stub
		BuildingNew obj=(BuildingNew) JSONObject.toBean(JSONObject.fromObject(building),BuildingNew.class);
		if(buildingNewMapper.insertBuildingNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: listAllBuildingNewCxf</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.BuildingNewService#listAllBuildingNewCxf()
	  */
	
	
	@Override
	public String listAllBuildingNewCxf() {
		// TODO Auto-generated method stub
		List<BuildingNew> buildings = buildingNewMapper.listAllBuildingNew();
		JSONArray json=JSONArray.fromObject(buildings);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: getBuildingNewbyIdCxf</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.BuildingNewService#getBuildingNewbyIdCxf(java.lang.String)
	  */
	
	
	@Override
	public String getBuildingNewByIdCxf(String id) {
		// TODO Auto-generated method stub
		BuildingNew building = buildingNewMapper.getBuildingNewById(id);
		JSONObject json = JSONObject.fromObject(building);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: updateBuildingNewCxf</p>
	  * <p>Description: </p>
	  * @param building
	  * @return
	  * @see com.flf.service.BuildingNewService#updateBuildingNewCxf(java.lang.String)
	  */
	
	
	@Override
	public String updateBuildingNewCxf(String building) {
		// TODO Auto-generated method stub
		BuildingNew obj=(BuildingNew) JSONObject.toBean(JSONObject.fromObject(building),BuildingNew.class);
		if(buildingNewMapper.updateBuildingNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: AddBuilding</p>
	  * <p>Description: </p>
	  * @param buildingnew
	  * @param areaNew
	  * @see com.flf.service.BuildingNewService#AddBuilding(com.flf.entity.BuildingNew, com.flf.entity.AreaNew)
	  */
	
	
	@Override
	public void AddBuildingNew(BuildingNew buildingnew) { 
		Double insideAreaNum = 0.0;
		Double utilityRatioNum = 0.0;
		Double buildingAreaNum = 0.0;
		Double commonalityAreaNum = 0.0;
		Map<String,String> childrenParentMap = new HashMap<String,String>();
		Map<String,String> childrenNameMap = new HashMap<String,String>();
		Map<String,String> childrenUUIDMap = new HashMap<String,String>();
		Map<String,String> childrenTypesMap = new HashMap<String,String>();
		Map<String,String> childrenTypesNameMap = new HashMap<String,String>();
		List<AreaNew> areaNew=buildingnew.getAreaNew();  //获取建筑里面类型列表
		//建筑id
		String uuid = UUID.randomUUID().toString();
		String isFinish = buildingnew.getIsFinish();
		//需要新增到住宅、商铺、车位表中的数据集合
		List<HouseNew> houseList = new ArrayList<HouseNew>();
		HouseNew house = null;
		StallNew stall = null;
		StoreNew store = null;
		//查询出所有sip账户集合
		List<Sipmanage> sipList = sipmanageMapper.listSipmanageByState();
		
		//查询所有的资产账户  王洲  2016.04.19
		List<AssetAccount> assetList = assetAccountMapper.listAllAssetAccount();
		int assetNum = 0;
		if(assetList != null){
			assetNum = assetList.size() > 0 ? 10000 + assetList.size() : 10000;			
		}else{
			assetNum = 10000;
		}
		
		//根据buildingnewId查询buildingStructure，如果没有数据则新增building
		BuildingStructureNew bsn = new BuildingStructureNew();
		bsn = buildingStructureNewMapper.getBuildingStructureNewbyId(buildingnew.getId());
		if(bsn != null){
		}else{
			buildingnew.setId(uuid); //添加主键			
			try {
				buildingNewMapper.insertBuildingNewUUID(buildingnew);  //添加建筑信息
				for (AreaNew area : areaNew) {
					area.setBuildingId(uuid);  //设置建筑id
					insideAreaNum +=area.getInsideArea();
					utilityRatioNum += area.getUtilityRatio();
					buildingAreaNum += area.getBuildingArea();
					commonalityAreaNum += area.getCommonalityArea();
					areaNewMapper.insertAreaNew(area);  //循环添加建筑面积信息 
				}
				//修改项目的面积
				Project project = projectMapper.getProject(buildingnew.getProjectId());
				if(project != null){
					project.setProjectTotalarea(project.getProjectTotalarea() + buildingnew.getTotalArea());
					project.setTotalBuildarea(project.getTotalBuildarea() + buildingnew.getBuildingArea());
					projectMapper.updateProject(project);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
		try {
			 String uuId = UUID.randomUUID().toString();
			 BuildingStructureNew buildingStructure=new BuildingStructureNew();  //建筑结构信息
			 //判断传入的根节点是否在表中存在
			 if(bsn != null){
				 buildingStructure = bsn;
			 }else{				 
				 buildingStructure.setId(uuId);
				 buildingStructure.setBuildingId(buildingnew.getId());  //建筑id
				 buildingStructure.setFullName(buildingnew.getBuildingName()); //节点全面
				 buildingStructure.setNodeName(buildingnew.getBuildingName()); //节点名称
//				 buildingStructure.setParentId(buildingnew.getProjectId());//建筑的父id
				 buildingStructure.setProjectId(buildingnew.getProjectId());//项目id
				 buildingStructure.setBuildingArea(buildingnew.getBuildingArea());//获取建筑总面积
				 buildingStructure.setTotalArea(buildingnew.getTotalArea());//获取用地总面积  王洲  2016.1.7
				 buildingStructure.setInsideArea(insideAreaNum);
				 buildingStructure.setUtilityRatio(insideAreaNum/buildingAreaNum);
				 buildingStructure.setCommonalityArea(commonalityAreaNum);
				 buildingStructure.setIsBindingAssets((byte)0);
				 buildingStructure.setParcelId(buildingnew.getParcelId());//关联宗地id 王洲  2016.2.2
				 buildingStructureNewMapper.insertBuildingStructureNewUUID(buildingStructure); //添加建筑结构信息
				 
				//添加入伙
					Intake intake = new Intake();
					intake.setIntakeId(UUID.randomUUID().toString());
					intake.setHouseId(uuId);
					//入伙状态
					if(isFinish.toString().equals("1")){
						intake.setIntakeState(1);
					}else{
						intake.setIntakeState(0);
					}
					intakeMapper.insertIntake(intake);
			 }
			 
			 Map<String,String> areaTypeMap = new HashMap<String,String>();
			 Map<String,String> areaTypeNameMap = new HashMap<String,String>();
			 //查询所有的建筑面积类型
			 List<AreaTypeNew> atnList = areaTypeNewMapper.listAllAreaTypeNew();
			 if(atnList != null && atnList.size() > 0){
			 	 for(AreaTypeNew atn:atnList){
			 		 //将建筑面积类型的名称和uuid存储入map集合，以便后面根据面积类型检索
					 areaTypeMap.put(atn.getAreaTypeCode(), atn.getId());
					 areaTypeNameMap.put(atn.getAreaTypeCode(), atn.getAreaTypeName());
				 }
			 }
			 
			 if(buildingnew.getTreeList() != null && buildingnew.getTreeList().size() > 0){
			 for(Tree t:buildingnew.getTreeList()){
				 if(t.getId() != null){
					 childrenParentMap.put(t.getId(), t.getpId());
				     childrenUUIDMap.put(t.getId(), UUID.randomUUID().toString());
				     childrenUUIDMap.put(t.getpId(), UUID.randomUUID().toString());
					 childrenNameMap.put(t.getId(), t.getName());
					 if(t.getTypes().equals("")){
						 childrenTypesMap.put(t.getId(), "");
						 childrenTypesNameMap.put(t.getId(), "");
					 }else if(t.getTypes().equals("1")){
						 childrenTypesMap.put(t.getId(), areaTypeMap.get("house"));
						 childrenTypesNameMap.put(t.getId(), areaTypeNameMap.get("house"));
					 }else if(t.getTypes().equals("2")){
						 childrenTypesMap.put(t.getId(), areaTypeMap.get("store"));
						 childrenTypesNameMap.put(t.getId(), areaTypeNameMap.get("store"));
					 }else if(t.getTypes().equals("3")){
						 childrenTypesMap.put(t.getId(), areaTypeMap.get("parkspace"));
						 childrenTypesNameMap.put(t.getId(), areaTypeNameMap.get("parkspace"));
					 }else if(t.getTypes().equals("4")){
						 childrenTypesMap.put(t.getId(), areaTypeMap.get("pool"));
						 childrenTypesNameMap.put(t.getId(), areaTypeNameMap.get("pool"));
					 }else if(t.getTypes().equals("5")){
						 childrenTypesMap.put(t.getId(), areaTypeMap.get("publicbuild"));
						 childrenTypesNameMap.put(t.getId(), areaTypeNameMap.get("publicbuild"));
					 }
				 }
			 }
			 
			 Map<String, String> childrenFullNameMap = new HashMap<String, String>();
			 for (Map.Entry<String, String> en : childrenNameMap.entrySet()) { //遍历childrenParentMap，将对应id的fullname取到，并放入map
				 String id = en.getKey();
				 String fullName = "";
				 String _fullname = "";
				 while(true){
					 if(id == null){
						 break;
					 }else{
						 if(childrenNameMap.get(id) != null){
							 fullName += childrenNameMap.get(id)+",";							 
						 }
						 id = childrenParentMap.get(id);
					 }
				 }
				 String[] _fullName = fullName.split(",");
				 for (int i = _fullName.length - 1; i >= 0; i--){
					 _fullname += _fullName[i];
				 }
				 childrenFullNameMap.put(en.getKey(), _fullname);
		 	 }
			 
			 if(bsn != null){
				 childrenUUIDMap.put("root", bsn.getId());
			 }else{
				 childrenUUIDMap.put("root", uuId);				 
			 }
			 int count = 0,assetcount = 0;
			 for (Map.Entry<String, String> entry : childrenNameMap.entrySet()) {  
		            BuildingStructureNew bs=new BuildingStructureNew();  //建筑结构信息
		            bs.setId(childrenUUIDMap.get(entry.getKey()));
		            if(bsn != null){
		            	bs.setBuildingId(bsn.getBuildingId());
		            }else{
		            	bs.setBuildingId(uuid);  //建筑id		            	
		            }
		            bs.setNodeName(entry.getValue()); //节点名称
		            bs.setAreaId(childrenTypesMap.get(entry.getKey()));
		            bs.setBuildingType(childrenTypesNameMap.get(entry.getKey()));
		            bs.setParentId(childrenUUIDMap.get(childrenParentMap.get(entry.getKey())));//建筑的父id
		            bs.setProjectId(buildingnew.getProjectId());//项目id
		            bs.setFullName(buildingStructure.getFullName() + childrenFullNameMap.get(entry.getKey()));
		            bs.setIsBindingAssets((byte)0);
		            bs.setParcelId(buildingnew.getParcelId());//关联宗地id  王洲  2016.2.2
					buildingStructureNewMapper.insertBuildingStructureNewUUID(bs); //添加建筑结构信息	
					
					//添加入伙
					Intake intake = new Intake();
					intake.setIntakeId(UUID.randomUUID().toString());
					intake.setHouseId(bs.getId());
					//入伙状态
					if(isFinish.toString().equals("1")){
						intake.setIntakeState(1);
					}else{
						intake.setIntakeState(0);
					}
					intakeMapper.insertIntake(intake);
					
					//将对应的住宅、商铺、车位存到对应的集合中
					if(bs.getAreaId().equals(areaTypeMap.get("house"))){
						house = new HouseNew();
						house.setId(UUID.randomUUID().toString());
						house.setBuildingId(bs.getBuildingId());
						house.setBuildingStructureId(bs.getId());
						house.setProjectId(bs.getProjectId());
						house.setHouseAddress(bs.getFullName());
						//根据是否入伙状态保存参数
						if(isFinish.toString().equals("1")){
							house.setJoinState((byte) 1);
							house.setJoinGangState((byte) 1);
						}else{
							house.setJoinState((byte) 0);
							house.setJoinGangState((byte) 0);
						}
						house.setSipId(sipList.size() > count ? sipList.get(count).getSipId() : "");
						count ++;
						//增加第二个sipId存储  wangzhou 2016.05.03
						house.setIndoorSipId(sipList.size() > count ? sipList.get(count).getSipId() : "");
						count ++;
						house.setPassword("123456");
						houseList.add(house);
						houseNewMapper.insertHouseNew(house);
						
						AssetAccount assetAccount = new AssetAccount();
						assetAccount.setAssetAccountId(UUID.randomUUID().toString());
						assetAccount.setBuildingId(bs.getId());
						assetAccount.setFullName(bs.getFullName());
						assetAccount.setAssetAccountNum("house" + String.valueOf(assetNum + assetcount));
						assetAccount.setIsBankCard((byte)0);
						assetAccount.setProjectId(bs.getProjectId());
						assetAccount.setAssetAccountBalance((double)0);
						assetAccount.setAssetAccountType((byte)0);
						assetAccount.setTotalDeposits((double)0);
						assetAccount.setTotalRefundableDeposit((double)0);
						assetAccount.setGeneralBalance((double)0);
						assetAccountMapper.insertAssetAccount(assetAccount);
						assetcount++;
						
					}else if(bs.getAreaId().equals(areaTypeMap.get("parkspace"))){
						stall = new StallNew();
						stall.setStallId(UUID.randomUUID().toString());
						stall.setBuildingId(bs.getBuildingId());
						stall.setBuildingStructureId(bs.getId());
						stall.setProjectId(bs.getProjectId());
						//根据是否入伙状态保存参数
						if(isFinish.toString().equals("1")){
							stall.setRentState((byte) 1);
							stall.setIntakeState((byte) 1);
						}else{
							stall.setRentState((byte) 0);
							stall.setIntakeState((byte) 0);
						}
						stallNewMapper.insertStallNew(stall);
						
						AssetAccount assetAccount = new AssetAccount();
						assetAccount.setAssetAccountId(UUID.randomUUID().toString());
						assetAccount.setBuildingId(bs.getId());
						assetAccount.setFullName(bs.getFullName());
						assetAccount.setAssetAccountNum("stall" + String.valueOf(assetNum + assetcount));
						assetAccount.setIsBankCard((byte)0);
						assetAccount.setProjectId(bs.getProjectId());
						assetAccount.setAssetAccountBalance((double)0);
						assetAccount.setAssetAccountType((byte)2);
						assetAccount.setTotalDeposits((double)0);
						assetAccount.setTotalRefundableDeposit((double)0);
						assetAccount.setGeneralBalance((double)0);
						assetAccountMapper.insertAssetAccount(assetAccount);
						assetcount++;
						
					}else if(bs.getAreaId().equals(areaTypeMap.get("store"))){
						store = new StoreNew();
						store.setStoreId(UUID.randomUUID().toString());
						store.setBuildingId(bs.getBuildingId());
						store.setBuildingStructureId(bs.getId());
						store.setProjectId(bs.getProjectId());
						//根据是否入伙状态保存参数
						if(isFinish.toString().equals("1")){
							store.setIntakeState((byte) 1);
						}else{
							store.setIntakeState((byte) 0);
						}
						storeNewMapper.insert(store);
						
						AssetAccount assetAccount = new AssetAccount();
						assetAccount.setAssetAccountId(UUID.randomUUID().toString());
						assetAccount.setBuildingId(bs.getId());
						assetAccount.setFullName(bs.getFullName());
						assetAccount.setAssetAccountNum("store" + String.valueOf(assetNum + assetcount));
						assetAccount.setIsBankCard((byte)0);
						assetAccount.setProjectId(bs.getProjectId());
						assetAccount.setAssetAccountBalance((double)0);
						assetAccount.setAssetAccountType((byte)0);
						assetAccount.setTotalDeposits((double)0);
						assetAccount.setTotalRefundableDeposit((double)0);
						assetAccount.setGeneralBalance((double)0);
						assetAccountMapper.insertAssetAccount(assetAccount);
						assetcount++;
					}
					if(sipList.size() > houseList.size() * 2){
						for(int i = 0; i < houseList.size() * 2; i++){
							sipmanageMapper.updateStateBySipId(sipList.get(i).getSipId());				
						}			
					}else{
						for(int i = 0; i < sipList.size(); i++){
							sipmanageMapper.updateStateBySipId(sipList.get(i).getSipId());				
						}
					}
		        }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 	
	
		
	}

	/*
	  * <p>Title: getBuildingbyId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.BuildingNewService#getBuildingbyId(java.lang.String)
	  */
	
	
	@Override
	public BuildingNew getBuildingbyId(String id) {
		// TODO Auto-generated method stub
		
		return buildingNewMapper.BuildingAreaNewResultMap(id);
	}

	/*
	  * <p>Title: ListBuildingNew</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.BuildingNewService#ListBuildingNew()
	  */
	
	
	@Override
	public List<BuildingNew> ListBuildingNew() {
		// TODO Auto-generated method stub
		return buildingNewMapper.listAllBuildingNew();
	}

	/*
	  * <p>Title: ListBuildingNewByprojectId</p>
	  * <p>Description: </p>
	  * @param projectId
	  * @return
	  * @see com.flf.service.BuildingNewService#ListBuildingNewByprojectId(java.lang.String)
	  */
	
	
	@Override
	public List<BuildingNew> ListBuildingNewByprojectId(String projectId) {
		// TODO Auto-generated method stub
		return buildingNewMapper.ListBuildingNewByprojectId(projectId);
	}

	@Override
	public List<BuildingNew> ListBuildingNewprojectIdAll(String projectId) {
		// TODO Auto-generated method stub
		return buildingNewMapper.ListBuildingNewprojectIdAll(projectId);
	}

	/**
	 * @author zhuwei
	 * @date   2015-07-02
	 * @description 将建筑和结构封装成json
	 */
	public List<Tree> jsonBuildingNewprojectIdAll(String projectId){
		List<Tree> treeList = new ArrayList<Tree>();
		List<String> crStringList = new ArrayList<String>();
		List<BuildingStructureNew> bsList = buildingStructureNewMapper.ListBuildingStructureNewByProjectId(projectId);
		List<CassetRepository> crList = cassetRepositoryMapper.ListCassetRepositoryByProjectId(projectId);
		if(crList != null && crList.size() > 0){
		for(CassetRepository cr:crList){
			crStringList.add(cr.getBuildingStructureId());
		}
		}
		if(bsList != null && bsList.size() > 0){
		  for(BuildingStructureNew bsn : bsList){
			  if(!crStringList.contains(bsn.getId())){
				  Tree t1 = new Tree();
			      t1.setId(bsn.getId());
			      t1.setpId(bsn.getParentId());
			      t1.setName(bsn.getNodeName());
				  //t1.setChecked(true);	
			      treeList.add(t1);
			  }
		}
		}
		return treeList;
	}

	@Override
	public String jsonBuildingNewAll(String projectId) {
		StringBuffer sb = new StringBuffer();
		List<BuildingStructureNew> bsList = null;
		bsList = getBuildingStructureNewList(projectId);
		if(bsList != null && bsList.size() > 0){
			  for(BuildingStructureNew bsn : bsList){
				  sb.append("[{name:"+bsn.getFullName()+",");
				  sb.append("children[");
				  bsList = getBuildingStructureNewList(bsn.getId());
				  if(bsList.size() >0){
					  for(BuildingStructureNew b1 : bsList){
						  sb.append("{name:"+b1.getFullName()+",");
						  sb.append("children[");
						  bsList = getBuildingStructureNewList(b1.getId());
						  if(bsList.size() >0){
							  for(BuildingStructureNew b2 : bsList){
								  sb.append("{name:"+b2.getFullName()+",");
								  sb.append("children[");
								  bsList = getBuildingStructureNewList(b2.getId());
								  if(bsList.size() >0){
									  for(BuildingStructureNew b3 : bsList){
										  sb.append("{name:"+b3.getFullName()+",");
										  sb.append("children[{}],");
									  }
								  }
								  sb.append("]},");
							  }
						  }
						  sb.append("]},");
					  }
				 sb.append("]}]");
				  }
			  }
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public List<BuildingStructureNew> getBuildingStructureNewList(String parentId){
		return buildingStructureNewMapper.listBuildingStructureByParentId(parentId);
	}

	@Override
	public List<BuildingNew> listBuildingNewsByProjectIdAndRegionId(
			String projectId, String regionId) {
		// TODO Auto-generated method stub
		return buildingNewMapper.listBuildingNewsByProjectIdAndRegionId(projectId, regionId);
	}

	@Override
	public List<Tree> BuildingNewprojectIdAll(String projectId) {
		// TODO Auto-generated method stub
		List<Tree> treeList = new ArrayList<Tree>();
		//List<String> crStringList = new ArrayList<String>();
		List<BuildingStructureNew> bsList = buildingStructureNewMapper.ListBuildingStructureNewByProjectId(projectId);
		List<CassetRepository> crList = cassetRepositoryMapper.ListCassetRepositoryByProjectId(projectId);
		if(crList != null && crList.size() > 0){
		/*for(CassetRepository cr:crList){
			crStringList.add(cr.getBuildingStructureId());
		}*/
		}
		if(bsList != null && bsList.size() > 0){
		  for(BuildingStructureNew bsn : bsList){
			//  if(crStringList.contains(bsn.getId())){
				  Tree t1 = new Tree();
			      t1.setId(bsn.getId());
			      t1.setpId(bsn.getParentId());
			      t1.setName(bsn.getNodeName());
				  //t1.setChecked(true);	
			      treeList.add(t1);
			  }
		}
		//}
		return treeList;
	}
	
	
	

}
