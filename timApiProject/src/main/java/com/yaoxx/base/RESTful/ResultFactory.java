package com.yaoxx.base.RESTful;

/**
 * @description 响应结果生成工厂类
 * @author yao_x_x
 * @date 2019年9月29日 下午8:36:58
 * @memo 无备注说明
 */
public class ResultFactory {
	
	public static Result getFailResult(Object data){
		return getResult(ResultCode.FAIL, "失败", data);
	}
	
	//知识点：java中的修饰符可以变换顺序，但是习惯上为 [权限修饰符]写在最前面
	static public Result getSuccResult(Object data){
		return getResult(ResultCode.SUCCESS, "成功", data);
	}
	static public Result getSuccResult(){
		return getResult(ResultCode.SUCCESS, "成功", null);
	}
	
	public static Result getResult(ResultCode resultCode, String message, Object data){
		return getResult(resultCode.code, message, data);
	}
	
	public static Result getResult(ResultCode resultCode, String message){
		return getResult(resultCode.code, message, null);
	}
	
	public static Result getResult(int code, String message, Object data){
		return new Result(code, message, data);
	}
	

}
