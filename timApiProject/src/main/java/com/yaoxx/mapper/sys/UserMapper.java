package com.yaoxx.mapper.sys;

import java.util.List;

import com.yaoxx.entity.sys.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User selectByName(String name);

	List<User> selectListByName(String loginName);
}