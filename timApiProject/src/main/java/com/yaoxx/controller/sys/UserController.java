
package com.yaoxx.controller.sys;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaoxx.base.RESTful.Result;
import com.yaoxx.base.RESTful.ResultFactory;
import com.yaoxx.entity.sys.User;
import com.yaoxx.mapper.sys.PermissionMapper;
import com.yaoxx.mapper.sys.RoleMapper;
import com.yaoxx.service.sys.UserService;

/**
* @version:    1.0
* @since:      JDK 1.8.0_91<br>
* Create at:   2018年9月22日 下午6:01:49<br>
* Description: vue控制器 返回 restful风格结口<br>
**/

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@RequestMapping(value = "/shiro/user")
	public Result login(@RequestBody User user) {
		List<User> userList = new ArrayList<>();
		String loginName = user.getName();
		if (StringUtils.isNotEmpty(loginName)) {
			userList = userService.findListByName(loginName);
			return ResultFactory.getSuccResult(userList);
		}
		userList = userService.findAll();
		return ResultFactory.getSuccResult(userList);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/shiro/user/add")
	public Result add(@RequestBody User user) {
		userService.addOne(user);
		return ResultFactory.getSuccResult();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/shiro/user/del/{id}")
	public Result del(@PathVariable("id") Integer id) {
		userService.delById(id);
		return ResultFactory.getSuccResult();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/shiro/user/update")
	public Result update(@RequestBody User user) {
		userService.update(user);
		return ResultFactory.getSuccResult();
	}
	
	
	
	
}


