package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.PageRestful;
import com.flf.entity.Post;
import com.flf.entity.Prepare;
import com.flf.entity.Staff;
import com.flf.entity.TRole;
import com.flf.entity.TUserRole;
import com.flf.entity.Teamwork;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.HrAuthorityMapper;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TRoleMapper;
import com.flf.mapper.TUserMapper;
import com.flf.mapper.TUserRoleMapper;
import com.flf.mapper.TeamworkMapper;
import com.flf.mapper.TeamworkStaffRoleMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.request.PrepareResult;
import com.flf.request.TeamworkstaffResult;
import com.flf.service.TeamworkstaffService;
import net.sf.json.JSONArray;

public class TeamworkstaffServiceImpl implements TeamworkstaffService {
	@Autowired
	private TeamworkstaffMapper teamworkstaffMapper;
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private PrepareMapper prepareMapper;
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TUserRoleMapper tUserRoleMapper;
	@Autowired
	private TRoleMapper tRoleMapper;
	@Autowired
	private TeamworkMapper teamworkMapper;
	@Autowired
	private StaffMapper staffMapper;
	@Autowired
	private HrAuthorityMapper hrAuthorityMapper;
	@Autowired
	private TeamworkStaffRoleMapper teamworkStaffRoleMapper;

	/*@Override
	public List<Teamworkstaff> listPageTeamworkstaff(Teamworkstaff teamworkstaff) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.listPageTeamworkstaff(teamworkstaff);
	}*/

	@Override
	public Teamworkstaff getTeamworkstaffByIdRest(String id) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.getTeamworkstaffbyId(id);
	}
	@Override
	public List<Teamworkstaff> getTeamworkstaffbyTeamworkId(String teamworkId) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.getTeamworkstaffbyTeamworkId(teamworkId);
	}

	@Override
	public void UpdateTeamworkstaff(Teamworkstaff teamworkstaff) {
		// TODO Auto-generated method stub
		teamworkstaffMapper.updateTeamworkstaff(teamworkstaff);
	}

	@Override
	public void DeleteTeamworkstaffById(String id) {
		// TODO Auto-generated method stub
		teamworkstaffMapper.deleteTeamworkstaff(id);
	}

	@Override
	public List<Teamworkstaff> listAllTeamworkstaff() {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.listAllTeamworkstaff();
	}

	@Override
	public List<Teamworkstaff> listTeanworkstaffbyTeamworkId(String teamworkId) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.listTeanworkstaffbyTeamworkId(teamworkId);
	}

/*	@Override
	public void insertListTeamworkstaff(TeamworkstaffResult teamworkstaffResult) {
		teamworkstaffMapper.insertListTeamworkstaff(teamworkstaffResult.getTeamworkstaffs());
	}*/

	
	
	
