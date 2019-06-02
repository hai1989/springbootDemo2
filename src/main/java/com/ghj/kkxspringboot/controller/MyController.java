package com.ghj.kkxspringboot.controller;

import com.ghj.kkxspringboot.common.Result;
import com.ghj.kkxspringboot.entity.Student;
import com.ghj.kkxspringboot.properties.UserProperties;
import com.ghj.kkxspringboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {
//    @Value("${age}")
//    private int age;
//    @Value("${count}")
//    private String count;
    @Autowired
    private UserProperties  userProperties;

    @RequestMapping(value = "/test")
    public String test1(){
        return  "hello";
    }

    @GetMapping(value = "test2")
    public Map test2(){
        Map<String,String> map  = new HashMap<>();
        map.put("name",userProperties.getName1());
        map.put("age",userProperties.getAge()+"");
//        map.put("toString",userProperties.toString());
//        map.put("count",count);
        return  map;
    }



//    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public Result test3(){
//        Result  result  = new Result();
        Student  student  = new Student();
        student.setAge(11);
        student.setName("哈哈儿");
        student.setId(1);
//        result.setCode("200");
//        result.setMessage("success");
//        result.setData(student);
        return ResultUtil.success(student);
//        return  result;
    }

    //有参数的
    @GetMapping(value = "/test4")
    public  String   test4(String name){

        System.out.println(">>>>>>"+name);
        if(name.endsWith("大叔")){
            return "hello";
        }
        else{
            return "name错误";
        }
    }

    @GetMapping(value = "/test5/{id1}")
    public  String  test5(@PathVariable(value = "id1") int id){
        if(id==1){
            return  "one";
        }
        else {
            return "other";
        }
    }

    @PostMapping(value = "/test6")
    public  Student  test6(@RequestBody Student student){

        System.out.println(student.getName());
        return  student;
    }
}