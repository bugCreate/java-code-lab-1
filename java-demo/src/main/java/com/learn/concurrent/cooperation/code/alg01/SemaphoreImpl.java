package com.learn.concurrent.cooperation.code.alg01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/***
 *1)启动 3 个线程，第一个线程打印 0，第二个打印 1，第三个打印 2，然后第一个线程打印 3，依次类推，直到打 印指定的数字为止，例如 20
 */


public class SemaphoreImpl {

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(3);

    public static void main(String[] args) {
        Semaphore Asemaphore = new Semaphore(1);
        Semaphore Bsemaphore = new Semaphore(1);
        Semaphore Csemaphore = new Semaphore(1);
        try {
            Bsemaphore.acquire();
            Csemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread athread = new MyThread("A", Asemaphore, Bsemaphore);
        MyThread bthread = new MyThread("B", Bsemaphore, Csemaphore);
        MyThread cthread = new MyThread("C", Csemaphore, Asemaphore);
        threadPool.execute(athread);
        threadPool.execute(bthread);
        threadPool.execute(cthread);
    }
}


class MyThread implements Runnable {
    private String name;
    private Semaphore mySemaphore;
    private Semaphore nextSemaphore;
    private static volatile Integer num = 1;

    public MyThread(String name, Semaphore mySemaphore, Semaphore nextSemaphore) {
        this.name = name;
        this.mySemaphore = mySemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        try {
            while (num <= 20) {

                mySemaphore.acquire();
                if (num > 20) {
                    break;
                }
                System.out.println(name + ":" + num++);
                nextSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}