package com.thomashayashi.FunnyString;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://www.hackerrank.com/challenges/funny-string/problem
 */
class FunnyStringTest {
    @Test
    void checkString(){
        assertTrue(funnyString("acxz"));
        assertFalse(funnyString("bcxz"));
    }

    public boolean funnyString(String s) {
        List<Integer> ascii = new ArrayList<>();
        for(char c : s.toCharArray())
            ascii.add((int)c);

        List<Integer> difference = new ArrayList<>();
        for(int i = 0; i < ascii.size() - 1; i++)
            difference.add(Math.abs(ascii.get(i) - ascii.get(i + 1)));

        List<Integer> reverseDifference = new ArrayList<>(difference);
        Collections.reverse(reverseDifference);

        return difference.equals(reverseDifference);
    }
}
