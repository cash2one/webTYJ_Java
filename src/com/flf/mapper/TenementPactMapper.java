package com.flf.mapper;
/**
 * 创建 by 肖聪  
 * 2015/6/26
 */
import java.util.List;

import com.flf.entity.SearchPact;
import com.flf.entity.TenementPact;
import com.flf.request.TenementPactSearch;
public interface TenementPactMapper {
	    List<TenementPact> listAllTenementPact();
	    List<TenementPact> listPageTenementPact(TenementPact tenementPact);
	    TenementPact getTenementPactById(String pactId);
	    int deleteTenementPact(String pactId);  //删除合同
	    int insertTenementPact(TenementPact tenementPact);
	    int updateTenementPact(TenementPact tenementPact);
	    List<TenementPact> searchTenementPact(TenementPactSearch tenementPactSearch);//搜索物业合同列表
	    int updateTenementPactState(TenementPact tenementPact); //生效合同
}