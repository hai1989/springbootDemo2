package com.ghj.kkxspringboot.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class HttpLogAop {

    @Pointcut("execution(public * com.ghj.kkxspringboot.controller.*.*(..))")
    public  void  log(){}

    @Before("log()")
    public void  before(JoinPoint joinPoint){

        //获取HttpServetRquest
        ServletRequestAttributes requestAttributes  = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest  request = requestAttributes.getRequest();
        //记录请求的信息：url ip   请求方式  参数  等等
        log.info("IP:"+request.getRemoteAddr());
        log.info("URI:"+request.getRequestURI());
        log.info("URL:"+request.getRequestURL());
        log.info("method:"+request.getMethod());

        Map<String,String []> parameter = request.getParameterMap();

        for(String key:parameter.keySet()){
            log.info("parameters:"+key+"="+ Arrays.toString(parameter.get(key)));
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            log.info("Header:"+headerName+"="+request.getHeader(headerName));
        }
        //记录请求了那个方法、类、方法、参数
        log.info("请求方法："+joinPoint.getSignature().getDeclaringTypeName()
                +"."+joinPoint.getSignature().getName());
        log.info("方法参数"+Arrays.toString(joinPoint.getArgs()));

//        System.out.println("请求前执行:"+ System.currentTimeMillis());

    }

    @After("execution(public * com.ghj.kkxspringboot.controller.*.*(..))")
    public void  after(){

        log.info("请求后执行:"+ System.currentTimeMillis());
    }

    @AfterReturning(pointcut = "log()",returning = "obj")
    public void returnObject(Object obj){

        log.info("响应结果："+ JSON.toJSONString(obj));
    }
}
