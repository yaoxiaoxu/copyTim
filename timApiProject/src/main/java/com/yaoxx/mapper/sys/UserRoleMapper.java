package com.yaoxx.mapper.sys;

import java.util.List;

import com.yaoxx.entity.sys.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();
}