package com.flf.service;
/**
 * 创建 by xiaocong   
 * date   2015-6-16
 */
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Intake;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.request.HouseNewResult;
import com.flf.request.IntakeResult;
@Path(value="/Intake")
public interface IntakeService {
	/*List<Intake> listAllIntake();
    List<Intake> listPageIntake(Intake Intake);
    Intake getIntakeById(String id);
    //int deleteIntake(int id);
    int insertIntake(Intake Intake);
    int updateIntake(Intake Intake);*/
	
	/**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 分页条件查询入伙信息
	 */  
	
    @POST
  	@Path("/listPageIntakeRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageIntakeRestful(Intake intake);
    
    /**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 查询所有入伙信息
	 */ 
    
    @GET
  	@Path("/listAllIntakeRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Intake> listAllIntakeRestful();
    
    /**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 通过入伙id查询入伙信息
	 */ 
    
    @GET
  	@Path("/getIntakeByIdRestful/{intakeId}")
  	@Produces(MediaType.APPLICATION_JSON)
    Intake getIntakeByIdRestful(@PathParam("intakeId") String intakeId);
    
    /**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 通过入伙id删除入伙信息
	 */ 
    
    @DELETE
   	@Path("/deleteIntakeRestful/{intakeId}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteIntakeRestful(@PathParam("intakeId") String intakeId);
    
    /**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 增加入伙信息
	 */ 
    
    @POST
   	@Path("/insertIntakeRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertIntakeRestful(Intake intake);
    
    /**
	 * 创建 by xiaocong   
	 * date   2015-6-16
	 * 修改入伙信息
	 */ 
    
    @PUT
   	@Path("/updateIntakeRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateIntakeRestful(Intake intake);
    
    @POST
   	@Path("listAllIntakeBySearch")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   	@Produces(MediaType.APPLICATION_JSON)
    List<Intake> listAllIntakeBySearch(Search search);
    
    @POST
   	@Path("/insertIntakesRestful")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    void insertIntakesRestful(IntakeResult intakeResult);
    
    
    /**
     * 入伙初始化
     * @param intakeResult
     */
    @POST
   	@Path("/insertIntakes")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    void insertIntakes(Intake intake);
}

