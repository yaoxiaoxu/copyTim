
package com.yaoxx.service.personal;

import com.yaoxx.base.baseService.BaseService;
import com.yaoxx.entity.personal.PersonalDetails;

/**

* Filename:    PersonalDetailService.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月19日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/

public interface PersonalDetailService extends BaseService<PersonalDetails>{

	
	/** 
	 * 进行更新操作之前会查询数据是否存在
	 * 		1.若存在-> 直接进行修改
	 * 		2.不存在-> 进行添加
	 */
	int update(PersonalDetails record);
	
	/**
	
	 * @param record
	 * @return 
	 *
	 * @Description: 查询数据是否存在,步骤：<br>1.根据主键查询，<br>2.参数对象中主键不存在使用uid查询
	 */
	boolean isExist(PersonalDetails record);
	
	/**
	
	 * @param uid
	 * @return 
	 *
	 * @Description: 根据用户id查询
	 */
	PersonalDetails findByUid(Integer uid);
}
