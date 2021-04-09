package com.learn.refect.proxy.cglib;

public class PrintMsgService {
    public String send(String msg){
        System.out.println("send msg:"+msg);
        return msg;
    }
}
