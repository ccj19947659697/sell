package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by home on 2019/3/1.
 */
@Data
public
class OrderForm {
    /**买家端*/
    @NotEmpty(message = "名字必填")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message ="openid必填")
    private String openid;
    /**购物车消息*/
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
