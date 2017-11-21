package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.GateAccount;
import com.flf.entity.PageRestful;
import com.flf.request.GateAccountResult;
import com.flf.request.Info;
@WebService
@Path("/GateAccount")
public interface GateAccountService {
	

	 //登入验证
	int validateLogin (String username ,String password); 

	/*1.2门控机的登录 用户名和密码loginValidate*/
    String loginValidate(String USERNAME,String PASSWORD);
    
    //添加账号并判断账号是否已存在
    int AddAccount(String account,String houses);
    
    //修改账号信息
    int updateAccount(String account);
    
    //显示门控机账号列表分页
    String listPageAccount(String account);
    
    @POST
	@Path("/AddGateAccount")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    Info AddGateAccount(GateAccountResult gateAccountResult);
    
    @POST
	@Path("/listPageGateAccount")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageGateAccount(GateAccount gateAccount);
    
    @POST
	@Path("/updateGateAccount")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    Info updateGateAccount(GateAccountResult gateAccountResult);
}

