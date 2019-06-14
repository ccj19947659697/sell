package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderFrom2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by home on 2019/3/1.
 */
@RestController
//意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
@RequestMapping("/buyer/order")
@Slf4j
public
class BuyerOrderController {
    @Autowired
    private
    OrderService orderService;
    @Autowired
    private
    BuyerService buyerService;
    //创建订单
    @PostMapping("/create")
  public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                             BindingResult bindingResult){
      if ( bindingResult.hasErrors() ){
          log.error("[创建订单] 参数不正确,orderForm={}",orderForm);
          throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                  bindingResult.getFieldError().getDefaultMessage());
      }
      OrderDTO orderDTO = OrderFrom2OrderDTOConverter.convert(orderForm);
      if ( CollectionUtils.isEmpty(orderDTO.getOrderDetailList()) ){
          log.error("[创建订单] 购物车不能为空");
          throw new SellException(ResultEnum.CART_EMPTY);
      }
      OrderDTO createResult = orderService.create(orderDTO);
      Map<String,String> map = new HashMap<>();
      map.put("orderId",createResult.getOrderId());
      return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                     @RequestParam(value = "page",defaultValue = "0") Integer page,//用默认值
                                     @RequestParam(value = "size",defaultValue = "10") Integer size){
      if( StringUtils.isEmpty(openid)){
          log.error("[查询订单列表] openid 为空");
          throw new SellException(ResultEnum.PARAM_ERROR);
      }
      PageRequest request =new PageRequest(page,size);
      Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
      //转存Date->Long
      return ResultVOUtil.success(orderDTOPage.getContent());//得到当前的第几页
        //return ResultVOUtil.success();//由于配置文件的设置,Data为空就不会返回了
       // orderDTOPage.getTotalElements(),得到总数
}

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
//   //TODO 不安全做法,改进
//    OrderDTO orderDTO = orderService.findOne(orderId);
//    return ResultVOUtil.success(orderDTO);
        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
//        //TODO 不安全做法,改进
//        OrderDTO orderDTO = orderService.findOne(orderId);
//        orderService.cancel(orderDTO);
//        return ResultVOUtil.success();
        OrderDTO orderDTO = buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();

}


}
