package com.thomashayashi.SaveThePrisoner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/save-the-prisoner/problem
 */
class SaveThePrisonerTest {
    @Test
    void checkPrisoner(){
        assertEquals(1, saveThePrisoner(1,1,1));

        assertEquals(1, saveThePrisoner(2,1,1));
        assertEquals(2, saveThePrisoner(2,2,1));
        assertEquals(1, saveThePrisoner(2,3,1));
        assertEquals(2, saveThePrisoner(2,4,1));
        assertEquals(1, saveThePrisoner(2,5,1));

        assertEquals(2, saveThePrisoner(2,1,2));
        assertEquals(1, saveThePrisoner(2,2,2));
        assertEquals(2, saveThePrisoner(2,3,2));
        assertEquals(1, saveThePrisoner(2,4,2));

        assertEquals(2, saveThePrisoner(5,2,1));
        assertEquals(3, saveThePrisoner(5,2,2));
    }

    private int saveThePrisoner(int prisoners, int candy, int startPosition) {
        //return ((startPosition - 1 + candy - 1) % prisoners) + 1;
        candy = removeCycles(prisoners, candy);
        return getLastPrisoner(prisoners, candy, startPosition);
    }

    private int removeCycles(int prisoners, int candy) {
        if(candy > prisoners) {
            int cycles = candy % prisoners;
            candy = cycles == 0 ? prisoners : cycles;
        }
        return candy;
    }

    private int getLastPrisoner(int prisoners, int candy, int startPosition) {
        int lastPerson = calculateLastPersonShift(candy, startPosition);
        return lastPerson > prisoners ? (lastPerson % prisoners) : lastPerson;
    }

    private int calculateLastPersonShift(int candy, int startPosition) {
        int shift = startPosition == 1 ? 0 : startPosition - 1;
        return candy + shift;
    }
}
