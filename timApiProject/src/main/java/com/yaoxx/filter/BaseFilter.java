package com.yaoxx.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
@WebFilter("/*")
public class BaseFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//知识点：过滤请求：过滤器1→过滤器2→过滤器3
		request.setCharacterEncoding("UTF-8");
//		
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		//允许跨域 -- begin --
//		httpResponse.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
//		httpResponse.setHeader("Access-Control-Allow-Origin", "*"); // 解决跨域访问报错
//		//允许跨域 -- end --
//		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		httpResponse.setHeader("Access-Control-Max-Age", "3600"); // 设置过期时间
//		httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
//		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP1.1.
//		httpResponse.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
