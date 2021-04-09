package com.learn.concurrent.cooperation.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Guider  implements Runnable{
    private CountDownLatch countDownLatch;

    public Guider(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("所有人都到了，出发");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
