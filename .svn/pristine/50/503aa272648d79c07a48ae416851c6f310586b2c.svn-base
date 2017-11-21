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

import com.flf.entity.FinancialStaff;
@WebService
@Path("/FinancialStaff")//部门表
public interface FinancialStaffService {
	/**
	 * 根据id查询上级员工信息(出纳)
	 * @param orderId
	 */
	@GET
	@Path("/selectById/{financialStaffId}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialStaff selectById(@PathParam("financialStaffId") String financialStaffId);

	/**
	 * 根据id查询上级员工信息(收银员)
	 * @param orderId
	 */
	@GET
	@Path("/selectAllsById/{financialStaffId}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialStaff selectAllsById(@PathParam("financialStaffId") String financialStaffId);
	
	/**
	 * 根据id查询上级员工信息(收银组长)
	 * @param orderId
	 */
	@GET
	@Path("/selectCashierById/{financialStaffId}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialStaff selectCashierById(@PathParam("financialStaffId") String financialStaffId);
	
	/**
	 *通过Id查询财务人员表信息
	 * @param orderId
	 */
	@GET
	@Path("/getFinancialStaffbyId/{financialStaffId}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialStaff getFinancialStaffbyId(@PathParam("financialStaffId") String financialStaffId);
	
	/**
	 *  通过员工id和岗位id查询
	 *  @author chenqiuxu
	 * @param financialStaff
	 * @return
	 */
	@POST
	@Path("/selectAllsByStaffId")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   	@Produces(MediaType.APPLICATION_JSON)
	FinancialStaff selectAllsByStaffId(FinancialStaff financialStaff);
	
	/**
	 * 通过员工id查询财务人员id
	 * @param staffId
	 * @return
	 */

	@GET
	@Path("/getFinancialStaffbyStaffId/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<FinancialStaff>getFinancialStaffbyStaffId(@PathParam("staffId") String staffId);
	
}
