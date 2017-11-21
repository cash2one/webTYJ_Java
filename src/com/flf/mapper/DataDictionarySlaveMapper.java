package com.flf.mapper;

import java.util.List;

import com.flf.entity.DataDictionarySlave;


public interface DataDictionarySlaveMapper {
    int deleteByPrimaryKey(String slaveId);

    int insert(DataDictionarySlave record);

    int insertSelective(DataDictionarySlave record);

    DataDictionarySlave selectByPrimaryKey(String slaveId);

    int updateByPrimaryKeySelective(DataDictionarySlave record);

    int updateByPrimaryKey(DataDictionarySlave record);
    
    /**
     * 分页显示数据字典从表数据
     * @return
     */
    List<DataDictionarySlave> listPageSlave(DataDictionarySlave dataDictionarySlave);
    
    /**
     * 查询所有数据 朱琪 2016.02.24
     * @param dataDictionarySlave
     * @return
     */
    List<DataDictionarySlave> listAllSlave();
    
    /**
     * 根据条件查询数据 朱琪 2016.03.01
     * @param slaveName
     * @return
     */
    List<DataDictionarySlave> listSlaveByName(String slaveName);
    
    /**
     * 根据项目id获取宠物数据字典表信息
     * @param projectId
     * @return
     */
    List<DataDictionarySlave> getDropboxList(String masterName,String projectId);
    
    /**
     * 查询默认从表属性
     * @author zhuqi 2016.04.15
     * @param masterName
     * @return
     */
    List<DataDictionarySlave> getDefaultByMasterName(String masterName);
    
    /**
     * 根据masterId查找数据
     * @author chenlang 2016.04.13
     * @param masterId
     * @return List<DaraDictionarySlave>
     */
    List<DataDictionarySlave> getDataDictionarySlaveByMasterId(String masterId);

    /**
     * 根据项目id查询违约系数
     * @param dataDictionarySlave
     * @return
     */
	DataDictionarySlave queryByPro(DataDictionarySlave dataDictionarySlave);
}