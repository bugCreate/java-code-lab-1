package com.learn.concurrent.cooperation.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreThread implements Runnable {
    private int name;
    private Semaphore semaphore;

    public SemaphoreThread(int name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("thread"+name+" get semaphore");
            TimeUnit.SECONDS.sleep(1);
            semaphore.release();
            System.out.println("thread"+name+" release semaphore");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
