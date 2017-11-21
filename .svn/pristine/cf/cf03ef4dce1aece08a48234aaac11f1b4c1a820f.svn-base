/**
 * @Title: EnterpriseCustNewNewMapper.java
 * @Package com.flf.mapper
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-25 下午1:04:39
 * @version V1.0
 */

package com.flf.mapper;

import java.util.List;


import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.entity.SearchPersonAndEnterprise;

/**
 * @ClassName: EnterpriseCustNewNewMapper
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-25 下午1:04:39
 *
 */

public interface EnterpriseCustNewMapper {
	/*
	 *  企业客户表
	 */
    List<EnterpriseCustNew> listPageEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew);//分页查询显示所有企业客户信息
    List<EnterpriseCustNew> listAllEnterpriseCustNew(); //查询所有企业客户信息
    EnterpriseCustNew getEnterpriseCustNewById(String enterpriseId);//根据id查询企业客户信息
    int insertEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew); //添加企业客户信息
    
    int insertEnterpriseCustNewUUID(EnterpriseCustNew enterpriseCustNew); //不自动生成主键添加企业客户信息
    int updateEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew); //修改企业客户信息
    int deleteEnterpriseCustNew(String enterpriseId); //删除企业客户信息
    
    List<EnterpriseCustNew> findEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew); //根据条件查询企业客户信息
    
	List<EnterpriseCustNew> getenterpriseCustNewByHouseId(String houseId);//根据房屋id查询公司信息
	
	List<EnterpriseCustNew> getenterpriseCustNewByStallNewId(String stallId);//根据车位id查询公司信息
	
	List<EnterpriseCustNew> getSearchEnterprise(SearchPersonAndEnterprise searchPersonAndEnterprise);
	List<PersonCustNew> listSearchEnterprise(Search search);//根据条件搜索公司信息
	
	List<EnterpriseCustNew> listEnterpriseCustNewByCondition(EnterpriseCustNew enterpriseCustNew);//根据条件查询企业客户的相关信息
	List<EnterpriseCustNew> listPageEnterpriseCustNewByCondition(EnterpriseCustNew enterpriseCustNew);//根据条件查询企业客户的相关信息
	
	String selectCustCode();
	
	List<EnterpriseCustNew> selectEnterpriseCust(String buildingStructureId);//根据建筑结构id查询有效企业客户业主的信息
	List<EnterpriseCustNew> listEnterpriseCustNewListByCondition(EnterpriseCustNew enterpriseCustNew);//导出用
	
	/**
	 * 根据企业名称和企业证件号查企业客户主键id
	 * @author xiaocong
	 * @date 上午10:16:35
	 * @Description:TODO
	 * @return
	 * @updateby
	 */
	String getEnterpriseId(String tradingNumber,String name);
}
