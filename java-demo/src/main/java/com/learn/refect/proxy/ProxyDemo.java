package com.learn.refect.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        MsgService msgService = (MsgService) JdkProxyFactory.getProxy(new PrintMsgService());
        msgService.send("demo");
    }
}
