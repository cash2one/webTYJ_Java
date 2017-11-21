package com.flf.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.flf.entity.AcceptanceOrders;
import com.flf.entity.AppealOrders;
import com.flf.entity.CentralizedProcessingRecords;
import com.flf.entity.CheckOrders;
import com.flf.entity.ClaimToCustomerOrders;
import com.flf.entity.ClosedOrders;
import com.flf.entity.CompensateOwner;
import com.flf.entity.ComplaintOrders;
import com.flf.entity.ConstructionAcceptanceOrders;
import com.flf.entity.ConstructionCheckOrders;
import com.flf.entity.ConstructionInspectionOrders;
import com.flf.entity.ConsultationOrders;
import com.flf.entity.DepartmentOrders;
import com.flf.entity.DisposeOrder;
import com.flf.entity.FixedParkingOrders;
import com.flf.entity.Friends;
import com.flf.entity.HouseNew;
import com.flf.entity.InspectorOrder;
import com.flf.entity.MeterReadingOrders;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Post;
import com.flf.entity.PraiseOrders;
import com.flf.entity.QuoteOrders;
import com.flf.entity.RenovationAcceptanceOrders;
import com.flf.entity.RenovationCheckOrders;
import com.flf.entity.RenovationInspectionOrders;
import com.flf.entity.RepairOrders;
import com.flf.entity.ReturnVisitOrders;
import com.flf.entity.ServiceRequest;
import com.flf.entity.SettleAccountsOrders;
import com.flf.entity.Staff;
import com.flf.entity.TaskTurnSpecialRecords;
import com.flf.entity.Tasks;
import com.flf.entity.TasksJournal;
import com.flf.entity.WaterMeterOrders;
import com.flf.mapper.AcceptanceOrdersMapper;
import com.flf.mapper.AppealOrdersMapper;
import com.flf.mapper.CentralizedProcessingRecordsMapper;
import com.flf.mapper.CheckOrdersMapper;
import com.flf.mapper.ClaimToCustomerOrdersMapper;
import com.flf.mapper.ClosedMapper;
import com.flf.mapper.CompensateOwnerMapper;
import com.flf.mapper.ComplaintOrdersMapper;
import com.flf.mapper.ConstructionAcceptanceOrdersMapper;
import com.flf.mapper.ConstructionCheckOrdersMapper;
import com.flf.mapper.ConstructionInspectionOrdersMapper;
import com.flf.mapper.ConsultationOrdersMapper;
import com.flf.mapper.DepartmentOrdersMapper;
import com.flf.mapper.DisposeOrderMapper;
import com.flf.mapper.FixedParkingOrdersMapper;
import com.flf.mapper.FriendsMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.InspectorOrderMapper;
import com.flf.mapper.MeterReadingOrdersMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PraiseOrdersMapper;
import com.flf.mapper.QuoteOrdersMapper;
import com.flf.mapper.RenovationAcceptanceOrdersMapper;
import com.flf.mapper.RenovationCheckOrdersMapper;
import com.flf.mapper.RenovationInspectionOrdersMapper;
import com.flf.mapper.RepairOrdersMapper;
import com.flf.mapper.ReturnVisitOrdersMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.SettleAccountsOrdersMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TaskTurnSpecialRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.TasksMapper;
import com.flf.mapper.WaterMeterOrdersMapper;
import com.flf.service.PropertyAppService;
import com.flf.util.JsonUtil;
import com.flf.util.JsonUtils;
import com.flf.util.Tools;
import com.google.gson.JsonObject;

public class PropertyAppServiceImpl implements PropertyAppService {

