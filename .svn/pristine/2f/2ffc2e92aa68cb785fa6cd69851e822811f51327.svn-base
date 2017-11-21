package com.flf.mapper;

import com.flf.entity.Corporatenews;
import com.flf.entity.Rules;

import java.util.List;

public interface CorporatenewsMapper {
	int deleteCorporatenews(String id);

    int insertCorporatenews(Corporatenews corporatenews);

     List<Corporatenews> listPageCorporatenews(Corporatenews corporatenews);
    
    List<Corporatenews> listAllCorporatenews();
    
    List<Corporatenews> listAllsCorporatenews();
    
    List<Corporatenews> listAllsCorporatenewsByUserId(String userId);//根据登陆的userId查询相关的项目中的企业新闻

    Corporatenews getCorporatenewsbyId(String id);

    int updateCorporatenews(Corporatenews corporatenews);
    
    List<Corporatenews> listPageCorporatenewsRestful(Corporatenews corporatenews);//分页查询企业新闻
}