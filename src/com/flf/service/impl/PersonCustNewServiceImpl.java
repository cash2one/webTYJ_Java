/**
 * @Title: PersonCustNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-26 下午1:01:52
 * @version V1.0
 */

package com.flf.service.impl;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.flf.entity.Account;
import com.flf.entity.AccountRelation;
import com.flf.entity.Annex;
import com.flf.entity.AssetAccount;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CarInfo;
import com.flf.entity.Caraccesscard;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.Entrance;
import com.flf.entity.HomeUser;
import com.flf.entity.HouseNew;
import com.flf.entity.NewLease;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.PetRegistration;
import com.flf.entity.Search;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;
import com.flf.mapper.AccountMapper;
import com.flf.mapper.AccountRelationMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.CarInfoMapper;
import com.flf.mapper.CaraccesscardMapper;
import com.flf.mapper.EntranceMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.NewLeaseMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.PetRegistrationMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.request.propertyService;
import com.flf.service.PersonCustNewService;
import com.flf.service.UserService;
import com.flf.util.ClientUtil;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.JsonUtil;
import com.flf.util.JsonUtils;
import com.flf.util.MapUtils;
import com.flf.util.Tools;
import com.flf.util.ValidatorUtil;

import cn.jpush.api.utils.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ClassName: PersonCustNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-26 下午1:01:52
 *
 */

public class PersonCustNewServiceImpl implements PersonCustNewService {

	private PersonCustNewMapper personCustNewMapper;

	private CarInfoMapper carInfoMapper;

	private HouseNewMapper houseNewMapper;

	private StallNewMapper stallNewMapper;

	private StoreNewMapper storeNewMapper;

	private CaraccesscardMapper caraccesscardMapper;

	private EntranceMapper entranceMapper;

	private NewLeaseMapper newLeaseMapper;

	private PetRegistrationMapper petRegistrationMapper;

	private BuildingStructureNewMapper buildingStructureNewMapper;

	private AnnexMapper annexMapper;

	private AccountMapper accountMapper;// 个人账户mapper 王洲 2016.04.13

	private AssetAccountMapper assetAccountMapper;// 资产账户/个人账户mapper 王洲
													// 2016.04.13

	private AccountRelationMapper accountRelationMapper;// 个人账户、资产账户/个人账户关联
														// mapper 王洲 2016.04.13

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public PetRegistrationMapper getPetRegistrationMapper() {
		return petRegistrationMapper;
	}

	public void setPetRegistrationMapper(PetRegistrationMapper petRegistrationMapper) {
		this.petRegistrationMapper = petRegistrationMapper;
	}

	public NewLeaseMapper getNewLeaseMapper() {
		return newLeaseMapper;
	}

	public void setNewLeaseMapper(NewLeaseMapper newLeaseMapper) {
		this.newLeaseMapper = newLeaseMapper;
	}

	public CaraccesscardMapper getCaraccesscardMapper() {
		return caraccesscardMapper;
	}

	public void setCaraccesscardMapper(CaraccesscardMapper caraccesscardMapper) {
		this.caraccesscardMapper = caraccesscardMapper;
	}

	public EntranceMapper getEntranceMapper() {
		return entranceMapper;
	}

