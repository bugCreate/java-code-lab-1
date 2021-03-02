package demo.common;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncInterDemo {
  public static void main(String[] args) {
    // consumer 消费型接口，可以接收参数，但没有返回值
    Consumer<String> consumer = System.out::println;
    consumer.accept("hello");
    // consumer 提供default 方法andThen 将两个consumer 顺序执行
    Consumer<String> consumer2 = (s) -> System.out.println(s + " world");
    consumer.andThen(consumer2).accept("hello");
    // BiConsumer 可以接收两个参数
    BiConsumer<Integer, Integer> biConsumer = (i, j) -> {
      System.out.println("i+j=" + (i + j));
    };
    biConsumer.accept(10, 2);

    // jdk 还提供基本数据的consumer
    // 例如IntConsumer、DoubleConsumer

    // Supplier 供给型接口，无参数。有返回值
    Supplier<String> stringSupplier = () -> "hello world";
    System.out.println(stringSupplier.get());
    // Supplier 没有参数所有没有BiSupplier
    // 但是jdk 默认提供基本数据的Supplier，例如DoubleSupplier
    // Supplier 没有default 方法
    Function<String, Integer> function = Integer::valueOf;
    System.out.println(function.apply("2"));
    // function 提供compose 和andThen 两个default 方法
    //compose 是在当前function 执行计算，将计算几个传递给当前func，andThen 是将当前计算结果传递给下个func
    // Function 还有一个static 方法，identity，返回传入的值
    Function<Integer, Integer> plus = s -> s + 2;
    Function<Integer, Integer> mi = s -> s - 1;
    // (s-1)+2-1 =s
    plus.compose(mi).andThen(mi).apply(5);
    // 可用于创建责任链
    // Function 有BiFunction，可以接收两个参数
    // BiFunction 没有compose
    BiFunction<Integer, Integer, String> biFunction = (j, i) -> "llla" + j + "LLL" + i;
    biFunction.apply(10, 20);
    // 基本数据类型。。。。

    // Predicate 断言，判断函数，返回bool
    Predicate<String> predicate = s -> s.length() > 10;
    System.out.println(predicate.test("sssssssssssss"));
    Predicate<String> con = s -> s.contains("a");
    predicate.and(con).test("aaaaaaaaaaaaaaa");
    // predicate 还支持and ，or 和非
    // BiPredicate 支持两个参数的断言
  }


}
