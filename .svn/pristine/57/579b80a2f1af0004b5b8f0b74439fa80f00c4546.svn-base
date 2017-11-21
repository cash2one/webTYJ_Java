/**
 * 修改 by xiaocong on 2015/6/1
 * 新增实现去掉租客表后的租赁表功能
 */
package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.CarInfo;
import com.flf.entity.Entrance;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.NewLease;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.Search;
import com.flf.entity.StoreNew;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.NewLeaseMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.service.NewLeaseService;

import net.sf.json.JSONObject;

public class NewLeaseServiceImpl implements NewLeaseService {

	private NewLeaseMapper newLeaseMapper;

    private HouseNewMapper houseNewMapper;
	
	private PersonBuildingNewMapper personBuildingNewMapper;  
	
	private AnnexMapper annexMapper;
	
	private StoreNewMapper storeNewMapper;

	public StoreNewMapper getStoreNewMapper() {
		return storeNewMapper;
	}

	public void setStoreNewMapper(StoreNewMapper storeNewMapper) {
		this.storeNewMapper = storeNewMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}
	
	public HouseNewMapper getHouseNewMapper() {
		return houseNewMapper;
	}

	public void setHouseNewMapper(HouseNewMapper houseNewMapper) {
		this.houseNewMapper = houseNewMapper;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(
			PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	public NewLeaseMapper getNewLeaseMapper() {
		return newLeaseMapper;
	}

	public void setNewLeaseMapper(NewLeaseMapper newLeaseMapper) {
		this.newLeaseMapper = newLeaseMapper;
	}

	@Override
	public PageRestful listPageNewLeaseRestful(NewLease newLease) {
		// TODO Auto-generated method stub
		PageRestful pagerestful = new PageRestful();
		List<NewLease> newLeases = newLeaseMapper.listPageNewLease(newLease);
		newLeases.add(0, null);
		pagerestful.setNewLeases(newLeases);
		pagerestful.setPage(newLease.getPage());
		return pagerestful;
	}

	@Override
	public List<NewLease> listAllNewLeaseRestful(NewLease newLease) {
		// TODO Auto-generated method stub
		return newLeaseMapper.listAllNewLease(newLease);
	}

	@Override
	public List<NewLease> getNewLeaseByIdRestful(String id) {
		// TODO Auto-generated method stub
		return newLeaseMapper.getNewLeaseById(id);
	}

	@Override
	public void deleteNewLeaseRestful(String id) {
		String ids[]=id.split(",");
		for (String realId : ids) {
			// 获取单个租赁信息
			List<NewLease> newlease = newLeaseMapper.getNewLeaseById(realId);
			String personIds = newlease.get(0).getLeasepersonId();
			String buildingStructureId = newlease.get(0).getHonseId();
			String personId[] = personIds.split(",");
//			逻辑删除租客关系
			for (String pid : personId) {
				if (!pid.equals("") && pid != null && !buildingStructureId.equals("") && buildingStructureId != null) {
					personBuildingNewMapper.deletePersonBuildingByCustId(pid, buildingStructureId);
				}
			}
			newLeaseMapper.deleteNewLease(realId);
		}
		
	}

	
	@Override
	public void insertNewLeaseRestful(NewLease newLease) {
		List<PersonBuildingNew> personBuildingNews = newLease.getPersonBuildingNew();
		Integer result =0;
		String uuid = UUID.randomUUID().toString();
		newLease.setId(uuid);
		String leasePersonIds = "";
		String leasePersonNames = "";
		for(PersonBuildingNew personBuildingNew:personBuildingNews)
		{
			leasePersonIds += personBuildingNew.getCustId()+",";
			leasePersonNames += personBuildingNew.getName()+",";
			personBuildingNewMapper.insertPersonBuildingNew(personBuildingNew);			
		}
		//去除最后的逗号
		leasePersonIds = leasePersonIds.substring(0,leasePersonIds.length()-1);
		leasePersonNames = leasePersonNames.substring(0,leasePersonNames.length()-1);
		
		newLease.setLeasepersonId(leasePersonIds);
		newLease.setLeasePersonName(leasePersonNames);
		result=newLeaseMapper.insertNewLease(newLease);
		
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if (newLease != null) {
			List<Annex> annexList =newLease.getAnnexs();
			if (result > 0) {
				if (annexList != null && annexList.size() > 0) {
					for (Annex annex : annexList) {
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
		
		
	}

	@Override
	public void updateNewLeaseRestful(NewLease newLease) {
		String id = newLease.getId();
		//获取之前的数据
		List<NewLease> list = newLeaseMapper.getNewLeaseById(id);
		NewLease oldNewLease = list.get(0);
		
		String buildingStructureId = oldNewLease.getHonseId();
		//先删除关系租客房屋关系
		String oldPersonId[] = oldNewLease.getLeasepersonId().split(",");//旧的租户id集合
		String personId[] = newLease.getLeasepersonId().split(",");//新的租户Id集合
		//删除删掉的租户房屋关系
		for(int i=0;i<oldPersonId.length;i++){
			int num=0;
			for(String pid:personId){
				if(!oldPersonId[i].equals(pid)){
					continue;
				}
				num=1;
			}
			if(num==0){				
				personBuildingNewMapper.deletePersonBuildingByCustId(oldPersonId[i], buildingStructureId);
			}
		}
		//增加新增的租户房屋关系
		PersonBuildingNew pbn = new PersonBuildingNew();
		pbn.setState((byte)0);
		pbn.setBuildingStructureId(buildingStructureId);
		pbn.setCustType("租客");
		for(int i=0;i<personId.length;i++){
			int num=0;
			for(String oid:oldPersonId){
				if(!personId[i].equals(oid)){
					continue;
				}
				num=1;
			}
			if(num==0){				
				pbn.setPersonBuildingId(UUID.randomUUID().toString());
				pbn.setCustId(personId[i]);
				personBuildingNewMapper.insertPersonBuildingNew(pbn);
			}
		}

		Integer n =newLeaseMapper.updateNewLease(newLease);
		if (n > 0) {
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			List<Annex> annexList1 = annexMapper.getAnnexbyRelationId(id);// 根据关系id查询附件表是否存在文件信息
			List<Annex> annexList =newLease.getAnnexs();// 得到传过来的文件列表
			if (annexList1 != null && annexList1.size() > 0) {// 存在 文件时 将原有文件删除
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
		}
	
	}

	@Override
	public List<NewLease> getNewLeaseByleasePersonRestful(String leasePersonId) {
		// TODO Auto-generated method stub
		return newLeaseMapper.getNewLeaseByleasePerson(leasePersonId);
	}

	@Override
	public List<NewLease> getNewLeaseByContract(String contractNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * 根据搜索条件查询办理人的fan租赁信息
     * @param Search
     * @return
     */
	@Override
	public List<NewLease> listSearchLease(Search search) {
		// TODO Auto-generated method stub
		return	newLeaseMapper.listSearchLease(search);
 
	}

	@Override
	public List<NewLease> listSearchLeaseone(Search search) {
		// TODO Auto-generated method stub
		return newLeaseMapper.listSearchLeaseone(search);
	}

	@Override
	public List<NewLease> listSearchLeaseAu(Search search) {
		// TODO Auto-generated method stub
		List<NewLease>leases=new ArrayList<NewLease>();
		List<NewLease> leasesone=newLeaseMapper.listSearchLeaseAu(search);
		List<NewLease> leasestwo=newLeaseMapper.listSearchLeaseone(search);
		if(leasesone != null && leasesone.size() > 0){
			for(NewLease hn : leasesone){
				List<Entrance> entrances=hn.getEntrances();
				entrances.add(0,null);
			    hn.setEntrances(entrances);
				leases.add(hn);
			}}
			if(leasestwo != null && leasestwo.size() > 0){
				for(NewLease hne : leasestwo){
					List<Entrance> entrancesone=hne.getEntrances();
					entrancesone.add(0,null);
					hne.setEntrances(entrancesone);
					
					leases.add(hne);
				}}
			
		return leases;
	}

	@Override
	public PageRestful listPageListSearchLease(NewLease newLease) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<NewLease> leases = newLeaseMapper.listPageListSearchLease(newLease);
		/*设置租赁状态,在有效期中的为租赁中，其余已结束*/
		Date date = new Date();
		for (NewLease newLease2 : leases) {
			Date endTime = newLease2.getHireFinishDate();
			if(date.getTime()<endTime.getTime()){
				newLease2.setAtRent("租赁中");
			}else{
				newLease2.setAtRent("已结束");
			}
		}
		leases.add(0, null);
		pageRestful.setNewLeases(leases);
		pageRestful.setPage(newLease.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPagegetNewLeasesByHonseId(NewLease newLease) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<NewLease> newLeases = newLeaseMapper.listPagegetNewLeasesByHonseId(newLease);
		newLeases.add(0, null);
		pageRestful.setNewLeases(newLeases);
		pageRestful.setPage(newLease.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageNewLeaseByContion(NewLease newLease) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<NewLease> newLeases = newLeaseMapper.listPageNewLeaseByContion(newLease);
		newLeases.add(0, null);
		pageRestful.setNewLeases(newLeases);
		pageRestful.setPage(newLease.getPage());
		return pageRestful;
	}

	@Override
	public String addNewLease(String jsonStr, String fileUrl) {
		try {
			
			NewLease newLease = (NewLease) JSONObject.toBean(JSONObject.fromObject(jsonStr), NewLease.class);
			String leaseId = UUID.randomUUID().toString();
			newLease.setId(leaseId);
			newLeaseMapper.insertNewLease(newLease);
			PersonBuildingNew personBuildingNew = new PersonBuildingNew();
			personBuildingNew.setPersonBuildingId(UUID.randomUUID().toString());
			personBuildingNew.setCustId(newLease.getLeasepersonId());
			personBuildingNew.setBuildingStructureId(newLease.getHonseId());
			personBuildingNew.setCustType("租客");
			personBuildingNew.setRelationDate(new Date());
			personBuildingNewMapper.insertPersonBuildingNew(personBuildingNew);
			Annex annex = new Annex();
			annex.setAnnexId(UUID.randomUUID().toString());
			annex.setRelationId(leaseId);
			annex.setAnnexType(0);
			annex.setAnnexName(fileUrl);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			annex.setAnnexTime(simpleDateFormat.format(new Date()));
			annexMapper.insertAnnex(annex);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

}
