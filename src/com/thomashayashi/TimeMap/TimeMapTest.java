package com.thomashayashi.TimeMap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/time-based-key-value-store/
 */
class TimeMapTest {
    HashMap<String, List<Map.Entry<String, Integer>>> map;

    @Test
    void checkTimeMap(){
        map = new HashMap<>();
        set("foo", "bar", 1);
        assertEquals("bar", get("foo", 1));
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new AbstractMap.SimpleEntry<>(value, timestamp) {
        });
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Map.Entry<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    public String search(List<Map.Entry<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).getValue() <= timestamp) start = mid; else end =
                    mid - 1;
        }
        return list.get(start).getValue() <= timestamp
                ? list.get(start).getKey()
                : "";
    }
}
