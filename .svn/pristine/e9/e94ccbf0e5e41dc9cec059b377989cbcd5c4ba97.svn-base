package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.CarInfo;
import com.flf.entity.LeaseContract;
import com.flf.entity.PageRestful;
import com.flf.entity.TcArticleState;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.LeaseContractMapper;
import com.flf.service.LeaseContractService;

public class LeaseContractServiceImpl implements LeaseContractService{
	
	private LeaseContractMapper leaseContractMapper;
	
	private AnnexMapper annexMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public LeaseContractMapper getLeaseContractMapper() {
		return leaseContractMapper;
	}

	public void setLeaseContractMapper(LeaseContractMapper leaseContractMapper) {
		this.leaseContractMapper = leaseContractMapper;
	}

	@Override
	public List<LeaseContract> listAllLeaseContracts() {
		return leaseContractMapper.listAllLeaseContract();
	}

	@Override
	public PageRestful listPageLeaseContracts(LeaseContract leaseContract) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<LeaseContract> leaseContracts =leaseContractMapper.listPageLeaseContracts(leaseContract);
		leaseContracts.add(0,null);
		pagerestful.setLeaseContracts(leaseContracts);
		pagerestful.setPage(leaseContract.getPage());
		return pagerestful;
	}

	@Override
	public int insertLeaseContract(LeaseContract leaseContract) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String uuid = UUID.randomUUID().toString();
		leaseContract.setContractId(uuid);
		if(leaseContract != null){
			List<Annex> annexList = leaseContract.getAnnexs();
			Integer result = leaseContractMapper.insert(leaseContract);
			if(result >0){
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
		
		//leaseContract.setContractId(UUID.randomUUID().toString());
		return 200;
	}
	
	

}
