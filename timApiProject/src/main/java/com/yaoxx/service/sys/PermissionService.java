
package com.yaoxx.service.sys;

import java.util.List;

import com.yaoxx.entity.sys.Permission;

/**

* Filename:    PermissionService.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月17日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public interface PermissionService {

	/**
	 * @param level
	 * @return
	 */
	List<Permission> findByLevel(Integer level);
	
	/**
	 * @return
	 */
	List<Permission> findAll();

	/**
	 * @param name
	 * @return List
	 * @description 通过父级的name查出子级的集合
	 */
	List<Permission> findChildByName(String name);

	/**
	 * @param id
	 */
	int deleteById(Integer id);

	/**
	 * @param name
	 * @return
	 * @description 通过【name】查询
	 */
	List<Permission> findByName(String name);

	/**
	 * @param permission
	 * @description 添加一条数据
	 */
	void addOne(Permission permission);
	
	

}
