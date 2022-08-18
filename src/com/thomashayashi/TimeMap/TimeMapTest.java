package com.thomashayashi.TimeMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/time-based-key-value-store/
 */
class TimeMapTest {
    TimeMap map;

    @Test
    void checkKnownTimeMap(){
        map = new TimeMap();
        map.set("foo", "bar", 1);
        assertEquals("bar", map.get("foo", 1));
    }

    @Test
    void checkUnknownTimeMap(){
        map = new TimeMap();
        map.set("foo", "bar", 1);
        assertEquals("", map.get("fo", 1));
    }
}

