package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.ChargeItemNew;
import com.flf.entity.ChargeItemNewDetails;
import com.flf.entity.ChargeTypeDetails;
import com.flf.mapper.ChargeItemNewDetailsMapper;
import com.flf.mapper.ChargeItemNewMapper;
import com.flf.mapper.ChargeTypeDetailsMapper;
import com.flf.service.ChargeItemNewDetailsService;
/**
 * 
 * @author maogaofei
 * @date 2016年6月29日 下午4:05:05
 */
public class ChargeItemNewDetailsServiceImpl implements ChargeItemNewDetailsService {
	
	private ChargeItemNewDetailsMapper chargeItemNewDetailsMapper;
	@Autowired
	private ChargeItemNewMapper chargeItemNewMapper;
	@Autowired
	private ChargeTypeDetailsMapper chargeTypeDetailsMapper;

	public ChargeItemNewDetailsMapper getChargeItemNewDetailsMapper() {
		return chargeItemNewDetailsMapper;
	}

	public void setChargeItemNewDetailsMapper(
			ChargeItemNewDetailsMapper chargeItemNewDetailsMapper) {
		this.chargeItemNewDetailsMapper = chargeItemNewDetailsMapper;
	}

	@Override
	public List<ChargeItemNewDetails> listAllChargeItemNewDetails(
			ChargeItemNewDetails chargeItemNewDetails) {
		List<ChargeItemNewDetails> list = new ArrayList<ChargeItemNewDetails>();
		ChargeItemNew chargeItemNew = chargeItemNewMapper.selectByPrimaryKey(chargeItemNewDetails.getChargeItemNewId());
		ChargeTypeDetails chargeTypeDetails = new ChargeTypeDetails();
		chargeTypeDetails.setChargeTypeId(chargeItemNew.getChargeTypeId());
		List<ChargeTypeDetails> chargeTypeDetailsList = chargeTypeDetailsMapper.listAllCharegeTypeDetails(chargeTypeDetails);
		for(ChargeTypeDetails ctd:chargeTypeDetailsList){
			ChargeItemNewDetails cid = chargeItemNewDetailsMapper.
					getCIDByCtdAndCin(ctd.getChargeTypeDetailsId(),chargeItemNew.getChargeItemNewId());
			cid.setChargeTypeDetailsName(ctd.getChargeTypeDetailsName());
			cid.setChargeTypeDetailsNum(ctd.getChargeTypeDetailsNum());
			list.add(cid);
		}
		return list;
	}
}
