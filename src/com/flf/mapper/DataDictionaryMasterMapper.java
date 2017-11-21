package com.flf.mapper;

import java.util.List;

import com.flf.entity.DataDictionaryMaster;
import com.flf.entity.DataDictionaryMasterProject;


public interface DataDictionaryMasterMapper {
    int deleteByPrimaryKey(String masterId);

    int insert(DataDictionaryMaster record);

    int insertSelective(DataDictionaryMaster record);

    DataDictionaryMaster selectByPrimaryKey(String masterId);

    int updateByPrimaryKeySelective(DataDictionaryMaster record);

    int updateByPrimaryKey(DataDictionaryMaster record);
    
    /**
     * 分页显示数据字典主表数据
     * @return
     */
    List<DataDictionaryMaster> listPageMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
    
    /**
     * 查询所有字典主表数据
     * @param dataDictionaryMasterProject
     * @return
     */
    List<DataDictionaryMasterProject> listAllMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
    
    int getDataDictionaryName(String masterName);  //根据属性名称查看属性名称是否重复
    
}