/**
 * @Title: PersonBuildingNewService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-12 上午10:41:53
 * @version V1.0
 */

package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Annex;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonBuildingNew;
import com.flf.request.Info;



/**
 * @ClassName: PersonBuildingNewService
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-12 上午10:41:53
 *
 */
@WebService
@Path("/PersonBuildingNew")
public interface PersonBuildingNewService {
	/**
	 * @return 
	 * 添加客户与建筑信息关联或，
	  * @Title: addPersonBuildingNewRestful
	  * @Description: TODO
	  * @param @param personBuildingNew    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	@POST
	@Path("/addPersonBuildingNewRestful")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	String addPersonBuildingNewRestful(PersonBuildingNew personBuildingNew);
	
	/**
	 * 个人客户信息与员工关联
	  * @Title: addPersonEnterpriseCustRestful
	  * @Description: TODO
	  * @param @param personBuildingNew    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	@POST
	@Path("/addPersonEnterpriseCustRestful")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void addPersonEnterpriseCustRestful(PersonBuildingNew personBuildingNew);
	
	

	/**
	 *  企业与建筑信息关联
	  * @Title: addPersonEnterpriseCustRestful
	  * @Description: TODO
	  * @param @param personBuildingNew    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	@POST
	@Path("/addEnterpriseCustHouseRestful")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void addEnterpriseCustHouseRestful(PersonBuildingNew personBuildingNew);
	
	
	/**
	 *  通过houseId查询房屋和人物的信息
	  * @Title: addPersonEnterpriseCustRestful
	  * @Description: TODO
	  * @param @param personBuildingNew    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	
	@GET
	@Path("/listAllPersonAndHouseByHouseId/{houseId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> listAllPersonAndHouseByHouseId(@PathParam("houseId")String houseId);
	
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> listAll();
	
	
	@POST
	@Path("/listAllPersonBuildingNewone")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<PersonBuildingNew> listAllPersonBuildingNewone(PersonBuildingNew personBuildingNew);
	
	
	/**
	 * 根据建筑结构id查询物品包和业主信息
	 * @param personBuildingNew
	 * @return
	 */
	@POST
	@Path("/listPagePersonBuildingNew")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	PageRestful listPagePersonBuildingNew(PersonBuildingNew personBuildingNew);

	
	
	/**
	 *  通过houseId查询房屋和人物的信息
	  * @Title: addPersonEnterpriseCustRestful
	  * @Description: TODO
	  * @param @param personBuildingNew    设定文件
	  * @return void    返回类型
	  * @throws
	 */
	
	@GET
	@Path("/listPersonBuildingNewone/{buildingStructureId}")
	@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<PersonBuildingNew> listPersonBuildingNewByBuildingStructureIdone(@PathParam("buildingStructureId")String buildingStructureId);

	//企业客户资产绑定
	@POST
	@Path("/addPersonBuildingEnterpriseNewRestful")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	String addPersonBuildingEnterpriseNewRestful(PersonBuildingNew personBuildingNew);
	
	/**
	 * 根据建筑id查询建筑信息
	 * @param buildingStructureid
	 * @return
	 */
	@GET
	@Path("/selectHouseNew")
	@Produces(MediaType.APPLICATION_JSON)
	PersonBuildingNew selectHouseNew(@PathParam("buildingStructureid")String buildingStructureid);
	
	/**
	 * 根据企业id查询与企业及企业关联的房屋的员工的关系链
	 */
	@POST
	@Path("/getRelationOfemplers")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> getRelationOfemplers(PersonBuildingNew personBuildingNew);
	
	/**
	 * 根据客户id查询客户建筑关系
	 * @param custId
	 * @return
	 */
	@GET
	@Path("/listPersonBuildingNewByCustId/{custId}")
	@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<PersonBuildingNew> listPersonBuildingNewByCustId(@PathParam("custId")String custId);
	
