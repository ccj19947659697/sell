package com.imooc.dto;

import lombok.Data;

/**
 * Created by home on 2019/2/26.
 */
@Data
public
class CartDTO {
    //商品Id
    private String productId;
    //数量
    private Integer productQuantity;

    public
    CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
