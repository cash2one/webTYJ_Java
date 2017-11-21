package com.flf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flf.entity.HrAuthority;
import com.flf.entity.PostAuthority;
import com.flf.entity.Staff;
import com.flf.entity.TRole;
import com.flf.entity.TUser;
import com.flf.entity.TUserPermissions;
import com.flf.mapper.HrAuthorityMapper;
import com.flf.mapper.TRoleMapper;
import com.flf.mapper.TUserPermissionsMapper;
import com.flf.mapper.TUserRoleMapper;
import com.flf.service.HrAuthorityService;
import com.flf.service.LoginService;
import com.flf.service.PostAuthorityService;
import com.flf.service.UserServiceNew;
import com.flf.util.JsonUtil;
import com.flf.util.MD5Utils;
import com.flf.util.Tools;

import net.sf.json.JSONObject;


@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private UserServiceNew userServiceNew;
	@Autowired
	private PostAuthorityService postAuthorityService;
	@Autowired
	private HrAuthorityService hrAuthorityService;
	@Autowired
	private TUserPermissionsMapper tuserPermissionsMapper;
	@Autowired
	private HrAuthorityMapper hrAuthorityMapper;
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	@Autowired
	private TUserRoleMapper tUserRoleMapper;
	@Autowired
	private TRoleMapper tRoleMapper;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/loginSys",method=RequestMethod.GET)
	public void loginSys(@RequestParam("loginName") String loginName,@RequestParam("password") String password, HttpServletResponse response,HttpSession session) throws IOException{
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		if(Tools.notEmpty(loginName) && Tools.notEmpty(password)){
			//存储权限的标识
		Set<String> authoritySet = new HashSet<String>();
			//根据登录名查询用户
	 		TUser tuser = userServiceNew.getTUserbyLoginName(loginName);
	 		//MD5加密
	 		String pw = MD5Utils.MD5(password);
	 		if(tuser!=null){
	 			//判断密码是否正确
	 			if(pw.equals(tuser.getPassword())){
	 				//测试使用，setDBType参数为用户公司ID
	 				/*DBContextHolder.setDBType("11");
	 				String sql2 = "select * from t_gift";
	 				System.out.println("========================================");
	 				List<Map<String,Object>> list2 = jdbcTemplate.queryForList(sql2);
	 				for (Map<String, Object> map : list2) {
	 					System.out.println(map);
	 				}*/
	 				//获取岗位权限信息
	 				List<PostAuthority> paList = postAuthorityService.getPostAuthorityByUserId(tuser.getUserId());
	 				List<HrAuthority> hraList = hrAuthorityService.getHrAuthorityByUserId(tuser.getUserId());
	 				
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
	 				tuser.setSessionId(session.getId());
	 				
	 				List<TUserPermissions>  tupList = tuserPermissionsMapper.listTUserPermissionsByuserId(tuser.getUserId());
	 				//获取系统管理员的功能信息 朱琪 2016.03.04
	 				List<HrAuthority> hrAuthorities = hrAuthorityMapper.getHrAuthorityByUserId(tuser.getUserId());
	 				for (HrAuthority hrAuthority : hrAuthorities) {
	 					TUserPermissions tup = new TUserPermissions();
	 					tup.setPermissionsId(hrAuthority.getPermissionsId());
	 					tup.setPermissions(hrAuthority.getPermissions());
	 					tup.setUserId(hrAuthority.gettUserId());
	 					tupList.add(tup);
					}
	 				//	tupList.add();
	 				tuser.setTuserPermissions(tupList);
	 				
	 				//获取登录用户是否为项目经理
	 				if(tuser.getStaff() != null){
	 					Staff staff = new Staff();
	 					staff = tuser.getStaff();
	 					if(staff.getCorePost() != null && staff.getCorePost().size() > 0){
 							tuser.setPostRole("projectManager");
	 					}else{
	 						TRole tRole = tRoleMapper.getTRoleByRoleType("4");
	 						Map map = new HashMap();
	 						map.put("userId", tuser.getUserId());
	 						map.put("roleId", tRole.getRoleId());
	 						if(tUserRoleMapper.getTUserRoleByMap(map).size() > 0){
	 							tuser.setPostRole("projectManager");
	 						}else{
	 							tuser.setPostRole("others");
	 						}
	 					}
	 				}else{
	 					tuser.setPostRole("others");
	 				}
	 				
	 				//将登录的用户存入session中
	 				session.setAttribute(session.getId(), tuser);
	 				//获取json字符串
	 				String json = JsonUtil.result(JSONObject.fromObject(tuser).toString(), "200", true);
	 				out = response.getWriter();
	 				out.write(json);
	 				out.close();
	 			}else{
	 				//增加密码错误的返回提示  王洲  2016.02.29
	 				out = response.getWriter();
	 				out.write(JsonUtil.result(null, "2002", false));
	 				out.close();
	 			}
	 		}else{
	 			out = response.getWriter();
 				out.write(JsonUtil.result(null, "2001", false));
 				out.close();
	 		}
		}else{
			out = response.getWriter();
			out.write(JsonUtil.result(null, "-1", false));
			out.close();
		}
	}
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public void loginOut(HttpServletResponse response,HttpSession session){
		session.invalidate();
	}
	
