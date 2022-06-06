package com.thomashayashi.InsertionSort2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/insertionsort2/problem
 */
class InsertionSort2Test {
    @Test
    void checkIndex(){
        assertEquals(Arrays.asList("1 4 3 5 6 2","1 3 4 5 6 2","1 3 4 5 6 2","1 3 4 5 6 2","1 2 3 4 5 6"), insertionSort2(Arrays.asList(1,4,3,5,6,2)));
    }

    private List<String> insertionSort2(List<Integer> arr) {
        List<String> arrayState = new ArrayList<>();
        int a, b;
        for(a = 0, b = a + 1; b < arr.size(); a++, b++){
            int temp = arr.get(b);
            int i = a;
            while(i >= 0 && temp < arr.get(i)){
                arr.set(i + 1, arr.get(i));
                i--;
            }
            arr.set(i + 1, temp);
            arrayState.add(getArrayState(arr));
        }
        return arrayState;
    }

    private String getArrayState(List<Integer> arr) {
        return arr.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
