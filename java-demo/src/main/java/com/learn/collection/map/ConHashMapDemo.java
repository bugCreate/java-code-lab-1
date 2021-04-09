package com.learn.collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 演示代码
 * */
public class ConHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        // init ...
        //

        String value =concurrentHashMap.get("sam");
        // do something
        concurrentHashMap.put("sam",value);
    }

}
