package com.thomashayashi.BitManipulationCountingBits;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/counting-bits/
 */
class BitManipulationCountingBitsTest {

    @Test
    void checkUniqueIntegerBitManipulation(){
        assertEquals(Arrays.asList(0,1,1), countBits(2));
        assertEquals(Arrays.asList(0,1,1,2,1,2), countBits(5));
    }

    private List<Integer> countBits(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int offset = 1;
        for(int i = 1; i <= n; i++) {
            if (offset * 2 == i)
                offset = i;
            ans.add(1 + ans.get(i - offset));
        }
        return ans;
    }
}
