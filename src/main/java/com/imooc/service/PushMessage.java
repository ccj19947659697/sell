package com.imooc.service;
import com.imooc.dto.OrderDTO;

/**
 * 推送消
 */
public
interface PushMessage {
    /**
     * 订单状态变更的消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
