package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by home on 2019/3/11.
 */
@Data
public
class ProductForm {

    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态 0正常,1下架
    //private Integer productStatus;
    //类目编号
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
