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
import com.flf.entity.UnionpayCollectionDetail;
import com.flf.entity.UnionpayCollectionTotall;
import com.flf.entity.UnionpayCounterofferDetai;
import com.flf.entity.UnionpayCounterofferTotal;
import com.flf.request.Info;

@WebService
@Path("/UnionpayCounterofferDetai")
public interface UnionpayCounterofferDetaiService {

	int insertUnionpayCounterofferDetai(
			UnionpayCounterofferDetai unionpayCounterofferDetai);

	List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiById(
			String unionpayCounterofferCotalId);

	@POST
	@Path("/insertUnionpayCounterofferDetai")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void insertUnionpayCounterofferDetai1(UnionpayCounterofferDetai unionpayCounterofferDetai);

	@GET
	@Path("/getUnionpayCounterofferDetaiById/{unionpayCounterofferCotalId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiByIdRestful(
			@PathParam("unionpayCounterofferCotalId") String unionpayCounterofferDetaiId);

	/**
  	 * 导入Excel数据文档
  	 * @param annex
  	 * @return
  	 */
  	@POST
  	@Path("/importExcel")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  	Info importExcel(UnionpayCounterofferDetai unionpayCounterofferDetai);

  	/**
	 * 添加从Excel文件导入,将结果返回到前台
	 */
	@POST
  	@Path("/getImportCounterofferDetai")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<UnionpayCounterofferDetai> returnImportCounterofferDetai(Annex annex);
	
	/**
	 * 导出回盘明细文件模版
	 * @author xiaocong
	 * @date 下午7:48:39
	 * @Description:TODO
	 * @return
	 * @updateby
	 */
	InputStream exportMBUDetailFile();
	/**
  	 * 通过id查询明细文件分页
  	 * @author chenqiuxu
  	 * @date  16：49
  	 * @param unionpayCounterofferDetai
  	 * @return
  	 */
  	@POST
	@Path("/listPagegetUnionpayCounterofferDetai")
	@Produces(MediaType.APPLICATION_JSON)
  	PageRestful listPagegetUnionpayCounterofferDetai(UnionpayCounterofferDetai unionpayCounterofferDetai);
	
}
