package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.GiftArticle;
import com.flf.entity.HouseArticle;
import com.flf.entity.HouseNew;
import com.flf.entity.Intake;
@XmlRootElement(name = "IntakeResult") 
public class IntakeResult {
	
	private String giftId;//礼包id
	
	private List<Intake> intakes;//入伙信息
	
	private List<HouseNew> houses;//房屋信息

	public List<Intake> getIntakes() {
		return intakes;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}



	public void setIntakes(List<Intake> intakes) {
		this.intakes = intakes;
	}

	public List<HouseNew> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseNew> houses) {
		this.houses = houses;
	}
}
