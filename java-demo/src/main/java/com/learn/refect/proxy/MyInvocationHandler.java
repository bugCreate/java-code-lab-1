package com.learn.refect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method "+ method.getName());
        Object result = method.invoke(target,args);
        System.out.println("after method "+ method.getName());
        return result;
    }
}
