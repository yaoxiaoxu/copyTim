		
package com.yaoxx.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaoxx.base.shiro.PermissionType;
import com.yaoxx.entity.sys.Permission;
import com.yaoxx.entity.sys.User;
import com.yaoxx.service.sys.PermissionService;

/**

* Filename:    PermissionController.java

* @version:    	1.0
* @since:       JDK 1.8.0_91
* @ Create at:   	2018年10月16日 下午4:46:21<br>
* Description:<br>
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description
* ------------------------------------------------------------------

* 2018年10月16日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@CrossOrigin
	@RequestMapping("/{level}")
	public List<Permission> permission(@PathVariable("level")Integer level){
		List<Permission> findAll = permissionService.findByLevel(level);
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		System.out.println(user);
		return findAll;
	} 
	
	@CrossOrigin
	@RequestMapping("/findByName/{name}")
	public List<Permission> permissionUntil(@PathVariable("name")String name){
		List<Permission> list = permissionService.findByName(name);
		return list;
	}
	
	@CrossOrigin
	@RequestMapping("/del/{id}")
	public int del(@PathVariable("id")Integer id){
		int delNum = permissionService.deleteById(id);
		return delNum;
	}
	
	@CrossOrigin
	@RequestMapping("/type")
	public List<Map<String, Object>> type(){
		List<Map<String, Object>> result =new ArrayList<>();
		for (PermissionType item : PermissionType.values()) {
			Map<String, Object> map = new HashMap<>();
			map.put("name", item.toString());
			map.put("code", item.code);
			result.add(map);
		}
		return result;
	}

	@CrossOrigin
	@RequestMapping("/add")
	public int add(@RequestBody Permission permission ,Integer id){
		permissionService.addOne(permission);
		int delNum = permissionService.deleteById(id);
		return delNum;
	}
}
