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

import com.flf.entity.PageRestful;
import com.flf.entity.Post;
import com.flf.entity.TcArticleGet;
import com.flf.entity.TcArticle;
import com.flf.entity.TcArticleState;


@WebService
@Path(value = "/TcArticleStateService")
public interface TcArticleStateService {

	/**
	 * 分页查询未领取的拾取到的物品
	 * @return
	 */
	@POST
	@Path("/listPageTcArticleStates")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageTcArticleStates(TcArticleState tcArticleState);
	
	/**
	 * 查询所有的物品信息
	 * @return
	 */
	@GET
	@Path("/listAllTcArticleStates")
	@Produces(MediaType.APPLICATION_JSON)
	List<TcArticleState> listAllTcArticleStates();
	
	/**
	 * 查询所有的被领取物品信息
	 * @return
	 */
	@POST
	@Path("/listPageTcArticleGets")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageTcArticleGets(TcArticleState tcArticleState);
	
	/**
	 * 登记领取物品
	 */
	@POST
	@Path("/insertTArticleGet")
	@Produces(MediaType.APPLICATION_JSON)
	String insertTArticleGet(TcArticleGet tArticleGet);
	
	/**
	 * 登记遗失物品和拾取物品
	 */
	@POST
	@Path("/insertTArticleLost")
	@Produces(MediaType.APPLICATION_JSON)
	String insertTArticleLost(TcArticleState tcArticleState);
	
	/**
	 * 查询待领取的拾取到的物品数量和待上交的遗失物品数量
	 */
	@GET
	@Path("/listTcArticleStatesCount")
	@Produces(MediaType.APPLICATION_JSON)
	String listTcArticleStatesCount();
	
}
