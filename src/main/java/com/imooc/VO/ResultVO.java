package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * 不要直接把entity返回给前端
 1.节约流量
 2.保护隐私，比如库存等不应该返回给网民浏览到
 * Created by home on 2019/2/24.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public
class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 3068837394742385883L;
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //private String msg=""如果是空值,返回是字符串
    //data里面是一个对象,我们定义成泛型
    //具体内容
    private T data;
}
