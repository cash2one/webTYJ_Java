package com.flf.mapper;

import java.util.List;

import com.flf.entity.User;

public interface UserMapper  {//用户表
	List<User> listAllUser();//获取所有用户
	
	User getUserById(String userId);//通过用户Id获取用户
	
	void insertUser(User user);//添加用户信息
	
	void updateUser(User user);//修改用户信息
	
	User getUserInfo(User user);//获取用户信息
	
	void updateUserBaseInfo(User user);//修改用户基本信息
	
	void updateUserRights(User user);//修改用户类型
	
	int getCountByName(String loginname);//通过用户名统计用户
	
	void deleteUser(String userId);//删除用户
	
	int getCount(User user);//统计用户个数
	
	List<User> listPageUser(User user);//分页查询用户
	
	User getUserAndRoleById(String userId);//通过用户Id获取用户及角色
	
	void updateLastLogin(User user);//修改上次登录时间
	
	User getUserByNameAndPwd(String username,String password);//获取用户的用户名密码
}
