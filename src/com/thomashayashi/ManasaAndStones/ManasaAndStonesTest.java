package com.thomashayashi.ManasaAndStones;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManasaAndStonesTest {
    @Test
    void checkStones(){
        assertEquals(Arrays.asList(2,3,4), stones(3, 1,2));
        assertEquals(Arrays.asList(30,120,210,300), stones(4, 10,100));
    }

    private List<Integer> stones(int n, int a, int b) {
        Set<Integer> finalStone = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int lastStoneNumber = (a * (n - 1 - i)) + (b * i);
            finalStone.add(lastStoneNumber);
        }
        return new ArrayList<>(finalStone);
    }
}
