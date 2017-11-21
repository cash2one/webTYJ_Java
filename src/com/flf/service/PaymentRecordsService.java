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

import com.flf.entity.News;
import com.flf.entity.PaymentDetails;
import com.flf.entity.PaymentRecords;

@WebService
@Path("/PaymentRecords")
public interface PaymentRecordsService {
	@POST
   	@Path("/insertPaymentRecords")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void insertPaymentRecords(PaymentRecords paymentRecords);
	
	
	/**
	 * 根据Id查询
	 * @param paymentDetailsId
	 * @return
	 */
	@GET
	@Path("/getPaymentRecordsById/{financialStaffId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PaymentRecords> getPaymentRecordsById(@PathParam("financialStaffId") String financialStaffId);
	
	
	/**
	 * 修改
	 */
	 
    @PUT
   	@Path("/updatePaymentRecordsRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updatePaymentRecords(PaymentRecords paymentRecords);
}
