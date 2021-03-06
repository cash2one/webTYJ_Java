package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.flf.entity.PageRestful;
import com.flf.entity.WorkFlow;


@WebService
@Path("/WorkFlow")
public interface WorkFlowService {
	/**
	 * 查询所有工作流数据
	 * @return
	 */
	@POST
	@Path("/listPageSelectAll")
	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public PageRestful listPageSelectAll(WorkFlow workflow);
}
