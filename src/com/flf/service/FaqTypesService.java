package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.FaqTypes;

/**
 * 问题类型FaqTypes接口
 * @author wangzhou
 *
 */
@WebService
@Path("/FaqTypes")
public interface FaqTypesService {

	/**
	 * 查询问题类型
	 * @param faqTypes
	 * @return
	 */
	@POST
	@Path("/listFaqTypes")
	@Produces(MediaType.APPLICATION_JSON)
	List<FaqTypes> listFaqTypes(FaqTypes faqTypes);
	
	/**
	 * 新增问题类型
	 * @param faqTypes
	 * @return
	 */
	@POST
	@Path("/insertFaqTypes")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	int insertFaqTypes(FaqTypes faqTypes);
	
	/**
	 * 修改问题类型
	 * @param faqTypes
	 */
	@POST
	@Path("/updateFaqTypes")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateFaqTypes(FaqTypes faqTypes);
	
	/**
	 * 根据问题类型id删除问题类型
	 * @param faqTypeId
	 * @return
	 */
	@DELETE
	@Path("/deleteFaqTypes/{faqTypeId}")
	int deleteFaqTypes(@PathParam("faqTypeId") String faqTypeId);
	
	/**
	 * 根据问题类型名称查询此名称是否存在，全匹配
	 * @param faqTypeName
	 * @return
	 */
	@GET
	@Path("/getFaqTypesByName/{faqTypeName}")
	@Produces(MediaType.APPLICATION_JSON)
	int getFaqTypesByName(@PathParam("faqTypeName") String faqTypeName);
}
