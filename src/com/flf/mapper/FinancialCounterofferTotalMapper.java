package com.flf.mapper;


import java.util.List;

import com.flf.entity.FinancialCounterofferTotal;

public interface FinancialCounterofferTotalMapper {
	
	int insertFinancialCounterofferTotal(FinancialCounterofferTotal financialCounterofferTotal);//添加

	FinancialCounterofferTotal getFinancialCounterofferTotalById(String id);//根据ID获取回盘总结文件
	//查询回盘总结文件列表
	List<FinancialCounterofferTotal> listPageFinancialCounterofferTotal(
			FinancialCounterofferTotal financialCounterofferTotal);
	/**
	 * 修改
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:26:52
	 * @param fcot
	 * @return
	 */
	int updateFinancialCounterofferTotal(FinancialCounterofferTotal fcot);
	/**
	 * 删除
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:26:58
	 * @param financialCounterofferTotalId
	 * @return
	 */
	int deleteByPrimaryKey(String financialCounterofferTotalId);
	/**
	 * 根据条件查询所有的回盘导入文件
	 * @author maogaofei
	 * @date 2016年6月12日 下午3:17:39
	 * @param financialCounterofferTotal
	 * @return
	 */
	List<FinancialCounterofferTotal> listAllFinancialCounterofferTotal(
			FinancialCounterofferTotal financialCounterofferTotal);
}
