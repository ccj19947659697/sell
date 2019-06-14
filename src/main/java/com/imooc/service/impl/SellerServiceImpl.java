package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by home on 2019/3/12.
 */
@Service
public
class SellerServiceImpl {
    @Autowired
    private
    SellerInfoRepository repository;

    public
    SellerInfo findSellerInfoByOpenid(String openid){
        return repository.findByOpenid(openid);
    }


}
