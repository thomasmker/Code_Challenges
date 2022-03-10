package com.thomashayashi.KangarooShow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number
* line ready to jump in the positive direction (i.e, toward positive infinity).
*
* The first kangaroo starts at location x1 and moves at a rate v1 of meters per jump
* The second kangaroo starts at location x2 and moves at a rate v2 of meters per jump
*
* You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
* If it is possible, return YES, otherwise return NO
*
* Full description: https://www.hackerrank.com/challenges/kangaroo/problem
 */
class KangarooShowTest {

    @Test
    void kangarooWillNotMeetIfFirstIsStandingAndSecondRunning() {
        int initKangaroo1 = 0;
        int initKangaroo2 = 1;
        int speedKangaroo1 = 0;
        int speedKangaroo2 = 1;
        String result = KangarooShow.willTheyMeet(initKangaroo1, speedKangaroo1, initKangaroo2, speedKangaroo2);
        assertEquals("NO", result);
    }

    @Test
    void kangarooWillNotMeetTheyHaveDifferentStartPointsButEqualSpeed() {
        int initKangaroo1 = 1;
        int initKangaroo2 = 0;
        int speedKangaroo1 = 1;
        int speedKangaroo2 = 1;
        String result = KangarooShow.willTheyMeet(initKangaroo1, speedKangaroo1, initKangaroo2, speedKangaroo2);
        assertEquals("NO", result);
    }

    @Test
    void kangarooWillNotMeetWhenKangaroo2ThatIsInFrontIsFaster() {
        int initKangaroo1 = 0;
        int initKangaroo2 = 1;
        int speedKangaroo1 = 1;
        int speedKangaroo2 = 2;
        String result = KangarooShow.willTheyMeet(initKangaroo1, speedKangaroo1, initKangaroo2, speedKangaroo2);
        assertEquals("NO", result);
    }

    @Test
    void kangarooWillMeetWhenTheKangarooBehindCatchesUpWithTheKangarooInFront() {
        int initKangaroo1 = 0;
        int initKangaroo2 = 4;
        int speedKangaroo1 = 3;
        int speedKangaroo2 = 2;
        String result = KangarooShow.willTheyMeet(initKangaroo1, speedKangaroo1, initKangaroo2, speedKangaroo2);
        assertEquals("YES", result);
    }

    @Test
    void kangarooWillNotMeetWhenTheKangarooBehindSurpassesTheOtherKangarooInsteadOfMeeting() {
        int initKangaroo1 = 21;
        int initKangaroo2 = 47;
        int speedKangaroo1 = 6;
        int speedKangaroo2 = 3;
        String result = KangarooShow.willTheyMeet(initKangaroo1, speedKangaroo1, initKangaroo2, speedKangaroo2);
        assertEquals("NO", result);
    }
}
