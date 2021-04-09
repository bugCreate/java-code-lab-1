package com.learn.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class School {
    private HashMap<String, String> allClasses = new HashMap<>();

    public Map<String, String> getAllClasses() {
        return Collections.unmodifiableMap(allClasses);
    }
}
