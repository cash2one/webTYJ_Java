package com.flf.mail;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.flf.entity.User;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailWithFreeMarker {

	private Configuration confi;

	public Configuration getConfi() {
		return confi;
	}

	public void setConfi(Configuration confi) {
		this.confi = confi;
	}
	
/*	public void send(AppUser user)
	{
		MailSenderInfo mailInfo = new MailSenderInfo();   
	     mailInfo.setMailServerHost("smtp.qq.com");
	     mailInfo.setMailServerPort("25");
	     mailInfo.setValidate(true);//是否需要身份验证
	     mailInfo.setUserName("jingguo.liu@winphone.us");   
	     mailInfo.setPassword("ljg13135998248");//您的邮箱密码   
	     mailInfo.setFromAddress("jingguo.liu@winphone.us");//发送者的地址
	     mailInfo.setAnonymity("物业管理员管理员");//匿名名称
	     mailInfo.setToAddress(user.getEmailAddr());//收件人的地址  
	     mailInfo.setSubject("物业找回密码");//邮件标题
	     String html="";
			try {
				Template temp =confi.getTemplate("mail.ftl");
				Map data = new HashMap();
				data.put("user",user.getAppUserId());//
				data.put("csn",user.getCsn());//员工号
				data.put("password",user.getPassword());//密码
				 html = FreeMarkerTemplateUtils.processTemplateIntoString(temp, data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mailInfo.setContent(html);//设置邮件类容
	        //这个类主要来发送邮件  
	     SimpleMailSender sms = new SimpleMailSender();  
	         //sms.sendTextMail(mailInfo);//发送文体格式   
	         
	         sms.sendHtmlMail(mailInfo);//发送html格式  
	}*/
}
