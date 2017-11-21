package com.flf.mapper;

import java.util.List;

import com.flf.entity.PostAuthority;

public interface PostAuthorityMapper {
    int deleteByPrimaryKey(String postAuthorityId);

    int insert(PostAuthority record);

    int insertSelective(PostAuthority record);

    PostAuthority selectByPrimaryKey(String postAuthorityId);

    int updateByPrimaryKeySelective(PostAuthority record);

    int updateByPrimaryKey(PostAuthority record);
    
    List<PostAuthority> selectActionPermissions(String postId);
    //根据用户id获取岗位权限信息
    List<PostAuthority> getPostAuthorityByUserId(String userId);
}