
package com.yaoxx.controller.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaoxx.base.BaseController;
import com.yaoxx.base.MyUtils;
import com.yaoxx.entity.personal.PersonalDetails;
import com.yaoxx.entity.sys.User;
import com.yaoxx.service.personal.PersonalDetailService;

/**

* Filename:    PersonalDetailController.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月20日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@RestController  
@RequestMapping("/personalDetail")
public class PersonalDetailController extends BaseController{
	
	@Autowired
	private MyUtils myUtils;
	
	@Autowired
	private PersonalDetailService detailService;
	
	
	
	@RequestMapping("/add")
	public String add(){
		detailService.add(new PersonalDetails());
		return "";
	}
	
	/**
	
	 * @param details
	 * @return 
	 *
	 * @Description: 对用户信息进行修改或添加。
	 * 					通过id与uid是否存在，进行判断是否添加
	 */
	@RequestMapping("/update")
	@CrossOrigin
	public void update(@RequestBody PersonalDetails details){
		User currentUser = myUtils.getCurrentUserByRedis();
		details.setUid(currentUser.getUid());
		detailService.update(details);
		return;
	}

	@RequestMapping("/detail")
	@CrossOrigin
	public PersonalDetails detail(){
		Integer uid = myUtils.getCurrentUserByRedis().getUid();
		return detailService.findByUid(uid);
	}

}
