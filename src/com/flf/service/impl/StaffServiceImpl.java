package com.flf.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.Staff;
import com.flf.entity.Teamwork;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.PostMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TeamworkMapper;
import com.flf.mapper.TeamworkStaffAddMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.StaffService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.JsonUtil;
import com.flf.util.MapUtils;
import com.flf.util.Tools;

@WebService
public class StaffServiceImpl implements StaffService {
	private TeamworkMapper teamworkMapper;
	private PostMapper postMapper;
	private StaffMapper staffMapper;
	private AnnexMapper annexMapper;
	private TeamworkStaffAddMapper teamworkStaffAddMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public TeamworkMapper getTeamworkMapper() {
		return teamworkMapper;
	}

	public void setTeamworkMapper(TeamworkMapper teamworkMapper) {
		this.teamworkMapper = teamworkMapper;
	}

	public PostMapper getPostMapper() {
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	@Override
	public List<Staff> listPageHouse(Staff staff) {
		// TODO Auto-generated method stub
		return staffMapper.findAll();
	}

	@Override
	public Staff getStaffById(String staffId) {
		// TODO Auto-generated method stub
		return staffMapper.findStaffBystaffId(staffId);
	}

	@Override
	public int deleteStaff(String staffId) {
		// TODO Auto-generated method stub
		return staffMapper.deleteStaff(staffId);
	}
	
	private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat fmt_L = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void insertStaff(Staff staff) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = fmt_L.format(new Date());
		/*
		 * int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) +
		 * 10000;// 获取5位随机数
		 * staff.setStaffNumber(Integer.toString(rannum));//员工编号
		 */
		String num = staffMapper.selectCustCode(); // 查询人员表中最大的员工编号
		if (num == null || num.equals("")) {
			num = "10000";
		} else {
			num = String.valueOf(Integer.parseInt(num) + 1);
		}
		staff.setStaffNumber(num);// 客户编号
		// 如果等于18位就加上个字母"S",那么在前端取值时也会删除掉字母'S'
		if (staff.getCardNum().length() == 18) {
			staff.setCardNum(staff.getCardNum() + "S");
		}
		if (staff != null) {
			List<Annex> annexList = staff.getAnnexs();
			staff.setStaffId(uuid); // 设置员工id
			staff.setState("1");// 状态设为有效
			Integer result = staffMapper.insertStaff(staff);
			if (result > 0) {
				if (annexList != null && annexList.size() > 0) {
					for (Annex annex : annexList) {
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
	}

	@Override
	public int updateStaff(Staff staff) {
		return staffMapper.updateStaff(staff);
	}

	@Override
	public String selectByid(String id) {
		Staff staff = staffMapper.selectByid(id);
		if (staff != null) {
			JSONObject json = JSONObject.fromObject(staff);
			return JsonUtil.success(json, false);
		} else {
			return JsonUtil.failure("failure", true);
		}
	}

	@Override
	public List<Staff> listAllStaff() {

		List<Staff> list = staffMapper.listAllStaff();

		return list;
	}

	@Override
	public List<Staff> listStaffByHillockId(String hillockId) {
		// TODO Auto-generated method stub
		return staffMapper.listStaffByHillockId(hillockId);
	}

	@Override
	public String listStaffHillockId(String hillockId) {

		// TODO Auto-generated method stub
		List<Staff> staffs = staffMapper.listStaffByHillockId(hillockId);
		if (staffs.size() > 0) {
			JSONArray json = JSONArray.fromObject(staffs);
			return JsonUtil.success(json, false);
		} else {
			return JsonUtil.failure("failure", true);
		}

	}

	@Override
	public List<Staff> listPageStaff() {
		// TODO Auto-generated method stub
		return staffMapper.listAllStaff();
	}

	/*
	 * 修改 by 肖聪 2015/6/2 增加年龄字段 (non-Javadoc)
	 * 
	 * @see com.flf.service.StaffService#getStaffByIdRest(java.lang.Integer)
	 */
	@Override
	public Staff getStaffByIdRest(String staffId) {
		Staff staff = staffMapper.findStaffBystaffId(staffId);
		return staff;
	}

	@Override
	public void AddStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffMapper.insertStaff(staff);
	}

	@Override
	public void UpdateStaff(Staff staff) {
		// TODO Auto-generated method stub
		String id = staff.getStaffId();
		if (staff.getCardNum().length() == 18) { // 如果等于18位就加上个字母"S",那么在前端取值时也会删除掉字母'S'
			staff.setCardNum(staff.getCardNum() + "S");
		}
		Integer n = staffMapper.updateStaff(staff);
		if (n > 0) {
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			List<Annex> annexList1 = annexMapper.getAnnexbyRelationId(id);// 根据关系id查询附件表是否存在文件信息
			List<Annex> annexList = staff.getAnnexs();// 得到传过来的文件列表
			if (annexList1 != null && annexList1.size() > 0) {// 存在 文件时 将原有文件删除
				for (int i = 0; i < annexList1.size(); i++) {
					annexMapper.deleteAnnexByRelationId(id);
				}
				if (annexList != null && annexList.size() > 0) {
					for (Annex annex : annexList) {
						annex.setRelationId(id);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			} else {// 不存在文件时 直接新增
				if (annexList != null && annexList.size() > 0) {
					for (Annex annex : annexList) {
						annex.setRelationId(id);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
	}

	@Override
	public void DeleteStaffById(String staffId) {
		staffMapper.deleteStaff(staffId);
	}

	@Override
	public List<Staff> listStaffByCurrentDateAndPostId(HashMap<String, Object> map) {
		List<Staff> staffs = staffMapper.listStaffByCurrentDateAndPostId(map);
		Collections.shuffle(staffs);
		return staffs;
	}

	@Override
	public int updateStaffByworkCount(String staffId) {
		Staff staff = staffMapper.selectByid(staffId); // 获取员工信息
		int WorkCount;
		if (staff.getWorkCount() != 6) {
			WorkCount = staff.getWorkCount() + 1; // 判断是否连续上班六天
		} else {
			WorkCount = 0;
		}

		return staffMapper.updateStaffByworkCount(staffId, WorkCount);
	}

	@Override
	public int updateStaffByworkCount(String staffid, int workCount) {
		// TODO Auto-generated method stub
		return staffMapper.updateStaffByworkCount(staffid, workCount);
	}

	@Override
	public int updateStaffworkCount(String postid) {
		return staffMapper.updateStaffworkCount(postid);
	}

	@Override
	public void updateAllStaffworkCount(List<Staff> staff) {
		for (Staff staff2 : staff) {
			if (staff2.getWorkCount() == 6) {
				staffMapper.updateStaffByworkCount(staff2.getStaffId(), 0);
			} else {
				staffMapper.updateStaffByworkCount(staff2.getStaffId(), staff2.getWorkCount() + 1);
			}
		}
	}

	@Override
	public PageRestful listPageStaffRestful(Staff staff) {
		PageRestful pagerestful = new PageRestful();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (staff.getBirthday() != null) {
			String s1 = sdf.format(staff.getBirthday());
			staff.setS_birthday(s1);
		} else {
			staff.setS_birthday("");
		}
		// 将输入的字符串变为大写
		if (StringUtils.isNotEmpty(staff.getParamForSearch())) {
			staff.setParamForSearch(staff.getParamForSearch().toUpperCase());
		}
		List<Staff> staffs = staffMapper.listPageAllStaff(staff);
		staffs.add(0, null);
		pagerestful.setStaffs(staffs);
		pagerestful.setPage(staff.getPage());
		return pagerestful;
	}

	@Override
	public void insertStaffRestful(Staff staff) {
		// TODO Auto-generated method stub
		staffMapper.insertStaff(staff);
	}

	/**
	 * 新建 xiaocong 2015/6/1 页面显示人员年龄
	 */
	@Override
	public List<Staff> listAllStaffRestful() {
		// TODO Auto-generated method stub
		List<Staff> staffs = staffMapper.findAll();
		for (Staff staff : staffs) {
			if (staff.getBirthday() != null) {
				staff.setAge(new Date().getYear() - staff.getBirthday().getYear());
			}
		}
		return staffs;
	}

	@Override
	public List<Staff> listStaffByteamworkId(String teamworkId) {
		// TODO Auto-generated method stub
		return staffMapper.listStaffByteamworkId(teamworkId);
	}

	@Override
	public List<Staff> getStaffbyPostType(String postId) {
		// TODO Auto-generated method stub
		return staffMapper.getStaffbyPostType(postId);
	}

	/*
	 * @Override public List<Staff> getStaffbyName(String instanceId) { // TODO
	 * Auto-generated method stub List<Teamwork>
	 * teamworks=teamworkMapper.listTeamworkbyinstanceId(instanceId);
	 * List<Staff> staffs=new ArrayList<Staff>(); for (Teamwork teamwork :
	 * teamworks) { List<Staff>
	 * staff=staffMapper.getStaffbyName(teamwork.getLeader(),teamwork.getId());
	 * Staff aa=new Staff(); aa.setStaffs(staff); staffs.add(aa); } return
	 * staffs; }
	 */

	@Override
	public List<Staff> getStaffbyName() {
		List<Teamwork> teamworks = teamworkMapper.listAllTeamwork();
		List<Staff> staffs = new ArrayList<Staff>();
		for (Teamwork teamwork : teamworks) {
			List<Staff> staff = staffMapper.getStaffbyName(teamwork.getLeader(), teamwork.getId());
			Staff aa = new Staff();
			aa.setStaffs(staff);
			staffs.add(aa);
		}
		return staffs;
	}

	@Override
	public List<Staff> getStaffbyProjectId(String projectId) {
		// TODO Auto-generated method stub
		return staffMapper.getStaffbyProjectId(projectId);
	}

	/*
	 * @Override public List<Staff> getStaffbyInstanceId(String instanceId) { //
	 * TODO Auto-generated method stub return
	 * staffMapper.getStaffbyInstanceId(instanceId); }
	 */

	@Override
	public List<Staff> listStaffprojectManager() {
		return staffMapper.listStaffprojectManager();
	}

	@Override
	public List<Staff> listStaffBypostId(String postId) {
		return staffMapper.listStaffBypostId(postId);
	}

	@Override
	public List<Staff> listAllStaffNoAllot(String id, String companyId) {
		List<Staff> staffList = new ArrayList<>();
		staffList = staffMapper.listAllStaffNoAllot(id,companyId);
		staffList.addAll(staffMapper.selectByTeamworkStaffAdd(id));
		return staffList;
	}

	@SuppressWarnings("unused")
	@Override
	public Info importDataFromExcelFile(final Annex annex) {

		SimpleDateFormat sdfForFile = new SimpleDateFormat("yyyyMMddHHmmss");// 用于给导入进来的excel文件命令
		String filePath = annex.getAnnexAddress();
		 int numbers=0;
		if (Tools.notEmpty(filePath)) {
			try {
				
				final List<Map<Short, String>> errorMapList = new ArrayList<Map<Short, String>>();
				final List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				 final List<Staff> insertStaffList = new ArrayList<Staff>();
				final List<Staff> staffes = staffMapper.listAllStaff();
				if (dataList != null && dataList.size() > 0) {
				//	staffes = staffMapper.listAllStaff();// 取出数据库中所有员工信息
					// int k = 0;// 用于标记插入失败的数据
					final String key = UUID.randomUUID().toString();
					int tmp = 0; 
					for (int i = 0; i < dataList.size(); i++) {
					//for (Map<Short, String> t : dataList) {
						Map<Short, String> t = dataList.get(i);
						String staffNo = t.get((short) 0);
						String staffName = t.get((short) 1);
						String sex = t.get((short) 2);
						String telphone = t.get((short) 3);
						String cardType = t.get((short) 4);
						String cardNum = t.get((short) 5).length() >= 18 ? t.get((short) 5) + "S" : t.get((short) 5);
						String birthday = t.get((short) 6);
						String married = t.get((short) 7);
						String address = t.get((short) 8);
						if (StringUtils.isEmpty(staffNo) || StringUtils.isEmpty(birthday)
								|| StringUtils.isEmpty(staffName) || StringUtils.isEmpty(sex)
								|| StringUtils.isEmpty(telphone) || StringUtils.isEmpty(cardType)
								|| StringUtils.isEmpty(cardNum)) {
							//errorMapList.add(t);
							dataList.remove(i);
							i--;
						} else {
							boolean insertFlag = true;
							for (Staff staff : staffes) {
								if (staffNo.equals(staff.getStaffNo()) || telphone.equals(staff.getTelphone())
										|| (cardType.equals(staff.getCardType())
												&& cardNum.equals(staff.getCardNum()))) {
									insertFlag = false;
									numbers++;
									break;
								}
							}
							if(!insertFlag){
								dataList.remove(i);
								i--;
							}
						}
					//}
					}
					
					
					if(numbers>0){
						return Tools.msg("不能重复导入!", false);
					}
					Runnable th = new Runnable() {
						@Override
						public void run() {
							//导入进度条
							int totalNum = dataList.size();
							int bsnum = 0;
							for (Map<Short, String> t : dataList) {
								String staffNo = t.get((short) 0);
								String staffName = t.get((short) 1);
								String sex = t.get((short) 2);
								String telphone = t.get((short) 3);
								String cardType = t.get((short) 4);
								String cardNum = t.get((short) 5).length() >= 18 ? t.get((short) 5) + "S" : t.get((short) 5);
								String birthday = t.get((short) 6);
								String married = t.get((short) 7);
								String address = t.get((short) 8);
		
								if (StringUtils.isEmpty(staffNo) || StringUtils.isEmpty(birthday)
										|| StringUtils.isEmpty(staffName) || StringUtils.isEmpty(sex)
										|| StringUtils.isEmpty(telphone) || StringUtils.isEmpty(cardType)
										|| StringUtils.isEmpty(cardNum)) {
									errorMapList.add(t);
								} else {
									boolean insertFlag = true;
									for (Staff staff : staffes) {
										if (staffNo.equals(staff.getStaffNo()) || telphone.equals(staff.getTelphone())
												|| (cardType.equals(staff.getCardType())
														&& cardNum.equals(staff.getCardNum()))) {
											insertFlag = false;
										}
									}
									if (insertFlag) {
										Staff staffNew = new Staff();
										// "员工工号","员工姓名","员工性别","联系电话","证件类型","证件号码","出生日期","户籍","婚姻状况","现居地址","学历"
										if(staffNo == null){
											continue;
										}
										staffNew.setStaffNo(staffNo);// 员工工号
										staffNew.setCompanyId(annex.getCompanyId());
										staffNew.setStaffName(staffName);// 员工姓名
										if ("男".equals(sex)) {// 员工性别(男0，女1)
											staffNew.setSex(0);
										} else {
											staffNew.setSex(1);
										}
										staffNew.setTelphone(telphone);// 联系电话
										if ("身份证".equals(cardType)) {// 证件类型(身份证0,护照1)
											staffNew.setCardType(0);
										} else {
											staffNew.setCardType(1);
										}
		
										staffNew.setCardNum(cardNum);// 证件号码
		
										if (!StringUtils.isEmpty(birthday)) {
											try {
												staffNew.setBirthday(fmt.parse(birthday));
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}// 出生日期
										} else {
											staffNew.setBirthday(null);// 出生日期
										}
		
										if ("已婚".equals(married)) {// 婚姻状况(已婚0，未婚1)
											staffNew.setMarried(0);
										} else {
											staffNew.setMarried(1);
										}
										staffNew.setAddress(address);// 现居住地
										staffNew.setState("1");
										insertStaffList.add(staffNew);
										bsnum++;
										MapUtils.getMap().put(key, bsnum + "|" + totalNum); 
									} else {
										bsnum++;
										MapUtils.getMap().put(key, bsnum + "|" + totalNum); 
										errorMapList.add(t);
									}
								}
							}
							if(insertStaffList.size() == 0){
								MapUtils.getMap().put(key, 0 + "|" + 0); 
							}else{
								staffMapper.insertList(insertStaffList);
							}
						}
					};
					Thread t = new Thread(th);
					t.start();
					return Tools.msg(key, true);
					/*int s = 0;
					String fileName = "";
					if (insertStaffList.size() > 0) {
						s = staffMapper.insertList(insertStaffList);
					}
					if (errorMapList.size() > 0) {
						List<Map<String, String>> errorMapListReturn = new ArrayList<Map<String, String>>();
						ExcelInfo ei = new ExcelInfo();
						ei.setSheetName("员工不合格记录");
						for (Map<Short, String> map : errorMapList) {
							Map<String, String> errorMap = new HashMap<String, String>();
							for (Short sh : map.keySet()) {
								switch (sh) {
								case 0:
									errorMap.put("staffNo", map.get(sh));
									break;
								case 1:
									errorMap.put("staffName", map.get(sh));
									break;
								case 2:
									errorMap.put("sex", map.get(sh));
									break;
								case 3:
									errorMap.put("telphone", map.get(sh));
									break;
								case 4:
									errorMap.put("cardType", map.get(sh));
									break;
								case 5:
									errorMap.put("cardNum", map.get(sh));
									break;
								case 6:
									errorMap.put("birthday", map.get(sh));
									break;
								case 7:
									errorMap.put("married", map.get(sh));
									break;
								case 8:
									errorMap.put("address", map.get(sh));
									break;
								}
							}
							errorMapListReturn.add(errorMap);
							String[] fieldNew = new String[]{"staffNo","staffName","sex","telphone","cardType","cardNum","birthday","married","address"};
							String[] titles = new String[] { "员工工号","员工姓名","员工性别","联系电话","证件类型","证件号码","生日","婚否","地址"};
							ei.setList(errorMapListReturn);
							ei.setTitles(titles);
							ei.setFields(fieldNew);
							List<ExcelInfo> l = new ArrayList<ExcelInfo>();
							l.add(ei);
							Excel e = new Excel();
							String str = getClass().getClassLoader().getResource("").toURI().getPath();
							fileName = sdfForFile.format(new Date()) + ".xls";
							String fileRealPath = str.substring(str.indexOf("/", 0) + 1, str.lastIndexOf("WEB-INF/"))
									+ fileName;
							fileRealPath = fileRealPath.replace("\\", "/");
							InputStream is = e.createExcelInputStream(l);
							File f = new File(fileRealPath);
							FileOutputStream fos = new FileOutputStream(f);
							byte[] buffer = new byte[1024];
							int num = -1;
							while (true) {
								num = is.read(buffer);
								if (num == -1) {// 是否知道了返回-1的作用了?
									break;
								}
								// read和write是有几种形式的，上面你可以看到
								fos.write(buffer, 0, num);
								// fos.write(buffer); //照样可以是实现，不同的是，上面规定了最大的字节数
							}
							is.close();
							fos.close();
						}
					}*/
					//return Tools.msg(s + "|" + errorMapList.size() + "|" + fileName, true);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}

	@Override
	public PageRestful listPageStaffForUser(Staff staff) {

		PageRestful pageRestful = new PageRestful();
		List<Staff> staffs = staffMapper.listPageAllStaffByRoleType(staff);
		staffs.add(0, null);
		pageRestful.setStaffs(staffs);
		pageRestful.setPage(staff.getPage());
		return pageRestful;
	}

	// 删除 --将状态改为0
	@Override
	public void updateStaffStateById(Staff staff) {
		List<Staff> list = staff.getStaffs();
		for (int i = 0; i < list.size(); i++) {
			staff.setStaffId(list.get(i).getStaffId());
			staffMapper.updateStaffStateById(staff);
		}
	}

	// 员工显示查询
	@Override
	public List<Staff> listAllStaffList() {
		List<Staff> list = staffMapper.listAllStaff();
		return list;
	}
	
	@Override
	public InputStream importStaffTemplet() {
		List<Staff> person = new ArrayList<Staff>();
		person.add(null);
		Excel ex = new Excel();
		
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "员工工号", "员工姓名", "员工性别", "联系电话", "证件类型", "证件号码", "出生日期", "婚姻状况", "现居地址" };
		String[] fields = { "staffNo", "staffName", "sex", "telphone", "cardType", "cardNum", "s_birthday", "married",
				"address" };
		List<Staff> dataset = new ArrayList<Staff>();
		Staff staff = new Staff();
		staff.setStaffNo("请输入您的工号");
		staff.setStaffName("请输入您的员工姓名");
		staff.setS_birthday("请输入您的出生日期,格式为:2016-01-12");
		staff.setCardNum("请现将此变为文本格式,再输入您的证件号.");
		dataset.add(staff);
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("员工导入模版");
		exl.setList(dataset);
		list.add(exl);
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InputStream exportStaffFile(Staff staff) {
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "员工工号", "员工姓名", "性别", "联系电话", "证件类型", "证件号码", "出生日期", "婚姻状况", "现居地址" };
		String[] fields = { "staffNo", "staffName", "sex1", "telphone", "cardType1", "cardNum", "s_birthday", "marry",
				"address" };

		List<Staff> dataset = staffMapper.listStaffList(staff);

		if (dataset != null && dataset.size() > 0) {
			for (int i = 0; i < dataset.size(); i++) {
				// 证件类型
				Integer type = dataset.get(i).getCardType();
				if (type != null) {
					if (type == 0) {
						dataset.get(i).setCardType1("身份证");
					} else if (type == 1) {
						dataset.get(i).setCardType1("护照");
					}
				} else {
					dataset.get(i).setCardType1("");
				}

				if (dataset.get(i).getCardNum().length() > 18) {
					dataset.get(i).setCardNum(dataset.get(i).getCardNum().substring(0, 18));
				}

				// 性别
				Integer sex = dataset.get(i).getSex();
				if (sex != null) {
					if (sex == 0) {
						dataset.get(i).setSex1("男");
					} else if (sex == 1) {
						dataset.get(i).setSex1("女");
					}
				}

				// 生日
				Date date = dataset.get(i).getBirthday();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (date != null) {
					String s1 = sdf.format(date);
					dataset.get(i).setS_birthday(s1);
				} else {
					dataset.get(i).setS_birthday("");
				}

				if (dataset.get(i).getMarried() != null) {
					// 婚否
					Integer married = dataset.get(i).getMarried();

					if (married == 0) {
						dataset.get(i).setMarry("已婚");
					} else if (married == 1) {
						dataset.get(i).setMarry("未婚");
					} else {
						dataset.get(i).setMarry(" ");
					}
				}
			}

			ExcelInfo exl = new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("员工");
			exl.setList(dataset);
			list.add(exl);
		}
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Staff> listStaffList(Staff staff) {

		return staffMapper.listStaffList(staff);
	}

	@Override
	public InputStream exportStaffTemplet() {
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "物业APP账号", "员工姓名"};
		String[] fields = { "userAppId", "staffName"};
		List<Staff> dataset = new ArrayList<Staff>();
		Staff staff = new Staff();
		staff.setUserAppId("请输入物业APP账号");
		staff.setStaffName("请输入您的员工姓名");
		dataset.add(staff);
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("员工导入模版");
		exl.setList(dataset);
		list.add(exl);
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getStaffNameById(String staffId) {
		// TODO Auto-generated method stub
		return staffMapper.getStaffNamebyId(staffId);
	}

	@Override
	public PageRestful listPageAllStaff_Unckeck(Staff staff) {
		PageRestful pagerestful = new PageRestful();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (staff.getBirthday() != null) {
			String s1 = sdf.format(staff.getBirthday());
			staff.setS_birthday(s1);
		} else {
			staff.setS_birthday("");
		}
		// 将输入的字符串变为大写
		if (StringUtils.isNotEmpty(staff.getParamForSearch())) {
			staff.setParamForSearch(staff.getParamForSearch().toUpperCase());
		}
		List<Staff> staffs = staffMapper.listPageAllStaff_Unckeck(staff);
		staffs.add(0, null);
		pagerestful.setStaffs(staffs);
		pagerestful.setPage(staff.getPage());
		return pagerestful;
	}

	@Override
	public List<Staff> findUserInfoByUserAppId(Staff staff) {
		return staffMapper.listStaffList(staff);
	}
}
