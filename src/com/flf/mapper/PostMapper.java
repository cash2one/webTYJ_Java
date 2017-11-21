package com.flf.mapper;

import java.util.List;

import com.flf.entity.Post;

public interface PostMapper {
	
  List<Post> listPostAll();   //查询所有岗位
  Post getPostById(String id); //根据id查询岗位信息
  int insertPost(Post post); //添加岗位信息
  int deletePost(String id);//删除岗位信息
  int updatePost(Post post); //修改岗位信息
  int updatePostByState(Post post);
  //将不在postIds内的post对象state置零 fansensen 2015/8/26
  int updatePostReverse(Post post);
  List<Post> listPostbyState();  //查询核心岗位信息
  List<Post> listPostsBystaffId(String staffId);//根据员工id查询核心岗位
  List<Post> getPostbyCore();
  List<Post> listPostsByProjectIdAndSpecialtyId(String projectId,String specialtyId);//获取项目下的专业线下的岗位

  List<Post> selectActionPermissions(String postId);//查询岗位所具有的操作权限和功能权限
  
  List<Post> getPostByStaffId(String staffId);//根据员工id查询关联的岗位
  
  List<Post> listCorePostByStaffId(String staffId);//根据员工id查询关联的核心岗位集合  王洲  2016.03.06
  
  /**
   * 查询用户团队管理的岗位
   * zhuqi 2016.03.08
   * @param staffId
   * @return List<Post>
   */
  List<Post> listTeamPostByStaffId(String staffId);
  
  /**
   * 通过名称查询id
   * @author chenqiuxu
   * @param postName
   * @return
   */
  Post getPostByName(String postName);
  
  /**
   * 通过专业线id查询
   * @param specialtyId
   * @return
   */
  List<Post> getPostBySpecialtyId(String specialtyId);
  
  List<Post> getPostSpecialtyByStaffId(String staffId);//根据员工id查询岗位和专业线名
  
}
