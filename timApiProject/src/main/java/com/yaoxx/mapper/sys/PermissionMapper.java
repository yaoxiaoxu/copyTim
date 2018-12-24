package com.yaoxx.mapper.sys;

import java.util.List;

import com.yaoxx.entity.sys.Permission;


public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
    
    /**
     * @param rid
     * @return
     * @description 通过【Role id】查询
     */
    List<Permission> selectByRid(Integer rid);
    

	/**
	 * @param level
	 * @return
	 * @description 通过【等级】查询<br>
	 * 等级对应详细请依照：{@link Permission} .level
	 * 
	 */
	List<Permission> selectByLevel(Integer level);
	
	
	/**
	 * @param parentId
	 * @return
	 * @description 根据【父id】查询--子级permission--
	 */
	List<Permission> selectByParentId(Integer parentId);

	/**
	 * @param name
	 * @return
	 * @description 通过【父name】查询 --子级permission--
	 */
	List<Permission> selectChildByName(String name);

	/**
	 * @param name
	 * @return 
	 * @description 通过【name】查询
	 */
	List<Permission> selectByName(String name);
}