package com.learn.concurrent.cooperation.code.alg01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 与Semaphore 基本一样
 * */
public class ConditionImpl2 {
    private static volatile int num = 0;
    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(3);

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        Condition condition3 = reentrantLock.newCondition();
        PrintThread2 t1 = new PrintThread2(0, reentrantLock, condition1, condition2, 1);
        PrintThread2 t2 = new PrintThread2(1, reentrantLock, condition2, condition3, 2);
        PrintThread2 t3 = new PrintThread2(2, reentrantLock, condition3, condition1, 3);

        threadPool.submit(t1);
        threadPool.submit(t2);
        threadPool.submit(t3);

    }

    static class PrintThread2 implements Runnable {
        private int yu;
        private ReentrantLock lock;
        private Condition condition;
        private Condition netxCondition;
        private int name;

        public PrintThread2(int yu, ReentrantLock lock, Condition condition, Condition netxCondition, int name) {
            this.yu = yu;
            this.lock = lock;
            this.condition = condition;
            this.netxCondition = netxCondition;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (num%3!=yu){
                        condition.await();
                    }
                    if (num > 20) {
                        break;
                    }
                    System.out.println("thread" + name + ":" + num);
                    num++;
                    netxCondition.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
