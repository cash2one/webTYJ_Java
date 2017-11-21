package com.flf.mapper;

import java.util.List;
import com.flf.entity.Menu;
//菜单表
public interface MenuMapper {
	List<Menu> listAllParentMenu();//查找所有的菜单信息
	List<Menu> listSubMenuByParentId(String parentId);
	Menu getMenuById(String menuId);//根据id查询菜单信息
	void insertMenu(Menu menu);//增加菜单
	void updateMenu(Menu menu);//修改菜单信息
	void deleteMenuById(String menuId);//删除菜单信息
	List<Menu> listAllSubMenu();
	List<Menu> listAllMenu();
}
