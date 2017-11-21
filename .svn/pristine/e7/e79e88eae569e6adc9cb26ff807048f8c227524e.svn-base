package com.flf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AcceptanceOrders;
import com.flf.entity.ContractPropertyStructure;

@Path("/ContractPropertyStructure")
public interface ContractPropertyStructureService {
    List<ContractPropertyStructure> listAllContractPropertyStructureByContractId(String contractId); //根据合同查询合同详情

    @GET
    @Path("/getContractPropertyStructureById/{id}")
    @Produces(MediaType.APPLICATION_JSON)    
    List<ContractPropertyStructure>  listAllByContractId(@PathParam("id")String id);
    
    
	@POST
	@Path("/selectBuildingById")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 List<ContractPropertyStructure> selectBuildingByIdRes(ContractPropertyStructure contractPropertyStructure);
   

}
