package com.yaoxx.mapper.sys;

import java.util.List;

import com.yaoxx.entity.sys.PermissionRole;

public interface PermissionRoleMapper {
    int insert(PermissionRole record);

    List<PermissionRole> selectAll();
}