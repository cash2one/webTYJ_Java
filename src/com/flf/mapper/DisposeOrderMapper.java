package com.flf.mapper;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.DisposeOrder;
/**
 * 处理工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
@XmlRootElement(name = "DisposeOrder")
public interface DisposeOrderMapper {
	int deleteDisposeOrder(String orderId);//删除处理信息

	int insertDisposeOrder(DisposeOrder disposeOrder);//添加处理信息
	
	int insertDisposeOrderUUID(DisposeOrder disposeOrder);//添加处理信息(uuid)

    List<DisposeOrder> listPageDisposeOrder(DisposeOrder disposeOrder);//分页查询处理信息
    
    List<DisposeOrder> listAllDisposeOrder();//查询所有处理信息

    DisposeOrder getDisposeOrderbyId(String orderId);//通过Id查询处理信息
    
    DisposeOrder getAppDisposeOrderbyId(String orderId);//通过Id查询处理信息app接口

    int updateDisposeOrder(DisposeOrder disposeOrder);//修改处理信息
    
    int closeDisposeOrder(String orderId); //关闭处理单

    
}