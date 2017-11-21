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

import com.flf.entity.Corporatenews;
import com.flf.entity.PageRestful;
@WebService
@Path("/Corporatenews")
//企业新闻
public interface CorporatenewsService {
	/*
	 * 增删改查
	 */
	
	@POST
	@Path("/listPageCorporatenewsRestful")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageCorporatenewsRestful(Corporatenews corporatenews);
	
	@GET
	@Path("/listAllCorporatenews")
	@Produces(MediaType.APPLICATION_JSON)
	List<Corporatenews> listAllCorporatenews(); 
	
	@GET
	@Path("/listAllsCorporatenews")
	@Produces(MediaType.APPLICATION_JSON)
	List<Corporatenews> listAllsCorporatenews(); 
	
	@GET
	@Path("/listAllsCorporatenewsByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Corporatenews> listAllsCorporatenewsByUserId(@PathParam("userId") String userId); 
	
	@GET
	@Path("/listPageCorporatenews")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<Corporatenews> listPageCorporatenews(Corporatenews corporatenews); 

	@GET
	@Path("/getCorporatenewsById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Corporatenews getCorporatenewsByIdRest(@PathParam("id") String id);
	
	@POST
	@Path("/AddCorporatenews")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddCorporatenews(Corporatenews corporatenews);
	
	@PUT
	@Path("/UpdateCorporatenews")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateCorporatenews(Corporatenews corporatenews);
	
	@DELETE
	@Path("/DeleteCorporatenewsById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteCorporatenewsById(@PathParam("id") String id);
	
	int updateCorporatenews(Corporatenews corporatenews);// 后台修改

	int insertcorporatenews(Corporatenews corporatenews);// 后台新增
	
	int deleteCorporatenews(String id);
}







