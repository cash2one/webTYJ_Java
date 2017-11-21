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

import com.flf.entity.Annex;
import com.flf.entity.FinancialGroupDetail;
import com.flf.entity.PageRestful;
import com.flf.request.Info;

@WebService
@Path("/FinancialGroupDetail")
public interface FinancialGroupDetailService {
	/**
	 * 通过Id查询
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getDatas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<FinancialGroupDetail> getDatasByIdRes(@PathParam("id") String id);
	
	
	/**
	 * 添加从Excel文件导入，将结果返回前台
	 */
	@POST
  	@Path("/getImportFileDatas")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<FinancialGroupDetail> returnImportFileDatas(Annex annex);
	
	/**
	 * 将前台确认的结果存入数据库（returnImportFileDatas的后续动作）
	 */
	@POST
  	@Path("/importDataFromExcelFile")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info importDataFromExcelFile(FinancialGroupDetail financialGroupDetail);
	
	@POST
  	@Path("/exportToExcel")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void exportToExcel(FinancialGroupDetail financialGroupDetail);
	
	
	/**
	 * 金融银行明细导出
	 * @author xiaocong
	 * @date 上午11:01:23
	 * @Description:TODO
	 * @param financialGroupTotalId
	 * @return
	 * @updateby
	 */
	InputStream exportFDetailFile(String financialGroupTotalId);

    /**
     * 金融银行明细模版导出
     * @author xiaocong
     * @date 下午2:06:45
     * @Description:TODO
     * @return
     * @updateby
     */
	InputStream exportMFUDetailFile(); 
	/**
	 * 根据金融联银行总文件id查询明细分页显示
	 * @author chennqiuxu
	 * @date 上午10:02
	 * @param financialGroupDetail
	 * @return pageRestful
	 */
	@POST
	@Path("/listPageFinancialGroupDetail")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFinancialGroupDetail(FinancialGroupDetail financialGroupDetail);

	/**
	 * 金融联明细历史导出Txt
	 * @author maogaofei
	 * @date 2016年6月2日 下午2:02:33
	 * @param financialGroupTotalId
	 * @return
	 */
	InputStream exportFDetailFileTxt(String financialGroupTotalId);

	/**
	 * 金融联明细导出Txt
	 * @author maogaofei
	 * @date 2016年6月12日 下午5:17:45
	 * @param financialGroupTotalId
	 * @return
	 * @throws Exception 
	 */
	InputStream exportDetailFileTxt(String financialGroupTotalId) throws Exception;
	
}