//	@Override
//	public void insertListTeamworkstaffone(TeamworkstaffResult teamworkstaffResult) {
//		// TODO Auto-generated method stub
//		List<Teamworkstaff> teamworkstaffs=teamworkstaffResult.getTeamworkstaffs();
//		
//		Prepare prepare=prepareMapper.getPreparebyIdone(teamworkstaffResult.getPrepareId());
//		Integer num = prepare.getPrepareNum();
//		num=num+teamworkstaffs.size();
//		if(num<=prepare.getPrepareNumber()){
//			teamworkstaffMapper.insertListTeamworkstaff(teamworkstaffs);
//			prepare.setPrepareNum(num);
//			prepareMapper.updatePrepare(prepare);
//		}
//		
//		
//	}
	
	@Override
	public void insertListTeamworkstaff(Teamworkstaff teamworkstaff) {
		
		if(teamworkstaff.getStaffs()!=null){
			for(Staff staff : teamworkstaff.getStaffs()){
				//如果有id就执行删除 zhuqi 2016.03.07
				if(staff.getId()!= null){
					teamworkstaff.setStaffId(staff.getStaffId());
					teamworkstaff.setTeamworkId(staff.getTeamworkId());
					teamworkstaffMapper.deleteMember(teamworkstaff);
					List<TRole> tRoleList = tRoleMapper.selectAllTRole();
					Map<String, String> map = new HashMap<String, String>();
					String userId = tUserMapper.getUserIdByEmployId(staff.getStaffId());
					if(teamworkstaff.getMarkState()!=null && teamworkstaff.getMarkState().equals("1")){
						//删除关联权限
						for (TRole tRole : tRoleList) {
							map.put(tRole.getRoleType(), tRole.getRoleId());
						}
						Map map1 = new HashMap<>();
						map1.put("roleId", map.get("4"));
						map1.put("userId", userId);
						tUserRoleMapper.deleteByPrimaryKey(map1);
					}
					//删除hr_authority表数据
					hrAuthorityMapper.deleteAuthrityByUserIdTeamworkStaffId(userId, 0, teamworkstaff.getTeamworkId());
					continue;
				}
				Teamworkstaff teamworkstaff1=new Teamworkstaff();
				teamworkstaff1.setStaffId(staff.getStaffId());
				teamworkstaff1.setTeamworkId(teamworkstaff.getTeamworkId());
				String uuid=UUID.randomUUID().toString();
				teamworkstaff1.setId(uuid);
				teamworkstaffMapper.insertTeamworkstaff(teamworkstaff1);
			}
		}
	}

	/**
	 * 根据岗位id查询对应岗位员工信息
	 * @param id
	 * @return
	 */
	@Override
	public List<Teamworkstaff> listTeamworkstaffbyPostId(String postId) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.listTeamworkstaffbyPostId(postId);
	}

	
	/**
	 * 查询各项目的核心岗位的人员信�?
	 * @param teamworkstaff
	 * @return
	 */
	@Override
	public List<Teamworkstaff> listTeanmworkstaffbyProject(
			Teamworkstaff teamworkstaff) {
		// TODO Auto-generated method stub
		List<Teamworkstaff> teamworkstaffs=new ArrayList<Teamworkstaff>();
		List<Post> post=postMapper.listPostbyState();
		for (Post post1 : post) {
			teamworkstaff.setPostId(post1.getPostId());
			teamworkstaffs.addAll(teamworkstaffMapper.listTeanmworkstaffbyProject(teamworkstaff));
		}
		return teamworkstaffs;
	}
	
	
	@Override
	public void AddTeamworkstaff(Teamworkstaff teamworkstaff) {
		// TODO Auto-generated method stub
		if(teamworkstaff.getStaffs()!=null){
			for (Staff staff : teamworkstaff.getStaffs()) {
				String uuid1=UUID.randomUUID().toString();
				teamworkstaff.setId(uuid1);
				teamworkstaff.setStaffId(staff.getStaffId());
				teamworkstaffMapper.insertTeamworkstaff(teamworkstaff);
			}
		}else{
			String uuid=UUID.randomUUID().toString();
			teamworkstaff.setId(uuid);
			teamworkstaffMapper.insertTeamworkstaff(teamworkstaff);
		}
	}
	
	@Override
	public List<Teamworkstaff> getTeamworkstaffbyStaffId(String staffId, String teamworkId) {
		//修改查询方法，因同一员工可能有多个团队，故根据员工id查询出的结果由对象改为集合 王洲 2016.1.18
		List <Teamwork> teamworkList = teamworkMapper.getTeamworkbyLeader(staffId);
		List<Teamworkstaff> teamworkstaffss=new ArrayList<Teamworkstaff>();
		for(Teamwork teamwork : teamworkList){
			if(teamwork.getId() != null){
				teamworkstaffss=new ArrayList<Teamworkstaff>(teamworkstaffMapper.getTeamworkstaffbyTeamworkId(teamwork.getId()));
			}
		}
		//遍历 查询每个团队成员是团队操作员 朱琪 2016-2-17
		for (Teamworkstaff teamworkstaff : teamworkstaffss) {			
			//查询userId
			String userId = tUserMapper.getUserIdByEmployId(teamworkstaff.getStaffId());
			if (userId != null){
				Map map = new HashMap();
				map.put("userId", userId);
				List<TUserRole> tUserRole = tUserRoleMapper.getTUserRoleByMap(map);
					if (tUserRole != null && tUserRole.size() > 0){
						for (TUserRole tur : tUserRole) {
							String roleType = tRoleMapper.getRoleTypeByRoleId(tur.getRoleId());
							if (roleType.equals("4")){
								//是否为团队中的操作员
								if(teamworkId != null){
									Map map1 = new HashMap<>();
									map1.put("staffId", teamworkstaff.getStaffId());
									map1.put("roleId", tRoleMapper.getTRoleByRoleType("4").getRoleId());
									map1.put("teamworkId", teamworkId);
									int s = teamworkStaffRoleMapper.findCountByMap(map1);
									if(s > 0){
										teamworkstaff.setMarkState("1");
										break;
									}else{
										teamworkstaff.setMarkState("0");
									}
								}
								teamworkstaff.setMarkState("0");
							} else {
								teamworkstaff.setMarkState("0");
							}
						}
					} else {
						teamworkstaff.setMarkState("0");
					}	
			} else {
				teamworkstaff.setMarkState("0");
			}
			
		}
		
		return teamworkstaffss;
	}

	@Override
	public void prepareAddStaff(PrepareResult prepareResult) {
		/*Map<String,Object> map=new HashMap<String,Object>();
		map.put("postId", prepareResult.getPost().getPostId());//岗位id
		map.put("projectId", prepareResult.getProjectId());//项目id
		if(prepareResult.getStaffs().size()>0){
			map.put("list", prepareResult.getStaffs());//员工集合
			teamworkstaffMapper.AddStaffPrepare(map);//向编制中添加员工
		}*/
		//获取团队id
		String teamworkId = prepareResult.getTeamworkId();
		//获取项目id
		String projectId = prepareResult.getProjectId();
		//获取postId
		String postId = prepareResult.getPost().getPostId();
		//生成员工list
		List<Staff> staffs = prepareResult.getStaffs();
		//循环员工list，针对每一个员工进行操作
		List<Teamworkstaff> tws = null;
		List<Teamworkstaff> staffList = null;
		for(int i = 0; i < staffs.size(); i++){
			//根据团队id，员工staffId、项目id、岗位id查询数据
			tws = new ArrayList<Teamworkstaff>();
			tws = teamworkstaffMapper.getListByTeamworkIdAndProjectIdAndPostId(teamworkId, projectId, postId);
			//判断此员工是否已被分配给此岗位，如果已分配，不做操作
			int num = 0;
			for(Teamworkstaff tf : tws){
				if(tf.getStaffId().toString().equals(staffs.get(i).getStaffId().toString())){
					num ++;
				}
			}
			if(num == 0){
				//获取此员工在此团队下有几条数据
				staffList = new ArrayList<Teamworkstaff>();
				staffList = teamworkstaffMapper.getListStaffByTeamworkIdAndStaffId(teamworkId, staffs.get(i).getStaffId().toString());
				if(staffList.size() == 1){
					//只有一条数据时判断此数据有没有岗位信息，有则新增，无则修改
					if(staffList.get(0).getPostId() == "" || staffList.get(0).getPostId() == null){
						staffList.get(0).setPostId(postId);
						staffList.get(0).setProjectId(projectId);
						teamworkstaffMapper.updateTeamworkStaffs(staffList.get(0));
					}else{
						Teamworkstaff toAdd = new Teamworkstaff();
						toAdd.setId(UUID.randomUUID().toString());
						toAdd.setTeamworkId(teamworkId);
						toAdd.setStaffId(staffs.get(i).getStaffId().toString());
						toAdd.setPostId(postId);
						toAdd.setProjectId(projectId);
						toAdd.setPrepareId(prepareMapper.getPrepareByProjectIdAndPostId(projectId, postId).getPrepareId());
						toAdd.setProfessionalLineId(postMapper.getPostById(postId).getProfessionalLineId());
						teamworkstaffMapper.insertTeamworkstaff(toAdd);
					}
				}else{
					//多条数据时新增一条数据
					Teamworkstaff toAdd = new Teamworkstaff();
					toAdd.setId(UUID.randomUUID().toString());
					toAdd.setTeamworkId(teamworkId);
					toAdd.setStaffId(staffs.get(i).getStaffId().toString());
					toAdd.setPostId(postId);
					toAdd.setProjectId(projectId);
					toAdd.setPrepareId(prepareMapper.getPrepareByProjectIdAndPostId(projectId, postId).getPrepareId());
					toAdd.setProfessionalLineId(postMapper.getPostById(postId).getProfessionalLineId());
					teamworkstaffMapper.insertTeamworkstaff(toAdd);
				}
			}
		}
	}
	@Override
	public int staffCountByPrepareId(String prepareId) {
		// TODO Auto-generated method stub
		return teamworkstaffMapper.staffCountByPrepareId(prepareId);
	}


	@Override
	public List<Teamworkstaff> listTeamworkstaffPostAndStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teamworkstaff> getTeamworkstaffbyProjectAndSpecial(
			String projectId, String specialId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertListTeamworkstaffone(TeamworkstaffResult teamworkstaffResult) {
		List<Staff> staff = new ArrayList<Staff>();
		List<Teamworkstaff> teamworkstaff = new ArrayList<Teamworkstaff>();
		String teamworkId = teamworkstaffResult.getTeamworkstaffs().get(0).getTeamworkId();
		if(teamworkId !=null || teamworkId.equals("")){
			staff = teamworkstaffMapper.getStaffByTeamworkId(teamworkId);
		}
		for (int i = 0; i < teamworkstaffResult.getTeamworkstaffs().size(); i++) {
			int j = 0, k = staff.size();
			for (; j < staff.size(); j++) {
				if(teamworkstaffResult.getTeamworkstaffs().get(i).getStaffId().equals(staff.get(j).getStaffId())){
					staff.remove(j);
					j--;
				}
			}
			if(j == k){
				teamworkstaff.add(teamworkstaffResult.getTeamworkstaffs().get(i));
			}
		}
		
		for (Staff Staff1 : staff) {
			Teamworkstaff teamworkstaffs = new Teamworkstaff(); 
			teamworkstaffs.setStaffId(Staff1.getStaffId());
			teamworkstaffs.setTeamworkId(teamworkId);
			teamworkstaffMapper.deleteMember(teamworkstaffs);
		}
		if(teamworkstaff.size() != 0){
			teamworkstaffMapper.insertListTeamworkstaff(teamworkstaff);
		}
	}

	@Override
	public PageRestful listPageTeamworkStaff(Teamworkstaff teamworkstaff) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Teamworkstaff> teamworkstaffs=teamworkstaffMapper.listPageTeamworkStaff(teamworkstaff);
		teamworkstaffs.add(0,null);
		pagerestful.setTeamworkStaffs(teamworkstaffs);
		pagerestful.setPage(teamworkstaff.getPage());
		return pagerestful;
	}
	
	@Override
	public List<Staff> getStaffNotInTeam(String staffId){
		//获取teamworkstaff表中的所有数据
 		List<Staff> temp = staffMapper.getStaffInTeamworkStaff();
 		List<Staff> temps = new ArrayList<Staff>();
 		List<Staff> allStaff = new ArrayList<Staff>();
		for(Staff staff : temp){
			if(!staff.getStaffId().equals(staffId)){
				temps.add(staff);
			}
		}
		//获取该经理下的所有成员
		List<Staff> teamworkStaff = staffMapper.listTeamWorkStaffBystaffId(staffId);
		for(Staff staff : temps){
			int i = 0;
			for(Staff staffs : teamworkStaff){
				if(staff.getStaffId().equals(staffs.getStaffId())){
					i ++;
				}
			}
			if(i == 0){
				allStaff.add(staff);
			}
		}
		return allStaff;
	}
	
	/**
	 * 删除团队成员
	 * 王洲
	 * 2016.1.27
	 */
	@Override
	public void deleteMember(Teamworkstaff teamworkstaff){
		teamworkstaffMapper.deleteMember(teamworkstaff);
	}
	
	@Override
	public String isFenpei(String staffId, String postId, String prepareId) {
		// TODO Auto-generated method stub
		int count=teamworkstaffMapper.isFenpei(staffId,postId,prepareId);
		if(count>0){
			return "true";
		}
		return "false";
	}

	@Override
	public String getFenpeiguanxi(String postId,String spcialtyId, String projectId) {
		// TODO Auto-generated method stub
		List<Prepare> prepares=prepareMapper.listAllSearchPrepare(projectId,spcialtyId);
		List dataList=new ArrayList();
		for(Prepare prepare:prepares){
			List<Staff> staffs=new ArrayList<Staff>();
			Map map=new HashMap();
			String myPostId=prepare.getPostId();
			int count=0;
			List<Teamworkstaff> teamworkstaffs=teamworkstaffMapper.getFenpeiguanxi(myPostId,spcialtyId,projectId);
			for(Teamworkstaff teamworkstaff:teamworkstaffs){
				count=teamworkstaff.getPrepare().getPrepareNumber();
				if(myPostId.equals(teamworkstaff.getPostId())){
					staffs.add(teamworkstaff.getStaff());
					map.put("prepareNum",count);//编制人数
					map.put("postName", teamworkstaff.getPost().getNameOfCustom());
				}
			}
			map.put("postId", myPostId);
			map.put("postNum",staffs.size());//岗位在变人数
			map.put("staffs", staffs);//岗位在编人员信息
			dataList.add(map);
		}
		
		return JSONArray.fromObject(dataList).toString();
	}

	@Override
	public List<Teamworkstaff> getPostyuangongxinxi(String postId, String spcialtyId,String projectId) {		
		return teamworkstaffMapper.getPostyuangongxinxi(postId,spcialtyId,projectId);
	}

	@Override
	public String shanchuTeamworkstaff(String teamworkstaffId) {
		teamworkstaffMapper.shanchuTeamworkstaff(teamworkstaffId);
		return "200";
	}
	
	@Override
	public List<Teamworkstaff> getProjectByStaffId(String staffId){
		return teamworkstaffMapper.getProjectByStaffId(staffId);
	}
}
