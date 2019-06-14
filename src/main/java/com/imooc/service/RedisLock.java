package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by home on 2019/3/17.
 */
@Component
@Slf4j
public
class RedisLock {
    @Autowired
    private
    StringRedisTemplate redisTemplate;
    /*
    * 加锁
    * @param key productId传过来
    * @param value 当前时间+超前时间传过来
    * @return
    **/
    public boolean lock(String key,String value){
        //  如果键不存在则新增,存在则不改变已经有的值
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;//锁住
        }
        //currentValue=A;这两个线程是的value都是B,其中只有一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue)<System.currentTimeMillis()){
            //获取上一个锁的时间
            //  获取原来key键对应的值并重新赋新值。
            String oldValue =redisTemplate.opsForValue().getAndSet(key,value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
            return true;
        }
        return false;
    }
    /*
    * 解锁
    * @param key productId传过来
    * @param value 当前时间+超前时间传过来
    * @return
    **/
    public void unlock(String key,String value){
        String currentValue = redisTemplate.opsForValue().get(key);
        try {
            if ( !StringUtils.isEmpty(currentValue) && currentValue.equals(value) ) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("[redis分布式]解锁异常,{}",e);
        }
    }
}
