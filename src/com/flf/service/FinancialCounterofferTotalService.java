package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.FinancialCounterofferTotal;
import com.flf.entity.PageRestful;

@WebService
@Path("/FinancialCounterofferTotal")
public interface FinancialCounterofferTotalService {
	
	/**
	 * 根据批次号分页查询回盘总结文件
	 * @author maogaofei
	 * @date 2016年6月8日 下午12:03:42
	 * @param financialCounterofferTotal
	 * @return
	 */
	@POST
	@Path("/listPageFinancialCounterofferTotal")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFinancialCounterofferTotal(FinancialCounterofferTotal financialCounterofferTotal);
	/**
	 * 根据批次号查询回盘总结文件并统计提出笔数、提出金额、成功笔数、成功金额、失败笔数、失败金额
	 * @author maogaofei
	 * @date 2016年7月20日 上午10:41:20
	 * @param financialCounterofferTotal
	 * @return
	 */
	@POST
	@Path("/getTotalFinancialCounterofferTotals")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialCounterofferTotal getTotalFinancialCounterofferTotals(FinancialCounterofferTotal financialCounterofferTotal);

}
