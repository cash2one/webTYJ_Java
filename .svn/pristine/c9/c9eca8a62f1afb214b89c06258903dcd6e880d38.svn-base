package com.flf.service;

import javax.jws.WebService;

@WebService
public interface AppUserService {

	/**
	 * 根据账号查询用户
	 * @param loginName
	 * @return
	 */
	public String selectUserByLoginName(String loginName);
	
	/**
	 * 根据手机号查询用户
	 * @param phone
	 * @return
	 */
	public String selectUserByPhone(String phone);
	
	
	/**
	 * 用户注册
	 * @author chenqiuxu
	 * @param appUser
	 * @return
	 */
	public String registerAppUser(String appUser);
	
	/**
	 * 根据id查询单个用户
	 * @author chenqiuxu
	 * @param id
	 * @return
	 */
	public String queryAppUser(String id);
	
	/**
	 * 根据id 修改用户
	 * @author chenqiuxu
	 * @param appUser
	 * @return
	 */
	public String updateAppUser(String appUser);
	

    
    /**
     * 物业app，pc登陆
     * @author chenqiuxu
     * @param appUser
     * @return
     */
    public String loginProperty(String appUser);
    
    /**
     * 邻音登陆
     * @author chenqiuxu
     * @param appUser
     * @return
     */
    public String loginNeighbor(String appUser);
    
    /**
     * 物业app扫码注册公司
     * @param loginName
     * @param twoCode
     * @return
     */
    public String scan(String loginName, String twoCode);
	
    /**
	 * 根据账号查询未绑定公司的用户
	 * @param loginName
	 * @return
	 */
	public String selectNotBuildingUserByLoginName(String loginName);
}