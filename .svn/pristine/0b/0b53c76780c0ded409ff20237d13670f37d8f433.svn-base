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

import com.flf.entity.Menu;
//菜单表
@WebService
@Path("/Menu")
public interface MenuService {
	List<Menu> listAllMenu();
	List<Menu> listAllParentMenu();//查找所有的菜单信息
	List<Menu> listSubMenuByParentId(String parentId);
	Menu getMenuById(String menuId);//根据id查询菜单信息
	void saveMenu(Menu menu);
	void insertMenu(Menu menu);//增加菜单
	void updateMenu(Menu menu);//修改菜单信息
	void deleteMenuById(String menuId);//删除菜单信息
	List<Menu> listAllSubMenu();
	

    @GET
	@Path("/listAllParentMenu")
	@Produces(MediaType.APPLICATION_JSON)
	List<Menu> listAllparentMenu();
	
	@GET
	@Path("/getMenuById/{menuId}")
	@Produces(MediaType.APPLICATION_JSON)
	Menu getMenuByIdRest(@PathParam("menuId") String menuId);
	
	@POST
	@Path("/insertMenu")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertMenurest(Menu menu);
	
	@PUT
	@Path("/updateMenu")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateMenurest(Menu menu);
	
	@DELETE
	@Path("/deleteMenuById/{menuId}")
	void deleteMenuByIdrest(@PathParam("menuId") String menuId);
}
