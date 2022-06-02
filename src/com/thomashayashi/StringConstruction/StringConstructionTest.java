package com.thomashayashi.StringConstruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/string-construction/problem
 */
class StringConstructionTest {
    @Test
    void check(){
        assertEquals(1, stringConstruction("a"));
        assertEquals(1, stringConstruction("aa"));
        assertEquals(2, stringConstruction("ab"));
        assertEquals(2, stringConstruction("abab"));
        assertEquals(2, stringConstruction("abba"));
        assertEquals(4, stringConstruction("abcd"));
    }

    private int stringConstruction(String s) {
        return (int)s.chars().distinct().count();
    }
}
