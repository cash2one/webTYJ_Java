package com.flf.mapper;

import java.util.List;

import com.flf.entity.ProductFixedparkingspace;
import com.flf.entity.ProductFixedparkingspaceChild;

public interface ProductFixedparkingspaceChildMapper {
    int deleteByPrimaryKey(String fixedparkingspaceChildId);
    
    int deleteByPfId(String pfid);

    int insert(ProductFixedparkingspaceChild record);

    int insertSelective(ProductFixedparkingspaceChild record);

    ProductFixedparkingspaceChild selectByPrimaryKey(String fixedparkingspaceChildId);

    int updateByPrimaryKeySelective(ProductFixedparkingspaceChild record);

    int updateByPrimaryKey(ProductFixedparkingspaceChild record);
    
    List<ProductFixedparkingspaceChild> listPageFullnNameById(ProductFixedparkingspaceChild id);
    
    List<ProductFixedparkingspaceChild> listPageAllPfc(ProductFixedparkingspaceChild pfc);
    List<ProductFixedparkingspaceChild> checkStall();
}