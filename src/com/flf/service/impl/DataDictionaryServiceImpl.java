package com.flf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.flf.entity.DataDictionaryMaster;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.DataDictionaryMasterProject;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.mapper.DataDictionaryMasterMapper;
import com.flf.mapper.DataDictionarySlaveMapper;
import com.flf.mapper.DataDictionaryMasterProjectMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.service.DataDictionaryService;

public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	private DataDictionaryMasterMapper dataDictionaryMasterMapper;
	
	private DataDictionarySlaveMapper dataDictionarySlaveMapper;
	
	private DataDictionaryMasterProjectMapper dataDictionaryMasterProjectMapper;
	
	private ProjectMapper projectMapper;

	/**
	 * 分页查询数据字典表主表
	 * 朱琪 2016.02.26
	 */
	@Override
	public PageRestful listPageMaster(DataDictionaryMasterProject dataDictionaryMasterProject) {

		//定义返回值
		PageRestful pageRestful=new PageRestful();
		//获取默认项目
		Project project = projectMapper.getProjectByState();
		//获取当前项目的属性
		List<DataDictionaryMasterProject> listProject = dataDictionaryMasterProjectMapper.getProjectByMaster(dataDictionaryMasterProject);
		dataDictionaryMasterProject.setProjectId(project.getProjectId());
		//获取默认项目的属性
//		List<DataDictionaryMasterProject> listProjectState = dataDictionaryMasterProjectMapper.listCountByProjectId(project.getProjectId());
		List<DataDictionaryMasterProject> listProjectState = dataDictionaryMasterProjectMapper.listPageProjectByMaster(dataDictionaryMasterProject);
		

		//将默认的属性与当前属性对比覆盖重复
		for(int i = 0; i < listProjectState.size(); i++){
			for(int j = 0; j < listProject.size(); j++){
				//有自设属性覆盖默认属性
				if(listProject.get(j).getDataDictionaryMaster() != null){
					if(listProjectState.get(i).getDataDictionaryMaster().getMasterName().equals(listProject.get(j).getDataDictionaryMaster().getMasterName())){
						//覆盖属性
						listProjectState.get(i).setDataDictionaryMaster(listProject.get(j).getDataDictionaryMaster());
					}
				}
			}
		}
		listProjectState.add(0,null);
		pageRestful.setDataDictionaryMasterProjects(listProjectState);
		pageRestful.setPage(dataDictionaryMasterProject.getPage());
		return pageRestful;
	}

	/**
	 * 分页查询数据字典从表
	 */
	@Override
	public PageRestful listPageSlave(DataDictionarySlave dataDictionarySlave) {

		//定义返回值
		PageRestful pageRestful = new PageRestful();
		//查询
		List<DataDictionarySlave> dataDictionarySlaves = dataDictionarySlaveMapper.listPageSlave(dataDictionarySlave);
		dataDictionarySlaves.add(0, null);
		pageRestful.setDataDictionarySlaves(dataDictionarySlaves);
		pageRestful.setPage(dataDictionarySlave.getPage());
		return pageRestful;
	}
	
	/**
	 * 新增数据字典主表数据
	 */
	@Override
	public int insertMaster(DataDictionaryMaster dataDictionaryMaster) {
		int count = dataDictionaryMasterMapper.getDataDictionaryName(dataDictionaryMaster.getMasterName());
		if(count>0){
			return -1;
		}else{
			dataDictionaryMaster.setMasterId(UUID.randomUUID().toString());
			dataDictionaryMaster.setCreateTime(new Date());
			Integer result = dataDictionaryMasterMapper.insert(dataDictionaryMaster);
			DataDictionaryMasterProject ddmp = new DataDictionaryMasterProject();
			ddmp.setId(UUID.randomUUID().toString());
			ddmp.setMasterId(dataDictionaryMaster.getMasterId());
			ddmp.setProjectId(dataDictionaryMaster.getProject().getProjectId());
			dataDictionaryMasterProjectMapper.insert(ddmp);
			return result;
		}
	}

	/**
	 * 新增数据字典从表数据
	 */
	@Override
	public int insertSlave(DataDictionarySlave dataDictionarySlave) {
		int state = 1;
		dataDictionarySlave.setSlaveId(UUID.randomUUID().toString());
		dataDictionarySlave.setCreateTime(new Date());
		//查询是否已存在属性
		List<DataDictionaryMasterProject> list = dataDictionaryMasterProjectMapper.listCountByProjectId(dataDictionarySlave.getProject().getProjectId());
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			if(list.get(i).getDataDictionaryMaster() != null){
				if(list.get(i).getDataDictionaryMaster().getMasterName() != null){
					DataDictionaryMasterProject dmp = list.get(i);
					DataDictionaryMaster d = dmp.getDataDictionaryMaster();
					if(dataDictionarySlave.getDataDictionaryMaster().getMasterName().equals(d.getMasterName())){
						dataDictionarySlave.setMasterId(dmp.getMasterId());
						state = 0;//没有新增属性
						break;
					}
				}
			}
		}
		if(i == list.size() || list == null){
			DataDictionaryMaster dataDictionaryMaster = new DataDictionaryMaster();
			dataDictionaryMaster.setMasterId(UUID.randomUUID().toString());
			dataDictionaryMaster.setMasterName(dataDictionarySlave.getDataDictionaryMaster().getMasterName());
			dataDictionaryMaster.setDescription(dataDictionarySlave.getDataDictionaryMaster().getDescription());
			dataDictionaryMaster.setStatus(dataDictionarySlave.getStatus());
			dataDictionaryMaster.setCreateId(dataDictionarySlave.getCreateId());
			dataDictionaryMaster.setCreateTime(new Date());
			dataDictionaryMasterMapper.insert(dataDictionaryMaster);
			DataDictionaryMasterProject ddmp = new DataDictionaryMasterProject();
			ddmp.setId(UUID.randomUUID().toString());
			ddmp.setMasterId(dataDictionaryMaster.getMasterId());
			ddmp.setProjectId(dataDictionarySlave.getProject().getProjectId());
			dataDictionaryMasterProjectMapper.insert(ddmp);
			dataDictionarySlave.setMasterId(dataDictionaryMaster.getMasterId());
			state = 1;//新增了属性
		}
		List<DataDictionarySlave> ldd = dataDictionarySlaveMapper.getDataDictionarySlaveByMasterId(dataDictionarySlave.getMasterId());
		for(DataDictionarySlave dds :ldd){
			if (dataDictionarySlave.getSlaveName().equals(dds.getSlaveName())
					&& dataDictionarySlave.getDescription().equals(dds.getDescription())) {
				return state = 2;
			}
		}
		
		dataDictionarySlaveMapper.insert(dataDictionarySlave);
		return state;
	}

	/**
	 * 修改数据字典主表数据
	 */
	@Override
	public void updateMaster(DataDictionaryMaster dataDictionaryMaster) {
		dataDictionaryMaster.setUpdateTime(new Date());
		dataDictionaryMasterMapper.updateByPrimaryKey(dataDictionaryMaster);
	}

	/**
	 * 修改数据字典从表数据
	 */
	@Override
	public int updateSlave(DataDictionarySlave dataDictionarySlave) {
		//默认属性无法修改
		if(dataDictionaryMasterProjectMapper.getCountByMasterId(dataDictionarySlave.getMasterId()) > 0){
			return 0;
		}
		dataDictionarySlave.setUpdateTime(new Date());
		dataDictionarySlaveMapper.updateByPrimaryKey(dataDictionarySlave);
		return 1;
	}

	/**
	 * 删除数据字典主表数据
	 */
	@Override
	public void deleteMaster(String masterIds) {
		String[] masterIdList = masterIds.split(",");
		for(int i = 0; i < masterIdList.length; i ++){
			DataDictionaryMaster ddm = dataDictionaryMasterMapper.selectByPrimaryKey(masterIdList[i]);
			ddm.setUpdateId("admin");
			ddm.setUpdateTime(new Date());
			ddm.setStatus("1");
			dataDictionaryMasterMapper.updateByPrimaryKey(ddm);
			DataDictionarySlave ddss = new DataDictionarySlave();
			ddss.setMasterId(ddm.getMasterId());
			List<DataDictionarySlave> dataDictionarySlaves = dataDictionarySlaveMapper.listPageSlave(ddss);
			if(dataDictionarySlaves != null && dataDictionarySlaves.size() > 0){
				for(int j = 0; j < dataDictionarySlaves.size(); j ++){
					DataDictionarySlave dds = dataDictionarySlaveMapper.selectByPrimaryKey(dataDictionarySlaves.get(j).getSlaveId());
					dds.setUpdateId("admin");
					dds.setUpdateTime(new Date());
					dds.setStatus("1");
					dataDictionarySlaveMapper.updateByPrimaryKey(dds);
				}
			}
		}
	}
	
	/**
	 * 删除数据字典主表数据-改为有效
	 */
	@Override
	public void deleteMasterOn(String masterIds) {
		String[] masterIdList = masterIds.split(",");
		for(int i = 0; i < masterIdList.length; i ++){
			DataDictionaryMaster ddm = dataDictionaryMasterMapper.selectByPrimaryKey(masterIdList[i]);
			ddm.setUpdateId("admin");
			ddm.setUpdateTime(new Date());
			ddm.setStatus("0");
			dataDictionaryMasterMapper.updateByPrimaryKey(ddm);
			DataDictionarySlave ddss = new DataDictionarySlave();
			ddss.setMasterId(ddm.getMasterId());
			List<DataDictionarySlave> dataDictionarySlaves = dataDictionarySlaveMapper.listPageSlave(ddss);
			if(dataDictionarySlaves != null && dataDictionarySlaves.size() > 0){
				for(int j = 0; j < dataDictionarySlaves.size(); j ++){
					DataDictionarySlave dds = dataDictionarySlaveMapper.selectByPrimaryKey(dataDictionarySlaves.get(j).getSlaveId());
					dds.setUpdateId("admin");
					dds.setUpdateTime(new Date());
					dds.setStatus("0");
					dataDictionarySlaveMapper.updateByPrimaryKey(dds);
				}
			}
		}
	}

	/**
	 * 删除数据字典从表数据-失效
	 */
	@Override
	public int deleteSlave(String slaveIds, String masterId) {
		//默认属性无法修改
		if(dataDictionaryMasterProjectMapper.getCountByMasterId(masterId) > 0){
			return 0;
		}
		
		String[] slaveIdList = slaveIds.split(",");
		for(int i = 0; i < slaveIdList.length; i ++){
			DataDictionarySlave dds = dataDictionarySlaveMapper.selectByPrimaryKey(slaveIdList[i]);
			dds.setUpdateId("admin");
			dds.setUpdateTime(new Date());
			dds.setStatus("1");
			dataDictionarySlaveMapper.updateByPrimaryKey(dds);
		}
		return 1;
	}
	
	/**
	 * 删除数据字典从表数据-开启	
	 */
	@Override
	public int deleteSlaveOn(String slaveIds, String masterId) {
		//默认属性无法修改
		if(dataDictionaryMasterProjectMapper.getCountByMasterId(masterId) > 0){
			return 0;
		}
		String[] slaveIdList = slaveIds.split(",");
		for(int i = 0; i < slaveIdList.length; i ++){
			DataDictionarySlave dds = dataDictionarySlaveMapper.selectByPrimaryKey(slaveIdList[i]);
			dds.setUpdateId("admin");
			dds.setUpdateTime(new Date());
			dds.setStatus("0");
			dataDictionarySlaveMapper.updateByPrimaryKey(dds);
		}
		return 1;
	}
	
	@Override
	public PageRestful listPageProjectByMaster(DataDictionaryMasterProject dataDictionaryMasterProject){
		//定义返回值
		PageRestful pageRestful = new PageRestful();
		//查询
		List<DataDictionaryMasterProject> dataDictionaryMasterprojects = dataDictionaryMasterProjectMapper.listPageProjectByMaster(dataDictionaryMasterProject);
		dataDictionaryMasterprojects.add(0, null);
		pageRestful.setDataDictionaryMasterProjects(dataDictionaryMasterprojects);
		pageRestful.setPage(dataDictionaryMasterProject.getPage());
		return pageRestful;
	}
	
	@Override
	public void insertDataDictionaryMasterProject(String masterId, String projectIds){
		String[] projectIdList = projectIds.split(",");
		for(int i = 0; i < projectIdList.length; i ++){
			DataDictionaryMasterProject ddmp = new DataDictionaryMasterProject();
			ddmp.setId(UUID.randomUUID().toString());
			ddmp.setMasterId(masterId);
			ddmp.setProjectId(projectIdList[i]);
			dataDictionaryMasterProjectMapper.insert(ddmp);
		}
	}
	
	@Override
	public void deleteProjectAndMaster(String ids){
		String[] idList = ids.split(",");
		for(int i = 0; i <idList.length; i ++){
			dataDictionaryMasterProjectMapper.deleteByPrimaryKey(idList[i]);
		}
	}
	
	@Override
	public List<DataDictionaryMasterProject> listAllMaster(DataDictionaryMasterProject dataDictionaryMasterProject) {
		// TODO Auto-generated method stub
	//	return dataDictionaryMasterMapper.listAllMasterState();
		List<DataDictionaryMasterProject> ddmpList = new ArrayList<>();
		Map map = new HashMap();
		if(dataDictionaryMasterProject.getDescription() == null && dataDictionaryMasterProject.getMasterName() == null){
			map.put("masterName", "eduLever");
		}else{
			if(dataDictionaryMasterProject.getDescription() != null){
				map.put("description", dataDictionaryMasterProject.getDescription());
			}
			if(dataDictionaryMasterProject.getMasterName() != null){
				map.put("masterName", dataDictionaryMasterProject.getMasterName());
			}
		}
		if(dataDictionaryMasterProject.getProjectId() != null){
			map.put("projectId", dataDictionaryMasterProject.getProjectId());
			ddmpList = dataDictionaryMasterProjectMapper.listMasterByProjectId(map);
			if(ddmpList.size() != 0){
				return ddmpList;
			}
		}
		ddmpList = dataDictionaryMasterProjectMapper.listAllMasterState(map);
		return ddmpList;
	}

	public List<DataDictionaryMasterProject> listAllMasterId(){
		return dataDictionaryMasterProjectMapper.listAllMasterId();
	}
	
	public DataDictionaryMasterMapper getDataDictionaryMasterMapper() {
		return dataDictionaryMasterMapper;
	}

	public void setDataDictionaryMasterMapper(
			DataDictionaryMasterMapper dataDictionaryMasterMapper) {
		this.dataDictionaryMasterMapper = dataDictionaryMasterMapper;
	}

	public DataDictionarySlaveMapper getDataDictionarySlaveMapper() {
		return dataDictionarySlaveMapper;
	}

	public void setDataDictionarySlaveMapper(
			DataDictionarySlaveMapper dataDictionarySlaveMapper) {
		this.dataDictionarySlaveMapper = dataDictionarySlaveMapper;
	}

	public DataDictionaryMasterProjectMapper getDataDictionaryMasterProjectMapper() {
		return dataDictionaryMasterProjectMapper;
	}

	public void setDataDictionaryMasterProjectMapper(
			DataDictionaryMasterProjectMapper dataDictionaryMasterProjectMapper) {
		this.dataDictionaryMasterProjectMapper = dataDictionaryMasterProjectMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

}
