package com.flf.service;

import java.io.InputStream;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.BusException;

import com.flf.entity.Annex;
import com.flf.entity.FinancialGroupTotal;
import com.flf.entity.PageRestful;
import com.flf.request.Info;

@WebService
@Path("/FinancialGroupTotal")
public interface FinancialGroupTotalService {

	/**
	 * 通过Id查询
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getDatasById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<FinancialGroupTotal> getDatasByIdRes(@PathParam("id") String id);
	
	/**
	 * 根据项目计费表id查询项目的一级收费项目详情
	 * 
	 */
	@POST
	@Path("/listPageFinancial")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFinancialRes(FinancialGroupTotal financialGroupTotal);
	
	/**
	 * 新建托收
	 * @author maogaofei
	 * @date 2016年6月1日 下午2:05:16
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("/createCollection/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialGroupTotal createCollection(@PathParam("projectId") String projectId);
	
	/**
	 * 删除托收数据
	 * @author maogaofei
	 * @date 2016年6月12日 下午2:19:34
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("/deleteFinancialGroupTotal/{financialGroupTotalId}")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteFinancialGroupTotal(@PathParam("financialGroupTotalId") String financialGroupTotalId);
	
	/**
	 * 将前台确认的结果存入数据库（returnImportFileDatas的后续动作）
	 */
	@POST
  	@Path("/importDataFromExcelFile")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info importDataFromExcelFile(FinancialGroupTotal financialGroupTotal);
	
	/**
	 * 添加从Excel文件导入,将结果返回到前台
	 */
	@POST
  	@Path("/getImportFileDatas")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<FinancialGroupTotal> returnImportFileDatas(Annex annex);
	
	/**
	 * 将前台数据导入到excel文件
	 * @param financialGroupTotal
	 */
	@POST
  	@Path("/exportToExcel")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info exportToExcel(FinancialGroupTotal financialGroupTotal);
	/**
	 * 金融联导入回盘文件
	 * @author maogaofei
	 * @date 2016年6月6日 下午3:09:37
	 * @param financialFiles
	 * @return
	 */
	@POST
   	@Path("/importFinancialFile")
  	@Produces(MediaType.APPLICATION_JSON)
    Info importFinancialFile(FinancialGroupTotal financialGroupTotal);
	/**
	 * 金融联回盘文件导入确认
	 * @author maogaofei
	 * @date 2016年6月8日 下午2:49:52
	 * @param financialGroupTotal
	 * @return
	 */
	@POST
   	@Path("/confirmImport")
  	@Produces(MediaType.APPLICATION_JSON)
    Info confirmImport(FinancialGroupTotal financialGroupTotal);
	
  	/**
  	 * 金融银行总结模版导出
  	 * @author xiaocong
  	 * @date 上午11:19:13
  	 * @Description:TODO
  	 * @return
  	 * @updateby
  	 */
	InputStream exportFTotalMBFile();

	/**
	 * 金融银行总结导出
	 * @author xiaocong
	 * @date 上午10:34:04
	 * @Description:TODO
	 * @param financialGroupTotalId
	 * @return
	 * @updateby
	 */
  	InputStream exportFTotalFile(String financialGroupTotalId);
  	/**
  	 * 金融银行总结历史导出Txt文件
  	 * @author maogaofei
  	 * @date 2016年6月2日 上午11:39:15
  	 * @param financialGroupTotalId
  	 * @return
  	 * @throws BusException 
  	 */
	InputStream exportFTotalFileTxt(String financialGroupTotalId) throws Exception;
	/**
	 * 
	 * @author maogaofei
	 * @date 2016年6月12日 下午5:13:43
	 * @param financialGroupTotalId
	 * @return
	 */
	InputStream exportTotalFileTxt(String financialGroupTotalId) throws Exception;
}
