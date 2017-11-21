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

import com.flf.entity.Caraccesscard;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;

/*import com.flf.entity.CollectFees;*/
/**
 * Created by Administrator on 2015/5/29. 
 * author:尹磊
 * 最后修改时间：2015/6/1  最后修改人：尹磊
 * 最后修改时间：2015/6/17  最后修改人：肖聪
 */
@WebService
@Path("/Caraccesscard")
public interface CaraccesscardService {
	/**
	 * 查询所有车辆卡信息
	 * @return
	 */
	@GET
	@Path("/listAllCaraccesscard")
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listAllCaraccesscard();
	/**
	 * 根据id查询车辆卡信息
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/getCaraccesscardbyId/{cardId}")
	@Produces(MediaType.APPLICATION_JSON)
	Caraccesscard getUserByIdRest(@PathParam("cardId") String cardId);
	
	/**
	 * 根据车位id查询车辆卡信息
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/getParkbyId/{parkId}")
	@Produces(MediaType.APPLICATION_JSON)
	Caraccesscard getParkByIdRest(@PathParam("parkId") String parkId);
	/**
	 * 新增车辆卡信息
	 * @param caraccesscard
	 */
	@POST
	@Path("/insertCaraccesscard")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertCaraccesscardrest(Caraccesscard caraccesscard);
	
	/**
	 * 新增车辆卡信息
	 * @param caraccesscard
	 */
	@POST
	@Path("/insertPark")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertParkcardrest(Caraccesscard caraccesscard);
	/**
	 * 修改车辆卡信息
	 * @param caraccesscard
	 */
	@PUT
	@Path("/updateCaraccesscard")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateCaraccesscardrest(Caraccesscard caraccesscard);
	/**
	 * 删除车辆卡信息
	 * @param cardId
	 */
	@DELETE
	@Path("/deleteCaraccesscard/{cardId}")
	void deleteCaraccesscardrest(@PathParam("cardId") String cardId);
	
	
	/**
	 * 根据户主id查询所有与之关联的门禁卡信息
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/listCaraccesscardByCustcode/{houseId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listCaraccesscardByCustcode(@PathParam("houseId") String houseId);
	
	/**
	 * 根据客户id查询车辆卡信息
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/listCaraccesscardByCustId/{custCode}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listCaraccesscardByCustId(@PathParam("custCode") String custCode);
	

	/**
	 * 更换停车卡
	 * @param caraccesscard
	 */
	@PUT
	@Path("/updateCaraccessBycardId")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateCaraccessBycardId(Caraccesscard caraccesscard);
	
	/**
	 * 停车卡挂失
	 * @param caraccesscard
	 */
	@PUT
	@Path("/LossCaraccessBycardId/{cardId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void LossCaraccessBycardId(@PathParam("cardId") String cardId);
	
	/**
	 * 停车卡退卡
	 * @param caraccesscard
	 */
	@PUT
	@Path("/RefundCaraccessBycardId")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void RefundCaraccessBycardId(Caraccesscard caraccesscard);
	
	/**
	 * 创建by肖聪 2015/7/10
	 * 通过条件查询车辆卡信息
	 * @param caraccesscard
	 */
	@POST
	@Path("/listSearchCaraccesscard")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listSearchCaraccesscard(Search search);
	
	/**
	 * 创建by肖聪 2015/7/10
	 * 通过条件查询办理人和授权人的停车卡
	 * @param caraccesscard
	 */
	@POST
	@Path("/listSearchCaraccesscardAu")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listSearchCaraccesscardAu(Search search);
	
	/**
	 * 创建by肖聪 2015/7/24
	 * 通过条件查询车辆卡信息
	 * @param caraccesscard
	 */
	@POST
	@Path("/listSearchCaraccesscardEX")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	List<Caraccesscard> listSearchCaraccesscardEX(Search search);
	/**
	 * 通过客户id分页查询停车卡信息
	 * 
	 * @param 
	 * @return
	 */
	@POST
	@Path("/listPageCaraccesscardByCustCode")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageCaraccesscardByCustCode(Caraccesscard caraccesscard);
	
	@POST
	@Path("/listPageCaraccesscardByContion")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageCaraccesscardByContion(Caraccesscard caraccesscard);
	
	
}
