package com.flf.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.flf.entity.Lost;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
@Path(value="/Lost")
public interface LostService {
	List<Lost> listAllLost();
    List<Lost> listPageLost(Lost lost);
    Lost getLostById(String id);
    //int deleteLost(int id);
    int insertLost(Lost lost);
    int updateLost(Lost lost);
          
  /*  @POST
  	@Path("/listPageLostRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageLostRestful(Lost lost);*/
    
    @GET
  	@Path("/listAllLostRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Lost> listAllLostRestful();
    
    @GET
  	@Path("/getLostByIdRestful/{id}")
  	@Produces(MediaType.APPLICATION_JSON)
    Lost getLostByIdRestful(@PathParam("id")String id);
    
    @DELETE
   	@Path("/deleteLostRestful/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteLostRestful(@PathParam("id")String id);
    
    @POST
   	@Path("/insertLostRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertLostRestful(Lost lost);
    
    @PUT
   	@Path("/updateLostRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateLostRestful(Lost lost);
    
    /**
     * 创建by肖聪
     * 2015/8/3
     * 遗失物品领取
     * @param lost
     */
    @PUT
   	@Path("/updateLostClaim")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateLostClaim(Lost lost);
    
    /**
     * 创建by 肖聪
     * 2015/8/3
     * 物品遗失更据条件查询
     * @param lost
     * @return
     */
    @POST
   	@Path("/listAllLostBySearch")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Lost>  listAllLostBySearch(Search search);
    
    @POST
   	@Path("/listAllLostSearch")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Lost>  listAllLostSearch(Search search);
    
    @POST
   	@Path("/listAllGetSearch")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Lost>  listAllGetSearch(Search search);
    
    @POST
   	@Path("/listAllUpSearch")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Lost>  listAllUpSearch(Search search);
    
    /**
     * 分页查询遗失物品信息
     * @param search
     * @return
     */
    @POST
   	@Path("/listPageAllLost")
    @Produces(MediaType.APPLICATION_JSON)
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    PageRestful  listPageAllLost(Lost lost);
    
    /**
     * 查询待领取的拾到的物品和待归还的遗失的物品
     * @return
     */
    @GET
  	@Path("/listAllCount")
  	@Produces(MediaType.APPLICATION_JSON)
    String listAllCount();
    
}
