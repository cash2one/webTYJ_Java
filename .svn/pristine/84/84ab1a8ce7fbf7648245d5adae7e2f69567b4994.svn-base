package com.flf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.AssetAccount;
import com.flf.entity.AssetAccountDetail;
import com.flf.entity.ChargeType;
import com.flf.mapper.AssetAccountDetailMapper;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.service.AssetAccountDetailService;

public class AssetAccountDetailServiceImpl implements AssetAccountDetailService {

	@Autowired
	private AssetAccountDetailMapper assetAccountDetailMapper;// 账单详情表
	@Autowired
	private ChargeTypeMapper chargeTypeMapper;// 收费类型表

	@Override
	public List<AssetAccountDetail> getAssetAccountDetailById(AssetAccount assetAccount) {
		List<AssetAccountDetail> list = assetAccountDetailMapper.getAssetAccountDetailById(assetAccount.getAssetAccountId());
		if (list.size() == 0) {
			ChargeType charge = new ChargeType();
			charge.setChargeTypeStatus("0");
			charge.setProjectId(assetAccount.getProjectId());
			List<ChargeType> chargeTypeList = chargeTypeMapper.listAllChargeType(charge);
			for (ChargeType chargeType : chargeTypeList) {
				AssetAccountDetail detail = new AssetAccountDetail();
				detail.setDetailName(chargeType.getChargeTypeName());
				detail.setDisposableBalance(0.0);
				list.add(detail);
			}
		}
		return list;
	}

}
