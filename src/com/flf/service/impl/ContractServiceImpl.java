/**
 * @Title: ContractServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-11 下午4:38:08
 * @version V1.0
 */

package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.Contract;
import com.flf.entity.ContractPropertyStructure;
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ContractMapper;
import com.flf.mapper.ContractPropertyStructureMapper;
import com.flf.mapper.OrderAttachmentMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.request.PropertyResult;
import com.flf.service.ContractService;
import com.flf.service.LogService;

/**
 * @ClassName: ContractServiceImpl
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-11 下午4:38:08
 *
 */

public class ContractServiceImpl implements ContractService {

	private ContractMapper contractMapper;
	
    private LogService logService;
	
	private OrderAttachmentMapper orderAttachmentMapper;
	
	private ContractPropertyStructureMapper contractPropertyStructureMapper;
	
	private AnnexMapper annexMapper;
	
	private PropertyMapper propertyMapper;
	
	/*
	 * <p>Title: listPageContract</p>
	 * <p>Description: </p>
	 * @param contract
	 * @return
	 * @see com.flf.service.ContractService#listPageContract(com.flf.entity.Contract)
	 */

	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}

	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public OrderAttachmentMapper getOrderAttachmentMapper() {
		return orderAttachmentMapper;
	}

	public void setOrderAttachmentMapper(OrderAttachmentMapper orderAttachmentMapper) {
		this.orderAttachmentMapper = orderAttachmentMapper;
	}

	public ContractPropertyStructureMapper getContractPropertyStructureMapper() {
		return contractPropertyStructureMapper;
	}

	public void setContractPropertyStructureMapper(
			ContractPropertyStructureMapper contractPropertyStructureMapper) {
		this.contractPropertyStructureMapper = contractPropertyStructureMapper;
	}

	public ContractMapper getContractMapper() {
		return contractMapper;
	}

	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	/*
	 * <p>Title: listAllContract</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.ContractService#listAllContract()
	 */

	@Override
	public List<Contract> listAllContract() {
		// TODO Auto-generated method stub
		return contractMapper.listAllContract();
	}

	/*
	 * <p>Title: getContractById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.ContractService#getContractById(java.lang.String)
	 */

	@Override
	public Contract getContractById(String id) {
		// TODO Auto-generated method stub
		return contractMapper.getContractById(id);
	}

	/*
	 * <p>Title: insertContract</p>
	 * <p>Description: </p>
	 * @param contract
	 * @return
	 * @see com.flf.service.ContractService#insertContract(com.flf.entity.Contract)
	 */

	@Override
	public int insertContract(Contract contract) {
		// TODO Auto-generated method stub
		return contractMapper.insertContract(contract);
	}

	/*
	 * <p>Title: updateContract</p>
	 * <p>Description: </p>
	 * @param contract
	 * @return
	 * @see com.flf.service.ContractService#updateContract(com.flf.entity.Contract)
	 */

	@Override
	public int updateContract(Contract contract) {
		// TODO Auto-generated method stub
		return contractMapper.updateContract(contract);
	}

	/*
	 * <p>Title: deleteContract</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.ContractService#deleteContract(java.lang.String)
	 */

	@Override
	public int deleteContract(String id) {
		// TODO Auto-generated method stub
		return contractMapper.deleteContract(id);
	}
	
	/*
	  * <p>Title: DeleteAccountById</p>
	  * <p>Description: </p>
	  * @param id
	  * @see com.flf.service.ContractService#DeleteAccountById(java.lang.String)
	  */
	
	
	@Override
	public void DeleteAccountById(String id) {
		// TODO Auto-generated method stub
		contractMapper.deleteContract(id);
	}
	
	/*
	  * <p>Title: getContractByIdRest</p>
	  * <p>Description: </p>
	  * @param accountId
	  * @return
	  * @see com.flf.service.ContractService#getContractByIdRest(java.lang.Integer)
	  */
	
	
	@Override
	public Contract getContractByIdRest(String id) {
		// TODO Auto-generated method stub
		return contractMapper.getContractById(id);
	}
	
	/*
	  * <p>Title: insertContractRest</p>
	  * <p>Description: </p>
	  * @param contract
	  * @see com.flf.service.ContractService#insertContractRest(com.flf.entity.Contract)
	  */
	
	
