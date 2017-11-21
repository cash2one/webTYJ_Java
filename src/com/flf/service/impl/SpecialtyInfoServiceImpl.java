package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import com.flf.entity.PageRestful;
import com.flf.entity.Post;
import com.flf.entity.Prepare;
import com.flf.entity.SpecialtyInfo;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.request.SpecialtyInfoResult;
import com.flf.service.SpecialtyInfoService;


public class SpecialtyInfoServiceImpl implements SpecialtyInfoService{
	
	private SpecialtyInfoMapper specialtyInfoMapper;
	
	private PrepareMapper prepareMapper;
	private PostMapper postMapper;
	


	public PostMapper getPostMapper() {
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public PrepareMapper getPrepareMapper() {
		return prepareMapper;
	}

	public void setPrepareMapper(PrepareMapper prepareMapper) {
		this.prepareMapper = prepareMapper;
	}

	public SpecialtyInfoMapper getSpecialtyInfoMapper() {
		return specialtyInfoMapper;
	}

	public void setSpecialtyInfoMapper(SpecialtyInfoMapper specialtyInfoMapper) {
		this.specialtyInfoMapper = specialtyInfoMapper;
	}

	@Override
	public List<SpecialtyInfo> listAllSpecialtyInfo() {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.listAllSpecialtyInfo();
	}

	@Override
	public List<SpecialtyInfo> listPageSpecialtyInfo(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.listPageSpecialtyInfo(specialtyInfo);
	}

	@Override
	public SpecialtyInfo getSpecialtyInfoById(String specialtyId) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.getSpecialtyInfoById(specialtyId);
	}

	@Override
	public int insertSpecialtyInfo(SpecialtyInfo SpecialtyInfo) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.insertSpecialtyInfo(SpecialtyInfo);
	}

	@Override
	public int updateSpecialtyInfo(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.updateSpecialtyInfo( specialtyInfo);
	}

	@Override
	public PageRestful listPageSpecialtyInfoRestful(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<SpecialtyInfo> specialtyInfos =specialtyInfoMapper.listPageSpecialtyInfo(specialtyInfo);
		specialtyInfos.add(0,null);
		pagerestful.setSpecialtyInfos(specialtyInfos);
		pagerestful.setPage(specialtyInfo.getPage());
		return pagerestful;
	}
	
	@Override
	public List<SpecialtyInfo> listAllSpecialtyInfoRestfulList() {
		return specialtyInfoMapper.listAllSpecialtyInfoList();
	}

	@Override
	public List<SpecialtyInfo> listAllSpecialtyInfoRestful() {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.listAllSpecialtyInfo();
	}

	@Override
	public SpecialtyInfo getSpecialtyInfoByIdRestful(String specialtyId) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.getSpecialtyInfoById(specialtyId);
	}

	@Override
	public void deleteSpecialtyInfoRestful(String specialtyId) {
		// TODO Auto-generated method stub
		specialtyInfoMapper.deleteSpecialtyInfo(specialtyId);
	}

	@Override
	public void insertSpecialtyInfoRestful(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		specialtyInfoMapper.insertSpecialtyInfo(specialtyInfo);
	}

	@Override
	public void updateSpecialtyInfoRestful(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		specialtyInfoMapper.updateSpecialtyInfo( specialtyInfo);
	}

	
	/**
	 * 根据项目id查询专业线信息
	 */
	
	@Override
	public List<SpecialtyInfo> getPreparebyprojectId(String projectId) {
		// TODO Auto-generated method stub
		List<Prepare> prepares=prepareMapper.getPreparebyprojectId(projectId);
		List<SpecialtyInfo> SpecialtyInfos=new ArrayList<SpecialtyInfo>();
		for (Prepare prepare : prepares) {
			SpecialtyInfo specialtyInfo=specialtyInfoMapper.getSpecialtyInfoById(prepare.getPostId());
			SpecialtyInfos.add(specialtyInfo);
		}
		return SpecialtyInfos;
	}

	/**
	 * 开启专业线
	 */
	
	@Override
	public void updateSpecialtyInfobystate(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		specialtyInfoMapper.updateSpecialtyInfobystate(specialtyInfo);
	}  
	
	@Override
	public void updateListSpecialtyInfo(SpecialtyInfoResult specialtyInfoResult) {
		// TODO 自动生成的方法存根
		for (SpecialtyInfo specialtyInfo : specialtyInfoResult.getSpecialtyInfos()) {
			specialtyInfoMapper.updateSpecialtyInfo(specialtyInfo);
		}
	}
	@Override
	public void updateListSpecialtyInfoTest(SpecialtyInfo specialtyInfo) {
		// TODO 自动生成的方法存根
			specialtyInfoMapper.updateSpecialtyInfo(specialtyInfo);
			List<Post> listPost=postMapper.getPostBySpecialtyId(specialtyInfo.getSpecialtyId());
			for(Post posts:listPost){
				if(specialtyInfo.getState()==1){
					posts.setState(Byte.valueOf("1"));
				}else{
					posts.setState(Byte.valueOf("0"));
				}
				postMapper.updatePostByState(posts);
			}
	}
	
	
	@Override
	public List<SpecialtyInfo> listAllSpecialtyInfoAndPostRestful() {
		// TODO 自动生成的方法存根
		return specialtyInfoMapper.listAllSpecialtyInfoAndPostRestful(); 
	}

	@Override
	public List<SpecialtyInfo> listAllSpecialtyInfoAndPostOpen() {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.listAllSpecialtyInfoAndPostOpen();
	}

	@Override
	public List<SpecialtyInfo> listSpecialtyInfoByCompanyId(String companyId,
			String specialtyId) {
	return specialtyInfoMapper.listSpecialtyInfoByCompanyId(companyId,specialtyId);
	}
	
	@Override
	public SpecialtyInfo getSpecialtyInfoByName(String specialtyName){
		return specialtyInfoMapper.getSpecialtyInfoByName(specialtyName);
	}
}
