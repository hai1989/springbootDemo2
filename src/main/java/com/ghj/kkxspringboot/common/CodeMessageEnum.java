package com.ghj.kkxspringboot.common;

public enum CodeMessageEnum {

    /*
      public  static  final  CodeMessageEnum NOT_FDOUND
            =  new CodeMessageEnum("404404","没有找到")
     */

    NOT_FDOUND("40404","没有找到"),
    UN_KNOW("999999","程序员去了")
    ;

    private String code;
    private String message;

    CodeMessageEnum(String code, String message) {
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
