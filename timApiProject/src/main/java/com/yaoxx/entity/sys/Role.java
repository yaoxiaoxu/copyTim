package com.yaoxx.entity.sys;

import java.io.Serializable;
import java.util.Set;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Generated
public class Role implements Serializable{
    private Integer rid;

    private String rname;
    
    private Set<Permission> permissions; 

}