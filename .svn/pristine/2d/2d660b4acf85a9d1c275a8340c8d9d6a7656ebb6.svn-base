package com.flf.service.impl;

import java.util.List;



import com.flf.entity.PageRestful;
import com.flf.entity.News;
import com.flf.entity.SearchNews;
import com.flf.mapper.NewsMapper;
import com.flf.service.NewsService;


public class NewsServiceImpl implements NewsService{
	
	private NewsMapper newsMapper;

	

	public NewsMapper getNewsMapper() {
		return newsMapper;
	}

	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}

	@Override
	public PageRestful listPageNewsRestful(SearchNews searchNews) {
		// TODO Auto-generated method stub
		News news = new News();
		PageRestful pagerestful=new PageRestful();
		List<News> newss =newsMapper.listPageNews(searchNews);
		newss.add(0,null);
		pagerestful.setNewss(newss);
		pagerestful.setPage(news.getPage());
		return pagerestful;
	}
	
	@Override
	public List<News> listAllNewsRestful(SearchNews searchNews) {
		// TODO Auto-generated method stub
		return newsMapper.listAllNews(searchNews);
	}

	@Override
	public News getNewsByIdRestful(String id) {
		// TODO Auto-generated method stub
		return newsMapper.getNewsById(id);
	}

	@Override
	public void deleteNewsRestful(String id) {
		// TODO Auto-generated method stub
		newsMapper.deleteNews(id);
	}

	@Override
	public void insertNewsRestful(News News) {
		// TODO Auto-generated method stub
		newsMapper.insertNews(News);
	}

	@Override
	public void updateNewsRestful(News News) {
		// TODO Auto-generated method stub
		newsMapper.updateNews( News);
	}  
}

