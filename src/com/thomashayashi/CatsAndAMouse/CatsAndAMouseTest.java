package com.thomashayashi.CatsAndAMouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 */
class CatsAndAMouseTest {
    @Test
    void checkCats(){
        assertEquals("Cat A", catAndMouse(2,1,3));
        assertEquals("Cat B", catAndMouse(1,2,3));
        assertEquals("Mouse C", catAndMouse(1,3,2));
    }

    private String catAndMouse(int x, int y, int z) {
        int distanceCatA = Math.abs(x - z);
        int distanceCatB = Math.abs(y - z);

        if(distanceCatA == distanceCatB)
            return "Mouse C";
        else if(distanceCatA > distanceCatB)
            return "Cat B";
        return "Cat A";
    }
}
