package com.learn.concurrent.cooperation.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 * semaphore 类似token
 * */
public class SemaphoreDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(4);
        for (int i =0 ;i<20;i++){
            SemaphoreThread semaphoreThread = new SemaphoreThread(i,semaphore);
            executorService.submit(semaphoreThread);
        }
        TimeUnit.SECONDS.sleep(30);
        executorService.shutdown();
    }
}
