package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 2015-10-10
 * @author TAOYONGCHAO
 * 资产账户详情表
 */
@XmlRootElement(name="AssetAccountDetail")
public class AssetAccountDetail {
	
	private String assetAccountDetailId; //资产账户详情id
	
	private String assetAccountId; //资产账户id
	
	private String detailName; //详情名称
	
	private String chargeItemId; //收费项目id
	
	private Double disposableBalance;  //可支配余额

	public String getAssetAccountDetailId() {
		return assetAccountDetailId;
	}

	public void setAssetAccountDetailId(String assetAccountDetailId) {
		this.assetAccountDetailId = assetAccountDetailId;
	}

	public String getAssetAccountId() {
		return assetAccountId;
	}

	public void setAssetAccountId(String assetAccountId) {
		this.assetAccountId = assetAccountId;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getChargeItemId() {
		return chargeItemId;
	}

	public void setChargeItemId(String chargeItemId) {
		this.chargeItemId = chargeItemId;
	}

	public Double getDisposableBalance() {
		return disposableBalance;
	}

	public void setDisposableBalance(Double disposableBalance) {
		this.disposableBalance = disposableBalance;
	}
	
}
