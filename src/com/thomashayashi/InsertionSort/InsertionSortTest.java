package com.thomashayashi.InsertionSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {

    @Test
    void checkIndex(){
        assertEquals(Arrays.asList("2 4 4","2 3 4"), insertionSort1(Arrays.asList(2,4,3)));
    }

    private List<String> insertionSort1(List<Integer> arr) {
        List<String> arrayState = new ArrayList<>();

        int temp;
        for (int i = arr.size() - 1; i > 0; i--) {
            temp = arr.get(i);

            if (arr.get(i - 1) > temp) {
                arr.set(i, arr.get(i - 1));
                arrayState.add(getArrayState(arr));
                arr.set(i - 1, temp);
            }
        }
        arrayState.add(getArrayState(arr));
        return arrayState;
    }

    private String getArrayState(List<Integer> arr) {
        return arr.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
