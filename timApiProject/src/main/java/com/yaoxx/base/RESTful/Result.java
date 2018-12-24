package com.yaoxx.base.RESTful;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description 统一 API响应结果封装
 * 
 * @author yao_x_x
 * 
 * @date 2018年9月29日 下午16:17:29
 * 
 * @memo 控制Result权限，构建结果Result对象统一使用工厂类来创建<br>
 */
@Setter
@Getter
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	
    /**
     * 响应状态码
     */
    private int code;
    
    /**
     * 响应提示信息
     */
    private String message;
    
    /**
     * 响应结果对象
     */
    private Object data;

    

}
