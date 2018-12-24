package com.yaoxx.base.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaoxx.entity.sys.Permission;
import com.yaoxx.entity.sys.Role;
import com.yaoxx.entity.sys.User;
import com.yaoxx.service.sys.UserService;

/**
 * @author yao_x_x
 * @ 授权<br>
 * 本类把身份对应的许可提出来
 */
public class AuthRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	// 验证登陆--
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePwdtoken = (UsernamePasswordToken) token;	
		String userName = usernamePwdtoken.getUsername();
		User user = userService.findByName(userName);
		
		return new SimpleAuthenticationInfo(user, user.getPwd(), this.getClass().getName());
	}

	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User)principals.fromRealm(this.getClass().getName()).iterator().next();
		List<String> permissionList = new ArrayList<>();
		List<String> roleList = new ArrayList<>();
		Set<Role> roles = user.getRoles();
		if (!CollectionUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleList.add(role.getRname());
				Set<Permission> permissions = role.getPermissions();
				if (CollectionUtils.isEmpty(permissions)) {
					for (Permission permission : permissions) {
						permissionList.add(permission.getName());
					}
				}
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissionList);
		info.addRoles(roleList);
		return info;
	}
	

}