	public void setEntranceMapper(EntranceMapper entranceMapper) {
		this.entranceMapper = entranceMapper;
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

	public CarInfoMapper getCarInfoMapper() {
		return carInfoMapper;
	}

	public void setCarInfoMapper(CarInfoMapper carInfoMapper) {
		this.carInfoMapper = carInfoMapper;
	}

	private PersonBuildingNewMapper personBuildingNewMapper;

	private String jiajiaUrl;

	/*
	 * <p>Title: listAllPersonCustNewRestful</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.flf.service.PersonCustNewService#listAllPersonCustNewRestful()
	 */

	public String getJiajiaUrl() {
		return jiajiaUrl;
	}

	public void setJiajiaUrl(String jiajiaUrl) {
		this.jiajiaUrl = jiajiaUrl;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	@Override
	public List<PersonCustNew> listAllPersonCustNewRestful() {
		// TODO Auto-generated method stub
		// List<PersonCustNew>list=personCustNewMapper.listAllPersonCustNew();
		return personCustNewMapper.listAllPersonCustNew();
	}

	/*
	 * <p>Title: getPersonCustNewByIdRestful</p> <p>Description: </p>
	 * 
	 * @param custId
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#getPersonCustNewByIdRestful(java.
	 * lang.Integer)
	 */

	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public AssetAccountMapper getAssetAccountMapper() {
		return assetAccountMapper;
	}

	public void setAssetAccountMapper(AssetAccountMapper assetAccountMapper) {
		this.assetAccountMapper = assetAccountMapper;
	}

	public AccountRelationMapper getAccountRelationMapper() {
		return accountRelationMapper;
	}

	public void setAccountRelationMapper(AccountRelationMapper accountRelationMapper) {
		this.accountRelationMapper = accountRelationMapper;
	}

	@Override
	public PersonCustNew getPersonCustNewByIdRestful(String custId) {
		// TODO Auto-generated method stub
		return personCustNewMapper.getPersonCustNewById(custId);
	}

	/*
	 * <p>Title: insertPersonCustNewRestful</p> <p>Description: </p>
	 * 
	 * @param PersonCustNew
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#insertPersonCustNewRestful(com.flf.
	 * entity.PersonCustNew)
	 */

	@Override
	public String getPersonCustNewsByIds(String custId) {
		String ids[] = custId.split(",");
		List<PersonCustNew> personCust = new ArrayList<PersonCustNew>();
		for (String id : ids) {
			personCust.add(personCustNewMapper.getPersonCustNewById(id));
		}
		return JSONArray.fromObject(personCust).toString();
	}

	/**
	 * 根据姓名电话身份证号查询客户信息
	 * @param name
	 * @param cardNum
	 * @param phoneNum
	 * @return
	 */
	public PersonCustNew getPersonCustNewbyNameAndCardAndNum(String name, String cardNum, String phoneNum) {
		return personCustNewMapper.getPersonCustNewbyNameAndCardAndNum(name, cardNum, phoneNum);
	}

	@Override
	public void insertPersonCustNewRestful1(String ids, PersonCustNew personCustNew) {

		UUID uuid = UUID.randomUUID();
		personCustNew.setCustId(uuid.toString());
		DecimalFormat df = new DecimalFormat("#");// 用于处理电话号码存入数据库格式发生改变
		if (personCustNew.getRegisterPhone() != null && !"".equals(personCustNew.getRegisterPhone())) {
			personCustNew.setRegisterPhone(df.format(personCustNew.getRegisterPhone()));
		}
		if (personCustNew.getPhone() != null && !"".equals(personCustNew.getPhone())) {
			personCustNew.setPhone(df.format(personCustNew.getPhone()));
		}

		if (personCustNew.getUrgentContactPhone() != null && !"".equals(personCustNew.getUrgentContactPhone())) {
			personCustNew.setUrgentContactPhone(df.format(personCustNew.getUrgentContactPhone()));
		}

		if (personCustNew.getPhoneNum() != null && !"".equals(personCustNew.getPhoneNum())) {
			personCustNew.setPhoneNum(df.format(personCustNew.getPhoneNum()));
		}

		if (personCustNew.getPhoneNum1() != null && !"".equals(personCustNew.getPhoneNum1())) {
			personCustNew.setPhoneNum1(df.format(personCustNew.getPhoneNum1()));
		}

		if (personCustNew.getPhoneNum2() != null && !"".equals(personCustNew.getPhoneNum2())) {
			personCustNew.setPhoneNum2(df.format(personCustNew.getPhoneNum2()));
		}

		personCustNewMapper.insertPersonCustNew(personCustNew); // 添加用户

		String[] sid = ids.split(",");

		for (String id : sid) {
			PersonBuildingNew personBuildingNew = new PersonBuildingNew();
			personBuildingNew.setCustId(uuid.toString()); // 绑定客户表id
			personBuildingNew.setBuildingStructureId(id); // 绑定建筑结构id
			personBuildingNewMapper.insertPersonBuildingNew(personBuildingNew);
		}

	}

	/*
	 * <p>Title: updatePersonCustNewRestful</p> <p>Description: </p>
	 * 
	 * @param PersonCustNew
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#updatePersonCustNewRestful(com.flf.
	 * entity.PersonCustNew)
	 */

	@Override
	public Info updatePersonCustNewRestful(PersonCustNew PersonCustNew) {
		Info info = new Info();
		// TODO Auto-generated method stub
		String message = PersonCustNew.getRegisterPhone();
		String msg = "";
		boolean check = true;
		String id = PersonCustNew.getCustId();
		if (PersonCustNew.getCardNum().length() == 18) {
			PersonCustNew.setCardNum(PersonCustNew.getCardNum() + "S");
		}
		PersonCustNew.setRegisterPhone(null);
		int num = personCustNewMapper.getCountByNoOrPhoneById(PersonCustNew);
		if (num != 0) {
			msg = "证件号码已存在";
			check = false;
		} else {
			PersonCustNew.setRegisterPhone(message);
			message = PersonCustNew.getCardNum();
			PersonCustNew.setCardNum(null);
			num = personCustNewMapper.getCountByNoOrPhoneById(PersonCustNew);
			if (num != 0) {
				check = false;
				if (msg.length() == 0) {
					msg += "注册电话号码已存在";
				} else {
					msg += ",注册电话号码已存在";
				}
			}
		}

		if (check) {

			Integer n = personCustNewMapper.updatePersonCustNew(PersonCustNew);
			msg = "编辑成功";
			if (n > 0) {
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				List<Annex> annexList1 = annexMapper.getAnnexbyRelationId(id);// 根据关系id查询附件表是否存在文件信息
				List<Annex> annexList = PersonCustNew.getAnnexs();// 得到传过来的文件列表
				if (annexList1 != null && annexList1.size() > 0) {// 存在 文件时
																	// 将原有文件删除
					for (int i = 0; i < annexList1.size(); i++) {
						annexMapper.deleteAnnexByRelationId(id);
					}
					if (annexList != null && annexList.size() > 0) {
						for (Annex annex : annexList) {
							annex.setRelationId(id);
							annex.setAnnexTime(date);
							annexMapper.insertAnnex(annex);
						}
					}
				} else {// 不存在文件时 直接新增
					if (annexList != null && annexList.size() > 0) {
						for (Annex annex : annexList) {
							annex.setRelationId(id);
							annex.setAnnexTime(date);
							annexMapper.insertAnnex(annex);
						}
					}
				}
				info.setState("success");
			}
		}

		info.setInfo(msg);
		return info;

	}

	/*
	 * <p>Title: deletePersonCustNewRestful</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#deletePersonCustNewRestful(java.lang
	 * .Integer)
	 */

	@Override
	public void deletePersonCustNewRestful(String id) {
		// TODO Auto-generated method stub

		personCustNewMapper.deletePersonCustNew(id);

	}

	/*
	 * <p>Title: insertPersonCustNewAndRelationRestful</p> <p>Description: </p>
	 * 
	 * @param PersonCustNew
	 * 
	 * @param personBuildingNew
	 * 
	 * @see com.flf.service.PersonCustNewService#
	 * insertPersonCustNewAndRelationRestful(com.flf.entity.PersonCustNew,
	 * com.flf.entity.PersonBuildingNew)
	 */

	@Override
	public void insertPersonCustNewAndRelationRestful(PersonCustNew PersonCustNew,
			List<PersonBuildingNew> personBuildingNew) {
		personCustNewMapper.insertPersonCustNew(PersonCustNew);
		for (PersonBuildingNew personBuilding : personBuildingNew) {

			personBuildingNewMapper.insertPersonBuildingNew(personBuilding); // 添加人与房屋关系

		}

	}

	/*
	 * <p>Title: findPersonCustNewByhouseId</p> <p>Description: </p>
	 * 
	 * @param houseid
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#findPersonCustNewByhouseId(java.lang
	 * .String)
	 */

	@Override
	public String findPersonCustNewByhouseId(String houseid) {

		try {
			List<PersonCustNew> personCustNews = personCustNewMapper.findPersonCustNewByhouseId(houseid);
			JSONArray json = JSONArray.fromObject(personCustNews);
			return JsonUtil.success(json.toString(), false);
		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.failure("failure", true);
		}

	}

	/*
	 * <p>Title: listPagePersonCustRestful</p> <p>Description: </p>
	 * 
	 * @param PersonCustNew
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#listPagePersonCustRestful(com.flf.
	 * entity.PersonCustNew)
	 */

	@Override
	public PageRestful listPagePersonCustRestful(PersonCustNew personCustNew) {
		PageRestful pagerestful = new PageRestful();
		List<PersonCustNew> personCusts = personCustNewMapper.listPagePersonCustNew(personCustNew);
		/*
		 * for (PersonCustNew perCust : personCusts) { Date date=new Date(); if
		 * (perCust.getBirthday()!=null) {
		 * perCust.setAge(date.getYear()-perCust.getBirthday().getYear());
		 * //添加年龄 } }
		 */
		personCusts.add(0, null);
		pagerestful.setPersonCustNew(personCusts);
		pagerestful.setPage(personCustNew.getPage());
		return pagerestful;
	}

	@Override
	public List<HomeUser> listAllHomeUserBypersonId(String personId) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(jiajiaUrl + "/UserService", UserService.class);
		UserService welcome = (UserService) factory.create();
		String json = welcome.getjiajiaBypersonId(personId);
		JSONArray homeUserJSON = JSONArray.fromObject(json);
		List<HomeUser> homeUsers = (List<HomeUser>) JSONArray.toCollection(homeUserJSON, HomeUser.class);
		return homeUsers;
	}

	@Override
	public PageRestful listPageSearchPersonCust(Search search) {
		// TODO Auto-generated method stub
		List<PersonCustNew> personCusts = personCustNewMapper.listPageSearchPersonCust(search);
		PageRestful pageRestful = new PageRestful();
		personCusts.add(0, null);
		pageRestful.setPage(search.getPage());
		pageRestful.setPersonCustNew(personCusts);
		return pageRestful;
	}

	/*
	 * <p>Title: updatePersonId</p> <p>Description: </p>
	 * 
	 * @param personId
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PersonCustNewService#updatePersonId(java.lang.String)
	 */

	@Override
	public Info updatePersonId(String personId, String userId) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(jiajiaUrl + "/UserService", UserService.class);
		UserService welcome = (UserService) factory.create();
		int state = welcome.updatePersonId(personId, userId);
		Info info = new Info();
		switch (state) {
		case 0:
			info.setState("success");
			info.setInfo("解绑成功！");
			break;
		case 1:
			info.setState("failure");
			info.setInfo("解绑失败！");
			break;
		case 2:
			info.setState("failure");
			info.setInfo("家家号不存在！");
			break;
		case 3:
			info.setState("success");
			info.setInfo("绑定成功！");
			break;
		case 4:
			info.setState("failure");
			info.setInfo("绑定失败！");
			break;

		}

		return info;
	}

