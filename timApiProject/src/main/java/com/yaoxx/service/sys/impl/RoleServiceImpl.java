
package com.yaoxx.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaoxx.entity.sys.Role;
import com.yaoxx.mapper.sys.RoleMapper;
import com.yaoxx.service.sys.RoleService;

/**

* Filename:    RoleServiceImpl.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月14日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@Service
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleMapper roleDao;

	@Override
	public List<Role> findAll() {
		return roleDao.selectAll();
	}

	@Override
	public List<Role> findByPermissionId(Integer pid) {
		Map<String, Object> params = new HashMap<>();
		params.put("permissionId", pid);
		return roleDao.findByParams(params);
	}

}
