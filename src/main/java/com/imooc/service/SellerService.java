package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by home on 2019/3/12.
 */
public
interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param
     * @return*/
    SellerInfo findSellerInfoByOpenid(String openid);
}
