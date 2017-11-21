package com.flf.service.impl;

import java.util.List;

import javax.jws.WebService;

import com.flf.entity.Menu;
import com.flf.mapper.MenuMapper;
import com.flf.service.MenuService;
@WebService
public class MenuServiceImpl implements MenuService{

	private MenuMapper menuMapper;
	
	public void deleteMenuById(String menuId) {
		// TODO Auto-generated method stub
		menuMapper.deleteMenuById(menuId);
	}

	public Menu getMenuById(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuById(menuId);
	}

	public List<Menu> listAllParentMenu() {
		// TODO Auto-generated method stub
		return menuMapper.listAllParentMenu();
	}

	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		//if(menu.getMenuId()!=null && menu.getMenuId().intValue()>0){
		if(menu.getMenuId()!=null){
			menuMapper.updateMenu(menu);
		}else{
			menuMapper.insertMenu(menu);
		}
	}

	public List<Menu> listSubMenuByParentId(String parentId) {
		// TODO Auto-generated method stub
		return menuMapper.listSubMenuByParentId(parentId);
	}
	
	public List<Menu> listAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> rl = this.listAllParentMenu();
		for(Menu menu : rl){
			List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
			menu.setSubMenu(subList);
		}
		return rl;
	}

	public List<Menu> listAllSubMenu(){
		return menuMapper.listAllSubMenu();
	}
	
	public MenuMapper getMenuMapper() {
		return menuMapper;
	}

	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public void insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.insertMenu(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.updateMenu(menu);
	}

	@Override
	public List<Menu> listAllparentMenu() {
		// TODO Auto-generated method stub
		Menu menu=new Menu();
		List<Menu> menus = menuMapper.listAllParentMenu();
		return menus;
	}

	@Override
	public Menu getMenuByIdRest(String menuId) {
		// TODO Auto-generated method stub
		Menu menu=menuMapper.getMenuById(menuId);
		return menu;
	}

	@Override
	public void insertMenurest(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.insertMenu(menu);;
	}

	@Override
	public void updateMenurest(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.updateMenu(menu);
	}

	@Override
	public void deleteMenuByIdrest(String menuId) {
		// TODO Auto-generated method stub
		menuMapper.deleteMenuById(menuId);
	}

}
