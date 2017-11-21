package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.FinancialCounterofferDetail;
import com.flf.entity.PageRestful;

@WebService
@Path("/FinancialCounterofferDetail")
public interface FinancialCounterofferDetailService {
	
	/**
	 * 根据回盘总结文件ID分页查询回盘明细文件
	 * @author maogaofei
	 * @date 2016年6月8日 下午12:03:42
	 * @param financialCounterofferTotal
	 * @return
	 */
	@POST
	@Path("/listPageFinancialCounterofferDetail")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFinancialCounterofferDetail(FinancialCounterofferDetail financialCounterofferDetail);

}
