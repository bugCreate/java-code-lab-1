package com.learn.collection.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * offer 新增一个元素
 * peek 只查询，不删除
 * poll 查询并删除
 * */
public class QueueBaseDemo {
    public static void main(String[] args) {
        // 继承AbstractQueue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Integer::compareTo);
        pq.offer(1);
        pq.offer(10);
        pq.offer(4);
        pq.peek();
        System.out.println(pq.size());
        pq.poll();
        System.out.println(pq.size());
        pq.forEach(System.out::println);
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        // Dqueue
        LinkedList<Integer> linkedList = new LinkedList<>();
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        linkedList.offerFirst(1);
        linkedList.offerLast(10);
        linkedList.offerLast(11);
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList.pollLast());

    }
}
