package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
  public static void main(String[] args) {
    CountDownLatch countDownLatch = new CountDownLatch(2);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(()->{
      try {
        System.out.println("task 1 start");
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {

      }
      countDownLatch.countDown();
    });
    executorService.submit(()->{
      try {
        System.out.println("task 2 start");
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {

      }
      countDownLatch.countDown();
    });
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
    System.out.println("end");
  }
}
