package com.flf.mapper;

import java.util.List;

import com.flf.entity.Parcel;

public interface ParcelMapper {
    int deleteByPrimaryKey(String parcelId);

    int insertParcel(Parcel parcel); //新增宗地
    
    int insertListParcel(List<Parcel> parcel); //新增多个宗地

    int insertSelective(Parcel record);

    Parcel selectByPrimaryKey(String parcelId);//通过Id查询宗地信息

    int updateByPrimaryKeySelective(Parcel record);

    int updateByPrimaryKey(Parcel record);//修改宗地信息
    
    List<Parcel> selectByProjectId(String projectId);
}