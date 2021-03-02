package base.demo;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class BaseReactorDemo {
  public static void main(String[] args) {
//    Flux<Integer> ints = Flux.range(1, 4).map(i -> {
//      if (i < 3) {
//        return i;
//      }
//      throw new RuntimeException("ada");
//    });
//    ints.subscribe(System.out::println, e -> System.out.println("Error: " + e));
    List<String> aa= new ArrayList<>();
    aa.add("aa");
    List<String> asub = aa.subList(0,3);
    asub.forEach(s-> System.out.println(s));
  }

}
