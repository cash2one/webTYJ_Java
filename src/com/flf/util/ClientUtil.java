/**
 * @Title: ClientUtil.java
 * @Package com.flf.util
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-26 下午5:12:21
 * @version V1.0
 */

package com.flf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;


/**
 * @ClassName: ClientUtil
 * @Description: TODO
 * @author wangyang
 * @date 2015-5-26 下午5:12:21
 *
 */

public class ClientUtil {
	public static JaxWsProxyFactoryBean getClientFactory(String url,Class service)
	{
		Map<String, Object> outProps = new HashMap<String, Object>();  
	       outProps.put(WSHandlerConstants.ACTION,  
	               WSHandlerConstants.USERNAME_TOKEN);  
	       outProps.put(WSHandlerConstants.USER, "admin");  
	       outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);  
	       outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,  
	               WsClinetAuthHandler.class.getName());  
	       ArrayList list = new ArrayList();  
	       list.add(new SAAJOutInterceptor());  
	       list.add(new WSS4JOutInterceptor(outProps)); 
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		    factory.setAddress(url);
		    factory.setServiceClass(service);
		    factory.getInInterceptors().add(new LoggingInInterceptor());  
		    factory.getOutInterceptors().add(new LoggingOutInterceptor()); 
	        //factory.getOutInterceptors().addAll(list); 
		    return factory;
		    
	}
}
