package com.learn.concurrent.cooperation.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;
    private static Random random = new Random();

    public Student(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            System.out.println(name+"到达教室准备上课。");
            TimeUnit.SECONDS.sleep(random.nextInt(4));
            cyclicBarrier.await();
            System.out.println(name+"到达教室准备上第二节课。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
