
/**
 * 创建 by 肖聪 2015/6/4
 * 添加产权变更接口
 */
package com.flf.service;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChangeTitle;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchPersonAndEnterprise;
@Path(value="/ChangeTitle")
public interface ChangeTitleService {
	List<ChangeTitle> listAllChangeTitle(ChangeTitle changeTitle);
    List<ChangeTitle> listPageChangeTitle(ChangeTitle changeTitle);
    ChangeTitle getChangeTitleById(String changeTitleId);
    //int deleteChangeTitle(int id);
    int insertChangeTitle(ChangeTitle changeTitle);
    int updateChangeTitle(ChangeTitle changeTitle);
          
    @POST
  	@Path("/listPageChangeTitleRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageChangeTitleRestful(ChangeTitle changeTitle);
    
    @POST
  	@Path("/listAllChangeTitleRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<ChangeTitle> listAllChangeTitleRestful(ChangeTitle changeTitle);
    
    @GET
  	@Path("/getChangeTitleByIdRestful/{changeTitleId}")
  	@Produces(MediaType.APPLICATION_JSON)
    ChangeTitle getChangeTitleByIdRestful(@PathParam("changeTitleId") String changeTitleId);
    
    @GET
  	@Path("/getChangeTitleByStallIdRestful/{stallId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<ChangeTitle> getChangeTitleByStallIdRestful(@PathParam("stallId") String stallId);
    
    @DELETE
   	@Path("/deleteChangeTitleRestful/{changeTitleId}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteChangeTitleRestful(@PathParam("changeTitleId") String changeTitle);
    
    /**
     * 创建 by 肖聪   2015/6/25
     * 产权变更 
     */
    @POST
   	@Path("/insertChangeTitleRestful")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertChangeTitleRestful(ChangeTitle  changeTitle);
    
    @PUT
   	@Path("/updateChangeTitleRestful")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateChangeTitleRestful(ChangeTitle changeTitle);
    
    /**
     * 创建 by 肖聪   2015/6/25
     * 查询与房屋车位关联的所有信息
     */
   
    @POST
   	@Path("/getAllchangeTitleAndPerson")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<SearchPersonAndEnterprise> getAllchangeTitleAndPerson();
    
    /**
	 * 创建 by 肖聪 
	 * 改变产权人或公司  
	 * 2015/6/25
	 */
    
    @POST
   	@Path("/updatePersonBuildingNewByState/{buildingStructureId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updatePersonBuildingNewByState(@PathParam("buildingStructureId")String buildingStructureId);
	
    /**
	 * 创建 by 肖聪 
	 * 根据条件查询出人或者公司
	 * 2015/6/25
	 */
    @POST
   	@Path("/searchAllchangeTitleAndPerson")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    SearchPersonAndEnterprise searchAllchangeTitleAndPerson(SearchPersonAndEnterprise searchPersonAndEnterprise);
    
    /**
     * 创建by 肖聪
     * 对资产进行产权的变更
     */
    
    @POST
   	@Path("/changeProperty")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void changeProperty(ChangeTitle changeTitle);
    
    /**
     * 根据id获取变更历史记录
     * @param custId
     * @return
     */
    @GET
    @Path("/getChangeTitleHistoryByCustId/{custId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<ChangeTitle> getChangeTitleHistoryByCustId(@PathParam("custId")String custId);
}

