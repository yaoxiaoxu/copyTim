
package com.yaoxx.base.shiro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yaoxx.entity.sys.Permission;
import com.yaoxx.entity.sys.Role;
import com.yaoxx.service.sys.PermissionService;
import com.yaoxx.service.sys.RoleService;

/**
* @version:     1.0
* @since:       JDK 1.8.0_91
* Create at:    2018年9月22日 上午11:46:22
* Description:  本类为shiro配置类
*
* Modification History:
* Date             |     Author    |    Version   |   Description
* ------------------------------------------------------------------------------
* 2018年9月22日       |     yao_x_x    |      1.0     |   创建类并初始化shiro配置

*/
@Configuration
public class ShiroConfiguration {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	
	
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager manager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(manager);
		/* 自定义filter */
		Map<String, Filter> filters = bean.getFilters(); 
		filters.put("authc", new MyAuthenticationFilter());
		filters.put("roles", new MyAuthorizationFilter());
		bean.setLoginUrl("/unauth"); //登陆地址				//  |
//		bean.setSuccessUrl("/index"); //成功地址				//  |----因为前后端分离，这些都不需要。已经在自定义过滤器里面配置好了
		bean.setUnauthorizedUrl("/unauth"); //未经授权地址	//  |
		
		Map<String, String> filterChainDefinitionMap =new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.putAll(this.getFilterChainDefinitionMap());
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return bean;
	}
	
	/*
	 * 整理出如下格式的map.put("/admin", "authc,roles[ADMIN,ROOT]");
	 * */
	private Map<? extends String, ? extends String> getFilterChainDefinitionMap() {
		Map<String, String> map = new HashMap<>();
		List<Permission> perList = permissionService.findAll();
		for (Permission permission : perList) {
			StringBuilder value = new StringBuilder("authc,roles[");
			List<Role> roleList=roleService.findByPermissionId(permission.getId());
			int flag =0;
			for (Role role : roleList) {
				if (flag++>0) {
					value.append(","+role.getRname());
				}else {
					value.append(role.getRname());
				}
			}
			value.append("]");
			map.put(permission.getUrl(), value.toString());
		}
		return map;
	}
	
	
		@Bean("securityManager")
	public SecurityManager securityManager(@Qualifier("authRealm")AuthRealm authRealm
			,@Qualifier("sessionManager")SessionManager sessionManager) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(authRealm);
		manager.setSessionManager(sessionManager);
	
		return manager;
	}

	@Bean("authRealm")
	public AuthRealm authRealm(@Qualifier("credentialsMatcher")CredentialsMatcher matcher) {
		AuthRealm authRealm =new AuthRealm();
		authRealm.setCredentialsMatcher(matcher);
		return authRealm;
	}
	
	@Bean("sessionManager")
	public SessionManager sessionManager(){
		CustomSessionManager manager = new CustomSessionManager();
		//设置 redis为缓存（重写CacheManager时需要重写Cache）：manager.setCacheManager(this.RedisCacheManager());
		
		//这里可以不设置。Shiro有默认的session管理。如果缓存为Redis则需改用Redis的管理（需要创建一个redis对应的dao）
        manager.setSessionDAO(new EnterpriseCacheSessionDAO());
		return manager;
	}
	
	@Bean("credentialsMatcher")
	public CredentialMatcher credentialMatcher() {
		return new CredentialMatcher();
	}

	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager")SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor =new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		
		return advisor;
	}
	
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		
		return creator;
	}
}
 
