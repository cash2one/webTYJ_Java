/**
 * @Title: RestfulFilter.java
 * @Package com.flf.filter
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-16 上午11:24:32
 * @version V1.0
 */

package com.flf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RestfulFilter
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-16 上午11:24:32
 *
 */

public class RestfulFilter implements Filter {

	/*
	 * <p>Title: destroy</p>
	 * <p>Description: </p>
	 * @see javax.servlet.Filter#destroy()
	 */

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * <p>Title: doFilter</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException ,ServletException {
		HttpServletResponse response = (HttpServletResponse) arg1;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,x-user-session,origin, content-type, accept");
		response.setHeader("Access-Control-Allow-Credentials","true");
        arg2.doFilter(arg0, arg1);

	};

	/*
	 * <p>Title: init</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
