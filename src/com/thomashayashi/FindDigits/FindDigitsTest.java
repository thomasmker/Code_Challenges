package com.thomashayashi.FindDigits;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/find-digits/problem
 */
class FindDigitsTest {
    @Test
    void checkDigits(){
        assertEquals(1, findDigits(10));
        assertEquals(2, findDigits(12));
        assertEquals(3, findDigits(124));
        assertEquals(3, findDigits(111));
        assertEquals(3, findDigits(1012));
    }

    private int findDigits(int n) {
        HashMap<Integer, Integer> numOccurrence = new HashMap<>();
        for(char c : String.valueOf(n).toCharArray()) {
            if(c == '0') continue;

            int occurrence = 1;
            Integer num = Integer.parseInt(String.valueOf(c));
            if(numOccurrence.containsKey(num))
                occurrence = numOccurrence.get(num) + 1;

            numOccurrence.put(num, occurrence);
        }

        int divisible = 0;
        for(Integer num : numOccurrence.keySet()) {
            if(n % num == 0)
                divisible += numOccurrence.get(num);
        }

        return divisible;
    }

}
