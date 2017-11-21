package com.flf.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.flf.entity.TUser;
import com.flf.util.Global;
import com.flf.util.JsonUtil;
import com.flf.util.PropertiesHelper;
import com.flf.util.Tools;

/**
 * @description <p>
 *              用户Session过滤
 *              </p>
 * @author hardy
 * @date 2015-12-14
 */
public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean doFilter = false;
		// 初始化过滤的路径
		PropertiesHelper ph = new PropertiesHelper();
		String vString = ph.readProperties("notfilter");
		//获取头部信息
		String token = request.getHeader("x-user-session");
		//用户对象
		if (null != vString) {
			// 不过滤的uri
			String[] notFilter = vString.split(",");
			// 请求的uri
			String uri = request.getRequestURI();
			for (String s : notFilter) {
				if (uri.indexOf(s) != -1) {
					// 如果uri中包含不过滤的uri，则不进行过滤
					doFilter = false;
					break;
				}
			}
		}

		if (doFilter) {
			// 执行过滤
			PrintWriter out = null;  
			// 从session中获取登录者实体
			HttpSession session =  request.getSession();
			Object obj = session.getAttribute(token);
			if (null == obj) {
				// 设置request和response的字符集，防止乱码
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				// 如果session中不存在登录者实体，则返回状态码
				String code = ph.readProperties("code");
				String str = JsonUtil.result(null, code, false);
				out = response.getWriter();
				out.write(str);
				out.close();
			} else {
				// 如果session中存在登录者实体，则继续
				filterChain.doFilter(request, response);
			}

		} else {
			// 如果不执行过滤，则继续
			filterChain.doFilter(request, response);
		}
	}

}
