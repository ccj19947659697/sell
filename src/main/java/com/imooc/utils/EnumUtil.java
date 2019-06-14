package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * Created by home on 2019/3/6.
 */
public
class EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if ( code.equals(each.getCode()) ){
                return each;
            }
        }
        return null;
    }
}
