package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.flf.entity.Condition;

/**
 * 条件对象service
 * @author wangzhou
 *
 */
@Path("/Condition")
@WebService
public interface ConditionService {

	/**
	 * 新增条件
	 * @param condition
	 */
	public void insertCondition(Condition condition);
	
	/**
	 * 修改条件
	 * @param condition
	 */
	public void updateCondition(Condition condition);
}
