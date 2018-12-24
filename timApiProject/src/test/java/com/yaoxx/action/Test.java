

package com.yaoxx.action;

import com.yaoxx.base.shiro.PermissionType;
import com.yaoxx.entity.personal.PersonalDetails;
import com.yaoxx.service.personal.PersonalDetailService;
import com.yaoxx.service.personal.impl.PersonalDetailServiceImpl;

/**

* Filename:    Test.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月26日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public class Test {

	@org.junit.Test
	public void iTest(){
		for (PermissionType item : PermissionType.values()) {
			System.out.println(item.code);
			System.out.println(item.toString());
		}
	}
	
	@org.junit.Test
	public void test1(){
		PersonalDetailService service = new PersonalDetailServiceImpl();
		//service.insert(new PersonalDetails());
		System.out.println("--");
	}
}
