package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.ibatis.annotations.Param;

import com.flf.entity.BuildingComponent;
import com.flf.entity.CassetRepository;
import com.flf.entity.PageRestful;

import com.flf.request.CassetRepositoryRequest;
import com.flf.request.PropertyResult;

import com.flf.request.Info;


@WebService
@Path("/CassetRepository")
public interface CassetRepositoryService {
	
	/**
	 * 分页显示资产库信息
	 * 
	 * @return
	 */
	@POST
   	@Path("/listPageCassetRepository")
   	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageCassetRepository(CassetRepository CassetRepository);  
	
	/**
	 * 查询所有资产库信息
	 * 
	 * @return
	 */
	@GET
	@Path("/listCassetRepositoryAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<CassetRepository> listCassetRepositoryAll();

	/**
	 * 根据id查询资产库信息
	 * 
	 * @param CassetRepositoryId
	 * @return
	 */
	@GET
	@Path("/getCassetRepositoryByIdRest/{CassetRepositoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	CassetRepository getCassetRepositoryByIdRest(@PathParam("CassetRepositoryId") String CassetRepositoryId);

	/**
	 * 添加资产库信息
	 * 
	 * @param CassetRepository
	 * @return
	 */
	@POST
	@Path("/AddCassetRepositorys")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void AddCassetRepository(CassetRepository CassetRepository);
	
	/**
	 * 绑定资产库信息
	 * @param CassetRepository
	 * @return
	 */
	@POST
	@Path("/bindingCassetRepository")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	Info bindingCassetRepository(CassetRepository cassetRepository);

	/**
	 * 修改资产库信息
	 * 
	 * @param CassetRepository
	 * @return
	 */
	@PUT
	@Path("/UpdateCassetRepository")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateCassetRepository(CassetRepository CassetRepository);

	/**
	 * 删除资产库信息
	 * 
	 * @param CassetRepositoryId
	 * @return
	 */
	@DELETE
	@Path("/DeleteCassetRepositoryById/{CassetRepositoryId}")
	void DeleteCassetRepositoryById(@PathParam("CassetRepositoryId") String CassetRepositoryId);

	/**
	 *批量添加资产库信息
	 * 
	 * @param CassetRepository
	 * @return
	 */
	@POST
	@Path("/AddCassetRepository")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddCassetRepositoryList(BuildingComponent buildingComponent);
	
	/**
	 * 根据建筑结构id查询所有资产库信息
	 * 
	 * @return
	 */
	@GET
	@Path("/listCassetRepositoryAllBybuildingStructureId/{buildingStructures}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CassetRepository> listCassetRepositoryAllBybuildingStructureId(@PathParam("buildingStructures") String buildingStructures);
	
	
	/**
	 * 批量修改资产库信息
	 * 
	 * @param CassetRepository
	 * @return
	 */
	@POST
	@Path("/ListCassetRepositoryList")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void ListCassetRepositoryList(CassetRepositoryRequest CassetRepositoryRequest);
	
	/**
	 * 根据条件查询资产库信息
	 * @param cassetRepository
	 * @return
	 */
	@POST
	@Path("/getCassetRepositorybyCondition")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<CassetRepository> getCassetRepositorybyCondition(CassetRepository cassetRepository);


	/**
	 * 根据条件查询资产库信息
	 * @param cassetRepository
	 * @return
	 */
	@POST
	@Path("/listPageSpecialAndClassify")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageSpecialAndClassifyRes(CassetRepository cassetRepository);
	
	@GET
	@Path("/getCassetRepositoryDatils/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	CassetRepository getCassetRepositoryDatils(@PathParam("id") String id);
	
}