	/**
	 * 根据客户id查询客户建筑关联
	 * @param personBuildingNew
	 * @return
	 */
	@POST
	@Path("/selectPersonBuildingNewByCustId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	List<PersonBuildingNew> selectPersonBuildingNewByCustId(PersonBuildingNew personBuildingNew);
	
	/**
	 * 根据建筑结构id查询关联的用户
	 * @param houseId
	 * @return
	 */
	@POST
	@Path("/listPersonBuildingByHouseId/{houseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<PersonBuildingNew> listPersonBuildingByHouseId(@PathParam("houseId") String houseId);
	
	/**
	 * 根据企业id查询与企业及企业关联的房屋的员工的关系链
	 */
	@POST
	@Path("/getRelationOfemplersByStructs")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> getRelationOfemplersByStructs(PersonBuildingNew personBuildingNew);
	
	/**
	 * 根据企业id查询与企业及企业关联的房屋的员工的关系链
	 */
	@POST
	@Path("/getRelationOfemplersByStructss")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> getRelationOfemplersByStructss(PersonBuildingNew personBuildingNew);

	/**
	 * 查询个人关系集
	 */
	@GET
	@Path("/getRelationOfemplersByCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> getRelationOfemplersByCustId(@PathParam("custId") String custId);
	
	/**
	 * 根据关系id修改，删除（关系启用/停止）关系链信息
	 * 肖聪
	 */
	
	@PUT
	@Path("/updataPersonBuildingById")
	@Produces(MediaType.APPLICATION_JSON)
	void updataPersonBuildingById(PersonBuildingNew personBuildingNew);
	
	/**
	 * 根据关系id修改，删除（关系启用/停止）关系链信息
	 * 肖聪
	 */
	
	@PUT
	@Path("/deletePersonBuildingById")
	@Produces(MediaType.APPLICATION_JSON)
	void deletePersonBuildingById(PersonBuildingNew personBuildingNew);  
	
	/**
	 * 查询个人关系集
	 */
	@GET
	@Path("/getRelationBycustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PersonBuildingNew> getRelationBycustId(@PathParam("custId") String custId);
	
    /**
     * 根据企业客户id查询企业客户关联的房屋 分页查询
     * @param personCustId
     * @return
     */
	@POST
	@Path("/listPageHouseByenterpriseId")
    @Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageHouseByenterpriseId(PersonBuildingNew personBuildingNew);
	
	/**
	 * 
	 * @author xiaocong
	 * @date 下午7:46:06
	 * @Description:TODO
	 * @param personBuildingId
	 * @updateby
	 */
	@POST
	@Path("/deletePersonBuilding")
	@Produces(MediaType.APPLICATION_JSON)
	String deletePersonBuilding(PersonBuildingNew personBuildingNew);
	
	@POST
	@Path("/importFile")
	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info importFile(Annex annex);
	
	@GET
	@Path("/getCustIdByCompanyId/{companyId}")
	@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	String getCustIdByCompanyId(@PathParam("companyId") String companyId);
	
	
	/*********************************************   可视对讲   *************************************************/
	
	String gteBuildingByPersonId(String personId);
	String getHouseNewByHouseId(String houseId);
	String getSipByStuctureId(String buildingStructureId);
	/**
	 * 根据建筑结构id获取相关联的person
	 * @param buildingStruId 建筑结构id
	 * @return
	 */
	String getPersonIdByBuildingStru(String buildingStruId);
	
	/**
	 * 根据客户id获取建筑信息
	 * @param custId
	 * @return
	 */
	String getPersonBuildingByCustId(String custId);
	
	/**
	 * by 吴颖
	 * 根据客户id获取绑定资产数量
	 * @param custId
	 * @return
	 */
	int getPersonBuildingCountByCustId(String custId);
	
	/**
	 * 查询家家sip以及室内机sip
	 * @param buildingStructureId
	 * @return
	 */
	String getSipsByStuctureId(String buildingStructureId);
	
	/**
	 * 根据客户id的集合查询建筑信息
	 * @param custIdList
	 * @return
	 */
	String getPersonBuildingByCustIdList(List<String> custIdList);
	
	String gteBuildingByPersonIdList(List<String> custIdList);
	
	/**
	 * 根据客户id集合获取绑定资产数量
	 * @param custId
	 * @return
	 */
	int getPersonBuildingCountByCustIdList(List<String> custIdList);
}