	@Override
	public List<PersonCustNew> findPersonCustNewRestful(PersonCustNew personCustNew) {
		// TODO Auto-generated method stub
		return personCustNewMapper.getPersonCustNewBycardType(personCustNew);

	}

	@Override
	public Info insertPersonCustNewRestful(PersonCustNew PersonCustNew) {
		PersonCustNew pcn = new PersonCustNew();
		pcn.setCardNum(PersonCustNew.getCardNum());
		pcn.setRegisterPhone(null);
		// TODO Auto-generated method stub
		if (pcn.getCardNum().length() == 18) {
			pcn.setCardNum(pcn.getCardNum() + "S");
		}
		int a = personCustNewMapper.getCountByNoOrPhoneById(pcn);
		String id = UUID.randomUUID().toString();
		Info info = new Info();
		PersonCustNew.setCustId(id);
		/*
		 * Random random = new Random(); int rannum = (int) (random.nextDouble()
		 * * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		 */
		String num = personCustNewMapper.selectCustCode();
		if (num == null || num.equals("")) {
			num = "10000";
		} else {
			num = String.valueOf(Integer.parseInt(num) + 1);
		}
		PersonCustNew.setCustCode(num);// 客户编号
		if (PersonCustNew.getCardNum().length() == 18) {
			PersonCustNew.setCardNum(PersonCustNew.getCardNum() + "S");
		}

		if (a == 0) {
			boolean insertPC = false;
			try {
				personCustNewMapper.insertPersonCustNew(PersonCustNew);
				insertPC = true;
			} catch (Exception e) {
				insertPC = false;
				e.printStackTrace();
			}
			if (insertPC) {
				if (PersonCustNew.getAnnexs() != null && PersonCustNew.getAnnexs().size() > 0) {
					for (Annex annex : PersonCustNew.getAnnexs()) {
						annex.setRelationId(id);
						String dt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
						annex.setAnnexTime(dt);
						annexMapper.insertAnnex(annex);
					}

				}
				// 添加个人账户表、押金账户表、个人账户和押金账户的管理 王洲 2016.04.15
				Account account = new Account();// 个人账户
				AssetAccount assetAccount = new AssetAccount();// 押金账户
				AccountRelation accountRelation = new AccountRelation();// 关系表

				// 个人账户对象添加数据
				account.setAccountId(UUID.randomUUID().toString());
				account.setAccountNum(PersonCustNew.getCustCode());
				account.setIsBankCard((byte) 0);
				account.setProjectId(PersonCustNew.getProjectId());
				account.setDisposableBalance((double) 0);
				account.setTotalBalance((double) 0);
				account.setCustId(PersonCustNew.getCustId());

				// 押金账户对象添加数据
				assetAccount.setAssetAccountId(UUID.randomUUID().toString());
				assetAccount.setAssetAccountNum("cust" + PersonCustNew.getCustCode());
				assetAccount.setIsBankCard((byte) 1);
				assetAccount.setProjectId(PersonCustNew.getProjectId());
				assetAccount.setAssetAccountBalance((double) 0);
				assetAccount.setAssetAccountType((byte) 1);
				assetAccount.setTotalDeposits((double) 0);
				assetAccount.setTotalRefundableDeposit((double) 0);
				assetAccount.setGeneralBalance((double) 0);

				// 关联表
				accountRelation.setAccountRelationId(UUID.randomUUID().toString());
				accountRelation.setAccountId(account.getAccountId());
				accountRelation.setAssetAccount(assetAccount.getAssetAccountId());

				try {
					accountMapper.insertAccount(account);
					assetAccountMapper.insertAssetAccount(assetAccount);
					accountRelationMapper.insertAccountRelation(accountRelation);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			info.setInfo("添加成功");
			info.setState("success");
		} else {
			info.setInfo("证件号码已存在");
			info.setState("success");
		}
		return info;
	}

	@Override
	public propertyService propertyServiceSearch(Search search) {
		// TODO Auto-generated method stub
		propertyService propertyService = new propertyService();
		if (search.getStaff())// 判断是否选择勾选人员
		{
			List<PersonCustNew> personCusts = personCustNewMapper.listSearchPersonCust(search);
			personCusts.add(0, null);
			propertyService.setPersonCusts(personCusts);// 搜索人员信信息
		}
		if (search.getProperty())// 判读是否勾选资产
		{
			List<CarInfo> carInfos = new ArrayList<CarInfo>();
			// if(!search.getStaffName().equals("")){
			carInfos = carInfoMapper.listSearchCarInfo(search);

			// }
			// carInfos.add(0,null);

			propertyService.setCarInfos(carInfos);// 搜索车辆信息

			List<HouseNew> houseNews = new ArrayList<HouseNew>();
			if (!search.getStaffName().equals("") || !search.getIdNum().equals("") || !search.getPhone().equals("")
					|| !search.getHouseAddress().equals("")) {
				houseNews = houseNewMapper.listSearchHouseNew(search);
			}
			houseNews.add(0, null);
			propertyService.setHouses(houseNews);// 搜索房屋信息

			List<StallNew> stallNews = stallNewMapper.listSearchStallNew(search);
			stallNews.add(0, null);
			propertyService.setStalls(stallNews);// 搜索车位信息

			List<StoreNew> storeNews = new ArrayList<StoreNew>();
			if (!search.getStaffName().equals("") || !search.getIdNum().equals("") || !search.getPhone().equals("")
					|| !search.getHouseAddress().equals("")) {
				storeNews = storeNewMapper.listSearchStoreNew(search);
			}
			storeNews.add(0, null);
			propertyService.setStores(storeNews);// 搜索商铺信息

		}
		if (search.getProduct())// 判断是否勾选产品
		{
			// 根据产品名称查询产品
		}
		if (search.getBill())// 判断是否勾选账单
		{
			// 根据指定条件查询账单
		}
		return propertyService;
	}

	public List<PersonCustNew> findEnterpriseCustByIdRestful(String EnterpriseCustId) {
		return personCustNewMapper.findEnterpriseCustByIdRestful(EnterpriseCustId);
	}

	/**
	 * 创建 by 肖聪 2015/6/30 很具搜索人员信息查询车位，车辆，门禁卡，停车卡
	 */
	public propertyService propertyServiceSearchCommon(Search search) {
		propertyService propertyService = new propertyService();
		List<PersonCustNew> personCusts = personCustNewMapper.listSearchPersonCust(search);
		personCusts.add(0, null);
		propertyService.setPersonCusts(personCusts);// 搜索人员信信息

		List<CarInfo> carInfos = carInfoMapper.listSearchCarInfo(search);
		carInfos.add(0, null);
		propertyService.setCarInfos(carInfos);// 搜索车辆信息

		List<HouseNew> houseNews = houseNewMapper.listSearchHouseNew(search);
		houseNews.add(0, null);
		propertyService.setHouses(houseNews);// 搜索房屋信息

		List<StallNew> stallNews = stallNewMapper.listSearchStallNew(search);
		stallNews.add(0, null);
		propertyService.setStalls(stallNews);// 搜索车位信息

		List<Caraccesscard> caraccesscards = caraccesscardMapper.listSearchCaraccesscard(search);
		caraccesscards.add(0, null);
		propertyService.setCaraccesscards(caraccesscards);// 搜索停车卡信息

		List<Entrance> entrances = entranceMapper.listSearchEntrance(search);
		entrances.add(0, null);
		propertyService.setEntrances(entrances);// 搜索门禁卡信息

		List<NewLease> leases = newLeaseMapper.listSearchLease(search);
		leases.add(0, null);
		propertyService.setLeases(leases);// 搜索门禁卡信息

		List<PetRegistration> pets = petRegistrationMapper.listSearchPets(search);
		pets.add(0, null);
		propertyService.setPets(pets);// 搜索门禁卡信息
		return propertyService;
	}

	/**
	 * 创建 by 肖聪 2015/7/1
	 */
	@Override
	public List<PersonCustNew> listAllPersonBySearch(Search search) {
		return personCustNewMapper.listSearchPersonCust(search);
	}

	/**
	 * 创建by 肖聪 2015/7/3 查询出授权人和办理人的相关资产
	 */
	@Override
	public propertyService propertyServiceAuSearch(Search search) {
		propertyService propertyService = new propertyService();
		// List<HouseNew> houseNews=houseNewMapper.listSearchHouseNewAu(search);
		List<HouseNew> houseNewsone = houseNewMapper.listSearchHouseNew(search);
		// houseNews.addAll(houseNewsone);
		houseNewsone.add(0, null);
		propertyService.setHouses(houseNewsone);// 搜索房屋信息

		// List<StallNew> stallNews=stallNewMapper.listSearchStallNewAu(search);
		List<StallNew> stallNewsone = stallNewMapper.listSearchStallNew(search);
		// stallNews.addAll(stallNewsone);
		stallNewsone.add(0, null);
		propertyService.setStalls(stallNewsone);// 搜索车位信息

		// List<StoreNew> storeNews=storeNewMapper.listSearchStoreNewAu(search);
		List<StoreNew> storeNewsone = storeNewMapper.listSearchStoreNew(search);
		// storeNews.addAll(storeNewsone);
		storeNewsone.add(0, null);
		propertyService.setStores(storeNewsone);// 搜索商铺信息

		return propertyService;

	}

	// @Override
	// public List<PersonCustNew> listPersonCustByCondition(PersonCustNew
	// personCustNew) {
	// List<PersonCustNew> pcnList = new ArrayList<PersonCustNew>();
	// List<String> stringList = new ArrayList<String>();
	// if(personCustNew.getProjectId() != null){
	// List<BuildingStructureNew> bsnList =
	// buildingStructureNewMapper.ListBuildingStructureNewByProjectId(personCustNew.getProjectId());
	// for(BuildingStructureNew bsn:bsnList){
	// stringList.add(bsn.getId());
	// }
	// personCustNew.setBsnList(stringList);
	// }
	//
	// pcnList = personCustNewMapper.listPersonCustByCondition(personCustNew);
	// return pcnList;
	// }
	@Override
	public PageRestful listPagePersonCustByCondition(PersonCustNew personCustNew) {
		PageRestful pageRestful = new PageRestful();
		List<PersonCustNew> pcnList = new ArrayList<PersonCustNew>();
		List<String> stringList = new ArrayList<String>();
		if (personCustNew.getProjectId() != null) {
			List<BuildingStructureNew> bsnList = buildingStructureNewMapper
					.ListBuildingStructureNewByProjectId(personCustNew.getProjectId());
			for (BuildingStructureNew bsn : bsnList) {
				stringList.add(bsn.getId());
			}
			personCustNew.setBsnList(stringList);
		}
		pcnList = personCustNewMapper.listPagePersonCustByCondition(personCustNew);
		pcnList.add(0, null);
		pageRestful.setPersonCustNew(pcnList);

		pageRestful.setPage(personCustNew.getPage());
		return pageRestful;

	}

	@Override
	public Info importExcelFile(Annex annex) {
		final String companyId = annex.getIsMain();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filePath = annex.getAnnexAddress();
		SimpleDateFormat sdfForFile = new SimpleDateFormat("yyyyMMddHHmmss");// 用于给导入进来的excel文件命令
		// final PersonCustNew personCustNew = null;
		final Map<String, PersonCustNew> codeMap = new HashMap<String, PersonCustNew>();
		List<PersonCustNew> allCustomerList = new ArrayList<PersonCustNew>();
		final List<PersonCustNew> repeatList = new ArrayList<PersonCustNew>();
		// 不符条件放入list
		final List<PersonCustNew> noLoad = new ArrayList<PersonCustNew>();

		if (Tools.notEmpty(filePath)) {
			try {
				final List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				List<PersonCustNew> personCustNews = new ArrayList<PersonCustNew>();

				int sum = 0;

				if (dataList != null && dataList.size() > 0) {
					allCustomerList = personCustNewMapper.listAllPersonCustNew();// 获取所有个人客户

					for (int i = 0; i < allCustomerList.size(); i++) {
						codeMap.put(allCustomerList.get(i).getCardNum(), allCustomerList.get(i));
					}
					int k = 0;

					final String key = UUID.randomUUID().toString();

					Runnable th = new Runnable() {
						@Override
						public void run() {
							final Map<String, String> importIdCard = new HashMap<String, String>();
							int totalNum = dataList.size();
							int bsnum = 0;
							int countNum = 0;
							String num = personCustNewMapper.selectCustCode();
							for (Map<Short, String> t : dataList) {
								boolean check = true;
								final PersonCustNew personCustNew = new PersonCustNew();
								personCustNew.setCompanyId(companyId);
								// 姓名
								if (!StringUtils.isEmpty(t.get((short) 0).trim())) {
									personCustNew.setName(t.get((short) 0));
								} else {
									check = false;
									// noLoad.add(setPerson(t));
									// continue;
								}
								// 性别
								if (!StringUtils.isEmpty(t.get((short) 1).trim())) {
									if (t.get((short) 1).equals("男")) {
										personCustNew.setSex("0");
									} else {
										personCustNew.setSex("1");
									}
								} else {
									check = false;
									// noLoad.add(setPerson(t));
									// continue;
								}
								// 民族
								if (!StringUtils.isEmpty(t.get((short) 2).trim())) {
									personCustNew.setNation(t.get((short) 2));
								}
								// 证件类型
								if (!StringUtils.isEmpty(t.get((short) 3).trim())) {
									if ("身份证".equals(t.get((short) 3))) {
										personCustNew.setCardType("0");
									} else {
										personCustNew.setCardType("1");// 护照
									}

								} else {
									check = false;
									// noLoad.add(setPerson(t));
									// continue;
								}
								if (personCustNew.getCardType().equals("0")) {
									// 证件号码
									String idCard_tmp = t.get((short) 4).trim();
									if (ValidatorUtil.isIdcard(idCard_tmp)) {

										if (importIdCard.containsKey(idCard_tmp)) {
											check = false;
											// repeatList.add(setPerson(t));
											// continue;
										} else {
											importIdCard.put(idCard_tmp, idCard_tmp);
										}

										if (idCard_tmp.length() >= 18) {
											if (codeMap.containsKey(idCard_tmp + "S")) {
												check = false;
												// repeatList.add(setPerson(t));
												// continue;
											} else {
												personCustNew.setCardNum(idCard_tmp + "S");
											}
										} else if (t.get((short) 4).length() >= 15) {
											if (codeMap.containsKey(idCard_tmp)) {
												check = false;
												// repeatList.add(setPerson(t));
												// continue;
											} else {
												personCustNew.setCardNum(idCard_tmp);
											}
										}
									} else {
										check = false;
										// noLoad.add(setPerson(t));
										// continue;
									}
								} else {
									if (codeMap.containsKey(t.get((short) 4).trim())) {
										continue;
									} else {
										personCustNew.setCardNum(t.get((short) 4));
									}
								}

								if (!StringUtils.isEmpty(t.get((short) 5).trim())) {
									try {
										// 出生日期
										personCustNew.setBirthday(sdf.parse(t.get((short) 5)));
									} catch (ParseException e) {
										e.printStackTrace();
									}
								}
								if (!StringUtils.isEmpty(t.get((short) 6).trim())) {
									if ("已婚".equals(t.get((short) 6))) {// 婚姻状况
										personCustNew.setMarrieState((byte) 0);
									} else {
										personCustNew.setMarrieState((byte) 1);// 婚否
									}
								}
								if (!StringUtils.isEmpty(t.get((short) 7).trim())) {
									personCustNew.setRegisterPhone(t.get((short) 7));// 注册号码
								} else {
									check = false;
									// noLoad.add(setPerson(t));
									// continue;
								}

								String nativePlace = t.get((short) 8).trim();
								if (!StringUtils.isEmpty(nativePlace)) {
									personCustNew.setNativePlace(nativePlace);// 籍贯
								}

								// 紧急联系人电话
								if (!StringUtils.isEmpty(t.get((short) 10).trim().trim())) {
									personCustNew.setUrgentContactPhone(t.get((short) 10));
								}

								if (!StringUtils.isEmpty(t.get((short) 11).trim())) {
									personCustNew.setCensus(t.get((short) 11));// 户口所在地
								}
								if (!StringUtils.isEmpty(t.get((short) 12).trim())) {
									personCustNew.setEmail(t.get((short) 12));// 电子邮箱
								}
								if (!StringUtils.isEmpty(t.get((short) 13).trim())) {
									personCustNew.setWorkUnits(t.get((short) 13));// 工作单位
								}
								if (!StringUtils.isEmpty(t.get((short) 14).trim())) {
									personCustNew.setPhoneNum(t.get((short) 14));
								}

								if (!StringUtils.isEmpty(t.get((short) 15).trim().trim())) {
									personCustNew.setPhoneNum1(t.get((short) 15));
								}
								if (!StringUtils.isEmpty(t.get((short) 16).trim())) {
									personCustNew.setPhoneNum2(t.get((short) 16));
								}

								String urgentContactPerson = t.get((short) 9).trim();
								if (!StringUtils.isEmpty(urgentContactPerson)) {
									personCustNew.setUrgentContactPerson(urgentContactPerson);// 紧急联系人
								}

								personCustNew.setCustId(UUID.randomUUID().toString());
								if (num == null || num.equals("")) {
									num = "10000";
								} else {
									num = String.valueOf(Integer.parseInt(num) + 1);
								}
								personCustNew.setCustCode(num);// 客户编号
								countNum++;
								if (check) {
									personCustNewMapper.insertPersonCustNew(personCustNew);
									bsnum++;

									// 添加个人账户表、押金账户表、个人账户和押金账户的管理 王洲 2016.04.15
									Account account = new Account();// 个人账户
									AssetAccount assetAccount = new AssetAccount();// 押金账户
									AccountRelation accountRelation = new AccountRelation();// 关系表

									// 个人账户对象添加数据
									account.setAccountId(UUID.randomUUID().toString());
									account.setAccountNum(personCustNew.getCustCode());
									account.setIsBankCard((byte) 0);
									account.setProjectId(personCustNew.getProjectId());
									account.setDisposableBalance((double) 0);
									account.setTotalBalance((double) 0);
									account.setCustId(personCustNew.getCustId());

									// 押金账户对象添加数据
									assetAccount.setAssetAccountId(UUID.randomUUID().toString());
									assetAccount.setAssetAccountNum("cust" + personCustNew.getCustCode());
									assetAccount.setIsBankCard((byte) 1);
									assetAccount.setProjectId(personCustNew.getProjectId());
									assetAccount.setAssetAccountBalance((double) 0);
									assetAccount.setAssetAccountType((byte) 1);
									assetAccount.setTotalDeposits((double) 0);
									assetAccount.setTotalRefundableDeposit((double) 0);
									assetAccount.setGeneralBalance((double) 0);

									// 关联表
									accountRelation.setAccountRelationId(UUID.randomUUID().toString());
									accountRelation.setAccountId(account.getAccountId());
									accountRelation.setAssetAccount(assetAccount.getAssetAccountId());

									try {
										accountMapper.insertAccount(account);
										assetAccountMapper.insertAssetAccount(assetAccount);
										accountRelationMapper.insertAccountRelation(accountRelation);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								// bsnum++;
								MapUtils.getMap().put(key, bsnum + "|" + totalNum + "|" + countNum);
							}
						}
					};
					Thread t = new Thread(th);
					t.start();
					return Tools.msg(key, true);

				}
				/*
				 * Excel ex=new Excel(); List<ExcelInfo> list=new
				 * ArrayList<ExcelInfo>(); String[] headers =
				 * {"姓名","性别","民族","证件类型", "证件号码", "出生日期",
				 * "婚姻状况","注册电话","籍贯","紧急联系人","紧急联系人号码","户口所在地","电子邮件","工作单位",
				 * "联系电话","联系电话1","联系电话2"}; String[] fields =
				 * {"name","sex","nation","cardType","cardNum","birthday",
				 * "marrieState","registerPhone","nativePlace",
				 * "urgentContactPerson",
				 * "urgentContactPhone","census","email","workUnits","phoneNum",
				 * "phoneNum1","phoneNum2"}; noLoad.addAll(repeatList);
				 * if(allCustomerList.size() > 0){ ExcelInfo exl=new
				 * ExcelInfo(); exl.setFields(fields); exl.setTitles(headers);
				 * exl.setSheetName("个人客户未导入记录"); exl.setList(noLoad);
				 * list.add(exl); } InputStream is =
				 * ex.createExcelInputStream(list); String excelName =
				 * "个人客户未导入记录.xls";
				 * 
				 * String str =
				 * getClass().getClassLoader().getResource("").toURI().getPath()
				 * ; String fileName = sdfForFile.format(new Date()) + ".xls";
				 * String fileRealPath = str.substring(str.indexOf("/", 0) + 1,
				 * str.lastIndexOf("WEB-INF/"))+ fileName; fileRealPath =
				 * fileRealPath.replace("\\", "/"); File f = new
				 * File(fileRealPath); FileOutputStream fos = new
				 * FileOutputStream(f); byte[] buffer = new byte[1024]; int num1
				 * = -1; while (true) { num1= is.read(buffer); if (num1 == -1)
				 * {// 是否知道了返回-1的作用了? break; } fos.write(buffer, 0, num1); }
				 * is.close(); fos.close(); return Tools.msg(sum + "|" +
				 * noLoad.size() + "|"+repeatList.size()+"|" + fileName, true);
				 */
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Tools.msg("数据导入失败!", false);
	}

	// 存放不符的数据
	/*
	 * public PersonCustNew setPerson(Map<Short, String> t){ SimpleDateFormat
	 * sdf = new SimpleDateFormat("yyyy-MM-dd"); PersonCustNew p=new
	 * PersonCustNew(); try{ p.setName(t.get((short) 0));//姓名
	 * p.setSex(t.get((short) 1));//性别 p.setNation(t.get((short) 2));//民族
	 * p.setCardType(t.get((short) 3));//身份证类型 p.setCardNum(t.get((short)
	 * 4));//证件号码 if(t.get((short)5)!=null&&!t.get((short)5).equals("")){
	 * p.setBirthday(sdf.parse(t.get((short)5)));//出生日期 }
	 * p.setMarrieString(t.get((short) 6));//婚否 p.setRegisterPhone(t.get((short)
	 * 7));//注册电话号码 p.setNativePlace(t.get((short) 8));//籍贯
	 * p.setUrgentContactPerson(t.get((short) 9));//紧急联系人
	 * p.setUrgentContactPhone(t.get((short)10));
	 * p.setCensus(t.get((short)11));//户口所在地 p.setEmail(t.get((short)
	 * 12));//电子邮箱 p.setPhoneNum(t.get((short) 14));//联系电话
	 * p.setPhoneNum1(t.get((short) 15));//俩系电话1 p.setPhoneNum2(t.get((short)
	 * 16));//联系电话2 }catch(Exception e){ e.printStackTrace(); } return p; }
	 */
	/**
	 * 查询人员信息 修改 添加年龄字段
	 */
	@Override
	public PageRestful listPagelistSearchPersonCust(PersonCustNew personCustNew) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<PersonCustNew> personCustNews = personCustNewMapper.listPagelistSearchPersonCust(personCustNew);
		for (PersonCustNew perCust : personCustNews) {
			Date date = new Date();
			if (perCust.getBirthday() != null) {
				Integer age = date.getYear() - perCust.getBirthday().getYear();
				if (age == 0) {
					age = 1;
				}
				perCust.setAge(age); // 添加年龄
			}
		}
		personCustNews.add(0, null);
		pageRestful.setPersonCustNew(personCustNews);
		pageRestful.setPage(personCustNew.getPage());
		return pageRestful;
	}

	@Override
	public List<PersonCustNew> listPersonCustNewByBuildingStructureId(String buildingStructureId) {
		return personCustNewMapper.listPersonCustNewByBuildingStructureId(buildingStructureId);
	}

	@Override
	public List<PersonCustNew> getSelectPersonNew(String buildingStructureid) {
		List<PersonCustNew> personList = personCustNewMapper.getSelectPersonNew(buildingStructureid);
		return personList;
	}

	@Override
	public PageRestful listPagePersonCustNewBySearch(PersonCustNew personCustNew) {
		PageRestful pageRestful = new PageRestful();
		List<PersonCustNew> personCustNews = personCustNewMapper.listPagePersonCustNewBySearch(personCustNew);
		personCustNews.add(0, null);
		pageRestful.setPersonCustNew(personCustNews);
		pageRestful.setPage(personCustNew.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPagePersonCustNewByAllSearch(PersonCustNew personCustNew) {
		PageRestful pageRestful = new PageRestful();
		List<PersonCustNew> personCustNews = personCustNewMapper.listPagePersonCustNewByAllSearch(personCustNew);
		personCustNews.add(0, null);
		pageRestful.setPersonCustNew(personCustNews);
		pageRestful.setPage(personCustNew.getPage());
		return pageRestful;
	}

	@SuppressWarnings("unused")
	@Override
	public List<PersonCustNew> getPersonCustNew(Search search) {
		String custId = search.getCustId();
		String buildingStructureId = search.getBuildingStructureId();
		List<PersonCustNew> list = new ArrayList<PersonCustNew>();
		PersonBuildingNew temp = null;
		// 通过建筑结构id获取与房屋相关联的人
		List<PersonBuildingNew> personBuildingNew = personBuildingNewMapper
				.listPersonBuildingByHouseId(buildingStructureId);
		for (PersonBuildingNew pb : personBuildingNew) {
			PersonCustNew custNew1 = new PersonCustNew();
			custNew1 = personCustNewMapper.getPersonCustById(pb.getCustId());
			if (custNew1 != null) {
				list.add(custNew1);
			}
		}
		if (list.size() != 0) {
			return list;
		} else {
			return personCustNewMapper.getPersonCustNewbySearch(search);
		}

		// 遍历比较是否办理人是与房屋有关联的
		/*
		 * for(PersonBuildingNew pb : personBuildingNew){
		 * if(custId.equals(pb.getCustId())){ temp = pb; } }
		 * 
		 * if(temp!=null){ if("业主".equals(temp.getCustType())){//当登录人为业主时
		 * PersonCustNew custNew1 =
		 * personCustNewMapper.getPersonCustById(temp.getCustId());
		 * list.add(custNew1); return list; }else{//登录人不是业主时，但是与房子有关联关系
		 * PersonCustNew custNew2 =
		 * personCustNewMapper.getPersonCustById(temp.getCustId());
		 * List<PersonCustNew> pcList =
		 * personCustNewMapper.getPersonCustNewbySearch(search);
		 * pcList.add(custNew2); return pcList; } }else{//只显示授权人 return
		 * personCustNewMapper.getPersonCustNewbySearch(search); }
		 */
	}

	// 导出
	@Override
	public InputStream exportPersonCustNewFile(PersonCustNew personCustNew) {
		String name = "";

		try {
			if ("" == personCustNew.getName() || "".equals(personCustNew.getName())) {
				personCustNew.setName(name);
			} else {
				name = new String(personCustNew.getName().getBytes("iso-8859-1"), "UTF-8");
				personCustNew.setName(name);
			}
			if (personCustNew.getUrgentContactPerson() != null) {
				if ("" != personCustNew.getUrgentContactPerson()
						|| !"".equals(personCustNew.getUrgentContactPerson())) {
					personCustNew.setUrgentContactPerson(
							new String(personCustNew.getUrgentContactPerson().getBytes("iso-8859-1"), "UTF-8"));
				}
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		personCustNew.setName(name);

		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "编号", "姓名", "性别", "民族", "证件类型", "证件号码", "出生日期", "婚姻状况", "注册电话", "籍贯", "紧急联系人", "紧急联系人号码",
				"户口所在地", "电子邮件", "微信号", "家家号", "工作单位", "联系电话", "联系电话1", "联系电话2" };
		String[] fields = { "custCode", "name", "sex", "nation", "cardType", "cardNum", "s_Birthday", "marry",
				"registerPhone", "nativePlace", "urgentContactPerson", "urgentContactPhone", "census", "email",
				"weixinNum", "jiajiaNum", "workUnits", "phoneNum", "phoneNum1", "phoneNum2" };
		List<PersonCustNew> dataset = personCustNewMapper.listAllPersonCustNewList(personCustNew);

		if (dataset != null && dataset.size() > 0) {
			for (int i = 0; i < dataset.size(); i++) {
				if (dataset.get(i).getCardType().equals("0")) {
					dataset.get(i).setCardType("身份证");
				} else if (dataset.get(i).getCardType().equals("1")) {
					dataset.get(i).setCardType("护照");
				} else {
					dataset.get(i).setCardType("");
				}

				if (dataset.get(i).getSex().equals("0")) {
					dataset.get(i).setSex("男");
				} else if (dataset.get(i).getSex().equals("1")) {
					dataset.get(i).setSex("女");
				} else {
					dataset.get(i).setSex("");
				}

				// 长度大于18位就取前18位
				if (dataset.get(i).getCardNum().length() > 18) {
					dataset.get(i).setCardNum(dataset.get(i).getCardNum().substring(0, 18));
				}

				if (dataset.get(i).getMarrieState() == null) {
					dataset.get(i).setMarry("");
				} else if (dataset.get(i).getMarrieState() == 0) {
					dataset.get(i).setMarry("已婚");
				} else if (dataset.get(i).getMarrieState() == 1) {
					dataset.get(i).setMarry("未婚");
				}
				Date date = dataset.get(i).getBirthday();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (date != null) {
					String s1 = sdf.format(date);
					dataset.get(i).setS_Birthday(s1);
				} else {
					dataset.get(i).setS_Birthday("");
				}
			}

			ExcelInfo exl = new ExcelInfo();

			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("个人客户");
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
	public InputStream importExcelTemplet() {
		List<PersonCustNew> person = new ArrayList<PersonCustNew>();
		person.add(null);
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "姓名", "性别", "民族", "证件类型", "证件号码", "出生日期", "婚姻状况", "注册电话", "籍贯", "紧急联系人", "紧急联系人号码",
				"户口所在地", "电子邮件", "工作单位", "联系电话", "联系电话1", "联系电话2" };
		String[] fields = { "name", "sex", "nation", "cardType", "cardNum", "birthday", "marrieState", "registerPhone",
				"nativePlace", "urgentContactPerson", "urgentContactPhone", "census", "email", "workUnits", "phoneNum",
				"phoneNum1", "phoneNum2" };
		List<PersonCustNew> dataset = new ArrayList<PersonCustNew>();

		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("个人客户导入模版");
		exl.setList(dataset);
		list.add(exl);

		String[] headers3 = { "字段名称", "字段类型", "默认值", "字段解释" };
		ExcelInfo exl3 = new ExcelInfo();
		String[] notes = new String[] { "姓名", "", "无", "必填项                ：客户姓名", "民族", "字符串", "无", "例如：汉族；", "证件类型",
				"字符串", "无", "必填项                ：身份证/护照 ", "证件号码", "字符串", "无",
				"必填项                ：用户证件号码，已存在的证件号码不会被导入", "出生日期", "日期格式", "无", "如: 1982-08-16 ", "婚姻状况", "字符串", "无",
				"已婚/未婚", "注册电话", "字符串", "无", "", "籍贯", "字符串", "无", "", "紧急联系人", "字符串", "无",
				"必填项                ：紧急联系人； 必填项", "紧急联系人号码", "字符串", "无", "必填项                ：紧急联系人号码； ", "户口所在地",
				"字符串", "无", "", "电子邮件", "字符串", "无", "", "工作单位", "字符串", "无", "", "联系电话", "字符串", "无", "", "联系电话1", "字符串",
				"无", "", "联系电话2", "字符串", "无", "", "", "", "", "注意：此次导入不会读取第二页。" };

		fields = new String[] { "字段名称", "字段类型", "默认值", "字段解释" };
		List<java.util.HashMap> mapList = new ArrayList<java.util.HashMap>();

		java.util.HashMap mp = null;
		for (int i = 0; i < notes.length; i++) {
			mp = new java.util.HashMap();
			mp.put("字段名称", notes[i++]);
			mp.put("字段类型", notes[i++]);
			mp.put("默认值", notes[i++]);
			mp.put("字段解释", notes[i]);
			mapList.add(mp);
		}

		exl3.setFields(fields);
		exl3.setTitles(headers3);
		exl3.setSheetName("说明文件");
		exl3.setList(mapList);
		list.add(exl3);

		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getCountByNoOrPhone(PersonCustNew personCustNew) {
		int i = personCustNewMapper.getCountByNoOrPhone(personCustNew);
		return i;
	}

	@Override
	public String getPersonCustByPerson(String name, String cardNum, String phoneNum) {
		if (Tools.notEmpty(name) && Tools.notEmpty(phoneNum) && Tools.notEmpty(cardNum)) {
			// 增加身份证判断，如果长度为18位时最后加"S" 王洲 2016.04.26
			// if(cardNum.length() >= 18){
			// cardNum += "S";
			// }
			PersonCustNew custNew = personCustNewMapper.getPersonCustNewbyNameAndCardAndNum(name, cardNum, phoneNum);
			if (custNew != null) {
				return custNew.getCustId();
			}
		}
		return null;
	}

	@Override
	public String getPersonCustById(String custId) {
		PersonCustNew custNew = personCustNewMapper.getPersonCustById(custId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("cardType", custNew.getCardType());
		map.put("cardNum", custNew.getCardNum());
		return JsonUtil.getJsonString4JavaPOJO(map);
	}

	@Override
	public String getCustByCompanyId(String companyId) {
		List<PersonCustNew> personCustNewList = personCustNewMapper.selectCustListByCompanyId(companyId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (PersonCustNew personCustNew : personCustNewList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("custId", personCustNew.getCustId());
			map.put("cardNum", personCustNew.getCardNum());
			map.put("projectId", personCustNew.getProjectId());
			list.add(map);
		}
		return JSONArray.fromObject(list).toString();
	}

	@Override
	public String getCustAndAddressByCustIdList(List<String> custIdList, String authorizationName) {
		List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
				.getCustAndAddressByCustIdList(custIdList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("custIdList", custIdList);
		map.put("authorizationName", authorizationName);
		List<BuildingStructureNew> buildingStructureNewList1 = buildingStructureNewMapper
				.getAuthorizationCustAndAddressByCustIdList(map);
		buildingStructureNewList.addAll(buildingStructureNewList1);
		if (buildingStructureNewList != null && buildingStructureNewList.size() > 0) {
			String[] property = { "custInfo", "fullName", "house", "id", "personBuildingId" };
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("custInfo", PersonCustNew.class);
			classMap.put("house", HouseNew.class);
			String[] custInfoFilter = { "name", "registerPhone", "cardType", "cardNum", "custId" };
			String[] houseFilter = { "houseAddress", "houseAttribute", "houseType", "houseNum", "equity", "towards",
					"floor", "projectId", "projectName" };
			Map<String, String[]> filterMap = new HashMap<String, String[]>();
			filterMap.put("custInfo", custInfoFilter);
			filterMap.put("house", houseFilter);
			return JsonUtils.listToJsonStringFilterProperty(buildingStructureNewList, BuildingStructureNew.class,
					property, classMap, filterMap);
		}
		return null;
	}

	@Override
	public String getEnterpriseCustAndAddressByCustIdList(List<String> custIdList) {
		try {
			List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper
					.getEnterpriseCustAndAddressByCustIdList(custIdList);
			if (buildingStructureNewList != null && buildingStructureNewList.size() > 0) {
				String[] property = { "custInfo", "fullName", "id", "personBuildingId", "enterpriseCustInfo" };
				Map<String, Class> classMap = new HashMap<String, Class>();
				classMap.put("custInfo", PersonCustNew.class);
				classMap.put("enterpriseCustInfo", EnterpriseCustNew.class);
				String[] custInfoFilter = { "name", "registerPhone", "cardType", "cardNum", "custId" };
				String[] enterpriseCustInfoFilter = { "enterpriseName" };
				Map<String, String[]> filterMap = new HashMap<String, String[]>();
				filterMap.put("custInfo", custInfoFilter);
				filterMap.put("enterpriseCustInfo", enterpriseCustInfoFilter);
				return JsonUtils.listToJsonStringFilterProperty(buildingStructureNewList, BuildingStructureNew.class,
						property, classMap, filterMap);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PersonBuildingNew> listBuildingByCustId(String custId) {
		List<PersonBuildingNew> list = null;
		if (custId != null && custId != "") {
			list = new ArrayList<PersonBuildingNew>();
			list = personBuildingNewMapper.listBuildingByCustId(custId);
		}
		return list;
	}

	@Override
	public String registPersonCust(String jsonStr) {
		try {
			JSONObject jsonObject = JSONObject.fromObject(jsonStr);
			PersonCustNew personCust = (PersonCustNew) JSONObject.toBean(jsonObject, PersonCustNew.class);
			personCust.setCustId(UUID.randomUUID().toString());
			personCust.setCardNum(personCust.getCardNum() + "S");
			PersonCustNew lastPersonCust = personCustNewMapper.getLastPersonCustNew();
			personCust.setCustCode(Integer.parseInt(lastPersonCust.getCustCode()) + 1 + "");
			personCustNewMapper.insertPersonCustNew(personCust);
			return personCust.getCustId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getPersonCustListByCustIdList(List<String> custIdList) {
		List<PersonCustNew> personCustNewList = personCustNewMapper.getPersonCustListByCustIdList(custIdList);
		if (personCustNewList != null && personCustNewList.size() > 0) {
			for (PersonCustNew personCustNew : personCustNewList) {
				personCustNew
						.setCardNum(personCustNew.getCardNum().substring(0, personCustNew.getCardNum().length() - 1));
			}
			String[] property = { "name", "sex", "cardType", "cardNum", "registerPhone", "custId" };
			return JsonUtils.toJsonStringFilterProperty(personCustNewList, PersonCustNew.class, property).toString();
		}
		return null;
	}

	@Override
	public Info insertLogoNewRestful(PersonCustNew PersonCustNew) {

		Info info = new Info();
		String companyId = PersonCustNew.getCompanyId();
		if (PersonCustNew.getAnnexs() != null && PersonCustNew.getAnnexs().size() > 0) {
			// info.setInfo("图片保存到数据库成功");
			info.setInfo("logo修改成功");
			info.setState("success");
			for (Annex annex : PersonCustNew.getAnnexs()) {
				annex.setRelationId(companyId);
				String dt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				annex.setAnnexTime(dt);
				annexMapper.insertAnnex(annex);
			}

		}
		return info;
	}

	@Override
	public List<Annex> getLogoByIdRestful(String companyId) {
		List<Annex> annexList = new ArrayList<Annex>();
		if (companyId != null) {
			annexList = annexMapper.getAnnexbyRelationId(companyId);// 根据关系id查询附件表是否存在文件信息
		}
		return annexList;
	}

	@Override
	public PageRestful ListPagefindEnterpriseCustByIdRestful(PersonCustNew personCustNew) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<PersonCustNew> personCustNews =personCustNewMapper.ListPagefindEnterpriseCustByIdRestful(personCustNew);
		personCustNews.add(0,null);
		pagerestful.setPersonCustNew(personCustNews);
		pagerestful.setPage(personCustNew.getPage());
		return pagerestful;
	}
}