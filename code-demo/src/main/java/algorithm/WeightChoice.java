package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 权重选择算法
 */
public class WeightChoice {
  private TreeMap<Integer, String> section = new TreeMap<>();
  private Integer sum = 0;
  private Random random = new Random();

  public WeightChoice(Map<String, Integer> weights) {
    tramform(weights);
  }

  private void tramform(Map<String, Integer> weights) {
    weights.entrySet().forEach(s -> {
      sum += (s.getValue()*10);
      section.put(sum, s.getKey());
    });
  }

  public String getNext() {
    int nextnum = random.nextInt(sum);
    SortedMap<Integer, String> tmp = section.tailMap(nextnum);
    return tmp.get(tmp.firstKey());
  }

  public static void main(String[] args) {
    Map<String, Integer> weights = new HashMap<>();
    weights.put("sam", 1);
    weights.put("john", 2);
    weights.put("tom", 4);
    weights.put("lili", 3);
    WeightChoice weightChoice = new WeightChoice(weights);
    Map<String, Integer> result = new HashMap<>();
    result.put("sam", 0);
    result.put("john", 0);
    result.put("tom", 0);
    result.put("lili", 0);
    for (int i = 0; i < 10000000; i++) {
      String next = weightChoice.getNext();
      result.put(next, result.get(next) + 1);
    }
    result.entrySet().forEach(s -> {
      System.out.println("key:" + s.getKey() + ",value:" + s.getValue());
    });
  }
}

