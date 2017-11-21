package com.flf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Gift;
import com.flf.entity.GiftArticle;
import com.flf.entity.PageRestful;

@Path("/Gift")
public interface GiftService {

	
	/**
	 * 分页搜索查询礼包
	 * @param GiftArticle
	 * @return
	 */
	@POST
  	@Path("/listPageGift")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    PageRestful listPageGift(Gift gift);
}
