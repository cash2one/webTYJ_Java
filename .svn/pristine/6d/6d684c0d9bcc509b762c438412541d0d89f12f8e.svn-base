package com.flf.mapper;

import com.flf.entity.Search;
import com.flf.entity.Staff;
import com.flf.entity.Teamwork;
import com.flf.entity.Teamworkstaff;

import java.util.List;
import java.util.Map;

public interface TeamworkMapper {
	int deleteTeamwork(String id);

    int insertTeamwork(Teamwork teamwork);
    
    Integer countStaffByTeamworkId(String id);//根据teamworkID获取成员人数
    
    //根据实例id查询团队信息
    List<Teamwork> listTeamworkbyinstanceId(String instanceId);
    
    //根据经理名称查询所有团队
    List<Teamwork> getTeamworkbyLeader(String leader);

    List<Teamwork> listPageTeamwork(Teamwork teamwork);
    
    List<Teamwork> listAllTeamwork();

    Teamwork getTeamworkbyId(String id);

    int updateTeamwork(Teamwork teamwork);

    List<Teamwork> getTeamworkIdBySearch(String projectId,String specialtyId);//通过项目id和专业线id查询团队信息

	List<Teamwork> getTeamworkBystaffId(String staffId);
	
	Teamworkstaff getStaffBystaffIdOrId(Map map);
	
	 List<Teamwork> listPageTeamworks(Teamwork teamwork);//分页查询团队信息
	 
	 int insertTeamworkUUID(Teamwork teamwork);
	 
	 List<Teamwork> getChildTeam();//查询所有子团队信息
	 
     Teamwork   getTeamworkbyCoreId(String coreId);//根据核心岗位id查找团队
	 
	 int deleteTeamworkByCoreId(String coreId);//根据岗位核心id删除
	 
	 /**
	  * 根据Staffid获取关联岗位数
	  * zhuqi 2016.03.08
	  * @param map
	  * @return int
	  */
	 int getNumberByMap(Map map);
	 
	 /**
	  * 根据员工Id获取团队Id
	  * zhuqi 2016.03.28
	  * @param StaffId
	  * @return TeamworkId
	  */
	 String getTeamworkIdByStaffId(String StaffId);
}