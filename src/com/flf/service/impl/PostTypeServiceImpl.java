package com.flf.service.impl;

import java.util.List;

import com.flf.entity.PostType;
import com.flf.mapper.PostTypeMapper;
import com.flf.service.PostTypeService;

public class PostTypeServiceImpl implements PostTypeService {

	private PostTypeMapper postTypeMapper;
	
	public PostTypeMapper getPostTypeMapper() {
		return postTypeMapper;
	}

	public void setPostTypeMapper(PostTypeMapper postTypeMapper) {
		this.postTypeMapper = postTypeMapper;
	}

	@Override
	public List<PostType> listPageuser() {
		List<PostType> l=postTypeMapper.ListPostTypeAll();
		return l;
	}

	@Override
	public PostType getPostTypeByIdRest(Integer id) {
		// TODO Auto-generated method stub
		return postTypeMapper.selectPostTypeById(id);
	}

	@Override
	public void AddPostType(PostType postType) {
		// TODO Auto-generated method stub
		postTypeMapper.addPostType(postType);

	}

	@Override
	public void UpdatePostType(PostType postType) {
		// TODO Auto-generated method stub
		postTypeMapper.updatePostTypeById(postType);

	}

	@Override
	public void DeletePostTypeById(Integer id) {
		// TODO Auto-generated method stub
		postTypeMapper.deletePostTypeById(id);

	}

	@Override
	public List<PostType> listPostTypeDivisionbyId(int id) {
		// TODO Auto-generated method stub
		return postTypeMapper.listPostTypeDivisionbyId(id);
	}

}
