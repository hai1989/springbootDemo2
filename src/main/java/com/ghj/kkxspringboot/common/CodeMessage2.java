package com.ghj.kkxspringboot.common;

public class CodeMessage2 {

    private String  code;
    private String  message;

    public static  final   CodeMessage2 NOT_FOUND =
            new CodeMessage2("404","没找到");
    public static  final   CodeMessage2 CHECK_FAIL =
            new CodeMessage2("700700","字段验证失败");
    public static  final   CodeMessage2 UN_KNOW =
            new CodeMessage2("999999","程序员去了");


    public CodeMessage2(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