//	@Override
//	public void insertContractRest(Contract contract) {
//		// TODO Auto-generated method stub
//		contractMapper.insertContract(contract);
//	}
	
	/*
	  * <p>Title: listAllContractRest</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.ContractService#listAllContractRest()
	  */
	
	
	@Override
	public List<Contract> listAllContractRest() {
		// TODO Auto-generated method stub
		return contractMapper.listAllContract();
	}
	
	/*
	  * <p>Title: updateContractRest</p>
	  * <p>Description: </p>
	  * @param contract
	  * @see com.flf.service.ContractService#updateContractRest(com.flf.entity.Contract)
	  */
	
	
	@Override
	public void updateContractRest(Contract contract) {
		// TODO Auto-generated method stub
		contractMapper.updateContract(contract);
	}


	/**
	 * 新增合同
	 */
	@Override
	public void insertInitializeProperty(PropertyResult propertyResult) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Contract contract=propertyResult.getContract();
		contract.setId(uuid);
		if(propertyResult != null){
			List<Annex> annexList = contract.getAnnexs();
			List<String> propertys=propertyResult.getPropertys();//资产id集合
			List<String> buildingStructures=propertyResult.getBuildingStructureNews();//建筑结构id集合
			List<Property> propertyList = propertyResult.getPropertyList();
			List<String> functionals=propertyResult.getFunctionals();
			List<Date> startTimes=propertyResult.getStartTimes();
			Integer result = contractMapper.insertContract(contract);
			if(result > 0){
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				for (String property : propertys) {
					if(propertyList != null && propertyList.size() >0){
						for(Property proper : propertyList){
							propertyMapper.updateByPrimaryKey(proper);
						}
					}
					for(String functional:functionals){
					
					}
						
				for(Date startTime:startTimes){
					
				}
					
					for (String buildingStructure : buildingStructures) {
						for(String functional:functionals){
							
						}
							
					for(Date startTime:startTimes){
						
					}
						ContractPropertyStructure contractPropertyStructure=new ContractPropertyStructure();
						contractPropertyStructure.setPropertyId(property);//资产id
						contractPropertyStructure.setContractId(contract.getId());//合同id
						contractPropertyStructure.setBuildingStructureId(buildingStructure);//建筑结构id
				/*		contractPropertyStructure.setFunctionalId(functional);
						contractPropertyStructure.setStartTime(startTime);*/
						contractPropertyStructureMapper.insertContractPropertyStructure(contractPropertyStructure);
					}
					
					
				}
			}
		}
		
	}

	@Override
	public PageRestful listPageContract(Contract contract) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Contract> contractList = contractMapper.listPageContract(contract);
		contractList.add(0,null);
		pageRestful.setContract(contractList);
		pageRestful.setPage(contract.getPage());
		return pageRestful;
	}

	@Override
	public List<Contract> getContractDataByIdRest(String id) {
		// TODO Auto-generated method stub
		return contractMapper.getContractDataById(id);
	}

	
	/**
	 * 新增合同
	 * 版本 001
	 * BUG 371 陶勇超 2016年1月18日 16:07:23
	 */
	@Override
	public void insertContractRest(Contract contract) {
		String uuid=UUID.randomUUID().toString();
		contract.setId(uuid);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Integer result = contractMapper.insertContract(contract);
		List<Annex> annexList = contract.getAnnexs();
		if(result > 0){
			if(annexList != null && annexList.size()>0){
				for(Annex annex : annexList){
					annex.setRelationId(uuid);
					annex.setAnnexTime(date);
					annexMapper.insertAnnex(annex);
				}
			}
		if(contract.getContractPropertyStructures() != null && contract.getContractPropertyStructures().size() > 0){
			for(ContractPropertyStructure ahr :contract.getContractPropertyStructures()){
				ahr.setPropertyId(ahr.getPropertyId());//资产id
				ahr.setContractId(contract.getId());//合同id
				ahr.setBuildingStructureId(ahr.getBuildingStructureId());//建筑结构id
			ahr.setFunctionalId(ahr.getFunctionalId());
				ahr.setStartTime(ahr.getStartTime());
				contractPropertyStructureMapper.insertContractPropertyStructure(ahr);
			}
		}
	}

	}

	
	
}
