package com.flf.mapper;

import java.util.List;

import com.flf.entity.FinancialStaff;

/**
 * 财务人员表
 * @author taoyongchao
 * 2015-10-9
 */
public interface FinancialStaffMapper {
	
	FinancialStaff getFinancialStaffbyId(String financialStaffId);//通过Id查询财务人员表信息

	FinancialStaff selectById(String financialStaffId);//根据id查询上级人员信息(出纳)
	
	FinancialStaff selectAllsById(String financialStaffId);//查询上级id(收银员)
	
	FinancialStaff selectCashierById(String financialStaffId);//根据id查询上级人员信息(收银组长)
	
	/**
	 * 通过员工id和岗位id查询
	 * @author chenqiuxu
	 * @param financialStaff
	 * @return
	 */
	FinancialStaff selectAllsByStaffId(FinancialStaff financialStaff);

	
	/**
	 * 插入财务人员表数据
	 * @author 王洲
	 * 2016.04.20
	 * @param financialStaff
	 * @return
	 */
	int insertFinancialStaff(FinancialStaff financialStaff);
	
	/**
	 * 修改财务人员表数据
	 * @author wangzhou
	 * 2016.04.20
	 * @param financialStaff
	 * @return
	 */
	int updateFinancialStaff(FinancialStaff financialStaff);
	
	/**
	 * 根据id删除数据
	 * @author wangzhou
	 * 2016.04.20
	 * @param financialStaffId
	 * @return
	 */
	int deleteFinancialStaffById(String financialStaffId);
	
	/**
	 * 根据员工id和上级id删除数据
	 * @author wangzhou
	 * 2016.04.20
	 * @param staffId
	 * @param parentId
	 * @return
	 */
	int deleteFinancialStaffByStaffIdAndParentId(String staffId, String parentId);
	
	/**
	 * 根据parentId删除所有下级
	 * @author wangzhou
	 * @param parentId
	 * @return
	 */
	int deleteFinancialStaffByParentId(String parentId);
	
	/**
	 * 批量新增数据
	 * @author wangzhou
	 * @param list
	 * @return
	 */
	int insertFinancialStaffList(List<FinancialStaff> list);
	
	/**
	 * 根据主键集合批量删除
	 * @author wangzhou
	 * 2016.04.20
	 * @param list
	 * @return
	 */
	int deleteByIdList(List<String> list);
	
	
	/**
	 * 查询所有数据
	 * @author wangzhou
	 * 2016.04.20
	 * @return
	 */
	List<FinancialStaff> selectFinancialStaffList(FinancialStaff financialStaff);
	
	/**
	 * 根据parentId查询关联的所有下级
	 * @author wangzhou
	 * @param parentId
	 * @return
	 */
	List<FinancialStaff> listFinancialStaffByParentId(String parentId);
	
	
	/**
	 * 通过员工id
	 * @param staffId
	 * @return
	 */
	List<FinancialStaff> getFinancialStaffbyStaffId(String staffId);

}
