package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by home on 2019/2/25.
 */
@Entity
@Data
@DynamicUpdate
public
class OrderMaster {
    @Id
    //订单id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信Openid
    private String buyerOpenid;
    //订单金额
    private BigDecimal orderAmount;
    //订单状态,默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();//使用枚举
    //支付状态,默认0为未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();//使用枚举
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
//    @Transient Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列
//    private List<OrderDetail> orderDetailList;//于数据库对应的时候,会报错,要加注解,不会报错
}