	@Autowired
	TasksMapper tasksMapper;
	@Autowired
	TaskTurnSpecialRecordsMapper taskTurnSpecialRecordsMapper;
	@Autowired
	TasksJournalMapper tasksJournalMapper;
	@Autowired
	CentralizedProcessingRecordsMapper centralizedProcessingRecordsMapper;
	@Autowired
	ServiceRequestMapper serviceRequestMapper;
	@Autowired
	StaffMapper staffMapper;
	@Autowired
	PersonCustNewMapper personCustNewMapper;
	@Autowired
	FriendsMapper friendsMapper;
	@Autowired
	ComplaintOrdersMapper complaintOrdersMapper;
	@Autowired
	PostMapper postMapper;
	@Autowired
	HouseNewMapper houseNewMapper;
	@Autowired
	QuoteOrdersMapper quoteOrdersMapper;
	@Autowired
	DisposeOrderMapper disposeOrderMapper;
	@Autowired
	AcceptanceOrdersMapper acceptanceOrdersMapper;
	@Autowired
	CheckOrdersMapper checkOrdersMapper;
	@Autowired
	SettleAccountsOrdersMapper settleAccountsOrdersMapper;
	@Autowired
	CompensateOwnerMapper compensateOwnerMapper;
	@Autowired
	PraiseOrdersMapper praiseOrdersMapper;
	@Autowired
	DepartmentOrdersMapper departmentOrdersMapper;
	@Autowired
	ReturnVisitOrdersMapper returnVisitOrdersMapper;
	@Autowired
	AppealOrdersMapper appealOrdersMapper;
	@Autowired
	WaterMeterOrdersMapper waterMeterOrdersMapper;
	@Autowired
	MeterReadingOrdersMapper meterReadingOrdersMapper;
	@Autowired
	ConsultationOrdersMapper consultationOrdersMapper;
	@Autowired
	FixedParkingOrdersMapper fixedParkingOrdersMapper;
	@Autowired
	RenovationCheckOrdersMapper renovationCheckOrdersMapper;
	@Autowired
	RenovationInspectionOrdersMapper renovationInspectionOrdersMapper;
	@Autowired
	RenovationAcceptanceOrdersMapper renovationAcceptanceOrdersMapper;
	@Autowired
	InspectorOrderMapper inspectorOrderMapper;
	@Autowired
	ConstructionCheckOrdersMapper constructionCheckOrdersMapper;
	@Autowired
	ConstructionInspectionOrdersMapper constructionInspectionOrdersMapper;
	@Autowired
	ConstructionAcceptanceOrdersMapper constructionAcceptanceOrdersMapper;
	@Autowired
	RepairOrdersMapper repairOrdersMapper;
	@Autowired
	ClosedMapper closedMapper;
	@Autowired
	ClaimToCustomerOrdersMapper claimToCustomerOrdersMapper;

