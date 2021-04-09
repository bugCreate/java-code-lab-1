package com.learn.refect.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CGLIBDemo {
    public static void main(String[] args) {
        PrintMsgService printMsgService = (PrintMsgService) CglibProxyFactory.getProxy(PrintMsgService.class);
        printMsgService.send("demo");
    }
}
