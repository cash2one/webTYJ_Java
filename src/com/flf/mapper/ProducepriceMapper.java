package com.flf.mapper;

import java.util.List;

import com.flf.entity.Produceprice;


public interface ProducepriceMapper {//产品价格表
	List<String> listType();//查询产品类型
	List<Produceprice> listProducequotelistByType(String type);//通过产品类型查询产品报价
	Produceprice producequotelistById(int id);//通过产品id查询产品报价
	List<Produceprice> listAllProduceprice();//查询所有产品报价列表
	List<Produceprice> listPageProduceprice(Produceprice produceprice);
	int insertProduceprice(Produceprice produceprice);//添加产品价格
	int updateByPrimaryKeySelective(Produceprice produceprice);//修改
	int deleteByPrimaryKey(int productId);//通过主键删除
	int UpdateStateById(int productId); // 修改状态
}
