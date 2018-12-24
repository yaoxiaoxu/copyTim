
package com.yaoxx.base.baseMapper;

import java.util.List;

import com.yaoxx.base.Entity;

/**
 * 
 * Filename: BaseMapper.java
 * 
 * @version: 1.0
 * @since: JDK 1.8.0_91
 * @Description:
 *
 * 				<br>
 * 				Modification History:<br>
 * 
 *               Date | Author | Version | Description<br>
 *               ------------------------------------------------------------------<br>
 * 
 *               2018年11月20日 | yao_x_x | 1.0 | 1.0 Version
 * 
 */

public interface BaseMapper<T extends Entity> {

	int deleteByPrimaryKey(Integer id);

	int insert(T record);

	T selectByPrimaryKey(Integer id);

	List<T> selectAll();

	int updateByPrimaryKey(T record);
}
