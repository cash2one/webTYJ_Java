/**
 * @Title: PetRegistrationServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author gengxiaojiang
 * @date 2015-4-24 下午4:59:59
 * @version V1.0
 */

package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PetRegistration;
import com.flf.entity.Search;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.PetRegistrationMapper;
import com.flf.service.PetRegistrationService;
import com.flf.util.JsonUtil;

import net.sf.json.JSONObject;

/**
 * @ClassName: PetRegistrationServiceImpl
 * @Description: TODO
 * @author gengxiaojiang
 * @date 2015-4-24 下午4:59:59
 *
 */
public class PetRegistrationServiceImpl implements PetRegistrationService {

	private PetRegistrationMapper petRegistrationMapper;
	private AnnexMapper annexMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public PetRegistrationMapper getPetRegistrationMapper() {
		return petRegistrationMapper;
	}

	public void setPetRegistrationMapper(PetRegistrationMapper petRegistrationMapper) {
		this.petRegistrationMapper = petRegistrationMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	@Override
	public List<PetRegistration> listAllPetRegistration(PetRegistration petRegistration) {
		List<PetRegistration> l = petRegistrationMapper.listAllPetRegistration(petRegistration);
		return l;

	}

	@Override
	public PetRegistration getPetRegistrationByIdRest(String petId) {
		// TODO Auto-generated method stub
		PetRegistration petRegistration = petRegistrationMapper.getPetRegistrationById(petId);
		if (petRegistration.getAnnexs() != null) {
			petRegistration.getAnnexs().add(0, null);
		}
		return petRegistration;
	}

	@Override
	public void insertPetRegistration(PetRegistration petRegistration) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();

		if (petRegistration != null) {
			List<Annex> annexList = petRegistration.getAnnexs();
			petRegistration.setPetId(uuid);
			int result = petRegistrationMapper.insertPetRegistration(petRegistration);
			if (result > 0) {
				// 附件信息保存
				if (annexList != null && annexList.size() > 0) {
					for (Annex annex : annexList) {
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}

	}

	/**
	 * 新增修改图片
	 * 
	 * @author zhuqi 2016.04.28
	 * @param petRegistration
	 */
	@Override
	public void updatePetRegistrationrest(PetRegistration petRegistration) {
		String petId = petRegistration.getPetId();
		int result = petRegistrationMapper.updatePetRegistration(petRegistration);
		if (result > 0) {
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			List<Annex> old_annexs = annexMapper.getAnnexbyRelationId(petId);// 根据关系id查询附件表是否存在文件信息
			List<Annex> new_annexs = petRegistration.getAnnexs();
			if (old_annexs != null && old_annexs.size() > 0) {
				for (int i = 0; i < old_annexs.size(); i++) {
					annexMapper.deleteAnnexByRelationId(petId);
				}
				if (new_annexs != null && new_annexs.size() > 0) {
					for (Annex annex : new_annexs) {
						if (annex != null) {
							annex.setRelationId(petId);
							annex.setAnnexTime(date);
							annexMapper.insertAnnex(annex);
						}
					}
				}
			} else {
				if (new_annexs != null && new_annexs.size() > 0) {
					for (Annex annex : new_annexs) {
						if (annex != null) {
							annex.setRelationId(petId);
							annex.setAnnexTime(date);
							annexMapper.insertAnnex(annex);
						}
					}
				}
			}
		}
	}

	/*
	 * <p>Title: deletePetRegistrationrest</p> <p>Description: </p>
	 * 
	 * @param petId
	 * 
	 * @see
	 * com.flf.service.PetRegistrationService#deletePetRegistrationrest(java.
	 * lang.Integer)
	 */

	@Override
	public void deletePetRegistrationrest(String petId) {
		petRegistrationMapper.deletePetRegistrationById(petId);

	}

	@Override
	public PageRestful listPagePetRegistration(PetRegistration petRegistration) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<PetRegistration> petRegistrations = petRegistrationMapper.listPagePetRegistration(petRegistration);
		for (PetRegistration petRegistration2 : petRegistrations) {
			if (petRegistration2.getAnnexs().size() != 0) {
				petRegistration2.getAnnexs().add(0, null);
			}
		}
		petRegistrations.add(0, null);
		pageRestful.setPetRegistrations(petRegistrations);
		pageRestful.setPage(petRegistration.getPage());
		return pageRestful;
	}

	@Override
	public List<PetRegistration> listSearchPetRegistration(Search search) {
		// TODO Auto-generated method stub
		return petRegistrationMapper.listSearchPets(search);
	}

	@Override
	public PageRestful listPagePetsByContion(PetRegistration petRegistration) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<PetRegistration> petRegistrations = petRegistrationMapper.listPagePetsByContion(petRegistration);
		petRegistrations.add(0, null);
		pageRestful.setPetRegistrations(petRegistrations);
		pageRestful.setPage(petRegistration.getPage());
		return pageRestful;
	}

	@Override
	public String addPetRegistration(String jsonStr) {
		try {
			PetRegistration petRegistration = (PetRegistration) JSONObject.toBean(JSONObject.fromObject(jsonStr),
					PetRegistration.class);
			petRegistration.setPetId(UUID.randomUUID().toString());
			petRegistration.setRegistrationTime(new Date());
			petRegistrationMapper.insertPetRegistration(petRegistration);
			return JsonUtil.success("添加成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("添加失败", false);
		}
	}

	@Override
	public String selectPetRegistrationByPersonBuildingId(String personBuildingId) {
		List<PetRegistration> petRegistrationList = petRegistrationMapper
				.selectPetRegistrationByPersonBuildingId(personBuildingId);
		if (petRegistrationList != null && petRegistrationList.size() > 0) {
			return JsonUtil.success(petRegistrationList, true);
		}
		return JsonUtil.failure("查询失败", false);
	}

	@Override
	public String selectPetRegistrationByCustList(List<String> custList) {
		List<BuildingStructureNew> buildingStructureNewList = buildingStructureNewMapper.getCustAndAddressByCustIdList(custList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("custIdList", custList);
		map.put("authorizationName", "宠物登记");
		List<BuildingStructureNew> buildingStructureNewList1 = buildingStructureNewMapper.getAuthorizationCustAndAddressByCustIdList(map);
		buildingStructureNewList.addAll(buildingStructureNewList1);
		
		List<String> personBuildingIdList = new ArrayList<String>();
		for (BuildingStructureNew item : buildingStructureNewList) {
			personBuildingIdList.add(item.getPersonBuildingId());
		}
		List<PetRegistration> petRegistrationList = petRegistrationMapper
				.selectPetRegistrationByPersonBuildingIdList(personBuildingIdList);
		if (petRegistrationList != null && petRegistrationList.size() > 0) {
			return com.alibaba.fastjson.JSONObject.toJSONString(petRegistrationList);
		}
		return "error";
	}

}
