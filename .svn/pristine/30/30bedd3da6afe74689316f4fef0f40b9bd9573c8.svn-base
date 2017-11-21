package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.Post;
import com.flf.entity.Staff;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.service.PostService;

@WebService
public class PostServiceImpl implements PostService {

	private PostMapper postMapper;
	
	private TeamworkstaffMapper teamworkstaffMapper;
	
	private StaffMapper staffMapper;
	
	private PrepareMapper prepareMapper;
	
	public TeamworkstaffMapper getTeamworkstaffMapper() {
		return teamworkstaffMapper;
	}

	public void setTeamworkstaffMapper(TeamworkstaffMapper teamworkstaffMapper) {
		this.teamworkstaffMapper = teamworkstaffMapper;
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	public PostMapper getPostMapper() {
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public PrepareMapper getPrepareMapper() {
		return prepareMapper;
	}

	public void setPrepareMapper(PrepareMapper prepareMapper) {
		this.prepareMapper = prepareMapper;
	}

	@Override
	public List<Post> listPostAll() {
		// TODO 自动生成的方法存根
		return postMapper.listPostAll();
	}

	@Override
	public Post getPostById(String id) {
		// TODO 自动生成的方法存根
		return postMapper.getPostById(id);
	}

	@Override
	public int insertPost(Post post) {
		return postMapper.insertPost(post);
	}

	@Override
	public int deletePost(String id) {
		return postMapper.deletePost(id);
	}

	@Override
	public void updatePost(Post post) {
		postMapper.updatePostByState(post);
	}

	@Override
	public List<Post> listPostbyState() {
		return postMapper.listPostbyState();
	}

	@Override
	public List<Post> listPostCore() {
		List<Post> postList = new ArrayList<Post>();
		//查询出所有的核心岗位
		List<Post> pList = postMapper.getPostbyCore();
		if(pList != null && pList.size() > 0)
		{
		for(Post p:pList){
			if(p.getPostId() != null){
			List<String> sList = new ArrayList<String>();
			//根据岗位id查询出所有的人
			List<Teamworkstaff> twsList = teamworkstaffMapper.listTeamworkstaffbyPostId(p.getPostId());
			if(twsList != null && twsList.size() > 0){
				for(Teamworkstaff ts:twsList){
					if(ts.getStaffId() != null){
						sList.add(ts.getStaffId());
					}
				}
				
			List<Staff> staffList = staffMapper.listStaffByListpostId(sList);
			if(staffList != null &&staffList.size() > 0){
			p.setStaffList(staffList);
			postList.add(p);
			}
			}
			}
		}
		}
		return postList;
	}

	@Override
	public List<Post> listPostsByProjectIdAndSpecialtyId(String projectId,
			String specialtyId) {
		List<Post> postList = postMapper.listPostsByProjectIdAndSpecialtyId(projectId, specialtyId);
		//得出每个岗位空缺的人数
		for(Post post : postList){
			//获得岗位在项目下的最大编制
			int maxnum = prepareMapper.getMaxNumByProjectAndPostId(projectId, post.getPostId());
			//获取现有编制数量
			Teamworkstaff tws = new Teamworkstaff();
			tws.setPostId(post.getPostId());
			tws.setProjectId(projectId);
			int nownum = teamworkstaffMapper.listTeanmworkstaffbyProject(tws).size();
			post.setPostNum(maxnum-nownum);
			post.setProjectId(projectId);
		}
		return postList;
	}

	@Override
	public List<Post> selectActionPermissions(String postId) {
		// TODO Auto-generated method stub
		return postMapper.selectActionPermissions(postId);
	}
	
	@Override
	public List<Post> listTeamPost(String staffId){
		return postMapper.listTeamPostByStaffId(staffId);
	}

	@Override
	public Post getPostByName(String postName) {
		return postMapper.getPostByName(postName);
	}
}
