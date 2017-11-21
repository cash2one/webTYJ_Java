/**
 * @Title: PersonVipServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-17 下午3:23:00
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.PendingApproval;
import com.flf.entity.PersonCustNew;
import com.flf.entity.PersonEmphasis;
import com.flf.entity.PersonVip;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.PendingApprovalMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.PersonVipMapper;
import com.flf.mapper.VipProjectStaffMapper;
import com.flf.service.PersonVipService;
import com.flf.util.JsonUtil;

/**
 * @ClassName: PersonVipServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-17 下午3:23:00
 *
 */

public class PersonVipServiceImpl implements  PersonVipService{
	
	private PersonVipMapper personVipMapper;
	
	private PersonCustNewMapper personCustNewMapper;
	
	private AnnexMapper annexMapper;
	
	private VipProjectStaffMapper vipProjectStaffMapper;
	
	private PendingApprovalMapper pendingApprovalMapper;

	/*
	  * <p>Title: listPagePersonVipRestful</p>
	  * <p>Description: </p>
	  * @param personVip
	  * @return
	  * @see com.flf.service.PersonVipService#listPagePersonVipRestful(com.flf.entity.PersonVip)
	  */
	
	
	public PendingApprovalMapper getPendingApprovalMapper() {
		return pendingApprovalMapper;
	}

	public void setPendingApprovalMapper(PendingApprovalMapper pendingApprovalMapper) {
		this.pendingApprovalMapper = pendingApprovalMapper;
	}

	public PersonVipMapper getPersonVipMapper() {
		return personVipMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	public void setPersonVipMapper(PersonVipMapper personVipMapper) {
		this.personVipMapper = personVipMapper;
	}

	public VipProjectStaffMapper getVipProjectStaffMapper() {
		return vipProjectStaffMapper;
	}

	public void setVipProjectStaffMapper(VipProjectStaffMapper vipProjectStaffMapper) {
		this.vipProjectStaffMapper = vipProjectStaffMapper;
	}

	@Override
	public PageRestful listPagePersonVipRestful(PersonVip personVip) {
		PageRestful pagerestful=new PageRestful();
		List<PersonVip> personVips =personVipMapper.listPagePersonVip(personVip);
		/*for (PersonCustNew perCust : personCusts) {
			Date date=new Date();
			if (perCust.getBirthday()!=null) {
				perCust.setAge(date.getYear()-perCust.getBirthday().getYear());	 //添加年龄
			}
		}*/
		personVips.add(0,null);
		pagerestful.setPersonVips(personVips);
		pagerestful.setPage(personVip.getPage());
		return pagerestful;
	}

	/*
	  * <p>Title: listAllPersonVip</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.PersonVipService#listAllPersonVip()
	  */
	
	
	@Override
	public List<PersonVip> listAllPersonVip() {
		// TODO Auto-generated method stub
		return personVipMapper.listAllPersonVip();
	}

	/*
	  * <p>Title: getPersonVipByIdRest</p>
	  * <p>Description: </p>
	  * @param personVipId
	  * @return
	  * @see com.flf.service.PersonVipService#getPersonVipByIdRest(java.lang.String)
	  */	
	
	
	@Override
	public PersonVip getPersonVipByIdRest(String personVipId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	  * <p>Title: AddPersonVip</p>
	  * <p>Description: </p>
	  * @param personVip
	  * @see com.flf.service.PersonVipService#AddPersonVip(com.flf.entity.PersonVip)
	  */
	
	
	/**
	 * vip客户新增
	 * yinlei
	 */
	@Override
	public void AddPersonVip(PersonVip personVip) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		personVip.setVipId(id);
		personVip.setVipStart(new Date());
		personVip.setApprovalId(UUID.randomUUID().toString());
		Integer s=personVipMapper.insertPersonVip(personVip);
		if(s>0){
			PendingApproval pendingApproval=new PendingApproval();
			pendingApproval.setPendingApprovalId(personVip.getApprovalId());
			pendingApproval.setCurrentDates(new Date());
			pendingApproval.setTypes(personVip.getApplystype());
			pendingApproval.setTheme(personVip.getTheme());
			pendingApprovalMapper.insert(pendingApproval);
			if(personVip.getAnnexs()!=null &&  personVip.getAnnexs().size()>0){
				for (Annex annex : personVip.getAnnexs()) {
					annex.setRelationId(id);
					annex.setAnnexAddress(personVip.getApplyfilePath());
					String dt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
					annex.setAnnexTime(dt);
					annexMapper.insertAnnex(annex);
				}
			}
			
			
		}
		
		
	}

	/*
	  * <p>Title: UpdatePersonVip</p>
	  * <p>Description: </p>
	  * @param personVip
	  * @see com.flf.service.PersonVipService#UpdatePersonVip(com.flf.entity.PersonVip)
	  */
	
	
	@Override
	public void UpdatePersonVip(PersonVip personVip) {
		// TODO Auto-generated method stub
		personVipMapper.updatePersonVip(personVip);
		
	}

	/*
	  * <p>Title: DeletePersonVip</p>
	  * <p>Description: </p>
	  * @param personVip
	  * @see com.flf.service.PersonVipService#DeletePersonVip(java.lang.String)
	  */
	
	
	@Override
	public void DeletePersonVip(String personVip) {
		// TODO Auto-generated method stub
		personVipMapper.deletePersonVip(personVip);
		vipProjectStaffMapper.deleteVipProStaffByVipid(personVip);
	}

	/**
	 * 根据审核状态查询vip客户信息
	 * yinlei
	 */
	@Override
	public List<PersonVip> selectPersonVipbyState(Byte reviewState) {
		// TODO Auto-generated method stub
		return personVipMapper.selectPersonVipbyState(reviewState);
	}

	/**
	 * vip客户审核保存
	 * yinlei
	 */
	@Override
	public void UpdatePersonVipReview(PersonVip personVip) {
		// TODO Auto-generated method stub
		Date vipEnd=new Date();
		personVip.setVipEnd(vipEnd);
		if(personVip.getReviewState()==1){
				personVipMapper.updatePersonVip(personVip);			
		}
		if(personVip.getReviewState()==2){			
			personVip.setRefuseReason(personVip.getRefuseReason());
				personVipMapper.updatePersonVip(personVip);
		}
	
	}

	@Override
	public PersonVip getPersonVipData(String custId) {
		// TODO Auto-generated method stub
		return personVipMapper.getPersonVipData(custId);
	}

	@Override
	public PersonVip getPersonVipDataById(String custId) {
		// TODO Auto-generated method stub
		return personVipMapper.getPersonVipDataById(custId);
	}

	@Override
	public PersonVip getPersonVipState(String custId) {
		// TODO Auto-generated method stub
		return personVipMapper.getPersonVipState(custId);
	}

	////查询vip客户申请
	@Override
	public String getPersonVipSum(String theme) {
		Integer in ;
		in = personVipMapper.getPersonVipSum(theme);
		return JsonUtil.success(in, true);
	}

	////查询vip客户失效申请
	@Override
	public String getFailPersonVipSum(String theme) {
		Integer in ;
		in = personVipMapper.getFailPersonVipSum(theme);
		return JsonUtil.success(in, true);
	}
}
