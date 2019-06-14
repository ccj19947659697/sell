package com.imooc.hander;

import com.imooc.VO.ResultVO;
import com.imooc.exception.ResponseBankException;
import com.imooc.exception.SellException;
import com.imooc.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by home on 2019/3/13.
 */
@ControllerAdvice
public
class SellExceptionHandler {
    @ExceptionHandler(value= SellException.class)
    @ResponseBody
    public
    ResultVO handlerSellerException(SellException e){

        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
@ExceptionHandler(value= ResponseBankException.class)
@ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){

}
}
