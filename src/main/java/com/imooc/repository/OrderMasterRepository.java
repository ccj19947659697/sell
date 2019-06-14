package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by home on 2019/2/25.
 */
public
interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    //按照买家Openid来查
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}

