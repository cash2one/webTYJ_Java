package com.flf.mapper;

import java.util.List;

import com.flf.entity.PooledNew;




public interface PooledNewMapper {
	
	List<PooledNew> ListPagePooledNew(PooledNew pooledNew);  //分页显示 公摊信息
	List<PooledNew> ListPooledNew();  //查询所有公摊信息
	PooledNew  selectPooledNewById(String id);  //根据id查询公摊信息
	
	int deletePooledNewById(String id);  //删除公摊信息
	
	int insertPooledNew(PooledNew pooledNew); //插入公摊信息
	int updatePooledNew(PooledNew pooledNew);//修改公摊信息
	
	PooledNew listPooledByBuildingStructureId(String buildingStructureId);//根据建筑结构id查询公摊信息集合
}