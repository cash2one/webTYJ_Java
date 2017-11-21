/**
 * 创建 by 肖聪 2015/6/4
 * 添加产权变更实现类
 */
package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;





import com.flf.entity.Authorization;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.ChangeTitle;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.SearchCar;
import com.flf.entity.SearchPersonAndEnterprise;
import com.flf.entity.StallNew;
import com.flf.mapper.AuthorizationMapper;
import com.flf.mapper.ChangeTitleMapper;
import com.flf.mapper.EnterpriseCustNewMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.RegionNewMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.service.ChangeTitleService;


public class ChangeTitleServiceImpl implements ChangeTitleService{
	
	public AuthorizationMapper getAuthorizationMapper() {
		return authorizationMapper;
	}

	public void setAuthorizationMapper(AuthorizationMapper authorizationMapper) {
		this.authorizationMapper = authorizationMapper;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(
			PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}

	
	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	public EnterpriseCustNewMapper getEnterpriseCustNewMapper() {
		return enterpriseCustNewMapper;
	}

	public void setEnterpriseCustNewMapper(
			EnterpriseCustNewMapper enterpriseCustNewMapper) {
		this.enterpriseCustNewMapper = enterpriseCustNewMapper;
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

	public RegionNewMapper getRegionNewMapper() {
		return regionNewMapper;
	}

	public void setRegionNewMapper(RegionNewMapper regionNewMapper) {
		this.regionNewMapper = regionNewMapper;
	}

	

	public ChangeTitleMapper getChangeTitleMapper() {
		return changeTitleMapper;
	}
    
	public void setChangeTitleMapper(ChangeTitleMapper changeTitleMapper) {
		this.changeTitleMapper = changeTitleMapper;
	}
	@Override
	public List<ChangeTitle> listAllChangeTitle(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		return changeTitleMapper.listAllChangeTitle(changeTitle);
	}

	@Override
	public List<ChangeTitle> listPageChangeTitle(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		return changeTitleMapper.listPageChangeTitle(changeTitle);
	}

	@Override
	public ChangeTitle getChangeTitleById(String changeTitleId) {
		// TODO Auto-generated method stub
		return changeTitleMapper.getChangeTitleById(changeTitleId);
	}

	@Override
	public int insertChangeTitle(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		return changeTitleMapper.insertChangeTitle(changeTitle);
	}

	@Override
	public int updateChangeTitle(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		return changeTitleMapper.updateChangeTitle( changeTitle);
	}

	@Override
	public PageRestful listPageChangeTitleRestful(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<ChangeTitle> changeTitles =changeTitleMapper.listPageChangeTitle(changeTitle);
		changeTitles.add(0,null);
		pagerestful.setChangeTitles(changeTitles);
		pagerestful.setPage(changeTitle.getPage());
		return pagerestful;
	}

	@Override
	public List<ChangeTitle> listAllChangeTitleRestful(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		return changeTitleMapper.listAllChangeTitle(changeTitle);
	}

	@Override
	public ChangeTitle getChangeTitleByIdRestful(String changeTitleId) {
		// TODO Auto-generated method stub
		return changeTitleMapper.getChangeTitleById(changeTitleId);
	}

	@Override
	public void deleteChangeTitleRestful(String changeTitleId) {
		// TODO Auto-generated method stub
		changeTitleMapper.deleteChangeTitle(changeTitleId);
	}

	@Override
	public void insertChangeTitleRestful(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		changeTitleMapper.insertChangeTitle(changeTitle);
	}

	@Override
	public void updateChangeTitleRestful(ChangeTitle changeTitle) {
		// TODO Auto-generated method stub
		changeTitleMapper.updateChangeTitle( changeTitle);
	}

	@Override
	public List<ChangeTitle> getChangeTitleByStallIdRestful(String stallId) {
		// TODO Auto-generated method stub
		return changeTitleMapper.getChangeTitleByStallId(stallId);
	}  
    private ChangeTitleMapper changeTitleMapper;
	
	private HouseNewMapper houseNewMapper;
	
    private StallNewMapper stallNewMapper;
	
	private RegionNewMapper regionNewMapper;
	
	private PersonCustNewMapper personCustNewMapper;
	
	private EnterpriseCustNewMapper enterpriseCustNewMapper;
	
	private PersonBuildingNewMapper personBuildingNewMapper;
	
	private AuthorizationMapper authorizationMapper;

	
	/**
	 * 创建 by 肖聪 
	 * 查询与产权相关的房屋与车位的详细信息
	 * 2015/6/25
	 */
	@Override
	public List<SearchPersonAndEnterprise> getAllchangeTitleAndPerson() {
		// TODO Auto-generated method stub
		List<SearchPersonAndEnterprise> SearchPersonAndEnterprises = new ArrayList<SearchPersonAndEnterprise>();
		List<HouseNew>houseNews=houseNewMapper.listAllHouseNew();
		List<StallNew>stallNews=stallNewMapper.listAllStallNew();
		
		for(HouseNew houseNew:houseNews){
			SearchPersonAndEnterprise searchPersonAndEnterpriseone = new SearchPersonAndEnterprise();
			searchPersonAndEnterpriseone.setHouseNew(houseNew);			
			searchPersonAndEnterpriseone.setPersonCustNew(personCustNewMapper.getPersonCustNewByHouseId(houseNew.getId()));
			searchPersonAndEnterpriseone.setRegionNew(regionNewMapper.getRegionNewByHouseId(houseNew.getId()));
			searchPersonAndEnterpriseone.setEnterpriseCustNew(enterpriseCustNewMapper.getenterpriseCustNewByHouseId(houseNew.getId()));
			SearchPersonAndEnterprises.add(searchPersonAndEnterpriseone);		
		}
		for(StallNew stallNew:stallNews){
			SearchPersonAndEnterprise searchPersonAndEnterpriseone = new SearchPersonAndEnterprise();
			searchPersonAndEnterpriseone.setStallNew(stallNew);
			searchPersonAndEnterpriseone.setPersonCustNew(personCustNewMapper.getPersonCustNewByStallNewId(stallNew.getStallId()));
			searchPersonAndEnterpriseone.setRegionNew(regionNewMapper.getRegionNewByStallNewId(stallNew.getStallId()));
			searchPersonAndEnterpriseone.setEnterpriseCustNew(enterpriseCustNewMapper.getenterpriseCustNewByStallNewId(stallNew.getStallId()));
			SearchPersonAndEnterprises.add(searchPersonAndEnterpriseone);
		}
		return SearchPersonAndEnterprises;
	} 
	
	/**
	 * 创建 by 肖聪 
	 * 改变产权人或公司  
	 * 2015/6/25
	 */
	@Override
	public void updatePersonBuildingNewByState(String buildingStructureId){
		personBuildingNewMapper.updatePersonBuildingNewByState(buildingStructureId);	
	}
	/**
	 * 创建 by 肖聪 
	 * 根据条件查询出人或者公司
	 * 2015/6/25
	 */
	
	@Override
	public SearchPersonAndEnterprise  searchAllchangeTitleAndPerson(SearchPersonAndEnterprise searchPersonAndEnterprise) {
		SearchPersonAndEnterprise searchPersonAndEnterpriseone = new SearchPersonAndEnterprise();
		if(searchPersonAndEnterprise.getEnterpriseName()!=null || searchPersonAndEnterprise.getRepresentative()!=null ){
			List<EnterpriseCustNew> enterpriseCustNews=enterpriseCustNewMapper.getSearchEnterprise(searchPersonAndEnterprise);
			searchPersonAndEnterpriseone.setEnterpriseCustNew(enterpriseCustNews);
			return  searchPersonAndEnterpriseone;
		}
		else
		{
			List<PersonCustNew> personCustNews=personCustNewMapper.getSearchPersonCust(searchPersonAndEnterprise);
			searchPersonAndEnterpriseone.setPersonCustNew(personCustNews);
			return  searchPersonAndEnterpriseone;
		}
	}

	//改变资产产权
	@Override
	public void changeProperty(ChangeTitle changeTitle) {
		
		// TODO Auto-generated method stub
		String uuid= UUID.randomUUID().toString();  //生成主键id
		changeTitleMapper.insertChangeTitle(changeTitle);
		personBuildingNewMapper.updatePersonBuildingNewByState(changeTitle.getPersonBuildingNew().getBuildingStructureId());
		List<Authorization> aulist =authorizationMapper.listAuthorizationByHouseId(changeTitle.getHouseId());
		if(aulist!=null && aulist.size()>0){
			for(Authorization au : aulist){
				au.setStatus("0");
				authorizationMapper.updateAuthorization(au);
			}
		}
		//changeTitle.getPersonBuildingNew().setCustId(uuid);//添加客户信息与资产关联外键
		personBuildingNewMapper.insertPersonBuildingNew(changeTitle.getPersonBuildingNew());
	}

	@Override
	public List<ChangeTitle> getChangeTitleHistoryByCustId(String custId) {
		List<ChangeTitle> list = new ArrayList<ChangeTitle>();
		List<ChangeTitle> house_list = changeTitleMapper.getHouseHistoryByCustId(custId);
		List<ChangeTitle> store_list = changeTitleMapper.getStoreHistoryByCustId(custId);
		List<ChangeTitle> stall_list = changeTitleMapper.getStallHistoryByCustId(custId);
		if(house_list!=null && house_list.size()>0){
			list.addAll(house_list);
		}if(store_list!=null && store_list.size()>0){
			list.addAll(store_list);
		}if(stall_list!=null && stall_list.size()>0){
			list.addAll(stall_list);
		}
		return list;
	}
}
