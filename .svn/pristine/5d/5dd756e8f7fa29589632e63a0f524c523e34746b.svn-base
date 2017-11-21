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

import com.flf.entity.BankDeposit;
import com.flf.entity.HandleMechanism;
import com.flf.entity.HouseNew;

@WebService
@Path("/HandleMechanism")
public interface HandleMechanismService {
	@PUT
	@Path("/updateHandleMechanism")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateHandleMechanism(HandleMechanism handleMechanism);

	@PUT
	@Path("/updateHandleState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateHandleState(HandleMechanism handleMechanism);
	
	@GET
	@Path("/getHandleMechanismbyEventTypeId/{eventTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<HandleMechanism> getHandleMechanismbyEventTypeId(@PathParam("eventTypeId") String eventTypeId);
	
	
    
    @POST
	@Path("/insertHandleMechanism")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertHandleMechanismUUID(HandleMechanism handleMechanism);
}
