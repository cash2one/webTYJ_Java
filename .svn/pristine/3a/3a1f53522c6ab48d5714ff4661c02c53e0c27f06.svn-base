package com.flf.mapper;


import java.util.List;

import com.flf.entity.CompensateMethods;
/**
 * 赔偿方案
 * 创建人：shaozheng
 * 创建时间：2015/6/25
 */
public interface CompensateMethodsMapper {
	int deleteCompensateMethods(String compensateMethodId);//删除赔偿方案信息

	int insertCompensateMethods(CompensateMethods compensateMethods);//添加赔偿方案信息

    List<CompensateMethods> listPageCompensateMethods(CompensateMethods compensateMethods);//分页查询赔偿方案信息
    
    List<CompensateMethods> listAllCompensateMethods();//查询所有赔偿方案信息

    CompensateMethods getCompensateMethodsbyId(String compensateMethodId);//通过Id查询赔偿方案信息

    int updateCompensateMethods(CompensateMethods compensateMethods);//修改赔偿方案信息
    
    CompensateMethods getCompensateMethodsbyOrderId(String orderId);//根据工单id获取赔偿方案信息

    
}