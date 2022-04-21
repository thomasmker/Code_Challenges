package com.thomashayashi.LonelyInteger;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer/problem
 */
class LonelyIntegerTest {
    @Test
    void checkLonelyNumber(){
        assertEquals(1, getLonelyNumber(Arrays.asList(2,1,2)));
        assertEquals(4, getLonelyNumber(Arrays.asList(1,2,3,4,3,2,1)));
    }

    private int getLonelyNumber(List<Integer> a) {
        HashSet<Integer> lonely = new HashSet<>();
        for(Integer num : a) {
            if(lonely.contains(num))
                lonely.remove(num);
            else
                lonely.add(num);
        }

        return lonely.iterator().next();
    }
}
