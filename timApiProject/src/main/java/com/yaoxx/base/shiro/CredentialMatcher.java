package com.yaoxx.base.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author yao_x_x
 * @ 密码验证规则
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {
	
	//自定义密码验证规则
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken userNamePwdToken = (UsernamePasswordToken)token;
		String pwd = new String(userNamePwdToken.getPassword());
		String dbPwd = (String) info.getCredentials();
		return equals(pwd,dbPwd);//可以使用MD5加密验证
	}

}
