package com.ghj.kkxspringboot.controller;

import com.ghj.kkxspringboot.common.CodeMessage2;
import com.ghj.kkxspringboot.common.CodeMessageEnum;
import com.ghj.kkxspringboot.common.Result;
import com.ghj.kkxspringboot.exception.MyException;
import com.ghj.kkxspringboot.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c2")
public class MyController2 {


    @GetMapping("/find/{id}")
    public Result test1(@PathVariable int id){

        if(id==1){
            throw new MyException(CodeMessageEnum.UN_KNOW);
        }
        else if(id==2){
            throw  new MyException(CodeMessageEnum.NOT_FDOUND);
        }
        else if (id==3){
            throw  new RuntimeException("12121212");//GlobalExceptionHandler   return ResultUtil.error(CodeMessageEnum.UN_KNOW);  因为UN_KNOW写死了
        }
        return ResultUtil.success(null);
    }

    @GetMapping("/t")
    public  Result  test2(){
        System.out.println("safasfasfsdaf");
        return  ResultUtil.success("121345678976543245");
    }

}
