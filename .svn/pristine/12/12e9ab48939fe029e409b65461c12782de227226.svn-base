package com.flf.service.impl;

import java.util.List;

import com.flf.entity.PostAuthority;
import com.flf.mapper.PostAuthorityMapper;
import com.flf.service.PostAuthorityService;

public class PostAuthorityServiceImpl implements PostAuthorityService{
	
	private PostAuthorityMapper postAuthorityMapper;

	public PostAuthorityMapper getPostAuthorityMapper() {
		return postAuthorityMapper;
	}

	public void setPostAuthorityMapper(PostAuthorityMapper postAuthorityMapper) {
		this.postAuthorityMapper = postAuthorityMapper;
	}

	@Override
	public List<PostAuthority> selectActionPermissions(String postId) {
		// TODO Auto-generated method stub
		return postAuthorityMapper.selectActionPermissions(postId);
	}

	@Override
	public List<PostAuthority> getPostAuthorityByUserId(String userId) {
		return postAuthorityMapper.getPostAuthorityByUserId(userId);
	}
}
