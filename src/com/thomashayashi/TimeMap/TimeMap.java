package com.thomashayashi.TimeMap;

import java.util.*;

class TimeMap {
    private final HashMap<String, List<Map.Entry<String, Integer>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new AbstractMap.SimpleEntry<>(value, timestamp) {});
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Map.Entry<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    private String search(List<Map.Entry<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).getValue() <= timestamp)
                start = mid;
            else
                end = mid - 1;
        }
        Map.Entry<String, Integer> entry = list.get(start);
        return  entry.getValue() <= timestamp ? entry.getKey() : "";
    }
}
