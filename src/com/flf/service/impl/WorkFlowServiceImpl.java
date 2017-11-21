package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.PageRestful;
import com.flf.entity.WorkFlow;
import com.flf.mapper.WorkFlowMapper;
import com.flf.service.WorkFlowService;

public class WorkFlowServiceImpl implements WorkFlowService {
	@Autowired
	private WorkFlowMapper workFlowMapper;

/*	public WorkFlowMapper getWorkFlowMapper() {
		return workFlowMapper;
	}

	public void setWorkFlowMapper(WorkFlowMapper workFlowMapper) {
		this.workFlowMapper = workFlowMapper;
	}

*/

	@Override
	public PageRestful listPageSelectAll(WorkFlow workflow) {
		PageRestful pageRestful = new PageRestful();
		List<WorkFlow> wf = workFlowMapper.listPageSelectAll(workflow);
		wf.add(0, null);
		pageRestful.setWorkFlows(wf);
		pageRestful.setPage(workflow.getPage());
		return pageRestful;
	}

}
