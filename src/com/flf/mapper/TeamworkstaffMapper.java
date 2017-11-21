package com.flf.mapper;

import com.flf.entity.Project;
import com.flf.entity.Staff;
import com.flf.entity.Teamworkstaff;

import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;


public interface TeamworkstaffMapper {
	int deleteTeamworkstaff(String id);

    void insertTeamworkstaff(Teamworkstaff teamworkstaff);   //团队人员编制岗位项目关系表新增功能接口

    /*List<Teamworkstaff> listPageTeamworkstaff(Teamworkstaff teamworkstaff);*/
    
    List<Teamworkstaff> listAllTeamworkstaff();

    Teamworkstaff getTeamworkstaffbyId(String id);

    int updateTeamworkstaff(Teamworkstaff teamworkstaff);
    
    List<Teamworkstaff> getTeamworkstaffbyStaffId(String staffId); //根据员工id查询员工团队关联表信息
    
    Teamworkstaff getTeamworkstaffbyStaffId_one(String staffId); //根据员工id查询员工团队关联表信息
    
    List<Teamworkstaff> getTeamworkstaffbyTeamworkId(String TeamworkId); //根据团队id查询员工团队关联表信息
    
    List<Teamworkstaff> listTeanworkstaffbyTeamworkId(String TeamworkId); //根据团队id查询该团队所管理的项目和岗位对应的人数
    
    void insertListTeamworkstaff(List<Teamworkstaff> teamworkstaffs);
    
    List<Teamworkstaff> listTeamworkstaffbyPostId (String postId); //根据岗位id查询对应岗位员工信息
    
    List<Teamworkstaff> listTeanmworkstaffbyProject(Teamworkstaff teamworkstaff); //查询各项目的核心岗位的人员信息
    
    List<Teamworkstaff> listTeanmworkstaffByListpostId(List<String> postId); //根据多个岗位id查询Teamworkstaff对象
    
    List<Teamworkstaff> listTeamworkstaffPostAndStaff(); //查询核心岗位的人员信息
    
    int staffCount(String project,String specialtyInfoId);//查询当前项目的当前专业线下的总人数
    
    int AddStaffPrepare(Map<String, Object> map);//向编制中添加员工

	int staffCountByPrepareId(String prepareId);//通过编制id查询属于该编制下已有的员工数量
	
	List<Teamworkstaff> getTeamworkstaffbyProjectAndSpecial(String projectId,String specialId);//通过项目id和专业线id获取
	
	List<Teamworkstaff> listPageTeamworkStaff(Teamworkstaff teamworkstaff); //分页查询专业线下员工信息
	
	List<Teamworkstaff> getStaffPostById(String staffId);//根据员工id查询岗位信息

	int staffCountForPrepare(String projectId, String specialtyId);//查询项目某专业线下已分配了员工的编制 数量 
	
	int getCountByTeamworkId(String teamworkId);
	
	int deleteByTeamworkId(String teamworkId);//根据团队id删除编制
	
	int deleteMember(Teamworkstaff teamworkstaff);//根据团队id和员工id删除数据    王洲    2016.1.27

	int isFenpei(String staffId, String postId, String prepareId);
	
	//根据团队id，项目id，岗位id查询此团队在此项目专业线下分配的人数    王洲    2016.1.29
	List<Teamworkstaff> getListByTeamworkIdAndProjectIdAndPostId(String teamworkId, String projectId, String postId);
	
	//根据团队id、员工id获得员工信息    王洲    2016.1.29
	List<Teamworkstaff> getListStaffByTeamworkIdAndStaffId(String teamworkId, String staffId);
	
	//修改团队成员信息  王洲  2016.1.29
	int updateTeamworkStaffs(Teamworkstaff teamworkstaff);
	
	List<Teamworkstaff> getFenpeiguanxi(String postId,String spcialtyId,String projectId);
	
	List<Teamworkstaff> getPostyuangongxinxi(String postId,String spcialtyId,String projectId);

	void shanchuTeamworkstaff(String teamworkstaffId);//删除员工岗位团队关系数据
	
	List<Staff> getStaffByTeamworkId(String teamworkId);
	
	List<Teamworkstaff> getProjectByStaffId(String staffId);
	

}