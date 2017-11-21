package com.flf.mapper;

import java.util.List;

import com.flf.entity.Friends;

public interface FriendsMapper {
    int deleteByPrimaryKey(String friendsId);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(String friendsId);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
    
    List<Friends> selectByFriends(Friends record);
    
    List<Friends> selectByPrimaryId(Friends friends);
}