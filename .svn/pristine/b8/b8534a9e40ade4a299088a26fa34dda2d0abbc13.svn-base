package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Items;
import com.flf.mapper.ItemsMapper;
import com.flf.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	private ItemsMapper itemsMapper;

	public ItemsMapper getItemsMapper() {
		return itemsMapper;
	}

	public void setItemsMapper(ItemsMapper itemsMapper) {
		this.itemsMapper = itemsMapper;
	}

	@Override
	public List<Items> listAllItems() {
		// TODO Auto-generated method stub
		return itemsMapper.listAllItems();
	}

	@Override
	public Items getUserByIdRest(String id) {
		// TODO Auto-generated method stub
		return itemsMapper.getItemsbyId(id);
	}

	@Override
	public void insertItemsrest(Items items) {
		// TODO Auto-generated method stub
		itemsMapper.insertItems(items);
	}

	@Override
	public void updateItemsrest(Items items) {
		// TODO Auto-generated method stub
		itemsMapper.updateItems(items);
	}

	@Override
	public void deleteItemsrest(String id) {
		// TODO Auto-generated method stub
		itemsMapper.deleteItems(id);
	}

}
