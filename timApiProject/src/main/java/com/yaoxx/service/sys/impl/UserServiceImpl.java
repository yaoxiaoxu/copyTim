package com.yaoxx.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaoxx.entity.sys.User;
import com.yaoxx.mapper.sys.UserMapper;
import com.yaoxx.service.sys.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	
	public User findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}


	public User findByName(String name) {
		 User selectByName = userMapper.selectByName(name);
		 return selectByName;
	}


	@Override
	public List<User> findListByName(String loginName) {
		loginName ="%"+loginName+"%";
		return userMapper.selectListByName(loginName);
	}


	@Override
	public List<User> findAll() {
		return userMapper.selectAll();
	}


	@Override
	public void addOne(User user) {
		this.userMapper.insert(user);
	}


	@Override
	public void delById(Integer id) {
		this.userMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void update(User user) {
		this.userMapper.updateByPrimaryKey(user);
	}

}
