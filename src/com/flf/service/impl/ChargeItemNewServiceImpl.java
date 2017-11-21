package com.flf.service.impl;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.BuildingStructureNew;
import com.flf.entity.ChargeItemNew;
import com.flf.entity.ChargeItemNewBuilding;
import com.flf.entity.ChargeItemNewDetails;
import com.flf.entity.ChargeType;
import com.flf.entity.ChargeTypeDetails;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.Formula;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ChargeItemNewBuildingMapper;
import com.flf.mapper.ChargeItemNewDetailsMapper;
import com.flf.mapper.ChargeItemNewMapper;
import com.flf.mapper.ChargeTypeDetailsMapper;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.mapper.FormulaMapper;
import com.flf.mapper.SchemeMapper;
import com.flf.service.ChargeItemNewService;
import com.flf.service.DataDictionarySlaveService;
import com.flf.service.ProductCommonserviceService;
import com.flf.util.Tools;

public class ChargeItemNewServiceImpl implements ChargeItemNewService {
	
	private ChargeItemNewMapper chargeItemNewMapper;
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;
	@Autowired
	private ChargeItemNewBuildingMapper chargeItemNewBuildingMapper; 
	@Autowired
	private ChargeTypeDetailsMapper chargeTypeDetailsMapper;
	@Autowired
	private ChargeItemNewDetailsMapper chargeItemNewDetailsMapper;
	@Autowired
	private FormulaMapper formulaMapper;
	@Autowired
	private DataDictionarySlaveService dataDictionarySlaveService;
	@Autowired
	private SchemeMapper schemeMapper;
	@Autowired
	private ChargeTypeMapper chargeTypeMapper;
	@Autowired
	private ProductCommonserviceService productCommonserviceService;

	public ChargeItemNewMapper getChargeItemNewMapper() {
		return chargeItemNewMapper;
	}

	public void setChargeItemNewMapper(ChargeItemNewMapper chargeItemNewMapper) {
		this.chargeItemNewMapper = chargeItemNewMapper;
	}

	@Override
	public List<BuildingStructureNew> getBuildingListByProidAndSchemeid(
			String projectId, String schemeId) {
		List<BuildingStructureNew>  buildingList = buildingStructureNewMapper.getBuildingListByProidAndSchemeid(projectId,schemeId);
		List<BuildingStructureNew>  buildingUnitList = buildingStructureNewMapper.getBuildingUnitListByProidAndSchemeid(projectId,schemeId);
		for(BuildingStructureNew bsn:buildingUnitList){
			buildingList.add(bsn);
		}
		List<BuildingStructureNew>  buildingBuildingList = buildingStructureNewMapper.getBuildingBuildingListByProidAndSchemeid(projectId,schemeId);
		for(BuildingStructureNew bsn:buildingBuildingList){
			buildingList.add(bsn);
		}
		return buildingList;
	}
	
	@Override
	public void insertChargeItemNew(ChargeItemNew chargeItemNew) {
		String chargeItemNewId = UUID.randomUUID().toString();
		List<ChargeItemNewBuilding> cinbList = new ArrayList<ChargeItemNewBuilding>();
		BigDecimal b_useRangeTotalBuildArea = BigDecimal.valueOf(0);
		for(BuildingStructureNew bsn:chargeItemNew.getBuildingStructureNewList()){
			ChargeItemNewBuilding cinb = new ChargeItemNewBuilding();
			cinb.setChargeItemNewBuildingId(UUID.randomUUID().toString());
			cinb.setChargeItemNewId(chargeItemNewId);
			cinb.setBuildingId(bsn.getId());
			cinbList.add(cinb);
//			chargeItemNewBuildingMapper.insertSelective(cinb);
//			Double d_buildingArea = 0.00;
//			bsn = buildingStructureNewMapper.getBuildingStructurebyId(bsn.getId());
//			if(bsn.getBuildingArea() != null){
//				d_buildingArea = bsn.getBuildingArea();
//			}
//			b_useRangeTotalBuildArea = b_useRangeTotalBuildArea.add(BigDecimal.valueOf(d_buildingArea));
		}
		Double d_result = chargeItemNewBuildingMapper.getTotalArea(chargeItemNew.getBuildingStructureNewList());
		if(d_result != null){
			b_useRangeTotalBuildArea = BigDecimal.valueOf(d_result);
		}
		chargeItemNewBuildingMapper.insertBatch(cinbList);
		String chargeTypeId = chargeItemNew.getChargeTypeId();
		ChargeTypeDetails chargeTypeDetails = new ChargeTypeDetails();
		chargeTypeDetails.setChargeTypeId(chargeTypeId);
		List<ChargeTypeDetails> chargeTypeDetailsList = chargeTypeDetailsMapper.listAllCharegeTypeDetails(chargeTypeDetails);
		for(ChargeTypeDetails ctd:chargeTypeDetailsList){
			ChargeItemNewDetails chargeItemNewDetails = new ChargeItemNewDetails();
			chargeItemNewDetails.setChargeItemDetailsId(UUID.randomUUID().toString());
			chargeItemNewDetails.setChargeItemNewId(chargeItemNewId);
			chargeItemNewDetails.setChargeTypeDetailsId(ctd.getChargeTypeDetailsId());
			chargeItemNewDetailsMapper.insertSelective(chargeItemNewDetails);
		}
		
		chargeItemNew.setChargeItemNewId(chargeItemNewId);
		List<ChargeItemNew> chargeItemNewList = chargeItemNewMapper.listAllChargeItemNew(new ChargeItemNew());
		String numStr = String.valueOf(chargeItemNewList.size());
		numStr = StringUtils.leftPad(String.valueOf(numStr), 5, "0");
		String chargeItemNewNum = productCommonserviceService.getProductNumber("440300", chargeItemNew.getProjectId(), "01", "004", numStr);
		JSONObject  jasonObject = JSONObject.fromObject(chargeItemNewNum);
		@SuppressWarnings("unchecked")
		Map<String,String> map = (Map<String,String>)jasonObject;
		chargeItemNewNum = map.get("code");
		chargeItemNew.setChargeItemNewNum(chargeItemNewNum);
		chargeItemNew.setHouseNum(chargeItemNew.getBuildingStructureNewList().size());
		chargeItemNew.setUseRangeTotalBuildArea(b_useRangeTotalBuildArea);
		chargeItemNewMapper.insertSelective(chargeItemNew);
	}

