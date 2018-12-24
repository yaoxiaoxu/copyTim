package com.yaoxx.mapper.personal;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yaoxx.base.baseMapper.BaseMapper;
import com.yaoxx.entity.personal.PersonalDetails;

@Resource
public interface PersonalDetailsMapper extends BaseMapper<PersonalDetails>{

	List<PersonalDetails> selectByParams(Map<String, Object> params);
	
    
}