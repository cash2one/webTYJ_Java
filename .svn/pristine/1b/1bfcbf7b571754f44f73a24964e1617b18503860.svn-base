package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Parcel;
import com.flf.entity.Prepare;

@WebService
@Path("/Parcel")
public interface ParcelService {
	/**
	 *  新增宗地
	 * @param parcel
	 * @return
	 */
	@POST
	@Path("/insertParcel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Parcel insertParcel(Parcel parcel);
	
	/**
	 * 根据项目id查询宗地信息
	 * @return
	 */
	@GET
	@Path("/getParcelByprojectId/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Parcel> getParcelByprojectId(@PathParam("projectId") String projectId);
}