	@Override
	public List<ChargeItemNew> listAllChargeItemNew(ChargeItemNew chargeItemNew) {
		List<ChargeItemNew> list = chargeItemNewMapper.listAllChargeItemNew(chargeItemNew);
		for(ChargeItemNew cin:list){
			ChargeType chargeType = chargeTypeMapper.selectByPrimaryKey(cin.getChargeTypeId());
			List<DataDictionarySlave> unitList = dataDictionarySlaveService.getDataDictionarySlaveRes("unit", chargeType.getProjectId());
			for(DataDictionarySlave dds:unitList){
				if(cin.getChargeItemNewUnit().equals(dds.getSlaveName())){
					cin.setChargeItemNewUnit(dds.getDescription());
				}
			}
		}
		return list;
	}

	@Override
	public List<BuildingStructureNew> getBuildingListByChargeItemNewId(
			String chargeItemNewId) {
		List<BuildingStructureNew>  buildingList  = buildingStructureNewMapper.getBuildingByChargeItemNewId(chargeItemNewId);
		List<BuildingStructureNew>  buildingUnitList = buildingStructureNewMapper.getBuildingUnitByChargeItemNewId(chargeItemNewId);
		for(BuildingStructureNew bsn:buildingUnitList){
			buildingList.add(bsn);
		}
		List<BuildingStructureNew>  buildingBuildingList = buildingStructureNewMapper.getBuildingBuildingByChargeItemNewId(chargeItemNewId);
		for(BuildingStructureNew bsn:buildingBuildingList){
			buildingList.add(bsn);
		}
		return buildingList;
	}

	@Override
	public void deleteChargeItemNew(String chargeItemNewId) {
		if (!Tools.isEmpty(chargeItemNewId)) {
			String[] array = chargeItemNewId.split(",");
			for (int i = 0 ; i < array.length; i++) {
				chargeItemNewMapper.deleteByPrimaryKey(array[i]);
			}
		}
	}

	@Override
	public String confirmList(String chargeItemNewId) {
		Map<String,String> map=new HashMap<String,String>();
		ChargeItemNewDetails newCid = new ChargeItemNewDetails();
		newCid.setChargeItemNewId(chargeItemNewId);
		List<ChargeItemNewDetails> cidList = chargeItemNewDetailsMapper.listAllChargeItemNewDetails(newCid);
		for(ChargeItemNewDetails cid:cidList){
			Formula formula = new Formula();
			formula.setChargeItemDetailsId(cid.getChargeItemDetailsId());
			List<Formula> formulaList = formulaMapper.listAllFormula(formula);
			if(formulaList.size() == 0){
				map.put("code","3001");
				map.put("information","请确认收费项目详情下是否都建立了公式！");
			    return JSONObject.fromObject(map).toString();// 200表示成功
			}
		}
		map.put("code","200");
		map.put("information","确认成功");
	    return JSONObject.fromObject(map).toString();//200表示成功
	}
}