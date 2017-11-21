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
import com.flf.entity.PageRestful;
import com.flf.entity.UnionpayCollectionTotall;
import com.flf.entity.UnionpayCounterofferTotal;
import com.flf.request.Info;

@WebService
@Path("/UnionpayCounterofferTotal")
public interface UnionpayCounterofferTotalService {

	int insertUnionpayCounterofferTotal(UnionpayCounterofferTotal unionpayCounterofferTotal);

	List<UnionpayCounterofferTotal> getUnionpayCounterofferTotalById(String unionpayCounterofferCotalId);

	List<UnionpayCounterofferTotal> listPageUnionpayCounterofferTotal(
			UnionpayCounterofferTotal unionpayCounterofferTotal);

	@POST
	@Path("/insertUnionpayCounterofferTotal")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void insertUnionpayCounterofferTotal1(UnionpayCounterofferTotal unionpayCounterofferTotal);

	@GET
	@Path("/getUnionpayCounterofferTotalById/{unionpayCounterofferCotalId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<UnionpayCounterofferTotal> getUnionpayCounterofferTotalById1(
			@PathParam("unionpayCounterofferCotalId") String unionpayCounterofferCotalId);

	// 分页查询
	@POST
	@Path("/listPageUnionpayCounterofferTotal")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageUnionpayCounterofferTotalRes(UnionpayCounterofferTotal unionpayCounterofferTotal);

	/**
	 * 导入Excel数据文档
	 * 
	 * @param annex
	 * @return
	 */
	@POST
	@Path("/importExcelFile")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Info importExcelFile(UnionpayCounterofferTotal unionpayCounterofferTotal);

	/**
	 * 银联导入回盘文件
	 * 
	 * @param unionpayCollectionTotall
	 * @return
	 */
	@POST
	@Path("/importCollectionFile")
	@Produces(MediaType.APPLICATION_JSON)
	Info importCollectionFile(UnionpayCollectionTotall unionpayCollectionTotall);

	/**
	 * 确认导入
	 * 
	 * @param financialGroupTotal
	 * @return
	 */
	@POST
	@Path("/confirmImport")
	@Produces(MediaType.APPLICATION_JSON)
	Info confirmImport(UnionpayCollectionTotall unionpayCollectionTotall);

	/**
	 * 添加从Excel文件导入,将结果返回到前台
	 */
	@POST
	@Path("/getImportFileDatas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<UnionpayCounterofferTotal> returnImportExcelFile(Annex annex);

	/**
	 * 盘回总结文件模版
	 * 
	 * @author xiaocong
	 * @date 下午7:18:00
	 * @Description:TODO
	 * @return
	 * @updateby
	 */
	InputStream exportUTotalMBFile();

}
