/**
 * @Title: EnterpriseCustNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-27 上午9:52:45
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
import java.util.Random;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.EnterpriseCustNewMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.EnterpriseCustNewService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.MapUtils;
import com.flf.util.NodeIDComparator;
import com.flf.util.Tools;

import cn.jpush.api.utils.StringUtils;

/**
 * @ClassName: EnterpriseCustNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-27 上午9:52:45
 *
 */

public class EnterpriseCustNewServiceImpl implements EnterpriseCustNewService {

	private EnterpriseCustNewMapper enterpriseCustNewMapper;
	private PersonBuildingNewMapper personBuildingNewMapper;
	
	@org.springframework.beans.factory.annotation.Autowired
	private com.flf.mapper.PersonCustNewMapper personCustNewMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;
	private AnnexMapper annexMapper;
	/*
	 * <p>Title: listAllEnterpriseCustNewRestful</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.EnterpriseCustNewService#listAllEnterpriseCustNewRestful()
	 */
    
	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}


	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public void setPersonBuildingNewMapper(
			PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	public EnterpriseCustNewMapper getEnterpriseCustNewMapper() {
		return enterpriseCustNewMapper;
	}

	public void setEnterpriseCustNewMapper(
			EnterpriseCustNewMapper enterpriseCustNewMapper) {
		this.enterpriseCustNewMapper = enterpriseCustNewMapper;
	}

	@Override
	public List<EnterpriseCustNew> listAllEnterpriseCustNewRestful() {
		// TODO Auto-generated method stub
		return enterpriseCustNewMapper.listAllEnterpriseCustNew();
	}

	/*
	 * <p>Title: getEnterpriseCustNewByIdRestful</p>
	 * <p>Description: </p>
	 * @param enterpriseId
	 * @return
	 * @see com.flf.service.EnterpriseCustNewService#getEnterpriseCustNewByIdRestful(java.lang.String)
	 */

	@Override
	public EnterpriseCustNew getEnterpriseCustNewByIdRestful(String enterpriseId) {
		
		return enterpriseCustNewMapper.getEnterpriseCustNewById(enterpriseId);
	}

	/*
	 * <p>Title: insertEnterpriseCustNewRestful</p>
	 * <p>Description: </p>
	 * @param EnterpriseCustNew
	 * @see com.flf.service.EnterpriseCustNewService#insertEnterpriseCustNewRestful(com.flf.entity.EnterpriseCustNew)
	 */

	@Override
	public void insertEnterpriseCustNewRestful(String ids, EnterpriseCustNew EnterpriseCustNew  ) {

		 UUID uuid = UUID.randomUUID();
		 EnterpriseCustNew.setEnterpriseId(uuid.toString());
		 enterpriseCustNewMapper.insertEnterpriseCustNew(EnterpriseCustNew);
		 String[] sid = ids.split(",");
		  for (String id : sid) {
				PersonBuildingNew personBuildingNew=new PersonBuildingNew();
				System.out.println(EnterpriseCustNew.getEnterpriseId());
				personBuildingNew.setCustId(uuid.toString()); // 绑定企业客户表id
				personBuildingNew.setBuildingStructureId(id); //绑定建筑结构id
				personBuildingNewMapper.insertPersonBuildingNew(personBuildingNew);
		  }
		
		
		// TODO Auto-generated method stub

	}

	/*
	 * <p>Title: updateEnterpriseCustNewRestful</p>
	 * <p>Description: </p>
	 * @param EnterpriseCustNew
	 * @see com.flf.service.EnterpriseCustNewService#updateEnterpriseCustNewRestful(com.flf.entity.EnterpriseCustNew)
	 */

	@Override
	public void updateEnterpriseCustNewRestful(
			EnterpriseCustNew EnterpriseCustNew) {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String id=EnterpriseCustNew.getEnterpriseId();
		Integer n=enterpriseCustNewMapper.updateEnterpriseCustNew(EnterpriseCustNew);
		if(n>0){
			List<Annex> annexList1= annexMapper.getAnnexbyRelationId(id);//根据关系id查询附件表是否存在文件信息
			List<Annex> annexList = EnterpriseCustNew.getAnnexs();//得到传过来的文件列表
			if(annexList1 != null && annexList1.size()>0){//存在 文件时 将原有文件删除	
				for(int i=0;i<annexList1.size();i++){
					annexMapper.deleteAnnexByRelationId(id);
				}
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(id);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}else{//不存在文件时  直接新增
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(id);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
		
		
		//添加上传功能
		/*if(EnterpriseCustNew!=null){
			List<Annex> annexs = EnterpriseCustNew.getAnnexs();
			if(annexs!=null){
				for (Annex annex : annexs) {
					if(annex.getPactId()!=null && annex.getPactId().equals("1")){//为营业执照
						EnterpriseCustNew.setTradingNumber(annex.getAnnexAddress());
						Annex ann = annexMapper.findAnnexByRelationIdAndAddress(EnterpriseCustNew.getEnterpriseId(), EnterpriseCustNew.getTradingNumber());
						ann.setAnnexAddress(annex.getAnnexAddress());
						ann.setAnnexName(annex.getAnnexName());
						ann.setAnnexTime(date);
						annexMapper.updateAnnex(ann);
					}else if(annex.getPactId()!=null && annex.getPactId().equals("2")){
						EnterpriseCustNew.setOrganizationCode(annex.getAnnexAddress());
						Annex ann = annexMapper.findAnnexByRelationIdAndAddress(EnterpriseCustNew.getEnterpriseId(), EnterpriseCustNew.getOrganizationCode());
						ann.setAnnexAddress(annex.getAnnexAddress());
						ann.setAnnexName(annex.getAnnexName());
						ann.setAnnexTime(date);
						annexMapper.updateAnnex(ann);
					}
				}
			}
		}*/
		

	}

	/*
	 * <p>Title: deleteEnterpriseCustNewRestful</p>
	 * <p>Description: </p>
	 * @param enterpriseId
	 * @see com.flf.service.EnterpriseCustNewService#deleteEnterpriseCustNewRestful(java.lang.String)
	 */

	@Override
	public void deleteEnterpriseCustNewRestful(String enterpriseId) {
		// TODO Auto-generated method stub
		enterpriseCustNewMapper.deleteEnterpriseCustNew(enterpriseId);

	}

	/*
	  * <p>Title: listPageEnterpriseCustNewRestful</p>
	  * <p>Description: </p>
	  * @param EnterpriseCustNew
	  * @return
	  * @see com.flf.service.EnterpriseCustNewService#listPageEnterpriseCustNewRestful(com.flf.entity.EnterpriseCustNew)
	  */
	
	
	@Override
	public PageRestful listPageEnterpriseCustNewRestful(
			EnterpriseCustNew EnterpriseCustNew) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<EnterpriseCustNew> enterpriseCustNews =enterpriseCustNewMapper.listPageEnterpriseCustNew(EnterpriseCustNew);
		/*for (PersonCustNew perCust : personCusts) {
			Date date=new Date();
			if (perCust.getBirthday()!=null) {
				perCust.setAge(date.getYear()-perCust.getBirthday().getYear());	 //添加年龄
			}
		}*/
		enterpriseCustNews.add(0,null);
		pagerestful.setEnterpriseCustNews(enterpriseCustNews);
		pagerestful.setPage(EnterpriseCustNew.getPage());
		return pagerestful;
	}

	/*
	  * <p>Title: findEnterpriseCustNewRestful</p>
	  * <p>Description: </p>
	  * @param enterpriseCustNew
	  * @return
	  * @see com.flf.service.EnterpriseCustNewService#findEnterpriseCustNewRestful(com.flf.entity.EnterpriseCustNew)
	  */
	
	
	@Override
	public List<EnterpriseCustNew> findEnterpriseCustNewRestful(
			EnterpriseCustNew enterpriseCustNew) {
		// TODO Auto-generated method stub
		return enterpriseCustNewMapper.findEnterpriseCustNew(enterpriseCustNew);
	}

	/*
	  * <p>Title: insertEnterpriseCustNewRestful</p>
	  * <p>Description: </p>
	  * @param EnterpriseCustNew
	  * @see com.flf.service.EnterpriseCustNewService#insertEnterpriseCustNewRestful(com.flf.entity.EnterpriseCustNew)
	  */
	
	
	@Override
	public void insertEnterpriseCustNew(
			EnterpriseCustNew EnterpriseCustNew) {
		// TODO Auto-generated method stub
		String uuid= UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(EnterpriseCustNew!=null){
			EnterpriseCustNew.setEnterpriseId(uuid);
			/*Random random = new Random();  		  
	        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数*/
	    String num=enterpriseCustNewMapper.selectCustCode();		
		if(num==null||num.equals("")){
			num="10000";			
		}else{
			num=String.valueOf(Integer.parseInt(num)+1);
		}
		EnterpriseCustNew.setUnitNumber(num);//企业编号
			
			Integer result = enterpriseCustNewMapper.insertEnterpriseCustNew(EnterpriseCustNew);
			//添加成功
			if(result>0){
				//上传文件
				List<Annex> annexs = EnterpriseCustNew.getAnnexs();
				if(annexs!=null && annexs.size()>0){
					for(Annex annex :annexs){
						EnterpriseCustNew.setTradingNumber(annex.getAnnexAddress());
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
						//if(annex.getPactId()!=null && annex.getPactId().equals("1")){// 传送文件为营业执照
						//	EnterpriseCustNew.setTradingNumber(annex.getAnnexAddress());
						//	annex.setRelationId(uuid);
						//	annex.setAnnexTime(date);
						//	annexMapper.insertAnnex(annex);
						//}else if(annex.getPactId()!=null && annex.getPactId().equals("2")){//传送文件为组织机构代码
						//	EnterpriseCustNew.setOrganizationCode(annex.getAnnexAddress());
						//	annex.setRelationId(uuid);
						//	annex.setAnnexTime(date);
						//	annexMapper.insertAnnex(annex);
						//}
						//annex.setPactId(null);
					}
				}
			}
			//enterpriseCustNewMapper.updateEnterpriseCustNew(EnterpriseCustNew);//将企业客户对象更新
		}
		
	}
 /**
  * 创建 by肖聪  2015/7/9
  * @param search
  * @return
  */
	
	@Override
	public List<PersonCustNew>  listAllEnterpriseBySearch(Search search) {
		// TODO Auto-generated method stub
		return enterpriseCustNewMapper.listSearchEnterprise(search);
	}

@Override
public List<EnterpriseCustNew> listEnterpriseCustNewByCondition(
		EnterpriseCustNew enterpriseCustNew) {
	List<EnterpriseCustNew> ecnList = new ArrayList<EnterpriseCustNew>();
	List<String> stringList = new ArrayList<String>();
	if(enterpriseCustNew.getProjectId() != null){
		List<BuildingStructureNew> bsnList = buildingStructureNewMapper.ListBuildingStructureNewByProjectId(enterpriseCustNew.getProjectId());
		if(bsnList!=null && bsnList.size() > 0){
			for(BuildingStructureNew bsn:bsnList){
				stringList.add(bsn.getId());
			}
		}else{
			stringList.add("");
		}
		enterpriseCustNew.setBsnList(stringList);
	}
	
	ecnList = enterpriseCustNewMapper.listEnterpriseCustNewByCondition(enterpriseCustNew);
	return ecnList;
}


@Override
public PageRestful listPageEnterpriseCustNewByCondition(
		EnterpriseCustNew enterpriseCustNew) {
	// TODO Auto-generated method stub
	PageRestful pageRestful = new PageRestful();
	List<EnterpriseCustNew> custNews = enterpriseCustNewMapper.listPageEnterpriseCustNewByCondition(enterpriseCustNew);
	
	custNews.add(0,null);
	pageRestful.setEnterpriseCustNews(custNews);
	pageRestful.setPage(enterpriseCustNew.getPage());
	return pageRestful;
}

//存放不符的数据
	public EnterpriseCustNew setEnterpriseCustNew(Map<Short, String> t){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EnterpriseCustNew e=new EnterpriseCustNew();
		try{			
			e.setEnterpriseName(t.get((short) 0));//企业姓名
			e.setManageType(t.get((short) 1));//经营类型
			e.setAddress(t.get((short) 2));//地址
			e.setRepresentative(t.get((short) 3));//法人代表
			e.setOfficePhone(t.get((short) 4));//办公电话
			e.setEmail(t.get((short)5));//电子邮件
			
			//添加验证，电子邮件/注册日期/企业类型/紧急联系人/紧急联系电话/企业委托人/企业地址 等等，均可能为空。
			
			if(t.get((short)6)!=null&&!"".equals(t.get((short)6))){
				e.setRegisterDate(sdf.parse(t.get((short)6)));//注册日期
			}else{
				e.setRegisterDate(null);//注册日期
			}
			e.setEnterpriseProperty(t.get((short) 7));//企业类型
			e.setEmergencyContact(t.get((short) 8));//紧急联系人
			e.setEmergencyContactPhone(t.get((short) 9));//紧急联系电话
			e.setPrincipal(t.get((short) 10));//企业委托人
			e.setBusinessAddress(t.get((short) 11));//企业地址	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return e;
	}

/*@Override
public Info importExcelFileRes(Annex annex) {

	final String companyId=annex.getIsMain();
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String filePath = annex.getAnnexAddress();
//	SimpleDateFormat sdfForFile = new SimpleDateFormat("yyyyMMddHHmmss");// 用于给导入进来的excel文件命令
	final Map<String ,EnterpriseCustNew> codeMap=new HashMap<String ,EnterpriseCustNew>();
	List<EnterpriseCustNew>  allCustomerList=new ArrayList<EnterpriseCustNew>();
//	final List<EnterpriseCustNew> repeatList=new ArrayList<EnterpriseCustNew>();
	//不符条件放入list
	final List<EnterpriseCustNew> noLoad=new ArrayList<EnterpriseCustNew>();
	if (Tools.notEmpty(filePath)) {
		try {
			final List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
			List <EnterpriseCustNew> enterpriseCustNew=new ArrayList<EnterpriseCustNew>();
//			int sum=0;
			if (dataList != null && dataList.size() > 0) {					
				allCustomerList=enterpriseCustNewMapper.listAllEnterpriseCustNew();//获取所有企业客户
	
				for (int n=0;n<dataList.size();n++) {
					for(int i=0;i<allCustomerList.size();i++){
						if(dataList.get(n).get((short) 0).equals(allCustomerList.get(i).getEnterpriseName())||
								dataList.get(n).get((short) 4).equals(allCustomerList.get(i).getOfficePhone())){
							dataList.remove(n);
						}
					}
				}
				
				for(int n=0;n<dataList.size();n++){
					Map<Short,String> map=dataList.get(n);
					int num=0;
					for(int i=0;i<dataList.size();i++){
						if(map.get((short)0).equals(dataList.get(i).get((short)0))||
								map.get((short)4).equals(dataList.get(i).get((short)4))){
							num++;
							if(num>1){
								dataList.remove(n);
							}
						}
					}
				}

				final String key = UUID.randomUUID().toString();
					if (dataList.size() != 0) {
						Runnable th = new Runnable() {
							@Override
							public void run() {
								int totalNum = dataList.size();
								int bsnum = 0;
								String num = enterpriseCustNewMapper.selectCustCode();// 获取最大编号
								for (Map<Short, String> t : dataList) {
									final EnterpriseCustNew enterpriseCustNew = new EnterpriseCustNew();
									// 企业名称
									if (!StringUtils.isEmpty(t.get((short) 0))) {
										enterpriseCustNew.setEnterpriseName(t.get((short) 0));
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 经营类型
									if (!StringUtils.isEmpty(t.get((short) 1))) {
										enterpriseCustNew.setManageType(t.get((short) 1));
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 注册地址
									if (!StringUtils.isEmpty(t.get((short) 2))) {
										enterpriseCustNew.setAddress(t.get((short) 2));
									}
									// 法人代表
									if (!StringUtils.isEmpty(t.get((short) 3))) {
										enterpriseCustNew.setRepresentative(t.get((short) 3));
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 办公电话
									if (!StringUtils.isEmpty(t.get((short) 4))) {
										enterpriseCustNew.setOfficePhone(t.get((short) 4));
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 电子邮件
									if (!StringUtils.isEmpty(t.get((short) 5))) {
										enterpriseCustNew.setEmail(t.get((short) 5));
									}
									// 注册日期
									if (!StringUtils.isEmpty(t.get((short) 6).trim())) {
										try {
											enterpriseCustNew.setRegisterDate(sdf.parse(t.get((short) 6)));
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										enterpriseCustNew.setRegisterDate(null);// 注册日期
									}
									// 企业类型
									if (!StringUtils.isEmpty(t.get((short) 7))) {
										enterpriseCustNew.setEnterpriseProperty(t.get((short) 7));
									}
									// 紧急联系人
									if (!StringUtils.isEmpty(t.get((short) 8))) {
										enterpriseCustNew.setEmergencyContact(t.get((short) 8));
									}
									// 紧急联系电话
									if (!StringUtils.isEmpty(t.get((short) 9))) {
										enterpriseCustNew.setEmergencyContactPhone(t.get((short) 9));
									}
									// 企业委托人
									if (!StringUtils.isEmpty(t.get((short) 10).trim())) {
										enterpriseCustNew.setPrincipal(t.get((short) 10));
									}
									// 企业地址
									if (!StringUtils.isEmpty(t.get((short) 11))) {
										enterpriseCustNew.setBusinessAddress(t.get((short) 11));
									}

									enterpriseCustNew.setEnterpriseId(UUID.randomUUID().toString());
									if (num == null || num.equals("")) {
										num = "10000";
									} else {
										num = String.valueOf(Integer.parseInt(num) + 1);
									}
									enterpriseCustNew.setUnitNumber(num);// 企业编号
									enterpriseCustNew.setCompanyId(companyId);// 公司id
									enterpriseCustNewMapper.insertEnterpriseCustNew(enterpriseCustNew);
									bsnum++;
									MapUtils.getMap().put(key, bsnum + "|" + totalNum);
								}

							}
						};
						Thread t = new Thread(th);
						t.start();
						return Tools.msg(key, true);
					}else{ 
						String keymsg = "failed";
						return Tools.msg(keymsg, true);
					}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}			  
	}
	
   return Tools.msg("数据导入失败!",false);

	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String filePath = annex.getAnnexAddress();
	String companyId=annex.getIsMain();
	EnterpriseCustNew enterpriseCustNew = null;
	
	List<EnterpriseCustNew>  enterpriseList=new ArrayList<EnterpriseCustNew>();
	
	if (Tools.notEmpty(filePath)) {
		try {
			List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
			if (dataList != null && dataList.size() > 0) {
				enterpriseList=enterpriseCustNewMapper.listAllEnterpriseCustNew();//查询所有企业客户信息
				 String num=enterpriseCustNewMapper.selectCustCode();		
				int k=0;//用于标记重复的数据	
				for (Map<Short, String> t : dataList) {
					enterpriseCustNew = new EnterpriseCustNew();
					enterpriseCustNew.setEnterpriseName(t.get((short) 0));//企业名称
					enterpriseCustNew.setManageType(t.get((short) 1));//经营类型
					enterpriseCustNew.setAddress(t.get((short) 2));//注册地址
					enterpriseCustNew.setRepresentative(t.get((short) 3));//法人代表
					
					// DecimalFormat df = new DecimalFormat("#");用于处理电话号码存入数据库格式发生改变
			
					 enterpriseCustNew.setOfficePhone(t.get((short) 4));//办公电话
				
					 enterpriseCustNew.setEmail(t.get((short)5));//电子邮件
					
					if(t.get((short)6)!=null&&!"".equals(t.get((short)6))){
						enterpriseCustNew.setRegisterDate(sdf.parse(t.get((short)6)));//注册日期
					}else{
						enterpriseCustNew.setRegisterDate(null);//注册日期
					}
					enterpriseCustNew.setEnterpriseProperty(t.get((short) 7));//企业类型
					enterpriseCustNew.setEmergencyContact(t.get((short) 8));//紧急联系人
				
				     enterpriseCustNew.setEmergencyContactPhone(t.get((short) 9));//紧急联系电话
						  
					enterpriseCustNew.setPrincipal(t.get((short) 10));//企业委托人
					enterpriseCustNew.setBusinessAddress(t.get((short) 11));//企业地址					
					enterpriseCustNew.setEnterpriseId(UUID.randomUUID().toString());
					
					     int j=0;
						for(int i=0;i<enterpriseList.size();i++){
							if((enterpriseList.get(i).getEnterpriseName().equals(enterpriseCustNew.getEnterpriseName())
									||enterpriseList.get(i).getOfficePhone().equals(enterpriseCustNew.getOfficePhone()))){
								  j++;
							}			
						}							
						if(j==0){
							if(num==null||num.equals("")){
								num="10000";			
							}else{
								num=String.valueOf(Integer.parseInt(num)+1);
							}
							 enterpriseCustNew.setUnitNumber(num);//企业编号
							 enterpriseCustNew.setCompanyId(companyId);//公司id
							 enterpriseCustNewMapper.insertEnterpriseCustNew(enterpriseCustNew);
							 enterpriseList.add(enterpriseCustNew);
							 k++;
						}				   
				}				 
				 return Tools.msg("成功导入"+k+"条数据,失败"+(dataList.size()-k)+"条数据",true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return Tools.msg("数据导入失败!", false);
	
	}*/


	@Override
	public Info importExcelFileRes(Annex annex) {
	final String companyId=annex.getIsMain();
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String filePath = annex.getAnnexAddress();
//	SimpleDateFormat sdfForFile = new SimpleDateFormat("yyyyMMddHHmmss");// 用于给导入进来的excel文件命令
	final Map<String ,EnterpriseCustNew> codeMap=new HashMap<String ,EnterpriseCustNew>();
	List<EnterpriseCustNew>  allCustomerList=new ArrayList<EnterpriseCustNew>();
	
	List<PersonCustNew> allPersonCustNew=new ArrayList<PersonCustNew>();
	final Map<String,PersonCustNew> nameValue=new HashMap<String,PersonCustNew>();
	
//	final List<EnterpriseCustNew> repeatList=new ArrayList<EnterpriseCustNew>();
	//不符条件放入list
	final List<EnterpriseCustNew> noLoad=new ArrayList<EnterpriseCustNew>();
	if (Tools.notEmpty(filePath)) {
		try {
			final List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
//			List <EnterpriseCustNew> enterpriseCustNew=new ArrayList<EnterpriseCustNew>();
			if (dataList != null && dataList.size() > 0) {					
				List<String> nameList=new ArrayList<String>();
				List<String> officeList=new ArrayList<String>();
				allCustomerList=enterpriseCustNewMapper.listAllEnterpriseCustNew();//获取所有企业客户
				
				allPersonCustNew=personCustNewMapper.searchAllPersonCustNewByCompanyId(companyId);
				for(PersonCustNew pn:allPersonCustNew){
					if(!nameValue.containsKey(pn.getName())){
						nameValue.put(pn.getName(), pn);
					}else{
						nameValue.remove(pn.getName());
					}
				}
				allCustomerList.clear();
				
				for(int i=0;i<allCustomerList.size();i++){
					nameList.add(allCustomerList.get(i).getEnterpriseName());
					officeList.add(allCustomerList.get(i).getOfficePhone());
				}
				
				List<Map<Short, String>>  noContains=new ArrayList<Map<Short, String>> ();
				for (int n=0;n<dataList.size();n++) {
					if(!nameList.contains(dataList.get(n).get((short) 0))
							||!officeList.contains(dataList.get(n).get((short) 4))){
						noContains.add(dataList.get(n));
					}
				}
				nameList.clear();
				officeList.clear();
				dataList.clear();
				for(int n=0;n<noContains.size();n++){
					if(!nameList.contains(noContains.get(n).get((short) 0))
							||!officeList.contains(noContains.get(n).get((short) 4))){
						nameList.add(noContains.get(n).get((short)0));
						officeList.add(noContains.get(n).get((short) 4));
						dataList.add(noContains.get(n));
					}
				}
				final String key = UUID.randomUUID().toString();
					if (dataList.size() != 0) {
						Runnable th = new Runnable() {
							@Override
							public void run() {
								int totalNum = dataList.size();
								int bsnum = 0;
								String num = enterpriseCustNewMapper.selectCustCode();// 获取最大编号
								for (Map<Short, String> t : dataList) {
									final EnterpriseCustNew enterpriseCustNew = new EnterpriseCustNew();
									// 企业名称
									if (!StringUtils.isEmpty(t.get((short) 0))) {
											enterpriseCustNew.setEnterpriseName(t.get((short) 0));
										
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 经营类型
									if (!StringUtils.isEmpty(t.get((short) 1))) {
										enterpriseCustNew.setManageType(t.get((short) 1));
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 注册地址
									if (!StringUtils.isEmpty(t.get((short) 2))) {
										enterpriseCustNew.setAddress(t.get((short) 2));
									}
									// 法人代表
									String representative = t.get((short) 3);
									if (!StringUtils.isEmpty(representative)) {
										if(nameValue.containsKey(representative)){
											PersonCustNew pcn=nameValue.get(representative);
											enterpriseCustNew.setRepresentative(pcn.getCustId());
										}
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 办公电话
									if (!StringUtils.isEmpty(t.get((short) 4))) {
											enterpriseCustNew.setOfficePhone(t.get((short) 4));
										
									} else {
										noLoad.add(setEnterpriseCustNew(t));
										continue;
									}
									// 电子邮件
									if (!StringUtils.isEmpty(t.get((short) 5))) {
										enterpriseCustNew.setEmail(t.get((short) 5));
									}
									// 注册日期
									if (!StringUtils.isEmpty(t.get((short) 6).trim())) {
										try {
											enterpriseCustNew.setRegisterDate(sdf.parse(t.get((short) 6)));
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										enterpriseCustNew.setRegisterDate(null);// 注册日期
									}
									// 企业类型
									if (!StringUtils.isEmpty(t.get((short) 7))) {
										enterpriseCustNew.setEnterpriseProperty(t.get((short) 7));
									}
									// 紧急联系人
									if (!StringUtils.isEmpty(t.get((short) 8))) {
										enterpriseCustNew.setEmergencyContact(t.get((short) 8));
									}
									// 紧急联系电话
									if (!StringUtils.isEmpty(t.get((short) 9))) {
										enterpriseCustNew.setEmergencyContactPhone(t.get((short) 9));
									}
									// 企业委托人
									if (!StringUtils.isEmpty(t.get((short) 10).trim())) {
										enterpriseCustNew.setPrincipal(t.get((short) 10));
									}
									// 企业地址
									if (!StringUtils.isEmpty(t.get((short) 11))) {
										enterpriseCustNew.setBusinessAddress(t.get((short) 11));
									}

									enterpriseCustNew.setEnterpriseId(UUID.randomUUID().toString());
									if (num == null || num.equals("")) {
										num = "10000";
									} else {
										num = String.valueOf(Integer.parseInt(num) + 1);
									}
									enterpriseCustNew.setUnitNumber(num);// 企业编号
									enterpriseCustNew.setCompanyId(companyId);// 公司id
									enterpriseCustNewMapper.insertEnterpriseCustNew(enterpriseCustNew);
									bsnum++;
									MapUtils.getMap().put(key, bsnum + "|" + totalNum);
								}

							}
						};
						Thread t = new Thread(th);
						t.start();
						return Tools.msg(key, true);
					}else{ 
						String keymsg = "failed";
						return Tools.msg(keymsg, true);
					}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}			  
	}
	
   return Tools.msg("数据导入失败!",false);

	
	/*
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String filePath = annex.getAnnexAddress();
	String companyId=annex.getIsMain();
	EnterpriseCustNew enterpriseCustNew = null;
	
	List<EnterpriseCustNew>  enterpriseList=new ArrayList<EnterpriseCustNew>();
	
	if (Tools.notEmpty(filePath)) {
		try {
			List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
			if (dataList != null && dataList.size() > 0) {
				enterpriseList=enterpriseCustNewMapper.listAllEnterpriseCustNew();//查询所有企业客户信息
				 String num=enterpriseCustNewMapper.selectCustCode();		
				int k=0;//用于标记重复的数据	
				for (Map<Short, String> t : dataList) {
					enterpriseCustNew = new EnterpriseCustNew();
					enterpriseCustNew.setEnterpriseName(t.get((short) 0));//企业名称
					enterpriseCustNew.setManageType(t.get((short) 1));//经营类型
					enterpriseCustNew.setAddress(t.get((short) 2));//注册地址
					enterpriseCustNew.setRepresentative(t.get((short) 3));//法人代表
					
					// DecimalFormat df = new DecimalFormat("#");用于处理电话号码存入数据库格式发生改变
			
					 enterpriseCustNew.setOfficePhone(t.get((short) 4));//办公电话
				
					 enterpriseCustNew.setEmail(t.get((short)5));//电子邮件
					
					if(t.get((short)6)!=null&&!"".equals(t.get((short)6))){
						enterpriseCustNew.setRegisterDate(sdf.parse(t.get((short)6)));//注册日期
					}else{
						enterpriseCustNew.setRegisterDate(null);//注册日期
					}
					enterpriseCustNew.setEnterpriseProperty(t.get((short) 7));//企业类型
					enterpriseCustNew.setEmergencyContact(t.get((short) 8));//紧急联系人
				
				     enterpriseCustNew.setEmergencyContactPhone(t.get((short) 9));//紧急联系电话
						  
					enterpriseCustNew.setPrincipal(t.get((short) 10));//企业委托人
					enterpriseCustNew.setBusinessAddress(t.get((short) 11));//企业地址					
					enterpriseCustNew.setEnterpriseId(UUID.randomUUID().toString());
					
					     int j=0;
						for(int i=0;i<enterpriseList.size();i++){
							if((enterpriseList.get(i).getEnterpriseName().equals(enterpriseCustNew.getEnterpriseName())
									||enterpriseList.get(i).getOfficePhone().equals(enterpriseCustNew.getOfficePhone()))){
								  j++;
							}			
						}							
						if(j==0){
							if(num==null||num.equals("")){
								num="10000";			
							}else{
								num=String.valueOf(Integer.parseInt(num)+1);
							}
							 enterpriseCustNew.setUnitNumber(num);//企业编号
							 enterpriseCustNew.setCompanyId(companyId);//公司id
							 enterpriseCustNewMapper.insertEnterpriseCustNew(enterpriseCustNew);
							 enterpriseList.add(enterpriseCustNew);
							 k++;
						}				   
				}				 
				 return Tools.msg("成功导入"+k+"条数据,失败"+(dataList.size()-k)+"条数据",true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return Tools.msg("数据导入失败!", false);
	
	*/}
	
	//企业客户导出
	@Override
	public InputStream exportEnterperiseFile(EnterpriseCustNew enterpriseCustNew) {
		String enterpriseName ="";
		String manageType="";
		try {
			if( ""==enterpriseCustNew.getEnterpriseName()||"".equals(enterpriseCustNew.getEnterpriseName())){	
				enterpriseCustNew.setEnterpriseName(enterpriseName);
			}else{
				enterpriseName=new String(enterpriseCustNew.getEnterpriseName().getBytes("iso-8859-1"),"UTF-8");
			}	
			
			if( ""==enterpriseCustNew.getManageType()||"".equals(enterpriseCustNew.getManageType())){	
				enterpriseCustNew.setManageType(manageType);
			}else{
				manageType=new String(enterpriseCustNew.getManageType().getBytes("iso-8859-1"),"UTF-8");
			}		
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		enterpriseCustNew.setEnterpriseName(enterpriseName);
		enterpriseCustNew.setManageType(manageType);
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = {"企业编号","企业名称","经营类型","注册地址","法人代表","企业办公电话", "企业电子邮件", "注册日期", "企业类型","紧急联系人","紧急联系人电话","企业委托人","企业地址"};
		String[] fields = {"unitNumber","enterpriseName","manageType","address","representative","officePhone","email","s_registerDate","enterpriseProperty",
				"emergencyContact","emergencyContactPhone","principal","businessAddress"};
        List<EnterpriseCustNew> dataset = enterpriseCustNewMapper.listEnterpriseCustNewListByCondition(enterpriseCustNew);
      
        if(dataset.size() > 0){       
        	for(int i=0;i<dataset.size();i++){
        		Date date =dataset.get(i).getRegisterDate();
     		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     		   if(date != null){
   		         String s1 = sdf.format(date); 
   		         dataset.get(i).setS_registerDate(s1);
   		     }else{
   		    	 dataset.get(i).setS_registerDate(null);		    	 
   		      }
        	}	
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("企业客户");
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
	public InputStream importEnterpriseExcelTemplet() {
		// TODO Auto-generated method stub
		List<EnterpriseCustNew> enterprise=new ArrayList<EnterpriseCustNew>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		enterprise.add(null);
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = {"企业名称","经营类型","注册地址","法人代表","企业办公电话", "企业电子邮件", "注册日期", "企业类型","紧急联系人","紧急联系人电话","企业委托人","企业地址"};
		String[] fields = {"enterpriseName","manageType","address","representative","officePhone","eMail","registerDate","enterpriseProperty",
				"emergencyContact","emergencyContactPhone","principal","businessAddress"};
        List<EnterpriseCustNew> dataset = new ArrayList<EnterpriseCustNew>();
        ExcelInfo exl=new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("企业客户导入模版");
		exl.setList(dataset);
		list.add(exl);
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

}