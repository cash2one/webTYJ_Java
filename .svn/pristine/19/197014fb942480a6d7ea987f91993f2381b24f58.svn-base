/**
 * @Title: AppUserAuditService.java
 * @Package com.flf.service
 * @Description: APP注册用户审核
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件有限公司
 * @date 2016年7月21日
 * @version V1.0
 */
package com.flf.service;

/**
 * @ClassName: AppUserAuditService
 * @Description: APP注册用户审核
 * @author ylq
 * @date 2016年7月21日
 */
@javax.jws.WebService
public interface AppUserAuditService {
	/**
	 * 根据物业APP账户ID和公司ID来修改状态-》用户同意。
	*/
	public String editProcessStatus2ByLoginNameAndCompanyId(String loginNameAndCompanyIdJson);
	 
	/**
	 * 从物业APP获取用户信息填充填充数据。  检测
	 */
	public String agree_CheckedAndFillUserInfoFromAPP(String infos);
	
	/**
	 * 员工拒绝。  检测
	 */
	public String disagree_CheckedFromAPP(String infos);

	
	/**
	 * 从物业APP获取用户信息填充填充数据。  审核
	 */
//	@javax.ws.rs.Path("/agree_ReviewedAndFillUserInfoFromAPP")
//	public String agree_ReviewedAndFillUserInfoFromAPP(String infos);
	
}
