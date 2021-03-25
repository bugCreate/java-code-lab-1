package com.learn.redisdemo;

import java.util.Map;

public class UserUtil {
  public static User transform(Map<String,String> attrs){
    User user = new User();
    attrs.entrySet().forEach(e->{
      String setMethod="set"+e.getKey().toUpperCase().substring(0, 1)+e.getKey().substring(1);

    });
  }
}
