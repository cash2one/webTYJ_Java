package com.flf.mapper;

import java.util.List;

import com.flf.entity.WorkFlow;

public interface WorkFlowMapper {
    int deleteByPrimaryKey(String workflowId);

    int insert(WorkFlow record);

    int insertSelective(WorkFlow record);

    WorkFlow selectByPrimaryKey(String workflowId);

    int updateByPrimaryKeySelective(WorkFlow record);

    int updateByPrimaryKey(WorkFlow record);


    
    /**
     * 查询工作流表所有数据
     * @return
     */
	List<WorkFlow> listPageSelectAll(WorkFlow workflow);
}