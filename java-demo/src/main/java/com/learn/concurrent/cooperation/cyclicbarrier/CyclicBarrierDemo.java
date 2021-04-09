package com.learn.concurrent.cooperation.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * cyclicbarrier 与countdownlatch 的区别是，cyclicbarrier 支持重用
 * */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            // 模拟上课
            try {
                System.out.println("上课了");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("下课了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Student student = new Student(cyclicBarrier,"tom");
        Student student1 = new Student(cyclicBarrier,"sam");
        Student student2 = new Student(cyclicBarrier,"lily");
        Student student3 = new Student(cyclicBarrier,"lucy");
        executorService.submit(student);
        executorService.submit(student1);
        executorService.submit(student2);
        executorService.submit(student3);
        TimeUnit.SECONDS.sleep(30);
        executorService.shutdown();
    }
}
