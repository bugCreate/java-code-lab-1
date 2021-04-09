package com.learn.collection.queue;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * 只有延迟时间到达后才能查询到
 * */
public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Item> queue = new DelayQueue<>();
        Item item = new Item(1,System.currentTimeMillis()+1000);
        Item item1 = new Item(3,System.currentTimeMillis()+3000);
        Item item2 = new Item(5,System.currentTimeMillis()+5000);
        queue.offer(item);
        queue.offer(item1);
        queue.offer(item2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(queue.poll().key);
        System.out.println(queue.poll());

    }
    static class Item implements Delayed {
        private Integer key;
        private long runAt;

        public Item(Integer key, long runAt) {
            this.key = key;
            this.runAt = runAt;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return runAt - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            Item i = (Item) o;
            return key.compareTo(i.key);
        }
    }
}
