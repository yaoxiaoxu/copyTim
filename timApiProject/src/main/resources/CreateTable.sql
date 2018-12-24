-- 权限表 --
CREATE TABLE `role` (                               
            `rid` int(11) NOT NULL AUTO_INCREMENT,                 
            `rname` varchar(255) DEFAULT NULL,                      
            PRIMARY KEY (`rid`)                                    
          ) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 

-- 用户 --
-- CREATE TABLE `user` (                     
--          `uid` int(11) NOT NULL AUTO_INCREMENT,  
--          `pwd` varchar(255) DEFAULT NULL,        
--          `name` varchar(255) DEFAULT NULL,       
--          PRIMARY KEY (`uid`)                     
--        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 
--用户表新增属性：创建时间，状态--      
 CREATE TABLE `user` (                     
          `uid` int(11) NOT NULL AUTO_INCREMENT,  
          `pwd` varchar(255) DEFAULT NULL,        
          `name` varchar(255) DEFAULT NULL,
	  	  `status` int(11) NOT NULL,
	   	  `createdate` datetime default null,       
          PRIMARY KEY (`uid`)                     
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 
        
-- 许可 --
CREATE TABLE `permission` (                                                                                     
              `c_id` int(11) NOT NULL AUTO_INCREMENT,                                                                       
              `c_name` varchar(128) DEFAULT NULL COMMENT '菜单名称',                                                    
              `c_url` varchar(128) DEFAULT NULL COMMENT '前端路由跳转url',                                            
              `c_parent_id` int(11) DEFAULT NULL COMMENT '父菜单id',                                                     
              `c_sort` int(11) DEFAULT NULL COMMENT '排序',                                                               
              `c_remark` varchar(256) DEFAULT NULL COMMENT '备注',                                                        
              `c_level` int(11) DEFAULT NULL COMMENT '等级：1->导航栏，2->菜单栏，3->子菜单，4->子导航',  
              `c_router` varchar(128) DEFAULT NULL,                                                                         
              `c_icon` varchar(128) DEFAULT NULL,                                                                           
              PRIMARY KEY (`c_id`)                                                                                          
            ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8   
        
-- 关系表 --         
CREATE TABLE `permission_role`(
			`pid` int(11),
			`rid` int(11),
			key  `idx_pid`(pid),
			key  `idx_rid`(rid)
)
-- 关系表 --         
CREATE TABLE `user_role`(
			`uid` int(11),
			`rid` int(11),
			key  `idx_uid`(uid),
			key  `idx_rid`(rid)
)

                                                        


