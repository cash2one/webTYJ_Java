/**
 * @Title: PetRegistrationService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author gengxiaojiang
 * @date 2015-4-24 下午4:58:44
 * @version V1.0
 */

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

import com.flf.entity.PageRestful;
import com.flf.entity.PetRegistration;
import com.flf.entity.Search;

/**
 * @ClassName: PetRegistrationService
 * @Description: TODO
 * @author gengxiaojiang
 * @date 2015-4-24 下午4:58:44
 *
 */
@Path("/PetRegistration")
@WebService
public interface PetRegistrationService {
	//根据条件分页查询宠物信息
	@POST
	@Path("/listPagePetRegistration")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPagePetRegistration(PetRegistration petRegistration);
	//查询所有宠物
	@POST
	@Path("/listAllPetRegistration")
	@Produces(MediaType.APPLICATION_JSON)
	List<PetRegistration> listAllPetRegistration(PetRegistration petRegistration);
	//id获取宠物信息
	@GET
	@Path("/getPetRegistrationbyId/{petId}")
	@Produces(MediaType.APPLICATION_JSON)
	PetRegistration getPetRegistrationByIdRest(@PathParam("petId") String petId);
	//添加宠物信息
	@POST
	@Path("/insertPetRegistration")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertPetRegistration(PetRegistration petRegistration);
	//更新
	@PUT
	@Path("/updatePetRegistration")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updatePetRegistrationrest(PetRegistration petRegistration);
	//删除
	@PUT
	@Path("/deletePetRegistration/{petId}")
	void deletePetRegistrationrest(@PathParam("petId") String petId);
	
	//查询所有宠物
		@POST
		@Path("/listSearchPetRegistration")
		@Produces(MediaType.APPLICATION_JSON)
		List<PetRegistration> listSearchPetRegistration(Search search);
		
	//条件查询 宠物信息
	@POST
	@Path("/listPagePetsByContion")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPagePetsByContion(PetRegistration petRegistration);		
	
	/**
	 * 家家客户端增加宠物信息
	 * @param jsonStr
	 * @return
	 */
	String addPetRegistration(String jsonStr);
	
	/**
	 * 家家客户端根据personBuildingId查询宠物信息
	 * @param personBuildingId
	 * @return
	 */
	String selectPetRegistrationByPersonBuildingId(String personBuildingId);
	
	/**
	 * 家家客户端根据登录名查询宠物登记信息
	 * @param loginName
	 * @return
	 */
	String selectPetRegistrationByCustList(List<String> custList);
}
