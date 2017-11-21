package com.flf.service.impl;

public class AppUserAuditServiceImpl implements com.flf.service.AppUserAuditService {
	private java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@org.springframework.beans.factory.annotation.Autowired
	private com.flf.mapper.StaffMapper staffMapper;
	/**
	 * 
	 * @param loginNameAndCompanyIdJson
	 * @return
	 */
	@Override
	public String editProcessStatus2ByLoginNameAndCompanyId(String loginNameAndCompanyIdJson) {
		com.flf.entity.Staff staff = new com.flf.entity.Staff();
		net.sf.json.JSONObject resultInf = net.sf.json.JSONObject.fromObject(loginNameAndCompanyIdJson);//
		String loginName=resultInf.getString("login_name");
		String companyId=resultInf.getString("company_id");
		staff.setStaffId(loginName);
		staff.setCompanyId(companyId);
		int flag=staffMapper.updateProcessStatus2ByLoginNameAndCompanyId(staff);
		if(flag > 0){
			return "success";
		}
		return "failed";
	}
	
	@Override
	public String agree_CheckedAndFillUserInfoFromAPP(String infos) {
		boolean beOk = true;
		com.flf.entity.Staff staff = new com.flf.entity.Staff();
		net.sf.json.JSONObject resultInf=null;
		try{
			System.out.println("===========================================================================================");
			if(infos!=null){
				System.out.println(infos);
			}else{
				beOk = false;
			}
			System.out.println("===========================================================================================");
			resultInf = net.sf.json.JSONObject.fromObject(infos);
			System.out.println("===========================================================================================");
			if(resultInf!=null){
				System.out.println(resultInf);
			}else{
				beOk = false;
			}
			System.out.println("===========================================================================================");
			
			String loginName = resultInf.getString("loginName");
			String companyId = resultInf.getString("companyId");
			
			if(loginName==null||"".equals(loginName)||companyId==null||"".equals(companyId)){
				beOk = false;
			}
			
			staff.setCompanyId(companyId);
			staff.setUserAppId(loginName);
			
		}catch(Exception e){
			beOk = false;
		}
		try {
			if(beOk==false)
				return com.flf.util.JsonUtil.failure("0", false);
			try {
				if (!org.apache.commons.lang3.StringUtils.isEmpty(resultInf.get("birthday").toString())) {

					staff.setBirthday(fmt.parse(resultInf.get("birthday").toString()));
				} else {
					staff.setBirthday(null);// 出生日期
				}
			} catch (java.lang.NullPointerException e) {
				staff.setBirthday(null);// 出生日期
			} catch (java.text.ParseException e) {
				staff.setBirthday(null);// 出生日期
			} // 出生日期
			
			
			if(resultInf.get("cardNo")!=null && !"".equals(resultInf.get("cardNo")))
				staff.setCardNum(resultInf.get("cardNo").toString());
			if(resultInf.get("account_id")!=null && !"".equals(resultInf.get("account_id")))
				staff.setUserId(resultInf.get("account_id").toString());
			if(resultInf.get("cardType")!=null && !"".equals(resultInf.get("cardType"))){
				
				if("身份证".equals(resultInf.get("cardType").toString())){
					staff.setCardType(0);
				}else if("护照".equals(resultInf.get("cardType").toString())){
					staff.setCardType(1);
				}else if("0".equals(resultInf.get("cardType").toString())){
					staff.setCardType(0);
				}else if("1".equals(resultInf.get("cardType").toString())){
					staff.setCardType(1);
				}
			}
			/**
			if(userInfoMap.get("birthday")!=null &&!"".equals(userInfoMap.get("birthday")))
				staff.setBirthday(fmt.parse(userInfoMap.get("birthday")));
			if(userInfoMap.get("cardNo")!=null && !"".equals(userInfoMap.get("cardNo")))
				staff.setCardNum(userInfoMap.get("cardNo"));
			if(userInfoMap.get("accountId")!=null && !"".equals(userInfoMap.get("accountId")))
				staff.setUserId(userInfoMap.get("accountId"));
			if(userInfoMap.get("cardType")!=null && !"".equals(userInfoMap.get("cardType")))
				staff.setCardType(Integer.parseInt(userInfoMap.get("cardType")));
			if(userInfoMap.get("accountId")!=null && !"".equals(userInfoMap.get("accountId")))
				staff.setStaffNo(userInfoMap.get("accountId"));
			if(userInfoMap.get("phoneNo")!=null && !"".equals(userInfoMap.get("phoneNo")))
				staff.setTelphone(userInfoMap.get("phoneNo"));
			if(userInfoMap.get("userName")!=null && !"".equals(userInfoMap.get("userName")))
				staff.setStaffName(userInfoMap.get("userName"));
			
			if(userInfoMap.get("jobnumber")!=null && !"".equals(userInfoMap.get("jobnumber")))
				staff.setStaffNo(userInfoMap.get("jobnumber"));
				**/
			
			if(resultInf.get("phoneNo")!=null && !"".equals(resultInf.get("phoneNo")))
				staff.setTelphone(resultInf.get("phoneNo").toString());
			if(resultInf.get("jobnumber")!=null && !"".equals(resultInf.get("jobnumber")))
				staff.setStaffNo(resultInf.get("jobnumber").toString());
			if(resultInf.get("userName")!=null && !"".equals(resultInf.get("userName")))
				staff.setStaffName(resultInf.get("userName").toString());

			String sex = null;
			if(resultInf.get("sex")!=null){
				sex=resultInf.get("sex").toString();
			}
			
			if("男".equals(sex)){
				staff.setSex(1);
			}else if("女".equals(sex)){
				staff.setSex(0);
			}else if("1".equals(sex)){
				staff.setSex(1);
			}else if("0".equals(sex)){
				staff.setSex(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		staff.setProcessStatus(2);
		int flag=0;
		if(beOk){
			flag=staffMapper.updateProcessStatus2ByLoginNameAndCompanyId(staff);
		}
		
		if(flag > 0){
			return com.flf.util.JsonUtil.success(flag, true);
		}
		
		return com.flf.util.JsonUtil.success(flag+"", false);
	}

	@Override
	public String disagree_CheckedFromAPP(String infos) {
		
		boolean beOk = true;
		com.flf.entity.Staff staff = new com.flf.entity.Staff();
		net.sf.json.JSONObject resultInf=null;
		try{
			System.out.println("===========================================================================================");
			if(infos!=null){
				System.out.println(infos);
			}else{
				beOk = false;
			}
			System.out.println("===========================================================================================");
			resultInf = net.sf.json.JSONObject.fromObject(infos);
			System.out.println("===========================================================================================");
			if(resultInf!=null){
				System.out.println(resultInf);
			}else{
				beOk = false;
			}
			System.out.println("===========================================================================================");
			
			String loginName = resultInf.getString("loginName");
			String companyId = resultInf.getString("companyId");
			
			if(loginName==null||"".equals(loginName)||companyId==null||"".equals(companyId)){
				beOk = false;
			}
			
			staff.setUserAppId(loginName);
			staff.setCompanyId(companyId);
			
		}catch(Exception e){
			beOk = false;
		}
		if(beOk){
			staffMapper.updateProcessStatusF1ByLoginNameAndCompanyId(staff);
		}
		return com.flf.util.JsonUtil.success("success", true);
	}
	

}
