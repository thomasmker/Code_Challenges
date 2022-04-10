package com.thomashayashi.ServiceLane;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/service-lane/problem
 */
class ServiceLaneTest {
    @Test
    void checkMaxSizeCar(){
        assertEquals(Arrays.asList(2,1), serviceLane(Arrays.asList(2,3,2,1), Arrays.asList(Arrays.asList(0,1),Arrays.asList(1,3)) ));
        assertEquals(Arrays.asList(1,2,3,2,1), serviceLane(Arrays.asList(2,3,1,2,3,2,3,3), Arrays.asList(Arrays.asList(0,3),Arrays.asList(4,6),Arrays.asList(6,7),Arrays.asList(3,5),Arrays.asList(0,7)) ));
    }

    private List<Integer> serviceLane(List<Integer> width, List<List<Integer>> cases) {
        List<Integer> maxSize = new ArrayList<>();
        for (List<Integer> singleCase : cases)
            maxSize.add(Collections.min(width.subList(singleCase.get(0), singleCase.get(1) + 1)));
        return maxSize;
    }
}
