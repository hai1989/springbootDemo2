package com.ghj.kkxspringboot.util;

import com.ghj.kkxspringboot.common.CodeMessageEnum;
import com.ghj.kkxspringboot.common.Result;

public class ResultUtil {

    public   static Result success(Object  data){

        Result  result =  new Result();
        result.setCode("200");
        result.setMessage("success");
        result.setData(data);
        return   result;
    }

    public static  Result  error(CodeMessageEnum codeMessageEnum){
        return  error(codeMessageEnum.getCode(),codeMessageEnum.getMessage());
    }

    public static   Result  error(String code ,String  message){
        Result result  = new Result();
//        result.setData("[null]");
        result.setCode(code);
        result.setMessage(message);
        return  result;
    }
}
