package com.thomashayashi.IntroChallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/tutorial-intro/problem
 */
class IntroChallengeTest {
    @Test
    void checkIndex(){
        assertEquals(2, introTutorial(3, Arrays.asList(1, 2, 3)));
        assertEquals(1, introTutorial(4, Arrays.asList(1, 4, 5, 7, 9, 12)));
    }

    private int introTutorial(int V, List<Integer> arr) {
        return arr.indexOf(V);
    }
}
