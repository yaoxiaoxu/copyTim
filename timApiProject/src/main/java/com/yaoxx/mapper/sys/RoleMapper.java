package com.yaoxx.mapper.sys;

import java.util.List;
import java.util.Map;

import com.yaoxx.entity.sys.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    Role selectByPrimaryKey(Integer rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByUid(Integer uid);

	/**
	 * @param params
	 * @return
	 * @description 根据参数查询role,其中查询条件与参数【params】的key对应关系如下:<br>
	 *  			<b>"permissionId"</b>-=-=-通过许可id查询身份对象
	 */
	List<Role> findByParams(Map<String, Object> params);
}