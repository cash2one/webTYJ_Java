/**
 * @Title: AuthorizationServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-20 下午4:10:27
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.Authorization;
import com.flf.entity.AuthorizationProject;
import com.flf.entity.AuthorizationProjectType;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.mapper.AuthorizationMapper;
import com.flf.mapper.AuthorizationProjectMapper;
import com.flf.mapper.AuthorizationProjectTypeMapper;
import com.flf.service.AuthorizationService;

/**
 * @ClassName: AuthorizationServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-20 下午4:10:27
 *
 */

public class AuthorizationServiceImpl implements AuthorizationService {

	private AuthorizationMapper authorizationMapper;
	
	private AuthorizationProjectMapper authorizationProjectMapper;
	
	private AuthorizationProjectTypeMapper authorizationProjectTypeMapper;
	
	/*
	 * <p>Title: listAllAuthorization</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.AuthorizationService#listAllAuthorization()
	 */

	public AuthorizationProjectTypeMapper getAuthorizationProjectTypeMapper() {
		return authorizationProjectTypeMapper;
	}

	public void setAuthorizationProjectTypeMapper(
			AuthorizationProjectTypeMapper authorizationProjectTypeMapper) {
		this.authorizationProjectTypeMapper = authorizationProjectTypeMapper;
	}

	public AuthorizationProjectMapper getAuthorizationProjectMapper() {
		return authorizationProjectMapper;
	}

	public void setAuthorizationProjectMapper(
			AuthorizationProjectMapper authorizationProjectMapper) {
		this.authorizationProjectMapper = authorizationProjectMapper;
	}

	public AuthorizationMapper getAuthorizationMapper() {
		return authorizationMapper;
	}

	public void setAuthorizationMapper(AuthorizationMapper authorizationMapper) {
		this.authorizationMapper = authorizationMapper;
	}

	@Override
	public List<Authorization> listAllAuthorization() {
		// TODO Auto-generated method stub
		return authorizationMapper.listAuthorization();
	}

	/*
	 * <p>Title: getAuthorizationbyId</p>
	 * <p>Description: </p>
	 * @param authorizationId
	 * @return
	 * @see com.flf.service.AuthorizationService#getAuthorizationbyId(java.lang.Integer)
	 */

	@Override
	public Authorization getAuthorizationbyId(String authorizationId) {
		// TODO Auto-generated method stub
		return authorizationMapper.selectByauthorizationId(authorizationId);
	}
	/*
	 * <p>Title: getAuthorizationbyId</p>
	 * <p>Description: </p>
	 * @param authorizedPersonid
	 * @return
	 * @see com.flf.service.AuthorizationService#getAuthorizationbyId(java.lang.Integer)
	 */
	@Override
	public List<Authorization> getAuthorizedbyId(String authorizedPersonid) {
		// TODO Auto-generated method stub
		return authorizationMapper.selectByauthorizedId(authorizedPersonid);
	}

	/*
	 * <p>Title: AddAuthorization</p>
	 * <p>Description: </p>
	 * @param authorization
	 * @see com.flf.service.AuthorizationService#AddAuthorization(com.flf.entity.Authorization)
	 */

	@Override
	public void AddAuthorization(Authorization authorization) {
		// TODO Auto-generated method stub
		authorizationMapper.insert(authorization);
	}

	/*
	 * <p>Title: UpdateAuthorizationbyId</p>
	 * <p>Description: </p>
	 * @param authorization
	 * @see com.flf.service.AuthorizationService#UpdateAuthorizationbyId(com.flf.entity.Authorization)
	 */

	@Override
	public void UpdateAuthorizationbyId(Authorization authorization) {
		// TODO Auto-generated method stub
		authorizationMapper.updateByPrimaryKey(authorization);
	}

	/*
	 * <p>Title: DeleteAuthorizationbyId</p>
	 * <p>Description: </p>
	 * @param authorizationId
	 * @see com.flf.service.AuthorizationService#DeleteAuthorizationbyId(java.lang.Integer)
	 */

	@Override
	public void DeleteAuthorizationbyId(String authorizationId) {
		// TODO Auto-generated method stub
		authorizationMapper.deleteByPrimaryKey(authorizationId);

	}

	@Override
	public List<Authorization> getAuthorizedbyIdLease(String authorizedPersonid) {
		// TODO Auto-generated method stub
		return authorizationMapper.selectByauthorizedIdlease(authorizedPersonid);
	}

