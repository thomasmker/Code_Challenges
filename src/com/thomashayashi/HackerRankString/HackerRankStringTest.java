package com.thomashayashi.HackerRankString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
class HackerRankStringTest {
    @Test
    void checkString(){
        assertEquals("YES", hackerrankInString("hackerrank"));
        assertEquals("YES", hackerrankInString("hereiamstackerrank"));
        assertEquals("NO", hackerrankInString("hackerworld"));
    }

    private String hackerrankInString(String s) {
        String str = "hackerrank";
        if (s.length() < str.length())
            return "NO";

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < str.length() && s.charAt(i) == str.charAt(j))
                j++;
        }

        return j == str.length() ? "YES" : "NO";
    }
}
