package demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectDemo {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 3, 4, 56, 7, 8, 2);
    /**
     * 计数：count
     * 平均值：averagingInt、averagingLong、averagingDouble
     * 最值：maxBy、minBy
     * 求和：summingInt、summingLong、summingDouble
     * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
     * */
    Double aver = list.stream().collect(Collectors.averagingDouble(s -> s));

    // 分组 partitioningBy/groupingBy
    Map<Boolean, List<Integer>> part = list.stream().collect(Collectors.partitioningBy(s -> s > 5));

    List<Person> personList = new ArrayList<Person>();
    personList.add(new Person("Tom", 8900, "male", "New York"));
    personList.add(new Person("Jack", 7000, "male", "Washington"));
    personList.add(new Person("Lily", 7800, "female", "Washington"));
    personList.add(new Person("Anni", 8200, "female", "New York"));
    personList.add(new Person("Owen", 9500, "male", "New York"));
    personList.add(new Person("Alisa", 7900, "female", "New York"));
    Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
    Map<String, Map<String, List<Person>>>
        group2 =
        personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getName)));
    //join
    String names = personList.stream().map(Person::getName).collect(Collectors.joining(","));
  }

  static class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person(String name, int salary, String sex, String area) {
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
