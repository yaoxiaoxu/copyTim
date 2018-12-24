package com.yaoxx.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yao_x_x
 * @see #ctx
 * @Desc 此类是对 ServletContext 的监听<br>
 *   	  目的是为了添加一个存在于Application域中的全局上下文
 */
//知识点： 与过滤器一样，监听也需要在web.xml配置，servlet3.0之后可以使用注解配置
@WebListener 
public class BasePathListener  implements ServletContextListener{
	
	/**
	 * 在前端页面使用此字符得到全局上下文
	 */
	private final String ctx="ctx";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO 
		ServletContext context = sce.getServletContext();
		context.setAttribute(ctx, context.getContextPath());
		System.err.println("------------获取全局上下文"+context.getContextPath()+"----------------");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO 项目结束时你想要做的事情
		
	}

}
