/**
 * @Title: PersonEmphasisServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-17 下午2:44:34
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.PendingApproval;
import com.flf.entity.PersonEmphasis;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.PendingApprovalMapper;
import com.flf.mapper.PersonEmphasisMapper;
import com.flf.service.PersonEmphasisService;
import com.flf.util.JsonUtil;

/**
 * @ClassName: PersonEmphasisServiceImpl
 * @Description: TODO
 * @author chenjie
 * @date 2015-8-6 下午15:54:34
 *
 */

public class PersonEmphasisServiceImpl implements PersonEmphasisService {

	private PersonEmphasisMapper personEmphasisMapper;
	private AnnexMapper annexMapper;
	
	private PendingApprovalMapper pendingApprovalMapper;
	
	/*
	  * <p>Title: listPagePersonEmphasisRestful</p>
	  * <p>Description: </p>
	  * @param personEmphasis
	  * @return
	  * @see com.flf.service.PersonEmphasisService#listPagePersonEmphasisRestful(com.flf.entity.PersonEmphasis)
	  */
	
	
	public PendingApprovalMapper getPendingApprovalMapper() {
		return pendingApprovalMapper;
	}

	public void setPendingApprovalMapper(PendingApprovalMapper pendingApprovalMapper) {
		this.pendingApprovalMapper = pendingApprovalMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public PersonEmphasisMapper getPersonEmphasisMapper() {
		return personEmphasisMapper;
	}

	public void setPersonEmphasisMapper(PersonEmphasisMapper personEmphasisMapper) {
		this.personEmphasisMapper = personEmphasisMapper;
	}

	@Override
	public PageRestful listPagePersonEmphasisRestful(
			PersonEmphasis personEmphasis) {
		// TODO Auto-generated method stub
		
		PageRestful pagerestful=new PageRestful();
		List<PersonEmphasis> personEmphasiss =personEmphasisMapper.listPagePersonEmphasis(personEmphasis);
		/*for (PersonCustNew perCust : personCusts) {
			Date date=new Date();
			if (perCust.getBirthday()!=null) {
				perCust.setAge(date.getYear()-perCust.getBirthday().getYear());	 //添加年龄
			}
		}*/
		personEmphasiss.add(0,null);
		pagerestful.setPersonEmphasiss(personEmphasiss);
		pagerestful.setPage(personEmphasis.getPage());
		return pagerestful;
		
	}

	/*
	  * <p>Title: listAllPersonEmphasis</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.PersonEmphasisService#listAllPersonEmphasis()
	  */
	
	
	@Override
	public List<PersonEmphasis> listAllPersonEmphasis() {
		// TODO Auto-generated method stub
		return personEmphasisMapper.listAllPersonEmphasis();
	}

	/*
	  * <p>Title: getPersonEmphasisByIdRest</p>
	  * <p>Description: </p>
	  * @param PersonEmphasisId
	  * @return
	  * @see com.flf.service.PersonEmphasisService#getPersonEmphasisByIdRest(java.lang.String)
	  */
	
	
	@Override
	public PersonEmphasis getPersonEmphasisByIdRest(String PersonEmphasisId) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.selectPersonEmphasis(PersonEmphasisId);
	}
	
	@Override
	public  List<Annex> getPersonEmphasisAnnexById(String PersonEmphasisId){
		// TODO Auto-generated method stub
		return annexMapper.getAnnexbyRelationId(PersonEmphasisId);
	}
	
	

	/*
	  * <p>Title: AddPersonEmphasis</p>
	  * <p>Description: </p>
	  * @param personEmphasis
	  * @see com.flf.service.PersonEmphasisService#AddPersonEmphasis(com.flf.entity.PersonEmphasis)
	  */
	
	
	@Override
	public void AddPersonEmphasis(PersonEmphasis personEmphasis) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		personEmphasis.setEmphasisId(id);
		personEmphasis.setApplydate(new Date());
		System.err.println(id);
		personEmphasis.setApprovalId(UUID.randomUUID().toString());
		personEmphasis.setApplyfilepath(personEmphasis.getApplyfilepath());
		Integer s=personEmphasisMapper.insertPersonEmphasis(personEmphasis);
		if(s>0){
			PendingApproval pendingApproval=new PendingApproval();
			pendingApproval.setPendingApprovalId(personEmphasis.getApprovalId());
			pendingApproval.setTypes(personEmphasis.getApplystype());
			pendingApproval.setTheme(personEmphasis.getTheme());
			pendingApproval.setCurrentDates(new Date());			
			pendingApprovalMapper.insert(pendingApproval);
			
		}
	
		if(personEmphasis.getApplyfilepath()==null)return;
		for(Annex pm:personEmphasis.getApplyfilepath()){
			pm.setRelationId(id);
			String dt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pm.setAnnexTime(dt);
			annexMapper.insertAnnex(pm);
		}
	}

	/*
	  * <p>Title: UpdatePersonEmphasis</p>
	  * <p>Description: </p>
	  * @param personEmphasis
	  * @see com.flf.service.PersonEmphasisService#UpdatePersonEmphasis(com.flf.entity.PersonEmphasis)
	  */
	
	
	@Override
	public void UpdatePersonEmphasis(PersonEmphasis personEmphasis) {
		// TODO Auto-generated method stub
		personEmphasis.setApplyeddate(new Date());
		personEmphasisMapper.updatePersonEmphasis(personEmphasis);
		
	}

	/*
	  * <p>Title: DeletePersonEmphasis</p>
	  * <p>Description: </p>
	  * @param PersonEmphasis
	  * @see com.flf.service.PersonEmphasisService#DeletePersonEmphasis(java.lang.String)
	  */
	
	
	@Override
	public void DeletePersonEmphasis(String PersonEmphasis) {
		// TODO Auto-generated method stub
		personEmphasisMapper.deletePersonEmphasis(PersonEmphasis);
	}

	@Override
	public List<PersonEmphasis> listPersonEmphasisBySta(int status) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.listPersonEmphasisBySta(status);
	}

	@Override
	public PersonEmphasis getPersonEmphasisData(String custId) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.getPersonEmphasisData(custId);
	}

	@Override
	public PersonEmphasis getPersonEmphasisDataById(String custId) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.getPersonEmphasisDataById(custId);
	}

	@Override
	public PersonEmphasis getPersonEmphasisDataByapprovalId(String approvalId) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.getPersonEmphasisDataByapprovalId(approvalId);
	}

	@Override
	public PersonEmphasis getPersonEmphasisState(String custId) {
		// TODO Auto-generated method stub
		return personEmphasisMapper.getPersonEmphasisState(custId);
	}
	
	
	//查询重点客户申请数量
	@Override
	public String getPersonEmphasisSum(String theme) {
		Integer in;
		in = personEmphasisMapper.getPersonEmphasisSum(theme);
		return JsonUtil.success(in, true);
	}
	//查询重点客户失效申请数量
	@Override
	public String getFailPersonEmphasisSum(String theme) {
		Integer in;
		in = personEmphasisMapper.getFailPersonEmphasisSum(theme);
		return JsonUtil.success(in, true);
	}

}
