package com.learn.redisdemo;

import java.util.HashMap;
import java.util.Map;

public class User {
  private String name;
  private int age;

  public User() {
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Map<String, String> toMap() {
    Map<String, String> result = new HashMap<>();
    result.put("name", name);
    result.put("age", String.valueOf(age));
    return result;
  }

  public static User transform(Map<String, String> attrs) {
    User user = new User();
    user.setName( attrs.get("name"));
    user.setAge(Integer.valueOf(attrs.get("age")) );
    return user;
  }
}
