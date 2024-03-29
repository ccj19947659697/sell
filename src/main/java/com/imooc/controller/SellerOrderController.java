package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端订单
 * Created by home on 2019/3/4.
 */
@Controller
@RequestMapping("/order")
@Slf4j
public
class SellerOrderController {
    @Autowired
    private
    OrderService orderService;
    /**订单列表
     * @param page 第几页,从第一页开始
     * @param size 一页有多少数据
     * @return
     * */
    @GetMapping("/list")
    public
    ModelAndView list(@RequestParam(value = "page",defaultValue ="1" ) Integer page,
                      @RequestParam(value = "size",defaultValue = "10") Integer size,
                      Map<String,Object> map){
        PageRequest request = new PageRequest(page - 1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage",orderDTOPage);
       //orderDTOPage.getTotalPages();
       map.put("currentPage",page);
       map.put("size",size);
        return new ModelAndView("/order/list",map );
    }
    /**
     * 取消订单
     * @param  orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView canacel(@RequestParam("orderId") String orderId,
                                Map<String,Object>map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e){
            log.error("[卖家端取消订单] 发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/order/list");
            return new ModelAndView("common/erro",map);
        }
       // orderService.cancel(orderDTO);
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/order/list");
       return new ModelAndView("common/succe");
    }

    /**
     * 订单详情
     * @param  orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                             Map<String, Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
             }
            map.put("orderDTO", orderDTO);
            return new ModelAndView("/order/detail", map);
         }

    /**
     * 订单完结
     * @param  orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
                                 Map<String,Object> map){
        try{
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.finish(orderDTO);
        }catch (SellException e) {
            log.error("【卖家端订单完结】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/order/list");
        return new ModelAndView("common/succe");
    }
    @GetMapping("/hello")
    public String hello(){
        return "123";
    }
}
