package com.flf.service.impl;

import java.util.Date;
import java.util.List;

import com.flf.entity.Communtitnotice;

import com.flf.entity.PageRestful;

import com.flf.mapper.CommuntitnoticeMapper;

import com.flf.service.CommuntitnoticeService;


public class CommuntitnoticeServiceImpl implements CommuntitnoticeService {
	
	private CommuntitnoticeMapper communtitnoticeMapper;
	

	public CommuntitnoticeMapper getCommuntitnoticeMapper() {
		return communtitnoticeMapper;
	}

	public void setCommuntitnoticeMapper(CommuntitnoticeMapper communtitnoticeMapper) {
		this.communtitnoticeMapper = communtitnoticeMapper;
	}

	@Override
	public List<Communtitnotice> listAllCommuntitnotice() {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.listAllCommuntitnotice();
	}
	
	@Override
	public List<Communtitnotice> listAllsCommuntitnotice() {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.listAllsCommuntitnotice();
	}

	@Override
	public Communtitnotice getCommuntitnoticeByIdRest(String id) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.getCommuntitnoticebyId(id);
	}

	@Override
	public void AddCommuntitnotice(Communtitnotice communtitnotice) {
		// TODO Auto-generated method stub
		communtitnotice.setCreationTime(new Date());
		communtitnoticeMapper.insertCommuntitnotice(communtitnotice);
	}

	@Override
	public void UpdateCommuntitnotice(Communtitnotice communtitnotice) {
		// TODO Auto-generated method stub
		communtitnotice.setCreationTime(new Date());
		communtitnoticeMapper.updateCommuntitnotice(communtitnotice);
	}

	@Override
	public void DeleteCommuntitnoticeById(String id) {
		// TODO Auto-generated method stub
		communtitnoticeMapper.deleteCommuntitnotice(id);
	}
	
	
	
	
	
	

	@Override
	public int deleteCommuntitnotice(String id) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.deleteCommuntitnotice(id);
	}

	@Override
	public int insertCommuntitnotice(Communtitnotice communtitnotice) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.insertCommuntitnotice(communtitnotice);
	}

	

	@Override
	public int updateCommuntitnotice(Communtitnotice communtitnotice) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.updateCommuntitnotice(communtitnotice);
	}

	@Override
	public List<Communtitnotice> listPageCommuntitnotice(
			Communtitnotice communtitnotice) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.listAllCommuntitnotice();
	}

	/*
	  * <p>Title: listPageCommuntitnoticeRestful</p>
	  * <p>Description: </p>
	  * @param communtitnotice
	  * @return
	  * @see com.flf.service.CommuntitnoticeService#listPageCommuntitnoticeRestful(com.flf.entity.Communtitnotice)
	  */
	
	
	@Override
	public PageRestful listPageCommuntitnoticeRestful(Communtitnotice communtitnotice) {
		
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Communtitnotice> communtitnotices = communtitnoticeMapper.listPageCommuntitnoticeRestful(communtitnotice);
		communtitnotices.add(0,null);
		pageRestful.setCommuntitnotices(communtitnotices);
		pageRestful.setPage(communtitnotice.getPage());
		return pageRestful;
	}

	@Override
	public List<Communtitnotice> listAllsCommuntitnoticeByUserId(String userId) {
		// TODO Auto-generated method stub
		return communtitnoticeMapper.listAllsCommuntitnoticeByUserId(userId);
	}

}
