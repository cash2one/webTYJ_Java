/**
 * @Title: GateAccountServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-25 下午10:55:44
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;


import com.flf.entity.CarInfo;
import com.flf.entity.GateAccount;
import com.flf.entity.PageRestful;
import com.flf.request.GateAccountResult;
import com.flf.request.Info;
import com.flf.request.TreeResult;
import com.flf.service.GateAccountService;
import com.flf.service.GatingService;
import com.flf.util.ClientUtil;
import com.flf.util.WsClinetAuthHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @ClassName: GateAccountServiceImpl
 * @Description: TODO
 * @author wangyang
 * @date 2015-5-25 下午10:55:44
 *
 */

public class GateAccountServiceImpl implements GateAccountService {

	private String gateUrl;
	
	
	/*
	 * <p>Title: listAccounts</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.GateAccountService#listAccounts()
	 */

	public String getGateUrl() {
		return gateUrl;
	}

	public void setGateUrl(String gateUrl) {
		this.gateUrl = gateUrl;
	}



	/*
	 * <p>Title: validateLogin</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.flf.service.GateAccountService#validateLogin(java.lang.String, java.lang.String)
	 */

	@Override
	public int validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * <p>Title: loginValidate</p>
	 * <p>Description: </p>
	 * @param USERNAME
	 * @param PASSWORD
	 * @return
	 * @see com.flf.service.GateAccountService#loginValidate(java.lang.String, java.lang.String)
	 */

	@Override
	public String loginValidate(String USERNAME, String PASSWORD) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * <p>Title: AddAccount</p>
	 * <p>Description: </p>
	 * @param account
	 * @return
	 * @see com.flf.service.GateAccountService#AddAccount(java.lang.String)
	 */
	public int AddAccount(String account, String houses) {
		return 0;
	};
	
	/*
	  * <p>Title: listPageAccount</p>
	  * <p>Description: </p>
	  * @param account
	  * @return
	  * @see com.flf.service.GateAccountService#listPageAccount(java.lang.String)
	  */
	
	
	@Override
	public String listPageAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	  * <p>Title: AddGateAccount</p>
	  * <p>Description: </p>
	  * @param gateAccount
	  * @return
	  * @see com.flf.service.GateAccountService#AddGateAccount(com.flf.entity.GateAccount)
	  */
	
	
	@Override
	public Info AddGateAccount(GateAccountResult gateAccountResult) {
		// TODO Auto-generated method stub
			JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(gateUrl+"/AccountService",GateAccountService.class);
	        GateAccountService welcome = (GateAccountService) factory.create();
	        JSONObject json=JSONObject.fromObject(gateAccountResult.getGateAccount());
	        Info info=new Info();
	        List<String> houses=new ArrayList<String>();
	        for (int i = 0; i < gateAccountResult.getTreeResult().getTreeList().size(); i++) {
				houses.add(gateAccountResult.getTreeResult().getTreeList().get(i).getId());
			}
	        JSONArray housesjson=JSONArray.fromObject(houses);
	        switch (welcome.AddAccount(json.toString(),housesjson.toString())) {
				case 0:{
					info.setState("success");
					info.setInfo("注册成功！");
					break;
				}
				case 1:{
					info.setState("failure");
					info.setInfo("用户名已存在！");
					break;
				}
				case 2:{
					info.setState("failure");
					info.setInfo("注册失败！");
					break;
				}
	        }
		return info;
	}
	
	/*
	  * <p>Title: listPageGateAccount</p>
	  * <p>Description: </p>
	  * @param gateAccount
	  * @return
	  * @see com.flf.service.GateAccountService#listPageGateAccount(com.flf.entity.GateAccount)
	  */
	
	
	@Override
	public PageRestful listPageGateAccount(GateAccount gateAccount) {
		// TODO Auto-generated method stub
		//通过ClientUtil类获取JaxWsProxyFactoryBean对象
		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(gateUrl+"/AccountService",GateAccountService.class);
        GateAccountService welcome = (GateAccountService) factory.create();
        JSONObject gateAccountjson=JSONObject.fromObject(gateAccount);
        //调用门控项目查询门控机账号列表
        String gateAccountsjson=welcome.listPageAccount(gateAccountjson.toString());
        Gson gs=new Gson();
        List<GateAccount> gateAccounts = gs.fromJson(gateAccountsjson, new TypeToken<List<GateAccount>>(){}.getType());//把JSON格式的字符串转为List  
/*        JSONArray json=JSONArray.fromObject(gateAccountsjson);
        List<GateAccount> gateAccounts=(List<GateAccount>) JSONArray.toCollection(json, GateAccount.class);*/
        PageRestful pagerestful=new PageRestful();
        pagerestful.setPage(gateAccounts.get(0).getPage());
		pagerestful.setGateAccounts(gateAccounts);
		return pagerestful;
	}
	
	/*
	  * <p>Title: updateAccount</p>
	  * <p>Description: </p>
	  * @param account
	  * @return
	  * @see com.flf.service.GateAccountService#updateAccount(java.lang.String)
	  */
	
	
	@Override
	public int updateAccount(String account) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	  * <p>Title: updateGateAccount</p>
	  * <p>Description: </p>
	  * @param gateAccount
	  * @return
	  * @see com.flf.service.GateAccountService#updateGateAccount(com.flf.entity.GateAccount)
	  */
	
	
	@Override
	public Info updateGateAccount(GateAccountResult gateAccountResult) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(gateUrl+"/AccountService",GateAccountService.class);
        GateAccountService welcome = (GateAccountService) factory.create();
        JSONObject json=JSONObject.fromObject(gateAccountResult.getGateAccount());
        Info info=new Info();
        if(welcome.updateAccount(json.toString())>0)
        {
        	info.setState("success");
        	info.setInfo("修改成功！");
        }else
        {
        	info.setState("failure");
        	info.setInfo("修改失败！");
        }
		return info;
	}
}
