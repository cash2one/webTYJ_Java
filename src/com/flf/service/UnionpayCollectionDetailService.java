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
import com.flf.entity.UnionpayCollectionDetail;
import com.flf.entity.UnionpayCounterofferDetai;

@WebService
@Path("/UnionpayCollectionDetail")
public interface UnionpayCollectionDetailService {

	List<UnionpayCollectionDetail>getUnionpayCollectionDetailById(String unionpayCollectionTotallId);

	//通过项目ID查询
			@GET
			@Path("/getUnionpayCollectionDetailById/{projectId}")
			@Produces(MediaType.APPLICATION_JSON)
			List<UnionpayCollectionDetail> getUnionpayCollectionDetailByIdRestful(@PathParam("projectId") String projectId);
			/**
		  	 * 导出Excel数据文档
		  	 * @param 
		  	 * @return
		  	 */
		  	@POST
		  	@Path("/exportExcelFile")
		  	@Produces(MediaType.APPLICATION_JSON)
		  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		  	List<UnionpayCollectionDetail> exportExcelFile(UnionpayCollectionDetail unionpayCollectionDetail);

		  	/**
		  	 * 导出文件体
		  	 * @author xiaocong
		  	 * @date 下午3:09:47
		  	 * @Description:TODO
		  	 * @param unionpayCollectionTotallId
		  	 * @return
		  	 * @updateby
		  	 */		  
		  	InputStream exportUDetailFile(String unionpayCollectionTotallId);
		  	
		  	/**
		  	 * 通过id查询，进行分页
		  	 * @author chenqiuxu
		  	 * @param unionpayCollectionDetail
		  	 * @return
		  	 */
		  	@POST
			@Path("/listPageUnionpayCollectionDetailById")
			@Produces(MediaType.APPLICATION_JSON)
		  	PageRestful listPageUnionpayCollectionDetailById(UnionpayCollectionDetail unionpayCollectionDetail);
		  	
}
