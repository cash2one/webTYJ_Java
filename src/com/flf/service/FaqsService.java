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

import com.flf.entity.Faqs;
import com.flf.entity.PageRestful;

/**
 * 服务请求FAQ接口
 * @author wangzhou
 *
 */
@WebService
@Path("/Faqs")
public interface FaqsService {
	
	/**
	 * 根据条件分页查询FAQ
	 * @param faqs
	 * @return pageRestful
	 */
	@POST
	@Path("/listPageFaqs")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageFaqs(Faqs faqs);
	
	/**
	 * 条件分页查询所有待办faqs
	 * @param faqs
	 * @return
	 */
	@POST
	@Path("/listPageFaqsNoAnswer")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	PageRestful listPageFaqsNoAnswer(Faqs faqs);
	
	/**
	 * 新增FAQ
	 * @param faqs
	 * @return
	 */
	@POST
	@Path("/insertFaqs")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	int insertFaqs(Faqs faqs);
	
	/**
	 * 修改FAQ
	 * @param faqs
	 */
	@POST
	@Path("/updateFaqs/{operatorId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateFaqs(Faqs faqs, @PathParam("operatorId") String operatorId);
	
	/**
	 * 根据faqQuestionId删除FAQS
	 * @param faqQuestionId
	 * @return
	 */
	@DELETE
	@Path("/deleteFaqs/{faqQuestionId}")
	int deleteFaqs(@PathParam("faqQuestionId") String faqQuestionId);
	
	/**
	 * 根据传入的faqs  id集合，将对应faqs设置为失效
	 * @param faqids
	 * @return
	 */
	@POST
	@Path("/failFaqs/{faqids}/{operatorId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void failFaqs(@PathParam("faqids") String faqids, @PathParam("operatorId") String operatorId);
	
	/**
	 * 根据faqs问题名模糊查询相关问题
	 * @param faqQuestionName
	 * @return
	 */
	@POST
	@Path("/getFaqsByQuestionName/{faqQuestionName}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Faqs> getFaqsByfaqQuestionName(@PathParam("faqQuestionName") String faqQuestionName);
	
	/**
	 * 根据id查询faqs
	 * @param faqQuestionId
	 * @return
	 */
	@GET
	@Path("/getFaqsById/{faqid}")
	@Produces(MediaType.APPLICATION_JSON)
	Faqs getFaqsById(@PathParam("faqid") String faqid);
	
}
