
package com.yaoxx.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yaoxx.base.MyUtils;
import com.yaoxx.base.RESTful.ResultCode;
import com.yaoxx.base.redis.RedisUtils;
import com.yaoxx.entity.sys.User;

/**
* @version:    1.0
* @since:      JDK 1.8.0_91<br>
* @Date:   2018年9月22日 下午6:01:49<br>
* @Description: 登录控制器<br>
**/

@RestController
public class LoginController {
	
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private  MyUtils myUtils;
	
	//1.参数中可以添加@RequestBody User user1
	@CrossOrigin
	@RequestMapping(value = "/login")
	public Map<String, Object> login(@RequestBody User loginUser) {
		Map<String, Object> result = new HashMap<>();
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getName(), loginUser.getPwd());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			User user = (User)subject.getPrincipal();
			String sessionID = subject.getSession().getId().toString();
			// 将当前用户储存进redis
			myUtils.setCurrentUserByRedis(sessionID,user);
			result.put("MES",sessionID);
		    return result;
		} catch (Exception e) {
			result.put("MES","身份信息错误");
			HttpServletResponse resp = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			resp.setStatus(ResultCode.LOG_FAIL.code);
			 return result;
		}
	    
	}
	
	@CrossOrigin
	@RequestMapping("/index")
	public String index() {	
		return"123";
	}
	
	/**
	 * @author yao_x_x
	 * @return
	 * @description 测试redis是否可用
	 */
	@CrossOrigin
	@RequestMapping("/redis")
	public String redis() {	
		boolean b = redisUtils.set("name", "姚晓旭");
		if (b) {
			String str =(String) redisUtils.get("name");
			System.err.println("得到redis数据[key：name-value："+str+"]");
			return"123";
		}
		return "失败 ";
	}
	
	
	
}


