package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.ChargeType;
import com.flf.entity.ChargeTypeBuildingBilling;
import com.flf.entity.PageRestful;
import com.flf.mapper.ChargeTypeBuildingBillingMapper;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.service.ChargeTypeBuildingBillingService;
/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:47:03
 */
public class ChargeTypeBuildingBillingServiceImpl implements ChargeTypeBuildingBillingService {
	
	private ChargeTypeBuildingBillingMapper chargeTypeBuildingBillingMapper;
	@Autowired
	private ChargeTypeMapper chargeTypeMapper;

	public ChargeTypeBuildingBillingMapper getChargeTypeBuildingBillingMapper() {
		return chargeTypeBuildingBillingMapper;
	}

	public void setChargeTypeBuildingBillingMapper(
			ChargeTypeBuildingBillingMapper chargeTypeBuildingBillingMapper) {
		this.chargeTypeBuildingBillingMapper = chargeTypeBuildingBillingMapper;
	}

	@Override
	public PageRestful listPageChargeTypeBuildingBilling(
			ChargeTypeBuildingBilling chargeTypeBuildingBilling) {
		PageRestful pageRestful=new PageRestful();
		List<ChargeTypeBuildingBilling> chargeTypeBuildingBillings = chargeTypeBuildingBillingMapper.listPageChargeTypeBuildingBilling(chargeTypeBuildingBilling);
		for(ChargeTypeBuildingBilling ctbb:chargeTypeBuildingBillings){
			ChargeType chargeType = chargeTypeMapper.selectByPrimaryKey(ctbb.getChargeTypeId());
			ctbb.setChargeTypeName(chargeType.getChargeTypeName());
		}
		chargeTypeBuildingBillings.add(0,null);
		pageRestful.setChargeTypeBuildingBillings(chargeTypeBuildingBillings);
		pageRestful.setPage(chargeTypeBuildingBilling.getPage());
		return pageRestful;
	}

}
