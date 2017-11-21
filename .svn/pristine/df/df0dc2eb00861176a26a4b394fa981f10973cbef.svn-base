package com.flf.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.flf.entity.HrAuthority;
import com.flf.entity.PostAuthority;
import com.flf.entity.Staff;
import com.flf.entity.TRole;
import com.flf.entity.TUser;
import com.flf.mapper.HrAuthorityMapper;
import com.flf.mapper.PostAuthorityMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TRoleMapper;
import com.flf.mapper.TUserMapper;
import com.flf.request.Info;
import com.flf.service.AppUserService;
import com.flf.service.LoginService;
import com.flf.util.ClientUtil;
import com.flf.util.ExcelUtils;
import com.flf.util.Global;
import com.flf.util.JsonUtil;
import com.flf.util.MD5Utils;
import com.flf.util.MapUtils;
@javax.jws.WebService
public class LoginServiceImpl implements LoginService{

	@javax.annotation.Resource   
    private WebServiceContext wsContext;     
    private MessageContext mc;     
    private HttpSession session; 
	
    @org.springframework.beans.factory.annotation.Autowired
    private StaffMapper staffMapper;
    @org.springframework.beans.factory.annotation.Autowired
	private TUserMapper tUserMapper;
    @org.springframework.beans.factory.annotation.Autowired
	private PostAuthorityMapper postAuthorityMapper;
    @org.springframework.beans.factory.annotation.Autowired
	private HrAuthorityMapper hrAuthorityMapper;
    @org.springframework.beans.factory.annotation.Autowired
	private TRoleMapper tRole;
	
	@Override
	public String login(TUser user) {
		//获取session
		javax.servlet.http.HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		session = req.getSession();
		
		java.util.Set<String> authoritySet = new java.util.HashSet<String>();
		
	 	//用户名
	 	String loginName = user.getLoginName();
	 	//密码
	 	String password = user.getPassword();
	 	//判断登录名和密码是否为空
	 	if(com.flf.util.Tools.notEmpty(loginName) && com.flf.util.Tools.notEmpty(password)){
	 		//根据登录名查询用户
	 		TUser tuser = tUserMapper.getTUserbyLoginName(loginName);
	 		//MD5加密
	 		String pw = MD5Utils.MD5(password);
	 		
	 		if(tuser!=null){
	 			//判断用户是否禁用
	 			if(pw.equals(tuser.getPassword())){
	 				//获取岗位权限信息
	 				java.util.List<PostAuthority> paList = postAuthorityMapper.getPostAuthorityByUserId(tuser.getUserId());
	 				java.util.List<HrAuthority> hraList = hrAuthorityMapper.getHrAuthorityByUserId(tuser.getUserId());
	 				
	 				//获取岗位权限信息中的功能权限和操作权限
	 				if(paList!=null && paList.size()>0){
	 					for(PostAuthority p : paList){
	 						authoritySet.add(p.getRoleId());
	 						authoritySet.add(p.getActionId());
	 					}
	 				}
	 				//获取团队关系信息中的功能权限
	 				if(hraList!=null && hraList.size()>0){
	 					for(HrAuthority hra:hraList){
	 						authoritySet.add(hra.getPermissionsId());
	 					}
	 				}
	 				tuser.setHrAuthority(authoritySet);
	 				
	 				//获取全局的session中的value值
	 				java.util.Collection sessionVal = Global.getSessionMap().values();
	 				if(sessionVal!=null && sessionVal.size()>0){
	 					//迭代sessionVal获取user对象(防止同一个用户重复登录，限制Global的session存入)
	 					for(java.util.Iterator it= sessionVal.iterator();it.hasNext();){
	 						TUser sessionUser = (TUser) it.next();
	 						if(tuser.getLoginName().equals(sessionUser.getLoginName())){
	 							return JsonUtil.result(net.sf.json.JSONObject.fromObject(sessionUser).toString(), "200", true);
	 						}else{
	 							tuser.setSessionId(session.getId());
	 							Global.getSessionMap().put(session.getId(), tuser);
	 						}
	 					}
	 				}else{
	 					tuser.setSessionId(session.getId());
	 					//保存session
		 				Global.getSessionMap().put(session.getId(), tuser);
	 				}
 		 		  	return JsonUtil.result(net.sf.json.JSONObject.fromObject(tuser).toString(), "200", true);
	 			}
	 		}else{
	 			//用户不存在或以失效
	 			return JsonUtil.result(null,"2001", false);
	 		}
	 	}else{
	 		//账号或密码错误
	 		return JsonUtil.result(null,"2002", false);
	 	}
	 	//登录失败
	 	return JsonUtil.result(null,"-1", false);
	}

