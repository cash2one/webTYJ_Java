package com.flf.mapper;

import com.flf.entity.Communtitnotice;
import java.util.List;

public interface CommuntitnoticeMapper {
	
	int deleteCommuntitnotice(String id);

    int insertCommuntitnotice(Communtitnotice communtitnotice);

   /* List<Communtitnotice> listPageCommuntitnotice(Communtitnotice Communtitnotice);*/
    
    List<Communtitnotice> listAllCommuntitnotice();
    
    List<Communtitnotice> listAllsCommuntitnotice();
    
    List<Communtitnotice> listAllsCommuntitnoticeByUserId(String userId);//根据登陆的userId查询相关的小区公告

    Communtitnotice getCommuntitnoticebyId(String id);

    int updateCommuntitnotice(Communtitnotice communtitnotice);	
	
	List<Communtitnotice> listPageCommuntitnoticeRestful(Communtitnotice communtitnotice);//分页查询小区公告信息
}
