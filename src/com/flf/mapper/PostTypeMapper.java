package com.flf.mapper;

import java.util.List;

import com.flf.entity.Post;
import com.flf.entity.PostType;

public interface PostTypeMapper {//岗位类型表
	 
	List<PostType>  ListPostTypeAll();//查询所有岗位类型
	
	PostType  selectPostTypeById(int id);//通过Id查询岗位类型
	
	int updatePostTypeById(PostType postType);//修改岗位类型
	
	int addPostType(PostType postType);//添加岗位类型
	
	int deletePostTypeById(int id);//删除岗位类型
	
	List<PostType>  listPostTypeDivisionbyId(int id); //根据部门id查询岗位类型列表

}
