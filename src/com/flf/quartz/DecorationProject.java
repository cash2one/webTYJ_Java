package com.flf.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.flf.entity.DecorationInspectionPlans;
import com.flf.mapper.DecorationInspectionPlansMapper;

public class DecorationProject extends QuartzJobBean {
	@Autowired
	private DecorationInspectionPlansMapper decorationInspectionPlansMapper;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	
	public void DecorationFailure(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
	
		Date date=new   Date();//取时间 
		Calendar   calendar   =   new   GregorianCalendar(); 
		calendar.setTime(date); 
		calendar.add(calendar.DATE,-1);//当前日期往前推一天
		date=calendar.getTime();   
		String time = sdf.format(date);
		
		List<DecorationInspectionPlans> decorationInspectionPlansList = decorationInspectionPlansMapper.getDecorationInspectionPlans();
		for(DecorationInspectionPlans dip : decorationInspectionPlansList){
			Date failureTime = dip.getFailureTime(); //失效时间
			String Datetiem = sdf.format(failureTime);
			if(time.equals(Datetiem)){
				dip.setState((byte)0);
				decorationInspectionPlansMapper.updateByPrimaryKeySelective(dip);
			}
		}
	
		
		
	}

}
