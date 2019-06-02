package com.ghj.kkxspringboot.config;

import com.ghj.kkxspringboot.common.Result;
import com.ghj.kkxspringboot.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest req, Exception e){
//        Result  result  =  new Result();
//        result.setCode("99999");//错误
//        result.setMessage("系统异常");
//        result.setData("[null]");
//        return result;

        return ResultUtil.error("100","fail");
    }
}
