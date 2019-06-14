package com.imooc.utils;

import java.util.Random;

/**
 * Created by home on 2019/2/26.
 */
public
class KeyUtil {
    //生成唯一主键
    //格式:时间+随机数
    public static String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
