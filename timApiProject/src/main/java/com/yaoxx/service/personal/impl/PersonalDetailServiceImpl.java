
package com.yaoxx.service.personal.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaoxx.base.baseService.impl.BaseServiceImpl;
import com.yaoxx.entity.personal.PersonalDetails;
import com.yaoxx.mapper.personal.PersonalDetailsMapper;
import com.yaoxx.service.personal.PersonalDetailService;

/**

* Filename:    PersonalDetailServiceImpl.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月20日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@Service
public class PersonalDetailServiceImpl extends BaseServiceImpl<PersonalDetailsMapper, PersonalDetails> implements PersonalDetailService{
	
	@Autowired
	private PersonalDetailsMapper detailDao; 

	@Override
	public int update(PersonalDetails record) {
		if (isExist(record)) {
			return super.update(record);
		}else{
			return super.add(record);
		}
	}

	public boolean isExist(PersonalDetails record) {
		//1. record如果存在主键，并且有值对应 ->true
		if (record.getId()!=null) {
			PersonalDetails details = detailDao.selectByPrimaryKey(record.getId());
			if (details!=null) {
				return true;
			}
		//2. record如果没有主键，查询PersonalDetails中 用户 uid 是否有值对应
		}else{
			PersonalDetails details = this.findByUid(record.getUid());
			if (details!=null) {
				return true;
			}
		}
		return false;
	}

	public PersonalDetails findByUid(Integer uid) {
		Map<String, Object> params =new HashMap<>();
		params.put("uid", uid);
		List<PersonalDetails> list = detailDao.selectByParams(params);
		if (list !=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
