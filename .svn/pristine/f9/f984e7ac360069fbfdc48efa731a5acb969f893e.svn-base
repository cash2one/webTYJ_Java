package com.flf.mapper;

import java.util.List;

import com.flf.entity.SubCompany;

/**
 * 子公司mapper层
 * @author Fansensen
 *
 */
public interface SubCompanyMapper {

	int insertSubCompany(SubCompany subCompany);//添加子公司
	int deleteSubCompany(String subCompanyId);//删除子公司
	int updateSubCompany(SubCompany subCompany);//修改子公司
	SubCompany getSubCompanyById(String subCompany);//根据id查询子公司
	List<SubCompany> getSubCompanyByName();//根据子公司名称模糊查询子公司信息
	
	/* 查询所有的子公司信息,可根据子公司名称模糊查询子公司信息   */
	List<SubCompany> listPageAllSubCompanys(SubCompany subCompany);
	
	List<SubCompany> getAllSubCompany();//查询所有的数据
	
	List<SubCompany> getAllSubCompanyData(String subCompanyId);
	
	List<SubCompany> getSubCompanyByCompanyId(String companyId);//查询公司下所有的子公司
}
