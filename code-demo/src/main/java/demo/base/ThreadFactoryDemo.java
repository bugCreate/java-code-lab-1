package demo.base;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo {

  class MyThreadFactory implements ThreadFactory {
    private AtomicInteger counter = new AtomicInteger(0);
    private String prefix;
    private String name;

    public MyThreadFactory(String prefix, String name) {
      this.prefix = prefix;
      this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
      Thread thread = new Thread(r, getFullName());
      counter.incrementAndGet();
      return thread;
    }

    private String getFullName() {
      return prefix + "_" + name + "_" + counter.get();
    }

  }
}
