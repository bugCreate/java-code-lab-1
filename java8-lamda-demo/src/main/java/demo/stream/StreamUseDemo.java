package demo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUseDemo {
  public static void main(String[] args) {
    // 遍历foreach/find/match
    List<Integer> list = Arrays.asList(4, 5, 6, 77, 1, 2, 5, 72);
    // 遍历所有
    list.stream().filter(x -> x > 6).forEach(System.out::println);
    // 匹配1个
    Optional<Integer> findFirst = list.stream().filter(s -> s > 6).findFirst();
    // 匹配任意（适用于并行流）
    Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
    // 是否包含符合特定条件的元素
    boolean anyMatch = list.stream().anyMatch(x -> x < 6);

    // 聚合 max、min、count
    List<String> strList = Arrays.asList("asda", "adasdas", "asdacadfa", "ss", "asdasca");
    Optional<String> max = strList.stream().max(Comparator.comparing(String::length));
    long count = list.stream().filter(s -> s > 6).count();

    // 映射 map、flatmap
    List<String> upStrList = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
    // flatmap
    List<String> strList1 = Arrays.asList("m,l,n,k", "1,3,4,6");
    List<String> strListNew = strList1.stream().flatMap(s -> {
      String[] split = s.split(",");
      Stream<String> s2 = Arrays.stream(split);
      return s2;
    }).collect(Collectors.toList());
    //处理前的集合：[m,k,l,a, 1,3,5]
    //处理后的集合：[m, k, l, a, 1, 3, 5]

    // 归约 reduce
    Optional<Integer> sum = list.stream().reduce(Integer::sum);
    // 排序 sorted
    List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

    // 提取、组合
    // 去重、限制、跳过
    String[] arr1 = {"a", "b", "c", "d"};
    String[] arr2 = {"d", "e", "f", "g"};

    Stream<String> stream1 = Stream.of(arr1);
    Stream<String> stream2 = Stream.of(arr2);
    // 去重
    List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
    List<Integer> collect = Stream.iterate(1, x -> x + 2).skip(1).limit(10).collect(Collectors.toList());
  }

  class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
      this.name = name;
      this.salary = salary;
      this.age = age;
      this.sex = sex;
      this.area = area;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getSalary() {
      return salary;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }

    public String getArea() {
      return area;
    }

    public void setArea(String area) {
      this.area = area;
    }
  }
}
