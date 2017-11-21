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
import com.flf.entity.PageRestful;
import com.flf.entity.UnionpayCollectionTotall;

@WebService
@Path("/UnionpayCollectionTotall")
public interface UnionpayCollectionTotallService {
	
	  //分页查询
		@POST
		@Path("/listPageUnionpayCollectionTotall")
		@Produces(MediaType.APPLICATION_JSON)
	//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    PageRestful listPageUnionpayCollectionTotallRes(UnionpayCollectionTotall unionpayCollectionTotall);
	 
		//通过项目ID查询
		@GET
		@Path("/getUnionpayCollectionTotallById/{unionpayCollectionTotallId}")
		@Produces(MediaType.APPLICATION_JSON)
		List<UnionpayCollectionTotall> getUnionpayCollectionTotallByIdRestful(@PathParam("unionpayCollectionTotallId") String unionpayCollectionTotallId);

	  	/**
	  	 * 导出Excel数据文档
	  	 * @param 
	  	 * @return
	  	 */
	  	@POST
	  	@Path("/exportExcelFile")
	  	@Produces(MediaType.APPLICATION_JSON)
	  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	  	void exportExcelFile(UnionpayCollectionTotall unionpayCollectionTotall);
	  	
	  	/**
	  	 * 导出Excel数据文档
	  	 * @param 
	  	 * @return
	  	 */
	  	InputStream exportUTotalFile(String unionpayCollectionTotallId);
	  	
	  	/**
	  	 * 导出银联托收文件
	  	 * @param 
	  	 * @return
	  	 */
	  	InputStream exportUcollectionFile(String unionpayCollectionTotallId);

	  	/**
	  	 * 银联新建托收
	  	 * @param projectId
	  	 * @return
	  	 */
	  	@GET
		@Path("/newCollection/{projectId}")
		@Produces(MediaType.APPLICATION_JSON)
	  	UnionpayCollectionTotall newCollection(@PathParam("projectId") String projectId);
	  	
	  	/**
	  	 * 银联取消托收
	  	 * @param projectId
	  	 * @return
	  	 */
	  	@GET
		@Path("/cancelCollection/{projectId}")
		@Produces(MediaType.APPLICATION_JSON)
	  	void cancelCollection(@PathParam("projectId") String projectId);
	  	
	  	/**
	  	 * 银联修改托收状态
	  	 * @author Zms
	  	 * @param unionpayCollectionTotallId
	  	 */
	  	@GET
		@Path("/updateCollectionState/{unionpayCollectionTotallId}")
		@Produces(MediaType.APPLICATION_JSON)
	  	void updateCollectionState(@PathParam("unionpayCollectionTotallId") String unionpayCollectionTotallId);
}
