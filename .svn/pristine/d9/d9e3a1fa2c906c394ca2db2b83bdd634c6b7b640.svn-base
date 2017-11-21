package com.flf.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.flf.entity.BuildingStructureNew;

/**
 * 建筑初始化，根据传入的id以及对象集合获取以id为parentId的所有数据
 * @author 王洲
 * 2016.02.24
 *
 */
public class BuildingTreeUtils {

	private List<BuildingStructureNew> returnList = new ArrayList<BuildingStructureNew>();
    
    /**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    public List<BuildingStructureNew> getChildNodes(List<BuildingStructureNew> list, String id) {
        if(list == null && id == null) return null;
        for (Iterator<BuildingStructureNew> iterator = list.iterator(); iterator.hasNext();) {
        	BuildingStructureNew buildingStructureNew = (BuildingStructureNew) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
        	if(id != null && buildingStructureNew.getParentId() != null){
        		if (id.toString().equals(buildingStructureNew.getParentId().toString())) {
        			recursionFn(list, buildingStructureNew);
        		}        		
        	}
        }
        return returnList;
    }
     
    private void recursionFn(List<BuildingStructureNew> list, BuildingStructureNew buildingStructureNew) {
        List<BuildingStructureNew> childList = getChildList(list, buildingStructureNew);// 得到子节点列表
        if (hasChild(list, buildingStructureNew)) {// 判断是否有子节点
            returnList.add(buildingStructureNew);
            Iterator<BuildingStructureNew> it = childList.iterator();
            while (it.hasNext()) {
            	BuildingStructureNew n = (BuildingStructureNew) it.next();
                recursionFn(list, n);
            }
        } else {
            returnList.add(buildingStructureNew);
        }
    }
     
    // 得到子节点列表
    private List<BuildingStructureNew> getChildList(List<BuildingStructureNew> list, BuildingStructureNew buildingStructureNew) {
        List<BuildingStructureNew> nodeList = new ArrayList<BuildingStructureNew>();
        Iterator<BuildingStructureNew> it = list.iterator();
        while (it.hasNext()) {
        	BuildingStructureNew n = (BuildingStructureNew) it.next();
        	if(n.getParentId() != null && buildingStructureNew.getId() != null){
        		if (n.getParentId().toString().equals(buildingStructureNew.getId().toString())) {
        			nodeList.add(n);
        		}
        	}
        }
        return nodeList;
    }
 
    // 判断是否有子节点
    private boolean hasChild(List<BuildingStructureNew> list, BuildingStructureNew buildingStructureNew) {
        return getChildList(list, buildingStructureNew).size() > 0 ? true : false;
    }
    
}
