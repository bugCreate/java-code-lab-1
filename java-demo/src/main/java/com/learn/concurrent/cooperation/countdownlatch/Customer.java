package com.learn.concurrent.cooperation.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Customer implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private int time;
    private Random random = new Random();

    public Customer(String name, CountDownLatch countDownLatch, int time) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println(name+" 到达");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
