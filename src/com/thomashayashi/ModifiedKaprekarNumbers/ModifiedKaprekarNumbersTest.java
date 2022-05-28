package com.thomashayashi.ModifiedKaprekarNumbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
class ModifiedKaprekarNumbersTest {
    @Test
    void checkKaprekar(){
        assertEquals(Arrays.asList(1,9), kaprekarNumbers(1,10));
        assertEquals(Arrays.asList(45,55), kaprekarNumbers(40,60));
    }

    private List<Integer> kaprekarNumbers(int p, int q) {
        List<Integer> kaprekar = new ArrayList<>();
        for(int i = p; i <=q; i++) {
            int digits = String.valueOf(i).length();
            String square = String.valueOf((long)Math.pow(i, 2));

            long right, left = 0;
            if(square.length() > 1)
                left = Long.parseLong(square.substring(0,square.length() - digits));

            right = Long.parseLong(square.substring(square.length() - digits));

            if(left + right == (long)i)
                kaprekar.add(i);
        }

        return kaprekar;
    }
}
