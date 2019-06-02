package com.ghj.kkxspringboot.common;

import lombok.Data;

@Data
public class Result {

    private  String  code;
    private  String  message;
    private  Object  data;
}