	@Override
	public String getTasksbyState2(String staffId, String state1, String state2) {
		try {
			List<Tasks> taskList = tasksMapper.getTasksbyLoginIdAndState(staffId, state1, state2);
			Map map = new HashMap<>();
			map.put("taskList", taskList);
			map.put("size", taskList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String getTasksByState(String staffId, String state) {
		try {
			Tasks tasks = new Tasks();
			tasks.setPrincipal(staffId);
			tasks.setTaskState(Integer.parseInt(state));
			List<Tasks> taskList = tasksMapper.getTasksbyLoginId(tasks);
			Map map = new HashMap<>();
			map.put("taskList", taskList);
			map.put("size", taskList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String getTasksByStates(String staffId, String states) {
		try {
			Map map = new HashMap<>();
			map.put("staffId", staffId);
			String state[];
			state = states.split(",");
			String stateTmp[] = states.split("，");
			if (state.length < stateTmp.length) {
				state = stateTmp;
			}
			if (state.length == 0) {
				return JsonUtil.failure("状态获取失败！", false);
			}
			for (int i = 0; i < state.length; i++) {
				map.put("state" + i, Integer.parseInt(state[i]));
			}
			List<Tasks> taskList = tasksMapper.listTasksByMap(map);
			Map map2 = new HashMap<>();
			map2.put("taskList", taskList);
			map2.put("size", taskList.size());
			return JsonUtil.success(map2, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String listTasksByTypesStates(String staffId, String Types, String States) {
		try {
			Map map = new HashMap<>();
			String type[] = Types.split(",");
			String typeTmp[] = type = Types.split("，");
			if (type.length < typeTmp.length) {
				type = typeTmp;
			}
			if (type.length == 0) {
				return JsonUtil.failure("任务类型获取失败！", false);
			}
			for (int i = 0; i < type.length; i++) {
				map.put("type" + i, Integer.parseInt(type[i]));
			}
			String state[] = States.split(",");
			String stateTmp[] = States.split("，");
			if (state.length < stateTmp.length) {
				state = stateTmp;
			}
			if (state.length == 0) {
				return JsonUtil.failure("任务状态获取失败！", false);
			}
			for (int i = 0; i < state.length; i++) {
				map.put("state" + i, Integer.parseInt(state[i]));
			}
			if (staffId != null && staffId != "") {
				map.put("staffId", staffId);
			}
			List<Tasks> taskList = tasksMapper.listTasksByTypesStates(map);
			Map map2 = new HashMap<>();
			map2.put("taskList", taskList);
			map2.put("size", taskList.size());
			return JsonUtil.success(map2, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String listAllTasks() {
		try {
			List<Tasks> taskList = tasksMapper.listAllTasks();
			Map map = new HashMap<>();
			map.put("taskList", taskList);
			map.put("size", taskList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String listTasksbyStateRestful() {
		try {
			List<Tasks> taskList = tasksMapper.listTasksbyStateRestful();
			Map map = new HashMap<>();
			map.put("taskList", taskList);
			map.put("size", taskList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String getTasksbyStaffId(String staffId) {
		try {
			List<Tasks> taskList = tasksMapper.getTasksbyStaffId(staffId);
			Map map = new HashMap<>();
			map.put("taskList", taskList);
			map.put("size", taskList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败", false);
		}
	}

	@Override
	public String acceptTasks(String staffId, String tasksId) {
		try {
			Tasks tasks = tasksMapper.getTasksbyId(tasksId);
			if (tasks.getTaskState() == 7) {
				tasks.setTaskState(3);
				tasksMapper.updateTasks(tasks);
			} else {
				tasks.setTaskState(3);
				tasks.setPrincipal(staffId);
				tasksMapper.updateTasks(tasks);
			}
			return JsonUtil.success("接受成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("接受失败", false);
		}
	}

	@Override
	public String changeTaskState(String tasksJson) {
		Tasks tasks = JSONObject.parseObject(tasksJson, Tasks.class);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if (tasks != null && Tools.notEmpty(tasks.getTaskId())) {
			Integer state = tasks.getTaskState();
			Integer outType = tasks.getTaskOutType();
			String staffName = tasks.getPrincipal();
			if (tasks.getStaff() != null) {
				if (tasks.getStaff().getStaffId() != null && !tasks.getStaff().getStaffId().equals("")) {
					tasks.setPrincipal(tasks.getStaff().getStaffId());
				}
			}

			if (state != null && state == 8 && tasks.getTurnSpecialRecordsId() != null && !"".equals(tasks.getTurnSpecialRecordsId())) {// 合并
				TaskTurnSpecialRecords tsr = new TaskTurnSpecialRecords();
				tsr.setTaskId(tasks.getTaskId());
				tsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());
				Integer result = taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(tsr);
				if (result > 0) {
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			} else if (state != null && state == 9 && tasks.getTurnSpecialRecordsId() != null && !"".equals(tasks.getTurnSpecialRecordsId())) {// 转专项
				TaskTurnSpecialRecords ttsr = new TaskTurnSpecialRecords();
				ttsr.setTaskId(tasks.getTaskId());
				ttsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());

				tasks.setPrincipal(null);//
				tasks.setSubordinateId(tasks.getTurnSpecialRecordsId());
				tasks.setSubordinateType(1);
				tasks.setSubordinateTime(new Date());

				if (tasksMapper.updateTasks(tasks) > 0 && taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(ttsr) > 0) {
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getSubordinateOperation());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			} else if (state != null && state == 10 && tasks.getProjectId() != null && !"".equals(tasks.getProjectId())) {// 转集中处理
				CentralizedProcessingRecords cpr = new CentralizedProcessingRecords();
				cpr.setTaskId(tasks.getTaskId());
				cpr.setProjectId(tasks.getProjectId());

				tasks.setPrincipal(null);
				tasks.setSubordinateId(tasks.getProjectId());
				tasks.setSubordinateType(2);
				tasks.setSubordinateTime(new Date());

				if (tasksMapper.updateTasks(tasks) > 0 && centralizedProcessingRecordsMapper.insertCentralizedProcessingRecords(cpr) > 0) {
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getSubordinateOperation());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			} else if (state != null && state == 2) {
				tasks.setFinishTime(new Date());
				if (tasksMapper.updateTasks(tasks) > 0) {
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			} else {
				if (tasksMapper.updateTasks(tasks) > 0) {
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					journal.setTaskOutType(outType);
					tasksJournalMapper.insertTasksJournal(journal);

					if (state != null && state == 0) {
						List<Tasks> tasksList = new ArrayList<>();
						tasksList = tasksMapper.getTasksbyServiceRequestId(tasks.getServerId());
						int i = 0, j = 0;
						for (; i < tasksList.size(); i++) {
							// 任务不等于已完成状态
							if (tasksList.get(i).getTaskState() != 2 && tasksList.get(i).getTaskState() != 0) {
								break;
							}
							if (tasksList.get(i).getTaskState() == 2) {
								j++;
							}
						}
						// 任务已是失效以及有完成的任务
						if (i == tasksList.size()) {
							ServiceRequest serviceRequest = new ServiceRequest();
							if (serviceRequest.getServiceRequestIds() == null) {
								serviceRequest.setServiceRequestIds(new ArrayList<String>());
							}
							serviceRequest.getServiceRequestIds().add(tasks.getServerId());
							// 有无完成任务
							if (j == 0) {
								serviceRequest.setServiceRequestState(0);// 无需回访
							} else {
								serviceRequest.setServiceRequestState(1);// 待回访
							}
							serviceRequestMapper.changeServiceRequestStateByIds(serviceRequest);
						}
					}

					return JsonUtil.success("操作成功!", true);
				}
			}
		}
		return JsonUtil.failure("任务不能为空!", true);
	}

	@Override
	public String getTasksJournalbyTasksId(String tasksId) {
		try {
			List<TasksJournal> JournaList = tasksJournalMapper.getTasksJournalbyTasksId(tasksId);
			Tasks tasks = new Tasks();
			tasks = tasksMapper.getAppTasksbyId(tasksId);
			Map map = new HashMap<>();
			map.put("JournaList", JournaList);
			map.put("tasks", tasks);
			map.put("size", JournaList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("查询失败!", true);
		}
	}

	@Override
	public String getTasksByTypeState(String Type, String State) {
		try {
			Tasks tasks = new Tasks();
			tasks.setTaskType(Integer.parseInt(Type));
			tasks.setTaskState(Integer.parseInt(State));
			List<Tasks> tasksList = tasksMapper.getTasksbyTaskAndServiceId(tasks);
			Map map = new HashMap<>();
			map.put("tastList", tasksList);
			map.put("size", tasksList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("操作失败!", true);
		}
	}

	@Override
	public String listStaffByAll(String all) {
		try {
			Staff staff = new Staff();
			staff.setStaffName(all);
			staff.setTelphone(all);
			staff.setStaffNo(all);
			staff.setCardNum(all);
			List<Staff> staffList = staffMapper.listStaffByAll(staff);
			Map map = new HashMap<>();
			map.put("staffList", staffList);
			map.put("size", staffList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("操作失败!", true);
		}
	}

	@Override
	public String listPersonCustByAll(String all) {
		try {
			Map map = new HashMap<>();
			List<PersonCustNew> personCusts = new ArrayList<>();
			personCusts = personCustNewMapper.listPersonCustByAll(all);
			map.put("personCusts", personCusts);
			map.put("size", personCusts.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("操作失败!", true);
		}
	}

	@Override
	public String addFriends(String primaryId, String secondaryId, String type) {
		try {
			List<Friends> friendsList = new ArrayList<>();
			Friends friends = new Friends();
			int result;
			friends.setPrimaryId(primaryId);
			friends.setSecondaryId(secondaryId);
			friendsList = friendsMapper.selectByFriends(friends);
			if (friendsList.size() == 0) {
				friends.setFriendsId(UUID.randomUUID().toString());
				friends.setPrimaryId(primaryId);
				friends.setSecondaryId(secondaryId);
				friends.setFriendsType(type);
				friends.setState("1");
				friends.setCreationTime(new Date());
				result = friendsMapper.insert(friends);
			} else {
				Friends friends1 = new Friends();
				friends.setFriendsId(friendsList.get(0).getFriendsId());
				friends.setState("1");
				result = friendsMapper.updateByPrimaryKeySelective(friends1);
			}
			if (result > 0) {
				return JsonUtil.success("添加成功", true);
			} else {
				return JsonUtil.failure("添加失败!", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("添加失败!", true);
		}
	}

	@Override
	public String failureFriends(String friendsId) {
		try {
			Friends friends = new Friends();
			friends.setFriendsId(friendsId);
			friends.setState("0");
			int result = friendsMapper.updateByPrimaryKeySelective(friends);
			if (result > 0) {
				return JsonUtil.success("删除成功", true);
			} else {
				return JsonUtil.failure("删除失败!", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("删除失败!", true);
		}
	}

	@Override
	public String listFriends(String primaryId, String friendsType) {
		try {
			List<Friends> friendsList = new ArrayList<>();
			Friends friends = new Friends();
			friends.setPrimaryId(primaryId);
			friends.setFriendsType(friendsType);
			friendsList = friendsMapper.selectByPrimaryId(friends);
			Map map = new HashMap<>();
			map.put("friendsList", friendsList);
			map.put("size", friendsList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String getStaffByLoginName(String loginName) {
		try {
			Staff staff = staffMapper.selectStaffByLoginName(loginName);
			Map map = new HashMap<>();
			map.put("staff", staff);
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String listTasksPoolNotStaffId(String staffId) {
		try {
			Map map = new HashMap<>();
			List<Tasks> tasksList = new ArrayList<>();
			Map map1 = new HashMap<>();
			map1.put("staffId", staffId);
			map1.put("time", -30);
			tasksList = tasksMapper.listTasksPoolNotStaffId(map1);
			map.put("tasksList", tasksList);
			map.put("size", tasksList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String customerDetails(String customerId) {
		try {
			Map map = new HashMap<>();
			PersonCustNew personCustNew = personCustNewMapper.getPersonCustNewVIPbyId(customerId);
			Map map2 = new HashMap<>();
			map2.put("customerId", customerId);
			map2.put("type", "1");
			int complaintOrders = complaintOrdersMapper.getCountComplaintOrdersComplete(map2);
			map.put("personCustNew", personCustNew);
			map.put("complaintOrders", complaintOrders);
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String staffDetails(String staffId) {
		try {
			Map map = new HashMap<>();
			List<Post> postList = postMapper.getPostSpecialtyByStaffId(staffId);
			Set set1 = new HashSet<>();
			Set set2 = new HashSet<>();
			for (Post post : postList) {
				set1.add(post.getNameOfCustom());
				set2.add(post.getSpecialtyName());
			}
			Staff staff = staffMapper.selectByidone(staffId);
			map.put("staff", staff);
			map.put("post", set1);
			map.put("specialty", set2);
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String listComplaintOrders(String customerId) {
		try {
			Map map = new HashMap<>();
			Map map2 = new HashMap<>();
			map2.put("customerId", customerId);
			map2.put("type", "1");
			// 未处理
			int inComplaintOrders = complaintOrdersMapper.getCountComplaintOrdersComplete(map2);
			// 已处理
			map2.put("type", "2");
			int notComplaintOrders = complaintOrdersMapper.getCountComplaintOrdersComplete(map2);
			List<ComplaintOrders> complaintOrders = complaintOrdersMapper.getComplaintOrdersComplete(customerId);
			map.put("complaintOrders", complaintOrders);
			map.put("inComplaintOrders", inComplaintOrders);
			map.put("notComplaintOrders", notComplaintOrders);
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String listHouseByCustomerId(String customerId) {
		try {
			Map map = new HashMap<>();
			List<HouseNew> HouseList = houseNewMapper.listHouseByCustomerId(customerId);
			map.put("houseList", HouseList);
			map.put("size", HouseList.size());
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("获取失败!", true);
		}
	}

	@Override
	public String getTasksJournalbyDateandType(String creOrderType, String operationTime) {
		// TODO Auto-generated method stub
		try {
			Map map = new HashMap<>();
			QuoteOrders quoteOrders = null;
			CheckOrders checkOrders = null;
			DisposeOrder disposeOrder = null;
			AcceptanceOrders acceptanceOrders = null;
			SettleAccountsOrders settleAccountsOrders = null;
			CompensateOwner compensateOwner = null;
			PraiseOrders praiseOrders = null;
			DepartmentOrders departmentOrders = null;
			ReturnVisitOrders returnVisitOrders = null;
			AppealOrders appealOrders = null;
			WaterMeterOrders waterMeterOrders = null;
			MeterReadingOrders meterReadingOrders = null;
			ComplaintOrders complaintOrders = null;
			ConsultationOrders consultationOrders = null;
			FixedParkingOrders fixedParkingOrders = null;
			RenovationCheckOrders renovationCheckOrders = null;
			RenovationInspectionOrders renovationInspectionOrders = null;
			RenovationAcceptanceOrders renovationAcceptanceOrders = null;
			InspectorOrder inspectorOrder = null;
			ConstructionCheckOrders constructionCheckOrders = null;
			ConstructionInspectionOrders constructionInspectionOrders = null;
			ConstructionAcceptanceOrders constructionAcceptanceOrders = null;
			RepairOrders repairOrders = null;
			ClosedOrders closedOrders = null;
			ClaimToCustomerOrders claimToCustomerOrders = null;
			if (creOrderType != null && operationTime != null && !"".equals(creOrderType) && !"".equals(operationTime)) {
				TasksJournal journal = tasksJournalMapper.getTasksJournalbyDateandType(creOrderType, operationTime);
				if (journal != null) {
					Integer type = journal.getCreOrderType();
					String creOrderId = journal.getCreOrderId();
					journal = new TasksJournal();
					if (type != null && type == 0 && creOrderId != null && !"".equals(creOrderId)) {// 报价单
						quoteOrders = quoteOrdersMapper.getAppQuoteOrdersbyId(creOrderId);
						quoteOrders.getItemRecords().add(0, null);
						journal.setQuoteOrders(quoteOrders);
					} else if (type != null && type == 1 && creOrderId != null && !"".equals(creOrderId)) {// 处理单
						disposeOrder = disposeOrderMapper.getDisposeOrderbyId(creOrderId);
						disposeOrder.getAnnexs().add(0, null);
						journal.setDisposeOrder(disposeOrder);
					} else if (type != null && type == 2 && creOrderId != null && !"".equals(creOrderId)) {// 验收单
						acceptanceOrders = acceptanceOrdersMapper.getAcceptanceOrdersbyId(creOrderId);
						journal.setAcceptanceOrders(acceptanceOrders);
					} else if (type != null && type == 3 && creOrderId != null && !"".equals(creOrderId)) {// 检测单
						checkOrders = checkOrdersMapper.getCheckOrdersbyId(creOrderId);
						journal.setCheckOrders(checkOrders);
					} else if (type != null && type == 4 && creOrderId != null && !"".equals(creOrderId)) {// 结算单
						settleAccountsOrders = settleAccountsOrdersMapper.getSettleAccountsOrdersById(creOrderId);
						settleAccountsOrders.getSaiRecords().add(0, null);
						journal.setSettleAccountsOrders(settleAccountsOrders);
					} else if (type != null && type == 5 && creOrderId != null && !"".equals(creOrderId)) {// 赔偿给业主
						compensateOwner = compensateOwnerMapper.getCompensateOwnerbyId(creOrderId);
						journal.setCompensateOwner(compensateOwner);
						/***********************************/
					} else if (type != null && type == 6 && creOrderId != null && !"".equals(creOrderId)) {// 部门质检
						departmentOrders = departmentOrdersMapper.getDepartmentOrdersbyId(creOrderId);
						journal.setDepartmentOrders(departmentOrders);
					} else if (type != null && type == 7 && creOrderId != null && !"".equals(creOrderId)) {// 回访单
						returnVisitOrders = returnVisitOrdersMapper.getReturnVisitOrdersbyId(creOrderId);
						journal.setReturnVisitOrders(returnVisitOrders);
					} else if (type != null && type == 8 && creOrderId != null && !"".equals(creOrderId)) {// 申诉单
						appealOrders = appealOrdersMapper.getAppealOrdersbyId(creOrderId);
						journal.setAppealOrders(appealOrders);
					} else if (type != null && type == 9 && creOrderId != null && !"".equals(creOrderId)) {// 抄水表
						waterMeterOrders = waterMeterOrdersMapper.getWaterMeterOrdersbyId(creOrderId);
						waterMeterOrders.getWaterMeterOrderRecordsList().add(0, null);
						journal.setWaterMeterOrders(waterMeterOrders);
					} else if (type != null && type == 10 && creOrderId != null && !"".equals(creOrderId)) {// 抄电表
						meterReadingOrders = meterReadingOrdersMapper.getMeterReadingOrdersbyId(creOrderId);
						journal.setMeterReadingOrders(meterReadingOrders);
					} else if (type != null && type == 11 && creOrderId != null && !"".equals(creOrderId)) { // 投诉表
						complaintOrders = complaintOrdersMapper.getComplaintOrdersbyId(creOrderId);
						journal.setComplaintOrders(complaintOrders);
					} else if (type != null && type == 12 && creOrderId != null && !"".equals(creOrderId)) { // 咨询表
						consultationOrders = consultationOrdersMapper.getConsultationOrdersbyId(creOrderId);
						journal.setConsultationOrders(consultationOrders);
					} else if (type != null && type == 13 && creOrderId != null && !"".equals(creOrderId)) { // 固定工单表
						fixedParkingOrders = fixedParkingOrdersMapper.getFixedParkingOrdersbyId(creOrderId);
						journal.setFixedParkingOrders(fixedParkingOrders);
					} else if (type != null && type == 14 && creOrderId != null && !"".equals(creOrderId)) { // 装修核查工单
						renovationCheckOrders = renovationCheckOrdersMapper.getRenovationCheckOrdersbyId(creOrderId);
						journal.setRenovationCheckOrders(renovationCheckOrders);
					} else if (type != null && type == 17 && creOrderId != null && !"".equals(creOrderId)) {// 表扬单
						praiseOrders = praiseOrdersMapper.getPraiseOrderById(creOrderId);
						journal.setPraiseOrders(praiseOrders);
					} else if (type != null && type == 15 && creOrderId != null && !"".equals(creOrderId)) { // 装修巡检工单
						renovationInspectionOrders = renovationInspectionOrdersMapper.getRenovationInspectionOrdersbyId(creOrderId);
						journal.setRenovationInspectionOrders(renovationInspectionOrders);
					} else if (type != null && type == 16 && creOrderId != null && !"".equals(creOrderId)) { // 装修核查工单
						renovationAcceptanceOrders = renovationAcceptanceOrdersMapper.getRenovationAcceptanceOrdersbyId(creOrderId);
						journal.setRenovationAcceptanceOrders(renovationAcceptanceOrders);
					} else if (type != null && type == 18 && creOrderId != null && !"".equals(creOrderId)) { // 验房单
						inspectorOrder = inspectorOrderMapper.getInspectorOrderbyId(creOrderId);
						journal.setInspectorOrder(inspectorOrder);
					} else if (type != null && type == 19 && creOrderId != null && !"".equals(creOrderId)) {// 施工核查
						constructionCheckOrders = constructionCheckOrdersMapper.getConstructionCheckOrdersbyId(creOrderId);
						journal.setConstructionCheckOrders(constructionCheckOrders);
					} else if (type != null && type == 20 && creOrderId != null && !"".equals(creOrderId)) {// 施工巡检
						constructionInspectionOrders = constructionInspectionOrdersMapper.getConstructionInspectionOrdersbyId(creOrderId);
						journal.setConstructionInspectionOrders(constructionInspectionOrders);
					} else if (type != null && type == 21 && creOrderId != null && !"".equals(creOrderId)) {// 施工验收
						constructionAcceptanceOrders = constructionAcceptanceOrdersMapper.getConstructionAcceptanceOrdersbyId(creOrderId);
						journal.setConstructionAcceptanceOrders(constructionAcceptanceOrders);
					} else if (type != null && type == 22 && creOrderId != null && !"".equals(creOrderId)) {// 维修单
						repairOrders = repairOrdersMapper.selectByPrimaryKey(creOrderId);
						journal.setRepairOrders(repairOrders);
					} else if (type != null && type == 24 && creOrderId != null && !"".equals(creOrderId)) {// 失效单
						closedOrders = closedMapper.getClosedOrdersbyId(creOrderId);
						journal.setClosedOrders(closedOrders);
					} else if (type != null && type == 23 && creOrderId != null && !"".equals(creOrderId)) {// 向业主索赔
						claimToCustomerOrders = claimToCustomerOrdersMapper.getClaimToCustomerOrdersbyId(creOrderId);
						journal.setClaimToCustomerOrders(claimToCustomerOrders);
					}
					map.put("journal", journal);
				}
			}
			return JsonUtil.success(map, true);
		} catch (Exception e) {
			return JsonUtil.failure("获取失败!", true);
		}
	}
}
