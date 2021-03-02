package demo.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class LinkedListDemo {
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(4);
    linkedList.add(6);
    linkedList.add(10);
    linkedList.addFirst(11);
    linkedList.addLast(50);
  }
}
