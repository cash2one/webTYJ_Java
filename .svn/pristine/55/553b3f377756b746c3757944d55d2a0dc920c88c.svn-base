package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.flf.entity.AuthorizationProject;

@WebService
@Path("/AuthorizationProject")
public interface AuthorizationProjectService {
	
    @GET
	@Path("/selectAllData")
	@Produces(MediaType.APPLICATION_JSON)
    List<AuthorizationProject> selectAllData();
}
