/**
 * 创建 by 肖聪
 * 2015/6/24
 */
package com.flf.mapper;
import java.util.List;
import com.flf.entity.News;
import com.flf.entity.SearchNews;
public interface NewsMapper {
	    List<News>  listAllNews(SearchNews searchNews);//通过搜索新闻条件搜索新闻信息
	    
	    List<News> listPageNews(SearchNews searchNews);
	    
	    News getNewsById(String newsId);
	    
	    int deleteNews(String newsId);
	    
	    int insertNews(News News);
	    
	    int updateNews(News News);
}
