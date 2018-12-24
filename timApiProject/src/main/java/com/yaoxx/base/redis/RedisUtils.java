
package com.yaoxx.base.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**

* Filename:    RedisPool.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description: 操作Redis的工具类
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年10月22日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@SuppressWarnings("unchecked")
@Component
public class RedisUtils {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * @param key
	 * @return 如若存在返回true，否则返回false
	 * @description 判断Redis中是否存在键为key的列
	 */
	public boolean exists(String key){
		if (StringUtils.isNotBlank(key)) {
			return this.redisTemplate.hasKey(key);
		}
		return false;
	}
	
	/**
	 * @param key
	 * @return	删除成功返回true, 不存在返回false;
	 * @description 删除键为【key】的列
	 */
	public boolean del(String key){
		boolean result = false;
		if (this.exists(key)) {
			this.redisTemplate.delete(key);
			result = true;
		}
		return result;
	}
	
	/**
	 * @param keys
	 * @return 批量删除
	 */
	public boolean del(Set<Serializable> keys){
		boolean result = false;
		if (keys !=null && keys.size()>0){
			this.redisTemplate.delete(keys);
			result =true;
		}
		return result;
	}
	
	/**
	 * @param key 
	 * @param value
	 * @return true为存储成功
	 * @description 存储类型  key(String)-value(Object)
	 */
	public boolean set(final String key,Object value){
		boolean result =false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key,value);
			result =true;
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
	
	/**
	 * @param key
	 * @param value
	 * @param timeout 超时时间	——单位：秒
	 * @return
	 * @description 存储类型  key(String)-value(Object)
	 */
	public boolean set(final String key,Object value,Long timeout){
		boolean result =false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key,value);
			redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
			result =true;
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
	
	
	/**
	 * @param key
	 * @param map
	 * @param timeout 超时时间	——单位：秒
	 * @return
	 * @description 存储类型  key(String)-map(Map)
	 */
	public boolean set(final String key,Map<String,String> map,Long...timeout){
		boolean result =false;
		try {
			this.redisTemplate.opsForHash().putAll(key, map);
			if (timeout!=null&&timeout.length>0) {
				this.redisTemplate.expire(key,timeout[0],TimeUnit.SECONDS);
			}
			result =true;
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
	
	
	/**
	 * @param key
	 * @return 得到key-value 
	 * @description 得出key为‘key’的值<br>
	 * @警告 没有改变序列化方式可能会对使用有影响
	 */
	public Object get(final String key){
		Object obj = null;
		try {
			ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
			obj = operations.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * @param key
	 * @return 得出 key-hash
	 */
	public Map<String, Object> getHash(final String key){
		Map<String, Object> obj = null;
		try {
			HashOperations operations = this.redisTemplate.opsForHash();
			obj = operations.entries(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
