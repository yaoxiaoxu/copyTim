
package com.yaoxx.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaoxx.entity.sys.Permission;
import com.yaoxx.mapper.sys.PermissionMapper;
import com.yaoxx.service.sys.PermissionService;

/**
* Filename:    PermissionServiceImpl.java
* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>
* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>
* 2018年10月17日   |     yao_x_x      |         1.0        |         1.0 Version
*/

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionMapper permissionDao;
	
	public List<Permission> findAll() {
		return permissionDao.selectAll();
	}

	@Override
	public List<Permission> findByLevel(Integer level) {
		return permissionDao.selectByLevel(level);
	}

	@Override
	public List<Permission> findChildByName(String name) {
		List<Permission> list = this.permissionDao.selectChildByName(name);
		return list;
	}

	@Override
	public int deleteById(Integer id) {
		return this.permissionDao.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.yaoxx.service.PermissionService#findByName(java.lang.String)
	 */
	@Override
	public List<Permission> findByName(String name) {
		return permissionDao.selectByName(name);
	}

	@Override
	public void addOne(Permission permission) {
		permissionDao.insert(permission);
		
	}

}