	public MessageContext getMc() {
		return mc;
	}

	public void setMc(MessageContext mc) {
		this.mc = mc;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public TUserMapper gettUserMapper() {
		return tUserMapper;
	}

	public void settUserMapper(TUserMapper tUserMapper) {
		this.tUserMapper = tUserMapper;
	}

	public PostAuthorityMapper getPostAuthorityMapper() {
		return postAuthorityMapper;
	}

	public void setPostAuthorityMapper(PostAuthorityMapper postAuthorityMapper) {
		this.postAuthorityMapper = postAuthorityMapper;
	}

	public HrAuthorityMapper getHrAuthorityMapper() {
		return hrAuthorityMapper;
	}

	public void setHrAuthorityMapper(HrAuthorityMapper hrAuthorityMapper) {
		this.hrAuthorityMapper = hrAuthorityMapper;
	}
	
	private String loginUrl;

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	@Override
	public String loginAppUser(String loginName,String pwd) {
		TUser tuser = new TUser();
		//获取session
		javax.servlet.http.HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		session = req.getSession();
		
		java.util.Set<String> authoritySet = new java.util.HashSet<String>();
		java.util.Map<String, String> userInfo = new java.util.HashMap<String, String>();
		userInfo.put("loginName", loginName);
		userInfo.put("password", pwd);
		
		net.sf.json.JSONObject resultInf=null;
	 	//判断登录名和密码是否为空
	 	if(com.flf.util.Tools.notEmpty(loginName) && com.flf.util.Tools.notEmpty(pwd)){
	 		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(loginUrl + "/AppUserService",AppUserService.class);
	 		AppUserService welcome = (AppUserService) factory.create();// WebService
	 		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(userInfo); //把用户封装成json
			String loginInf = welcome.loginProperty(jsonObject.toString());//调用接口访问WebService
//			List<java.util.Map<String, Object>> userInfoList = getListMap("companyInfo",loginInf);
			
			if(loginInf==null){
				return null;
			}
			
			System.out.println("==============================================================================");
			System.out.println(loginInf);
			System.out.println("==============================================================================");
			
			loginInf = loginInf.substring(1, loginInf.length()-1);
			resultInf = net.sf.json.JSONObject.fromObject(loginInf);
			String state = resultInf.getString("state");
			if(state==null||!"success".equals(state)){
				//账号或密码错误
		 		return JsonUtil.result(null,"2002", false);
			}
			tuser = tUserMapper.getTUserbyLoginName(loginName);
			
			
			java.util.Map<String, Object> userInfoMap = null;
//			if(tuser != null){
				
		 		if(tuser!=null){
		 			//判断用户是否禁用
		 				//获取岗位权限信息
		 			java.util.List<PostAuthority> paList = postAuthorityMapper.getPostAuthorityByUserId(tuser.getUserId());
		 				java.util.List<HrAuthority> hraList = hrAuthorityMapper.getHrAuthorityByUserId(tuser.getUserId());
		 				
		 				//获取岗位权限信息中的功能权限和操作权限
		 				if(paList!=null && paList.size()>0){
		 					for(PostAuthority p : paList){
		 						authoritySet.add(p.getRoleId());
		 						authoritySet.add(p.getActionId());
		 					}
		 				}
		 				//获取团队关系信息中的功能权限
		 				if(hraList!=null && hraList.size()>0){
		 					for(HrAuthority hra:hraList){
		 						authoritySet.add(hra.getPermissionsId());
		 					}
		 				}
		 				tuser.setHrAuthority(authoritySet);
		 				
		 				//获取全局的session中的value值
		 				java.util.Collection sessionVal = Global.getSessionMap().values();
		 				if(sessionVal!=null && sessionVal.size()>0){
		 					//迭代sessionVal获取user对象(防止同一个用户重复登录，限制Global的session存入)
		 					for(java.util.Iterator it= sessionVal.iterator();it.hasNext();){
		 						TUser sessionUser = (TUser) it.next();
		 						if(tuser.getLoginName().equals(sessionUser.getLoginName())){
		 							return JsonUtil.result(net.sf.json.JSONObject.fromObject(sessionUser).toString(), "200", true);
		 						}else{
		 							tuser.setSessionId(session.getId());
		 							Global.getSessionMap().put(session.getId(), tuser);
		 						}
		 					}
		 				}else{
		 					tuser.setSessionId(session.getId());
		 					//保存session
			 				Global.getSessionMap().put(session.getId(), tuser);
		 				}
//	 					System.out.println(resultInf.getString("jdbcUrl"));
//	 					tuser.setCompanyId(resultInf.getString("companyId"));
	 					tuser.setLoginName(loginName);
	 					//tuser.setUserId(userId);
	 					
	 		 		  	//return JsonUtil.result(net.sf.json.JSONObject.fromObject(tuser).toString(), "200", true);
		 			}else{
		 				
		 				tuser = new TUser();
		 				tuser.setLoginName(loginName);
		 				tuser.setUserName(loginName);
		 				tuser.setRoleType("2");
		 				return JsonUtil.result(net.sf.json.JSONObject.fromObject(tuser).toString(), "2010", true);
////				 		tuser.setUserName(resultInf.getString("phone"));
		 			}
		 		

				
 				//获取全局的session中的value值
		 		java.util.Collection sessionVal = Global.getSessionMap().values();
 				if(sessionVal!=null && sessionVal.size()>0){
 					//迭代sessionVal获取user对象(防止同一个用户重复登录，限制Global的session存入)
 					for(java.util.Iterator it= sessionVal.iterator();it.hasNext();){
 						TUser sessionUser = (TUser) it.next();
 						if(tuser.getLoginName().equals(sessionUser.getLoginName())){
 							return JsonUtil.result(net.sf.json.JSONObject.fromObject(sessionUser).toString(), "200", true);
 						}else{
 							tuser.setSessionId(session.getId());
 							Global.getSessionMap().put(session.getId(), tuser);
 						}
 					}
 				}else{
 					tuser.setSessionId(session.getId());
 					//保存session
	 				Global.getSessionMap().put(session.getId(), tuser);
 				}
		 		return JsonUtil.result(net.sf.json.JSONObject.fromObject(tuser).toString(), "200", true);
				
//			}else{
//	 			//用户不存在或以失效
//	 			return JsonUtil.result(null,"2001", false);
//	 		}
	 	}else{
	 		//账号或密码错误
	 		return JsonUtil.result(null,"2002", false);
	 	}
	}
	
    public static java.util.List<java.util.Map<String, Object>> getListMap(String key,String jsonString){
    	java.util.List<java.util.Map<String, Object>> list = new java.util.ArrayList<java.util.Map<String,Object>>();
        try {
        	net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonString);
            net.sf.json.JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.size(); i++) {
            	net.sf.json.JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
                java.util.Iterator<String> iterator = jsonObject2.keys();
                while (iterator.hasNext()) {
                    String json_key = iterator.next();
                    Object json_value = jsonObject2.get(json_key);
                    if (json_value == null) {
                        json_value = "";
                    }
                    map.put(json_key, json_value);
                }
                list.add(map);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
	
    private java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public com.flf.entity.Staff ws_checkUserByAppAccountId(com.flf.entity.Staff staffNew) {
		com.flf.entity.Staff staff = new com.flf.entity.Staff();
		staff.setUserAppId(staffNew.getUserAppId());
		String loginInf = null;
	 	//判断登录名和密码是否为空
	 	if(com.flf.util.Tools.notEmpty(staffNew.getUserAppId())){
	 		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(loginUrl + "/AppUserService",AppUserService.class);
	 		AppUserService welcome = (AppUserService) factory.create();// WebService
			loginInf = welcome.selectUserByLoginName(staffNew.getUserAppId());//调用接口访问WebService
			
			if(loginInf==null){
				return null;
			}
			
			System.out.println("==============================================================================");
			System.out.println(loginInf);
			System.out.println("==============================================================================");
			
			loginInf = loginInf.substring(1, loginInf.length()-1);
			net.sf.json.JSONObject resultInf = net.sf.json.JSONObject.fromObject(loginInf);//
			String stateMsg = resultInf.getString("state");
			
			if("success".equals(stateMsg)){
				java.util.Map<String, String> userInfoMap = null;
				String userInfo = resultInf.getString("info");
				userInfoMap = (java.util.Map<String, String>)com.alibaba.fastjson.JSON.parseObject(userInfo,java.util.Map.class);
					try {
						if(userInfoMap.get("birthday")!=null &&!"".equals(userInfoMap.get("birthday")))
							staff.setBirthday(fmt.parse(userInfoMap.get("birthday")));
						if(userInfoMap.get("cardNum")!=null && !"".equals(userInfoMap.get("cardNum")))
							staff.setCardNum(userInfoMap.get("cardNum"));
						if(userInfoMap.get("accountId")!=null && !"".equals(userInfoMap.get("accountId")))
							staff.setUserId(userInfoMap.get("accountId"));
						if(userInfoMap.get("cardType")!=null && !"".equals(userInfoMap.get("cardType")))
							staff.setCardType(Integer.parseInt(userInfoMap.get("cardType")));
						if(userInfoMap.get("accountId")!=null && !"".equals(userInfoMap.get("accountId")))
							staff.setStaffNo(userInfoMap.get("accountId"));
						if(userInfoMap.get("phone")!=null && !"".equals(userInfoMap.get("phone")))
							staff.setTelphone(userInfoMap.get("phone"));
						if(userInfoMap.get("userName")!=null && !"".equals(userInfoMap.get("userName")))
							staff.setStaffName(userInfoMap.get("userName"));

						String sex = null;
						if(userInfoMap.get("sex")!=null){
							sex=userInfoMap.get("sex");
						}
						
						if("男".equals(sex)){
							staff.setSex(1);
						}else if("女".equals(sex)){
							staff.setSex(0);
						}
						
						/**
						java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
						paramas.put("company_id", "");
						paramas.put("msg_type", "1");
						com.flf.push.PushMsgUtil.toAppMsg("邀您入职。", userAppId, paramas);
						**/
					} catch (Exception e) {
						e.printStackTrace();
					}
				//验证成功。
			}
			
	 	}
	 	return staff;
	}
	
	@Override
	public Info importDataFromExcelFileNew(final com.flf.entity.Annex annex) {
		final String companyId = annex.getCompanyId();
		String filePath = annex.getAnnexAddress();
		 int numbers=0;
		if (com.flf.util.Tools.notEmpty(filePath)) {
			try {
				final java.util.List<java.util.Map<Short, String>> errorMapList = new java.util.ArrayList<java.util.Map<Short, String>>();
				final java.util.List<java.util.Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				 final java.util.List<com.flf.entity.Staff> insertStaffList = new java.util.ArrayList<com.flf.entity.Staff>();
				final java.util.List<com.flf.entity.Staff> staffes = staffMapper.listALlStaffInfo(new com.flf.entity.Staff());
				if (dataList != null && dataList.size() > 0) {
					final String key = java.util.UUID.randomUUID().toString();
					for (int i = 0; i < dataList.size(); i++) {
						java.util.Map<Short, String> t = dataList.get(i);
						String userAppId = t.get((short) 0);
						String staffName = t.get((short) 1);
						if (StringUtils.isEmpty(userAppId) || StringUtils.isEmpty(staffName)) {
							dataList.remove(i);
							i--;
						} else {
							boolean insertFlag = true;
							for (com.flf.entity.Staff staff : staffes) {
								if (userAppId.equals(staff.getUserAppId()) || staffName.equals(staff.getStaffName())) {
									insertFlag = false;
									numbers++;
									break;
								}
							}
							if(!insertFlag){
								dataList.remove(i);
								i--;
							}
						}
					}
					
					
					if(numbers>0){
						return com.flf.util.Tools.msg("用户已存在!", false);
					}
					Runnable th = new Runnable() {
						@Override
						public void run() {
							JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(loginUrl + "/AppUserService",AppUserService.class);
					 		AppUserService welcome = (AppUserService) factory.create();// WebService
							//导入进度条
							int totalNum = dataList.size();
							int bsnum = 0;
							for (java.util.Map<Short, String> t : dataList) {
								String userAppId = t.get((short) 0);
								String staffName = t.get((short) 1);
		
								if (StringUtils.isEmpty(userAppId) || StringUtils.isEmpty(staffName)) {
									errorMapList.add(t);
								} else {
									boolean insertFlag = true;
									for (com.flf.entity.Staff staff : staffes) {
										if (userAppId.equals(staff.getUserAppId()) || staffName.equals(staff.getStaffName())) {
											insertFlag = false;
										}
									}
									if (insertFlag) {
										String loginInf = welcome.selectUserByLoginName(userAppId);//调用接口访问WebService
										com.flf.entity.Staff staffNew = new com.flf.entity.Staff();
										// "员工工号","员工姓名","员工性别","联系电话","证件类型","证件号码","出生日期","户籍","婚姻状况","现居地址","学历"
										loginInf = welcome.selectUserByLoginName(userAppId);//调用接口访问WebService
										
										if(loginInf==null){
											continue;
										}
										
										staffNew.setCompanyId(companyId);
										staffNew.setUserAppId(userAppId);
										
										System.out.println("==============================================================================");
										System.out.println(loginInf);
										System.out.println("==============================================================================");
										
										loginInf = loginInf.substring(1, loginInf.length()-1);
										net.sf.json.JSONObject resultInf = net.sf.json.JSONObject.fromObject(loginInf);//
										String stateMsg = resultInf.getString("state");
										
										if("success".equals(stateMsg)){
											java.util.Map<String, String> userInfoMap = null;
											String userInfo = resultInf.getString("info");
											userInfoMap = (java.util.Map<String, String>)com.alibaba.fastjson.JSON.parseObject(userInfo,java.util.Map.class);
											
//											if(!staffName.equals(userInfoMap.get("userName"))){
//												continue;
//											}
											
												try {
													if (!StringUtils.isEmpty(userInfoMap.get("birthday"))) {
														try {
															staffNew.setBirthday(fmt.parse(userInfoMap.get("birthday")));
														} catch (java.text.ParseException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}// 出生日期
													} else {
														staffNew.setBirthday(null);// 出生日期
													}
													
													
													
													if(userInfoMap.get("cardNum")!=null && !"".equals(userInfoMap.get("cardNum")))
														staffNew.setCardNum(userInfoMap.get("cardNum"));
													if(userInfoMap.get("accountId")!=null && !"".equals(userInfoMap.get("accountId")))
														staffNew.setUserId(userInfoMap.get("accountId"));
													if(userInfoMap.get("cardType")!=null && !"".equals(userInfoMap.get("cardType")))
														staffNew.setCardType(Integer.parseInt(userInfoMap.get("cardType")));
													if(userInfoMap.get("phone")!=null && !"".equals(userInfoMap.get("phone")))
														staffNew.setTelphone(userInfoMap.get("phone"));
													if(userInfoMap.get("userName")!=null && !"".equals(userInfoMap.get("userName")))
														staffNew.setStaffName(userInfoMap.get("userName"));

													String sex = null;
													if(userInfoMap.get("sex")!=null){
														sex=userInfoMap.get("sex");
													}
													
													if("男".equals(sex)){
														staffNew.setSex(1);
													}else if("女".equals(sex)){
														staffNew.setSex(0);
													}
												} catch (Exception e) {
													e.printStackTrace();
												}
												staffNew.setCompanyId(annex.getCompanyId());
												staffNew.setStaffName(staffName);// 员工姓名
												staffNew.setState("1");
												staffNew.setProcessStatus(0);
												insertStaffList.add(staffNew);
												bsnum++;
												MapUtils.getMap().put(key, bsnum + "|" + totalNum); 
												
												java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
												paramas.put("company_id", companyId);
												paramas.put("msg_type", "1");
												com.flf.push.PushMsgUtil.toAppMsg("邀您入职。", userAppId, paramas);
										}
									} else {
										bsnum++;
										MapUtils.getMap().put(key, bsnum + "|" + totalNum); 
										errorMapList.add(t);
									}
								}
							}
							if(insertStaffList.size() == 0){
								MapUtils.getMap().put(key, 0 + "|" + 0); 
							}else{
								staffMapper.insertList(insertStaffList);
							}
						}
					};
					Thread t = new Thread(th);
					t.start();
					return com.flf.util.Tools.msg(key, true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return com.flf.util.Tools.msg("数据导入失败!", false);
	}

	@Override
	public String checkUserByLoginNameAndSendMsg(com.flf.entity.Staff staff) {
		
		if(staff == null)
			return com.flf.util.JsonUtil.failure("用户为空！", false);
		
		staff.setProcessStatus(1);
		java.util.List<com.flf.entity.Staff> list= staffMapper.listALlStaffInfo(staff);
		if(list!=null&&list.size()>0){
			return com.flf.util.JsonUtil.failure("已存在该用户", false);
		}else{
			//获取详细信息
		}
		staff.setState("0");
		staffMapper.insertStaffUUID(staff);
		
		java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
		paramas.put("company_id", staff.getCompanyId());
		paramas.put("msg_type", "1");
		com.flf.push.PushMsgUtil.toAppMsg("有公司邀您入职。", staff.getUserAppId(), paramas);
		
		return com.flf.util.JsonUtil.success("消息发送成功！", true);
	}

	@Override
	public String disagree_UserByLoginNameAndSendMsg(Staff staff) {
		
		if(staff == null)
			return com.flf.util.JsonUtil.success("用户为空！", false);
		
		java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
		paramas.put("company_id", staff.getCompanyId());
		paramas.put("msg_type", "1");
		com.flf.push.PushMsgUtil.toAppMsg("请保证信息准确无误！", staff.getUserAppId(), paramas);
		
		return com.flf.util.JsonUtil.success("消息发送成功！", true);
	}

	@Override
	public String agree_WelcomeUser(Staff staff) {
		
		//查询普通权限
		if(staff.getUserAppId()!=null&&staff.getCompanyId()!=null){
			//保存T_User
			TUser user=new TUser();
			user.setUserId(UUID.randomUUID().toString());
			user.setUserName(staff.getUserAppId());
			user.setLoginName(staff.getUserAppId());
			user.setRoleType("2");
			user.setPassword("");
			user.setCreateTime(new java.util.Date());
			user.setCompanyId(staff.getCompanyId());
//			user.setPassword();
			user.setState((byte)1);
			java.util.List<TUser> listUsers = tUserMapper.findUserByLoginNameAndCompanyId(user);
			if(listUsers==null||listUsers.size()==0){
				tUserMapper.insert(user);
				Staff staffn =new Staff();
				staffn.setUserAppId(staff.getUserAppId());
				staffn.setCompanyId(staff.getCompanyId());
				
				java.util.List<com.flf.entity.Staff> uList = staffMapper.listALlStaffInfo(staffn);
				
				if(uList!=null && uList.size() == 1){
					Staff tmp=uList.get(0);
					if(tmp.getProcessStatus() != null && tmp.getProcessStatus() == 2){
						staffn.setState("1");
						staffn.setProcessStatus(3);
						staffn.setStaffId(tmp.getStaffId());
						int flg = staffMapper.updateStaff(staffn);
						if(flg>0){
							return com.flf.util.JsonUtil.success("员工状态更新成功！", true);
						}else{
							return com.flf.util.JsonUtil.failure("该员工不能被直接入职，请检查该员工状态！", true);
						}
					}else if(tmp.getProcessStatus() != null && tmp.getProcessStatus() == 1){
						return com.flf.util.JsonUtil.failure("请等待员工上传完整资料！", true);
					}
					return com.flf.util.JsonUtil.failure("该员工不能被直接入职，请检查该员工状态！", true);
				}
				
//				java.util.List<com.flf.entity.Staff> list = staffMapper.listPageAllStaff_Unckeck(staffn);
//				if(list != null && list.size() > 0){
//					staffn = list.get(0);
//					staffn.setState("1");
//					staffn.setProcessStatus(3);
//					staffn.setStaffId(staffn.getStaffId());
//					staffMapper.updateStaff(staffn);
//					return com.flf.util.JsonUtil.success("员工状态更新成功！", true);
//				}
				
			}
		}
		//保存T_User_Role
		//分配完账号
		//修改process_status
		return com.flf.util.JsonUtil.failure("用户表已存在改用户，请检查该员工状态！", true);
	}

	@Override
	public String sendMsg2UserByLoginName(Staff staff) {
		java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
		paramas.put("company_id", staff.getCompanyId());
		
		if(staff.getProcessStatus()!=null&&staff.getProcessStatus()==1){
			paramas.put("msg_type", "1");
			com.flf.push.PushMsgUtil.toAppMsg("有公司邀您入职。", staff.getUserAppId(), paramas);
		}else if(staff.getProcessStatus()!=null&&staff.getProcessStatus()==2){
			paramas.put("msg_type", "2");
			com.flf.push.PushMsgUtil.toAppMsg("请完善个人信息或者校对信息！", staff.getUserAppId(), paramas);
		}else if(staff.getProcessStatus()!=null&&staff.getProcessStatus()==3){
			paramas.put("msg_type", "3");
			com.flf.push.PushMsgUtil.toAppMsg("入职成功。", staff.getUserAppId(), paramas);
		}
		
		
		return com.flf.util.JsonUtil.success("消息发送成功！", true);
	}

	@Override
	public String putLoginNameInSystemFromAPP(Staff staff) {
		if(staff == null)
			return com.flf.util.JsonUtil.failure("用户为空！", false);
		Staff staffn =new Staff();
		staffn.setUserAppId(staff.getUserAppId());
		staffn.setCompanyId(staff.getCompanyId());
		
		java.util.List<com.flf.entity.Staff> uList = staffMapper.listALlStaffInfo(staffn);
		//java.util.List<com.flf.entity.Staff> list = staffMapper.listPageAllStaff_Unckeck(staffn);
		if(uList != null && uList.size() > 0 ){
			staffn = uList.get(0);
			if(staffn.getState()!=null && "0".equals(staffn.getState())){
				staff.setStaffId(staffn.getStaffId());
				staffMapper.updateStaff(staff);
				return com.flf.util.JsonUtil.success("员工状态更新成功！", true);
			}
			return com.flf.util.JsonUtil.failure("该员工已经入职！", true);
		}else{
			//获取详细信息
			//staff.setState("0");
		}
		if(staff.getProcessStatus()==null||(staff.getProcessStatus() != 0 && staff.getProcessStatus() != 1)){
			return com.flf.util.JsonUtil.failure("员工状态不正确！", true);
		}
		staff.setState("0");
		staffMapper.insertStaffUUID(staff);
		return com.flf.util.JsonUtil.success("员工成功添加到公司！", true);
	}

	@Override
	public String sendAuditMsg2UserByLoginName(Staff staff) {
		java.util.Map<String,String> paramas =new java.util.HashMap<String,String>();
		paramas.put("company_id", staff.getCompanyId());
		paramas.put("msg_type", "1");
		com.flf.push.PushMsgUtil.toAppMsg("需要重新填一下资料哦，请保证信息完整。", staff.getUserAppId(), paramas);
		return com.flf.util.JsonUtil.success("消息发送成功！", true);
	}

	@Override
	public void removeStaffStateByStateAndId(Staff staff) {
		List<Staff> list = staff.getStaffs();
		for (int i = 0; i < list.size(); i++) {
			staff.setStaffId(list.get(i).getStaffId());
			staffMapper.deleteStaffStateByStateAndId(staff);
		}
	}
	@Override
	public void leaveStaffStateByStateAndId(Staff staff) {
		List<Staff> list = staff.getStaffs();
		for (int i = 0; i < list.size(); i++) {
			staff.setStaffId(list.get(i).getStaffId());
			staffMapper.leaveStaffStateByStateAndId(staff);
		}
	}

	@Override
	public boolean loginAppUser_Check(String loginName, String password) {
		try{
			java.util.Map<String, String> userInfo = new java.util.HashMap<String, String>();
			userInfo.put("loginName", loginName);
			userInfo.put("password", password);
			net.sf.json.JSONObject resultInf=null;
		 	//判断登录名和密码是否为空
		 	if(com.flf.util.Tools.notEmpty(loginName) && com.flf.util.Tools.notEmpty(password)){
		 		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(loginUrl + "/AppUserService",AppUserService.class);
		 		AppUserService welcome = (AppUserService) factory.create();// WebService
		 		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(userInfo); //把用户封装成json
				String loginInf = welcome.loginProperty(jsonObject.toString());//调用接口访问WebService
//				List<java.util.Map<String, Object>> userInfoList = getListMap("companyInfo",loginInf);
				
				if(loginInf==null){
					return false;
				}
				
				System.out.println("==============================================================================");
				System.out.println(loginInf);
				System.out.println("==============================================================================");
				
				loginInf = loginInf.substring(1, loginInf.length()-1);
				resultInf = net.sf.json.JSONObject.fromObject(loginInf);
				String state = resultInf.getString("state");
				if(state==null||!"success".equals(state)){
					//账号或密码错误
			 		return false;
				}else{
					return true;
				}
		 	}else{
		 		return false;
		 	}
		}catch(Exception e){
			return false;
		}
	}
}
