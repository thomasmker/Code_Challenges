package com.thomashayashi.CamelCase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/camelcase/problem
 */
class CamelCaseTest {
    @Test
    void checkNumberOfWords(){
        assertEquals(2, camelcase("oneTwo"));
        assertEquals(3, camelcase("oneTwoThree"));
    }

    private int camelcase(String s) {
        return s.split("[A-Z]").length;
    }
}
