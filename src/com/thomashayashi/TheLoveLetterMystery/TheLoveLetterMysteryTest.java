package com.thomashayashi.TheLoveLetterMystery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
 */
class TheLoveLetterMysteryTest {
    @Test
    void checkPalindromeConversion(){
        assertEquals(0, theLoveLetterMystery("abcba"));
        assertEquals(2, theLoveLetterMystery("abc"));
        assertEquals(2, theLoveLetterMystery("cba"));
        assertEquals(4, theLoveLetterMystery("abcd"));
    }

    private int theLoveLetterMystery(String s) {
        int conversions = 0;

        int size = s.length() - 1;
        for(int i = 0; i < s.length() / 2; i++)
            conversions += Math.abs((int)s.charAt(i) - (int)s.charAt(size - i));

        return conversions;
    }
}
