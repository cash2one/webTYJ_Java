package com.flf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flf.entity.CassetRepository;
import com.flf.request.CassetRepositoryReault;
import com.flf.request.PropertyResult;



public interface CassetRepositoryMapper {
	
	List<CassetRepository> ListPageCassetRepository(CassetRepository cassetRepository);//分页查询资产库
	
	List<CassetRepository> ListCassetRepositoryAll();//查询所有资产库
	
	List<CassetRepository> ListCassetRepositoryByProjectId(String projectId);//查询所有资产库
	
	CassetRepository selectCassetRepositoryById(String cassetRepositoryId);//根据id查询资产库信息
	
    int insertCassetRepository(CassetRepository cassetRepository); //添加资产库信息
    
    int updateCassetRepository(CassetRepository cassetRepository);//修改资产库信息

    int deleteCassetRepository(String cassetRepositoryId);//删除资产库信息
    
    List<CassetRepository> listCassetRepositoryAllBybuildingStructureId(PropertyResult propertyResult); //根据建筑结构id查询资产库信息
    
    List<CassetRepository> getCassetRepositorybyCondition(CassetRepository cassetRepository);//根据条件查询资产库信息
    
    List<CassetRepositoryReault> listPageSpecialAndClassify(CassetRepository cassetRepository);//根据条件查询资产库信息（新）
    	
    CassetRepository getCassetRepositoryDatils(String id);//查询详情
    
}