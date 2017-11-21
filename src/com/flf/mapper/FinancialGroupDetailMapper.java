package com.flf.mapper;

import java.util.List;

import com.flf.entity.FinancialGroupDetail;

public interface FinancialGroupDetailMapper {
	
	List<FinancialGroupDetail> getDatas(String id);
	//根据id获取明细文件信息
	List<FinancialGroupDetail> getDetail(String id);
	int insertFinancialGroupDetail(FinancialGroupDetail financialGroupDetail);//插入数据库
	
	//根据总结文件id查询明细信息
	List<FinancialGroupDetail> getDatasByTotalId(String financialGroupTotalId);
	/**
	 * 根据金融联银行总文件id查询明细分页显示
	 * @author chennqiuxu
	 * @date 上午10:02
	 * @param financialGroupDetail
	 * @return
	 */
	List<FinancialGroupDetail>listPageFinancialGroupDetail(FinancialGroupDetail financialGroupDetail);
	//	插入明细文件
	int insertFinancialGroupDetailById(FinancialGroupDetail f);
	/**
	 * 根据条件查询所有的明细
	 * @author maogaofei
	 * @date 2016年6月12日 下午3:11:23
	 * @param financialGroupDetail
	 * @return
	 */
	List<FinancialGroupDetail> listAllFinancialGroupDetail(FinancialGroupDetail financialGroupDetail);
	/**
	 * 修改
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:26:31
	 * @param fgd
	 * @return
	 */
	int updateFinancialGroupDetail(FinancialGroupDetail fgd);
	/**
	 * 删除
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:26:39
	 * @param financialGroupDetailId
	 * @return
	 */
	int deleteByPrimaryKey(String financialGroupDetailId);
	
	
}
