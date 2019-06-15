package com.ghj.kkxspringboot.exception;

import com.ghj.kkxspringboot.common.CodeMessageEnum;

import javax.management.RuntimeMBeanException;

public class MyException   extends RuntimeException {


    private  String  code;
    public  MyException(CodeMessageEnum codeMessageEnum){
        this(codeMessageEnum.getCode(),codeMessageEnum.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MyException() {
    }

    public MyException(String code,String message) {
        super(message);
        this.code = code;
    }

    public MyException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public MyException(String code,Throwable cause) {
        super(cause);
        this.code = code;
    }

    public MyException(String code,String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
