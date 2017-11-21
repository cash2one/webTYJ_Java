package com.flf.mapper;

import java.util.List;
import com.flf.entity.UnionpayCounterofferDetai;

public interface UnionpayCounterofferDetaiMapper {

	// 插入所有信息
	int insertUnionpayCounterofferDetai(UnionpayCounterofferDetai unionpayCounterofferDetai);

	// 通过ID查询所有
	List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiById(String unionpayCounterofferDetaiId);

	// 通过回盘总结文件id查询回盘明细
	List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiByUTId(String unionpayCounterofferTotalId);

	/**
	 * 通过id查询明细文件分页
	 * 
	 * @author chenqiuxu
	 * @date 16：49
	 * @param unionpayCounterofferDetai
	 * @return
	 */
	List<UnionpayCounterofferDetai> listPagegetUnionpayCounterofferDetai(
			UnionpayCounterofferDetai unionpayCounterofferDetai);
	
	List<UnionpayCounterofferDetai> listAllgetUnionpayCounterofferDetai(
			UnionpayCounterofferDetai unionpayCounterofferDetai);
	
	/**
	 * 修改回盘状态
	 * @param ucod
	 * @return
	 */
	int updateOfferState(UnionpayCounterofferDetai ucod);
	
	int deleteByPrimaryKey(String unionpayCounterofferDetaiId);
}
