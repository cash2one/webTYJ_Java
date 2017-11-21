package com.flf.service.impl;

import java.util.List;

import com.flf.entity.PageRestful;
import com.flf.entity.PendingApproval;
import com.flf.mapper.PendingApprovalMapper;
import com.flf.service.PendingApprovalService;

public class PendingApprovalServiceImpl implements PendingApprovalService{

	private  PendingApprovalMapper pendingApprovalMapper;
	
	public PendingApprovalMapper getPendingApprovalMapper() {
		return pendingApprovalMapper;
	}

	public void setPendingApprovalMapper(PendingApprovalMapper pendingApprovalMapper) {
		this.pendingApprovalMapper = pendingApprovalMapper;
	}

	@Override
	public PageRestful listPagePendingApproval(PendingApproval pendingApproval) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<PendingApproval> list =pendingApprovalMapper.listPagePendingApproval(pendingApproval);
		list.add(0,null);
		pageRestful.setPendingApprovals(list);
		pageRestful.setPage(pendingApproval.getPage());
		return pageRestful;
	}

	@Override
	public List<PendingApproval> selectAllPendingApproval() {
		// TODO Auto-generated method stub
		return pendingApprovalMapper.selectAllPendingApproval();
	}

}
