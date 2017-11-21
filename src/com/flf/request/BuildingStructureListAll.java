/**
 * @Title: BuildingStructureListAll.java
 * @Package com.flf.request
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午2:36:43
 * @version V1.0
 */

package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.ArchitectureNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.HouseNew;
import com.flf.entity.PooledNew;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;

/**
 * @ClassName: BuildingStructureListAll
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午2:36:43
 *
 */
@XmlRootElement(name = "BuildingStructureListAll") 
public class BuildingStructureListAll {
	private List<BuildingStructureNew> buildingStructureNews;  //建筑结构对象
	private List<HouseNew> houseNews ;   //住宅对象
	private List<StallNew> stallNews; //车位对象
	private List<StoreNew> storeNews; //商铺对象
	private List<ArchitectureNew> architectureNews; //公建对象
	private List<PooledNew> pooledNews; //公摊对象
	public List<BuildingStructureNew> getBuildingStructureNews() {
		return buildingStructureNews;
	}
	public void setBuildingStructureNews(
			List<BuildingStructureNew> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}
	public List<HouseNew> getHouseNews() {
		return houseNews;
	}
	public void setHouseNews(List<HouseNew> houseNews) {
		this.houseNews = houseNews;
	}
	public List<StallNew> getStallNews() {
		return stallNews;
	}
	public void setStallNews(List<StallNew> stallNews) {
		this.stallNews = stallNews;
	}
	public List<StoreNew> getStoreNews() {
		return storeNews;
	}
	public void setStoreNews(List<StoreNew> storeNews) {
		this.storeNews = storeNews;
	}
	public List<ArchitectureNew> getArchitectureNews() {
		return architectureNews;
	}
	public void setArchitectureNews(List<ArchitectureNew> architectureNews) {
		this.architectureNews = architectureNews;
	}
	public List<PooledNew> getPooledNews() {
		return pooledNews;
	}
	public void setPooledNews(List<PooledNew> pooledNews) {
		this.pooledNews = pooledNews;
	}
}
