package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flf.entity.OrganizationStructure;
import com.flf.mapper.OrganizationStructureMapper;
import com.flf.request.OrgTree;
import com.flf.request.Tree;
import com.flf.service.OrganizationStructureService;

public class OrganizationStructureServiceImpl implements OrganizationStructureService{
	
	private OrganizationStructureMapper organizationStructureMapper;
	
	public OrganizationStructureMapper getOrganizationStructureMapper() {
		return organizationStructureMapper;
	}

	public void setOrganizationStructureMapper(
			OrganizationStructureMapper organizationStructureMapper) {
		this.organizationStructureMapper = organizationStructureMapper;
	}

	@Override
	public List<OrgTree> getAllOrganizationStructure() {
		List<OrgTree> treeList = new ArrayList<OrgTree>();
		List<OrganizationStructure> oslist = organizationStructureMapper.getAllOrganizationStructure();
		if(oslist != null && oslist.size()>0){
			for(OrganizationStructure os : oslist){
				OrgTree t = new OrgTree();
				t.setId(os.getOrganizationId());
				t.setpId(os.getParentsId());
				t.setName(os.getOrganizationName());
				t.setLeaderId(os.getLeaderId());
				t.setLeaderName(os.getLeaderName());
				treeList.add(t);
			}
		}
		return treeList;
	}

	@Override
	public List<Tree> getOrganizationStructurebyId(
			String organizationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrganizationStructure(String organizationId) {
		String temp = organizationId;
		System.out.println(temp);
		organizationStructureMapper.deleteOrganizationStructure(organizationId);
	}

	@Override
	public void updateOrganizationStructure(
			OrganizationStructure organizationStructure) {
		if(organizationStructure!=null){
			organizationStructureMapper.updateOrganizationStructure(organizationStructure);
		}
	}

	@Override
	public void insertOrganizationStructure(
			OrganizationStructure organizationStructure) {
		organizationStructureMapper.insertOrganizationStructure(organizationStructure);
	}

	@Override
	public List<OrgTree> getOrganizationStructureTree() {
		List<OrganizationStructure> oslist = organizationStructureMapper.getAllOrganizationStructure();
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		if(oslist!=null && oslist.size()>0){
			for(OrganizationStructure os : oslist){
				if(oslist!=null && oslist.size()==1){
					oslist.add(null);					
				}
				HashMap map = new HashMap();
				map.put("id",os.getOrganizationId());
				map.put("name",os.getOrganizationName());
				map.put("pid", os.getParentsId());
				map.put("leaderId", os.getLeaderId());
				map.put("leaderName", os.getLeaderName());
				dataList.add(map);
			}
		}
		
		HashMap<String,OrgTree> nodeList = new HashMap<String,OrgTree>();
		OrgTree root = null;
		  // 根据结果集构造节点列表（存入散列表）  
		  for (Iterator<Map<String,String>> it = dataList.iterator(); it.hasNext();) {  
			   Map<String,String> dataRecord = (Map<String,String>) it.next(); 
				if(dataRecord!=null && dataRecord.size()==1){
					dataRecord.get(null);		
				}
			   OrgTree t = new OrgTree();
			   t.setId((String) dataRecord.get("id"));
			   t.setName((String) dataRecord.get("name"));
			   t.setpId((String) dataRecord.get("pid"));
			   t.setLeaderId((String) dataRecord.get("leaderId"));
			   t.setLeaderName((String) dataRecord.get("leaderName"));
			   nodeList.put(t.getId(), t);
		} 
		
		Set<Map.Entry<String,OrgTree>> entrySet = nodeList.entrySet();  
		  for (Iterator<Map.Entry<String,OrgTree>> it = entrySet.iterator(); it.hasNext();) {  
			  OrgTree t1 = (OrgTree) ((Map.Entry<String,OrgTree>) it.next()).getValue();
			  if(t1.getpId() == null || t1.getpId().equals("")){
				  root = t1;
			  }else{
				  nodeList.get(t1.getpId()).gettList().add(t1);
			  }
		  }
		  System.out.println(root); 
		  List<OrgTree> treeList = new ArrayList<OrgTree>();
		  treeList.add(root);
		  
		return treeList;
	}
	
	
}
