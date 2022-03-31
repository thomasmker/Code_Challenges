package com.thomashayashi.CutTheStick;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */
class CutTheStickTest {
    @Test
    void checkSticks(){
        assertEquals(Arrays.asList(2,1), cutTheSticks(new ArrayList<>(Arrays.asList(1,2))));
        assertEquals(Arrays.asList(6,4,2,1), cutTheSticks(new ArrayList<>(Arrays.asList(5,4,4,2,2,8))));
        assertEquals(Arrays.asList(8,6,4,1), cutTheSticks(new ArrayList<>(Arrays.asList(1,2,3,4,3,3,2,1))));
    }

    private List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> cutSticks = new ArrayList<>();

        Collections.sort(arr);
        do {
            int min = arr.get(0);
            cutSticks.add(arr.size());
            for(int i = arr.size() - 1; i >=0; i--) {
                int cutSize = arr.get(i) - min;
                if(cutSize == 0)
                    arr.remove(i);
                else
                    arr.set(i, cutSize);
            }
        } while(arr.size() != 0);


        return cutSticks;
    }
}
