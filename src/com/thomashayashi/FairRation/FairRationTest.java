package com.thomashayashi.FairRation;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/fair-rations/problem
 */
class FairRationTest {
    @Test
    void checkIndex(){
        assertEquals("NO", fairRations(Arrays.asList(1, 2)));
        assertEquals("4", fairRations(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private String fairRations(List<Integer> B) {
        int lastID = -1;
        int count = 0;

        for(int i = 0; i < B.size(); i++){
            if(B.get(i) % 2 != 0){
                if(lastID == -1)
                    lastID = i;
                else{
                    count += Math.abs(i - lastID)*2;
                    lastID = -1;
                }
            }
        }

        return (lastID == -1) ? String.valueOf(count) : "NO";
    }
}
