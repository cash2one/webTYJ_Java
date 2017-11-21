package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.User;
@WebService
@Path("/user")
public interface UserService {//用户表
	User getUserById(String userId);//根据Id查询用户表
	
	boolean insertUser(User user);//添加用户表信息
	
	void updateUser(User user);//修改用户表信息
	
	User getUserByNameAndPwd(String username, String password);//根据用户名和密码查询用户
	
	void updateUserBaseInfo(User user);//修改用户信息
	
	void updateUserRights(User user);//修改用户类型
	
	void deleteUser(String userId);//删除用户
	
	List<User> listPageUser(User user);//分页查询用户
	
	void updateLastLogin(User user);//修改用户最后登录时间
	
	User getUserAndRoleById(String userId);//根据用户Id查询用户 和 角色
	
	List<User> listAllUser();//查询所有用户
	
	int verifyUser(String longinname, String password);//根据登录名和密码 验证用户
	
	/**
	 * 查询所有用户
	 * @return
	 */
	@GET
	@Path("/listAlluser")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<User> listAlluser();
	
	/**
	 * 根据用户Id查询用户
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/getUserById/{userId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	User getUserByIdRest(@PathParam("userId") String userId);
	
	/**
	 * 添加用户
	 * @param user
	 */
	@POST
	@Path("/AddUser")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void AddUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	@PUT
	@Path("/UpdateUser")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void UpdateUser(User user);
	
	
	/**
	 * 删除用户
	 * @param userId
	 */
	@DELETE
	@Path("/DeleteUserById/{userId}")

	void DeleteUserById(@PathParam("userId") String userId);
	
	//通过家家账号查询客户id
    String getpersonIdByjiajiaNum(String jiajiaNum);
    
    //通过客户id查找家家号列表
  	String getjiajiaBypersonId(String personId);
    
    int updatePersonId(String personId,String userId);
    
//    String login(String loginname,String password);
//    
//    String updateBindingPhone(String phoneNum,String newPhoneNum,String newCode);

}
