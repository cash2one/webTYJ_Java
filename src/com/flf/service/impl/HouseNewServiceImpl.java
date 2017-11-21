package com.flf.service.impl;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.flf.entity.Annex;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Entrance;
import com.flf.entity.HouseGate;
import com.flf.entity.HouseNew;
import com.flf.entity.Intake;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Project;
import com.flf.entity.Search;
import com.flf.entity.Sipmanage;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.EntranceMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.IntakeMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SipmanageMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.HouseNewService;
import com.flf.service.IdentityAuService;
import com.flf.service.UserService;
import com.flf.util.ClientUtil;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.JsonUtil;
import com.flf.util.JsonUtils;
import com.flf.util.Tools;

@WebService
public class HouseNewServiceImpl implements HouseNewService{
	private HouseNewMapper houseNewMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	private ProjectMapper projectMapper;
	
	private SipmanageMapper sipmanageMapper;
	
	private String jiajiaUrl;
	
	private PersonCustNewMapper personCustNewMapper;
	
	private EntranceMapper entranceMapper;
	
	private IntakeMapper intakeMapper;
	
	private PersonBuildingNewMapper personBuildingNewMapper;

	/*
	  * <p>Title: deleteHouseNew</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.HouseNewService#deleteHouseNew(java.lang.String)
	  */
	
	
	public IntakeMapper getIntakeMapper() {
		return intakeMapper;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	public void setIntakeMapper(IntakeMapper intakeMapper) {
		this.intakeMapper = intakeMapper;
	}

	public String getJiajiaUrl() {
		return jiajiaUrl;
	}

	public SipmanageMapper getSipmanageMapper() {
		return sipmanageMapper;
	}

	public void setSipmanageMapper(SipmanageMapper sipmanageMapper) {
		this.sipmanageMapper = sipmanageMapper;
	}

	public void setJiajiaUrl(String jiajiaUrl) {
		this.jiajiaUrl = jiajiaUrl;
	}

	public HouseNewMapper getHouseNewMapper() {
		return houseNewMapper;
	}

	public void setHouseNewMapper(HouseNewMapper houseNewMapper) {
		this.houseNewMapper = houseNewMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	public EntranceMapper getEntranceMapper() {
		return entranceMapper;
	}

	public void setEntranceMapper(EntranceMapper entranceMapper) {
		this.entranceMapper = entranceMapper;
	}

	@Override
	public int deleteHouseNew(String id) {
		// TODO Auto-generated method stub
		return houseNewMapper.deleteHouseNew(id);
	}

	/*
	  * <p>Title: insertHouseNew</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#insertHouseNew(com.flf.entity.HouseNew)
	  */
	
	
	public HouseNew getHouseNewById(String id) {
		return houseNewMapper.getHouseNewById(id);
	};
	
	/*
	  * <p>Title: insertHouseNew</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#insertHouseNew(com.flf.entity.House)
	 */
	
	
	@Override
	public int insertHouseNew(HouseNew house) {
		// TODO Auto-generated method stub
		return houseNewMapper.insertHouseNew(house);
	}
	
	/*
	  * <p>Title: listAllHouseNew</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.HouseNewService#listAllHouseNew()
	  */
	
	
	@Override
	public List<HouseNew> listAllHouseNew() {
		// TODO Auto-generated method stub
		return houseNewMapper.listAllHouseNew();
	}
	
	/*
	  * <p>Title: listPageHouseNew</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#listPageHouseNew(com.flf.entity.House)
	  */
	
	
	@Override
	public List<HouseNew> listPageHouseNew(HouseNew house) {
		// TODO Auto-generated method stub
		return houseNewMapper.listPageHouseNew(house);
	}
	
	/*
	  * <p>Title: updateHouseNew</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#updateHouseNew(com.flf.entity.House)
	  */
	
	
	@Override
	public int updateHouseNew(HouseNew house) {
		// TODO Auto-generated method stub
		return houseNewMapper.updateHouseNew(house);
	}
	
	
	
	@Override
	public String deleteHouseNewCxf(String id) {
		// TODO Auto-generated method stub
		if(houseNewMapper.deleteHouseNew(id)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: insertHouseNewCXF</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#insertHouseNewCXF(java.lang.String)
	  */
	
	
	@Override
	public String insertHouseNewCxf(String house) {
		// TODO Auto-generated method stub
		HouseNew obj=(HouseNew) JSONObject.toBean(JSONObject.fromObject(house),HouseNew.class);
		if(houseNewMapper.insertHouseNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: listAllHouseNewCxf</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.HouseNewService#listAllHouseNewCxf()
	  */
	
	
	@Override
	public String listAllHouseNewCxf() {
		// TODO Auto-generated method stub
		List<HouseNew> houses = houseNewMapper.listAllHouseNew();
		JSONArray json=JSONArray.fromObject(houses);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: getHouseNewbyIdCxf</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.HouseNewService#getHouseNewbyIdCxf(java.lang.String)
	  */
	
	
	@Override
	public String getHouseNewByIdCxf(String id) {
		// TODO Auto-generated method stub
		HouseNew house = houseNewMapper.getHouseNewById(id);
		JSONObject json = JSONObject.fromObject(house);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: updateHouseNewCxf</p>
	  * <p>Description: </p>
	  * @param house
	  * @return
	  * @see com.flf.service.HouseNewService#updateHouseNewCxf(java.lang.String)
	  */
	
	
	@Override
	public String updateHouseNewCxf(String house) {
		// TODO Auto-generated method stub
		HouseNew obj=(HouseNew) JSONObject.toBean(JSONObject.fromObject(house),HouseNew.class);
		if(houseNewMapper.updateHouseNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}
	
	/*
	  * <p>Title: listHouseByhouseGates</p>
	  * <p>Description: </p>
	  * @param houseGates
	  * @return
	  * @see com.flf.service.HouseNewService#listHouseByhouseGates(java.lang.String)
	  */
	
	
	@Override
	public String listHouseByhouseGates(String houseGates) {
		// TODO Auto-generated method stub
		JSONArray houseGatesJSON=JSONArray.fromObject(houseGates);
		List<HouseGate> houseGate=(List<HouseGate>) JSONArray.toCollection(houseGatesJSON,HouseGate.class);
		List<HouseNew> houseNews=houseNewMapper.listHouseByhouseGates(houseGate);
		JSONArray json=JSONArray.fromObject(houseNews);
		return json.toString();
	}
	
	/*
	  * <p>Title: getSipByhouseId</p>
	  * <p>Description: </p>
	  * @param houseId
	  * @return
	  * @see com.flf.service.HouseNewService#getSipByhouseId(java.lang.String)
	  */
	
	
	@Override
	public String getHouseNewSipmanageByhouseId(String houseId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		HouseNew house=houseNewMapper.getHouseNewSipmanageByhouseId(houseId);
		if(house != null) {
			map.put("buildingStructureId", house.getBuildingStructureId());
			map.put("houseAddress", house.getHouseAddress());
			map.put("sipmanage", house.getSipmanage());
		}
		return JsonUtil.getJsonString4JavaPOJO(map);
	}
	
	/*
	  * <p>Title: openGateVerify</p>
	  * <p>Description: </p>
	  * @param houseId
	  * @param password
	  * @return
	  * @see com.flf.service.HouseNewService#openGateVerify(java.lang.String, java.lang.String)
	  */
	
	
	@Override
	public int openGateVerify(String houseId, String password) {
		// TODO Auto-generated method stub
		return houseNewMapper.openGateVerify(houseId, password);
	}
	
	/*
	  * <p>Title: listHouseByjiajiaNum</p>
	  * <p>Description: </p>
	  * @param jiajiaNum
	  * @return
	  * @see com.flf.service.HouseNewService#listHouseByjiajiaNum(java.lang.String)
	  */
	
	
	@Override
	public String listHouseByjiajiaNum(String jiajiaNum) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(jiajiaUrl+"/UserService",UserService.class);
		UserService welcome = (UserService) factory.create();
		String personId=welcome.getpersonIdByjiajiaNum(jiajiaNum);
		List<HouseNew> houses=houseNewMapper.listHouseBypersonId(personId);
		if(houses.size()>0){
		JSONArray json=JSONArray.fromObject(houses);
			return json.toString();
		}else
		{
			return null;
		}
	}
	
	@Override
	public  List<HouseNew> listAllHouseNewByPerson(PersonCustNew personCustNew) {
		// TODO Auto-generated method stub
		return houseNewMapper.listAllHouseNewByPerson(personCustNew);
	}

	 /**
     * 根据搜索条件查询房屋信息
     * @param Search
     * @return
     */
	@Override
	public List<HouseNew> listAllHouseNewBySearch(Search search) {
		// TODO Auto-generated method stub
		return houseNewMapper.listSearchHouseNew(search);
	}

	@Override
	public void AddHouseNew(HouseNew houseNew) {
		
		//查询出所有有效状态的sipmanage数据  王洲  2016.02.27
		List<Sipmanage> sipList = sipmanageMapper.listSipmanageByState();
		
		List<HouseNew> hList = houseNew.getHnList();
		for(int i = 0; i < hList.size(); i++){
			HouseNew house = new HouseNew();
			house.setProjectId(hList.get(i).getProjectId().trim()==""?"":hList.get(i).getProjectId());
			house.setBuildingId(hList.get(i).getBuildingId().trim()==""?"":hList.get(i).getBuildingId());
			house.setBuildingStructureId(hList.get(i).getBuildingStructureId().trim()==""?"":hList.get(i).getBuildingStructureId());
			house.setHouseAttribute(hList.get(i).getHouseAttribute().trim()==""?"":hList.get(i).getHouseAttribute());
			house.setHouseType(hList.get(i).getHouseType().trim()==""?"":hList.get(i).getHouseType());
			house.setHouseAddress(hList.get(i).getHouseAddress());
			house.setHouseArea(hList.get(i).getHouseArea());
			house.setUsableArea(hList.get(i).getUsableArea());
			house.setShareArea(hList.get(i).getShareArea());
			house.setCompleteArea(hList.get(i).getCompleteArea());
			house.setCompleteDate(hList.get(i).getCompleteDate());
			//增加住宅新增时的字段  王洲  2016.02.25
			house.setJoinGangState(hList.get(i).getJoinGangState());
			house.setHouseNum(hList.get(i).getHouseNum());
			
			//增加sipId字段插入  王洲  2016.02.27
			house.setSipId(sipList.size() > i ? sipList.get(i).getSipId() : "");
			
			//增加password默认值
			house.setPassword("123456");
			
			houseNewMapper.insertHouseNew(house);
		}
		//将使用过的sip账号状态置为失效
		if(sipList.size() > hList.size()){
			for(int i = 0; i < hList.size(); i++){
				sipmanageMapper.updateStateBySipId(sipList.get(i).getSipId());				
			}			
		}else{
			for(int i = 0; i < sipList.size(); i++){
				sipmanageMapper.updateStateBySipId(sipList.get(i).getSipId());				
			}
		}
	}
	
	@Override
	public List<HouseNew> listHouseByPersonCustId(Search search) {
		// TODO Auto-generated method stub
		List<HouseNew> list = houseNewMapper.listHouseByPersonCustId(search);
		return list;
	}
	
	@Override
	public int joinGang(String houseId, int state) {
		// TODO Auto-generated method stub
		return houseNewMapper.joinGang(houseId, state);
	}

	@Override
	public List<HouseNew> listHouseByenterpriseId(String enterpriseId) {
		// TODO Auto-generated method stub
		List<HouseNew> houseNews=houseNewMapper.listHouseByenterpriseId(enterpriseId);
		List<HouseNew> houseNews_one=new ArrayList<HouseNew>();
		for(HouseNew house:houseNews){
			if(house!=null){
				houseNews_one.add(house);
			}
		}
		return houseNews_one;
	}
	
	@Override
	public  List<HouseNew> listHouseBySearchAu(Search search) {
		// TODO Auto-generated method stub
		List<HouseNew> hnList = new ArrayList<HouseNew>();
//		List<HouseNew> houseNews=houseNewMapper.listSearchHouseNewAu(search);
		List<HouseNew> houseNewsone=houseNewMapper.listSearchHouseNew(search);
//		if(houseNews != null && houseNews.size() > 0){
//		for(HouseNew hn : houseNews){
//			hnList.add(hn);
//		}}
		if(houseNewsone != null && houseNewsone.size() > 0){
			for(HouseNew hne : houseNewsone){
				hnList.add(hne);
			}}
		
//		houseNews.addAll(houseNewsone);
//		houseNews.add(0,null);
		return  hnList;
	}
	
	@Override
	public List<HouseNew> listHouseByName(String name) {
		// TODO Auto-generated method stub
		return houseNewMapper.listHouseByName(name);
	}

	@Override
	public List<HouseNew> listHouseByEnterpriseName(String enterpriseName) {
		// TODO Auto-generated method stub
		return houseNewMapper.listHouseByEnterpriseName(enterpriseName);
	}
	
	@Override
	public Info importExcelFile(Annex annex){
		
		//查询出所有有效状态的sipmanage数据  王洲  2016.02.27
		List<Sipmanage> sipList = sipmanageMapper.listSipmanageByState();
		
		//查询数据库中的所有住宅信息
		List<HouseNew> houseList = houseNewMapper.listAllHouseNew();
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filePath = annex.getAnnexAddress();
		if(Tools.notEmpty(filePath)){
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if(dataList != null && dataList.size() > 0){
					int i = 0;
					for(Map<Short, String> t : dataList){
						int count = 0;
						for(int k = 0; k < houseList.size(); k ++){
							if(t.get((short)2) == houseList.get(k).getBuildingStructureId()){
								count++;
							}
						}
						if(count == 0){
							HouseNew house = new HouseNew();
							house.setId(UUID.randomUUID().toString());
							house.setProjectId(t.get((short)0));//项目id
							house.setBuildingId(t.get((short)1));//建筑id
							house.setBuildingStructureId(t.get((short)2));//建筑结构id
							house.setHouseAddress(t.get((short)3));//建筑名称
							house.setHouseAttribute(t.get((short)4));//楼房属性
							house.setHouseType(t.get((short)5));//房屋户型
							house.setHouseNum(t.get((short)6));//房屋编码
							house.setHouseArea(Double.parseDouble(t.get((short)7)));//建筑面积
							house.setUsableArea(Double.parseDouble(t.get((short)8)));//套内面积
							house.setShareArea(Double.parseDouble(t.get((short)9)));//分摊面积
							house.setCompleteArea(Double.parseDouble(t.get((short)10)));//竣工面积
							house.setCompleteDate(sdf.parse(t.get((short)11)));//竣工日期
							house.setJoinGangState((byte) (t.get((short)12).trim().toString().equals("未售") ? 0 : 1));//销售状态
							
							//增加sipId字段插入  王洲  2016.02.27
							house.setSipId(sipList.size() > i ? sipList.get(i).getSipId() : "");
							i++;
							
							//增加password默认值
							house.setPassword("123456");
							
							houseNewMapper.insertHouseNew(house);
							houseList.add(house);
						}
					}
					//将使用过的sip账号状态置为失效
					if(sipList.size() > dataList.size()){
						for(int j = 0; j < dataList.size(); j ++){
							sipmanageMapper.updateStateBySipId(sipList.get(j).getSipId());				
						}			
					}else{
						for(int j = 0; j < sipList.size(); j ++){
							sipmanageMapper.updateStateBySipId(sipList.get(j).getSipId());				
						}
					}
					return Tools.msg("数据导入成功！", true);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败！", false);
	}
	
	@Override
	public HouseNew listHouseByBuildingStructureId(String buildingStructureId) {
		// TODO Auto-generated method stub
		return houseNewMapper.listHouseByBuildingStructureId(buildingStructureId);
	}
	
	/**
	 * 分页显示住宅数据
	 * @author wangzhou
	 */
	@Override
	public PageRestful listPageHouseNewBySearch(Search search){
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> houseNews = houseNewMapper.listSearchHouseNew(search);
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(search.getPage());
		return pageRestful;
	}
	
	/**
	 * 分页显示住宅数据根据HouseNew
	 * @author wangzhou
	 */
	@Override
	public PageRestful listPageHouseNewByHouseNew(HouseNew houseNew){
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> houseNews = houseNewMapper.listPageIntakeHouseByPersonCustId(houseNew);
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(houseNew.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageAllHouseNewBySearch(Search search) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> houseNews = houseNewMapper.listPageAllHouseNewBySearch(search);
		for(HouseNew hosue:houseNews){
			int i=0;
			StringBuffer a=new StringBuffer();
			List<HouseNew>houseNews_nams= houseNewMapper.getAllCustNamesByStructId(hosue.getBuildingStructureId());
			for(HouseNew house_name:houseNews_nams){
				if(i>0){
					a.append(",");	
				}
				if(house_name!=null){
					a.append(house_name.getName());
					i++;
				}
				
			}
			hosue.setName(a.toString());
		}
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(search.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPagelistHouseBySearchAu(Search search) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> houseNews = houseNewMapper.listPagelistHouseBySearchAu(search);
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(search.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageByContion(HouseNew houseNew) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<HouseNew> houseNews =houseNewMapper.listPageByContion(houseNew);
		houseNews.add(0,null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(houseNew.getPage());
		return pageRestful;
		}
	
	@Override
	public PageRestful listPageHouseByPerson(HouseNew houseNew) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		Search search=new Search();
		search.setCustId(houseNew.getCustId());
		List<HouseNew> houseNews = houseNewMapper.listHouseByPersonCustId(search);
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(houseNew.getPage());
		return pageRestful;
	}
	
	/**
	 * 将需要excel导入的数据先写入excel模板并导出到本地
	 */
	@Override
	public InputStream exportHouseNewFile(String projectId){
		
		//获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
		BuildingStructureNew bsn = new BuildingStructureNew();
		bsn.setAreaId(areaTypeMap.get("house"));
		bsn.setProjectId(projectId);
		List<BuildingStructureNew> bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(bsn);
		
		//根据传入的projectId获取该项目下的所有house数据
		List<HouseNew> hsList = houseNewMapper.listHouseNewByProjectId(projectId);
		
		//生成需要写入的建筑结构数据集合
		List<BuildingStructureNew> _bsnList = new ArrayList<BuildingStructureNew>();
		for(BuildingStructureNew buildingStructureNew : bsnList){
			int i = 0;
			for (HouseNew houseNew : hsList) {
				if(!buildingStructureNew.getId().toString().equals(houseNew.getBuildingStructureId().toString())){
					i++;
				}
			}
			if(i == hsList.size()){
				_bsnList.add(buildingStructureNew);
			}
		}
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = { "项目归属编号","建筑归属编号","建筑结构归属编号","建筑名称", "楼房属性", "房屋户型", "房屋编码", "建筑面积", "套内面积","分摊面积","竣工面积","竣工日期", "销售状态"};
		String[] fields = {"projectId","buildingId","buildingStructureId","houseName"};
        List<HouseNew> dataset = new ArrayList<HouseNew>();
        for(BuildingStructureNew bsns : _bsnList){
        	HouseNew hn = new HouseNew();
        	hn.setId(null);
        	hn.setProjectId(bsns.getProjectId());
        	hn.setBuildingId(bsns.getBuildingId());
        	hn.setBuildingStructureId(bsns.getId());
        	hn.setHouseName(bsns.getFullName());
        	dataset.add(hn);
        }
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("住宅记录模板");
			exl.setList(dataset);
			list.add(exl);
        }
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public InputStream exportAllHouseNew(){
		//获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//获取所有住宅的信息
		List<HouseNew> hsList = houseNewMapper.listAllHouseNew();
		
		//循环设置住宅用于导出的竣工时间并存放到导出的list中
		List<HouseNew> dataset = new ArrayList<HouseNew>();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		for(HouseNew hn : hsList){
			if(hn.getBuildingStructureNew() != null){
				hn.setFullName(hn.getBuildingStructureNew().getFullName());				
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
			dataset.add(hn);
		}
		
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = {"名称","房屋编码","楼房属性","房屋户型","建筑面积","套内面积","公摊面积","竣工面积","竣工日期","销售状态"};
	    String[] fields = {"fullName","houseNum","houseAttribute","houseType","houseArea","usableArea","shareArea","completeArea","e_completeDate","joinGangStates"};
        
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("住宅记录");
			exl.setList(dataset);
			list.add(exl);
        }
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getSipByhouseAddress(String houseAddress) {
		Sipmanage sip=sipmanageMapper.getSipByhouseAddress(houseAddress);
		if(sip!=null){
			JSONObject json=JSONObject.fromObject(sip);
			return json.toString();
		}
		return null;
	}
	
	@Override
	public String listHousePasswordByjiajiaNum(String jiajiaNum){
		try {
			JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(jiajiaUrl+"/IdentityAuService",IdentityAuService.class);
			IdentityAuService welcome = (IdentityAuService) factory.create();
			String personId=welcome.getCustId(jiajiaNum);
			List<HouseNew> houses=houseNewMapper.listHouseBypersonId(personId);
			if(houses.size()>0){
			JSONArray json=JSONArray.fromObject(houses);
				return JsonUtil.success(json.toString(),true);
			}else
			{
				return JsonUtil.failure("家家账号没有关联房屋！ ",false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.failure("failure",false);
		}
	}
	
	@Override
	public String updateHousePasswordByhouseId(String houseId,String password){
		try {
			if(houseNewMapper.updateHousePasswordByhouseId(houseId, password)>0){
				return JsonUtil.success("修改成功！",false);
			}else{
				return JsonUtil.failure("修改失败！ ",false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.failure("failure ",false);
		}
		
	}
	
	@Override
	public void updateHouse(HouseNew houseNew){
		List<HouseNew> houseList = houseNew.getHnList();
		if(houseList != null && houseList.size() > 0){
			for(HouseNew house : houseList){
				houseNewMapper.updateHouseNew(house);
			}
		}
	}

	@Override
	public List<String> getHouseIdListByParentId(String parentIds) {
		return houseNewMapper.getHouseIdListByParentId(parentIds.split(","));
	}
	
	@Override
	public PageRestful listPageHouseByProjectId(HouseNew houseNew){
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> houseNews = houseNewMapper.listPageHouseNewByProjectId(houseNew);
		for(HouseNew hn : houseNews){
			if(hn.getJoinGangState() != null){
				if(hn.getJoinGangState().equals((byte)1)){
					hn.setSaleState("已售");
				}else{
					hn.setSaleState("未售");
				}
			}else{
				hn.setSaleState("未售");
			}
		}
		houseNews.add(0, null);
		pageRestful.setHouseNews(houseNews);
		pageRestful.setPage(houseNew.getPage());
		return pageRestful;
	}
	
	@Override
	public void updateHouseNews(HouseNew houseNew){
		houseNewMapper.updateHouseNew(houseNew);
	}

	@Override
	public String listHouseByCustIds(List<String> custIds) {
		List<HouseNew> houseNewList = houseNewMapper.listHouseByCustIds(custIds);
		if(houseNewList.size()>0) {
			return JSONArray.fromObject(houseNewList).toString();
		}
		return null;
	}

	@Override
	public String selectHouseInfoByHouseId(String houseId) {
		try {
			HouseNew houseNew = houseNewMapper.getHouseNewById(houseId);
			if(houseNew !=null ) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("houseId", houseId);
				map.put("custType", "业主");
				List<PersonCustNew> custList = personCustNewMapper.selectPersonCustNewByHouseIdAndCustType(map);
				map.put("custType", "亲属");
				List<PersonCustNew> familyCustList = personCustNewMapper.selectPersonCustNewByHouseIdAndCustType(map);
				
				List<String> custNameList = new ArrayList<String>();
				for (PersonCustNew item : custList) {
					custNameList.add(item.getName());
				}
				List<String> familyNameList = new ArrayList<String>();
				for (PersonCustNew item : familyCustList) {
					familyNameList.add(item.getName());
				}
				houseNew.setCustNameList(custNameList);
				houseNew.setFamilyNameList(familyNameList);
				
				List<Entrance> entranceList = entranceMapper.listEntranceByHouseId(houseId);
				houseNew.setEntranceList(entranceList);
				String[] property = {"houseNum","custNameList","houseAddress","completeDate","joinDate","floor","houseAttribute","houseType","familyNameList","entranceList"};
				return JsonUtils.toJsonStringFilterProperty(houseNew, HouseNew.class, property);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int updataJoinStateByHouseId(String houseId) {
		HouseNew houseNew = new HouseNew();
		houseNew = houseNewMapper.getHouseNewById(houseId);
		if(houseNew != null){
			houseNew.setJoinDate(new Date());
			houseNew.setJoinState((byte) 1);
			if(houseNewMapper.updateHouseNew(houseNew)!=0){
				List<Intake> intakes = new ArrayList<>();
				intakes = intakeMapper.getInrakeByBuildingId(houseNew.getBuildingId());
				intakes.get(0).setIntakeState(1);
				if(houseNew.getJoinDate() != null){
					intakes.get(0).setEndDate(houseNew.getJoinDate());
				}
				intakeMapper.updateIntake(intakes.get(0));
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getSipAndCust(String houseId) {
		if(Tools.notEmpty(houseId)){
			
			Map<String,Object> map = new HashMap<String,Object>();
			HouseNew house=houseNewMapper.getHouseNewSipmanageByhouseId(houseId);
			
			if(house!=null){
				List<String > custStr = personBuildingNewMapper.getPersonIdByBuildingStruId(house.getBuildingStructureId());
				if(custStr != null){
					map.put("buildingStructureId", house.getBuildingStructureId());
					map.put("houseAddress", house.getHouseAddress());
					map.put("sipmanage", house.getSipmanage());
					map.put("custList", custStr);
					return JsonUtil.getJsonString4JavaPOJO(map);
				}
			}
		}
		return null;
	}
	
	@Override
	public PageRestful searchHouseNewByBuildingStructureId(HouseNew hsn) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<HouseNew> hnList = houseNewMapper.searchHouseNewByBuildingStructureId(hsn);
		for(HouseNew hn : hnList){
			if(hn.getJoinGangState() != null){
				if(hn.getJoinGangState().equals((byte)1)){
					hn.setSaleState("已售");
				}else{
					hn.setSaleState("未售");
				}
			}else{
				hn.setSaleState("未售");
			}
		}
		hnList.add(0, null);
		pageRestful.setHouseNews(hnList);
		pageRestful.setPage(hsn.getPage());
		return pageRestful;
	}
	
}
