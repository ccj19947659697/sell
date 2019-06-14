package com.imooc.enums;

import lombok.Getter;

/**
 * Created by home on 2019/2/24.
 */
@Getter
public
enum ProductStatusEnum implements CodeEnum  {
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;
//构造方法
    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
