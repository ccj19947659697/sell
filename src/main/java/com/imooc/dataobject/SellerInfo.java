package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by home on 2019/3/12.
 */
@Data
@Entity
public
class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
}
