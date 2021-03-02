package demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreateDemo {
  public static void main(String[] args) {
    // collection创建
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> stream = list.stream();
    Stream<String> parStream = list.parallelStream();
    // 数组创建
    int[] array = {1, 2, 3, 4, 5, 87};
    IntStream intStream = Arrays.stream(array);
    // stream 静态方法
    Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 56);
    Stream<Integer> stream2 = Stream.iterate(0, x -> x + 3).limit(4);
    Stream<Double> stream3 = Stream.generate(Math::random).limit(6);
  }
}
