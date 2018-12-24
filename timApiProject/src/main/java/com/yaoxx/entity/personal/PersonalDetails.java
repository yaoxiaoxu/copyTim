package com.yaoxx.entity.personal;

import java.util.Date;

import com.yaoxx.base.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonalDetails extends Entity {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6508169737139892595L;


    private Integer uid;

    private String realname;

    private Date birthday;

    private String signature;

    private String nickname;

    private String headImg;

    
}