	@Override
	public List<Authorization> getAuthorizedbyIdLeaseAndHouse(String authorizedPersonid) {
		// TODO Auto-generated method stub
		return authorizationMapper.listAuthorizationAndHouse(authorizedPersonid);
	}
	/**
	 * 创建 by 肖聪   2015/6/4
	 * 通过被授权人查询授权的车位
	 * @param authorizedPersonid
	 * @return
	 */
	@Override
	public List<Authorization> getAuthorizedbyIdLeaseAndStall(String authorizedPersonid) {
		// TODO Auto-generated method stub
		return authorizationMapper.listAuthorizationAndStall(authorizedPersonid);
	}

	@Override
	public List<Authorization> listAllAuthorizationBySearch(Search search) {
		// TODO Auto-generated method stub
		return  authorizationMapper.listSearchAuthorization(search);
	}

	@Override
	public PageRestful listPageAuthorization(Authorization authorization) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Authorization> authorizations =authorizationMapper.listPageAuthorization(authorization);
		List<AuthorizationProjectType> authorizationProjects=authorizationProjectTypeMapper.listAllData();
		authorizations.add(0,null);
		List<AuthorizationProject> list;
		List<String> typeList;
		String flag="n";
		for(int i=1;i<authorizations.size();i++){
			typeList=new ArrayList<String>();
			list=authorizations.get(i).getAuthorizationProjects();
				for (AuthorizationProjectType authorizationProjectType : authorizationProjects) {
					flag="n";
					if(list.size()>0){
						for (AuthorizationProject authorizationProject : list) {
							if(authorizationProjectType.getAuthorizationProjectName().toString().equals(authorizationProject.getAuthorizationProjectName().toString())){
								flag="y";
								break;
							}
						}
					}
					typeList.add(flag);
				}
				authorizations.get(i).setTypeList(typeList);
		}
		pageRestful.setAuthorizations(authorizations);
		pageRestful.setPage(authorization.getPage());
		return pageRestful;
	}

	/*@Override
	public void AddAuthorizationRes(Authorization authorization) {
		// TODO Auto-generated method stub
		List<String> ids=authorization.getIds();
		List<Annex> annexs=authorization.getAnnexs();
		if(ids!=null&&ids.size()>0){
			for(String houseId:ids){
				authorization.setHouseId(houseId);
				authorization.setAuthorizedPersonid(authorization.getAuthorizedPersonid());
				authorization.setAuthorizerPersonid(authorization.getAuthorizedPersonid());
				if(annexs!=null&&annexs.size()>0){
					for(int i=0;i<annexs.size();i++){						
						authorization.setAccessoryAddress(annexs.get(i).getAnnexAddress());						
					}
				}
				authorizationMapper.insert(authorization);
			}
		}		
	}*/
	
	//新增授权
	@Override
	public void AddAuthorizationRes(Authorization authorization) {
		// TODO Auto-generated method stub
		List<String> ids=authorization.getIds();
		List<Annex> annexs=authorization.getAnnexs();
		Integer n=0;
		List<String> authorizationProjectType=authorization.getAuthorizationProjectTypes();
		if(ids!=null&&ids.size()>0){
			for(int i=0;i<ids.size();i++){
				authorization.setHouseId(ids.get(i));
				authorization.setAuthorizationId(UUID.randomUUID().toString());
				authorization.setAuthorizedPersonid(authorization.getAuthorizedPersonid());
				authorization.setAuthorizerPersonid(authorization.getAuthorizerPersonid());
				if(annexs!=null&&annexs.size()>0){
					for(int j=0;j<annexs.size();j++){						
						authorization.setAccessoryAddress(annexs.get(j).getAnnexAddress());						
					}
				}
				n=authorizationMapper.insert(authorization);
				if(n>0){
					for(int j=0;j<authorizationProjectType.size();j++){
						AuthorizationProject authorizationProject=new AuthorizationProject();
						authorizationProject.setAuthorizationId(authorization.getAuthorizationId());
						authorizationProject.setAuthorizationProjectTypeId(authorizationProjectType.get(j));
						authorizationProject.setAuthorizationProjectId(UUID.randomUUID().toString());
						authorizationProjectMapper.insert(authorizationProject);
					}
				}		
			}
		}
	}

}
