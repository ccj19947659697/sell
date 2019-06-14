package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by home on 2019/2/26.
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL),做一个全局变量,在配置文件中设置,所有返回值为NULL在前端不显示
public
class OrderDTO {
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
    private Integer orderStatus;//使用枚举
    //支付状态,默认0为未支付
    private Integer payStatus;//使用枚举
    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    List<OrderDetail> orderDetailList;
    // List<OrderDetail> orderDetailList = new ArrayList<>() 返回字符处理;
    @JsonIgnore//对象转格式Json格式,会忽略这个方法
    public OrderStatusEnum getOrderStatusEnum(){

        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class );
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
