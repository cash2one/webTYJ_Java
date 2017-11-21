package com.flf.service;

import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.flf.entity.AssetAccount;
import com.flf.entity.AssetAccountDetail;

/**
 * 资产账户详情表
 * @author 陶勇超
 * 2015-10-10
 */
@WebService
@Path("AssetAccountDetail")
public interface AssetAccountDetailService {
	/**
	 * 根据ID查询详情
	 * 
	 * @param assetAccountId
	 * @return
	 */
	@POST
	@Path("/getAssetAccountDetailById")
	@Produces(MediaType.APPLICATION_JSON)
	List<AssetAccountDetail> getAssetAccountDetailById(AssetAccount assetAccount);

}
