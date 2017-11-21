package com.flf.service;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Post;
import com.flf.entity.Role;
import com.flf.entity.TcArticle;


@WebService
@Path(value = "/TcArticleService")
public interface TcArticleService {

	/**
	 * 分页查询未领取的拾取到的物品
	 * @return
	 */
	@POST
	@Path("/listPageTcArticles")
	@Produces(MediaType.APPLICATION_JSON)
	List<TcArticle> listPageTcArticles(TcArticle tcArticle);
	
	/**
	 * 查询所有的物品信息
	 * @return
	 */
	@GET
	@Path("/listAllTcArticles")
	@Produces(MediaType.APPLICATION_JSON)
	List<TcArticle> listAllTcArticles();
	
}
