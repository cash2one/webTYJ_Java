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
import com.flf.entity.Entrance;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.request.Info;

@WebService
@Path("/Entrance")
public interface EntranceService {

	/**
	 * ��ѯ�����Ž���Ϣ
	 * @return
	 */
	@GET
	@Path("/listAllEntrance")
	@Produces(MediaType.APPLICATION_JSON)
	List<Entrance> listAllEntranceRest();
	/**
	 * ���id��ѯ�Ž���Ϣ
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/getEntrance/{cardId}")
	@Produces(MediaType.APPLICATION_JSON)
	Entrance getEntranceRest(@PathParam("cardId") String cardId);
	
	
	/**
	 * �����Ž���Ϣ
	 * @param entrance
	 */
	@POST
	@Path("/insertEntrance")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertEntranceRest(Entrance entrance);
	
	/**
	 * �޸��Ž���Ϣ
	 * @param entrance
	 */
	@PUT
	@Path("/updateEntrance")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateEntranceRest(Entrance entrance);
	/**
	 * 退还门禁卡(删除)
	 * @param cardId
	 */
	@DELETE
	@Path("/deleteEntranceById/{cardId}")
	void deleteEntranceByIdRest(@PathParam("cardId") String cardId);
	
	
	/**
	 * ��ݻ���id��ѯ������֮�������Ž���Ϣ
	 * @param cardId
	 * @return
	 */
	@GET
	@Path("/listEntranceByCustcode/{houseId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Entrance> listEntranceByCustcodeRest(@PathParam("houseId") String houseId);

	/**
	 * 更换门禁卡
	 * @param entrance
	 */
	@PUT
	@Path("/updateEntranceByIdRest")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateEntranceByIdRest(Entrance entrance);
	
	/**
	 * 挂失门禁卡
	 * @param entrance
	 */
	@PUT
	@Path("/updateEntranceByIdAndLost/{cardId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	void updateEntranceByIdAndLost(@PathParam("cardId")String cardId);
	
	/**
	 * 退还门禁卡
	 * @param entrance
	 */
	@PUT
	@Path("/updateEntranceByIdAndReturn/{cardId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	void updateEntranceByIdAndReturn(@PathParam("cardId")String cardId);
	
	/**
	 * 根据条件查询门禁卡信息
	 * @param search
	 * @return
	 */
	@POST
	@Path("listAllEntranceBySearch")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	List<Entrance> listAllEntranceBySearch(Search search);
	
	/**
	 * 根据条件查询办理人和授权人的门禁卡信息
	 * @param search
	 * @return
	 */
	@POST
	@Path("listSearchEntrancedAu")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	List<Entrance> listSearchEntrancedAu(Search search);
	
	/**
	 * 分页查询当前办卡人办理的门禁卡(是否查询已退卡的在页面判断)
	 * @param entrance
	 * @return
	 */
	@POST
	@Path("/listPageEntranceByEntrance")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageEntranceRestful(Entrance entrance);
	
	@POST
	@Path("/listPageEntranceByContion")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageEntranceByContion(Entrance entrance);
	
	/**
	 * 查询输入的门禁卡号在数据库中是否已存在
	 * 王洲
	 * 2016.1.14
	 * @param cardNum
	 * @return
	 */
	@GET
	@Path("/getEntranceBycardNum/{cardNum}")
	@Produces(MediaType.APPLICATION_JSON)
	Info getEntranceBycardNum(@PathParam("cardNum") String cardNum);
}
