package com.flf.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.User;
import com.flf.mapper.UserMapper;
import com.flf.service.UserService;
import com.flf.util.JsonUtil;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userId);
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		int count = userMapper.getCountByName(user.getLoginname());
		if(count>0){
			return false;
		}else{
			userMapper.insertUser(user);
			return true;
		}
		
	}

	public List<User> listPageUser(User user){
		return userMapper.listPageUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	public void updateUserBaseInfo(User user){
		userMapper.updateUserBaseInfo(user);
	}
	
	public void updateUserRights(User user){
		userMapper.updateUserRights(user);
	}
	
	public User getUserByNameAndPwd(String loginname, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		return userMapper.getUserInfo(user);
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void deleteUser(String userId){
		userMapper.deleteUser(userId);
	}

	public User getUserAndRoleById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserAndRoleById(userId);
	}

	public void updateLastLogin(User user) {
		// TODO Auto-generated method stub
		userMapper.updateLastLogin(user);
	}

	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return userMapper.listAllUser();
	}

	@Override
	public int verifyUser(String loginname, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		User user1=userMapper.getUserInfo(user);
		if (user1!=null) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public List<User> listAlluser() {
		// TODO Auto-generated method stub
		List<User> users = userMapper.listAllUser();
		return users;
	}

	@Override
	public User getUserByIdRest(String userId) {
		// TODO Auto-generated method stub
		User user=userMapper.getUserById(userId);
		return user;
	}

	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	@Override
	public void DeleteUserById(String userId) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(userId);
	}

	/*
	  * <p>Title: getpersonIdByjiajiaNum</p>
	  * <p>Description: </p>
	  * @param jiajiaNum
	  * @return
	  * @see com.flf.service.UserService#getpersonIdByjiajiaNum(java.lang.String)
	  */
	
	
	@Override
	public String getpersonIdByjiajiaNum(String jiajiaNum) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	  * <p>Title: getjiajiaBypersonId</p>
	  * <p>Description: </p>
	  * @param personId
	  * @return
	  * @see com.flf.service.UserService#getjiajiaBypersonId(java.lang.String)
	  */
	
	
	@Override
	public String getjiajiaBypersonId(String personId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	  * <p>Title: updatePersonId</p>
	  * <p>Description: </p>
	  * @param personId
	  * @param userId
	  * @return
	  * @see com.flf.service.UserService#updatePersonId(java.lang.String, java.lang.String)
	  */
	
	
	@Override
	public int updatePersonId(String personId, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
