
package com.yaoxx.base.baseService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaoxx.base.Entity;
import com.yaoxx.base.baseMapper.BaseMapper;
import com.yaoxx.base.baseService.BaseService;

/**

* Filename:    BaseServiceImpl.java

* @version:     1.0
 * @param <T>
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月20日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
public class BaseServiceImpl<M extends BaseMapper<T>, T extends Entity> implements BaseService<T>{
	
	@Autowired
	private M m;
	
	@Override
	public int delete(Integer id) {
		return m.deleteByPrimaryKey(id);
	}

	@Override
	public int add(T record) {
		return m.insert(record);
	}

	@Override
	public T findById(Integer id) {
		return m.selectByPrimaryKey(id);
	}

	@Override
	public List<T> findAll() {
		return m.selectAll();
	}

	@Override
	public int update(T record) {
		return m.updateByPrimaryKey(record);
	}

}
