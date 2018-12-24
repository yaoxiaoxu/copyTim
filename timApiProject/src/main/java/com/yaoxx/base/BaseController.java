
package com.yaoxx.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yaoxx.base.RESTful.Result;
import com.yaoxx.base.RESTful.ResultCode;
import com.yaoxx.base.RESTful.ResultFactory;

/**

* Filename:    BaseController.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description: 所有controller都需要继承此类，用于处理一些apache.shiro抛出异常时的请求。
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月24日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public class BaseController {
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @description 
	 * 		apache.Shiro 拦截未登录会抛出
	 * 		UnauthenticatedException，AuthenticationException异常，<br>
	 * 		对则两个异常进行处理可以决定未登陆时返回数据
	 */
	@ExceptionHandler({UnauthenticatedException.class,AuthenticationException.class})
	public Result authenticationException(HttpServletRequest request,HttpServletResponse response){
		Result result = ResultFactory.getResult(ResultCode.NOT_LOG_IN, "未登录");
		return result;
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return {@link Result}
	 * @description 
	 *  	apache.Shiro 拦截权限异常时抛出
	 * 		UnauthorizedException，AuthorizationException异常，<br>
	 * 		对则两个异常进行处理可以决定无权限时返回数据
	 */
	@ExceptionHandler({UnauthorizedException.class,AuthorizationException.class})
	public Result authorizationException(HttpServletRequest request,HttpServletResponse response){
		Result result = ResultFactory.getResult(ResultCode.WHITOUT_PERMISSION, "无权限访问");
		return result;
	}
	
	/**
	 * @param request
	 * @return
	 * @description 判断请求是否为AJAX请求
	 */
	public boolean isAjaxRequest(HttpServletRequest request){
		boolean result = false;
		//由于本项目前后分离，存在跨域行为所以无法传递此请求头
		String str = request.getHeader("x-requested-with");
		if ("XMLHttpRequest".equals(str)) {
			result = true;
		}
		return result;
	}
	

}
