package com.flf.service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.CarInfo;
import com.flf.entity.LeaseContract;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.SearchCar;
import com.flf.entity.TcArticleState;

@Path("/LeaseContractService")
public interface LeaseContractService {
	
	/**
	 * 查询所有租赁合同管理列表
	 * @return
	 */
	@GET
	@Path("/listAllLeaseContracts")
	@Produces(MediaType.APPLICATION_JSON)
	List<LeaseContract> listAllLeaseContracts();
	
	/**
	 * 分页查询所有租赁合同管理列表
	 * @return
	 */
	@POST
	@Path("/listPageLeaseContracts")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageLeaseContracts(LeaseContract leaseContract);
	
	/**
	 * 新增租赁合同
	 */
	@POST
	@Path("/insertLeaseContract")
	@Produces(MediaType.APPLICATION_JSON)
	int insertLeaseContract(LeaseContract leaseContract);
}
