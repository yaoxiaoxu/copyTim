package com.yaoxx.service.sys;

import java.util.List;

import com.yaoxx.entity.sys.User;

public interface UserService {
	
	User findById(Integer id);
	
	User findByName(String name);

	List<User> findListByName(String loginName);
	
	List<User> findAll();

	void addOne(User user);

	void delById(Integer id);

	void update(User user);

}
