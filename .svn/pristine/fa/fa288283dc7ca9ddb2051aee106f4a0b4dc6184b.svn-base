package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Faq;
import com.flf.entity.PageRestful;

@WebService
@Path("/Faq")
public interface FaqService {

    
	
	@POST
	@Path("/listPageFAQ")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageFAQ(Faq faq);
	
	@GET
	@Path("/listAllFAQ")
	@Produces(MediaType.APPLICATION_JSON)
	List<Faq> listAllFAQ();
	
	@GET
	@Path("/getFAQById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Faq getFAQById(@PathParam("id") String id);
	
	@POST
	@Path("/insertFAQ")
	@Consumes( MediaType.APPLICATION_JSON)
	public void insertFAQ(Faq faq);
	
	@PUT
	@Path("/updateFAQ")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateFAQ(Faq faq);
	
	@PUT
	@Path("/deleteFAQ/{id}")
	public void deleteFAQ(@PathParam("id") String id);

	
	}
