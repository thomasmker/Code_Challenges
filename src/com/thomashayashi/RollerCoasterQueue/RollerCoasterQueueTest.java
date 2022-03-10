package com.thomashayashi.RollerCoasterQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
* It is New Year's Day and people are in line for the Wonderland roller coaster ride.
* Each person wears a sticker indicating their initial position in the queue from 1 to N.
* Any person can bribe the person directly in front of them to swap positions, but they
* still wear their original sticker. One person can bribe at most two others.
*
* Determine the minimum number of bribes that took place to get to a given queue order.
* Print the number of bribes or if anyone has bribed more than two people, print Too chaotic.
*
* Full description: https://www.hackerrank.com/challenges/new-year-chaos/problem
*/
class RollerCoasterQueueTest {

    private RollerCoasterQueue rollerCoasterQueue;

    @BeforeEach
    void setUp() {
        rollerCoasterQueue = new RollerCoasterQueue();
    }

    @Test
    void shouldExpectThatNoBribesWithOnlyOneElement(){
        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(0,numberOfBribes);
    }

    @Test
    void shouldExpectThatNoBribesWereDoneWhenTheNumbersAreInAscendingOrder(){
        List<Integer> queue = Arrays.asList(1,2);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(0,numberOfBribes);
    }

    @Test
    void shouldExpectThatOneBribeWasDoneBecauseAnElementBiggerIsAppearingFirstInTheQueue(){
        List<Integer> queue = Arrays.asList(2,1);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(1,numberOfBribes);
    }

    @Test
    void shouldExpectThatNoBribesWereDoneWhenTheNumbersAreInAscendingOrderWithThreeElements(){
        List<Integer> queue = Arrays.asList(1,2,3);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(0,numberOfBribes);
    }

    @Test
    void shouldExpectThatOneBribeWasDoneBecauseAnElementBiggerIsAppearingFirstInTheQueueButTheRestIsOk(){
        List<Integer> queue = Arrays.asList(2,1,3);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(1,numberOfBribes);
    }

    @Test
    void shouldExpectThatTwoBribesWereDone(){
        List<Integer> queue = Arrays.asList(3,1,2);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(2,numberOfBribes);
    }

    @Test
    void shouldExpectThatThreeBribesWereDone(){
        List<Integer> queue = Arrays.asList(3,2,1);
        int numberOfBribes = rollerCoasterQueue.minimumBribes(queue);
        assertEquals(3,numberOfBribes);
    }

    @Test
    void shouldNotAllowOverTwoBribes(){
        assertThrows(
                RuntimeException.class,
                () -> {
                    List<Integer> queue = Arrays.asList(4,1,2,3);
                    rollerCoasterQueue.minimumBribes(queue);
                }
        );
    }
}
