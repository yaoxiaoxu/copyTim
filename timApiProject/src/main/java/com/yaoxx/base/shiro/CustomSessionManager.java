
package com.yaoxx.base.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

/**

* Filename:    CustomSessionManager.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description: 适用于前后端分离情况下对sessionId的获取
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月23日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public class CustomSessionManager extends DefaultWebSessionManager {
	
	/**
	 * 获取请求头中key为“Authorization”的value == sessionId
	 */
	public static final String AUTHORIZATION ="Authorization";
	
//	private static final String REFERENCED_SESSION_ID_SOURCE = "cookie";
	
	/** 
	 *  @Description shiro框架 自定义session获取方式<br/>
	 *  可自定义session获取规则。这里采用ajax请求头 {@link AUTHORIZATION}携带sessionId的方式
	 */
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		if (StringUtils.isNotEmpty(sessionId)) {
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
		}
		return super.getSessionId(request, response);
	}

}
