/**
 * @Title: TreeResult.java
 * @Package com.flf.request
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-1 上午11:56:37
 * @version V1.0
 */

package com.flf.request;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.BuildingStructureNew;

/**
 * @ClassName: TreeResult
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-1 上午11:56:37
 *
 */
@XmlRootElement(name = "TreeResult") 
public class TreeResult {
	private List<Tree> treeList;
	private List<BuildingStructureNew>  buildingStructureNews;
	private List<BuildingStructureAll> buildingStructureAll; 
	private Map<String,Tree> treeMap;
	private String gatingAccount;
	
	
	
	public List<BuildingStructureAll> getBuildingStructureAll() {
		return buildingStructureAll;
	}
	public void setBuildingStructureAll(
			List<BuildingStructureAll> buildingStructureAll) {
		this.buildingStructureAll = buildingStructureAll;
	}
	public List<BuildingStructureNew> getBuildingStructureNews() {
		return buildingStructureNews;
	}
	public void setBuildingStructureNews(
			List<BuildingStructureNew> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}
	public String getGatingAccount() {
		return gatingAccount;
	}
	public void setGatingAccount(String gatingAccount) {
		this.gatingAccount = gatingAccount;
	}
	public List<Tree> getTreeList() {
		return treeList;
	}
	public void setTreeList(List<Tree> treeList) {
		this.treeList = treeList;
	}
	public Map<String, Tree> getTreeMap() {
		return treeMap;
	}
	public void setTreeMap(Map<String, Tree> treeMap) {
		this.treeMap = treeMap;
	} 
}
