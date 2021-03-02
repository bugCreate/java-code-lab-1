package demo.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
  public static void main(String[] args) {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(1, "a");
    treeMap.put(6, "s");
    treeMap.put(18, "r");
    treeMap.put(34, "d");
    treeMap.put(88, "x");
    SortedMap<Integer, String> tailMap = treeMap.tailMap(3);
    SortedMap<Integer, String> tailMap2 = treeMap.tailMap(6);
    SortedMap<Integer, String> tailMap3 = treeMap.tailMap(6, false);
    System.out.println(tailMap.get(tailMap.firstKey()));
    System.out.println(tailMap2.get(tailMap2.firstKey()));
    System.out.println(tailMap3.get(tailMap3.firstKey()));
  }
}
