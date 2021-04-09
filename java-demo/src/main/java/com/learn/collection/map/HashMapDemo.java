package com.learn.collection.map;

import java.util.HashMap;

/***
 *HashMap 基本演示代码
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 基础用法
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("sam",10);
        map1.put("tom",11);
        map1.containsKey("lily");
        map1.getOrDefault("lily",20);

        //java 8
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("a", "H");
        hashMap.put("b", "J");
        hashMap.put("c", "K");
        // compute,但key 不存在时v=null
        hashMap.entrySet().forEach(
                e -> {
                    hashMap.compute(e.getKey(), (k, v) -> {
                        return v.toLowerCase();
                    });
                }
        );
        System.out.println(hashMap);
        // key 不存在时，增加映射
        hashMap.computeIfAbsent("d", (k) -> {
            return "L";
        });
        System.out.println(hashMap);
        // 当key 存在且v不等于null 的时候才参与计算
        hashMap.computeIfPresent("d", (k, v) -> {
            return v.toLowerCase();
        });
        // merge 合并map 中的值与新值，合并操作需要自定义function，可以是任意方式处理数据。
        HashMap<String, Student> hashMap1 = new HashMap<>();
        hashMap1.put("1", new Student("sam", "yuwen", 30));
        hashMap1.put("2", new Student("sam", "shuxue", 60));
        hashMap1.put("3", new Student("sam", "yingyu", 70));
        hashMap1.put("4", new Student("tom", "shuxue", 80));
        hashMap1.put("5", new Student("tom", "yingyu", 20));
        HashMap<String, Integer> strdentScores = new HashMap<>();
        hashMap1.forEach((k, v) -> {
            strdentScores.merge(v.getName(), v.getScore(), Integer::sum);
        });
        System.out.println(strdentScores);
    }
}
