package com.flf.mapper;

import java.util.List;

import com.flf.entity.AfterSale;
import com.flf.entity.AfterSaleQuery;


public interface AfterSaleQueryMapper {
    List<AfterSale> listAllAfterSale();
    List<AfterSale> listPageAfterSale(AfterSaleQuery afterSaleQuery);
    AfterSale getAfterSaleById(String id);
    int deleteAfterSale(String id);
    int insertAfterSale(AfterSale afterSale);
    int updateAfterSale(AfterSale afterSale);
}