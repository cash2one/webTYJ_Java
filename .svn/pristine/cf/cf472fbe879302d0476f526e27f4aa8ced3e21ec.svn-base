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

import com.flf.entity.Post;

@WebService
@Path(value = "/Post")
public interface PostService {
	List<Post> listPostAll();   //查询所有岗位
	
	@GET
	@Path("/getPostById/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	Post getPostById(@PathParam("postId")String postId); //根据id查询岗位信息
	
	int insertPost(Post post); //添加岗位信息
	int deletePost(String id);//删除岗位信息
	
	/**
	 * 查询核心岗位
	 * @return
	 */
	@GET
	@Path("/listPostbyState")
	@Produces(MediaType.APPLICATION_JSON)
	List<Post> listPostbyState();
	
	@GET
	@Path("/listPostCore")
	@Produces(MediaType.APPLICATION_JSON)
	List<Post> listPostCore();
	
	//获取项目下的专业线下的岗位
	@GET
	@Path("/listPostsByProjectIdAndSpecialtyId/{projectId}/{specialtyId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Post> listPostsByProjectIdAndSpecialtyId(@PathParam("projectId")String projectId,@PathParam("specialtyId")String specialtyId);
	
	
	/**
	 * 开启岗位
	 * @return
	 */
	@PUT
	@Path("/updatePost")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updatePost(Post post);
	
	
	/**
	 * 查询岗位所具有的操作权限和功能权限
	 * 
	 */
	@GET
	@Path("/selectActionPermissions/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Post> selectActionPermissions(@PathParam("postId")String postId);
	
	/**
	 * 查询用户团队管理的岗位
	 * zhuqi 2016.03.08
	 * @param staffId
	 * @return List<Post>
	 */
	@POST
	@Path("/listTeamPost/{staffId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<Post> listTeamPost(@PathParam("staffId") String staffId);
	
	@GET
	@Path("/getPostByName/{postName}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	Post getPostByName(@PathParam("postName") String postName);
	
}
