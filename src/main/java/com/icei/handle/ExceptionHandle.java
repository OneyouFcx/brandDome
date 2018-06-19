package com.icei.handle;

import com.icei.domain.Result;
import com.icei.exception.IceiExeption;
import com.icei.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=  LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //判断是否为自定义异常
        if (e instanceof IceiExeption){
            IceiExeption girlExeption= (IceiExeption) e;
            logger.error(girlExeption.getMessage(),e);
            return ResultUtil.error(girlExeption.getCode(),girlExeption.getMessage());
        }else {
            logger.error("系统异常",e);
            return ResultUtil.error(-1,"系统异常");
        }
    }
}
