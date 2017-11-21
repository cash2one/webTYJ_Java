package com.flf.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.PageRestful;
import com.flf.entity.PendingApproval;
@Path(value = "/PendingApproval")
public interface PendingApprovalService {
	/*
	 * 分页查询
	 */
    @POST
 	@Path("/listPagePendingApprovalRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPagePendingApproval(PendingApproval pendingApproval);
	
    @GET
  	@Path("/selectAllPendingApproval")
  	@Produces(MediaType.APPLICATION_JSON)
    List<PendingApproval> selectAllPendingApproval();
    
    
}
