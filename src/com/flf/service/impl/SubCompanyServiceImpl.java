package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.flf.entity.Company;
import com.flf.entity.ConpanyTree;
import com.flf.entity.OrganizationStructure;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.SubCompany;
import com.flf.entity.SubCompanyProjectRelation;
import com.flf.mapper.CompanyMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SubCompanyMapper;
import com.flf.mapper.SubCompanyProjectRelationMapper;
import com.flf.request.OrgTree;
import com.flf.service.SubCompanyService;

public class SubCompanyServiceImpl implements SubCompanyService {

	private SubCompanyMapper subCompanyMapper;//子公司
	private SubCompanyProjectRelationMapper subCompanyProjectRelationMapper;//子公司项目关系
	private ProjectMapper projectMapper;
	private CompanyMapper companyMapper;
	
	public CompanyMapper getCompanyMapper() {
		return companyMapper;
	}

	public void setCompanyMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public SubCompanyMapper getSubCompanyMapper() {
		return subCompanyMapper;
	}

	public void setSubCompanyMapper(SubCompanyMapper subCompanyMapper) {
		this.subCompanyMapper = subCompanyMapper;
	}

	public SubCompanyProjectRelationMapper getSubCompanyProjectRelationMapper() {
		return subCompanyProjectRelationMapper;
	}

	public void setSubCompanyProjectRelationMapper(
			SubCompanyProjectRelationMapper subCompanyProjectRelationMapper) {
		this.subCompanyProjectRelationMapper = subCompanyProjectRelationMapper;
	}

