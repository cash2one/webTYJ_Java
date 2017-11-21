package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.DataDictionaryMasterProject;

public interface DataDictionaryMasterProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataDictionaryMasterProject record);

    int insertSelective(DataDictionaryMasterProject record);

    DataDictionaryMasterProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DataDictionaryMasterProject record);

    int updateByPrimaryKey(DataDictionaryMasterProject record);
    
    /**
     * 根据主表id分页查询关联项目
     * @param slaveId
     * @return
     */
    List<DataDictionaryMasterProject> listPageProjectByMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
    
    /**
     * 根据主表id查询关联项目
     * @param slaveId
     * @return
     */
    List<DataDictionaryMasterProject> getProjectByMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
    
    /**
     * 
     * @param masterId
     * @return
     */
    DataDictionaryMasterProject selectByMasterId(String masterId);
    
    /**
     * 根据ProjectId获取COUNT
     * zhuqi 2016.02.25
     */
    List<DataDictionaryMasterProject> listCountByProjectId(String ProjectId);
    
    /**
     * 查询所有默认属性 zhuqi 2016.20.26
     * @return
     */
    List<DataDictionaryMasterProject> listAllMasterState(Map map);
    
    /**
     * 查询所有默认属性 cl 2016-05-04
     * @return
     */
    List<DataDictionaryMasterProject> listAllMasterId();
    
    /**
     * 根据masterId查询是否为默认属性
     * @param masterId
     * @return
     */
    int getCountByMasterId(String masterId);
    
    /**
     * 查询项目属性 
     * zhuqi 2016.03.15
     * @param map
     * @return List<DataDictionaryMasterProject>
     */
    List<DataDictionaryMasterProject> listMasterByProjectId(Map map);
}