package com.flf.mapper;

import java.util.List;

import com.flf.entity.UserPost;

public interface UserPostMapper {

    int deleteByPrimaryKey(String id);

    int insert(UserPost record);

    UserPost selectByPrimaryKey(String id);

    int updateByPrimaryKey(UserPost record);
    
    int countUserPosts(String postId,String userId);//根据岗位id和用户id查询员工是否在员工岗位表中存在有效关系的数量
}