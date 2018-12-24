package com.yaoxx.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author yao_x_x
 * @Desc 字符过滤器
 */
//知识点：在servlet3.0之前过滤器需要在web.xml中配置
@WebFilter(filterName="CharacterEncoding",urlPatterns="/*") 
public class CharacterEncoding implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//知识点：过滤请求：过滤器1→过滤器2→过滤器3
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);//以这句为分隔
		
		//过滤响应：过滤器1←过滤器2←过滤器3
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
