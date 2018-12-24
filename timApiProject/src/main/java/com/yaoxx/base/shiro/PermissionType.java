
package com.yaoxx.base.shiro;

/**

* Filename:    PermissionType.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description: 与Permission.leve对应 1->导航栏，2->菜单栏，3->子菜单，4->子导航
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月26日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public enum PermissionType {
	
	/**
	 * 系统
	 */
	系统(0),
	
	/**
	 * 导航 -最上面的
	 */
	导航(1),
	
	/**
	 * 菜单 -左边的
	 */
	菜单(2),
	
	/**
	 * 子级菜单
	 */
	子级菜单(3),
	
	/**
	 * 按钮
	 */
	按钮(4);
	
	public int code;
	PermissionType(int code){
		this.code =code;
	}

}
