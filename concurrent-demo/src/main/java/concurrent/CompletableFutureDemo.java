package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class CompletableFutureDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture.runAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("ssss");
    });
    System.out.println("aaaa");
    TimeUnit.SECONDS.sleep(4);
    System.out.println("done");

    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("lalala");
      return "ok";
    });
    System.out.println(future.get());


  }

  private static void completeDemo() {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("start..");
      return "hello";
    });
    future.whenComplete(new BiConsumer<String, Throwable>() {
      @Override
      public void accept(String s, Throwable throwable) {
        System.out.println(s);
      }
    });
    future.exceptionally(e -> {
      System.out.println(e);
      return "hi";
    });
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      throw new RuntimeException("error");
    });
    future1.exceptionally(e -> {
      System.out.println(e);
      return "hi";
    });
  }

  private static void thenapplyDemo() {
    CompletableFuture.runAsync(() -> System.out.println("llll")).thenApply(s -> {
      System.out.println("ssssss");
      return "asda";
    });
  }

  private static void combine() throws ExecutionException, InterruptedException {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "world");
    CompletableFuture<String> result= future.thenCombine(future2, (s, s2) -> s + " " + s2);
    System.out.println(result.get());
  }
}
