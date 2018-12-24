package com.yaoxx.entity.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Generated
@ToString
//@NoArgsConstructor  生成不带参数的构造参数
//@AllArgsConstructor 生成带参数的构造参数
public class User implements Serializable{
    private Integer uid;

    private String name;
    
    private String pwd;
    
    private Date createDate;
    
    private Integer status;
    
    private Set<Role> roles;

	
    

}