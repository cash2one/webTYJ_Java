package com.flf.mapper;

import java.util.List;

import com.flf.entity.FinancialGroupTotal;

public interface FinancialGroupTotalMapper {
	
	int insertFinancialGroupTotal(FinancialGroupTotal financialGroupTotal);//添加
	List<FinancialGroupTotal> listPageFinancial(FinancialGroupTotal financialGroupTotal);


	List<FinancialGroupTotal> getDatasById(String id);
	/**
	 * 查询条件查询所有托收的总结文件
	 * @author maogaofei
	 * @date 2016年6月1日 下午6:01:49
	 * @return
	 */
	List<FinancialGroupTotal> listAllFinancialGroupTotal(FinancialGroupTotal financialGroupTotal);
	/**
	 * 修改托收总结文件
	 * @author maogaofei
	 * @date 2016年6月3日 上午10:02:19
	 * @param financialGroupTotal
	 * @return
	 */
	int updateFinancialGroupTotal(FinancialGroupTotal financialGroupTotal);//修改
	/**
	 * 查询已托收的托收记录
	 * @author maogaofei
	 * @date 2016年6月8日 上午10:23:17
	 * @param projectId
	 * @return
	 */
	List<FinancialGroupTotal> listFinancialIng(String projectId);
	/**
	 * 删除
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:26:03
	 * @param financialGroupTotalId
	 */
	int deleteByPrimaryKey(String financialGroupTotalId);
	/**
	 * 根据交易文件名头模糊查询已回盘的所有托收总结记录
	 * @author maogaofei
	 * @date 2016年6月12日 下午4:36:42
	 * @param batchNumberHeader
	 * @return
	 */
	List<FinancialGroupTotal> listAllFGTLikeFileNameHeader(String batchNumberHeader,String projectId);
}
