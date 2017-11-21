package com.flf.mapper;

import java.util.List;

import com.flf.entity.Prepare;
import com.flf.entity.SpecialtyInfo;

public interface SpecialtyInfoMapper {
	List<SpecialtyInfo> listAllSpecialtyInfo();
	List<SpecialtyInfo> listAllSpecialtyInfoList();
    List<SpecialtyInfo> listPageSpecialtyInfo(SpecialtyInfo specialtyInfo);
    SpecialtyInfo getSpecialtyInfoById(String specialtyId);
    int deleteSpecialtyInfo(String specialtyId);
    int insertSpecialtyInfo(SpecialtyInfo specialtyInfo);
    int updateSpecialtyInfo(SpecialtyInfo specialtyInfo); 
    SpecialtyInfo selectSpecialtyInfoById(String specialtyId);
    //根据项目id查询专业线信息
    List<Prepare> getPreparebyprojectId(String projectId);
    
    //开启专业线
    int updateSpecialtyInfobystate(SpecialtyInfo specialtyInfo);
    
    List<SpecialtyInfo> listAllSpecialtyInfoAndPostRestful();
    
    List<SpecialtyInfo> listlistAllSpecialtyInfoNum();//查询所有项目相关的专业线满编人数和缺编人数
	List<SpecialtyInfo> listAllSpecialtyInfoAndPostOpen();//查询所有开启了的专业线
	List<SpecialtyInfo> listSpecialtyInfoBystaffId(String staffId);
	
	List<SpecialtyInfo> listSpecialtyInfoByCompanyId(String specialtyId,String companyId);
	
	SpecialtyInfo getSpecialtyInfoByName(String specialtyName);
	
	List<SpecialtyInfo> listSpecialtyInfo();
	
}
