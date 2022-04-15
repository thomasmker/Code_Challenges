package com.thomashayashi.SequenceEquation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/permutation-equation/problem
 */
class SequenceEquationTest {
    @Test
    void checkEquation(){
        assertEquals(Arrays.asList(4,2,5,1,3), permutationEquation(Arrays.asList(5,2,1,3,4)));
        assertEquals(Arrays.asList(2,3,1), permutationEquation(Arrays.asList(2,3,1)));
    }

    private List<Integer> permutationEquation(List<Integer> p) {
        HashMap<Integer, Integer> mapReverse = new HashMap<>();
        for(int i = 0; i < p.size(); i++)
            mapReverse.put(p.get(i), i + 1);

        List<Integer> permuted = new ArrayList<>();
        for(int x = 1; x <= p.size(); x++)
            permuted.add(mapReverse.get(mapReverse.get(x)));

        return permuted;
    }
}
