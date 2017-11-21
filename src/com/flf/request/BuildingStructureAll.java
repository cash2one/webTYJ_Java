/**
 * @Title: buildingStructureHousew.java
 * @Package com.flf.request
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-9 下午2:52:51
 * @version V1.0
 */

package com.flf.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.ArchitectureNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.HouseNew;
import com.flf.entity.PooledNew;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;


/**
 * @ClassName: buildingStructureHousew
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-9 下午2:52:51
 *
 */
@XmlRootElement(name = "BuildingStructureAll") 
public class BuildingStructureAll {
	
	private BuildingStructureNew buildingStructureNew;  //建筑结构对象
	private HouseNew houseNew;   //住宅对象
	private StallNew stallNew; //车位对象
	private StoreNew storeNew; //商铺对象
	private ArchitectureNew architectureNew; //公建对象
	private PooledNew pooledNew; //公摊对象
	
	
	public ArchitectureNew getArchitectureNew() {
		return architectureNew;
	}
	public void setArchitectureNew(ArchitectureNew architectureNew) {
		this.architectureNew = architectureNew;
	}
	public PooledNew getPooledNew() {
		return pooledNew;
	}
	public void setPooledNew(PooledNew pooledNew) {
		this.pooledNew = pooledNew;
	}
	public StoreNew getStoreNew() {
		return storeNew;
	}
	public void setStoreNew(StoreNew storeNew) {
		this.storeNew = storeNew;
	}
	public StallNew getStallNew() {
		return stallNew;
	}
	public void setStallNew(StallNew stallNew) {
		this.stallNew = stallNew;
	}
	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}
	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}
	public HouseNew getHouseNew() {
		return houseNew;
	}
	public void setHouseNew(HouseNew houseNew) {
		this.houseNew = houseNew;
	}

}
