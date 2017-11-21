package com.flf.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.Account;
import com.flf.entity.AccountRelation;
import com.flf.entity.Annex;
import com.flf.entity.ArchitectureNew;
import com.flf.entity.AreaNew;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.AssetAccount;
import com.flf.entity.BuildingComponent;
import com.flf.entity.BuildingNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.BuildingStructureSearch;
import com.flf.entity.ComponentStructure;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.HouseGate;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.Parcel;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.PooledNew;
import com.flf.entity.Sipmanage;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;
import com.flf.entity.WaterMeterProject;
import com.flf.entity.ZTree;
import com.flf.mapper.AccountMapper;
import com.flf.mapper.AccountRelationMapper;
import com.flf.mapper.ArchitectureNewMapper;
import com.flf.mapper.AreaNewMapper;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BuildingComponentMapper;
import com.flf.mapper.BuildingNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ComponentStructureMapper;
import com.flf.mapper.EnterpriseCustNewMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.MeterProjectMapper;
import com.flf.mapper.ParcelMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.PooledNewMapper;
import com.flf.mapper.ProductBsMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SipmanageMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.request.BuildingStructureAll;
import com.flf.request.BuildingStructureListAll;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.request.Tree;
import com.flf.request.TreeResult;
import com.flf.service.BuildingStructureNewService;
import com.flf.service.HouseGateService;
import com.flf.service.PersonBuildingNewService;
import com.flf.util.BinaryTree;
import com.flf.util.BuildingTreeUtils;
import com.flf.util.ClientUtil;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.JsonUtil;
import com.flf.util.MapUtils;
import com.flf.util.Node;
import com.flf.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BuildingStructureNewServiceImpl implements BuildingStructureNewService {

	private String gateUrl;

	@Autowired
	private PersonBuildingNewService personBuildingNewService;

	private BuildingStructureNewMapper buildingStructureNewMapper;

	private HouseNewMapper houseNewMapper;

	private StallNewMapper stallNewMapper;

	private StoreNewMapper storeNewMapper;

	private ArchitectureNewMapper architectureNewMapper;

	private PooledNewMapper pooledNewMapper;

	private AreaTypeNewMapper areaTypeNewMapper;

	private MeterProjectMapper meterProjectMapper;

	private ComponentStructureMapper componentStructureMapper;

	private BuildingComponentMapper buildingComponentMapper;

	private ParcelMapper parcelMapper;

	private BuildingNewMapper buildingNewMapper;

	private AreaNewMapper areaNewMapper;

	private SipmanageMapper sipmanageMapper;

	private PersonBuildingNewMapper personBuildingNewMapper;

	private PersonCustNewMapper personCustNewMapper;

	private EnterpriseCustNewMapper enterpriseCustNewMapper;
	
	private AssetAccountMapper assetAccountMapper;//资产账户mapper  王洲  2016.04.19
	
	private AccountMapper accountMapper;//个人账户mapper  王洲  2016.04.19
	
	private AccountRelationMapper accountRelationMapper;//个人账户、资产账户关联表  王洲  2016.04.19
	
	private ProjectMapper projectMapper;//项目列表
	
	private ProductBsMapper productBsMapper;//产品关系表
	
	public ProductBsMapper getProductBsMapper() {
		return productBsMapper;
	}

	public void setProductBsMapper(ProductBsMapper productBsMapper) {
		this.productBsMapper = productBsMapper;
	}

	public EnterpriseCustNewMapper getEnterpriseCustNewMapper() {
		return enterpriseCustNewMapper;
	}

	public void setEnterpriseCustNewMapper(EnterpriseCustNewMapper enterpriseCustNewMapper) {
		this.enterpriseCustNewMapper = enterpriseCustNewMapper;
	}

	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	public SipmanageMapper getSipmanageMapper() {
		return sipmanageMapper;
	}

	public void setSipmanageMapper(SipmanageMapper sipmanageMapper) {
		this.sipmanageMapper = sipmanageMapper;
	}

	public AreaNewMapper getAreaNewMapper() {
		return areaNewMapper;
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

	public ParcelMapper getParcelMapper() {
		return parcelMapper;
	}

	public void setParcelMapper(ParcelMapper parcelMapper) {
		this.parcelMapper = parcelMapper;
	}

	public BuildingComponentMapper getBuildingComponentMapper() {
		return buildingComponentMapper;
	}

	public void setBuildingComponentMapper(BuildingComponentMapper buildingComponentMapper) {
		this.buildingComponentMapper = buildingComponentMapper;
	}

	public ComponentStructureMapper getComponentStructureMapper() {
		return componentStructureMapper;
	}

	public void setComponentStructureMapper(ComponentStructureMapper componentStructureMapper) {
		this.componentStructureMapper = componentStructureMapper;
	}

	public MeterProjectMapper getMeterProjectMapper() {
		return meterProjectMapper;
	}

	public void setMeterProjectMapper(MeterProjectMapper meterProjectMapper) {
		this.meterProjectMapper = meterProjectMapper;
	}

	public PooledNewMapper getPooledNewMapper() {
		return pooledNewMapper;
	}

	public void setPooledNewMapper(PooledNewMapper pooledNewMapper) {
		this.pooledNewMapper = pooledNewMapper;
	}

	public ArchitectureNewMapper getArchitectureNewMapper() {
		return architectureNewMapper;
	}

	public void setArchitectureNewMapper(ArchitectureNewMapper architectureNewMapper) {
		this.architectureNewMapper = architectureNewMapper;
	}

	public StoreNewMapper getStoreNewMapper() {
		return storeNewMapper;
	}

	public void setStoreNewMapper(StoreNewMapper storeNewMapper) {
		this.storeNewMapper = storeNewMapper;
	}

	public StallNewMapper getStallNewMapper() {
		return stallNewMapper;
	}

	public void setStallNewMapper(StallNewMapper stallNewMapper) {
		this.stallNewMapper = stallNewMapper;
	}

	public HouseNewMapper getHouseNewMapper() {
		return houseNewMapper;
	}

	public void setHouseNewMapper(HouseNewMapper houseNewMapper) {
		this.houseNewMapper = houseNewMapper;
	}

	public String getGateUrl() {
		return gateUrl;
	}

	public void setGateUrl(String gateUrl) {
		this.gateUrl = gateUrl;
	}

	/*
	 * <p>Title: deleteBuildingStructureNew</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#deleteBuildingStructureNew(
	 * java.lang.String)
	 */

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public AssetAccountMapper getAssetAccountMapper() {
		return assetAccountMapper;
	}

	public void setAssetAccountMapper(AssetAccountMapper assetAccountMapper) {
		this.assetAccountMapper = assetAccountMapper;
	}

	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public AccountRelationMapper getAccountRelationMapper() {
		return accountRelationMapper;
	}

	public void setAccountRelationMapper(AccountRelationMapper accountRelationMapper) {
		this.accountRelationMapper = accountRelationMapper;
	}

	@Override
	public int deleteBuildingStructureNew(String id) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.deleteBuildingStructureNew(id);
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}
	/*
	 * <p>Title: insertBuildingStructureNew</p> <p>Description: </p>
	 * 
	 * @param buildingStructure
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#insertBuildingStructureNew(
	 * com.flf.entity.BuildingStructureNew)
	 */

	@Override
	public int insertBuildingStructureNew(BuildingStructureNew buildingStructure) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.insertBuildingStructureNew(buildingStructure);
	}

	/*
	 * <p>Title: listPageBuildingStructureNew</p> <p>Description: </p>
	 * 
	 * @param buildingStructure
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#listPageBuildingStructureNew(
	 * com.flf.entity.BuildingStructureNew)
	 */

	@Override
	public List<BuildingStructureNew> listPageBuildingStructureNew(BuildingStructureNew buildingStructure) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.listPageBuildingStructureNew(buildingStructure);
	}

	/*
	 * <p>Title: listAllBuildingStructureNew</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#listAllBuildingStructureNew()
	 */

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureNew(String projectId) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.listAllBuildingStructureNew(projectId);
	}

	/*
	 * <p>Title: getBuildingStructureNewbyId</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#getBuildingStructureNewbyId(
	 * java.lang.String)
	 */

	@Override
	public BuildingStructureNew getBuildingStructureNewbyId(String id) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.getBuildingStructureNewbyId(id);
	}

	/*
	 * <p>Title: updateBuildingStructureNew</p> <p>Description: </p>
	 * 
	 * @param buildingStructure
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#updateBuildingStructureNew(
	 * com.flf.entity.BuildingStructureNew)
	 */

	@Override
	public int updateBuildingStructureNew(BuildingStructureNew buildingStructure) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.updateBuildingStructureNew(buildingStructure);
	}

	/*
	 * <p>Title: deleteBuildingStructureNewCxf</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#deleteBuildingStructureNewCxf
	 * (java.lang.String)
	 */

	@Override
	public String deleteBuildingStructureNewCxf(String id) {
		// TODO Auto-generated method stub
		if (buildingStructureNewMapper.deleteBuildingStructureNew(id) > 0) {
			return JsonUtil.success("success", false);
		}
		return JsonUtil.failure("failure", false);
	}

	/*
	 * <p>Title: insertBuildingStructureNewCXF</p> <p>Description: </p>
	 * 
	 * @param buildingStructure
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#insertBuildingStructureNewCXF
	 * (java.lang.String)
	 */

	@Override
	public String insertBuildingStructureNewCXF(String buildingStructure) {
		// TODO Auto-generated method stub
		BuildingStructureNew obj = (BuildingStructureNew) JSONObject.toBean(JSONObject.fromObject(buildingStructure),
				BuildingStructureNew.class);
		if (buildingStructureNewMapper.insertBuildingStructureNew(obj) > 0) {
			return JsonUtil.success("success", false);
		}
		return JsonUtil.failure("failure", false);
	}

	/*
	 * <p>Title: listAllBuildingStructureNewCxf</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * listAllBuildingStructureNewCxf()
	 */

	@Override
	public String listAllBuildingStructureNewCxf(String projectid) {
		// TODO Auto-generated method stub
		List<BuildingStructureNew> buildingStructures = buildingStructureNewMapper
				.listAllBuildingStructureNew(projectid);
		JSONArray json = JSONArray.fromObject(buildingStructures);
		return JsonUtil.success(json, true);
	}

	/*
	 * <p>Title: getBuildingStructureNewbyIdCxf</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * getBuildingStructureNewbyIdCxf(java.lang.String)
	 */

	@Override
	public String getBuildingStructureNewByIdCxf(String id) {
		// TODO Auto-generated method stub
		BuildingStructureNew buildingStructure = buildingStructureNewMapper.getBuildingStructureNewbyId(id);
		JSONObject json = JSONObject.fromObject(buildingStructure);
		return JsonUtil.success(json, true);
	}

	/*
	 * <p>Title: updateBuildingStructureNewCxf</p> <p>Description: </p>
	 * 
	 * @param buildingStructure
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#updateBuildingStructureNewCxf
	 * (java.lang.String)
	 */

	@Override
	public String updateBuildingStructureNewCxf(String buildingStructure) {
		// TODO Auto-generated method stub
		BuildingStructureNew obj = (BuildingStructureNew) JSONObject.toBean(JSONObject.fromObject(buildingStructure),
				BuildingStructureNew.class);
		if (buildingStructureNewMapper.updateBuildingStructureNew(obj) > 0) {
			return JsonUtil.success("success", false);
		}
		return JsonUtil.failure("failure", false);
	}

	/*
	 * <p>Title: getAllHouseTree</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.flf.service.BuildingStructureNewService#getAllHouseTree()
	 */

	@Override
	public List<Tree> getTree(String gateAccountId) {
		// TODO Auto-generated method stub
		List<Tree> allTree = buildingStructureNewMapper.listAllBuildingStructureNewTree();
		if (gateAccountId != null && !"".equals(gateAccountId)) {
			JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(gateUrl + "/HouseGateService",
					HouseGateService.class);
			HouseGateService welcome = (HouseGateService) factory.create();
			String houseGatesJSON = welcome.listHouseGateBygateAccountId(gateAccountId);
			JSONArray json = JSONArray.fromObject(houseGatesJSON);
			List<HouseGate> houseGates = (List<HouseGate>) JSONArray.toCollection(json, HouseGate.class);
			List<Tree> gateAccountTree = buildingStructureNewMapper.listBuildingStructureNewTreeByHouses(houseGates);
			for (Tree alltree : allTree) {
				for (Tree gateAccounttree : gateAccountTree) {
					if (alltree.getId().equals(gateAccounttree.getpId())) {
						alltree.setChecked(true);
						for (Tree tree : allTree) {
							if (alltree.getpId().equals(tree.getId())) {
								alltree.setOpen(true);
							}
						}
					}
				}
			}
		}
		return allTree;
	}

	@Override
	public List<Tree> getTreeHouseId(String gateAccountId) {
		List<Tree> allTree = buildingStructureNewMapper.listAllBuildingStructureNewTree();
		return allTree;
	}

	/*
	 * <p>Title: listAllBuildingStructureNewRest</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * listAllBuildingStructureNewRest()
	 */

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureNewRest(String projectId) {
		List<BuildingStructureNew> list = buildingStructureNewMapper.getBuildingStructureNewbyProjectId(projectId);
		long e = System.currentTimeMillis();
		return list;
	}

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureTreeNewRest(String projectId) {
		List<BuildingStructureNew> list = buildingStructureNewMapper.getBuildingStructureTreeNewbyProjectId(projectId);
		long e = System.currentTimeMillis();
		return list;
	}

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureTreeNew1Rest(String projectId, String parentId) {
		List<BuildingStructureNew> list = null;
		if (projectId.equals(parentId)) {
			parentId = null;
			list = buildingStructureNewMapper.getBuildingStructureNewbyProjectIdAndParentId1(projectId, parentId);
		} else {
			list = buildingStructureNewMapper.getBuildingStructureNewbyProjectIdAndParentId(projectId, parentId);
		}
		List<BuildingStructureNew> nodeList = null;
		for(BuildingStructureNew bsn : list){
			nodeList = new ArrayList<BuildingStructureNew>();
			nodeList = buildingStructureNewMapper.listAllBuildingStructureByParentId(bsn.getId());
			if(nodeList != null && nodeList.size() > 0){
				bsn.setChecked(true);
			}else{
				bsn.setChecked(false);
			}
		}
		return list;
	}

	@Override
	public void addBuildingStructureNew(String ids, String names, String pIds, String isParents) {
		// TODO Auto-generated method stub
		String id[] = ids.split(",");
		String name[] = names.split(",");
		String pId[] = pIds.split(",");
		String isParent[] = isParents.split(",");
		List<ZTree> ztrees = new ArrayList<ZTree>();
		for (int i = 0; i < pId.length; i++) {
			ZTree ztree = new ZTree();
			ztree.setId(id[i]);
			ztree.setName(name[i]);
			ztree.setpId(pId[i]);
			ztree.setIsParent(isParent[i]);
			ztrees.add(ztree);
		}
		for (int i = 1; i < ztrees.size(); i++) {
			if (ztrees.get(0).getId().equals(ztrees.get(i).getpId())) {

				ztrees.get(i).setFullName(ztrees.get(i).getName());
			} else {
				String pIdName = null;
				for (ZTree zTree : ztrees) {
					if (ztrees.get(i).getpId().equals(zTree.getId())) {
						pIdName = zTree.getFullName(); // 上级节点名称
					}
				}

				ztrees.get(i).setFullName(pIdName + ztrees.get(i).getName());
			}

		}

		for (int i = 1; i < ztrees.size(); i++) {
			BuildingStructureNew bildings = new BuildingStructureNew();
			bildings.setId(ztrees.get(i).getId());
			bildings.setFullName(ztrees.get(i).getFullName());
			bildings.setParentId(ztrees.get(i).getpId());
			bildings.setNodeName(ztrees.get(i).getName());
			buildingStructureNewMapper.NewinsertBuildingStructure(bildings); // 插入建筑结构信息
			if (ztrees.get(i).getIsParent().equals("false")) {
				HouseNew house = new HouseNew();
				house.setBuildingStructureId(ztrees.get(i).getId()); // 建筑结构id
				house.setHouseNum(ztrees.get(i).getName()); // 房号
				houseNewMapper.insertHouseNew(house);
			}
		}

		/*
		 * for (ZTree zTree : ztrees) {
		 * System.out.println(zTree.getName()+"\t"+zTree.getFullName()+"\t"+
		 * zTree.getId()+"\t"+zTree.getpId()+"\n"); }
		 */

	}

	@Override
	public String listBuildingStructureNewByhouseGates(String houseGates) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * <p>Title: addBuildingStructureNewRestful</p> <p>Description: </p>
	 * 
	 * @param treeResult
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * addBuildingStructureNewRestful(com.flf.request.TreeResult)
	 */

	@Override
	public void addBuildingStructureNewRestful(TreeResult treeResult) {
		// TODO Auto-generated method stub
		List<BuildingStructureNew> buildingStructureNews = treeResult.getBuildingStructureNews();
		for (BuildingStructureNew buildingStructureNew : buildingStructureNews) {
			buildingStructureNewMapper.insertBuildingStructureNew(buildingStructureNew); // 添加建筑结构信息
		}

	}

	/*
	 * <p>Title: addBuildingStructureAllNewRestful</p> <p>Description: </p>
	 * 
	 * @param treeResult
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * addBuildingStructureAllNewRestful(com.flf.request.TreeResult)
	 */

	@Override
	public void addBuildingStructureAllNewRestful(TreeResult treeResult) {
		List<BuildingStructureAll> buildingStructureAlls = treeResult.getBuildingStructureAll();
		for (BuildingStructureAll buildingStructureAll : buildingStructureAlls) {

			BuildingStructureNew buildingStructureNew = buildingStructureAll.getBuildingStructureNew(); // 获取建筑结构对象信息
			buildingStructureNewMapper.insertBuildingStructureNew(buildingStructureNew); // 添加建筑结构关系表
			if (buildingStructureAll.getHouseNew() != null) {
				HouseNew houseNew = buildingStructureAll.getHouseNew(); // 获取住宅信息
				houseNew.setBuildingStructureId(buildingStructureNew.getId()); // 设置建筑结构id
				houseNew.setBuildingId(buildingStructureNew.getBuildingId()); // 设置建筑id
				houseNewMapper.insertHouseNew(houseNew);// 添加住宅信息
			}
			if (buildingStructureAll.getStallNew() != null) {
				StallNew stallNew = buildingStructureAll.getStallNew(); // 获取车库信息
				stallNew.setBuildingStructureId(buildingStructureNew.getId()); // 设置建筑结构id
				stallNew.setBuildingId(buildingStructureNew.getBuildingId()); // 设置建筑id
				stallNewMapper.insertStallNew(stallNew);// 添加车库信息
			}
			if (buildingStructureAll.getStoreNew() != null) {
				StoreNew storeNew = buildingStructureAll.getStoreNew(); // 获取商铺信息
				storeNew.setBuildingStructureId(buildingStructureNew.getId()); // 设置建筑结构id
				storeNew.setBuildingId(buildingStructureNew.getBuildingId()); // 设置建筑id
				storeNewMapper.insert(storeNew);// 添加商铺信息
			}
			if (buildingStructureAll.getArchitectureNew() != null) {
				ArchitectureNew architectureNew = buildingStructureAll.getArchitectureNew(); // 获取公建信息
				architectureNew.setBuildingStructureId(buildingStructureNew.getId()); // 设置建筑结构id
				architectureNew.setBuildingId(buildingStructureNew.getBuildingId()); // 设置建筑id
				architectureNewMapper.insertArchitectureNew(architectureNew);// 添加公建信息
			}
			if (buildingStructureAll.getPooledNew() != null) {
				PooledNew pooledNew = buildingStructureAll.getPooledNew(); // 获取公摊信息
				pooledNew.setBuildingStructureId(buildingStructureNew.getId()); // 设置建筑结构id
				pooledNew.setBuildingId(buildingStructureNew.getBuildingId()); // 设置建筑id
				pooledNewMapper.insertPooledNew(pooledNew);// 添加公摊信息
			}

		}

	}

	/*
	 * <p>Title: updateBuildingStructure</p> <p>Description: </p>
	 * 
	 * @param buildingStructureNew
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#updateBuildingStructure(com.
	 * flf.entity.BuildingStructureNew)
	 */

	@Override
	public void updateBuildingStructure(BuildingStructureNew buildingStructureNew) {
		buildingStructureNewMapper.updateBuildingStructureNew(buildingStructureNew);

	}

	/*
	 * <p>Title: getBuildingStructureNewByCustId</p> <p>Description: </p>
	 * 
	 * @param CustId
	 * 
	 * @return
	 * 
	 * @see com.flf.service.BuildingStructureNewService#
	 * getBuildingStructureNewByCustId(java.lang.String)
	 */

	@Override
	public List<BuildingStructureNew> getBuildingStructureNewByCustId(String CustId) {
		// TODO Auto-generated method stub

		return buildingStructureNewMapper.getBuildingStructureNewByCustId(CustId);
	}

	/*
	 * <p>Title: getBrandbyparentId</p> <p>Description: </p>
	 * 
	 * @param parentId
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#getBrandbyparentId(java.lang.
	 * String)
	 */

	@Override
	public List<BuildingStructureNew> getBrandbyparentId(String parentId) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.getBuildingStructureNewByparentId(parentId);
	}

	/*
	 * <p>Title: listBuildingStructureAll</p> <p>Description: </p>
	 * 
	 * @param parentId
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.BuildingStructureNewService#listBuildingStructureAll(java
	 * .lang.String)
	 */

	@Override
	public BuildingStructureListAll listBuildingStructureAll(String parentId) {
		// TODO Auto-generated method stub
		BuildingStructureListAll bs = new BuildingStructureListAll();
		List<BuildingStructureNew> buildingStructureNew = buildingStructureNewMapper
				.getBuildingStructureNewByparentId(parentId); // 获取节点的子节点信息
		List<HouseNew> houseNews = new ArrayList<HouseNew>();
		List<StallNew> stallNews = new ArrayList<StallNew>();
		List<StoreNew> storeNews = new ArrayList<StoreNew>();
		List<ArchitectureNew> architectureNews = new ArrayList<ArchitectureNew>();
		List<PooledNew> pooledNews = new ArrayList<PooledNew>();

		for (BuildingStructureNew bsNew : buildingStructureNew) {
			System.err.println(bsNew.getBuildingType());
			if (bsNew.getBuildingType() != null) {
				if (bsNew.getBuildingType().equals("住宅")) {
					HouseNew houseNew = houseNewMapper.listHouseByBuildingStructureId(bsNew.getId()); // 根据建筑结构id查询住宅信息集合
					houseNews.add(houseNew);
				}
				if (bsNew.getBuildingType().equals("车位")) {
					StallNew stallNew = stallNewMapper.listStallByBuildingStructureId(bsNew.getId());// 根据建筑结构id查询车位信息集合
					stallNews.add(stallNew);
				}
				if (bsNew.getBuildingType().equals("商业")) {
					StoreNew storeNew = storeNewMapper.listStoreByBuildingStructureId(bsNew.getId());// 根据建筑结构id查询商铺信息集合
					storeNews.add(storeNew);
				}
				if (bsNew.getBuildingType().equals("公建")) {
					ArchitectureNew architectureNew = architectureNewMapper
							.listArchitectureByBuildingStructureId(bsNew.getId());// 根据建筑结构id查询公建信息集合
					architectureNews.add(architectureNew);

				}
				if (bsNew.getBuildingType().equals("公摊")) {
					PooledNew pooledNew = pooledNewMapper.listPooledByBuildingStructureId(bsNew.getId());// 根据建筑结构id查询公摊信息集合
					pooledNews.add(pooledNew);
				}

			}

		}
		bs.setBuildingStructureNews(buildingStructureNew);
		bs.setHouseNews(houseNews);
		bs.setStallNews(stallNews);
		bs.setStoreNews(storeNews);
		bs.setArchitectureNews(architectureNews);
		bs.setPooledNews(pooledNews);

		return bs;
	}

	@Override
	public List<BuildingStructureNew> getBuildingStructureNewByfullName(String fullName) {
		// TODO Auto-generated method stub
		return buildingStructureNewMapper.getBuildingStructureNewByfullName(fullName);
	}

	@Override
	public List<BuildingStructureNew> getBuildingStructureNewByProjectId(String ProjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureNewByAll() {
		// TODO Auto-generated method stub
		List<BuildingStructureNew> bsList = buildingStructureNewMapper.listAllBuildingStructureNewByAll();
		return bsList;
	}

	@Override
	public List<BuildingStructureNew> listBuildingStructureNewByProjectId(String buildingId) {
		return buildingStructureNewMapper.ListBuildingStructureNewByBuildingId(buildingId);
	}

	@Override
	public List<BuildingStructureNew> listBuildingStructureByProjectIdAndAreaId(
			BuildingStructureNew buildingStructureNew) {
		List<BuildingStructureNew> bsnList = new ArrayList<BuildingStructureNew>();
		List<BuildingStructureNew> _bsnList = new ArrayList<BuildingStructureNew>();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		// 查询所有的建筑面积类型
		List<AreaTypeNew> atnList = areaTypeNewMapper.listAllAreaTypeNew();
		if (atnList != null && atnList.size() > 0) {
			for (AreaTypeNew atn : atnList) {
				// 将建筑面积类型的名称和uuid存储入map集合，以便后面根据面积类型检索
				areaTypeMap.put(atn.getAreaTypeCode(), atn.getId());
			}
		}
		// 判断前端需要查询的建筑面积类型
		/*
		 * BuildingStructureNew bsn = new BuildingStructureNew();
		 * if(!buildingStructureNew.getBuildingId().equals("") &&
		 * !buildingStructureNew.getBuildingId().equals(null)){ bsn =
		 * buildingStructureNewMapper.getBuildingStructureNewbyId(
		 * buildingStructureNew.getBuildingId()); }
		 * bsn.setProjectId(buildingStructureNew.getProjectId());
		 */
		switch (buildingStructureNew.getAreaId()) {
		case "0":
			buildingStructureNew.setAreaId(areaTypeMap.get("house"));
			// 查询建筑结构中对应项目下属性为住宅的数据
			bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(buildingStructureNew);
			// 根据项目id查询houseNew中对应的数据
			List<HouseNew> hnList = houseNewMapper.listHouseNewByProjectId(buildingStructureNew.getProjectId());
			// 筛选出在houseNew中没有数据的BuildingStructure数据
			for (BuildingStructureNew buildingStructureNews : bsnList) {
				int i = 0;
				for (HouseNew hn : hnList) {
					if (!buildingStructureNews.getId().toString().equals(hn.getBuildingStructureId().toString())) {
						i++;
					}
				}
				if (i == hnList.size()) {
					_bsnList.add(buildingStructureNews);
				}
			}
			break;
		case "1":
			buildingStructureNew.setAreaId(areaTypeMap.get("store"));
			// 查询建筑结构中对应项目下属性为商铺的数据
			bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(buildingStructureNew);
			// 根据项目id查询store中对应的数据
			List<StoreNew> sn = storeNewMapper.listStoreByProjectId(buildingStructureNew.getProjectId());
			// 筛选出storeNew中没有数据的buildingstructure数据
			for (BuildingStructureNew buildingStructureNews : bsnList) {
				int i = 0;
				for (StoreNew storeNew : sn) {
					if (!buildingStructureNews.getId().toString()
							.equals(storeNew.getBuildingStructureId().toString())) {
						i++;
					}
				}
				if (i == sn.size()) {
					_bsnList.add(buildingStructureNews);
				}
			}
			break;
		case "2":
			buildingStructureNew.setAreaId(areaTypeMap.get("parkspace"));
			// 查询建筑结构中对应项目下属性为车位的数据
			bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(buildingStructureNew);
			// 根据项目id查询stall中对应的数据
			List<StallNew> stallList = stallNewMapper.listStallByProjectId(buildingStructureNew.getProjectId());
			// 筛选出stalllist中没有数据的buildingstructure数据
			for (BuildingStructureNew buildingStructureNews : bsnList) {
				int i = 0;
				for (StallNew stallNew : stallList) {
					if (!buildingStructureNews.getId().toString()
							.equals(stallNew.getBuildingStructureId().toString())) {
						i++;
					}
				}
				if (i == stallList.size()) {
					_bsnList.add(buildingStructureNews);
				}
			}
			break;
		}

		return _bsnList;
	}

	@Override
	public BuildingStructureNew listAllBuildingStructureNewByProjectIdAndAreaId(
			BuildingStructureNew buildingStructureNew) {
		BuildingStructureNew bsn = new BuildingStructureNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		List<AreaTypeNew> atnList = areaTypeNewMapper.listAllAreaTypeNew();
		if (atnList != null && atnList.size() > 0) {
			for (AreaTypeNew atn : atnList) {
				// 将建筑面积类型的名称和uuid存储入map集合，以便后面根据面积类型检索
				areaTypeMap.put(atn.getAreaTypeCode(), atn.getId());
			}
		}
		switch (buildingStructureNew.getAreaId()) {
		case "0":
			buildingStructureNew.setAreaId(areaTypeMap.get("house"));

			// 根据项目id查询houseNew中对应的数据
			List<HouseNew> hnList = houseNewMapper.listHouseNewByProjectId(buildingStructureNew.getProjectId());
			bsn.setHouseList(hnList);
			break;
		case "1":
			buildingStructureNew.setAreaId(areaTypeMap.get("store"));
			// 根据项目id查询store中对应的数据
			List<StoreNew> sn = storeNewMapper.listStoreByProjectId(buildingStructureNew.getProjectId());
			bsn.setStoreList(sn);
			break;
		case "2":
			buildingStructureNew.setAreaId(areaTypeMap.get("parkspace"));

			// 根据项目id查询stall中对应的数据
			List<StallNew> stallList = stallNewMapper.listStallByProjectId(buildingStructureNew.getProjectId());
			bsn.setStallList(stallList);
			break;
		}
		return bsn;
	}

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureNewByAllId(String meterReadingProgramId) {
		// TODO Auto-generated method stub
		if (meterReadingProgramId != null && !meterReadingProgramId.equals("null")) {
			List<BuildingStructureNew> buildingStructureNew = buildingStructureNewMapper
					.listAllBuildingStructureNewByAll();
			List<WaterMeterProject> waterMeterProject = meterProjectMapper
					.listWaterMeterProjectbyId(meterReadingProgramId);
			for (WaterMeterProject waterMeterProjects : waterMeterProject) {
				for (BuildingStructureNew buildingStructureNews : buildingStructureNew) {
					String a = waterMeterProjects.getBuildingStructureId();
					String b = buildingStructureNews.getId();
					if (a.equals(b)) {
						buildingStructureNews.setChecked(true);
					}
				}
			}
			return buildingStructureNew;
		} else {
			List<BuildingStructureNew> bsList = buildingStructureNewMapper.listAllBuildingStructureNewByAll();
			return bsList;
		}
	}

	@Override
	public List<BuildingStructureNew> listAllBuildingStructureNewByAllOptimize(String meterReadingProgramId) {
		// TODO Auto-generated method stub
		if (meterReadingProgramId != null && !meterReadingProgramId.equals("null")) {
			List<BuildingStructureNew> buildingStructureNew = buildingStructureNewMapper
					.listAllBuildingStructureNewByAllOptimize();
			List<WaterMeterProject> waterMeterProject = meterProjectMapper
					.listWaterMeterProjectbyId(meterReadingProgramId);
			for (WaterMeterProject waterMeterProjects : waterMeterProject) {
				for (BuildingStructureNew buildingStructureNews : buildingStructureNew) {
					String a = waterMeterProjects.getBuildingStructureId();
					String b = buildingStructureNews.getId();
					if (a.equals(b)) {
						buildingStructureNews.setChecked(true);
					}
				}
			}
			return buildingStructureNew;
		} else {
			List<BuildingStructureNew> bsList = buildingStructureNewMapper.listAllBuildingStructureNewByAll();
			return bsList;
		}
	}

	@Override
	public List<Node> listAllBuildingStructureNewByPar(String projectId) {
		// TODO Auto-generated method stub
		// 存放父级节点id
		List dataList = new ArrayList();
		// 查询所有建筑结构

		List<BuildingStructureNew> ListBS = buildingStructureNewMapper.listAllBuildingStructureNew(projectId);
		for (BuildingStructureNew buildingStructureNew : ListBS) {
			StringBuffer a = new StringBuffer();
			StringBuffer b = new StringBuffer();
			StringBuffer c = new StringBuffer();
			if (buildingStructureNew.getPersonCusts() != null) {
				for (int i = 0; i < buildingStructureNew.getPersonCusts().size(); i++) {
					/*
					 * a.append("["); b.append("["); c.append("[");
					 */
					if (i > 0) {
						a.append(",");
						b.append(",");
						c.append(",");
					}
					if (buildingStructureNew.getPersonCusts().get(i).getCardType() != null) {
						if (buildingStructureNew.getPersonCusts().get(i).getCardType() != ""
								&& buildingStructureNew.getPersonCusts().get(i).getCardType().equals("1")) {
							buildingStructureNew.getPersonCusts().get(i).setCardType("身份证");
						}
						a.append(buildingStructureNew.getPersonCusts().get(i).getName());
						b.append(buildingStructureNew.getPersonCusts().get(i).getCardType());
						c.append(buildingStructureNew.getPersonCusts().get(i).getCardNum());
					}

				}
				/*
				 * a.append("]"); b.append("]"); c.append("]");
				 */
			}
			HashMap dataRecord = new HashMap();
			dataRecord.put("fullName", buildingStructureNew.getFullName());
			dataRecord.put("id", buildingStructureNew.getId());
			dataRecord.put("nodeName", buildingStructureNew.getNodeName());
			dataRecord.put("parentId", buildingStructureNew.getParentId());
			dataRecord.put("names", a.toString());
			dataRecord.put("cardTypes", b.toString());
			dataRecord.put("cardNums", c.toString());
			dataList.add(dataRecord);
		}
		List<Node> data = BinaryTree.BinaryTree(dataList);

		return data;
	}

	@Override
	public Node listAllBuildingStructureNewone() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 资产报表查询 yinlei
	 */
	@Override
	public List<Node> listBuildingStructureSearch(BuildingStructureSearch buildingStructureSearch) {
		// TODO Auto-generated method stub
		// 存放父级节点id
		List dataList = new ArrayList();
		// if(buildingStructureSearch.getName()==null ||
		// buildingStructureSearch.getName().equals("")&&(buildingStructureSearch.getEnterpriseName()==null
		// || buildingStructureSearch.getEnterpriseName().equals(""))){
		// 查询所有建筑结构
		// 当用户姓名和企业名称都为空的时候执行查询操作
		// List<BuildingStructureNew>ListBS_father=buildingStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
		List<BuildingStructureNew> ListBS = new ArrayList<BuildingStructureNew>();
		List<BuildingStructureNew> ListBS_repeat = new ArrayList<BuildingStructureNew>();
		if (buildingStructureSearch.getIsBindingAssets() == 2) {
			if ("".equals(buildingStructureSearch.getEnterpriseName())
					&& "".equals(buildingStructureSearch.getName())) {
				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
				for (int i = 0; i < ListBS.size(); i++) {
					if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
						ListBS_repeat.add(ListBS.get(i));
					}
				}
				ListBS = ListBS_repeat;
				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew building : ListBS) {
					BuildingStructureNew build = building;
					while (build.getParentId() != null && build.getParentId().equals(build.getProjectId()) == false) {
						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
						ListBSadd.add(build);
					}
				}
				for (BuildingStructureNew building : ListBSadd) {
					ListBS.add(building);
				}
			} else {
				buildingStructureSearch.setCustType("业主");
				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew building : ListBS) {
					BuildingStructureNew build = building;
					while (build != null && build.getParentId() != null
							&& build.getParentId().equals(build.getProjectId()) == false) {
						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
						ListBSadd.add(build);
					}
				}
				for (BuildingStructureNew building : ListBSadd) {
					ListBS.add(building);
				}
			}
		} else {
			if (buildingStructureSearch.getIsBindingAssets() == 0) {
				if ("".equals(buildingStructureSearch.getEnterpriseName())
						&& "".equals(buildingStructureSearch.getName())) {
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					for (int i = 0; i < ListBS.size(); i++) {
						if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
							if (ListBS.get(i) != null) {
								ListBS_repeat.add(ListBS.get(i));
							}
						}
					}
					ListBS = ListBS_repeat;
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build != null && build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							if (build != null) {
								ListBSadd.add(build);
							}
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				} else {
					buildingStructureSearch.setCustType("业主");
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				}
			}
			if (buildingStructureSearch.getIsBindingAssets() == 1) {

				if ("".equals(buildingStructureSearch.getEnterpriseName())
						&& "".equals(buildingStructureSearch.getName())) {
					// List<BuildingStructureNew>ListBS_father=buildingStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					// for(BuildingStructureNew building:ListBS_father){
					// ListBS.add(building);
					// }
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				} else {
					buildingStructureSearch.setCustType("业主");
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				}
			}
		}
		// }

		for (BuildingStructureNew buildingStructureNew : ListBS) {
			StringBuffer a = new StringBuffer();
			StringBuffer b = new StringBuffer();
			StringBuffer c = new StringBuffer();
			int count_cust = 0;
			int count_enter = 0;
			List<PersonCustNew> personCusts = buildingStructureNew.getPersonCusts();
			List<EnterpriseCustNew> enterpriseCusts = buildingStructureNew.getEnterpriseCustNews();
			List<PersonCustNew> personCusts_new = new ArrayList<PersonCustNew>();
			List<EnterpriseCustNew> enterpriseCusts_new = new ArrayList<EnterpriseCustNew>();
			for (PersonCustNew ersonCust_repeat : personCusts) {
				if (ersonCust_repeat != null) {
					count_cust++;
					personCusts_new.add(ersonCust_repeat);
				}
			}
			for (EnterpriseCustNew enterprise_repeat : enterpriseCusts) {
				if (enterprise_repeat != null) {
					count_enter++;
					enterpriseCusts_new.add(enterprise_repeat);
				}
			}
			if (count_enter + count_cust > 0) {
				// 遍历人员信息 拼接所有业主姓名，证件号
				int k = 0;
				if (count_cust > 0 && count_enter > 0) {
					int e = 0;
					e = count_cust;
					PersonCustNew person_test = personCusts_new.get(0);
					String card = person_test.getCardNum();
				}
				if (count_cust > 0) {
					for (int m = 0; m < count_cust; m++) {
						if (k > 0) {
							a.append(",");
							b.append(",");
							c.append(",");
						}
						if (personCusts_new.get(m).getCardType() != null) {
							if (personCusts_new.get(m).getCardType() != ""
									&& personCusts_new.get(m).getCardType().equals("1")) {
								personCusts_new.get(m).setCardType("身份证");
							}
							if (personCusts_new.get(m).getCardType() != ""
									&& personCusts_new.get(m).getCardType().equals("2")) {
								personCusts_new.get(m).setCardType("护照");
							}
							a.append(personCusts_new.get(m).getName());
							b.append(personCusts_new.get(m).getCardType());
							c.append(personCusts_new.get(m).getCardNum());
						}
						k++;
					}
				}
				if (count_enter > 0) {
					for (int n = 0; n < count_enter; n++) {
						if (k > 0) {
							a.append(",");
							b.append(",");
							c.append(",");
						}
						a.append(enterpriseCusts_new.get(n).getEnterpriseName());
						b.append("");
						c.append("");
						k++;
					}
				}
				HashMap dataRecord = new HashMap();
				dataRecord.put("fullName", buildingStructureNew.getFullName());
				dataRecord.put("id", buildingStructureNew.getId());
				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
				dataRecord.put("parentId", buildingStructureNew.getParentId());
				dataRecord.put("names", a.toString());
				dataRecord.put("cardTypes", b.toString());
				dataRecord.put("cardNums", c.toString());
				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
				dataRecord.put("projectId", buildingStructureNew.getProjectId());
				if (buildingStructureNew.getHouse() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
					if (buildingStructureNew.getHouse().getHouseArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStall() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
					if (buildingStructureNew.getStall().getUsableArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStore() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
					if (buildingStructureNew.getStore().getBuildingArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
					dataRecord.put("isParent", "true");
				} else {
					dataRecord.put("isParent", "false");
				}
				dataList.add(dataRecord);
			} else {
				for (int i = 0; i < buildingStructureNew.getPersonCusts().size(); i++) {
					if (i > 0) {
						a.append(",");
						b.append(",");
						c.append(",");
					}
				}
				HashMap dataRecord = new HashMap();
				dataRecord.put("fullName", buildingStructureNew.getFullName());
				dataRecord.put("id", buildingStructureNew.getId());
				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
				dataRecord.put("parentId", buildingStructureNew.getParentId());
				dataRecord.put("names", a.toString());
				dataRecord.put("cardTypes", b.toString());
				dataRecord.put("cardNums", c.toString());
				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
				dataRecord.put("projectId", buildingStructureNew.getProjectId());
				if (buildingStructureNew.getHouse() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
					if (buildingStructureNew.getHouse().getHouseArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStall() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
					if (buildingStructureNew.getStall().getUsableArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStore() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
					if (buildingStructureNew.getStore().getBuildingArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
					dataRecord.put("isParent", "true");
				} else {
					dataRecord.put("isParent", "false");
				}
				dataList.add(dataRecord);
			}
		}
		List<Node> data = BinaryTree.BinaryTree(dataList);
		return data;

	}

	/*
	 * List<BuildingStructureNew>
	 * getBuildingStructureNode(BuildingStructureSearch
	 * buildingStructureSearch){ List<BuildingStructureNew> buildings=new
	 * ArrayList<BuildingStructureNew>(); return buildings; }
	 */

	@Override
	public List<BuildingStructureNew> getBuildingStructureNewAndComponent(String projectId) {
		if (Tools.notEmpty(projectId)) {
			// 通过项目id获取建筑建构对象
			List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
					.getBuildingStructureNewbyProjectId(projectId);
			List<BuildingStructureNew> buildingStructureNewTemp = new ArrayList<BuildingStructureNew>();
			// buildingStructureNewTemp.addAll(buildingStructureNewList);
			if (buildingStructureNewList != null && buildingStructureNewList.size() > 0) {
				// 遍历建筑结构集合
				for (BuildingStructureNew buildingStructureNew : buildingStructureNewList) {
					// 获取组件与建筑结构关系对象
					List<ComponentStructure> componentStructures = componentStructureMapper
							.getComponentStructurebyBuildingStructureId(buildingStructureNew.getId());
					if (componentStructures != null && componentStructures.size() > 0) {
						for (ComponentStructure componentStructure : componentStructures) {
							// 获取建筑组件对象
							BuildingComponent buildingComponent = buildingComponentMapper
									.selectBuildingComponentById(componentStructure.getComponentPropertyId());
							if (buildingComponent != null) {
								BuildingStructureNew bsn = new BuildingStructureNew();
								bsn.setParentId(componentStructure.getBuildingStructureId());
								bsn.setNodeName(buildingComponent.getComponentName());
								bsn.setFullName(
										buildingStructureNew.getFullName() + buildingComponent.getComponentName());
								bsn.setId(buildingComponent.getComponentId());
								buildingStructureNewTemp.add(bsn);
							}
						}
					}
				}
				buildingStructureNewTemp.addAll(buildingStructureNewList);
				return buildingStructureNewTemp;
			}
		}
		return null;
	}

	@Override
	public List<BuildingStructureNew> getBuildingStructureNewAndComponentV(String projectId) {
		if (Tools.notEmpty(projectId)) {
			// 通过项目id获取建筑建构对象
			List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
					.getBuildingStructureNewVbyProjectId(projectId);
			List<BuildingStructureNew> buildingStructureNewTemp = new ArrayList<BuildingStructureNew>();
			// buildingStructureNewTemp.addAll(buildingStructureNewList);
			if (buildingStructureNewList != null && buildingStructureNewList.size() > 0) {
				buildingStructureNewTemp.addAll(buildingStructureNewList);
				return buildingStructureNewTemp;
			}
		}
		return null;
	}

	// 根据条件查询(企业客户)
	@Override
	public Node listAllBuildingStructureNewtwo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildingStructureNew> listIdAndfullNameByType(BuildingStructureNew buildingStructureNew) {
		// Map<String, String> areaMap = new HashMap<String, String>();
		// List<AreaTypeNew> atn = new ArrayList<AreaTypeNew>();
		// atn = areaTypeNewMapper.listAllAreaTypeNew();
		// if(atn.size() > 0){
		// for(AreaTypeNew areatype : atn){
		// areaMap.put(areatype.getAreaTypeCode(), areatype.getId());
		// }
		// }
		// buildingStructureNew.setAreaId(areaMap.get("parkspace"));
		List<BuildingStructureNew> buildingStructureNews = buildingStructureNewMapper
				.listAllBuildingStructureNewByType(buildingStructureNew);
		for (BuildingStructureNew building : buildingStructureNews) {
			building.setChildren(buildingStructureNewMapper.listAllBuildingStructureNewByParentId(building.getId()));
		}
		// return
		// buildingStructureNewMapper.listIdAndfullNameByType(buildingStructureNew);
		return buildingStructureNews;
	}
	
	@Override
	public List<BuildingStructureNew> listAllByType() {
		
		List<BuildingStructureNew>  buildingStructureNews = buildingStructureNewMapper.getProductBsType();
		List<BuildingStructureNew> buidingParentList=buildingStructureNewMapper.getProductBsParent();
		for(BuildingStructureNew bsn:buidingParentList){
			buildingStructureNews.add(bsn);
		}
		List<BuildingStructureNew> buidingParentTopList=buildingStructureNewMapper.getProductBsParentTop();
		for(BuildingStructureNew bsn:buidingParentTopList){
			buildingStructureNews.add(bsn);
		}
		return buildingStructureNews;
		
		
		
		
		
		
		
		
		
		
		
		
		
		//查询所有项目
//		List<Project> projectList = projectMapper.selectAllProject();
//		List<BuildingStructureNew> buildingStructureNews = new ArrayList<BuildingStructureNew>();
//		
//		for(Project project: projectList){
//			//根据项目id查根建筑
//			List<BuildingStructureNew> rootBuildingStructureNewList =  buildingStructureNewMapper.selectParentBuildingByProjectId(project.getProjectId());
//			for(BuildingStructureNew rbsn : rootBuildingStructureNewList){
//				//根据根id查父节点
//				List<BuildingStructureNew> parentBuildingStructureNewList =  buildingStructureNewMapper.listBuildingStructureByParentId(rbsn.getId());
//				
//				if(parentBuildingStructureNewList.size()!=0){					
//					//创建一个用于装有车位子节点的父节点
//					List<BuildingStructureNew> list =  new ArrayList<BuildingStructureNew>();
//					List<BuildingStructureNew> list2 =  new ArrayList<BuildingStructureNew>();
//					for(BuildingStructureNew pbsn : parentBuildingStructureNewList){
//						//获取父节点下的子节点
//						List<BuildingStructureNew> childBuildingStructureNewList =  buildingStructureNewMapper.listBuildingStructureByPId(pbsn.getId());
//						if(childBuildingStructureNewList.size()!=0){
//							list.add(pbsn);					
//							for(BuildingStructureNew cbsn : childBuildingStructureNewList){
//								list2.add(cbsn);									
//							}
//						}
//					}
//					//将有车位子节点并且没有绑定产品的父节点放入根节点中															
//					if(list!=null&&list.size()!=0)
//					{
//						List<BuildingStructureNew> newList = new ArrayList<BuildingStructureNew>();
//						for(BuildingStructureNew nbsn:list){
//							if(productBsMapper.listAllProductBsByBId(nbsn.getId()).size()==0){								
//								newList.add(nbsn);
//							}							
//					}
//					rbsn.setChildren(newList);	
//				}
//			}				
//			if(rbsn.getChildren()!=null&&rbsn.getChildren().size()!=0){
//				buildingStructureNews.add(rbsn);			
//			}
//		}
//	}
//	return buildingStructureNews;
		
//		List<BuildingStructureNew> buildingStructureNews = buildingStructureNewMapper
//				.listAllBuildingStructureNewByType(buildingStructureNew);
//		for (BuildingStructureNew building : buildingStructureNews) {
//			building.setChildren(buildingStructureNewMapper.listAllBuildingStructureNewByParentId(building.getId()));
//		}
	}

	@Override
	public BuildingStructureNew getBuildingStructureNewByPersonBuildingId(String personBuildingId) {
		return buildingStructureNewMapper.getBuildingStructureNewByPersonBuildingId(personBuildingId);
	}

	@Override
	public String getCountByCustId(String custId) {
		Map<String, Integer> data = new HashMap<String, Integer>();
		List<BuildingStructureNew> list0 = buildingStructureNewMapper.getCountAll(custId);
		List<BuildingStructureNew> list1 = buildingStructureNewMapper.getCountByType(custId, "住宅");
		List<BuildingStructureNew> list2 = buildingStructureNewMapper.getCountByType(custId, "车位");
		List<BuildingStructureNew> list3 = buildingStructureNewMapper.getCountByType(custId, "商铺");

		data.put("allCount_building", list0 == null ? 0 : list0.size());// 服务请求个数
		data.put("count_house", list1 == null ? 0 : list1.size());// 未处理
		data.put("count_stall", list2 == null ? 0 : list2.size());// 处理中
		data.put("count_cap", list3 == null ? 0 : list3.size());// 已处理
		return JSONObject.fromObject(data).toString();
	}

	@Override
	public BuildingStructureNew getBuildingStructurebyId(String id) {
		// TODO Auto-generated method stub
		String string = listAllBuildingStructureByParentId(id);
		if ("true".equals(string)) {
			return new BuildingStructureNew();
		}
		return buildingStructureNewMapper.getBuildingStructurebyId(id);
	}

	@Override
	public String listAllBuildingStructureByParentId(String buildingStructureId) {
		if (buildingStructureId != null) {
			if (buildingStructureNewMapper.listAllBuildingStructureByParentId(buildingStructureId).size() > 0) {
				return "true";
			}
			return "false";
		} else {
			return "3001";// 3001表示参数不全
		}
	}

	@Override
	public String updateDetailBuilding(BuildingStructureNew buildingStructureNew) {
		if (buildingStructureNew.getId() != null && buildingStructureNew.getBuildingType() != null
				&& buildingStructureNew.getBuildingCertificate() != null
				&& "/".equals(buildingStructureNew.getBuildingCertificate()) == false) {
			if ("住宅".equals(buildingStructureNew.getBuildingType())) {
				houseNewMapper.updateHouse(buildingStructureNew.getId(), buildingStructureNew.getBuildingCertificate());
			} else if ("车位".equals(buildingStructureNew.getBuildingType())) {
				stallNewMapper.updateStall(buildingStructureNew.getId(), buildingStructureNew.getBuildingCertificate());
			} else if ("商铺".equals(buildingStructureNew.getBuildingType())) {
				storeNewMapper.updateStore(buildingStructureNew.getId(), buildingStructureNew.getBuildingCertificate());
			}
		} else {
			return "3001";// 参数不全
		}
		return "200";
	}

	@Override
	public String savaZichanbangding(BuildingStructureNew buildingStructureNew) {
		if (buildingStructureNew.getBuildingCertificate() != null && buildingStructureNew.getBuildingType() != null) {
			updateDetailBuilding(buildingStructureNew);
		}
		if (buildingStructureNew.getPersonBuildingNew() != null) {
			if (buildingStructureNew.getPersonBuildingNew().getPersonBuildingIds() != null) {
				personBuildingNewService.deletePersonBuilding(buildingStructureNew.getPersonBuildingNew());
			}
			PersonBuildingNew personBuilding = new PersonBuildingNew();
			if (buildingStructureNew.getCustIds() != null
					&& buildingStructureNew.getPersonBuildingNew().getBuildingStructureId() != null) {
				for (String custId : buildingStructureNew.getCustIds()) {
					personBuilding.setCustId(custId);
					personBuilding.setBuildingStructureId(buildingStructureNew.getId());
					personBuilding.setCustType("业主");
					personBuildingNewService.addPersonBuildingNewRestful(personBuilding);
					
					//根据客户id查询个人客户账户
					Account account = new Account();
					account = accountMapper.getAccountByCustId(custId);
					//根据建筑结构id查询资产账户
					AssetAccount assetAccount = new AssetAccount();
					assetAccount = assetAccountMapper.getAssetAccountByBuildingId(buildingStructureNew.getId());
					//进行绑定
					if(account != null && assetAccount != null){
						AccountRelation aRelation = new AccountRelation();
						aRelation.setAccountRelationId(UUID.randomUUID().toString());
						aRelation.setAccountId(account.getAccountId());
						aRelation.setAssetAccount(assetAccount.getAssetAccountId());
						accountRelationMapper.insertAccountRelation(aRelation);
					}
					
				}
			} else if (buildingStructureNew.getEnterIds() != null
					&& buildingStructureNew.getPersonBuildingNew().getBuildingStructureId() != null) {
				for (String enterId : buildingStructureNew.getEnterIds()) {
					personBuilding.setCustId(enterId);
					personBuilding.setBuildingStructureId(buildingStructureNew.getId());
					personBuilding.setCustType("业主");
					personBuildingNewService
							.addPersonBuildingEnterpriseNewRestful(buildingStructureNew.getPersonBuildingNew());
				}
			}
		}
		return "200";
	}

	@Override
	public List<BuildingStructureNew> listBuildingforconllection(String custId) {
		return buildingStructureNewMapper.listBuildingforconllection(custId);
	}

	/*
	 * //递归获取子节点信息 private List<BuildingStructureNew>
	 * recursive(List<BuildingStructureNew> ListBS,List<String> Pid){ // TODO
	 * Auto-generated method stub List<String> Pids=new ArrayList<String>();
	 * List<BuildingStructureNew> childrens=new
	 * ArrayList<BuildingStructureNew>(); for(int j=0;j<Pid.size();j++){ for
	 * (int i=0;i<ListBS.size();i++) { //子节点数据制空
	 * ListBS.get(i).setChildren(null);
	 * if(Pid.get(j).equals(ListBS.get(i).getParentId())){ //存放父节点id
	 * Pids.add((ListBS.get(i).getId()));
	 * ListBS.get(i).setChildren(recursive(ListBS,Pids)); } }
	 * 
	 * }
	 * 
	 * return childrens; }
	 */

	/*
	 * public Node listAllBuildingStructureNewone() { // TODO Auto-generated
	 * method stub //存放父级节点idss List dataList=new ArrayList(); //查询所有建筑结构
	 * StringBuffer a=new StringBuffer(); StringBuffer b=new StringBuffer();
	 * StringBuffer c=new StringBuffer(); List<BuildingStructureNew>
	 * ListBS=buildingStructureNewMapper.listAllBuildingStructureNewByAll(); for
	 * (BuildingStructureNew buildingStructureNew : ListBS) {
	 * if(buildingStructureNew.getPersonCusts()!=null){ for(int
	 * i=0;i<buildingStructureNew.getPersonCusts().size();i++){ a.append("[");
	 * b.append("["); c.append("["); if(i>0){ a.append(","); b.append(",");
	 * c.append(","); }
	 * a.append(buildingStructureNew.getPersonCusts().get(i).getName());
	 * b.append(buildingStructureNew.getPersonCusts().get(i).getCardType());
	 * c.append(buildingStructureNew.getPersonCusts().get(i).getCardNum()); }
	 * a.append("]"); b.append("]"); c.append("]"); } HashMap dataRecord = new
	 * HashMap(); dataRecord.put("fullName",
	 * buildingStructureNew.getFullName()); dataRecord.put("id",
	 * buildingStructureNew.getId()); dataRecord.put("nodeName",
	 * buildingStructureNew.getNodeName()); dataRecord.put("parentId",
	 * buildingStructureNew.getParentId()); dataRecord.put("names",
	 * a.toString()); dataRecord.put("cardTypes", b.toString());
	 * dataRecord.put("cardNums", c.toString()); dataList.add(dataRecord); }
	 * Node data=BinaryTree.BinaryTree(dataList); JSONArray a
	 * =JSONArray.fromObject("["+data+"]"); System.out.println(a); String
	 * a="["+data+"]" ; System.out.println(data);
	 * System.out.println(data.toString()); return data ; }
	 */

	/**
	 * 资产报表查询 yinlei
	 */
	@Override
	public InputStream listBuildingStructureSearchMB(String projectId, String fullName, String name,
			Byte isBindingAssets, int num) {
		// TODO Auto-generated method stub
		// 存放父级节点id
		List dataList = new ArrayList();
		BuildingStructureSearch buildingStructureSearch = new BuildingStructureSearch();
		if (projectId != null || "".equals(projectId)) {
			buildingStructureSearch.setProjectId(projectId);
		}
		if (fullName != null || "".equals(fullName)) {
			buildingStructureSearch.setFullName(fullName);
		}
		buildingStructureSearch.setIsBindingAssets(isBindingAssets);
		if (name != null || "".equals(name)) {
			buildingStructureSearch.setName(name);
		}

		// if(buildingStructureSearch.getName()==null ||
		// buildingStructureSearch.getName().equals("")&&(buildingStructureSearch.getEnterpriseName()==null
		// || buildingStructureSearch.getEnterpriseName().equals(""))){
		// 查询所有建筑结构
		// 当用户姓名和企业名称都为空的时候执行查询操作
		// List<BuildingStructureNew>ListBS_father=buildingStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
		List<BuildingStructureNew> ListBS = new ArrayList<BuildingStructureNew>();
		List<BuildingStructureNew> ListBS_repeat = new ArrayList<BuildingStructureNew>();
		if (buildingStructureSearch.getIsBindingAssets() == 2) {
			if ("".equals(buildingStructureSearch.getName())) {
				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
				for (int i = 0; i < ListBS.size(); i++) {
					if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
						ListBS_repeat.add(ListBS.get(i));
					}
				}
				ListBS = ListBS_repeat;
				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew building : ListBS) {
					BuildingStructureNew build = building;
					while (build.getParentId() != null && build.getParentId().equals(build.getProjectId()) == false) {
						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
						ListBSadd.add(build);
					}
				}
				for (BuildingStructureNew building : ListBSadd) {
					ListBS.add(building);
				}
			} else {
				buildingStructureSearch.setCustType("业主");
				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew building : ListBS) {
					BuildingStructureNew build = building;
					while (build.getParentId() != null && build.getParentId().equals(build.getProjectId()) == false) {
						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
						ListBSadd.add(build);
					}
				}
				for (BuildingStructureNew building : ListBSadd) {
					ListBS.add(building);
				}
			}
		} else {
			if (buildingStructureSearch.getIsBindingAssets() == 0) {
				if ("".equals(buildingStructureSearch.getName())) {
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					/*for (int i = 0; i < ListBS.size(); i++) {
						if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
							ListBS_repeat.add(ListBS.get(i));
						}
					}
					ListBS = ListBS_repeat;
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}*/
				} else {
					buildingStructureSearch.setCustType("业主");
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					/*List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}*/
				}
			}
			if (buildingStructureSearch.getIsBindingAssets() == 1) {

				if ("".equals(buildingStructureSearch.getName())) {
					// List<BuildingStructureNew>ListBS_father=buildingStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					// for(BuildingStructureNew building:ListBS_father){
					// ListBS.add(building);
					// }
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				} else {
					buildingStructureSearch.setCustType("业主");
					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
					for (BuildingStructureNew building : ListBS) {
						BuildingStructureNew build = building;
						while (build.getParentId() != null
								&& build.getParentId().equals(build.getProjectId()) == false) {
							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
							ListBSadd.add(build);
						}
					}
					for (BuildingStructureNew building : ListBSadd) {
						ListBS.add(building);
					}
				}
			}
		}
		// }
		List<Node> nodeList = new ArrayList<Node>();
		for (BuildingStructureNew buildingStructureNew : ListBS) {
			StringBuffer a = new StringBuffer();//姓名
			StringBuffer b = new StringBuffer();//证件类型
			StringBuffer c = new StringBuffer();//证件号码
			int count_cust = 0;
			int count_enter = 0;
			//获取对应建筑资产对应的客户信息（个人和企业）
			List<PersonCustNew> personCusts = buildingStructureNew.getPersonCusts();
			List<EnterpriseCustNew> enterpriseCusts = buildingStructureNew.getEnterpriseCustNews();
			List<PersonCustNew> personCusts_new = new ArrayList<PersonCustNew>();
			List<EnterpriseCustNew> enterpriseCusts_new = new ArrayList<EnterpriseCustNew>();
			for (PersonCustNew ersonCust_repeat : personCusts) {
				if (ersonCust_repeat != null) {
					count_cust++;
					personCusts_new.add(ersonCust_repeat);
				}
			}
			for (EnterpriseCustNew enterprise_repeat : enterpriseCusts) {
				if (enterprise_repeat != null) {
					count_enter++;
					enterpriseCusts_new.add(enterprise_repeat);
				}
			}
			if (count_enter + count_cust > 0) {
				// 遍历人员信息 拼接所有业主姓名，证件号，证件类型
				int k = 0;
				if (count_cust > 0) {
					for (int m = 0; m < count_cust; m++) {
						if (k > 0) {
							a.append(",");
							b.append(",");
							c.append(",");
						}
						if (personCusts_new.get(m).getCardType() != null) {
							if (personCusts_new.get(m).getCardType() != ""
									&& personCusts_new.get(m).getCardType().equals("1")) {
								personCusts_new.get(m).setCardType("身份证");
							}
							if (personCusts_new.get(m).getCardType() != ""
									&& personCusts_new.get(m).getCardType().equals("2")) {
								personCusts_new.get(m).setCardType("护照");
							}
							a.append(personCusts_new.get(m).getName());
							b.append(personCusts_new.get(m).getCardType());
							c.append(personCusts_new.get(m).getCardNum());
						}
						k++;
					}
				}
				if (count_enter > 0) {
					for (int n = 0; n < count_enter; n++) {
						if (k > 0) {
							a.append(",");
							b.append(",");
							c.append(",");
						}
						a.append(enterpriseCusts_new.get(n).getEnterpriseName());
						b.append("");
						c.append("");
						k++;
					}
				}
				Node n = new Node();
				//HashMap dataRecord = new HashMap();
				n.setFullName(buildingStructureNew.getFullName());
				n.setId(buildingStructureNew.getId());
				n.setNodeName(buildingStructureNew.getNodeName());
				n.setParentId(buildingStructureNew.getParentId());
				n.setNames(a.toString());
				n.setCardTypes(b.toString());
				n.setCardNums(c.toString());
				n.setBuildingType(buildingStructureNew.getBuildingType());
				n.setProjectId(buildingStructureNew.getProjectId());
				/*dataRecord.put("fullName", buildingStructureNew.getFullName());
				dataRecord.put("id", buildingStructureNew.getId());
				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
				dataRecord.put("parentId", buildingStructureNew.getParentId());
				dataRecord.put("names", a.toString());
				dataRecord.put("cardTypes", b.toString());
				dataRecord.put("cardNums", c.toString());
				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
				dataRecord.put("projectId", buildingStructureNew.getProjectId());*/
				if (buildingStructureNew.getHouse() != null) {
					n.setBuildingCertificate(buildingStructureNew.getHouse().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
					if (buildingStructureNew.getHouse().getHouseArea() != null) {
						n.setBuildingArea(buildingStructureNew.getHouse().getHouseArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStall() != null) {
					n.setBuildingCertificate(buildingStructureNew.getStall().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
					if (buildingStructureNew.getStall().getUsableArea() != null) {
						n.setBuildingArea(buildingStructureNew.getStall().getUsableArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStore() != null) {
					n.setBuildingCertificate(buildingStructureNew.getStore().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
					if (buildingStructureNew.getStore().getBuildingArea() != null) {
						n.setBuildingArea(buildingStructureNew.getStore().getUsableArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
					n.setIsParent("true");
					//dataRecord.put("isParent", "true");
				} else {
					n.setIsParent("false");
					//dataRecord.put("isParent", "false");
				}
				nodeList.add(n);
			} else {
				for (int i = 0; i < buildingStructureNew.getPersonCusts().size(); i++) {
					if (i > 0) {
						a.append(",");
						b.append(",");
						c.append(",");
					}
				}
				/*HashMap dataRecord = new HashMap();
				dataRecord.put("fullName", buildingStructureNew.getFullName());
				dataRecord.put("id", buildingStructureNew.getId());
				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
				dataRecord.put("parentId", buildingStructureNew.getParentId());
				dataRecord.put("names", a.toString());
				dataRecord.put("cardTypes", b.toString());
				dataRecord.put("cardNums", c.toString());
				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
				dataRecord.put("projectId", buildingStructureNew.getProjectId());
				if (buildingStructureNew.getHouse() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
					if (buildingStructureNew.getHouse().getHouseArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStall() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
					if (buildingStructureNew.getStall().getUsableArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStore() != null) {
					dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
					if (buildingStructureNew.getStore().getBuildingArea() != null) {
						dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
					} else {
						dataRecord.put("buildingArea", "");
					}
				}
				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
					dataRecord.put("isParent", "true");
				} else {
					dataRecord.put("isParent", "false");
				}
				dataList.add(dataRecord);*/
				Node n = new Node();
				//HashMap dataRecord = new HashMap();
				n.setFullName(buildingStructureNew.getFullName());
				n.setId(buildingStructureNew.getId());
				n.setNodeName(buildingStructureNew.getNodeName());
				n.setParentId(buildingStructureNew.getParentId());
				n.setNames(a.toString());
				n.setCardTypes(b.toString());
				n.setCardNums(c.toString());
				n.setBuildingType(buildingStructureNew.getBuildingType());
				n.setProjectId(buildingStructureNew.getProjectId());
				/*dataRecord.put("fullName", buildingStructureNew.getFullName());
				dataRecord.put("id", buildingStructureNew.getId());
				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
				dataRecord.put("parentId", buildingStructureNew.getParentId());
				dataRecord.put("names", a.toString());
				dataRecord.put("cardTypes", b.toString());
				dataRecord.put("cardNums", c.toString());
				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
				dataRecord.put("projectId", buildingStructureNew.getProjectId());*/
				if (buildingStructureNew.getHouse() != null) {
					n.setBuildingCertificate(buildingStructureNew.getHouse().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
					if (buildingStructureNew.getHouse().getHouseArea() != null) {
						n.setBuildingArea(buildingStructureNew.getHouse().getHouseArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStall() != null) {
					n.setBuildingCertificate(buildingStructureNew.getStall().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
					if (buildingStructureNew.getStall().getUsableArea() != null) {
						n.setBuildingArea(buildingStructureNew.getStall().getUsableArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if (buildingStructureNew.getStore() != null) {
					n.setBuildingCertificate(buildingStructureNew.getStore().getBuildingCertificate());
					//dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
					if (buildingStructureNew.getStore().getBuildingArea() != null) {
						n.setBuildingArea(buildingStructureNew.getStore().getUsableArea().toString());
						//dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
					} else {
						n.setBuildingArea("");
						//dataRecord.put("buildingArea", "");
					}
				}
				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
					n.setIsParent("true");
					//dataRecord.put("isParent", "true");
				} else {
					n.setIsParent("false");
					//dataRecord.put("isParent", "false");
				}
				nodeList.add(n);
			}
		}
		/*HashMap<String, Node> nodeList = new HashMap<String, Node>();
		for (Iterator<Map<String, String>> it = dataList.iterator(); it.hasNext();) {
			Map<String, String> dataRecord = (Map<String, String>) it.next();
			Node node = new Node();
			node.setId((String) dataRecord.get("id"));
			node.setNodeName((String) dataRecord.get("nodeName"));
			node.setParentId((String) dataRecord.get("parentId"));
			node.setFullName((String) dataRecord.get("fullName"));
			node.setNames((String) dataRecord.get("names"));
			node.setCardTypes((String) dataRecord.get("cardTypes"));
			node.setCardNums((String) dataRecord.get("cardNums"));
			node.setBuildingType((String) dataRecord.get("buildingType"));
			node.setProjectId((String) dataRecord.get("projectId"));
			node.setBuildingCertificate((String) dataRecord.get("buildingCertificate"));
			node.setIsParent((String) dataRecord.get("isParent"));
			String s = dataRecord.get("buildingArea");
			node.setBuildingArea(s);
			nodeList.put(node.getId(), node);
		}*/
		//List nodes = new ArrayList(nodeList.values());
		List<String> AddNodeId=new ArrayList<String>();
		List<Node> listNodes=new ArrayList<Node>();
		for(int i=0;i<nodeList.size();i++){
			if(!AddNodeId.contains(nodeList.get(i).getId())){
				AddNodeId.add(nodeList.get(i).getId());
				listNodes.add(nodeList.get(i));
			}
		}
		
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		ExcelInfo exl = new ExcelInfo();
		String[] headers;
		String[] fields = { "id", "fullName", "nodeName", "buildingType", "isParent", "buildingArea",
				"buildingCertificate", "names" };
		if (num == 2) {
			headers = new String[] { "建筑结构编号", "建筑全名称", "建筑节点名称", "建筑类型", "是否为单位建筑(true:是 ,false:不是)", "建筑面积", "房产证号",
					"户主", "户主类型", "户主证件号", "追加客户类型(个人客户,企业客户)", "证件号", "追加客户姓名" };
			exl.setTitles(headers);
		}
		if (num == 1) {
			headers = new String[] { "建筑结构编号", "建筑全名称", "建筑节点名称", "建筑类型", "是否为单位建筑", "建筑面积", "房产证号", "户主" };
			exl.setTitles(headers);
		}
		if (nodeList.size() > 0) {
			exl.setFields(fields);
			// exl.setTitles(headers);
			exl.setSheetName("建筑导表导出文件");
			exl.setList(listNodes);
			list.add(exl);
		}
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
//	public InputStream listBuildingStructureSearchMB(String projectId, String fullName, String name,
//			Byte isBindingAssets, int num) {
//		// TODO Auto-generated method stub
//		// 存放父级节点id
//		List dataList = new ArrayList();
//		BuildingStructureSearch buildingStructureSearch = new BuildingStructureSearch();
//		if (projectId != null || "".equals(projectId)) {
//			buildingStructureSearch.setProjectId(projectId);
//		}
//		if (fullName != null || "".equals(fullName)) {
//			buildingStructureSearch.setFullName(fullName);
//		}
//		buildingStructureSearch.setIsBindingAssets(isBindingAssets);
//		if (name != null || "".equals(name)) {
//			buildingStructureSearch.setName(name);
//		}
//
//		// if(buildingStructureSearch.getName()==null ||
//		// buildingStructureSearch.getName().equals("")&&(buildingStructureSearch.getEnterpriseName()==null
//		// || buildingStructureSearch.getEnterpriseName().equals(""))){
//		// 查询所有建筑结构
//		// 当用户姓名和企业名称都为空的时候执行查询操作
//		// List<BuildingStructureNew>ListBS_father=buildingStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
//		List<BuildingStructureNew> ListBS = new ArrayList<BuildingStructureNew>();
//		List<BuildingStructureNew> ListBS_repeat = new ArrayList<BuildingStructureNew>();
//		if (buildingStructureSearch.getIsBindingAssets() == 2) {
//			if ("".equals(buildingStructureSearch.getName())) {
//				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
//				for (int i = 0; i < ListBS.size(); i++) {
//					if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
//						ListBS_repeat.add(ListBS.get(i));
//					}
//				}
//				ListBS = ListBS_repeat;
//				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//				for (BuildingStructureNew building : ListBS) {
//					BuildingStructureNew build = building;
//					while (build.getParentId() != null && build.getParentId().equals(build.getProjectId()) == false) {
//						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//						ListBSadd.add(build);
//					}
//				}
//				for (BuildingStructureNew building : ListBSadd) {
//					ListBS.add(building);
//				}
//			} else {
//				buildingStructureSearch.setCustType("业主");
//				ListBS = buildingStructureNewMapper.listNotBuildingStructureSearch(buildingStructureSearch);
//				List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//				for (BuildingStructureNew building : ListBS) {
//					BuildingStructureNew build = building;
//					while (build.getParentId() != null && build.getParentId().equals(build.getProjectId()) == false) {
//						build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//						ListBSadd.add(build);
//					}
//				}
//				for (BuildingStructureNew building : ListBSadd) {
//					ListBS.add(building);
//				}
//			}
//		} else {
//			if (buildingStructureSearch.getIsBindingAssets() == 0) {
//				if ("".equals(buildingStructureSearch.getName())) {
//					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
//					for (int i = 0; i < ListBS.size(); i++) {
//						if ("false".equals(listAllBuildingStructureByParentId(ListBS.get(i).getId()))) {
//							ListBS_repeat.add(ListBS.get(i));
//						}
//					}
//					ListBS = ListBS_repeat;
//					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//					for (BuildingStructureNew building : ListBS) {
//						BuildingStructureNew build = building;
//						while (build.getParentId() != null
//								&& build.getParentId().equals(build.getProjectId()) == false) {
//							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//							ListBSadd.add(build);
//						}
//					}
//					for (BuildingStructureNew building : ListBSadd) {
//						ListBS.add(building);
//					}
//				} else {
//					buildingStructureSearch.setCustType("业主");
//					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
//					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//					for (BuildingStructureNew building : ListBS) {
//						BuildingStructureNew build = building;
//						while (build.getParentId() != null
//								&& build.getParentId().equals(build.getProjectId()) == false) {
//							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//							ListBSadd.add(build);
//						}
//					}
//					for (BuildingStructureNew building : ListBSadd) {
//						ListBS.add(building);
//					}
//				}
//			}
//			if (buildingStructureSearch.getIsBindingAssets() == 1) {
//
//				if ("".equals(buildingStructureSearch.getName())) {
//					// List<BuildingStructureNew>ListBS_father=buildingiStructureNewMapper.getAllFatherNodes(buildingStructureSearch.getProjectId());
//					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
//					// for(BuildingStructureNew building:ListBS_father){
//					// ListBS.add(building);
//					// }
//					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//					for (BuildingStructureNew building : ListBS) {
//						BuildingStructureNew build = building;
//						while (build.getParentId() != null
//								&& build.getParentId().equals(build.getProjectId()) == false) {
//							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//							ListBSadd.add(build);
//						}
//					}
//					for (BuildingStructureNew building : ListBSadd) {
//						ListBS.add(building);
//					}
//				} else {
//					buildingStructureSearch.setCustType("业主");
//					ListBS = buildingStructureNewMapper.listBuildingStructureSearch(buildingStructureSearch);
//					List<BuildingStructureNew> ListBSadd = new ArrayList<BuildingStructureNew>();
//					for (BuildingStructureNew building : ListBS) {
//						BuildingStructureNew build = building;
//						while (build.getParentId() != null
//								&& build.getParentId().equals(build.getProjectId()) == false) {
//							build = buildingStructureNewMapper.getBuildingStructureById(build.getParentId());
//							ListBSadd.add(build);
//						}
//					}
//					for (BuildingStructureNew building : ListBSadd) {
//						ListBS.add(building);
//					}
//				}
//			}
//		}
//		// }
//
//		for (BuildingStructureNew buildingStructureNew : ListBS) {
//			StringBuffer a = new StringBuffer();
//			StringBuffer b = new StringBuffer();
//			StringBuffer c = new StringBuffer();
//			int count_cust = 0;
//			int count_enter = 0;
//			List<PersonCustNew> personCusts = buildingStructureNew.getPersonCusts();
//			List<EnterpriseCustNew> enterpriseCusts = buildingStructureNew.getEnterpriseCustNews();
//			List<PersonCustNew> personCusts_new = new ArrayList<PersonCustNew>();
//			List<EnterpriseCustNew> enterpriseCusts_new = new ArrayList<EnterpriseCustNew>();
//			for (PersonCustNew ersonCust_repeat : personCusts) {
//				if (ersonCust_repeat != null) {
//					count_cust++;
//					personCusts_new.add(ersonCust_repeat);
//				}
//			}
//			for (EnterpriseCustNew enterprise_repeat : enterpriseCusts) {
//				if (enterprise_repeat != null) {
//					count_enter++;
//					enterpriseCusts_new.add(enterprise_repeat);
//				}
//			}
//			if (count_enter + count_cust > 0) {
//				// 遍历人员信息 拼接所有业主姓名，证件号
//				int k = 0;
//				if (count_cust > 0 && count_enter > 0) {
//					int e = 0;
//					e = count_cust;
//					PersonCustNew person_test = personCusts_new.get(0);
//					String card = person_test.getCardNum();
//				}
//				if (count_cust > 0) {
//					for (int m = 0; m < count_cust; m++) {
//						if (k > 0) {
//							a.append(",");
//							b.append(",");
//							c.append(",");
//						}
//						if (personCusts_new.get(m).getCardType() != null) {
//							if (personCusts_new.get(m).getCardType() != ""
//									&& personCusts_new.get(m).getCardType().equals("1")) {
//								personCusts_new.get(m).setCardType("身份证");
//							}
//							if (personCusts_new.get(m).getCardType() != ""
//									&& personCusts_new.get(m).getCardType().equals("2")) {
//								personCusts_new.get(m).setCardType("护照");
//							}
//							a.append(personCusts_new.get(m).getName());
//							b.append(personCusts_new.get(m).getCardType());
//							c.append(personCusts_new.get(m).getCardNum());
//						}
//						k++;
//					}
//				}
//				if (count_enter > 0) {
//					for (int n = 0; n < count_enter; n++) {
//						if (k > 0) {
//							a.append(",");
//							b.append(",");
//							c.append(",");
//						}
//						a.append(enterpriseCusts_new.get(n).getEnterpriseName());
//						b.append("");
//						c.append("");
//						k++;
//					}
//				}
//				HashMap dataRecord = new HashMap();
//				dataRecord.put("fullName", buildingStructureNew.getFullName());
//				dataRecord.put("id", buildingStructureNew.getId());
//				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
//				dataRecord.put("parentId", buildingStructureNew.getParentId());
//				dataRecord.put("names", a.toString());
//				dataRecord.put("cardTypes", b.toString());
//				dataRecord.put("cardNums", c.toString());
//				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
//				dataRecord.put("projectId", buildingStructureNew.getProjectId());
//				if (buildingStructureNew.getHouse() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
//					if (buildingStructureNew.getHouse().getHouseArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if (buildingStructureNew.getStall() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
//					if (buildingStructureNew.getStall().getUsableArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if (buildingStructureNew.getStore() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
//					if (buildingStructureNew.getStore().getBuildingArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
//					dataRecord.put("isParent", "true");
//				} else {
//					dataRecord.put("isParent", "false");
//				}
//				dataList.add(dataRecord);
//			} else {
//				for (int i = 0; i < buildingStructureNew.getPersonCusts().size(); i++) {
//					if (i > 0) {
//						a.append(",");
//						b.append(",");
//						c.append(",");
//					}
//				}
//				HashMap dataRecord = new HashMap();
//				dataRecord.put("fullName", buildingStructureNew.getFullName());
//				dataRecord.put("id", buildingStructureNew.getId());
//				dataRecord.put("nodeName", buildingStructureNew.getNodeName());
//				dataRecord.put("parentId", buildingStructureNew.getParentId());
//				dataRecord.put("names", a.toString());
//				dataRecord.put("cardTypes", b.toString());
//				dataRecord.put("cardNums", c.toString());
//				dataRecord.put("buildingType", buildingStructureNew.getBuildingType());
//				dataRecord.put("projectId", buildingStructureNew.getProjectId());
//				if (buildingStructureNew.getHouse() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getHouse().getBuildingCertificate());
//					if (buildingStructureNew.getHouse().getHouseArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getHouse().getHouseArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if (buildingStructureNew.getStall() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getStall().getBuildingCertificate());
//					if (buildingStructureNew.getStall().getUsableArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getStall().getUsableArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if (buildingStructureNew.getStore() != null) {
//					dataRecord.put("buildingCertificate", buildingStructureNew.getStore().getBuildingCertificate());
//					if (buildingStructureNew.getStore().getBuildingArea() != null) {
//						dataRecord.put("buildingArea", buildingStructureNew.getStore().getBuildingArea().toString());
//					} else {
//						dataRecord.put("buildingArea", "");
//					}
//				}
//				if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
//					dataRecord.put("isParent", "true");
//				} else {
//					dataRecord.put("isParent", "false");
//				}
//				dataList.add(dataRecord);
//			}
//		}
//		HashMap<String, Node> nodeList = new HashMap<String, Node>();
//		for (Iterator<Map<String, String>> it = dataList.iterator(); it.hasNext();) {
//			Map<String, String> dataRecord = (Map<String, String>) it.next();
//			Node node = new Node();
//			node.setId((String) dataRecord.get("id"));
//			node.setNodeName((String) dataRecord.get("nodeName"));
//			node.setParentId((String) dataRecord.get("parentId"));
//			node.setFullName((String) dataRecord.get("fullName"));
//			node.setNames((String) dataRecord.get("names"));
//			node.setCardTypes((String) dataRecord.get("cardTypes"));
//			node.setCardNums((String) dataRecord.get("cardNums"));
//			node.setBuildingType((String) dataRecord.get("buildingType"));
//			node.setProjectId((String) dataRecord.get("projectId"));
//			node.setBuildingCertificate((String) dataRecord.get("buildingCertificate"));
//			node.setIsParent((String) dataRecord.get("isParent"));
//			String s = dataRecord.get("buildingArea");
//			node.setBuildingArea(s);
//			nodeList.put(node.getId(), node);
//		}
//		List nodes = new ArrayList(nodeList.values());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Excel ex = new Excel();
//		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
//		ExcelInfo exl = new ExcelInfo();
//		String[] headers;
//		String[] fields = { "id", "fullName", "nodeName", "buildingType", "isParent", "buildingArea",
//				"buildingCertificate", "names" };
//		if (num == 2) {
//			headers = new String[] { "建筑结构编号", "建筑全名称", "建筑节点名称", "建筑类型", "是否为单位建筑(true:是 ,false:不是)", "建筑面积", "房产证号",
//					"户主", "户主类型", "户主证件号", "追加客户类型(个人客户,企业客户)", "证件号", "追加客户姓名" };
//			exl.setTitles(headers);
//		}
//		if (num == 1) {
//			headers = new String[] { "建筑结构编号", "建筑全名称", "建筑节点名称", "建筑类型", "是否为单位建筑", "建筑面积", "房产证号", "户主" };
//			exl.setTitles(headers);
//		}
//		if (nodeList.size() > 0) {
//			exl.setFields(fields);
//			// exl.setTitles(headers);
//			exl.setSheetName("建筑导表导出文件");
//			exl.setList(nodes);
//			list.add(exl);
//		}
//		try {
//			return ex.createExcelInputStream(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}
	
	public InputStream importExcelTemplet() {
		// TODO Auto-generated method stub
		List<BuildingStructureNew> person=new ArrayList<BuildingStructureNew>();
		person.add(null);
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = new String[] { "建筑结构编号", "建筑全名称", "建筑节点名称", "建筑类型", "是否为单位建筑(true:是 ,false:不是)", "建筑面积", "房产证号",
				"户主", "户主类型", "户主证件号", "追加客户类型(个人客户,企业客户)", "证件号", "追加客户姓名" };
		String[] fields = {};
        List<BuildingStructureNew> dataset = new ArrayList<BuildingStructureNew>();
      
        ExcelInfo exl=new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("客户资产绑定导入模版");
		exl.setList(dataset);
		list.add(exl);
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String listParentBuildingStructureCxf(String houseGates) {
		JSONArray jsonarray = JSONArray.fromObject(houseGates);
		List<HouseGate> jsons = (List<HouseGate>) JSONArray.toCollection(jsonarray, HouseGate.class);
		List<String> ids = new ArrayList<String>();
		if (jsons != null && jsons.size() > 0) {
			for (HouseGate gate : jsons) {
				String houseId = gate.getHouseId();
				ids.add(houseId);
			}
			List<BuildingStructureNew> buildingStructureNews = buildingStructureNewMapper
					.listParentBuildingStructureCxf1(ids);
			JSONArray json = JSONArray.fromObject(buildingStructureNews);
			return json.toString();
		}
		return "";
	}

	@Override
	public String listChildrenBuildingStructureByparentIdCxf(String houseGates, String parentId) {
		// TODO Auto-generated method stub
		List<BuildingStructureNew> buildingStructureNewAll = buildingStructureNewMapper.listAllBuildingStructureNew1();// 所有数据
		JSONArray jsonarray = JSONArray.fromObject(houseGates);
		List<HouseGate> jsons = (List<HouseGate>) JSONArray.toCollection(jsonarray, HouseGate.class);
		/*
		 * List<BuildingStructureNew>
		 * buildingStructureNews=buildingStructureNewMapper.
		 * listParentBuildingStructureCxf(jsons);//门控机关联房屋
		 */ /*
			 * List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,
			 * Object>>(); for (BuildingStructureNew buildingStructureNew :
			 * buildingStructureNewAll) { HashMap<String, Object> map=new
			 * HashMap<String, Object>();
			 * map.put(buildingStructureNew.getId(),buildingStructureNew.
			 * getParentId()); maps.add(map); }
			 */
		/*
		 * List<String> parentIds=new ArrayList<String>(); for
		 * (BuildingStructureNew buildingStructure : buildingStructureNewAll) {
		 * for (HouseGate houseGate : jsons) {
		 * if(buildingStructure.getId().equals(houseGate.getId())){
		 * parentIds.add(buildingStructure.getParentId()); }
		 * 
		 * } }
		 */

		HashSet<BuildingStructureNew> BuildingStructureNewByParent = new HashSet<BuildingStructureNew>();
		for (HouseGate houseGate : jsons) {
			List<BuildingStructureNew> list = new ArrayList<BuildingStructureNew>();
			List<BuildingStructureNew> list1 = recursion(list, houseGate.getHouseId(), buildingStructureNewAll);
			BuildingStructureNewByParent.addAll(list1);
		}

		Iterator<BuildingStructureNew> it = BuildingStructureNewByParent.iterator();
		List<BuildingStructureNew> rest = new ArrayList<BuildingStructureNew>();
		while (it.hasNext()) {
			BuildingStructureNew obj = it.next();
			if (parentId.equals(obj.getParentId())) {
				rest.add(obj);
			}
		}
		JSONArray json = JSONArray.fromObject(rest);
		return json.toString();
	}

	private List<BuildingStructureNew> recursion(List<BuildingStructureNew> strs, String parentId,
			List<BuildingStructureNew> data) {
		List<BuildingStructureNew> objs = data;
		if (objs != null && objs.size() > 0) {
			for (BuildingStructureNew buildingStructureNew : objs) {
				if (parentId.equals(buildingStructureNew.getId())) {
					strs.add(buildingStructureNew);
					if (buildingStructureNew.getParentId() != null) {
						recursion(strs, buildingStructureNew.getParentId(), data);
					}
				}
			}
		}
		return strs;
	}

	/**
	 * 修改建筑结构名称
	 * 
	 * @param String
	 *            id, 修改名称的节点的id
	 * @param String
	 *            nodeName, 修改后的节点名称
	 * @author 王洲 2016.02.24
	 */
	public Info changeBuildName(String id, String nodeName) {

		// 查询需要修改的buildingStructure
		BuildingStructureNew bsn = buildingStructureNewMapper.getBuildingStructureNewbyId(id);

		// 根据建筑id获取这一栋建筑的所有建筑结构
		List<BuildingStructureNew> allbsnList = buildingStructureNewMapper
				.ListBuildingStructureNewByBuildingId(bsn.getBuildingId());

		// 获取bsn下的所有子节点,不包括bsn
		List<BuildingStructureNew> childList = new ArrayList<BuildingStructureNew>();
		BuildingTreeUtils btu = new BuildingTreeUtils();
		childList = btu.getChildNodes(allbsnList, id);

		// 获取建筑面积类型信息
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		List<AreaTypeNew> atnList = areaTypeNewMapper.listAllAreaTypeNew();
		if (atnList != null && atnList.size() > 0) {
			for (AreaTypeNew atn : atnList) {
				// 将建筑面积类型的名称和uuid存储入map集合，以便后面根据面积类型检索
				areaTypeMap.put(atn.getAreaTypeCode(), atn.getId());
			}
		}
		// 初始化住宅对象
		HouseNew house = new HouseNew();

		// 获取修改前的bsn全名
		String fullNameToUpdate = bsn.getFullName();

		// 获取全名中不需要修改的部分
		String fullNameToKeep = fullNameToUpdate.substring(0, fullNameToUpdate.length() - bsn.getNodeName().length());

		// 定义节点修改后所有子节点需要修改的fullName
		String fullNameForChild = fullNameToKeep + nodeName;

		// 修改当前传入的对象的节点名和全名
		try {
			bsn.setNodeName(nodeName);
			bsn.setFullName(fullNameForChild);
			buildingStructureNewMapper.updateFullNameById(bsn);
			// 判断当前节点是否为住宅，获取住宅对象
			if(bsn.getAreaId() != null){
				if (bsn.getAreaId().equals(areaTypeMap.get("house"))) {
					house = houseNewMapper.getHouseNewByBuildingStructId(bsn.getId());
					// 如果为住宅且有对应住宅对象时，同步修改住宅的名称
					if (house != null && house.getId() != null) {
						house.setHouseAddress(bsn.getFullName());
						houseNewMapper.updateHouseNew(house);
					}
				}
			}
			if (childList != null && childList.size() > 0) {
				for (BuildingStructureNew child : childList) {
					String oldFullName = child.getFullName().substring(fullNameToUpdate.length(),
							child.getFullName().length());
					child.setFullName(fullNameForChild + oldFullName);
					buildingStructureNewMapper.updateFullNameById(child);
					// 判断当前子节点是否为住宅，获取住宅对象
					if(child.getAreaId() != null){
						if (child.getAreaId().equals(areaTypeMap.get("house"))) {
							house = houseNewMapper.getHouseNewByBuildingStructId(child.getId());
							// 如果为住宅且有对应住宅对象时，同步修改住宅的名称
							if (house != null && house.getId() != null) {
								house.setHouseAddress(child.getFullName());
								houseNewMapper.updateHouseNew(house);
							}
						}						
					}
				}
			}
			return Tools.msg("success!", true);
		} catch (Exception e) {
			e.printStackTrace();
			return Tools.msg("fail!", false);
		}
	}

	@Override
	public List<BuildingStructureNew> getBuildingByIds(String ids) {
		String[] idArray = ids.split(",");
		List<String> idList = Arrays.asList(idArray);
		List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper.selectByBuildingByIds(idList);
		if (buildingStructureNewList.size() > 0) {
			return buildingStructureNewList;
		}
		return null;
	}

	@Override
	public List<BuildingStructureNew> listBuildingByProjectId(String projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", projectId);
		List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
				.selectParentBuildingByProjectId(projectId);
		List<BuildingStructureNew> temp = new ArrayList<BuildingStructureNew>();
		for (BuildingStructureNew buildingStructureNew : buildingStructureNewList) {
			map.put("parentId", buildingStructureNew.getId());
			List<BuildingStructureNew> childrenList = buildingStructureNewMapper.selectChildrenBuilding(map);
			temp.addAll(childrenList);
		}
		buildingStructureNewList.addAll(temp);
		return buildingStructureNewList;
	}

	@Override
	public String listBuildingStructureByParentIds(String ids) {
		JSONArray jsonArray = JSONArray.fromObject(ids);
		String[] buildingStru = (String[]) JSONArray.toArray(jsonArray, String.class);
		List<String> bsIds = buildingStructureNewMapper.listBuildingStructureByParentIds(buildingStru);
		if (bsIds != null && bsIds.size() > 0) {
			JSONArray json = JSONArray.fromObject(bsIds);
			return json.toString();
		}
		return null;
	}

	/**
	 * 住宅、商铺、车位合并模板导出 王洲 2016.03.04
	 */
	@Override
	public InputStream importAllBuidingStructureByProjectId(String projectId) {
		// 获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}

		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();

		List<String> forsearch = new ArrayList<String>();
		forsearch.add("house");
		forsearch.add("store");
		forsearch.add("parkspace");

		for (int i = 0; i < forsearch.size(); i++) {
			if (forsearch.get(i) == "house") {
				// 根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
				BuildingStructureNew bsn = new BuildingStructureNew();
				bsn.setAreaId(areaTypeMap.get("house"));
				bsn.setProjectId(projectId);
				List<BuildingStructureNew> bsnList = buildingStructureNewMapper
						.listBuildingStructureByProjectIdAndAreaId(bsn);

				// 根据传入的projectId获取该项目下的所有house数据
				List<HouseNew> hsList = houseNewMapper.listHouseNewByProjectId(projectId);

				// 生成需要写入的建筑结构数据集合
				List<BuildingStructureNew> _bsnList = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew buildingStructureNew : bsnList) {
					int j = 0;
					for (HouseNew houseNew : hsList) {
						if (!buildingStructureNew.getId().toString()
								.equals(houseNew.getBuildingStructureId().toString())) {
							j++;
						}
					}
					if (j == hsList.size()) {
						_bsnList.add(buildingStructureNew);
					}
				}
				// 导出到excel
				String[] headers = { "项目归属编号", "建筑归属编号", "建筑结构归属编号", "建筑名称", "楼房属性", "房屋户型", "房屋编码", "建筑面积", "套内面积",
						"分摊面积", "竣工面积", "竣工日期", "销售状态" };
				String[] fields = { "projectId", "buildingId", "buildingStructureId", "houseName" };
				List<HouseNew> dataset = new ArrayList<HouseNew>();
				for (BuildingStructureNew bsns : _bsnList) {
					HouseNew hn = new HouseNew();
					hn.setId(null);
					hn.setProjectId(bsns.getProjectId());
					hn.setBuildingId(bsns.getBuildingId());
					hn.setBuildingStructureId(bsns.getId());
					hn.setHouseName(bsns.getFullName());
					dataset.add(hn);
				}
				if (dataset.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("住宅记录模板");
					exl.setList(dataset);
					list.add(exl);
				}
			} else if (forsearch.get(i) == "store") {
				// 根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
				BuildingStructureNew bsn = new BuildingStructureNew();
				bsn.setAreaId(areaTypeMap.get("store"));
				bsn.setProjectId(projectId);
				List<BuildingStructureNew> bsnList = buildingStructureNewMapper
						.listBuildingStructureByProjectIdAndAreaId(bsn);

				// 根据传入的projectId获取该项目下的所有house数据
				List<StoreNew> snList = storeNewMapper.listStoreByProjectId(projectId);

				// 生成需要写入的建筑结构数据集合
				List<BuildingStructureNew> _snList = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew buildingStructureNew : bsnList) {
					int j = 0;
					for (StoreNew storeNew : snList) {
						if (!buildingStructureNew.getId().toString()
								.equals(storeNew.getBuildingStructureId().toString())) {
							j++;
						}
					}
					if (j == snList.size()) {
						_snList.add(buildingStructureNew);
					}
				}
				String[] headers = { "建筑结构归属编号", "建筑归属编号", "项目归属编号", "商铺名称", "商业属性", "商铺编码", "商铺号", "建筑面积", "套内面积",
						"分摊面积", "竣工面积", "竣工日期", "销售状态" };
				String[] fields = { "buildingStructureId", "buildingId", "projectId", "fullName" };
				List<StoreNew> dataset = new ArrayList<StoreNew>();
				for (BuildingStructureNew bsns : _snList) {
					StoreNew sn = new StoreNew();
					sn.setBuildingStructureId(bsns.getId());
					sn.setBuildingId(bsns.getBuildingId());
					sn.setProjectId(bsns.getProjectId());
					sn.setFullName(bsns.getFullName());
					dataset.add(sn);
				}
				if (dataset.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("商铺记录模板");
					exl.setList(dataset);
					list.add(exl);
				}
			} else if (forsearch.get(i) == "parkspace") {
				// 根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
				BuildingStructureNew bsn = new BuildingStructureNew();
				bsn.setAreaId(areaTypeMap.get("parkspace"));
				bsn.setProjectId(projectId);
				List<BuildingStructureNew> bsnList = buildingStructureNewMapper
						.listBuildingStructureByProjectIdAndAreaId(bsn);

				// 根据传入的projectId获取该项目下的所有车位数据
				List<StallNew> snList = stallNewMapper.listStallByProjectId(projectId);

				// 生成需要写入的建筑结构数据集合
				List<BuildingStructureNew> _snList = new ArrayList<BuildingStructureNew>();
				for (BuildingStructureNew buildingStructureNew : bsnList) {
					int j = 0;
					for (StallNew stallNew : snList) {
						if (!buildingStructureNew.getId().toString()
								.equals(stallNew.getBuildingStructureId().toString())) {
							j++;
						}
					}
					if (j == snList.size()) {
						_snList.add(buildingStructureNew);
					}
				}
				// 导出到excel
				String[] headers = { "建筑结构归属编号", "建筑归属编号", "项目归属编号", "车位名称", "车位编码", "车位属性", "车位号", "是否机械车位", "竣工日期",
						"销售状态" };
				String[] fields = { "buildingStructureId", "buildingId", "projectId", "stallPosition" };
				List<StallNew> dataset = new ArrayList<StallNew>();
				for (BuildingStructureNew bsns : _snList) {
					StallNew sn = new StallNew();
					sn.setBuildingStructureId(bsns.getId());
					sn.setBuildingId(bsns.getBuildingId());
					sn.setProjectId(bsns.getProjectId());
					sn.setStallPosition(bsns.getFullName());
					dataset.add(sn);
				}
				if (dataset.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("车位记录模板");
					exl.setList(dataset);
					list.add(exl);
				}
			}
		}

		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InputStream exportAllBuildingStructtureByProjectId(String projectId) {

		// 获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}

		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();

		List<String> forsearch = new ArrayList<String>();
		forsearch.add("house");
		forsearch.add("store");
		forsearch.add("parkspace");

		for (String params : forsearch) {
			if (params == "house") {

				// 根据传入的projectId获取该项目下的所有house数据
				List<HouseNew> hsList = houseNewMapper.listHouseNewByProjectId(projectId);
								
				for(HouseNew hn : hsList){
					if(hn.getHouseAddress() != null){
						hn.setFullName(hn.getHouseAddress());				
					}else{
						hn.setFullName("");
					}
					if(hn.getCompleteDate() != null){
						hn.setE_completeDate(sdf.format(hn.getCompleteDate()));				
					}else{
						hn.setE_completeDate("");
					}
					//调整导出方法，修改导出的数据字段  王洲  2016.02.29
					if(hn.getJoinGangState() != null){
						if(hn.getJoinGangState() == 0){
							hn.setJoinGangStates("未售");
						}else{
							hn.setJoinGangStates("已售");
						}				
					}else{
						hn.setJoinGangStates("未售");
					}
				}

				// 导出到excel
				String[] headers = { "名称", "房屋编码", "楼房属性", "房屋户型", "建筑面积", "套内面积", "公摊面积", "竣工面积", "竣工日期", "销售状态" };
				String[] fields = { "fullName", "houseNum", "houseAttribute", "houseType", "houseArea", "usableArea",
						"shareArea", "completeArea", "e_completeDate", "joinGangStates" };

				if (hsList.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("住宅记录模板");
					exl.setList(hsList);
					list.add(exl);
				}
			} else if (params == "store") {

				// 根据传入的projectId获取该项目下的所有house数据
				List<StoreNew> snList = storeNewMapper.listStoreByProjectId(projectId);

				String[] headers = { "名称", "商业属性", "商铺编码", "商铺号", "建筑面积", "公摊面积", "套内面积", "竣工面积", "竣工日期", "销售状态" };
				String[] fields = { "fullName", "storeTyoe", "storeCode", "storeNumber", "buildingArea",
						"commonalityArea", "insideArea", "completionArea", "e_intakeDate", "intakeStates" };

				if (snList.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("商铺记录");
					exl.setList(snList);
					list.add(exl);
				}
			} else if (params == "parkspace") {

				// 根据传入的projectId获取该项目下的所有车位数据
				List<StallNew> snewList = stallNewMapper.listStallByProjectId(projectId);

				for(StallNew sn : snewList){
					if("1".equals(sn.getIsMechanicalStall())){
						sn.setIsMechanicalStall("机械车位");
					}else{
						sn.setIsMechanicalStall("非机械车位");
					}
					if(sn.getIntakeDate() != null){
						sn.setE_intakeDate(sdf.format(sn.getIntakeDate()));				
					}else{
						sn.setE_intakeDate("");
					}
					if(sn.getIntakeState() != null){
						if(sn.getIntakeState() == 1){
							sn.setIntakeStates("已售");
						}else{
							sn.setIntakeStates("未售");
						}
					}else{
						sn.setIntakeStates("未售");
					}
				}

				String[] headers = { "名称", "车位编码", "车位属性", "车位号", "机械车位", "竣工日期", "销售状态" };
				String[] fields = { "fullName", "stallCoding", "stallProperty", "stallNumber", "isMechanicalStall",
						"e_intakeDate", "intakeStates" };

				if (snewList.size() > 0) {
					ExcelInfo exl = new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("车位记录");
					exl.setList(snewList);
					list.add(exl);
				}
			}
		}
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	public InputStream createBuildingModel() {

		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "序号", "项目名称", "房屋编号/车位编号", "房屋名称/车位位置", "宗地编号", "期号/区号", "楼栋", "座号", "单元", "楼屋/车位楼层",
				"房号/车位号", "房屋用途" };
		String[] fields = {};
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("建筑结构导入模板");
		exl.setList(null);
		list.add(exl);
		try {
			return ex.createExcelInputStream(list);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	**/
	//序号	项目名称	房屋编号/车位编号	房屋名称/车位位置	宗地编号	期号/区号	楼栋	座号	单元	楼屋/车位楼层	房号/车位号	房屋用途	建筑标识	建筑面积	公摊面积	套内面积	竣工面积	竣工日期	楼房属性/车位属性/商业属性	房屋户型/机械车位	销售状态
	public InputStream createBuildingModel() {

		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers1 = { "序号", "项目名称", "房屋编号/车位编号", "房屋名称/车位位置", "宗地编号", "期号/区号", "楼栋"
				, "座号", "单元", "楼屋/车位楼层","房号/车位号", "房屋用途","建筑标识","建筑面积","公摊面积","套内面积","竣工面积","竣工日期"
				,"楼房属性/车位属性/商业属性","房屋户型/机械车位","销售状态"};
		String[] headers2 = { "序号", "项目名称", "房屋编号/车位编号", "房屋名称/车位位置", "宗地编号", "期号/区号", "楼栋"
				, "座号", "单元", "楼屋/车位楼层","房号/车位号", "房屋用途","建筑标识","建筑面积","公摊面积","套内面积"};
		String[] fields = {};
		ExcelInfo exl1 = new ExcelInfo();
		exl1.setFields(fields);
		exl1.setTitles(headers1);
		exl1.setSheetName("建筑结构导入模板");
		exl1.setList(null);
		list.add(exl1);
		ExcelInfo exl2 = new ExcelInfo();
		exl2.setFields(fields);
		exl2.setTitles(headers2);
		exl2.setSheetName("建筑信息导入模板");
		exl2.setList(null);
		list.add(exl2);
		
		String[] headers3 = { "字段名称","字段类型","默认值","字段解释"};
		//字段名称	字段类型	默认值	 字段解释
		ExcelInfo exl3 = new ExcelInfo();
//		序号		无	无实际意义
//		项目名称	字符串	无	项目名称
//		房屋编号/车位编号	字符串	无	以房屋类型来区分是房屋编号还是车位编号
//		房屋名称/车位位置	字符串	无	以房屋类型来区分
//		宗地编号	字符串	无	宗地编号，必填项。判断标识。
//		期号/区号	字符串	无	一般以两位为准，比如说02代表02期或02区。如果为建筑的话是02期，如果是建筑结构为02区。
//		楼栋	字符串	无	例如：002,004,地下车库
//		座号	字符串	无	
//		单元	字符串	无	
//		楼屋/车位楼层	字符串	无	
//		房号/车位号	字符串	无	
//		房屋用途	字符串	无	分别为:建筑/住宅/商铺/车位;
//		建筑标识	字符串	否	是/否，来区分是建筑还是建筑结构。
//		建筑面积	字符串	0	
//		公摊面积	字符串	0	
//		套内面积	字符串	0	
//		竣工面积	字符串	0	
//		竣工日期	日期	无	
//		楼房属性/车位属性/商业属性	字符串		"如果房屋用途是住房:多层/小高层/高层/超高层;
//		如果房屋用途是车位:标准车位/微型车位/子母车位;
//		如果房屋用途是商铺:小商铺/写字楼/商业公寓/酒店/商业综合体/产业用房;"
//		房屋户型/机械车位	字符串		"如果房屋用途是住房:一房一厅/一房两厅/两房两厅/三房两厅/四房两厅/五房两厅/连排/别墅/其它;
//		如果房屋用途是车位:是/否;"
//		销售状态	字符串		已售/未售;
// 				注意：默认第一页为建筑结构导入，第二页为建筑信息导入。不读取第三页。

		String [] notes = new String[]{"序号","","无","无实际意义"
				,"项目名称","字符串","无","项目名称"
				,"房屋编号/车位编号","字符串","无","以房屋类型来区分是房屋编号还是车位编号"
				,"房屋名称/车位位置","字符串","无","以房屋类型来区分"
				,"宗地编号","字符串","无","宗地编号，必填项。判断标识。"
				,"期号/区号","字符串","无","一般以两位为准，比如说02代表02期或02区。如果为建筑的话是02期，如果是建筑结构为02区。"
				,"楼栋","字符串","无","例如：002,004,地下车库"
				,"座号","字符串","无",""
				,"单元","字符串","无",""
				,"楼屋/车位楼层","字符串","无",""
				,"房号/车位号","字符串","无",""
				,"房屋用途","字符串","无","分别为:建筑/住宅/商铺/车位;"
				,"建筑标识","字符串","否","是/否，来区分是建筑还是建筑结构。"
				,"建筑面积","浮点型","0",""
				,"公摊面积","浮点型","0",""
				,"套内面积","浮点型","0",""
				,"竣工面积","浮点型","0",""
				,"竣工日期","日期","无",""
				,"楼房属性/车位属性/商业属性","字符串","无","1.如果房屋用途是住房:多层/小高层/高层/超高层;2.如果房屋用途是车位:标准车位/微型车位/子母车位;3.如果房屋用途是商铺:小商铺/写字楼/商业公寓/酒店/商业综合体/产业用房;"
				,"房屋户型/机械车位","字符串","无","1.如果房屋用途是住房:一房一厅/一房两厅/两房两厅/三房两厅/四房两厅/五房两厅/连排/别墅/其它;2.如果房屋用途是车位:是/否;"
				,"销售状态","字符串","无","已售/未售"
				,"","","","注意：默认第一页为建筑结构导入，第二页为建筑信息导入。不读取第三页。"};

		fields = new String[]{"字段名称","字段类型","默认值","字段解释"};
		List<java.util.HashMap> mapList =new ArrayList<java.util.HashMap>();
		
		java.util.HashMap mp =null;
		for(int i = 0;i<notes.length;i++){
			mp = new java.util.HashMap();
			mp.put("字段名称", notes[i++]);
			mp.put("字段类型", notes[i++]);
			mp.put("默认值", notes[i++]);
			mp.put("字段解释",notes[i]);
			mapList.add(mp);
		}
		
		exl3.setFields(fields);
		exl3.setTitles(headers3);
		exl3.setSheetName("说明文件");
		exl3.setList(mapList);
		list.add(exl3);
		
		try {
			return ex.createExcelInputStream(list);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unused")
	@Override
	/**
	public Info importDataFromExcelFile(Annex annex) {
		String filePath = annex.getAnnexAddress();
		String projectId = annex.getProjectId();
		String isFinish = annex.getIsFinish();

		if (Tools.notEmpty(filePath)) {
			try {
				String fileName = annex.getAnnexName();
				String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
				List<Map<Short, String>> dataList = null;
				if ("xls".equals(prefix)) {
					dataList = new ExcelUtils().readExcel(filePath);
				}
				if ("xlsx".equals(prefix)) {
					dataList = new ExcelUtils().readExcelXlsx(filePath);
				}
				if (dataList != null && dataList.size() > 0) {
					final List<BuildingNew> baseDataList = new ArrayList<BuildingNew>();// 建筑列表
					final List<BuildingStructureNew> bsNewList = new ArrayList<BuildingStructureNew>();// 建筑结构列表
					
					// 获取该项目下的所有宗地列表信息
					List<Parcel> parcelList = new ArrayList<Parcel>();
					parcelList = parcelMapper.selectByProjectId(projectId);
					List<AreaTypeNew> areaTypeList = new ArrayList<AreaTypeNew>();
					Map<String, String> areaTypeMap = new HashMap<String, String>();
					for(AreaTypeNew at : areaTypeList){
						areaTypeMap.put(at.getAreaTypeCode(), at.getId());
					}
					areaTypeList = areaTypeNewMapper.listAllAreaTypeNew();
					// 保存excel编号和栋主键的map
					Map<String, String> oneLevelMap = new HashMap<String, String>();
					
					//住宅和商业：保存excel编号和单元主键的map; 车位：保存楼层或者车库的主键map
					 
					Map<String, String> secondLevelMap = new HashMap<String, String>();
					// 最终被录入到数据库的满足宗地号在对应项目下的记录
					List<Map<Short, String>> finalList = new ArrayList<Map<Short, String>>();
					for (Map<Short, String> t : dataList) {
						String parcelNum = t.get((short) 4);// 住宅、商业、车位的宗地编号
						if (StringUtils.isNotEmpty(parcelNum)) {
							String parcelId = "";
							boolean parcelExist = false;
							for (Parcel p : parcelList) {
								if (parcelNum.equals(p.getParcelNum())) {
									parcelExist = true;
									parcelId = p.getParcelId();
									break;
								}
							}
							// 如果该条记录的宗地编号在项目中的宗地编号内，进行后续操作
							if (parcelExist) {
								finalList.add(t);
								// 获取项目名称、区号（期号）、栋作为顶级节点的唯一标识
								String projectName = t.get((short) 1);// 项目名称
								String areaNum = t.get((short) 5);// 区号
								String buildingNum = t.get((short) 6);// 栋号
								String seatNum = t.get((short) 7);// 座号
								String unitNum = t.get((short) 8);// 单元号
								String floorNum = t.get((short) 9);// 楼屋号或者车位楼层号
								String houseNum = t.get((short) 10);// 房号或者车位号
								String homeType = t.get((short) 11);// 房屋用途

								String groupKey = projectName + areaNum + buildingNum;// 一级节点Key
								String gSecondKey = "";// 二级节点
								boolean isStallFlag = false;// 判断是否是车位信息
								if ("车位".equals(homeType)) {
									isStallFlag = true;
									gSecondKey = groupKey + floorNum;// 车位上级key
								} else {
									gSecondKey = groupKey + unitNum;// 房屋上级Key
								}

								// 判断该条记录拼接的Key是否已经保存到一级节点Map中，如果没有该条key则拼接建筑名称，
								// 去建筑表查看是否有对应的建筑信息，如果有则取出建筑ID，查询建筑结构表，
								// 获取建筑结构ID，并将相关信息保存到map中,如果没有，则在程序中新增该条建筑记录和建筑结构记录，并将生成的相关信息保存到一级Key中
								if (oneLevelMap.size() > 0) {
									boolean hasKey = false;
									for (String gKey : oneLevelMap.keySet()) {
										if (groupKey.equals(gKey)) {
											hasKey = true;
											break;
										}
									}
									if (!hasKey) {
										// 查看建筑表中是否有对应信息，如果有，则取出，没有，则程序生成
										BuildingNew b = buildingNewMapper
												.getBuildingNewByBuildingName(areaNum + "区" + buildingNum + "栋");
										if (b != null) {
											// 如果有记录，则肯定有对应的建筑结构一级记录，二级记录是否存在还不清楚
											BuildingStructureNew bsn = buildingStructureNewMapper
													.getBuildingStructureByBuildingId(b.getId());
											oneLevelMap.put(groupKey, b.getId() + "," + bsn.getId() + "," + parcelId);

											// 根据获取到的建筑结构一级节点信息，查看是否有二级节点已经存在
											List<BuildingStructureNew> list = buildingStructureNewMapper
													.getBuildingStructureNewByparentId(bsn.getId());
											String secondNodeName = "";
											if (isStallFlag) {
												secondNodeName = floorNum + "层";
											} else {
												secondNodeName = unitNum + "单元";
											}
											boolean isSecondFlag = false;
											for (BuildingStructureNew buildingStructureNew : list) {
												if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
													secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
															+ "," + buildingStructureNew.getId() + "," + parcelId);
													isSecondFlag = true;
													break;
												}
											}
											if (!isSecondFlag) {
												String bsNewId = UUID.randomUUID().toString();
												BuildingStructureNew bsnNew = new BuildingStructureNew();
												bsnNew.setBuildingId(b.getId());
												bsnNew.setId(bsNewId);
												bsnNew.setParentId(bsn.getId());
												bsnNew.setProjectId(projectId);
												bsnNew.setNodeName(secondNodeName);
												bsnNew.setIsBindingAssets((byte)0);
												bsnNew.setParcelId(parcelId);
												secondLevelMap.put(gSecondKey,
														b.getId() + "," + bsNewId + "," + parcelId);
												bsNewList.add(bsnNew);
											}
										} else {
											String bId = UUID.randomUUID().toString();// 建筑Id
											String bsId = UUID.randomUUID().toString();// 建筑结构栋Id

											BuildingNew bn = new BuildingNew();// 保存到建筑表
											bn.setId(bId);
											bn.setParcelId(parcelId);
											bn.setProjectId(projectId);
											bn.setBuildingName(areaNum + "区" + buildingNum + "栋");
											baseDataList.add(bn);

											// 插入建筑结构表
											BuildingStructureNew bsn = new BuildingStructureNew();// 保存到建筑结构表
											bsn.setBuildingId(bId);
											bsn.setProjectId(projectId);
											bsn.setId(bsId);
											bsn.setParentId(null);
											bsn.setNodeName(areaNum + "区" + buildingNum + "栋");
											bsn.setFullName(areaNum + "区" + buildingNum + "栋");
											bsn.setIsBindingAssets((byte)0);
											bsn.setParcelId(parcelId);
											bsNewList.add(bsn);

											oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

											String secondNodeName = "";
											if (isStallFlag) {
												secondNodeName = floorNum + "层";
											} else {
												secondNodeName = unitNum + "单元";
											}
											String bsSecondId = UUID.randomUUID().toString();// 建筑结构单元Id

											// 插入建筑结构表
											BuildingStructureNew bsnSecond = new BuildingStructureNew();// 保存到建筑结构表
											bsnSecond.setBuildingId(bId);
											bsnSecond.setProjectId(projectId);
											bsnSecond.setId(bsSecondId);
											bsnSecond.setParentId(bsId);
											bsnSecond.setFullName(areaNum + "区" + buildingNum + "栋"+secondNodeName);
											bsnSecond.setNodeName(secondNodeName);
											bsnSecond.setIsBindingAssets((byte)0);
											bsnSecond.setParcelId(parcelId);
											bsNewList.add(bsnSecond);

											secondLevelMap.put(gSecondKey, bId + "," + bsSecondId + "," + parcelId);
										}
									} else {
										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										boolean hasSecondKey = false;
										for (String sKey : secondLevelMap.keySet()) {
											if (gSecondKey.equals(sKey)) {
												hasSecondKey = true;
												break;
											}
										}
										if (!hasSecondKey) {
											String bId = oneLevelMap.get(groupKey).split(",")[0];
											String parentId = oneLevelMap.get(groupKey).split(",")[1];
											List<BuildingStructureNew> list = buildingStructureNewMapper
													.getBuildingStructureNewByparentId(parentId);

											boolean isSecondFlag = false;
											for (BuildingStructureNew buildingStructureNew : list) {
												if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
													secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
															+ "," + buildingStructureNew.getId() + "," + parcelId);
													isSecondFlag = true;
													break;
												}
											}
											if (!isSecondFlag) {
												String bsNewId = UUID.randomUUID().toString();
												BuildingStructureNew bsnNew = new BuildingStructureNew();
												bsnNew.setBuildingId(bId);
												bsnNew.setId(bsNewId);
												bsnNew.setParentId(parentId);
												bsnNew.setProjectId(projectId);
												bsnNew.setNodeName(secondNodeName);
												bsnNew.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
												bsnNew.setIsBindingAssets((byte)0);
												bsnNew.setParcelId(parcelId);
												bsNewList.add(bsnNew);
												secondLevelMap.put(gSecondKey, bId + "," + bsNewId + "," + parcelId);
											}
										}
									}
								} else {
									String bId = "";// 建筑Id
									String bsId = "";// 建筑结构栋Id

									BuildingNew b = buildingNewMapper
											.getBuildingNewByBuildingName(areaNum + "区" + buildingNum + "栋");

									if (b != null) {
										BuildingStructureNew bsn = buildingStructureNewMapper
												.getBuildingStructureByBuildingId(b.getId());
										bId = b.getId();
										bsId = bsn.getId();
										oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

										// 根据获取到的建筑结构一级节点信息，查看是否有二级节点已经存在
										List<BuildingStructureNew> list = buildingStructureNewMapper
												.getBuildingStructureNewByparentId(bsn.getId());
										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										boolean isSecondFlag = false;
										for (BuildingStructureNew buildingStructureNew : list) {
											if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
												secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
														+ "," + buildingStructureNew.getId() + "," + parcelId);
												isSecondFlag = true;
												break;
											}
										}
										if (!isSecondFlag) {
											String bsNewId = UUID.randomUUID().toString();
											BuildingStructureNew bsnNew = new BuildingStructureNew();
											bsnNew.setBuildingId(b.getId());
											bsnNew.setId(bsNewId);
											bsnNew.setParentId(bsn.getId());
											bsnNew.setProjectId(projectId);
											bsnNew.setNodeName(secondNodeName);
											bsnNew.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
											bsnNew.setIsBindingAssets((byte)0);
											bsnNew.setParcelId(parcelId);
											bsNewList.add(bsnNew);
											secondLevelMap.put(gSecondKey, b.getId() + "," + bsNewId + "," + parcelId);
										}
									} else {
										bId = UUID.randomUUID().toString();//建筑Id
										bsId = UUID.randomUUID().toString();//建筑结构Id
										BuildingNew bn = new BuildingNew();// 保存到建筑表
										bn.setId(bId);
										bn.setParcelId(parcelId);
										bn.setProjectId(projectId);
										bn.setBuildingName(areaNum + "区" + buildingNum + "栋");
										baseDataList.add(bn);

										// 插入建筑结构表
										BuildingStructureNew bsn = new BuildingStructureNew();// 保存到建筑结构表
										bsn.setBuildingId(bId);
										bsn.setProjectId(projectId);
										bsn.setId(bsId);
										bsn.setParentId(null);
										bsn.setNodeName(areaNum + "区" + buildingNum + "栋");
										bsn.setFullName(areaNum + "区" + buildingNum + "栋");
										bsn.setIsBindingAssets((byte)0);
										bsn.setParcelId(parcelId);
										bsNewList.add(bsn);
										oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										String bsSecondId = UUID.randomUUID().toString();// 建筑结构单元Id
										secondLevelMap.put(gSecondKey, bId + "," + bsSecondId + "," + parcelId);
										// 插入建筑结构表(单元)
										BuildingStructureNew bsnSecond = new BuildingStructureNew();// 保存到建筑结构表
										bsnSecond.setProjectId(projectId);
										bsnSecond.setId(bsSecondId);
										bsnSecond.setNodeName(secondNodeName);
										bsnSecond.setBuildingId(bId);
										bsnSecond.setParentId(bsId);
										bsnSecond.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
										bsnSecond.setParcelId(parcelId);
										bsnSecond.setIsBindingAssets((byte)0);
										bsNewList.add(bsnSecond);
									}
								}
							}
						}
					}
					// 插入子节点数据、根据房屋用途插入住宅商铺车位
					int count = 0;
					// 查询出所有sip账户集合
					List<Sipmanage> sipList = sipmanageMapper.listSipmanageByState();
					final List<HouseNew> houseList = new ArrayList<HouseNew>();
					final List<StallNew> stallList = new ArrayList<StallNew>();
					final List<StoreNew> storeList = new ArrayList<StoreNew>();
					final List<AssetAccount> accountList = new ArrayList<AssetAccount>();
					
					//查询所有的资产账户  王洲  2016.04.19
					List<AssetAccount> assetList = assetAccountMapper.listAllAssetAccount();
					int assetNum = 0;
					if(assetList != null){
						assetNum = assetList.size() > 0 ? 10000 + assetList.size() : 10000;			
					}else{
						assetNum = 10000;
					}
					
					int errnum = 0,assetcount = 0;
					for (Map<Short, String> t : finalList) {
						// 获取项目名称、区号（期号）、栋作为顶级节点的唯一标识
						String projectName = t.get((short) 1);// 项目名称
						String areaNum = t.get((short) 5);// 区号
						String buildingNum = t.get((short) 6);// 栋号
						String seatNum = t.get((short) 7);// 座号
						String unitNum = t.get((short) 8);// 单元号
						String floorNum = t.get((short) 9);// 楼屋号或者车位楼层号
						String houseNum = t.get((short) 10);// 房号或者车位号
						String homeType = t.get((short) 11);// 房屋用途
						String fullName = "";
						boolean isStallFlag = false;// 判断是否是车位相关建筑信息，如果是，则不生成二级节点，不是，则生成二级节点
						if ("车位".equals(homeType)) {
							isStallFlag = true;
						}
						if (isStallFlag) {
							fullName = areaNum + "区" + buildingNum + "栋" + floorNum + "层" + houseNum + "号";
						} else {
							if (StringUtils.isNotEmpty(houseNum) && "0".equals(String.valueOf(houseNum.charAt(0)))) {
								houseNum = houseNum.substring(1);
							}
							if ("0".equals(seatNum)) {
								fullName = areaNum + "区" + buildingNum + "栋" + unitNum + "单元" + floorNum + houseNum
										+ "房";
							} else {
								fullName = areaNum + "区" + buildingNum + "栋" + seatNum + "座" + unitNum + "单元" + floorNum
										+ houseNum + "房";
							}
						}

						List<BuildingStructureNew> existList = buildingStructureNewMapper
								.getBuildingStructureNewByfullName(fullName);
						if (existList != null && existList.size() > 0) {
							errnum++;
							continue;
						} else {
							if (isStallFlag) {
								String mapValue = "";
								String gSecondKey = projectName + areaNum + buildingNum + floorNum;
								for (String sMapKey : secondLevelMap.keySet()) {
									if (gSecondKey.equals(sMapKey)) {
										mapValue = secondLevelMap.get(gSecondKey);
										break;
									}
								}
								BuildingStructureNew bsnThird = new BuildingStructureNew();// 保存到建筑结构表
								String bsThirdId = UUID.randomUUID().toString();
								String[] mapValueArr = mapValue.split(",");
								if (StringUtils.isNotEmpty(mapValue)) {
									bsnThird.setBuildingId(mapValueArr[0]);
									bsnThird.setParentId(mapValueArr[1]);
									bsnThird.setParcelId(mapValueArr[2]);
								}
								bsnThird.setProjectId(projectId);
								bsnThird.setId(bsThirdId);
								bsnThird.setIsBindingAssets((byte) 0);
								
								 //if(StringUtils.isNotEmpty(houseNum)){ int pos
								 // = 0; for (int i = 0; i < houseNum.length();
								 //i++) { String c =
								 //String.valueOf(houseNum.charAt(i));
								 //if(!"0".equals(c)){ houseNum =
								 //houseNum.substring(i); break; } } }
								 
								bsnThird.setNodeName(houseNum + "号");
								bsnThird.setFullName(fullName);
								bsnThird.setBuildingType("车位");
								bsnThird.setAreaId(areaTypeMap.get("parkspace"));
								bsNewList.add(bsnThird);
								// 保存到车位表中
								StallNew stall = new StallNew();
								stall.setStallId(UUID.randomUUID().toString());
								stall.setBuildingId(mapValueArr[0]);
								stall.setBuildingStructureId(bsThirdId);
								stall.setProjectId(projectId);
								//根据是否入伙状态保存参数
								if(isFinish == "1"){
									stall.setRentState((byte) 1);
									stall.setIntakeState((byte) 1);
								}else{
									stall.setRentState((byte) 0);
									stall.setIntakeState((byte) 0);
								}
								stallList.add(stall);
								
								AssetAccount assetAccount = new AssetAccount();
								assetAccount.setAssetAccountId(UUID.randomUUID().toString());
								assetAccount.setBuildingId(bsThirdId);
								assetAccount.setFullName(fullName);
								assetAccount.setAssetAccountNum("stall" + String.valueOf(assetNum + assetcount));
								assetAccount.setIsBankCard((byte)0);
								assetAccount.setProjectId(projectId);
								assetAccount.setAssetAccountBalance((double)0);
								assetAccount.setAssetAccountType((byte)2);
								assetAccount.setTotalDeposits((double)0);
								assetAccount.setTotalRefundableDeposit((double)0);
								assetAccount.setGeneralBalance((double)0);
								accountList.add(assetAccount);
								assetcount++;
								
							} else {
								String gSecondKey = projectName + areaNum + buildingNum + unitNum;
								String mapValue = "";
								for (String sMapKey : secondLevelMap.keySet()) {
									if (gSecondKey.equals(sMapKey)) {
										mapValue = secondLevelMap.get(gSecondKey);
										break;
									}
								}
								BuildingStructureNew bsnThird = new BuildingStructureNew();// 保存到建筑结构表
								String bsThirdId = UUID.randomUUID().toString();
								String[] mapValueArr = mapValue.split(",");
								if (StringUtils.isNotEmpty(mapValue)) {
									bsnThird.setBuildingId(mapValueArr[0]);
									bsnThird.setParentId(mapValueArr[1]);
									bsnThird.setParcelId(mapValueArr[2]);
								}
								bsnThird.setProjectId(projectId);
								bsnThird.setId(bsThirdId);
								bsnThird.setIsBindingAssets((byte) 0);
								bsnThird.setBuildingType(homeType);
								if("住宅".equals(homeType)){
									bsnThird.setAreaId(areaTypeMap.get("house"));
								}else{
									bsnThird.setAreaId(areaTypeMap.get("store"));
								}
								bsnThird.setNodeName(floorNum + houseNum + "房");
								bsnThird.setFullName(fullName);
								bsNewList.add(bsnThird);

								if (StringUtils.isNotEmpty(homeType)) {
									for (AreaTypeNew areaTypeNew : areaTypeList) {
										if ("住宅".equals(homeType) && homeType.equals(areaTypeNew.getAreaTypeName())) {
											HouseNew house = new HouseNew();
											house.setId(UUID.randomUUID().toString());
											house.setBuildingId(mapValueArr[0]);
											house.setBuildingStructureId(bsThirdId);
											house.setProjectId(projectId);
											house.setHouseAddress(fullName);
											//根据是否入伙状态保存参数
											if(isFinish == "1"){
												house.setJoinState((byte) 1);
												house.setJoinGangState((byte) 1);
											}else{
												house.setJoinState((byte) 0);
												house.setJoinGangState((byte) 0);
											}
											String sipId = "";
											if(sipList.size() > count){
												sipId = sipList.get(count).getSipId();
											}
											house.setSipId(sipId);
											//sip使用完之后修改对应sip的状态，使之失效
											sipmanageMapper.updateStateBySipId(sipId);
											count++;
											sipId = "";
											if(sipList.size() > count){
												sipId = sipList.get(count).getSipId();
											}
											house.setIndoorSipId(sipId);
											sipmanageMapper.updateStateBySipId(sipId);
											count ++;
											house.setPassword("123456");
											houseList.add(house);
											
											AssetAccount assetAccount = new AssetAccount();
											assetAccount.setAssetAccountId(UUID.randomUUID().toString());
											assetAccount.setBuildingId(bsThirdId);
											assetAccount.setFullName(fullName);
											assetAccount.setAssetAccountNum("house" + String.valueOf(assetNum + assetcount));
											assetAccount.setIsBankCard((byte)0);
											assetAccount.setProjectId(projectId);
											assetAccount.setAssetAccountBalance((double)0);
											assetAccount.setAssetAccountType((byte)0);
											assetAccount.setTotalDeposits((double)0);
											assetAccount.setTotalRefundableDeposit((double)0);
											assetAccount.setGeneralBalance((double)0);
											accountList.add(assetAccount);
											assetcount++;
											
											break;
										}
										if ("商铺".equals(homeType) && homeType.equals(areaTypeNew.getAreaTypeName())) {
											StoreNew store = new StoreNew();
											store.setStoreId(UUID.randomUUID().toString());
											store.setBuildingId(mapValueArr[0]);
											store.setBuildingStructureId(bsThirdId);
											store.setProjectId(projectId);
											//根据是否入伙状态保存参数
											if(isFinish == "1"){
												store.setIntakeState((byte) 1);
											}else{
												store.setIntakeState((byte) 0);
											}
											storeList.add(store);
											break;
										}
									}
								}
							}
						}
					}
					final String key = UUID.randomUUID().toString();
					if(bsNewList.size() == 0){
						MapUtils.getMap().put(key, 0 + "|" + 0);
					}else{
						Runnable th = new Runnable() {
							@Override
							public void run() {
								int bnum = 0;
								int housenum = 0;
								int storenum = 0;
								int stallnum = 0;
								int aanum = 0;
								if (baseDataList.size() > 0) {
									bnum = buildingNewMapper.insertList(baseDataList);
								}
								int totalNum = bsNewList.size();
								int bsnum = 0;
								for (BuildingStructureNew buildingStructureNew : bsNewList) {
									buildingStructureNewMapper.insertBuildingStructureNewSpec(buildingStructureNew);
									bsnum++;
									MapUtils.getMap().put(key, bsnum + "|" + totalNum);

								}
								if (houseList.size() > 0) {
									housenum = houseNewMapper.insertList(houseList);
								}
								if (storeList.size() > 0) {
									storenum = storeNewMapper.insertList(storeList);
								}
								if (stallList.size() > 0) {
									stallnum = stallNewMapper.insertList(stallList);
								}
								if(accountList.size() > 0){
									aanum = assetAccountMapper.insertAssetAccountList(accountList);
								}
							}
						};
						Thread t = new Thread(th);
						t.start();
					}
					return Tools.msg(key, true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}*/
	public Info importDataFromExcelFile(Annex annex) {
		String filePath = annex.getAnnexAddress();
		String projectId = annex.getProjectId();
		String isFinish = annex.getIsFinish();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (Tools.notEmpty(filePath)) {
			try {
				String fileName = annex.getAnnexName();
				String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
				String parcelId = "";
				// 获取该项目下的所有宗地列表信息
				List<Parcel> parcelList = new ArrayList<Parcel>();
				List<Map<Short, String>> bsnDataList = null;
				
				List<Map<Short, String>> areaDataList = null;
				if ("xls".equals(prefix)) {
					bsnDataList = new ExcelUtils().readExcel(filePath,0);
					areaDataList = new ExcelUtils().readExcel(filePath,1);
				}
				if ("xlsx".equals(prefix)) {
					bsnDataList = new ExcelUtils().readExcelXlsx(filePath,0);
					areaDataList = new ExcelUtils().readExcelXlsx(filePath,1);
				}
				
				
				
				final List<BuildingNew> baseDataList = new ArrayList<BuildingNew>();// 建筑列表
				final List<BuildingStructureNew> bsNewList = new ArrayList<BuildingStructureNew>();// 建筑结构列表
				final List<AreaNew> areaNewList = new ArrayList<AreaNew>();
				
				final List<HouseNew> houseList = new ArrayList<HouseNew>();
				final List<StallNew> stallList = new ArrayList<StallNew>();
				final List<StoreNew> storeList = new ArrayList<StoreNew>();
				final List<AssetAccount> accountList = new ArrayList<AssetAccount>();
				
				parcelList = parcelMapper.selectByProjectId(projectId);
				//区域信息
				List<AreaNew> areaList = new ArrayList<AreaNew>();
				List<AreaTypeNew> areaTypeList = new ArrayList<AreaTypeNew>();
				Map<String, String> areaTypeMap = new HashMap<String, String>();
				
				
				for(AreaTypeNew at : areaTypeList){
					areaTypeMap.put(at.getAreaTypeCode(), at.getId());
				}
				areaTypeList = areaTypeNewMapper.listAllAreaTypeNew();
				
				// 保存excel编号和栋主键的map
				Map<String, String> oneLevelMap = new HashMap<String, String>();
				
				if (bsnDataList != null && bsnDataList.size() > 0) {
					
					
					/**
					 * 住宅和商业：保存excel编号和单元主键的map; 车位：保存楼层或者车库的主键map
					 */
					Map<String, String> secondLevelMap = new HashMap<String, String>();
					// 最终被录入到数据库的满足宗地号在对应项目下的记录
					List<Map<Short, String>> finalList = new ArrayList<Map<Short, String>>();
					for (Map<Short, String> t : bsnDataList) {
						String parcelNum = t.get((short) 4);// 住宅、商业、车位的宗地编号
						if (StringUtils.isNotEmpty(parcelNum)) {
							parcelId = "";
							boolean parcelExist = false;
							for (Parcel p : parcelList) {
								if (parcelNum.equals(p.getParcelNum())) {
									parcelExist = true;
									parcelId = p.getParcelId();
									break;
								}
							}
							// 如果该条记录的宗地编号在项目中的宗地编号内，进行后续操作
							if (parcelExist) {
								finalList.add(t);
								// 获取项目名称、区号（期号）、栋作为顶级节点的唯一标识
								String projectName = t.get((short) 1);// 项目名称
								String houseName = t.get((short) 3);// 房屋名称
								String areaNum = t.get((short) 5);// 区号
								String buildingNum = t.get((short) 6);// 栋号
								String seatNum = t.get((short) 7);// 座号
								String unitNum = t.get((short) 8);// 单元号
								String floorNum = t.get((short) 9);// 楼屋号或者车位楼层号
								String houseNum = t.get((short) 10);// 房号或者车位号
								String homeType = t.get((short) 11);// 房屋用途
								
								if(areaNum==null||"".equals(areaNum)){
									continue;
								}
								
/*								String areaTypeName = t.get((short) 12);// 区域名称  = 区号+栋号 */
								
								/***
								 * @@edit 
								 * 导入新增  建筑面积 实用率 套内面积。
								 * 1，判断宗地编号是否存在，存在进行下一步。否则导入失败。
								 * 2，取出 是否建筑标识 判断是否是建筑。
								 * 3，如果是：则应该向对应的数据库插入数据（tc_building ？,tc_area）否则处理下一条记录。
								 * 4，插入数据之前判断是否存在该数据。
								 */
								
								String isBuilding = t.get((short) 12);// 是否建筑
								String buildingArea = t.get((short) 13);// 建筑面积
								String utilityRatio = t.get((short) 14);// 实用率
								String commonalityArea = t.get((short) 15);// 套内面积

								String groupKey = projectName + areaNum + buildingNum;// 一级节点Key
								String gSecondKey = "";// 二级节点
								boolean isStallFlag = false;// 判断是否是车位信息
								if ("车位".equals(homeType)) {
									isStallFlag = true;
									gSecondKey = groupKey + floorNum;// 车位上级key
								} else {
									gSecondKey = groupKey + unitNum;// 房屋上级Key
								}							

								// 判断该条记录拼接的Key是否已经保存到一级节点Map中，如果没有该条key则拼接建筑名称，
								// 去建筑表查看是否有对应的建筑信息，如果有则取出建筑ID，查询建筑结构表，
								// 获取建筑结构ID，并将相关信息保存到map中,如果没有，则在程序中新增该条建筑记录和建筑结构记录，并将生成的相关信息保存到一级Key中
								if (oneLevelMap.size() > 0) {
									boolean hasKey = false;
									for (String gKey : oneLevelMap.keySet()) {
										if (groupKey.equals(gKey)) {
											hasKey = true;
											break;
										}
									}
									if (!hasKey) {
										// 查看建筑表中是否有对应信息，如果有，则取出，没有，则程序生成
										BuildingNew b = buildingNewMapper
												.getBuildingNewByBuildingNameAndParcelId(areaNum + "区" + buildingNum + "栋",parcelId);
										
										//取出建筑信息，判断是否存在该建筑 if not exists：添加建筑信息，并录入区域面积信息
										//if exists
										
										if (b != null) {
											// 如果有记录，则肯定有对应的建筑结构一级记录，二级记录是否存在还不清楚
											BuildingStructureNew bsn = buildingStructureNewMapper
													.getBuildingStructureByBuildingId(b.getId());
											oneLevelMap.put(groupKey, b.getId() + "," + bsn.getId() + "," + parcelId);

											// 根据获取到的建筑结构一级节点信息，查看是否有二级节点已经存在
											List<BuildingStructureNew> list = buildingStructureNewMapper
													.getBuildingStructureNewByparentId(bsn.getId());
											String secondNodeName = "";
											if (isStallFlag) {
												secondNodeName = floorNum + "层";
											} else {
												secondNodeName = unitNum + "单元";
											}
											boolean isSecondFlag = false;
											for (BuildingStructureNew buildingStructureNew : list) {
												if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
													secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
															+ "," + buildingStructureNew.getId() + "," + parcelId);
													isSecondFlag = true;
													break;
												}
											}
											if (!isSecondFlag) {
												String bsNewId = UUID.randomUUID().toString();
												BuildingStructureNew bsnNew = new BuildingStructureNew();
												bsnNew.setBuildingId(b.getId());
												bsnNew.setId(bsNewId);
												bsnNew.setParentId(bsn.getId());
												bsnNew.setProjectId(projectId);
												bsnNew.setNodeName(secondNodeName);
												bsnNew.setIsBindingAssets((byte)0);
												bsnNew.setParcelId(parcelId);
												secondLevelMap.put(gSecondKey,
														b.getId() + "," + bsNewId + "," + parcelId);
												bsNewList.add(bsnNew);
											}
										} else {
											String bId = UUID.randomUUID().toString();// 建筑Id
											String bsId = UUID.randomUUID().toString();// 建筑结构栋Id

											BuildingNew bn = new BuildingNew();// 保存到建筑表
											bn.setId(bId);
											bn.setParcelId(parcelId);
											bn.setProjectId(projectId);
											bn.setBuildingName(areaNum + "区" + buildingNum + "栋");
											baseDataList.add(bn);

											// 插入建筑结构表
											BuildingStructureNew bsn = new BuildingStructureNew();// 保存到建筑结构表
											bsn.setBuildingId(bId);
											bsn.setProjectId(projectId);
											bsn.setId(bsId);
											//bsn.setParentId(null);
											bsn.setNodeName(areaNum + "区" + buildingNum + "栋");
											bsn.setFullName(areaNum + "区" + buildingNum + "栋");
											bsn.setIsBindingAssets((byte)0);
											bsn.setParcelId(parcelId);
											bsNewList.add(bsn);

											oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

											String secondNodeName = "";
											if (isStallFlag) {
												secondNodeName = floorNum + "层";
											} else {
												secondNodeName = unitNum + "单元";
											}
											String bsSecondId = UUID.randomUUID().toString();// 建筑结构单元Id

											// 插入建筑结构表
											BuildingStructureNew bsnSecond = new BuildingStructureNew();// 保存到建筑结构表
											bsnSecond.setBuildingId(bId);
											bsnSecond.setProjectId(projectId);
											bsnSecond.setId(bsSecondId);
											bsnSecond.setParentId(bsId);
											bsnSecond.setFullName(areaNum + "区" + buildingNum + "栋"+secondNodeName);
											bsnSecond.setNodeName(secondNodeName);
											bsnSecond.setIsBindingAssets((byte)0);
											bsnSecond.setParcelId(parcelId);
											bsNewList.add(bsnSecond);

											secondLevelMap.put(gSecondKey, bId + "," + bsSecondId + "," + parcelId);
										}
									} else {
										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										boolean hasSecondKey = false;
										for (String sKey : secondLevelMap.keySet()) {
											if (gSecondKey.equals(sKey)) {
												hasSecondKey = true;
												break;
											}
										}
										if (!hasSecondKey) {
											String bId = oneLevelMap.get(groupKey).split(",")[0];
											String parentId = oneLevelMap.get(groupKey).split(",")[1];
											List<BuildingStructureNew> list = buildingStructureNewMapper
													.getBuildingStructureNewByparentId(parentId);

											boolean isSecondFlag = false;
											for (BuildingStructureNew buildingStructureNew : list) {
												if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
													secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
															+ "," + buildingStructureNew.getId() + "," + parcelId);
													isSecondFlag = true;
													break;
												}
											}
											if (!isSecondFlag) {
												String bsNewId = UUID.randomUUID().toString();
												BuildingStructureNew bsnNew = new BuildingStructureNew();
												bsnNew.setBuildingId(bId);
												bsnNew.setId(bsNewId);
												bsnNew.setParentId(parentId);
												bsnNew.setProjectId(projectId);
												bsnNew.setNodeName(secondNodeName);
												bsnNew.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
												bsnNew.setIsBindingAssets((byte)0);
												bsnNew.setParcelId(parcelId);
												bsNewList.add(bsnNew);
												secondLevelMap.put(gSecondKey, bId + "," + bsNewId + "," + parcelId);
											}
										}
									}
								} else {
									String bId = "";// 建筑Id
									String bsId = "";// 建筑结构栋Id

//									BuildingNew b = buildingNewMapper.getBuildingNewByBuildingName(areaNum + "区" + buildingNum + "栋");
									BuildingNew b = buildingNewMapper.getBuildingNewByBuildingNameAndParcelId(areaNum + "区" + buildingNum + "栋",parcelId);

									if (b != null) {
										BuildingStructureNew bsn = buildingStructureNewMapper.getBuildingStructureByBuildingId(b.getId());
										
										if(bsn==null){
											bsId =  UUID.randomUUID().toString();
											
											// 插入建筑结构表
											bsn = new BuildingStructureNew();// 保存到建筑结构表
											bsn.setId(bsId);
											bsn.setBuildingId(bId);
											bsn.setProjectId(projectId);
											bsn.setId(bsId);
											bsn.setParentId(null);
											bsn.setNodeName(areaNum + "区" + buildingNum + "栋");
											bsn.setFullName(areaNum + "区" + buildingNum + "栋");
											bsn.setIsBindingAssets((byte)0);
											bsn.setParcelId(parcelId);
											bsNewList.add(bsn);
											oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);
										}else{
											bsId = bsn.getId();
										}
										
										bId = b.getId();
										//bsId = bsn.getId();
										oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

										// 根据获取到的建筑结构一级节点信息，查看是否有二级节点已经存在
										List<BuildingStructureNew> list = buildingStructureNewMapper
												.getBuildingStructureNewByparentId(bsId);
										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										boolean isSecondFlag = false;
										for (BuildingStructureNew buildingStructureNew : list) {
											if (secondNodeName.equals(buildingStructureNew.getNodeName())) {
												secondLevelMap.put(gSecondKey, buildingStructureNew.getBuildingId()
														+ "," + buildingStructureNew.getId() + "," + parcelId);
												isSecondFlag = true;
												break;
											}
										}
										if (!isSecondFlag) {
											String bsNewId = UUID.randomUUID().toString();
											BuildingStructureNew bsnNew = new BuildingStructureNew();
											bsnNew.setBuildingId(b.getId());
											bsnNew.setId(bsNewId);
											bsnNew.setParentId(bsId);
											bsnNew.setProjectId(projectId);
											bsnNew.setNodeName(secondNodeName);
											bsnNew.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
											bsnNew.setIsBindingAssets((byte)0);
											bsnNew.setParcelId(parcelId);
											bsNewList.add(bsnNew);
											secondLevelMap.put(gSecondKey, b.getId() + "," + bsNewId + "," + parcelId);
										}
									} else {
										bId = UUID.randomUUID().toString();//建筑Id
										bsId = UUID.randomUUID().toString();//建筑结构Id
										BuildingNew bn = new BuildingNew();// 保存到建筑表
										bn.setId(bId);
										bn.setParcelId(parcelId);
										bn.setProjectId(projectId);
										bn.setBuildingName(areaNum + "区" + buildingNum + "栋");
										baseDataList.add(bn);

										// 插入建筑结构表
										BuildingStructureNew bsn = new BuildingStructureNew();// 保存到建筑结构表
										bsn.setBuildingId(bId);
										bsn.setProjectId(projectId);
										bsn.setId(bsId);
										bsn.setParentId(null);
										bsn.setNodeName(areaNum + "区" + buildingNum + "栋");
										bsn.setFullName(areaNum + "区" + buildingNum + "栋");
										bsn.setIsBindingAssets((byte)0);
										bsn.setParcelId(parcelId);
										bsNewList.add(bsn);
										oneLevelMap.put(groupKey, bId + "," + bsId + "," + parcelId);

										String secondNodeName = "";
										if (isStallFlag) {
											secondNodeName = floorNum + "层";
										} else {
											secondNodeName = unitNum + "单元";
										}
										String bsSecondId = UUID.randomUUID().toString();// 建筑结构单元Id
										secondLevelMap.put(gSecondKey, bId + "," + bsSecondId + "," + parcelId);
										// 插入建筑结构表(单元)
										BuildingStructureNew bsnSecond = new BuildingStructureNew();// 保存到建筑结构表
										bsnSecond.setProjectId(projectId);
										bsnSecond.setId(bsSecondId);
										bsnSecond.setNodeName(secondNodeName);
										bsnSecond.setBuildingId(bId);
										bsnSecond.setParentId(bsId);
										bsnSecond.setFullName(areaNum + "区" + buildingNum + "栋" + secondNodeName);
										bsnSecond.setParcelId(parcelId);
										bsnSecond.setIsBindingAssets((byte)0);
										bsNewList.add(bsnSecond);
									}
								}
							}
						}
					}
					// 插入子节点数据、根据房屋用途插入住宅商铺车位
					int count = 0;
					// 查询出所有sip账户集合
					List<Sipmanage> sipList = sipmanageMapper.listSipmanageByState();
					
					
					
					//查询所有的资产账户  王洲  2016.04.19
					List<AssetAccount> assetList = assetAccountMapper.listAllAssetAccount();
					int assetNum = 0;
					if(assetList != null){
						assetNum = assetList.size() > 0 ? 10000 + assetList.size() : 10000;			
					}else{
						assetNum = 10000;
					}
					
					int errnum = 0,assetcount = 0;
					for (Map<Short, String> t : finalList) {
						// 获取项目名称、区号（期号）、栋作为顶级节点的唯一标识
						String projectName = t.get((short) 1);// 项目名称
						String areaNum = t.get((short) 5);// 区号
						String buildingNum = t.get((short) 6);// 栋号
						String seatNum = t.get((short) 7);// 座号
						String unitNum = t.get((short) 8);// 单元号
						String floorNum = t.get((short) 9);// 楼屋号或者车位楼层号
						String houseNum = t.get((short) 10);// 房号或者车位号
						String homeType = t.get((short) 11);// 房屋用途
						
						//2016/7/5 ylq
						//String buildingFlag = t.get((short) 12);// 建筑标识
						String buildingArea = t.get((short) 13);// 建筑面积
						String shareArea = t.get((short) 14);// 公摊面积
						String usableArea = t.get((short) 15);//套内面积
						String completeArea = t.get((short) 16);// 竣工面积
						String completeDate = t.get((short) 17);// 竣工日期
						String buildingAttribute = t.get((short) 18);// 楼房属性/车位属性/商业属性
						String houseType = t.get((short) 19);// 房屋户型/机械车位
						String saleState = t.get((short) 20);// 销售状态
						
						String parcelNum = t.get((short) 4);// 住宅、商业、车位的宗地编号
						parcelId = "";
						boolean parcelExist = false;
						for (Parcel p : parcelList) {
							if (parcelNum.equals(p.getParcelNum())) {
								parcelExist = true;
								parcelId = p.getParcelId();
								break;
							}
						}
						
						String buildNum = t.get((short) 2);// 编码
						String buildSNo = t.get((short) 10);//房号/车位号/商铺编号 序号
						
						
						String fullName = "";
						boolean isStallFlag = false;// 判断是否是车位相关建筑信息，如果是，则不生成二级节点，不是，则生成二级节点
						if ("车位".equals(homeType)) {
							isStallFlag = true;
						}
						if (isStallFlag) {
							fullName = areaNum + "区" + buildingNum + "栋" + floorNum + "层" + houseNum + "号";
						} else {
							if (StringUtils.isNotEmpty(houseNum) && "0".equals(String.valueOf(houseNum.charAt(0)))) {
								houseNum = houseNum.substring(1);
							}
							if ("0".equals(seatNum)) {
								fullName = areaNum + "区" + buildingNum + "栋" + unitNum + "单元" + floorNum + houseNum
										+ "房";
							} else {
								fullName = areaNum + "区" + buildingNum + "栋" + seatNum + "座" + unitNum + "单元" + floorNum
										+ houseNum + "房";
							}
						}

//						List<BuildingStructureNew> existList = buildingStructureNewMapper
//								.getBuildingStructureNewByfullName(fullName);
						List<BuildingStructureNew> existList = buildingStructureNewMapper
								.getBuildingStructureNewByFullNameAndParcelId(fullName,parcelId);
						if (existList != null && existList.size() > 0) {
							errnum++;
							continue;
						} else {
							if (isStallFlag) {
								String mapValue = "";
								String gSecondKey = projectName + areaNum + buildingNum + floorNum;
								for (String sMapKey : secondLevelMap.keySet()) {
									if (gSecondKey.equals(sMapKey)) {
										mapValue = secondLevelMap.get(gSecondKey);
										break;
									}
								}
								BuildingStructureNew bsnThird = new BuildingStructureNew();// 保存到建筑结构表
								String bsThirdId = UUID.randomUUID().toString();
								String[] mapValueArr = mapValue.split(",");
								if (StringUtils.isNotEmpty(mapValue)) {
									bsnThird.setBuildingId(mapValueArr[0]);
									bsnThird.setParentId(mapValueArr[1]);
									bsnThird.setParcelId(mapValueArr[2]);
								}
								bsnThird.setProjectId(projectId);
								bsnThird.setId(bsThirdId);
								bsnThird.setIsBindingAssets((byte) 0);
								/*
								 * if(StringUtils.isNotEmpty(houseNum)){ int pos
								 * = 0; for (int i = 0; i < houseNum.length();
								 * i++) { String c =
								 * String.valueOf(houseNum.charAt(i));
								 * if(!"0".equals(c)){ houseNum =
								 * houseNum.substring(i); break; } } }
								 */
								bsnThird.setNodeName(houseNum + "号");
								bsnThird.setFullName(fullName);
								bsnThird.setBuildingType("车位");
								bsnThird.setAreaId(areaTypeMap.get("parkspace"));
								bsNewList.add(bsnThird);
								// 保存到车位表中
								StallNew stall = new StallNew();
								stall.setStallId(UUID.randomUUID().toString());
								stall.setBuildingId(mapValueArr[0]);
								stall.setBuildingStructureId(bsThirdId);
								stall.setProjectId(projectId);
								//根据是否入伙状态保存参数
								if(isFinish == "1"){
									stall.setRentState((byte) 1);
								}else{
									stall.setRentState((byte) 0);
								}
								
								
								stall.setStallProperty(buildingAttribute);
								
								try{
									stall.setE_intakeDate(completeDate);
								}catch(Exception e){
									//TODO 日期格式未验证
								}
								if("已售".equals(saleState)){
									stall.setIntakeState((byte)1);
								}else{
									stall.setIntakeState((byte)0);
								}
								
								if("是".equals(houseType)){
									stall.setIsMechanicalStall("1");
								}else{
									stall.setIsMechanicalStall("0");
								}
								
								stall.setStallCoding(buildNum);
								stall.setStallNumber(buildSNo);
								
								stallList.add(stall);
								
								AssetAccount assetAccount = new AssetAccount();
								assetAccount.setAssetAccountId(UUID.randomUUID().toString());
								assetAccount.setBuildingId(bsThirdId);
								assetAccount.setFullName(fullName);
								assetAccount.setAssetAccountNum("stall" + String.valueOf(assetNum + assetcount));
								assetAccount.setIsBankCard((byte)0);
								assetAccount.setProjectId(projectId);
								assetAccount.setAssetAccountBalance((double)0);
								assetAccount.setAssetAccountType((byte)2);
								assetAccount.setTotalDeposits((double)0);
								assetAccount.setTotalRefundableDeposit((double)0);
								assetAccount.setGeneralBalance((double)0);
								accountList.add(assetAccount);
								assetcount++;
								
							} else {
								String gSecondKey = projectName + areaNum + buildingNum + unitNum;
								String mapValue = "";
								for (String sMapKey : secondLevelMap.keySet()) {
									if (gSecondKey.equals(sMapKey)) {
										mapValue = secondLevelMap.get(gSecondKey);
										break;
									}
								}
								BuildingStructureNew bsnThird = new BuildingStructureNew();// 保存到建筑结构表
								String bsThirdId = UUID.randomUUID().toString();
								String[] mapValueArr = mapValue.split(",");
								if (StringUtils.isNotEmpty(mapValue)) {
									bsnThird.setBuildingId(mapValueArr[0]);
									bsnThird.setParentId(mapValueArr[1]);
									bsnThird.setParcelId(mapValueArr[2]);
								}
								bsnThird.setProjectId(projectId);
								bsnThird.setId(bsThirdId);
								bsnThird.setIsBindingAssets((byte) 0);
								bsnThird.setBuildingType(homeType);
								if("住宅".equals(homeType)){
									bsnThird.setAreaId(areaTypeMap.get("house"));
								}else{
									bsnThird.setAreaId(areaTypeMap.get("store"));
								}
								bsnThird.setNodeName(floorNum + houseNum + "房");
								bsnThird.setFullName(fullName);
								bsNewList.add(bsnThird);

								if (StringUtils.isNotEmpty(homeType)) {
									for (AreaTypeNew areaTypeNew : areaTypeList) {
										if ("住宅".equals(homeType) && homeType.equals(areaTypeNew.getAreaTypeName())) {
											HouseNew house = new HouseNew();
											house.setId(UUID.randomUUID().toString());
											house.setBuildingId(mapValueArr[0]);
											house.setBuildingStructureId(bsThirdId);
											house.setProjectId(projectId);
											house.setHouseAddress(fullName);
											//根据是否入伙状态保存参数
											if(isFinish == "1"){
												house.setJoinState((byte) 1);
												house.setJoinGangState((byte) 1);
											}else{
												house.setJoinState((byte) 0);
												house.setJoinGangState((byte) 0);
											}
											
											house.setSaleState(saleState);
											house.setHouseNum(buildNum);

											if("多层".equals(buildingAttribute) || "小高层".equals(buildingAttribute) || "高层".equals(buildingAttribute)
													|| "超高层".equals(buildingAttribute)){
												house.setHouseAttribute(buildingAttribute);
											}else{
												//
											}
											
											Double shareAreaD = 0.0;
											Double buildingAreaD = 0.0;
											Double usableAreaD = 0.0;
											Double completeAreaD = 0.0;
											Date completeDateD = null;
											try{
												usableAreaD = Double.valueOf(usableArea);
												shareAreaD = Double.valueOf(shareArea);
												buildingAreaD = Double.valueOf(buildingArea);
												completeAreaD = Double.valueOf(completeArea);
												completeDateD = format.parse(completeDate);
											}catch(Exception e){
												shareAreaD = 0.0;
												buildingAreaD = 0.0;
												usableAreaD = 0.0;
												completeAreaD = 0.0;
											}
											
											house.setShareArea(shareAreaD);
											house.setBuildingArea(buildingAreaD.toString());
											house.setUsableArea(usableAreaD);
											house.setCompleteArea(completeAreaD);
											house.setHouseArea(buildingAreaD);
											
											house.setHouseType(houseType);
											house.setCompleteDate(completeDateD);
											
											
											String sipId = "";
											if(sipList.size() > count){
												sipId = sipList.get(count).getSipId();
											}
											house.setSipId(sipId);
											//sip使用完之后修改对应sip的状态，使之失效
											sipmanageMapper.updateStateBySipId(sipId);
											count++;
											sipId = "";
											if(sipList.size() > count){
												sipId = sipList.get(count).getSipId();
											}
											house.setIndoorSipId(sipId);
											sipmanageMapper.updateStateBySipId(sipId);
											count ++;
											house.setPassword("123456");
											houseList.add(house);
											
											AssetAccount assetAccount = new AssetAccount();
											assetAccount.setAssetAccountId(UUID.randomUUID().toString());
											assetAccount.setBuildingId(bsThirdId);
											assetAccount.setFullName(fullName);
											assetAccount.setAssetAccountNum("house" + String.valueOf(assetNum + assetcount));
											assetAccount.setIsBankCard((byte)0);
											assetAccount.setProjectId(projectId);
											assetAccount.setAssetAccountBalance((double)0);
											assetAccount.setAssetAccountType((byte)0);
											assetAccount.setTotalDeposits((double)0);
											assetAccount.setTotalRefundableDeposit((double)0);
											assetAccount.setGeneralBalance((double)0);
											accountList.add(assetAccount);
											assetcount++;
											
											break;
										}
										if ("商铺".equals(homeType) && homeType.equals(areaTypeNew.getAreaTypeName())) {
											StoreNew store = new StoreNew();
											store.setStoreId(UUID.randomUUID().toString());
											store.setBuildingId(mapValueArr[0]);
											store.setBuildingStructureId(bsThirdId);
											store.setProjectId(projectId);
											
											//store.setSaleState(saleState);
											store.setStoreTyoe(buildingAttribute);
											
											Double shareAreaD = 0.0;
											Double buildingAreaD = 0.0;
											Double usableAreaD = 0.0;
											Double completeAreaD = 0.0;
											Date completeDateD = null;
											try{
												usableAreaD = Double.valueOf(usableArea);
												shareAreaD = Double.valueOf(shareArea);
												buildingAreaD = Double.valueOf(buildingArea);
												completeAreaD = Double.valueOf(completeArea);
												completeDateD = format.parse(completeDate);
												store.setE_intakeDate(format.format(completeDateD));
											}catch(Exception e){
												shareAreaD = 0.0;
												buildingAreaD = 0.0;
												usableAreaD = 0.0;
												completeAreaD = 0.0;
											}
											store.setStoreCode(buildNum);
											store.setStoreNumber(buildSNo);
											
											store.setCommonalityArea(shareAreaD);
											store.setBuildingArea(buildingAreaD);
											//@TODO FIXME 
											store.setUsableArea(usableAreaD);
											store.setInsideArea(usableAreaD);
											
											store.setCompletionArea(completeAreaD);
											store.setIntakeDate(completeDateD);
											//根据是否入伙状态保存参数
											if(isFinish == "1"){
												store.setIntakeState((byte) 1);
											}else{
												store.setIntakeState((byte) 0);
											}
											storeList.add(store);
											
											AssetAccount assetAccount = new AssetAccount();
											assetAccount.setAssetAccountId(UUID.randomUUID().toString());
											assetAccount.setBuildingId(bsThirdId);
											assetAccount.setFullName(fullName);
											assetAccount.setAssetAccountNum("store" + String.valueOf(assetNum + assetcount));
											assetAccount.setIsBankCard((byte)0);
											assetAccount.setProjectId(projectId);
											assetAccount.setAssetAccountBalance((double)0);
											assetAccount.setAssetAccountType((byte)0);
											assetAccount.setTotalDeposits((double)0);
											assetAccount.setTotalRefundableDeposit((double)0);
											assetAccount.setGeneralBalance((double)0);
											accountList.add(assetAccount);
											assetcount++;
											
											break;
										}
									}
								}
							}
						}
					}
					
					

				}
				
				//导入建筑信息
				if(areaDataList != null && areaDataList.size() > 0){
					for (Map<Short, String> t : areaDataList) {
						String parcelNum = t.get((short) 4);// 住宅、商业、车位的宗地编号
						if (StringUtils.isNotEmpty(parcelNum)) {
							parcelId = "";
							boolean parcelExist = false;
							for (Parcel p : parcelList) {
								if (parcelNum.equals(p.getParcelNum())) {
									parcelExist = true;
									parcelId = p.getParcelId();
									break;
								}
							}
						}
						if(parcelId==null || "".equals(parcelId)){
							continue;
						}
						// 获取项目名称、区号（期号）、栋作为顶级节点的唯一标识
						String projectName = t.get((short) 1);// 项目名称
						String houseName = t.get((short) 3);// 房屋名称
						String areaNum = t.get((short) 5);// 区号
						String buildingNum = t.get((short) 6);// 栋号
						String seatNum = t.get((short) 7);// 座号
						String unitNum = t.get((short) 8);// 单元号
						String floorNum = t.get((short) 9);// 楼屋号或者车位楼层号
						String houseNum = t.get((short) 10);// 房号或者车位号
						String homeType = t.get((short) 11);// 房屋用途
						
						
						String isBuilding = t.get((short) 12);// 是否建筑
						String buildingArea = t.get((short) 13);// 建筑面积
						String utilityRatio = t.get((short) 14);// 实用率
						String commonalityArea = t.get((short) 15);// 套内面积

						String groupKey = projectName + areaNum + buildingNum;// 一级节点Key
						String fullName="";
//						boolean isStallFlag = false;// 判断是否是车位信息
//						if ("车位".equals(homeType)) {
//							isStallFlag = true;
//						}
//						if (isStallFlag) {
//							fullName = areaNum + "区" + buildingNum + "栋" + floorNum + "层" + houseNum + "号";
//						} else {
//							if (StringUtils.isNotEmpty(houseNum) && "0".equals(String.valueOf(houseNum.charAt(0)))) {
//								houseNum = houseNum.substring(1);
//							}
//							if ("0".equals(seatNum)) {
//								fullName = areaNum + "区" + buildingNum + "栋" + unitNum + "单元" + floorNum + houseNum
//										+ "房";
//							} else {
//								fullName = areaNum + "区" + buildingNum + "栋" + seatNum + "座" + unitNum + "单元" + floorNum
//										+ houseNum + "房";
//							}
//						}
						fullName = areaNum + "区" + buildingNum + "栋";
						//添加建筑信息
//						BuildingNew build = buildingNewMapper.getBuildingNewByBuildingName(areaNum + "区" + buildingNum + "栋");
						BuildingNew build = buildingNewMapper.getBuildingNewByBuildingNameAndParcelId(areaNum + "区" + buildingNum + "栋",parcelId);
						
						String buildId = UUID.randomUUID().toString();
						
						Double buildingAreaD =  0.00;
						Double utilityRatioD =  0.00;
						Double commonalityAreaD =  0.00;
						AreaNew area=new AreaNew();
						area.setId(UUID.randomUUID().toString());
						try{
							buildingAreaD=Double.valueOf(buildingArea);
							utilityRatioD=Double.valueOf(utilityRatio);
							commonalityAreaD=Double.valueOf(commonalityArea);
						}catch(NumberFormatException e){
							buildingAreaD=0.00;
							utilityRatioD=0.00;
							commonalityAreaD=0.00;
						}
						
						if(build != null){
							buildId = build.getId();
						}else{
							if(oneLevelMap.containsKey(groupKey)){
								buildId=oneLevelMap.get(groupKey).split(",")[0];
							}
						}
						
						for(AreaTypeNew atNew : areaTypeList){
							if(homeType.equals(atNew.getAreaTypeName()))
							{
								area.setAreaTypeId(atNew.getId());
								break;
							}									
						}
						area.setBuildingId(buildId);
						area.setBuildingArea(buildingAreaD);
						area.setUtilityRatio(utilityRatioD);
						area.setCommonalityArea(commonalityAreaD);
						areaNewList.add(area);
					}
				}
				
				final String key = UUID.randomUUID().toString();
				if(bsNewList.size() == 0){
					MapUtils.getMap().put(key, 0 + "|" + 0);
				}else{
					Runnable th = new Runnable() {
						@Override
						public void run() {
							int bnum = 0;
							int housenum = 0;
							int storenum = 0;
							int stallnum = 0;
							int aanum = 0;
							int areanum=0;
							if (baseDataList.size() > 0) {
								bnum = buildingNewMapper.insertList(baseDataList);
							}
							int totalNum = bsNewList.size();
							int bsnum = 0;
							for (BuildingStructureNew buildingStructureNew : bsNewList) {
								buildingStructureNewMapper.insertBuildingStructureNewSpec(buildingStructureNew);
								bsnum++;
								MapUtils.getMap().put(key, bsnum + "|" + totalNum);

							}
							if (houseList.size() > 0) {
								housenum = houseNewMapper.insertList(houseList);
							}
							if (storeList.size() > 0) {
								storenum = storeNewMapper.insertList(storeList);
							}
							if (stallList.size() > 0) {
								stallnum = stallNewMapper.insertList(stallList);
							}
							if(accountList.size() > 0){
								aanum = assetAccountMapper.insertAssetAccountList(accountList);
							}

							if(areaNewList.size() > 0){
								areanum = areaNewMapper.insertList(areaNewList);
							}

						}
					};
					Thread t = new Thread(th);
					t.start();
				}
				return Tools.msg(key, true);
					
				
				/***
				 * 区域信息导入
				 */
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}
	
	//对搜索三条件
	public List<Node> selectThree(BuildingStructureNew bsn){
		List<String> parentS=new ArrayList<String>();
		List<Node> nodeList = new ArrayList<Node>();
		List<BuildingStructureNew> bsts=new ArrayList<BuildingStructureNew>();
		List<String> parentIds=new ArrayList<String>();//判断返回的数据是否重复
		if(bsn.getProjectId().equals(bsn.getParentId())){
			bsts= buildingStructureNewMapper.getCusNameAndEnterNameByBuS(bsn);
			for(int i=0;i<bsts.size();i++){
				if(!parentS.contains(bsts.get(i).getParentId())){
					//三级进行去重
					parentS.add(bsts.get(i).getParentId());
				}
			}
			for(int i=0;i<parentS.size();i++){
				//查询二级
				BuildingStructureNew b=buildingStructureNewMapper.getBuildingStructureByIdTree(parentS.get(i));
				//查询一级
				BuildingStructureNew bs=buildingStructureNewMapper.getBuildingStructureByIdTree(b.getParentId());
				if(!parentIds.contains(bs.getId())){
					Node n = new Node();
					n.setFullName(bs.getFullName());
					n.setId(bs.getId());
					n.setNodeName(bs.getNodeName());
					n.setParentId("");
					n.setProjectId(bs.getProjectId());
					n.setHasChildren(true);
					n.setNodeLevel("1");
					n.setIsParent("true");
					n.setNames("");
					nodeList.add(n);
					parentIds.add(bs.getId());
				}
			}
		}else{
			return getNodes(bsn);
		}
		return nodeList;
	}
	@Override
	public List<Node> findListByProAndParentId(BuildingStructureNew bsn) {
		List<Node> nodeList = new ArrayList<Node>();
		//当查询条件不为空，根据条件查询，
		List<BuildingStructureNew> bsts=new ArrayList<BuildingStructureNew>();
		List<BuildingStructureNew> bsnList = new ArrayList<BuildingStructureNew>();
		List<String> parentS=new ArrayList<String>();
		List<String> parentIds=new ArrayList<String>();//判断返回的数据是否重复
		
		//当建筑名称不为空，其他条件为空
		//所有条件都不为空，
	if(!bsn.getFullName().equals("")||!bsn.getName().equals("")||!bsn.getEnterpriseName().equals("")){	
		if(!bsn.getFullName().trim().equals("")){
			
			if(String.valueOf(bsn.getIsBindingAssets()).equals("3")){
				bsn.setIsBindingAssets(null);
			}else if(String.valueOf(bsn.getIsBindingAssets()).equals("1")){
			return 	nodeList=selectThree(bsn);
				
			}
			
			//只查询建筑名称
			if(bsn.getName().equals("")&&bsn.getEnterpriseName().equals("")){
				if(bsn.getProjectId().equals(bsn.getParentId())){
					bsts= buildingStructureNewMapper.getCusNameAndEnterNameByBuS(bsn);
					for(int i=0;i<bsts.size();i++){
						//当parentId 不为空，说明查询的条件只有是客户和企业
						if(bsts.get(i).getParentId()==null){
							bsnList.add(bsts.get(i));
						}
					}
						for(int i=0;i<bsnList.size();i++){
							Node n = new Node();
							BuildingStructureNew bsns=bsnList.get(i);
							n.setFullName(bsns.getFullName());
							n.setId(bsns.getId());
							n.setNodeName(bsns.getNodeName());
							n.setParentId("");
							n.setProjectId(bsns.getProjectId());
							n.setHasChildren(true);
							n.setNodeLevel("1");
							n.setIsParent("true");
							n.setNames("");
							nodeList.add(n);
						}
					}else{
						return getNodes(bsn);
					}
			}else{
				return selectThree(bsn);
			}
		}else {
			if(!bsn.getName().equals("")||!bsn.getEnterpriseName().equals("")){
				if(String.valueOf(bsn.getIsBindingAssets()).equals("3")){
					bsn.setIsBindingAssets(null);
				}
				nodeList=selectThree(bsn);
			}
		}
		}else{
			return getNodes(bsn);
		}
		return nodeList;
	}

	public List<Node> getNodes( BuildingStructureNew bsn){
		List<BuildingStructureNew> bsnList=new ArrayList<BuildingStructureNew>();
		List <Node>nodeList=new ArrayList<Node>();
		if (bsn.getProjectId().equals(bsn.getParentId())) {
			bsnList = buildingStructureNewMapper.getBuildingStructureNewbyProjectIdAndParentId1(bsn.getProjectId(), bsn.getParentId());
		} else {
			bsnList = buildingStructureNewMapper.getBuildingStructureNewbyProjectIdAndParentId(bsn.getProjectId(),bsn.getParentId());
		}
		/**
		 * 循环获取到的建筑结构信息，将前台所需信息放到Node节点中， 如果节点为叶子节点，则可以根据bsnId从资产绑定节点中查出并放到node中
		 */
		for (BuildingStructureNew buildingStructureNew : bsnList) {
			Node n = new Node();
			StringBuffer a = new StringBuffer();// 业主姓名
			StringBuffer b = new StringBuffer();// 业主证件号
			int count_cust = 0;
			int count_enter = 0;
			boolean hasChildren = false;//是否有子节点
			String bsnId = buildingStructureNew.getId();// 获取建筑结构的主键用于从建筑结构资产绑定表中获取数据
			List<PersonBuildingNew> pbnList = personBuildingNewMapper.getAllPersonBuildings(bsnId);
			List<BuildingStructureNew> childList = buildingStructureNewMapper.getBuildingStructureNewByparentId(bsnId);
			if(childList!= null && childList.size()>0){
				hasChildren =true;
			}
			n.setHasChildren(hasChildren);
			String bsnParentId = buildingStructureNew.getParentId();
			BuildingStructureNew bsnParent = null;
			boolean bP = StringUtils.isEmpty(bsnParentId);
			if(!bP){
				bsnParent = buildingStructureNewMapper.getBuildingStructureById(bsnParentId);
			}
			if(bP){
				n.setNodeLevel("1");
			}else{
				if(bsnParent!= null && StringUtils.isEmpty(bsnParent.getParentId())){
					n.setNodeLevel("2");
				}else{
					n.setNodeLevel("3");
				}
			}
			if (pbnList != null && pbnList.size() > 0) {
				for (int i = 0; i < pbnList.size(); i++) {
					PersonBuildingNew personBuildingNew = pbnList.get(i);
					if (StringUtils.isNotEmpty(personBuildingNew.getCustId())) {
						PersonCustNew pcn = personCustNewMapper.getPersonCustById(personBuildingNew.getCustId());
						if(pcn!=null){
							if (i == pbnList.size() - 1) {
								a.append(pcn.getName());
								b.append(pcn.getCardNum());
							} else {
								a.append(pcn.getName() + ",");
								b.append(pcn.getCardNum() + ",");
							}
						}
					}
					if (StringUtils.isNotEmpty(personBuildingNew.getEnterpriseId())) {
						EnterpriseCustNew ecn = enterpriseCustNewMapper.getEnterpriseCustNewById(personBuildingNew.getEnterpriseId());
						if(ecn!=null){
							if (i == pbnList.size() - 1) {
								a.append(ecn.getEnterpriseName());
								b.append(ecn.getTradingNumber());
							} else {
								a.append(ecn.getEnterpriseName() + ",");
								b.append(ecn.getTradingNumber() + ",");
							}
						}
					}
				}
			}
			n.setFullName(buildingStructureNew.getFullName());
			n.setId(buildingStructureNew.getId());
			n.setNodeName(buildingStructureNew.getNodeName());
			n.setParentId(buildingStructureNew.getParentId());
			n.setNames(a.toString());
			n.setCardNums(b.toString());
			n.setBuildingType(buildingStructureNew.getBuildingType());
			n.setProjectId(buildingStructureNew.getProjectId());
			n.setUuid(String.valueOf(buildingStructureNew.getIsBindingAssets()));
			/*if (buildingStructureNew.getHouse() != null) {
				n.setBuildingCertificate(buildingStructureNew.getHouse().getBuildingCertificate());
				if (buildingStructureNew.getHouse().getHouseArea() != null) {
					n.setBuildingArea(buildingStructureNew.getHouse().getHouseArea().toString());
				} else {
					n.setBuildingArea("");
				}
			}*/
			/*if (buildingStructureNew.getStall() != null) {
				n.setBuildingCertificate(buildingStructureNew.getStall().getBuildingCertificate());
				if (buildingStructureNew.getStall().getUsableArea() != null) {
					n.setBuildingArea(buildingStructureNew.getStall().getUsableArea().toString());
				} else {
					n.setBuildingArea("");
				}
			}*/
			/*if (buildingStructureNew.getStore() != null) {
				n.setBuildingCertificate(buildingStructureNew.getStore().getBuildingCertificate());
				if (buildingStructureNew.getStore().getBuildingArea() != null) {
					n.setBuildingArea(buildingStructureNew.getStore().getBuildingArea().toString());
				} else {
					n.setBuildingArea("");
				}
			}*/
			if ("true".equals(listAllBuildingStructureByParentId(buildingStructureNew.getId()))) {
				n.setIsParent("true");
			} else {
				n.setIsParent("false");
			}
			nodeList.add(n);
		}
		
		List<Node> secondLeves=new ArrayList<Node>();
		List<String> parentIds=new ArrayList<String>();
		secondLeves.addAll(nodeList);
		if(!bsn.getName().equals("")||!bsn.getEnterpriseName().equals("")){
			List<BuildingStructureNew> bsts= buildingStructureNewMapper.getCusNameAndEnterNameByBuS(bsn);
			for(int i=0;i<bsts.size();i++){
				parentIds.add(bsts.get(i).getParentId());
			}
			nodeList.clear();
			for(int i=0;i<secondLeves.size();i++){
				if(secondLeves.get(i).getNodeLevel().equals("2")){
					if(parentIds.contains(secondLeves.get(i).getId())){
						nodeList.add(secondLeves.get(i));
					}
				}
				if(secondLeves.get(i).getNodeLevel().equals("3")){
					if(!bsn.getName().trim().equals("")){
						if(secondLeves.get(i).getNames()!=null){
							if(secondLeves.get(i).getNames().indexOf(bsn.getName())!=-1){
								nodeList.add(secondLeves.get(i));
							}
						}
					}
				}
				if(secondLeves.get(i).getNodeLevel().equals("3")){
					if(!bsn.getEnterpriseName().trim().equals("")){
						if(secondLeves.get(i).getNames().indexOf(bsn.getEnterpriseName())!=-1){
							nodeList.add(secondLeves.get(i));
						}
					}
				}
				
			}
		}else if(!String.valueOf(bsn.getIsBindingAssets()).equals("3")){
				if(bsn.getIsBindingAssets()!=null){
				List<BuildingStructureNew> bsts= buildingStructureNewMapper.getCusNameAndEnterNameByBuS(bsn);
				for(int i=0;i<bsts.size();i++){
					parentIds.add(bsts.get(i).getParentId());
				}
				if(secondLeves.size()!=0&&secondLeves.get(0).getNodeLevel().equals("3")){
				nodeList.clear();
				for(int i=0;i<secondLeves.size();i++){
					if(secondLeves.get(i).getNodeLevel().equals("3")){
							if(secondLeves.get(i).getUuid().equals(String.valueOf(bsn.getIsBindingAssets()))){
								nodeList.add(secondLeves.get(i));
							}
					}
					
					}
				}
				
			}
		}
		return nodeList;
	}
	@Override
	public String listChildrenBuildingStructureByparentId(List<String> houseIdList, String parentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("houseIdList", houseIdList);
		map.put("parentId", parentId);
		List<BuildingStructureNew> buildingStructureList = buildingStructureNewMapper.listBuildingStructureResidenceByParentId(map);
		if(buildingStructureList != null && buildingStructureList.size()>0){
			return JSONArray.fromObject(buildingStructureList).toString();
		}
		return null;
	}

	@Override
	public List<BuildingStructureNew> listBuildingStructureById(String id) {
		List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
				.selectParentBuildingByProjectId(id);
		if(buildingStructureNewList != null && buildingStructureNewList.size()>0){
		} else {
			buildingStructureNewList = buildingStructureNewMapper.selectBuildingByParentId(id);
		}
		for (BuildingStructureNew item : buildingStructureNewList) {
			if(buildingStructureNewMapper.selectBuildingByParentId(item.getId()).size()>0){
				item.setChecked(true);
			} else {
				item.setChecked(false);
			}
		}
		return buildingStructureNewList;
	}

	@Override
	public List<BuildingStructureNew> listAllByProductId(String productId) {
		List<BuildingStructureNew>  buildingStructureNews = buildingStructureNewMapper.getByProductId(productId);
		List<BuildingStructureNew> buidingParentList=buildingStructureNewMapper.getParentByProductId(productId);
		for(BuildingStructureNew bsn:buidingParentList){
			buildingStructureNews.add(bsn);
		}
		List<BuildingStructureNew> buidingParentTopList=buildingStructureNewMapper.getParentTopByProductId(productId);
		for(BuildingStructureNew bsn:buidingParentTopList){
			buildingStructureNews.add(bsn);
		}
		return buildingStructureNews;
	}

	@Override
	public List<BuildingStructureNew> listAllByPId(String productId) {	
		
		List<BuildingStructureNew>  buildingStructureNews = buildingStructureNewMapper.editByProductId(productId);
		List<BuildingStructureNew> buidingParentList=buildingStructureNewMapper.editParentByProductId(productId);
		for(BuildingStructureNew bsn:buidingParentList){
			buildingStructureNews.add(bsn);
		}
		List<BuildingStructureNew> buidingParentTopList=buildingStructureNewMapper.editParentTopByProductId(productId);
		for(BuildingStructureNew bsn:buidingParentTopList){
			buildingStructureNews.add(bsn);
		}
		return buildingStructureNews;
	}

	@Override
	public List<BuildingStructureNew> listPrivateStall(String custId) {
		
		return buildingStructureNewMapper.listPrivateStall(custId);
	}


}
