/**
 * @Title: PetRegistrationMapper.java
 * @Package com.flf.mapper
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author gengxiaojiang
 * @date 2015-4-24 下午1:55:42
 * @version V1.0
 */

package com.flf.mapper;


import java.util.List;

import com.flf.entity.PetRegistration;
import com.flf.entity.Search;

/**
 * @ClassName: PetRegistrationMapper
 * @Description: TODO
 * @author gengxiaojiang
 * @date 2015-4-24 下午1:55:42
 *
 */

public interface PetRegistrationMapper {//宠物登记表
	
	List< PetRegistration> listPagePetRegistration(PetRegistration petRegistration);
	
	List< PetRegistration> listAllPetRegistration(PetRegistration petRegistration);
	
	PetRegistration getPetRegistrationById(String petId);//根据id查询宠物信息

	int updatePetRegistration(PetRegistration  petRegistration);//更新宠物信息

	int insertPetRegistration( PetRegistration  petRegistration);//增加宠物信息

	int deletePetRegistrationById(String petId);//删除 宠物信息

	List<PetRegistration> listSearchPets(Search search);//通过条件查询宠物信息
	
	List<PetRegistration> listPagePetsByContion( PetRegistration  petRegistration);

	/**
	 * 根据personBuildingId查询宠物信息
	 * @param personBuildingId
	 * @return
	 */
	List<PetRegistration> selectPetRegistrationByPersonBuildingId(String personBuildingId);
	/**
	 * 根据personBuildingIdList查询宠物信息
	 * @param personBuildingIdList
	 * @return
	 */
	List<PetRegistration> selectPetRegistrationByPersonBuildingIdList(List<String> personBuildingIdList);

}

