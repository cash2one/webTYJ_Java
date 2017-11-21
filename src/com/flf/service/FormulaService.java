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

import com.flf.entity.Formula;

/**
 * 计费收费公式service
 * @author maogaofei
 * @date 2016年7月1日 下午3:18:18
 */
@WebService
@Path("/Formula")
public interface FormulaService {
	
	/**
	 * 根据条件查询公式列表
	 * @author maogaofei
	 * @date 2016年7月1日 下午3:14:57
	 * @param formula
	 * @return
	 */
	@POST
	@Path("/listAllFormula")
	@PathParam(MediaType.APPLICATION_JSON)
	public List<Formula> listAllFormula(Formula formula);
	
	/**
	 * 新增计费公式
	 * @author maogaofei
	 * @date 2016年7月4日 下午2:40:30
	 * @param scheme
	 * @return
	 */
	@POST
	@Path("/insertFormula")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String insertFormula(Formula formula);
	/**
	 * 批量删除计费公式
	 * @author maogaofei
	 * @date 2016年7月4日 下午6:49:47
	 * @param formulaId
	 */
	@GET
	@Path("/deleteFormula/{formulaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteChargeItemNew(@PathParam("formulaId") String formulaId);

}
