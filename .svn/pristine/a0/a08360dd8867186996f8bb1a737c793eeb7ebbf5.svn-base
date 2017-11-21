package com.flf.mapper;

import java.util.List;

import com.flf.entity.SpecialtyInfoProject;

public interface SpecialtyInfoProjectMapper {
    int deleteByPrimaryKey(String specialtyId);

    int insert(SpecialtyInfoProject record);

    int insertSelective(SpecialtyInfoProject record);

    SpecialtyInfoProject selectByPrimaryKey(String specialtyId);

    int updateByPrimaryKeySelective(SpecialtyInfoProject record);

    int updateByPrimaryKey(SpecialtyInfoProject record);
    
    List<SpecialtyInfoProject> listSpecialtyInfoProjectOpen(String projectId);
    
    List<SpecialtyInfoProject> listSpecialtyInfoProject();
    
    List<SpecialtyInfoProject> listSpecialtyInfoProjectByCompanyId(String CompanyId,String SpecialtyId);
    
    List<SpecialtyInfoProject> listSpecialtyInfoProjectByProjectId(String projectId);
}