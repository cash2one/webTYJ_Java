package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.PageRestful;
import com.flf.entity.ProjectBilling;

/**
 * 项目计费service
 * @author maogaofei
 * @date 2016年7月9日 下午2:45:41
 */
@WebService
@Path("/ProjectBilling")
public interface ProjectBillingService {
	/**
	 * 根据条件分页查询项目计费列表
	 * @author maogaofei
	 * @date 2016年7月9日 下午4:08:41
	 * @param projectBilling
	 * @return
	 */
	@POST
	@Path("/listPageProjectBilling")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageProjectBilling(ProjectBilling projectBilling);
}
