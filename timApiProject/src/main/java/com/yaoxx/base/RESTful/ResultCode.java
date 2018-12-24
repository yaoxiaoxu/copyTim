package com.yaoxx.base.RESTful;


/**
 * @description 
 * 	响应码枚举，参考 HTTP状态码的语义 。
 *  发现了一个一样意义的类：{@link org.springframework.http.HttpStatus}
 * @author yao_x_x
 * @date 2018年9月29日 下午16:30:00
 * @memo 其中无权限->{@link WHITOUT_PERMISSION}			<br>
 * 			  未登录->{@link NOT_LOG_IN}					<br>
 */
public enum ResultCode {
	
	 /** 
     * 成功
     */ 
    SUCCESS(200),
    /** 
     * 失败 
     */ 
    FAIL(400),
    
    /** 
     * 未认证（签名错误）
     */ 
    UNAUTHORIZED(401),
    
    /** 
     * 接口不存在
     */ 
    NOT_FOUND(404),
    
    /** 
     * 服务器内部错误
     */ 
    INTERNAL_SERVER_ERROR(500),
    
    /**
     * 无权限
     */
    WHITOUT_PERMISSION(999),
    
    /**
     * 未登录 
     */
    NOT_LOG_IN(-1),
    
    /**
     * 登录失败
     */
    LOG_FAIL(-2);
	
	
	
	public int code;

    ResultCode(int code) {
        this.code = code;
    }

}
