package com.flf.service;
/**
 * 创建 by 肖聪 
 * 2015/6/24
 */
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.CarInfo;
import com.flf.entity.News;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.SearchNews;
@Path(value="/News")
public interface NewsService {
        
    @POST
  	@Path("/listPageNewsRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageNewsRestful(SearchNews searchNews);
    
    @POST
  	@Path("/listAllNewsRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<News> listAllNewsRestful(SearchNews searchNews);
    
    @GET
  	@Path("/getNewsByIdRestful/{newsId}")
  	@Produces(MediaType.APPLICATION_JSON)
    News getNewsByIdRestful(@PathParam("newsId") String newsId);
    
    @DELETE
   	@Path("/deleteNewsRestful/{newsId}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteNewsRestful(@PathParam("newsId") String newsId);
    
    @POST
   	@Path("/insertNewsRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertNewsRestful(News News);
    
    @PUT
   	@Path("/updateNewsRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateNewsRestful(News News);
    
    
    
    
}
