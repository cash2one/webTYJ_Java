package com.flf.mapper;

import java.util.List;

import com.flf.entity.ProductCommonservice;
public interface ProductCommonserviceMapper {
    int deleteByPrimaryKey(String commonserviceId);

    int insert(ProductCommonservice record);

    int insertSelective(ProductCommonservice record);

    ProductCommonservice selectByPrimaryKey(String commonserviceId);
    
    ProductCommonservice selectByName(String commonserviceName);
    ProductCommonservice selectMaxCode();

    int updateByPrimaryKeySelective(ProductCommonservice record);

    int updateByPrimaryKey(ProductCommonservice record);
    
    List<ProductCommonservice> getProductCommonByType(String Type);
    
}