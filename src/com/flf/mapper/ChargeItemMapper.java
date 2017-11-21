package com.flf.mapper;

import java.util.Map;

public interface ChargeItemMapper {
	int insertListChargeItem(Map<String,Object> map);//添加多个收费项
	
	int deleteChargeItem(String pactId); //删除合同的收费项
}
