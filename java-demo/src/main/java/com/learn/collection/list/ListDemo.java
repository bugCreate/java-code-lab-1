package com.learn.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Thread thread = new Thread(ATest::m,"asd");
    }
}
class ATest{
    static void m(){

    }
}
