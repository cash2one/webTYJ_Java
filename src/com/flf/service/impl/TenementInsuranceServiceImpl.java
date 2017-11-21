package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.TenementInsurance;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.TenementInsuranceMapper;
import com.flf.service.TenementInsuranceService;
import com.flf.util.Tools;

public class TenementInsuranceServiceImpl implements TenementInsuranceService{

	private TenementInsuranceMapper tenementInsuranceMapper;
	
	private AnnexMapper annexMapper;
	
	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public TenementInsuranceMapper getTenementInsuranceMapper() {
		return tenementInsuranceMapper;
	}

	public void setTenementInsuranceMapper(
			TenementInsuranceMapper tenementInsuranceMapper) {
		this.tenementInsuranceMapper = tenementInsuranceMapper;
	}

	@Override
	public void deleteTenementInsurance(String insuranceId) {
		if(Tools.notEmpty(insuranceId)){
			tenementInsuranceMapper.deleteTenementInsurance(insuranceId);
		}
	}

	@Override
	public TenementInsurance getTenementInsuranceById(String insuranceId) {
		if(Tools.notEmpty(insuranceId)){
			return tenementInsuranceMapper.getTenementInsuranceById(insuranceId);
		}
		return null;
	}

	@Override
	public void insertTenementInsurance(TenementInsurance tenementInsurance) {
		String uuid=UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		tenementInsurance.setInsuranceId(uuid);		
		Integer result =tenementInsuranceMapper.insertTenementInsurance(tenementInsurance);
		//添加成功
		if(result>0){
			//上传文件
			List<Annex> annexs = tenementInsurance.getAnnexs();
			if(annexs!=null && annexs.size()>0){
				for(Annex annex :annexs){
					annex.setRelationId(uuid);
					annex.setAnnexTime(date);
					annexMapper.insertAnnex(annex);
					
				}
			}
		}
		
	}

	@Override
	public List<TenementInsurance> searchTenementInsurance(
			TenementInsurance tenementInsurance) {
		if(tenementInsurance!=null){
			return tenementInsuranceMapper.searchTenementInsurance(tenementInsurance);
		}
		return null;
	}

	@Override
	public void updateTenementInsurance(TenementInsurance tenementInsurance) {
		if(tenementInsurance!=null){
			tenementInsuranceMapper.updateTenementInsurance(tenementInsurance);
		}
	}

	@Override
	public List<TenementInsurance> getAllTenementInsurance() {
		// TODO Auto-generated method stub
		return tenementInsuranceMapper.getAllTenementInsurance();
	}

	@Override
	public PageRestful listPageTenementInsurance(
			TenementInsurance tenementInsurance) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		String colors="red";//未投保颜色
		String state="";
		Date currentDate=new Date();
		int month=0;
		List<TenementInsurance> tenementInsurances =tenementInsuranceMapper.listPageTenementInsurance(tenementInsurance);
		for(int i=0;i<tenementInsurances.size();i++){
			String id=tenementInsurances.get(i).getInsuranceId();
			colors="red";
			state="2";
			if(id!=null){
				 colors="green";//已投保颜色
				 state="1";
				//判断该保险是否快过期
				  Calendar cal1 = Calendar.getInstance();     
				  cal1.setTime(currentDate); 
		          Calendar cal2 = Calendar.getInstance();     
		          cal2.setTime(tenementInsurances.get(i).getEndTime()); 
		          month=(cal2.get(1)-cal1.get(1))*12+(cal2.get(2)-cal1.get(2));
		          if(month>=0&&month<=4){
		        	  colors="yellow";
		        	  state="3";
		          }  
			}
			tenementInsurances.get(i).setColors(colors);
			tenementInsurances.get(i).setState(state);
		}
		tenementInsurances.add(0,null);		
		pagerestful.setTenementInsurances(tenementInsurances);
		pagerestful.setPage(tenementInsurance.getPage());
		return pagerestful;
		
	}

	@Override
	public TenementInsurance getTenementInsuranceByIds(String insuranceId) {
		// TODO Auto-generated method stub
		return tenementInsuranceMapper.getTenementInsuranceByIds(insuranceId);
	}

}