	@Override
	public PageRestful listPageAllSubCompanys(SubCompany subCompany) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<SubCompany> subCompanies = subCompanyMapper.listPageAllSubCompanys(subCompany);
		subCompanies.add(0, null);
		pageRestful.setSubCompanies(subCompanies);
		pageRestful.setPage(subCompany.getPage());
		return pageRestful;
	}

	@Override
	public SubCompany getSubCompanyById(String subCompanyId) {
		// TODO Auto-generated method stub
		return subCompanyMapper.getSubCompanyById(subCompanyId);
	}

	@Override
	public int updateSubCompany(SubCompany subCompany) {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<String> projectIds = subCompany.getProjectIds();
	
		subCompany.setModifiedTime(date);
		subCompanyProjectRelationMapper.deleteRelationsBySubCompanyId(subCompany.getSubCompanyId());
		if(projectIds!=null){//插入子公司关系信息
			for (String pId : projectIds) {
				if(pId!=null && !"".equals(pId)){
					SubCompanyProjectRelation subCompanyProjectRelation = new SubCompanyProjectRelation();
					subCompanyProjectRelation.setSubCompanyId(subCompany.getSubCompanyId());
					subCompanyProjectRelation.setProjectId(pId);
					subCompanyProjectRelationMapper.insertSubCompanyProjectRelation(subCompanyProjectRelation);
				}
			}
		}
		return subCompanyMapper.updateSubCompany(subCompany);
	}

	@Override
	public int insertSubCompany(SubCompany subCompany) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		subCompany.setSubCompanyId(uuid);
		List<String> projectIds = subCompany.getProjectIds();
		List<String> companyIds = subCompany.getCompanyIds();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		subCompany.setCreateTime(date);
		if(projectIds!=null){//插入子公司关系信息
			for (String pId : projectIds) {
				if(pId!=null && !"".equals(pId)){
					SubCompanyProjectRelation subCompanyProjectRelation = new SubCompanyProjectRelation();
					subCompanyProjectRelation.setSubCompanyId(uuid);
					subCompanyProjectRelation.setProjectId(pId);
					subCompanyProjectRelationMapper.insertSubCompanyProjectRelation(subCompanyProjectRelation);
				}
			}
		}
		if(companyIds!=null){
			for(String cid : companyIds){
				if(cid!=null){
					subCompany.setCompanyId(cid);
				}
				
			}
			
		}
		return subCompanyMapper.insertSubCompany(subCompany);
	}
	
	@Override
	public List<ConpanyTree> getSubCompanyTree() {
		// TODO Auto-generated method stub
		List<SubCompany> oslist = subCompanyMapper.getAllSubCompany();
		
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		if(oslist!=null && oslist.size()>0){
			for(SubCompany os : oslist){
				if(oslist!=null && oslist.size()==1){
					oslist.add(null);					
				}				
				HashMap map = new HashMap();				
				map.put("id",os.getSubCompanyId());
				map.put("companyName",os.getSubCompanyName());
				map.put("pId", os.getCompanyId());
				
				map.put("projectId",os.getProjectId());
				map.put("projectName",os.getProjectName());
				dataList.add(map);
			}
		}
		
		HashMap<String,ConpanyTree> nodeList = new HashMap<String,ConpanyTree>();
		ConpanyTree root = null;
		  // 根据结果集构造节点列表（存入散列表）  
		  for (Iterator<Map<String,String>> it = dataList.iterator(); it.hasNext();) {  
			   Map<String,String> dataRecord = (Map<String,String>) it.next(); 
				if(dataRecord!=null && dataRecord.size()==1){
					dataRecord.get(null);		
				}
			   ConpanyTree t = new ConpanyTree();
			   
			   t.setId((String) dataRecord.get("id"));
			   t.setCompanyName((String) dataRecord.get("companyName"));
			   t.setpId((String) dataRecord.get("pId"));		 
			   
			   nodeList.put(t.getId(), t);
		} 
		
		Set<Map.Entry<String,ConpanyTree>> entrySet = nodeList.entrySet();  
		  for (Iterator<Map.Entry<String,ConpanyTree>> it = entrySet.iterator(); it.hasNext();) {  
			  ConpanyTree t1 = (ConpanyTree) ((Map.Entry<String,ConpanyTree>) it.next()).getValue();
			  if(t1.getpId() == null || t1.getpId().equals("")){
				  root = t1;
			  }else{
				  nodeList.get(t1.getpId()).getTreeList().add(t1);
			  }
		  }
		  System.out.println(root); 
		  List<ConpanyTree> treeList = new ArrayList<ConpanyTree>();
		  treeList.add(root);
		  
		return treeList;
	}

	@Override
	public List<SubCompany> getAllSubCompany() {
		// TODO Auto-generated method stub
		return subCompanyMapper.getAllSubCompany();
	}

	@Override
	public List<ConpanyTree> getAllSubCompanyStructure() {
		// TODO Auto-generated method stub
		List<ConpanyTree> treeList = new ArrayList<ConpanyTree>();
		List<SubCompany> oslist = subCompanyMapper.getAllSubCompany();
		if(oslist != null && oslist.size()>0){
			for(SubCompany os : oslist){
				ConpanyTree t = new ConpanyTree();
				t.setId(os.getSubCompanyId());
				t.setCompanyName(os.getSubCompanyName());
				t.setpId(os.getCompanyId());
				treeList.add(t);				
			}
		}
		return treeList;
	}

	@Override
	public List<SubCompany> getAllSubCompanyData(String subCompanyId) {
		// TODO Auto-generated method stub
		return subCompanyMapper.getAllSubCompanyData(subCompanyId);
	}

	@Override
	public void deleteSubCompany(SubCompany subCompany) {
		// TODO Auto-generated method stub
		List<String> list = subCompany.getSubCompanyIds();
		for (String sId : list) {
			if(sId != null && !"".equals(sId)){
				subCompanyMapper.deleteSubCompany(sId);
				subCompanyProjectRelationMapper.deleteRelationsBySubCompanyId(sId);
			}
		}
	}

	@Override
	public List<SubCompany> getSubCompanyByCompanyId(String companyId) {
		// TODO Auto-generated method stub
		return subCompanyMapper.getSubCompanyByCompanyId(companyId);
	}

	@Override
	public List<OrgTree> getOrganizationStructureTree(String projectId) {
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		//获取项目对象
		Project p = projectMapper.getProject(projectId);
		if(p!=null){
			//获取公司
			Company c = companyMapper.getCompanyById(p.getCompany());
			HashMap map = new HashMap();
			map.put("id",c.getCompanyId());
			map.put("name",c.getCompanyName());
			map.put("pid",null);
			dataList.add(map);
			//获取子公司
			List<SubCompany> scList = subCompanyMapper.getSubCompanyByCompanyId(c.getCompanyId());
			if(scList!=null && scList.size()>0){
				for(SubCompany sub : scList){
					HashMap map1 = new HashMap();
					map1.put("id",sub.getSubCompanyId());
					map1.put("name",sub.getSubCompanyName());
					map1.put("pid", c.getCompanyId());
					dataList.add(map1);
					//获取子公司下面的所有项目
					List<Project> projectList = projectMapper.getProjectBySubCompanyId(sub.getSubCompanyId());
					if(projectList!=null && projectList.size()>0){
						for(Project tProject : projectList){
							HashMap map2 = new HashMap();
							map2.put("id",tProject.getProjectId());
							map2.put("name",tProject.getProjectName());
							map2.put("pid", sub.getSubCompanyId());
							dataList.add(map2);
						}
					}
				}
			}
			HashMap<String,OrgTree> nodeList = new HashMap<String,OrgTree>();
			OrgTree root = null;
			// 根据结果集构造节点列表（存入散列表）  
			for(Iterator<Map<String,String>> it = dataList.iterator();it.hasNext();){
				Map<String,String> dataRecord = (Map<String,String>) it.next();
				OrgTree t = new OrgTree();
			    t.setId((String) dataRecord.get("id"));
			    t.setName((String) dataRecord.get("name"));
			    t.setpId((String) dataRecord.get("pid"));
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
		return null;
	}

	@Override
	public List<SubCompanyProjectRelation> getAllProject(String subCompanyId) {
		// TODO Auto-generated method stub
		return subCompanyProjectRelationMapper.getAllProject(subCompanyId);
	}
}
