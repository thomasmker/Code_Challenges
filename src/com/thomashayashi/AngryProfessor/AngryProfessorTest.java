package com.thomashayashi.AngryProfessor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/angry-professor/problem
 */
class AngryProfessorTest {
    @Test
    void checkWillTheClassBeSuspended(){
        assertEquals("NO", angryProfessor(3,Arrays.asList(-2,-1,0,1,2)));
        assertEquals("YES", angryProfessor(3,Arrays.asList(-1,-3,4,2)));
        assertEquals("NO", angryProfessor(2,Arrays.asList(0,-1,2,1)));
    }

    private String angryProfessor(int k, List<Integer> a) {
        int onTimeStudents = (int) a.stream().filter(s -> s <= 0).count();
        return onTimeStudents >= k ? "NO" : "YES";
    }
}
