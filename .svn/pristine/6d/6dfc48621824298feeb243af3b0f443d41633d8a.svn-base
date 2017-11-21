package com.flf.mapper;

import java.util.List;

import com.flf.entity.FinancialCounterofferDetail;

public interface FinancialCounterofferDetailMapper {
	
	//根据id获取明细文件信息
	FinancialCounterofferDetail getFinancialCounterofferDetailById(String id);
	//根据总结文件id查询明细信息列表
	List<FinancialCounterofferDetail> getFinancialCounterofferDetailsByTotalId(String financialCounterofferTotalId);
	//插入数据库
	int insertFinancialCounterofferDetail(FinancialCounterofferDetail financialCounterofferDetail);
	//查询回盘明细文件
	List<FinancialCounterofferDetail> listPageFinancialCounterofferDetail(
			FinancialCounterofferDetail financialCounterofferDetail);
	/**
	 * 修改
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:27:09
	 * @param fcd
	 * @return
	 */
	int updateFinancialCounterofferDetail(FinancialCounterofferDetail fcd);
	/**
	 * 删除
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:27:15
	 * @param financialCounterofferDetailId
	 * @return
	 */
	int deleteByPrimaryKey(String financialCounterofferDetailId);
	/**
	 * 根据条件查询所有的回盘明细
	 * @author maogaofei
	 * @date 2016年6月12日 下午3:22:07
	 * @param financialCounterofferDetail
	 * @return
	 */
	List<FinancialCounterofferDetail> listAllFinancialCounterofferDetail(
			FinancialCounterofferDetail financialCounterofferDetail);
}
