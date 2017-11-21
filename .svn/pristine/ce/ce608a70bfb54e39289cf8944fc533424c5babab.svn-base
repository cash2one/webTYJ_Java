package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.InspectionPropertyCheckItem;
@WebService
@Path("/InspectionPropertyCheckItem")
public interface InspectionPropertyCheckItemService{
    @GET
	@Path("/selectInspectionPropertyCheckItemById/{inspectionPlanId}")//根据id查询
	@Produces(MediaType.APPLICATION_JSON)
    List<InspectionPropertyCheckItem> selectInspectionPropertyCheckItem(@PathParam("inspectionPlanId") String inspectionPlanId);

}