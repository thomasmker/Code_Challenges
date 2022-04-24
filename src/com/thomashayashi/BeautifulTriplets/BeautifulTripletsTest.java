package com.thomashayashi.BeautifulTriplets;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/beautiful-triplets/problem
 */
class BeautifulTripletsTest {

    @Test
    void checkTriplets(){
        assertEquals(0, beautifulTriplets(2,Arrays.asList(1,1)));
        assertEquals(3, beautifulTriplets(3,Arrays.asList(1,2,4,5,7,8,10)));
        assertEquals(2, beautifulTriplets(3,Arrays.asList(1,6,7,7,8,10,12,13,14,19)));
    }

    private int beautifulTriplets(int d, List<Integer> arr) {
        int countTriplets = 0;

        HashMap<Integer,Integer> uniqueList = new HashMap<>();
        for(Integer num : arr) {
            uniqueList.put(num, uniqueList.containsKey(num) ? uniqueList.get(num) + 1 : 1);
        }

        for(int i = arr.size() - 1; i >= 1; i--) {
            int twin = arr.get(i) - d;
            if(uniqueList.containsKey(twin) && uniqueList.containsKey(twin - d))
                countTriplets += uniqueList.get(twin - d);
        }

        return countTriplets;
    }
}
