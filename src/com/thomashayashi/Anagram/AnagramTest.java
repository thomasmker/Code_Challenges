package com.thomashayashi.Anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/anagram/problem
 */
class AnagramTest {
    @Test
    void checkTeams(){
        assertEquals(-1, anagram("abc"));
        assertEquals(3, anagram("aaabbb"));
    }

    public static int anagram(String s) {
        if(s.length() % 2 == 1)
            return -1;

        StringBuilder a = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder b = new StringBuilder(s.substring(s.length() / 2));

        for (int i =0; i < b.length(); i++) {
            int index = a.indexOf(String.valueOf(b.charAt(i)));
            if (index > -1)
                a.delete(index, index + 1);
        }

        return a.length();
    }
}
