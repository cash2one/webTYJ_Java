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

import com.flf.entity.AreaTypeNew;
import com.flf.entity.PageRestful;
import com.flf.entity.TenementInsurance;

/**
 * 物业保险
 * @author shaozheng
 *	2015-8-6
 */
@WebService
@Path("/TenementInsurance")
public interface TenementInsuranceService {
	
	/**
	 * 添加物业保险
	 * @param tenementInsurance
	 * @return
	 */
	@POST
	@Path("/insertTenementInsurance")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertTenementInsurance(TenementInsurance tenementInsurance);
	
	/**
	 * 删除物业保险
	 * @param insuranceId
	 * @return
	 */
	@DELETE
	@Path("/deleteTenementInsurance/{insuranceId}")
	public void deleteTenementInsurance(@PathParam("insuranceId")String insuranceId);
	
	/**
	 * 根据保险id获取保险
	 * @param insuranceId
	 * @return
	 */
	@GET
	@Path("/getTenementInsuranceById/{insuranceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TenementInsurance getTenementInsuranceById(@PathParam("insuranceId")String insuranceId);
	/**
	 * 查询所有保险
	 * @param insuranceId
	 * @return
	 */
	
	@GET
	@Path("/getAllTenementInsurance")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TenementInsurance> getAllTenementInsurance();
	
	/**
	 * 修改保险
	 * @param tenementInsurance
	 * @return
	 */
	@PUT
	@Path("/updateTenementInsurance")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateTenementInsurance(TenementInsurance tenementInsurance);
	
	/**
	 * 多条件查询
	 * @param tenementInsurance
	 * @return
	 */
	@POST
	@Path("/searchTenementInsurance")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<TenementInsurance> searchTenementInsurance(TenementInsurance tenementInsurance);

	@POST
 	@Path("/listPageTenementInsurance")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageTenementInsurance(TenementInsurance tenementInsurance);
	
	
	@GET
	@Path("/getTenementInsuranceByIds/{insuranceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TenementInsurance getTenementInsuranceByIds(@PathParam("insuranceId")String insuranceId);
	
	
}




