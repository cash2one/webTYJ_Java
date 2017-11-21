package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.OrderAttachment;
@WebService
@Path("/OrderAttachment")
public interface OrderAttachmentService {
	List<OrderAttachment> listPageOrderAttachment(OrderAttachment orderAttachment);//分页查询所有信息
	List<OrderAttachment> listAllOrderAttachment();//查询所有信息
	OrderAttachment getOrderAttachmentById(String id);//查询
	int insertOrderAttachment(OrderAttachment orderAttachment);//添加
	int updateOrderAttachment(OrderAttachment orderAttachment);//修改
	int deleteOrderAttachment(String id);//删除
	
	/**
	 * 追加多个工单附件（通用接口）
	 * @param integer 关联id
	 * @param attachments 上传附件信息json数组
	 * @param attachmenttype 关联类型
	 * @author 汪洋
	 * @return
	 */
	Boolean AddAttachments(String id, String attachments, String attachmenttype);
	
	@GET
	@Path("/listPageOrderattachment")//分页查询所有信息
	@Produces(MediaType.APPLICATION_JSON)
	List<OrderAttachment> listPageOrderattachment();
	
	@GET
	@Path("/getOrderAttachmentById/{id}")//查询
	@Produces(MediaType.APPLICATION_JSON)
	OrderAttachment getOrderAttachmentByIdRest(@PathParam("id") String id);
	
	@POST
	@Path("/AllOrderAttachment")//添加
	@Consumes( MediaType.APPLICATION_JSON)
	public void AllOrderAttachment(OrderAttachment orderAttachment);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)//修改
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/UpdateOrderAttachment")
	public void UpdateOrderAttachment(OrderAttachment orderAttachment);
	
	@DELETE
	@Path("/DeleteOrderAttachment/{id}")//删除
	public void DeleteOrderAttachment(@PathParam("id") String id);
}
