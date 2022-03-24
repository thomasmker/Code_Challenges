package com.thomashayashi.BillDivision;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/bon-appetit/problem
 */
class BillDivisionTest {
    @Test
    void checkSplitBill(){
        assertEquals(5, bonAppetit(Arrays.asList(3,10,2,9),1,12));
        assertEquals(-1, bonAppetit(Arrays.asList(3,10,2,9),1,7));
        assertEquals(-1, bonAppetit(Arrays.asList(10,3,2,9),0,7));
    }

    private int bonAppetit(List<Integer> bill, int k, int b) {
        bill.set(k, 0);
        int split = bill.stream().mapToInt(Integer::intValue).sum() / 2;
        return (split == b) ? -1 : (b - split);
    }
}
