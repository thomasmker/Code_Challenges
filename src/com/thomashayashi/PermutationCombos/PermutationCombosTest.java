package com.thomashayashi.PermutationCombos;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationCombosTest {

    @Test
    void checkPermutations(){
        assertEquals(of(), getAllCombinations(of()));
        assertEquals(of(1), getAllCombinations(of(1)));
        assertEquals(Arrays.asList(1,2,3), getAllCombinations(Arrays.asList(1,2)));
        assertEquals(Arrays.asList(1,2,3,4,5,6), getAllCombinations(Arrays.asList(1,2,3)));
    }

    @Test
    void checkTopPermutations(){
        assertEquals(of(6), getTopCombinations(Arrays.asList(1,2,3),1));
        assertEquals(Arrays.asList(6,5), getTopCombinations(Arrays.asList(1,2,3),2));
    }

    @Test
    void checkTopPermutationsSlow(){
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i < 20; i++)
            lst.add(i * - 1);
        assertEquals(of(0), getTopCombinations(lst,1));
    }

    private List<Integer> getAllCombinations(List<Integer> elements) {
        Set<Integer> combinationList = new HashSet<>();

        double permutations = Math.pow(2, elements.size());
        for (long i = 1; i < permutations; i++ ) {
            int sumValue = 0;
            for ( int j = 0; j < elements.size(); j++ ) {
                if ( (i & (long) Math.pow(2, j)) > 0 ) {
                    sumValue += elements.get(j);
                }
            }
            combinationList.add(sumValue);
        }
        return new ArrayList<>(combinationList);
    }

    private List<Integer> getTopCombinations(List<Integer> elements, int n) {
        List<Integer> combinations = getAllCombinations(elements);
        combinations.sort(Collections.reverseOrder());
        return combinations.subList(0, n);
    }


}
