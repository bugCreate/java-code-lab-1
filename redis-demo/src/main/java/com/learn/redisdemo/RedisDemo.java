package com.learn.redisdemo;

import redis.clients.jedis.Jedis;

public class RedisDemo {
  public static void main(String[] args) {
    Jedis jedis = new Jedis("localhost", 6379);
    User user = new User("luffy", 10);

    jedis.hset("luffy", user.toMap());
    User gUser = User.transform(jedis.hgetAll("luffy"));
    System.out.println(gUser.getName());
  }
}
