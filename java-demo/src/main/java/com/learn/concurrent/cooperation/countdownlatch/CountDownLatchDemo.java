package com.learn.concurrent.cooperation.countdownlatch;

import java.util.concurrent.*;

/**
 * count down latch 是一次性的，为了多个线程能够在某一时刻能同时执行
 * */
public class CountDownLatchDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Customer customer1 = new Customer("sam",countDownLatch,1);
        Customer customer2 = new Customer("tom",countDownLatch,3);
        Customer customer3 = new Customer("lily",countDownLatch,4);
        Customer customer4 = new Customer("lucy",countDownLatch,2);
        Guider guider = new Guider(countDownLatch);
        executorService.submit(customer1);
        executorService.submit(customer2);
        executorService.submit(customer3);
        executorService.submit(customer4);
        executorService.submit(guider);
        TimeUnit.SECONDS.sleep(30);
        executorService.shutdown();
    }
}
