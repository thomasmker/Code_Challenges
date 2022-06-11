package com.thomashayashi.PermutationPossibilities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationPossibilitiesTest {
    @Test
    void checkPermutations(){
        assertEquals(of(), getAllCombinations(of()));
        assertEquals(of(of(1)), getAllCombinations(of(1)));
        assertEquals(Arrays.asList(List.of(1),List.of(2),Arrays.asList(1,2)), getAllCombinations(Arrays.asList(1,2)));
        assertEquals(Arrays.asList(List.of(1),List.of(2),Arrays.asList(1,2),List.of(3),Arrays.asList(1,3),Arrays.asList(2,3),Arrays.asList(1,2,3)), getAllCombinations(Arrays.asList(1,2,3)));
    }

    private List<List<Integer>> getAllCombinations(List<Integer> elements) {
        List<List<Integer>> combinationList = new ArrayList<>();

        double permutations = Math.pow(2, elements.size());
        for (long i = 1; i < permutations; i++ ) {
            List<Integer> list = new ArrayList<>();
            for ( int j = 0; j < elements.size(); j++ ) {
                if ( (i & (long) Math.pow(2, j)) > 0 ) {
                    list.add(elements.get(j));
                }
            }
            combinationList.add(list);
        }
        return combinationList;
    }
}
