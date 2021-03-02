package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureDemo {
  static ExecutorService pool = Executors.newFixedThreadPool(2);
  static ExecutorService pool2 = Executors.newFixedThreadPool(2);
  static ExecutorService pool3 = Executors.newCachedThreadPool();

  public static void main(String[] args) throws ExecutionException, InterruptedException {
//    Callable<String> callable = () -> {
//      System.out.println("callable in.");
//      TimeUnit.SECONDS.sleep(5);
//      return "done";
//    };
//    ExecutorService executorService = Executors.newSingleThreadExecutor();
//    Future<String> future = executorService.submit(callable);
//    System.out.println("main continue....");
//    // get 会阻塞等待
//    String result = future.get();
//    System.out.println("result:" + result);
//    executorService.shutdown();

    Callable<String> s = () -> {
      System.out.println("start");
      try {
        TimeUnit.SECONDS.sleep(12);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "1";
    };
    for (int i = 0; i < 20; i++) {
      pool.submit(s);
      pool2.submit(s);
      pool3.submit(s);
    }
    TimeUnit.SECONDS.sleep(3000);
  }
}