//	private boolean isLogin(String loginName, String password){
//		java.util.Map<String, String> userInfo = new java.util.HashMap<String, String>();
//		userInfo.put("loginName", loginName);
//		userInfo.put("password", password);
//
//	 	//判断登录名和密码是否为空
//	 	if(Tools.notEmpty(loginName) && Tools.notEmpty(password)){
//	 		JaxWsProxyFactoryBean factory = ClientUtil.getClientFactory(loginUrl + "/AppUserService",AppUserService.class);
//	 		AppUserService welcome = (AppUserService) factory.create();
//			JSONObject jsonObject = JSONObject.fromObject(userInfo);
//			String loginInf = welcome.loginProperty(jsonObject.toString());
//			JSONArray json = JSONArray.fromObject(loginInf);
//			System.out.println(json);
//	 		
//	 	}
//		return true;
//	}
	
	@RequestMapping(value = "/loginAppUser", method = RequestMethod.GET)
	public void loginQrcode(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
			HttpServletResponse response, HttpSession session) throws IOException {
		
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		if (Tools.notEmpty(loginName) && Tools.notEmpty(password)) {
			// 存储权限的标识
			Set<String> authoritySet = new HashSet<String>();
			// 根据登录名查询用户
			TUser tuser = userServiceNew.getTUserbyLoginName(loginName);
			// MD5加密
//			String pw = MD5Utils.MD5(password);
//			String msg = loginService.loginAppUser(loginName, password);
			
			if (tuser != null) {
				// 判断密码是否正确
				if (loginService.loginAppUser_Check(loginName, password)) {
					// 获取岗位权限信息
					List<PostAuthority> paList = postAuthorityService.getPostAuthorityByUserId(tuser.getUserId());
					List<HrAuthority> hraList = hrAuthorityService.getHrAuthorityByUserId(tuser.getUserId());

					// 获取岗位权限信息中的功能权限和操作权限
					if (paList != null && paList.size() > 0) {
						for (PostAuthority p : paList) {
							authoritySet.add(p.getRoleId());
							authoritySet.add(p.getActionId());
						}
					}
					// 获取团队关系信息中的功能权限
					if (hraList != null && hraList.size() > 0) {
						for (HrAuthority hra : hraList) {
							authoritySet.add(hra.getPermissionsId());
						}
					}
					tuser.setHrAuthority(authoritySet);
					tuser.setSessionId(session.getId());

					List<TUserPermissions> tupList = tuserPermissionsMapper.listTUserPermissionsByuserId(tuser.getUserId());
					// 获取系统管理员的功能信息 朱琪 2016.03.04
					List<HrAuthority> hrAuthorities = hrAuthorityMapper.getHrAuthorityByUserId(tuser.getUserId());
					for (HrAuthority hrAuthority : hrAuthorities) {
						TUserPermissions tup = new TUserPermissions();
						tup.setPermissionsId(hrAuthority.getPermissionsId());
						tup.setPermissions(hrAuthority.getPermissions());
						tup.setUserId(hrAuthority.gettUserId());
						tupList.add(tup);
					}
					// tupList.add();
					tuser.setTuserPermissions(tupList);

					// 获取登录用户是否为项目经理
					if (tuser.getStaff() != null) {
						Staff staff = new Staff();
						staff = tuser.getStaff();
						if (staff.getCorePost() != null && staff.getCorePost().size() > 0) {
							tuser.setPostRole("projectManager");
						} else {
							TRole tRole = tRoleMapper.getTRoleByRoleType("4");
							Map map = new HashMap();
							map.put("userId", tuser.getUserId());
							map.put("roleId", tRole.getRoleId());
							if (tUserRoleMapper.getTUserRoleByMap(map).size() > 0) {
								tuser.setPostRole("projectManager");
							} else {
								tuser.setPostRole("others");
							}
						}
					} else {
						tuser.setPostRole("others");
					}

					// 将登录的用户存入session中
					session.setAttribute(session.getId(), tuser);
					// 获取json字符串
					String json = JsonUtil.result(JSONObject.fromObject(tuser).toString(), "200", true);
					out = response.getWriter();
					out.write(json);
					out.close();
				} else {
					// 增加密码错误的返回提示 王洲 2016.02.29
					out = response.getWriter();
					out.write(JsonUtil.result(null, "2002", false));
					out.close();
				}
			} else {
				out = response.getWriter();
				out.write(JsonUtil.result(null, "2001", false));
				out.close();
			}
//			out = response.getWriter();
//			out.write(msg);
//			out.close();
		} else {
			out = response.getWriter();
			out.write(JsonUtil.result(null, "-1", false));
			out.close();
		}
	}
}
