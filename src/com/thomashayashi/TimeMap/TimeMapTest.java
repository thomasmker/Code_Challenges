package com.thomashayashi.TimeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/time-based-key-value-store/
 */
class TimeMapTest {
    TimeMap map;

    @BeforeEach
    void init() {
        map = new TimeMap();
    }

    @Test
    void checkKnownTimeMap(){
        map.set("foo", "bar1", 1);
        map.set("foo", "bar2", 2);
        map.set("foo", "bar3", 3);

        assertEquals("bar1", map.get("foo", 1));
        assertEquals("bar2", map.get("foo", 2));
        assertEquals("bar3", map.get("foo", 3));
    }

    @Test
    void checkUnknownTimeMap(){
        map.set("foo", "bar", 1);
        assertEquals("", map.get("fo", 1));
    }

    @Test
    void checkUnknownTimeStamp(){
        map.set("foo", "bar", 1);
        assertEquals("", map.get("fo", 2));
    }
}

