
package com.yaoxx.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yaoxx.base.redis.RedisUtils;
import com.yaoxx.base.shiro.AuthRealm;
import com.yaoxx.base.shiro.CustomSessionManager;
import com.yaoxx.entity.sys.User;

/**
 * 
 * Filename: MyUtils.java
 * 
 * @version: 1.0
 * @since: JDK 1.8.0_91
 * @Description:
 *
 * 				<br>
 *               Modification History:<br>
 * 
 *               Date | Author | Version | Description<br>
 *               ------------------------------------------------------------------<br>
 * 
 *               2018年11月4日 | yao_x_x | 1.0 | 1.0 Version
 * 
 */
@Component
public class MyUtils implements ApplicationContextAware {

	private static final String currentUser = "user";

	/*-------------------------- spring上下文 工具 ----------------------------------*/
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		if (MyUtils.applicationContext == null) {
			MyUtils.applicationContext = applicationContext;
		}
		System.out
				.println("------------------------------------  com.yaoxx.base.MyUtils ------------------------------------------------------");

		System.out.println(
				"======== ApplicationContext配置成功,在普通类可以通过调用MyUtils.getApplicationContext()获取applicationContext对象=========");

		System.out.println("---------------------------------------------------------------------");
	}

	/**
	 * @return 获取 spring上下文
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param clazz
	 * @return 通过Class对象获取一个类对象
	 */
	public static <T> T getBeanByClass(Class<T> clazz) {

		return applicationContext.getBean(clazz);
	}

	/**
	 * @param name
	 *            参数【name】是向spring注入bean时使用的id
	 *            ,使用注解注入默认id为 Class的【SimpleName】 (首字母小写 )	<br>
	 *            e.g: 											
	 *            {@code<bean id="a" class="com.bean.A">}		<br>
	 * @return
	 */
	public static Object getBeanByName(String name) {
		return applicationContext.getBean(name);
	}
	
	/**
	 * @param name  参考：{@link #getBeanByClass(Class)}
	 * @param clazz 参考：{@link #getBeanByName(String)}
	 * @return
	 */
	public static <T> T getBean(String name,Class<T> clazz){
		return applicationContext.getBean(name, clazz);
	}
	/*------------------------------------------------------------------------------------*/
	
	
	
	/*----------------------------------- 获取当前用户 -------------------------------------*/
	@Autowired
	private RedisUtils redisutils;

	/**
	 * @return
	 * @description 使用session获取当前用户
	 */
	public static User getCurrentUserBySession() {
		// 获取本次访问的request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取session对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(currentUser);
		return user;
	}

	/**
	 * @param sessionId
	 * @return 返回当前用户对象 User
	 */
	public User getCurrentUserByRedis(String sessionId) {
		if (redisutils.exists(sessionId)) {
			return (User) redisutils.get(sessionId);
		}
		return new User();
	}

	/**
	 * @return 返回当前用户对象 User
	 */
	public User getCurrentUserByRedis() {
		String sessionId = getSessionId(CustomSessionManager.AUTHORIZATION);
		if (redisutils.exists(sessionId)) {
			return (User) redisutils.get(sessionId);
		}

		return new User();
	}

	/**
	 * @param sessionId
	 *            前端cookie中的sessionID
	 * @param user
	 *            当前用户对象
	 * @return 储存成功->true 失败->false
	 * @description 使用redies向内存放置当前用户对象
	 */
	public boolean setCurrentUserByRedis(String sessionId, User user) {
		if (redisutils.exists(sessionId)) {
			return false;
		}
		redisutils.set(sessionId, user);
		return true;
	}

	/**
	 * @param user
	 *            当前用户对象
	 * @return 储存成功->true 失败->false
	 * @description 使用redies向内存放置当前用户对象
	 */
	public boolean setCurrentUserByRedis(User user) {
		String sessionId = getSessionId(CustomSessionManager.AUTHORIZATION);
		if (redisutils.exists(sessionId)) {
			return false;
		}
		redisutils.set(sessionId, user);
		return true;
	}

	/**
	
	 * @param headerKey
	 * @return 
	 *
	 * @Description: 获取存在cookie中的sessionId
	 */
	public static String getSessionId(String headerKey) {
		// 获取本次访问的request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String sessionId = WebUtils.toHttp(request).getHeader(headerKey);
		return sessionId;
	}

	/**
	
	 * @param obj
	 * @return 
	 *	
	 * @Description: TODO替换空值
	 */
	public static Object isNull(Object obj) {
		String typeName = obj.getClass().getSimpleName();
		switch (typeName) {
		case "int":
			
			break;

		default:
			break;
		}
		return null;
	}

}
