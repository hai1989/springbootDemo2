package com.ghj.kkxspringboot.config;

import com.ghj.kkxspringboot.common.CodeMessageEnum;
import com.ghj.kkxspringboot.common.Result;
import com.ghj.kkxspringboot.exception.MyException;
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
        if(e  instanceof MyException){
            MyException   myException   =  (MyException) e;
            return  ResultUtil.error(myException.getCode(),myException.getMessage());
        }
        return ResultUtil.error(CodeMessageEnum.UN_KNOW);
    }
}
