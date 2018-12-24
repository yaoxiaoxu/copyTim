package com.yaoxx.entity.sys;

import java.io.Serializable;
import java.util.List;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yao_x_x
 * @description
 * 其中level【等级】：1->导航栏，2->菜单栏，3->子菜单，4->子导航<br>
 */
@Setter
@Getter
@Generated
public class Permission implements Serializable {
	
	private Integer id;
	
    private String 	name;
    
    private String 	url;
    
	private Integer parentId;
	
	private Integer sort;
	
	private String 	remark;
	
	private String 	icon;
	
	/**
	 * 1->导航栏，2->菜单栏，3->子菜单，4->子导航
	 */
	private Integer level; 
	
	/**
	 * 前端项目中路由路径
	 */
	private String router;
	
	private List<Permission> childPermissions;


}