package com.flf.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flf.entity.TRole;
import com.flf.entity.TUser;
import com.flf.entity.TUserRole;
import com.flf.mapper.TRoleMapper;
import com.flf.mapper.TUserMapper;
import com.flf.mapper.TUserRoleMapper;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private TUserMapper tuserMapper;
	@Autowired
	private TRoleMapper troleMapper;
	@Autowired
	private TUserRoleMapper tuserroleMapper;

	/**
	 * 创建登录账号接口供子系统调用
	 * 王洲
	 * 2016.2.2
	 * @param loginName
	 * @param password
	 * @return JSON
	 */
	@RequestMapping(value="/adduser", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestParam("companyId") String companyId, @RequestParam("loginName") String loginName, @RequestParam("password") String password){
		//初始化
		String result = "";
		TUser user = new TUser();
		String roleId = null;
		TUserRole tur = new TUserRole();
		//获取角色
		List<TRole> roleList = troleMapper.selectAllTRole();
		for (TRole trole : roleList){
			if(trole.getRoleType().toString().equals("0")){
				roleId = trole.getRoleId();
			}
		}

		try {
			//创建超级管理员
			user.setUserId(UUID.randomUUID().toString());
			user.setLoginName(loginName);
//			user.setPassword(com.flf.util.MD5Utils.MD5(password));
			user.setPassword(password);
			user.setCompanyId(companyId);
			user.setState((byte) 1);
			tuserMapper.insert(user);

			//赋予相关角色
			if(roleId != null){
				tur.setId(UUID.randomUUID().toString());
				tur.setUserId(user.getUserId());
				tur.setRoleId(roleId);
				tuserroleMapper.insert(tur);
			}
			result = "{\"state\":\"success\"}";
		} catch (Exception e) {
			result = "{\"state\":\"error\"}";
			e.printStackTrace();
		}
		return result;
	}
}
