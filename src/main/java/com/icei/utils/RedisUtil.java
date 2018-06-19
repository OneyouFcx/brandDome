package com.icei.utils;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * RedisUtil工具类
 */
@Component("redisService")
public class RedisUtil {
	@Resource
    private RedisTemplate<String, String> redisTemplate;
	/**
     * set存数据
     * @param key
     * @param value
     * @return
     */
	public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }
	/**
	 * 设置时间储存set
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public boolean set(final String key, final String value,long expire) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.setEx(serializer.serialize(key),expire, serializer.serialize(value));
                return true;
            }
        });
        return result;
    }
	/**
	 * 设置时间储存
	 * @param key
	 * @param value
	 * @param expire
	 */
	public void setForValue(final String key,final String value,long expire) {
		redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
	}
	/**
     * get获取数据
     * @param key
     * @return
     */
	public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }
	/**
     * 设置有效天数
     * @param key
     * @param expire
     * @return
     */
	public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }
	
	/**
     * 移除数据
     * @param key
     * @return
     */
	public boolean remove(final String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.del(key.getBytes());
                return true;
            }
        });
        return result;
    }
}
