package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.DataDictionaryMaster;
import com.flf.entity.DataDictionaryMasterProject;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.PageRestful;

/**
 * 属性设置service
 * @author wangzhou
 *
 */

@WebService
@Path("/DataDictionary")
public interface DataDictionaryService {

	/**
	 * 分页查询数据字典表主表
	 * @param dataDictionaryMaster
	 * @return
	 */
	@POST
	@Path("/listPageMaster")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
	
	/**
	 * 分页查询数据字典表从表
	 * @param dataDictionarySlave
	 * @return
	 */
	@POST
	@Path("/listPageSlave")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageSlave(DataDictionarySlave dataDictionarySlave);
	
	/**
	 * 新增数据字典主表
	 * @param dataDictionaryMaster
	 */
	@POST
	@Path("/insertMaster")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int insertMaster(DataDictionaryMaster dataDictionaryMaster);
	
	/**
	 * 新增数据字典从表
	 * @param dataDictionarySlave
	 */
	@POST
	@Path("/insertSlave")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int insertSlave(DataDictionarySlave dataDictionarySlave);
	
	/**
	 * 修改数据字典主表
	 * @param dataDictionaryMaster
	 */
	@POST
	@Path("/updateMaster")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateMaster(DataDictionaryMaster dataDictionaryMaster);
	
	/**
	 * 修改数据字典从表
	 * @param dataDictionarySlave
	 */
	@POST
	@Path("/updateSlave")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int updateSlave(DataDictionarySlave dataDictionarySlave);
	
	/**
	 * 删除数据字典主表数据(将状态从启用该成未启用)
	 * @param dataDictionaryMaster
	 */
	@POST
	@Path("/deleteMaster/{masterIds}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void deleteMaster(@PathParam("masterIds") String masterIds);
	
	/**
	 * 删除数据字典主表数据(将状态从启用该成启用)
	 * @param dataDictionaryMaster
	 */
	@POST
	@Path("/deleteMasterOn/{masterIds}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void deleteMasterOn(@PathParam("masterIds") String masterIds);
	
	/**
	 * 删除数据字典从表数据(将状态从启用改成未启用)
	 * @param slaveIds
	 */
	@POST
	@Path("/deleteSlaveOff/{slaveIds}/{masterId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int deleteSlave(@PathParam("slaveIds") String slaveIds, @PathParam("masterId") String masterId);
	
	/**
	 * 删除数据字典从表数据(将状态从启用改成未启用)
	 * @param slaveIds
	 */
	@POST
	@Path("/deleteSlaveOn/{slaveIds}/{masterId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int deleteSlaveOn(@PathParam("slaveIds") String slaveIds, @PathParam("masterId") String masterId);
	
	/**
	 * 查询从表关联的所有项目
	 * @param slaveId
	 * @return
	 */
	@POST
	@Path("/listPageProjectByMaster")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageProjectByMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
	
	/**
	 * 向从表和项目关联表中添加数据
	 * @param slaveId
	 * @param projectIds
	 */
	@POST
	@Path("/insertDataDictionaryMasterProject/{masterId}/{projectids}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void insertDataDictionaryMasterProject(@PathParam("masterId") String masterId, @PathParam("projectids") String projectids);
	
	/**
	 * 删除主表和项目的关联关系
	 * @param ids
	 */
	@POST
	@Path("/deleteProjectAndMaster/{sPids}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void deleteProjectAndMaster(@PathParam("sPids") String sPids);
	
	/**
	 * 查询所有字典表主表数据
	 * @return
	 */
	@POST
	@Path("/listAllMaster")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	List<DataDictionaryMasterProject> listAllMaster(DataDictionaryMasterProject dataDictionaryMasterProject);
	
	/**
	 * 查询所有字典表主表默认数据
	 * @return List<DataDictionaryMasterProject>
	 */
	@POST
	@Path("/listAllMasterId")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	List<DataDictionaryMasterProject> listAllMasterId();
}
