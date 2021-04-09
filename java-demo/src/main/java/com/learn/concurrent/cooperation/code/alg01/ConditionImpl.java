package com.learn.concurrent.cooperation.code.alg01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用一个condition，线程自己判断唤醒后是否需要打印
 * */
public class ConditionImpl {
    private static volatile int num = 0;
    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(3);

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        PrintThread t1 = new PrintThread(0, condition, reentrantLock, 1);
        PrintThread t2 = new PrintThread(1, condition, reentrantLock, 2);
        PrintThread t3 = new PrintThread(2, condition, reentrantLock, 3);
        threadPool.submit(t1);
        threadPool.submit(t2);
        threadPool.submit(t3);
    }

    static class PrintThread implements Runnable {

        private int yu;
        private Condition condition;
        private ReentrantLock lock;
        private int name;

        public PrintThread(int yu, Condition condition, ReentrantLock lock, int name) {
            this.yu = yu;
            this.condition = condition;
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {


            while (true) {
                if (num >= 20) {
                    break;
                }
                try {
                    lock.lock();

                    if (num % 3 != yu) {
                        condition.await();
                    }
                    // 由于await 会阻塞，唤醒时num 可能大于20，需要唤醒后再判断一次
                    if (num > 20) {
                        break;
                    }
                    if (num%3==yu){
                        System.out.println("thread" + name + ":" + num);
                        condition.signalAll();
                        num++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }

        }
    }
}
