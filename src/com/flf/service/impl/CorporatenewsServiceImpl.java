package com.flf.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.flf.entity.Corporatenews;
import com.flf.entity.PageRestful;
import com.flf.entity.Rules;
import com.flf.mapper.CorporatenewsMapper;
import com.flf.service.CorporatenewsService;

public class CorporatenewsServiceImpl implements CorporatenewsService {
	private CorporatenewsMapper corporatenewsMapper;

	public CorporatenewsMapper getCorporatenewsMapper() {
		return corporatenewsMapper;
	}

	public void setCorporatenewsMapper(CorporatenewsMapper corporatenewsMapper) {
		this.corporatenewsMapper = corporatenewsMapper;
	}

	@Override
	public List<Corporatenews> listAllCorporatenews() {
		// TODO Auto-generated method stub
		return corporatenewsMapper.listAllCorporatenews();
	}

	@Override
	public Corporatenews getCorporatenewsByIdRest(String id) {
		// TODO Auto-generated method stub
		return corporatenewsMapper.getCorporatenewsbyId(id);
	}

	@Override
	public void AddCorporatenews(Corporatenews corporatenews) {
		// TODO Auto-generated method stub
		Date date = new Date();
		corporatenews.setCreationTime(date);
		corporatenews.setLastModificationTime(date);
		corporatenewsMapper.insertCorporatenews(corporatenews);
	}

	@Override
	public void UpdateCorporatenews(Corporatenews corporatenews) {
		// TODO Auto-generated method stub
		corporatenewsMapper.updateCorporatenews(corporatenews);
	}

	@Override
	public void DeleteCorporatenewsById(String id) {
		// TODO Auto-generated method stub
		corporatenewsMapper.deleteCorporatenews(id);
	}

	@Override
	public List<Corporatenews> listPageCorporatenews(Corporatenews corporatenews) {
		// TODO Auto-generated method stub
		return corporatenewsMapper.listPageCorporatenews(corporatenews);
	}

	@Override
	public int updateCorporatenews(Corporatenews corporatenews) {
		// TODO Auto-generated method stub	
		return corporatenewsMapper.updateCorporatenews(corporatenews);
	}

	@Override
	public int insertcorporatenews(Corporatenews corporatenews) {
		// TODO Auto-generated method stub
		return corporatenewsMapper.insertCorporatenews(corporatenews);
	}

	@Override
	public int deleteCorporatenews(String id) {
		// TODO Auto-generated method stub
		return corporatenewsMapper.deleteCorporatenews(id);
	}

	/*
	  * <p>Title: listPageCorporatenewsRestful</p>
	  * <p>Description: </p>
	  * @param corporatenews
	  * @return
	  * @see com.flf.service.CorporatenewsService#listPageCorporatenewsRestful(com.flf.entity.Corporatenews)
	  */
	
	
	@Override
	public PageRestful listPageCorporatenewsRestful(Corporatenews corporatenews) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Corporatenews> corporatenewss = corporatenewsMapper.listPageCorporatenewsRestful(corporatenews);
		corporatenewss.add(0,null);
		pageRestful.setCorporatenewss(corporatenewss);
		pageRestful.setPage(corporatenews.getPage());
		return pageRestful;
	}

	@Override
	public List<Corporatenews> listAllsCorporatenews() {
		// TODO Auto-generated method stub
		return corporatenewsMapper.listAllsCorporatenews();
	}

	@Override
	public List<Corporatenews> listAllsCorporatenewsByUserId(String userId) {
		// TODO Auto-generated method stub
		return corporatenewsMapper.listAllsCorporatenewsByUserId(userId);
	}

}
