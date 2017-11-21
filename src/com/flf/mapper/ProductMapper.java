package com.flf.mapper;

import java.util.List;

import com.flf.entity.Product;
import com.flf.entity.StallNew;
import com.flf.request.FixedParkingSpace;

public interface ProductMapper {
	//分页查询
    List<Product> listPageProduct(Product product);
    //根据产品ID删除
    int deleteProductById(String productId);
    //根据车位ID删除
    int deleteProductByStallId(String productId);
    //新增
    int insertProduct(Product record);
    //修改
    int updateProduct(Product record);
    
    List<Product> getProductByProductNum(String Type);
    
    //根据产品id查询对象及关联对象
    Product getProductByProductId(String productId);
    
    Product getProductByStallId(String stallId);
    
	List<FixedParkingSpace> listPageStallP(StallNew stallNew);//分页查询显示车位信息
	
	/**
	 * 修改产品的状态为失效
	 * @param productId
	 */
	void changeState(String productId);
	
	/**
	 * 根据产品类型查询门禁卡
	 * @param productType
	 * @return
	 */
	Product getProductByType(String productType);
	
	/**
	 * 根据产品名称查询是否有数据
	 * @author wangzhou
	 * 2016.04.22
	 * @param productName
	 * @return
	 */
	List<Product> getProductByproductName(String productName);
	Product getCode();
	/**
	 * @author hanyupeng
	 * 修改固定车位状态为已启用
	 */
	int updateStateByType();
	int updateStateByTypeAndS();
	
	Product getStall(String t,String s);
	/**
	 * 根据产品类型查询产品
	 * @param productType
	 * @return
	 */
	List<Product> listgetProductByType(String productType);
	
	/**
	 * 根据产品id查询产品
	 * @param productId
	 * @return
	 */
	Product getProductById1(String productId);
	
	
	
	Product getProductFivById(String productId);

}