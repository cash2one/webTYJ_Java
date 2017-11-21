package com.flf.service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.GiftArticle;
@Path("/GiftArticle")
public interface GiftArticleService {
	
	
	
	/**
	 * 根据礼包id查询物品信息
	 * @param giftArticle
	 */
	@GET
   	@Path("/getGiftArticlebyGiftId/{giftId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<GiftArticle> getGiftArticlebyGiftId(@PathParam("giftId") String giftId);
	

	 /**
	 * 物品礼包新增绑定
	 * @param giftArticle
	 */
	@POST
   	@Path("/insertGiftArticle")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void insertContractRest(GiftArticle giftArticle);
	
	/**
	 * 礼包信息修改
	 * @param giftArticle
	 */
	@PUT
   	@Path("/updateGiftArticle")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void updateContractRest(GiftArticle giftArticle);
}
