package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.HouseNew;
//房屋Result
@XmlRootElement(name = "HouseNewResult") 
public class HouseNewResult {
	private List<HouseNew> houses;//房屋list

	public List<HouseNew> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseNew> houses) {
		this.houses = houses;
	}
}
