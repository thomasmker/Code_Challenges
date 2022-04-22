package com.thomashayashi.FindMedian;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianTest {
    @Test
    void checkMedian(){
        assertEquals(1, findMedian(Arrays.asList(0,1,2)));
        assertEquals(1, findMedian(Arrays.asList(2,0,1)));
        assertEquals(3, findMedian(Arrays.asList(4,5,2,1,3)));
    }

    private int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        int median = (int)Math.floor((double)arr.size() / 2);
        return arr.get(median);
    }
}
