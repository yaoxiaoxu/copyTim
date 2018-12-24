
package com.yaoxx.service.sys;

import java.util.List;

import com.yaoxx.entity.sys.Role;

/**

* Filename:    RoleService.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月14日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public interface RoleService {
	
	public List<Role> findAll();

	/**
	 * @param id
	 * @return
	 * @description 根据【PermissionId】查询身份
	 */
	public List<Role> findByPermissionId(Integer pid);

}
