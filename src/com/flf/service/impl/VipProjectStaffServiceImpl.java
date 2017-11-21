package com.flf.service.impl;

import java.util.List;
import java.util.UUID;

import com.flf.entity.VipProjectStaff;
import com.flf.mapper.VipProjectStaffMapper;
import com.flf.service.VipProjectStaffService;

public class VipProjectStaffServiceImpl implements VipProjectStaffService {

	private VipProjectStaffMapper vipProjectStaffMapper;
	
	public VipProjectStaffMapper getVipProjectStaffMapper() {
		return vipProjectStaffMapper;
	}

	public void setVipProjectStaffMapper(VipProjectStaffMapper vipProjectStaffMapper) {
		this.vipProjectStaffMapper = vipProjectStaffMapper;
	}

	/**
	 * 向VIP客户项目专员关联表中添加数据
	 */
	@Override
	public void insertVipProjectStaff(VipProjectStaff vps) {
		List<String> vipProjectStaffs = vps.getProjectIds();
		VipProjectStaff vipProjectStaff = new VipProjectStaff();
		for(int i=0;i<vipProjectStaffs.size();i++){
			vipProjectStaff.setId(UUID.randomUUID().toString());
			vipProjectStaff.setVipId(vps.getVipId());
			vipProjectStaff.setProjectId(vipProjectStaffs.get(i).toString());
			vipProjectStaff.setStaffId(vps.getStaffId());
			vipProjectStaffMapper.insertVipProjectStaff(vipProjectStaff);
		}
	}
	
	/**
	 * 根据VIP客户ID查询VIP客户是否已经关联VIP客户项目专员关联表
	 */
	@Override
	public List<VipProjectStaff> selectVipProStaffByVipid(String vipId){
		List<VipProjectStaff> vps = vipProjectStaffMapper.selectVipProStaffByVipid(vipId);
		return vps;
	}

	/**
	 * 根据vipId删除用户在表中数据
	 */
	@Override
	public void deleteVipProStaffByVipid(String vipId){
		vipProjectStaffMapper.deleteVipProStaffByVipid(vipId);
	}
	
	/**
	 * 修改VIP客户在表中的数据
	 */
	@Override
	public void updateVipProjectStaff(VipProjectStaff vps){
		try {
			//1.获取对应客户的vipid，删除此vipid在表中的数据
			vipProjectStaffMapper.deleteVipProStaffByVipid(vps.getVipId());
			//2.获取传入的数据将数据遍历后存入表中
				VipProjectStaff vipprojectstaff = new VipProjectStaff();
				List<String> vpsProjectIds = vps.getProjectIds();
				for(int i = 0 ; i < vpsProjectIds.size() ; i ++){
					vipprojectstaff.setId(UUID.randomUUID().toString());
					vipprojectstaff.setVipId(vps.getVipId());
					vipprojectstaff.setProjectId(vpsProjectIds.get(i).toString());
					vipprojectstaff.setStaffId(vps.getStaffId());
					vipProjectStaffMapper.insertVipProjectStaff(vipprojectstaff);
				}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * VIP列表页面根据vipid查询表中的数据
	 */
	@Override
	public List<VipProjectStaff> listAllByVipid(String vipId){
		List<VipProjectStaff> vps = vipProjectStaffMapper.selectVipProStaffByVipid(vipId);
		return vps;
	}
}
