package com.thomashayashi.CorrectnessInvariant;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/correctness-invariant/problem
 */
class CorrectnessInvariantTest {
    @Test
    void checkInsertionSort(){
        assertEquals(Arrays.asList(1,2,3),insertionSort(Arrays.asList(3,1,2)));
    }

    private List<Integer>  insertionSort(List<Integer> array){
        for(int i = 1; i < array.size(); i++){
            int index = i;
            while (index > 0 && array.get(index) < array.get(index - 1)) {
                int temp = array.get(index);
                array.set(index, array.get(index - 1));
                array.set(index - 1, temp);
                index--;
            }
        }

        return array;
    }
}
