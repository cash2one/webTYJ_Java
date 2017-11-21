package com.flf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.flf.entity.PageRestful;
import com.flf.entity.TcArticleGet;
import com.flf.entity.TcArticle;
import com.flf.entity.TcArticleState;
import com.flf.mapper.TcArticleGetMapper;
import com.flf.mapper.TcArticleMapper;
import com.flf.mapper.TcArticleStateMapper;
import com.flf.service.TcArticleStateService;

public class TcArticleServiceStateImpl implements TcArticleStateService{
	
    private TcArticleStateMapper tcArticleStateMapper;
    
    private TcArticleGetMapper tcArticleGetMapper;
	
	private TcArticleMapper tcArticleMapper;
	


	public TcArticleStateMapper getTcArticleStateMapper() {
		return tcArticleStateMapper;
	}

	public void setTcArticleStateMapper(TcArticleStateMapper tcArticleStateMapper) {
		this.tcArticleStateMapper = tcArticleStateMapper;
	}

	

	public TcArticleGetMapper getTcArticleGetMapper() {
		return tcArticleGetMapper;
	}

	public void setTcArticleGetMapper(TcArticleGetMapper tcArticleGetMapper) {
		this.tcArticleGetMapper = tcArticleGetMapper;
	}

	public TcArticleMapper getTcArticleMapper() {
		return tcArticleMapper;
	}

	public void setTcArticleMapper(TcArticleMapper tcArticleMapper) {
		this.tcArticleMapper = tcArticleMapper;
	}

	@Override
	public PageRestful listPageTcArticleStates(TcArticleState tcArticleState) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<TcArticleState> tcArticleStates =tcArticleStateMapper.listPageTcArticleStates(tcArticleState);
		tcArticleStates.add(0,null);
		pagerestful.setTcArticleStates(tcArticleStates);
		pagerestful.setPage(tcArticleState.getPage());
		return pagerestful;
		
	}

	@Override
	public List<TcArticleState> listAllTcArticleStates() {
		// TODO Auto-generated method stub
		return tcArticleStateMapper.listAllTcArticleStates();
	}

	@Override
	public PageRestful listPageTcArticleGets(TcArticleState tcArticleState) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<TcArticleState> tcArticleStates =tcArticleStateMapper.listPageTcArticleGets(tcArticleState);
		tcArticleStates.add(0,null);
		pagerestful.setTcArticleStates(tcArticleStates);
		pagerestful.setPage(tcArticleState.getPage());
		return pagerestful;
	}

	@Override
	public String insertTArticleGet(TcArticleGet tArticleGet) {
		// TODO Auto-generated method stub
		String articleGetId=UUID.randomUUID().toString();
		tArticleGet.setArticleGetId(articleGetId);
		tcArticleGetMapper.insert(tArticleGet);
		tcArticleStateMapper.updataState(tArticleGet.getArticleStateId());
		return "200";
	}

	@Override
	public String insertTArticleLost(TcArticleState tcArticleState) {
		// TODO Auto-generated method stub
		String articleId=UUID.randomUUID().toString();
		String articleStateId=UUID.randomUUID().toString();
		tcArticleState.setArticleStateId(articleStateId);
		tcArticleState.setArticleId(articleId);
		tcArticleStateMapper.insert(tcArticleState);
		TcArticle tcArticle=tcArticleState.getArticle();
		tcArticle.setArticleId(articleId);
		//tcArticle.setState(1);
		tcArticleMapper.insert(tcArticle);
		return "200";
	}

	@Override
	public String listTcArticleStatesCount() {
		Map<String,Integer> data = new HashMap<String, Integer>();
		data.put("lostPick",tcArticleStateMapper.listCounts(0));
		data.put("lostWait",tcArticleStateMapper.listCounts(1));
		return JSONObject.fromObject(data).toString();
	}


}
