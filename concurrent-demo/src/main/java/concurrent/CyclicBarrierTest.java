package concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    int breakCount=0;
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(()->{
      try {
        System.out.println("......");
        TimeUnit.SECONDS.sleep(2);
        cyclicBarrier.await();
        System.out.println("'''''''");
        TimeUnit.SECONDS.sleep(1);
        cyclicBarrier.await();
        System.out.println(";;;;;;;;;");
      }catch (Exception e){

      }
    });
    executorService.submit(()->{
      try {
        System.out.println("......");
        TimeUnit.SECONDS.sleep(1);
        cyclicBarrier.await();
        System.out.println("'''''''");
        TimeUnit.SECONDS.sleep(2);
        cyclicBarrier.await();
        System.out.println(";;;;;;;;;");
      }catch (Exception e){

      }
    });
    executorService.shutdown();
  }
}
