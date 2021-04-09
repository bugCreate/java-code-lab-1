package com.learn.refect.proxy;

public class PrintMsgService implements MsgService {
    @Override
    public void send(String msg) {
        System.out.println("print msg:"+msg);
    }
}
